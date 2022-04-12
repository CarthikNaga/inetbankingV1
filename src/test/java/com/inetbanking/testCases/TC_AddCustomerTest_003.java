package com.inetbanking.testCases;
import java.io.IOException;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.testng.annotations.Test;
import com.inetbanking.pageObject.AddCustomerPage;
import com.inetbanking.pageObject.LoginPage;
public class TC_AddCustomerTest_003 extends BaseClass {

	@Test
	public void addNewCustomer() throws InterruptedException, IOException {

		// driver.get(baseURL);
		// driver.manage().window().maximize();
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("usersname provided");
		lp.setPassword(password);
		logger.info("password provided");
		lp.clcikSubmit();
		Thread.sleep(3000);

		AddCustomerPage addcust = new AddCustomerPage(driver);
		addcust.clickAddNewCustomer();
		logger.info("providing cust detailes");

		addcust.custName("Pavan");
		addcust.custgender("male");
		addcust.custdob("10", "15", "1985");
		Thread.sleep(3000);
		addcust.custaddress("INDIA");
		addcust.custcity("HYD");
		addcust.custstate("AP");
		addcust.custpinno("5000074");
		addcust.custtelephoneno("987890091");

		String email = randomestring() + "@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcdefgh");
		addcust.custsubmit();
		Thread.sleep(3000);

		logger.info("validation started");

		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		if (res == true) {
			Assert.assertTrue(true);
			logger.info("Customer added sucessfully");

		} else {
			getScreenShotPath("addnewcustomer", driver);
			logger.info("Test Failed");

			Assert.assertTrue(false);

		}

	}

	public String randomestring() {
		String generatedstirng = RandomStringUtils.randomAlphabetic(5);
		return generatedstirng;

	}

	public String randomeNum() {
		String generatedstirng2 = RandomStringUtils.randomNumeric(4);
		return generatedstirng2;

	}

}
