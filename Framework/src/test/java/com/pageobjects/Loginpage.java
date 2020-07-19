package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {

	WebDriver driver;
	
	public Loginpage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='navbar-collapse']/ul/li[1]/a")
	private WebElement loginlink;
	
	@FindBy(name="email")
	private WebElement uname;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(xpath="//*[@id='ui']/div/div/form/div/div[3]")
	private WebElement submit;
	
	public void login(){
		loginlink.click();
	}
	
	public void LogintoApp(String username,String pass) {
		try{
			Thread.sleep(2000);
		}
		catch(InterruptedException e){
		}
		
		uname.sendKeys(username);
		password.sendKeys(pass);
		submit.click();
	}
	
	
	
	
		
	
}
	

