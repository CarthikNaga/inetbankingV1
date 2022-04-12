package com.inetbanking.testCases;


import org.apache.log4j.PropertyConfigurator;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilites.ExtentReportingNG;
import com.inetbanking.utilites.ReadConfig;

public class BaseClass extends ExtentReportingNG{
	
	ReadConfig readconfig = new ReadConfig();
	
	
	public String baseURL=readconfig.getApplicationurl();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	public String texttitle=readconfig.getTexttile();
	public static WebDriver driver;
	public static Logger logger;
	
	
	
	@Parameters ("browser")	
	@BeforeClass
	public void login(String brow) 
	{		
		
			logger=Logger.getLogger("ebanking");
			PropertyConfigurator.configure("log4j.properties");
	
		if(brow.equals("chrome"))
			
		{
			System.setProperty("webdriver.chrome.driver", readconfig.getChromepath());	
			driver =  new ChromeDriver();	
		}
	 else if(brow.equals("firefox"))
	 {
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxpath());	
			driver =  new FirefoxDriver();	
		 
	 }
	 
	 else if(brow.equals("edge"))
	 {
			System.setProperty("webdriver.edge.driver", readconfig.getEdgepath());	
			driver =  new EdgeDriver();	 		 
	 }
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(baseURL);
		driver.manage().window().maximize();
		
	}	
	
	
	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException
	{
		
		TakesScreenshot ts= (TakesScreenshot) driver;		
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destfile=System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destfile));		
		return destfile;
		
	}


	
	@AfterClass
	public void tearDown()	
	{
		driver.quit(); 	
		extent.flush();
		
	}
	

}
