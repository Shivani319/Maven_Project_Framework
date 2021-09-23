package com.crm.autodesk.GenericLibraries;

import java.io.FileInputStream;


import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {
	/*this method will read the data from excel sheet to write row number and cell number
	 * @throws throwable
	 * 
	 */
	public String getExcelData(String SheetName, int rowNum, int cellNum) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstants.excelSheetPath);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sh = workbook.getSheet(SheetName);
		Row row = sh.getRow(rowNum);
		String data = row.getCell(cellNum).getStringCellValue();
		workbook.close();
		
		
		
		
		return data;
		
	}

}
