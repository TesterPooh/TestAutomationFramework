package com.ui.listeners;

import java.util.Properties;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.constants.Env;
import com.ui.utility.JSONUtility;
import com.ui.utility.PropertiesUtil;

public class MyRetryAnalyzer implements IRetryAnalyzer {

	//private  static final int MAX_NUMBER_OF_ATTEMPTS =Integer.parseInt(PropertiesUtil.readProperties(Env.QA, "MAX"));
	private static int current_attempt = 1;
	private  static final int MAX_NUMBER_OF_ATTEMPTS =JSONUtility.readJson(Env.QA).getMAX_NUMBER_OF_ATTEMPTS();

	
	@Override
	public boolean retry(ITestResult result) {
		if(current_attempt <=MAX_NUMBER_OF_ATTEMPTS)
		{   current_attempt++;
			return true;
		}
		return false;
	}

}
