package com.ui.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import static com.constants.Browser.*;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import com.constants.Env;

import static com.constants.Env.*;
import com.ui.utility.BrowserUtility;
import com.ui.utility.JSONUtility;
import com.ui.utility.LoggerUtility;

import static com.ui.utility.PropertiesUtil.*;

public final  class HomePage extends BrowserUtility  {
	
	Logger logger = LoggerUtility.getLogger(this.getClass());
	private static final By SIGN_IN_LINK_LOCATOR = By.cssSelector(".login");

	
	public HomePage(Browser browserName,boolean isHeadless) {
		
		super(browserName,isHeadless);
		gotoWebsite(JSONUtility.readJson(QA).getURL());
	
	}
 
public HomePage(WebDriver driver) {
		super(driver);
		gotoWebsite(JSONUtility.readJson(QA).getURL());
		
	}

public LoginPage gotoLoginPage()
 {
	  logger.info("Trying to perform click to go to sign in page");
	 clickOn(SIGN_IN_LINK_LOCATOR);
	 LoginPage loginPage = new LoginPage(getDriver());
	 return loginPage;
 }





}
