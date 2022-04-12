package com.inetbanking.testCases;

//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;

//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.inetbanking.pageObject.LoginPage;
public class TC_LoginTest_001 extends BaseClass {

	
	
	@Test
	public void LoginTest()
	{
		
		//driver.get(baseURL);
		logger.info("URL is opened");
		//driver.manage().window().maximize();
		//extent.createTest("loginTest");		

		LoginPage lp =new LoginPage(driver);
		lp.setPassword(password);
		logger.debug("debugged");
		lp.setUserName(username);
		logger.info("users name and password entered");

		lp.clcikSubmit();
		
		
		
		if (driver.getTitle().equals(texttitle))
		{
			Assert.assertTrue(true);	
			logger.info("login test passed");

		}
		else 
		{
			Assert.assertTrue(false);
			logger.info("login test failed");

		}

	}

	
}
