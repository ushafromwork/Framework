package com.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pageobjects.Loginpage;
import com.utils.BrowserManager;
import com.utils.ExcelDataProvider;
import com.utils.Helper;

public class LogintestCRM extends Base {

	
	
	@Test(priority=1)
	public void loginApp () throws InterruptedException{
		logger= report.createTest("Login to CRM");
		
		
		Loginpage lp=new Loginpage(driver);
		Thread.sleep(2000);
		
		logger.info("Starting Application");
		
		lp.login();
		lp.LogintoApp(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 0));
		Helper.captureScreenshot(driver);
		
		logger.pass("Login success");
		
	}
	
	
}
