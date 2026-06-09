package com.ui.dataproviders;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.ui.pojos.TestData;
import com.ui.pojos.User;
import com.ui.utility.CsvReaderUtility;
import com.ui.utility.ExcelReaderUtility;

public class LoginDataProvider {
	
	@DataProvider(name = "LoginTestDataProvider")
	public Iterator<Object[]> loginDataProvider() throws FileNotFoundException{
	
	Gson gson = new Gson();
	File testdatafile = new File(System.getProperty("user.dir") + "//TestData//logindata.json");
	FileReader fileReader = new FileReader(testdatafile);
	TestData data = gson.fromJson(fileReader,TestData.class);
	List <Object[]>datatoReturn = new ArrayList<Object[]>();
	for(User user:data.getData()) {
		datatoReturn.add(new Object[] {user});
	}
     return datatoReturn.iterator();
}
	
	
	@DataProvider(name = "LoginTestCSVDataProvider")
	public Iterator<User> loginCSVDataProvider()
	{
		return CsvReaderUtility.readCSVFile("logindata.csv");
		
	}

	@DataProvider(name = "LoginTestxlsDataProvider")
	public Iterator<User> loginxlsDataProvider()
	{
		return ExcelReaderUtility.readExcelFile("loginxldata.xlsx");
		
	}


}
