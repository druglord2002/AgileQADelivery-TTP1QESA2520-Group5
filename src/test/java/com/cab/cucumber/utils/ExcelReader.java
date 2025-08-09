package com.cab.cucumber.utils;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	static String filePath = null;
	static FileInputStream file;
	static XSSFWorkbook wb;
	static XSSFSheet sh;
	static XSSFRow row;
	
	static String[] data = new String[10];
	
	public static String[] readData(String fileName, String sheetName, String Rows) throws Exception{
		
			filePath = new File(fileName).getAbsolutePath();
			file = new FileInputStream(filePath);
			wb = new XSSFWorkbook(file);
			sh = wb.getSheet(sheetName);
			row = sh.getRow(Integer.parseInt(Rows));
			
			for(int i = 0; i < 10; i++) {
				XSSFCell cell= row.getCell(i);
				if(cell != null) {
					DataFormatter formatter = new DataFormatter();
					data[i] = formatter.formatCellValue(cell);
				}
			}
			return data;
		
	}
}
