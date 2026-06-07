package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.utility.BrowserUtility;

public class LoginPage extends BrowserUtility{

	 private static final By EMAIL_TEXT_LOCATOR = By.cssSelector("#email");
	 private static final By PASSWORD_TEXT_LOCATOR  = By.cssSelector("#passwd");
	 private static final By SUBMIT_TEXT_LOCATOR = By.cssSelector("#SubmitLogin");
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	public MyAccountPage doLoginWith(String emailAddress,String Password) {
	 EnterText(EMAIL_TEXT_LOCATOR, emailAddress);
	 EnterText(PASSWORD_TEXT_LOCATOR, Password);
	 clickOn(SUBMIT_TEXT_LOCATOR);
	
	 MyAccountPage myAccountPage = new MyAccountPage(getDriver());
	 return myAccountPage;
		
	}
	
}
