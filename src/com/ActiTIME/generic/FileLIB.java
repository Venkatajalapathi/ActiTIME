package com.ActiTIME.generic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLIB {
	public String getExcelData(String excelpath, String sheet, int r, int c) throws Throwable
	{
		FileInputStream fis=new FileInputStream(excelpath);
		Workbook wb=WorkbookFactory.create(fis);
		String cellvalue=wb.getSheet(sheet).getRow(r).getCell(c).toString();
		return cellvalue;
	}
	
	public int getRowCount(String excelpath, String sheet) throws Throwable
	{
		FileInputStream fis=new FileInputStream(excelpath);
		Workbook wb=WorkbookFactory.create(fis);
		int rowCount=wb.getSheet(sheet).getLastRowNum();
		return rowCount;
	}
	
	public void setCellData(String excelpath, String sheet, int r, int c, String data) throws Throwable
	{
		FileInputStream fis=new FileInputStream(excelpath);
		Workbook wb=WorkbookFactory.create(fis);
		wb.getSheet(sheet).getRow(r).createCell(c).setCellValue(data);
		
		FileOutputStream fos=new FileOutputStream(excelpath);
		wb.write(fos);
		wb.close();
	}
	
	public String getPropKeyValue(String propPath, String key) throws Throwable
	{
		FileInputStream fis=new FileInputStream(propPath);
		Properties prop=new Properties();
		prop.load(fis);
		String propValue=prop.getProperty(key, "key is incorrect");
		return propValue;
	}
		


}
