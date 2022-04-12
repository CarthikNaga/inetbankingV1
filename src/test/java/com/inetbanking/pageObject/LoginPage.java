package com.inetbanking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	
	WebDriver ldriver;
	
	
	 public LoginPage (WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);		
	}

	
	
	@FindBy(name="uid")
	WebElement txtuserName;
	
	@FindBy(name="password")
	WebElement txtpassword;
	
	@FindBy(name="btnLogin")
	WebElement btnLogin;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")	
	WebElement lnkLogout;

	
	//for above elements 
	//below is the action method
	
	public void setUserName(String uname)
	{
		txtuserName.sendKeys(uname);
		
	}
	
	public void setPassword(String pwd)
	{
		txtpassword.sendKeys(pwd);
		
	}
	
	
	public void clcikSubmit()
	{
		btnLogin.click();;
		
	}
	
	
	public void clickLogout()
	{
		lnkLogout.click();
	}
	
	//after action method test cases to be created
	//test contains 3 parts setup method, test case , tear down method
	
}
