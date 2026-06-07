package com.ui.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterUtility {

	
	private static ExtentReports extentreporter;
	private static ThreadLocal<ExtentTest>  extenttest= new ThreadLocal<ExtentTest>();
	
 public static void setupsparkreporter(String reportName)
 {
	 ExtentSparkReporter extentsparkreporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/"+ reportName);
		extentreporter = new ExtentReports();
		extentreporter.attachReporter(extentsparkreporter);
	 
 }
 public static void createExtentTest(String testName)
 {
	 ExtentTest test = extentreporter.createTest(testName);
	 extenttest.set(test);
	 
 }

public static ExtentTest getTest()
{
	return extenttest.get();
}

public static void flushReport()
{
	extentreporter.flush();
	}
}
