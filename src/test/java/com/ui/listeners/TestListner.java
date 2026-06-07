package com.ui.listeners;

import java.util.Arrays;

import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ui.test.TestBase;
import com.ui.utility.BrowserUtility;
import com.ui.utility.ExtentReporterUtility;
import com.ui.utility.LoggerUtility;

public class TestListner implements ITestListener {

	Logger logger = LoggerUtility.getLogger(this.getClass());
	ExtentSparkReporter extentsparkreporter;
	ExtentReports extentreporter;
	ExtentTest extenttest;

	@Override
	public void onTestStart(ITestResult result) {
		logger.info(result.getMethod().getMethodName());
		logger.info(result.getMethod().getDescription());
		logger.info(Arrays.toString(result.getMethod().getGroups()));
		ExtentReporterUtility.createExtentTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logger.info(result.getMethod().getMethodName() + "" + "Passed");
		ExtentReporterUtility.getTest().log(Status.PASS, result.getMethod().getMethodName() + "Passed");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		logger.info(result.getMethod().getMethodName() + "" + "Failed");
		logger.error(result.getThrowable().getMessage());
	
		ExtentReporterUtility.getTest().log(Status.FAIL, result.getMethod().getMethodName() + "Failed");
		ExtentReporterUtility.getTest().log(Status.FAIL,result.getThrowable().getMessage());
		Object testclass = result.getInstance();
		BrowserUtility browserutility= ((TestBase)testclass).getInstance();
		String screenshotpath = browserutility.takescreenshot(result.getMethod().getMethodName());
		ExtentReporterUtility.getTest().addScreenCaptureFromPath(screenshotpath);
	}

	@Override
	public void onTestSkipped(ITestResult result) {

		logger.warn(result.getMethod().getMethodName() + "" + "Skipped");
		ExtentReporterUtility.getTest().log(Status.SKIP, result.getMethod().getMethodName() + "Skipped");

	}

	@Override

	public void onStart(ITestContext context) {
		logger.info("TestSuite Started");
		ExtentReporterUtility.setupsparkreporter("report.html");
	}

	@Override
	public void onFinish(ITestContext context) {
		logger.info("TestSuite Finished");
		ExtentReporterUtility.flushReport();

	}
}
