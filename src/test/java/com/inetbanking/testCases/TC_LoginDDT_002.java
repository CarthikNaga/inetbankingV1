package com.inetbanking.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObject.LoginPage;
import com.inetbanking.utilites.XLUtils;

public class TC_LoginDDT_002 extends BaseClass {
	
	
	@Test (dataProvider="LoginData")
	public void loginDDT(String User, String pwd) throws InterruptedException

	{
		//driver.get(baseURL);
		logger.info("URL is opened");
		//driver.manage().window().maximize();
		LoginPage lp=new LoginPage(driver); 
		lp.setUserName(User);
		logger.info("usersname provided");
		lp.setPassword(pwd);
		logger.info("password provided");
		lp.clcikSubmit();
		
		Thread.sleep(3000);
		
		if (isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);		
			logger.warn("login failed");

		}
		else 
		{			
			Assert.assertTrue(true);	
			logger.info("login passed");			
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
		
	}
	
	
	
	public boolean isAlertPresent()	
	{		
		
		try {
		driver.switchTo().alert();
		return true;		
	}
	
	catch(NoAlertPresentException e)	
	{		
		return false;
		}
	}	
	
	
	
	
	
	
	
	
	@DataProvider (name="LoginData")
	String[][] getData() throws IOException
	{
		String path = System.getProperty("user.dir")+"/src\\test\\java\\com\\inetbanking\\testData\\testdata.xlsx";
		
		
		int rownumber = XLUtils.getRowCount(path, "Sheet1");
		int cocount =XLUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata[][]= new String [rownumber][cocount];
		
				
				
		for (int i=1;i<=rownumber;i++)			
		{			
			for (int j=0;j<cocount;j++)				
			{				
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);				
			}			
		}				
			return 	logindata;
	}	

	
	
	
	
}
