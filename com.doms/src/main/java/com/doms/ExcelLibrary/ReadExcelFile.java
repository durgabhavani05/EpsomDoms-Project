package com.doms.ExcelLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.doms.GenericLibrary.FrameworkConstant;


/**
 * This Class Provides the Reusable Method To Read And Write The Data To The Excel File
 * @author bhavani
 */

public class ReadExcelFile implements FrameworkConstant
{
	public  final  String data = null;
	public  FileInputStream fis = null;
	public  Workbook wb = null;
	public  FileOutputStream fos = null;
	
	public String readSingleData(String sheetname, int row, int cell)
	{
		//1. convert the physical file into java readable file
		
		try {
			fis = new FileInputStream(excelpath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//2. create the workbook using WorkBookFactory
		try
		{
			wb = WorkbookFactory.create(fis);
		}catch (EncryptedDocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//3. using workbook get the sheet control
		//4. Using sheet get the row control
		//5. using row get the column control
		//6. using column get the cell data
		
		String data = wb.getSheet(sheetname).getRow(0).getCell(0).getStringCellValue();
		return data;
		
		//wb.getSheet(sheetname).getRow(row).createCell(cell).setCellValue("data we will pass");
		
		//return data;
		
	}
	
	public  void readMultipleData(String Sheetname, int row)
	{
		try {
			fis = new FileInputStream(excelpath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//2. create the workbook using WorkBookFactory
		try
		{
			wb = WorkbookFactory.create(fis);
		}catch (EncryptedDocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//3. using workbook get the sheet control
		//4. Using sheet get the row control
		//5. using row get the column control
		//6. using column get the cell data
		int rowcount = wb.getSheet(Sheetname).getLastRowNum();
		for(int i = 1; i< rowcount; i++)
		{
			String data = wb.getSheet("Sheetname").getRow(1).getCell(1).getStringCellValue();
		}	
	}
	 
	public  void writeData(String sheetname, int row, int cell, String data)
	{
		//1. convert the physical file into java readable file
		
				try {
					fis = new FileInputStream(excelpath);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//2. create the workbook using WorkBookFactory
				try
				{
					wb = WorkbookFactory.create(fis);
				}catch (EncryptedDocumentException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				

				//3. using workbook get the sheet control
				//4. Using sheet get the row control
				//5. using row get the column control
				//6. using column get the cell data
				
				wb.getSheet(sheetname).getRow(row).createCell(cell).setCellValue("data we will pass");
				
				//7. convert java readable file into physical file
				
				try {
					fos = new FileOutputStream(excelpath);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//8. write the data
				
				try {
					wb.write(fos);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//9. close the workbook
				
				try {
					wb.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
	}
}






















