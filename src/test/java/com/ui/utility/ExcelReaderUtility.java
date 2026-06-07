package com.ui.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.eventusermodel.XSSFReader.XSSFSheetRef;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojos.User;

public class ExcelReaderUtility {
	
	public  static Iterator<User> readExcelFile(String fileName)
	{
		File xlsxFile = new File(System.getProperty("user.dir") + "//TestData//" +  fileName);
		XSSFWorkbook xssfworkbook = null;
		 
		XSSFSheet xssfsheet = null;
		List <User>userList = new ArrayList<User>();
		Iterator <Row> rowiterator;
		Row row;
		Cell firstcell;
		Cell secondcell;
		User user;
		
		try {
			xssfworkbook = new XSSFWorkbook(xlsxFile);
			xssfsheet =  xssfworkbook.getSheet("LoginTestData");
			rowiterator = xssfsheet.iterator();
			rowiterator.next();
			while(rowiterator.hasNext())
			{
				 row = rowiterator.next();
				 firstcell = row.getCell(0);
				 secondcell = row.getCell(1);
				 user  = new User(firstcell.toString(),secondcell.toString());
			     userList.add(user);
			 	xssfworkbook.close();
			}
			
		} catch (InvalidFormatException |IOException e) {
			
			e.printStackTrace();
		} 
		
		
		return userList.iterator();
	
		
	}

}
