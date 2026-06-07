package com.ui.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import com.constants.Browser;

public abstract class BrowserUtility {

	private static ThreadLocal <WebDriver> driver= new ThreadLocal<WebDriver>();

	Logger logger = LoggerUtility.getLogger(this.getClass());
	public WebDriver getDriver() {
		return driver.get();
	}

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);
	}
     
	public BrowserUtility(String browserName)
	{
	if(browserName.equalsIgnoreCase("chrome")){
		driver.set(new ChromeDriver());		
		}
	else if (browserName.equalsIgnoreCase("edge"))
	{
		driver.set(new EdgeDriver());	
	}
	else 
		System.out.println("Invalid Browser Name Please select Chrome or Edge");
	}
	public BrowserUtility(Browser browserName ,  boolean isHeadless)
	{
	if(browserName == Browser.CHROME){
		if(isHeadless)
		{		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=old");
		options.addArguments("--window--size= 1920,1080");
		driver.set(new ChromeDriver(options)); 		
		}
		else {
			driver.set(new ChromeDriver());
			}
		}
	else if (browserName == Browser.EDGE)
	{
		
		if(isHeadless)
		{		EdgeOptions options = new EdgeOptions();
		options.addArguments("--headless=old");
		options.addArguments("--disable-gpu");
		driver.set(new EdgeDriver(options)); 		
		}
		else {
			driver.set(new EdgeDriver());
			}
		
		
	}
	else if (browserName == Browser.SAFARI)
	{
		if(isHeadless)
		{		SafariOptions options = new SafariOptions();
	          
		driver.set(new SafariDriver(options)); 		
		}
		else {
			driver.set( new SafariDriver());
			}
	
		driver.set(new SafariDriver());
	}
	else 
		System.out.println("Invalid Browser Name Plesae select Chrome or Edge");
	}





	public void gotoWebsite(String url) {
		logger.info("launching the qwebsite");
		driver.get().get(url);
		
	}

	public void MaximizeWindow() {
		logger.info("maximizing the browsser window");
		driver.get().manage().window().maximize();
	}

	public void clickOn(By locator) {
		WebElement element = driver.get().findElement(locator);
		element.click();
	}

	public void EnterText(By locator, String textToEnter) {

		WebElement element = driver.get().findElement(locator);
		element.sendKeys(textToEnter);

	}
	public String  getVisibleText(By locator)
	{
		WebElement element = driver.get().findElement(locator);
		return element.getText();
	}
	public String takescreenshot(String name)
	{
		TakesScreenshot takescreenshot = (TakesScreenshot) driver.get();
	File screenshotdata = 	takescreenshot.getScreenshotAs(OutputType.FILE);
	Date date  =new Date();

	String timestamp =new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	String  path = System.getProperty("user.dir") +"/Screenshot/" + name + "_" + timestamp + ".png";
	File Screenshotfile =  new File(path);
	try {
		FileUtils.copyFile(screenshotdata, Screenshotfile);
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	
		return path;
	}
	public static void quit()
	{
		if(driver!= null) {
			driver.get().quit();
		}
	}
}
