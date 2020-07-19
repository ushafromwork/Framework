package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	XSSFWorkbook wb;
	public ExcelDataProvider() {  //it will load the Excel as soon as class  object is created
		                           //don't have to provide excel path again and again 
		
		File src=new File("./Testdata/TestData.xlsx");
		
		
			
		
		try {
			FileInputStream fis=new FileInputStream (src);
			
			//To read xlsx file we need XSSFWorkbook
			 wb=new XSSFWorkbook(fis);
		} catch (Exception e) {
			  
			System.out.println("unable to read excelfiles"+e.getMessage());
		} 
		 
		
	}
	
	public String getStringData(String sheetname,int row,int column){
		return wb.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();
		
		
	}
	
	public double numericData(String sheetname,int row,int column){
		return wb.getSheet(sheetname).getRow(row).getCell(column).getNumericCellValue();
	}
}
