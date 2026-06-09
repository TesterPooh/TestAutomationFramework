package com.ui.test;
import static org.testng.Assert.*;

import org.apache.logging.log4j.Logger;

import static com.constants.Env.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.constants.Browser.*;
import com.ui.pages.HomePage;
import com.ui.pojos.User;
import com.ui.utility.LoggerUtility;

@Listeners({com.ui.listeners.TestListner.class})

public class LoginTest extends TestBase{
	


 
	 
 
	@Test
(
	        description = "Verifies valid user is able to login into application", 
	        groups = {"e2e", "sanity"},dataProviderClass = com.ui.dataproviders.LoginDataProvider.class,dataProvider = "LoginTestDataProvider"
	    )
	


	
public void logintest(User user) {

		
	assertEquals (homePage.gotoLoginPage().doLoginWith(user.getEmailaddress(), user.getPassword()).getUserName(),
     "Pooh nemade");	
	
	   
}
	

 @Test ( description =
"Verifies valid user is able to login into application", groups = {"e2e",
 "sanity"},dataProviderClass =
 com.ui.dataproviders.LoginDataProvider.class,dataProvider =
"LoginTestCSVDataProvider" ) public void loginCSVtest(User user) {


 assertEquals (homePage.gotoLoginPage().doLoginWith(user.getEmailaddress(),
user.getPassword()).getUserName(), "Pooh nemade");

 }
 



 @Test ( description =
 "Verifies valid user is able to login into application", groups = {"e2e",
"sanity"},dataProviderClass =
com.ui.dataproviders.LoginDataProvider.class,dataProvider =
 "LoginTestxlsDataProvider", retryAnalyzer =
 com.ui.listeners.MyRetryAnalyzer.class ) public void loginxlstest(User user)
 {  assertEquals (homePage.gotoLoginPage().doLoginWith(user.getEmailaddress(),
 user.getPassword()).getUserName(), "Pooh nemade");
 

 }
	} 
