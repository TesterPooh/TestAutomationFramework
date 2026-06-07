package com.ui.test;

import static com.constants.Browser.CHROME;

import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.ui.utility.BrowserUtility;
import com.ui.utility.LambdaTestUtility;
import com.ui.utility.LoggerUtility;

public class TestBase {
 
   
	protected HomePage homePage;
	Logger logger = LoggerUtility.getLogger(this.getClass());
	private boolean isLambdaTest ;

	
	  @Parameters ({"browser","isLambdaTest","isHeadless"})
	@BeforeMethod(description = "load the Homepage of the website")

	public void setUp(
			@Optional("chrome")String browser,
			@Optional("false")boolean isLambdaTest,
			@Optional("true")boolean isHeadless,ITestResult result  ) {
		  
		  
		  this.isLambdaTest = isLambdaTest;
		  
		  
		WebDriver lambdaDriver;
		if (isLambdaTest) {
			lambdaDriver = LambdaTestUtility.intilizeLambdaTestSession(browser, result.getMethod().getMethodName());
			homePage = new HomePage(lambdaDriver);
		} else {
			logger.info("Load Homepage of  the website"); // Running on local machine
			homePage = new HomePage(Browser.valueOf(browser.toUpperCase()), isHeadless);
		}

	}

	public BrowserUtility getInstance() {
		return homePage;
	}

	@AfterMethod(description = "Tear down the browser")
	public void tearDown() {

		if (isLambdaTest) {
			LambdaTestUtility.quitSession();
		} else {

			homePage.quit();
		}
	}

}
