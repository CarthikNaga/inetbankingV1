package com.inetbanking.utilites;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

//Listener class used to generate Extent reports
public class ExtentReportingNG {

	protected static ExtentReports extent;

	public static ExtentReports getReportOject() {

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String nowTime = "Test-Report-" + timeStamp + ".html";
		String path = System.getProperty("user.dir") + "\\reports\\" + nowTime;

		// String path = System.getProperty("user.dir") + "\\reports\\report.html";

		ExtentSparkReporter reporter = new ExtentSparkReporter(path);

		reporter.config().setReportName("Web Auto Result");
		reporter.config().setDocumentTitle("Test Results");
		reporter.config().setTheme(Theme.DARK);
		
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Carthik");
		return extent;

	}

}
