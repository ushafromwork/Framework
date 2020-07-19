package com.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;



public class BrowserManager {

	
	
	public static WebDriver startApp(WebDriver driver,String browsername,String url){
		if(browsername.equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
			//System.setProperty("Webdriver.chrome.driver", "./chromedriver.exe");
			 driver= new ChromeDriver();
			 
			 
		}else if(browsername.equalsIgnoreCase("firefox")){
			
			WebDriverManager.firefoxdriver().setup();
			//System.setProperty("Webdriver.gecko.driver", "./geckodriver.exe");
		driver= new FirefoxDriver();
		
		
		}else if(browsername.equalsIgnoreCase("ie")){
			
			WebDriverManager.iedriver().setup();
			//System.setProperty("Webdriver.ie.driver", "./IEDriverServer.exe");
			 driver= new InternetExplorerDriver();
			 
		}else{
			Assert.assertEquals(false, "No browser type sent");
			
		}
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
		Reporter.log("Navigated to browser:"+browsername+"URL:"+url,true);
		
		return driver;
		
	}
	
	
	public static void quitApp(WebDriver driver){
		driver.quit();
	}
}
