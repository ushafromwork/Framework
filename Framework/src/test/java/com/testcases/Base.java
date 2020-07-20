package com.testcases;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.utils.BrowserManager;
import com.utils.ConfigDataProvider;
import com.utils.ExcelDataProvider;
import com.utils.Helper;

public class Base {

	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;

	@BeforeSuite
	public void setupSuite() {
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();
		ExtentHtmlReporter extent = new ExtentHtmlReporter(
				new File(System.getProperty("user.dir") + "/Reports/FreeCRM_" + Helper.getCurrentDateTime() + ".html"));
		report = new ExtentReports();
		report.attachReporter(extent);

	}
    @Parameters("browser")
	@BeforeClass
	public void setUp() {
		driver = BrowserManager.startApp(driver, config.getBrowser(), config.getqaURL());
		//driver = BrowserManager.startApp(driver, browser, config.getqaURL());
		System.out.println(driver.getTitle());
	}

	@AfterClass
	public void teardown() {
		BrowserManager.quitApp(driver);
	}

	@AfterMethod
	public void tearDownmethod(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {

			logger.fail("Test failed",
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}

		else if (result.getStatus() == ITestResult.SUCCESS) {
			//MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build();

			logger.pass("Test passed",
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}

		else if (result.getStatus() == ITestResult.SKIP) {

			logger.skip("Testcase is  skipped",
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		report.flush();
	}
}
