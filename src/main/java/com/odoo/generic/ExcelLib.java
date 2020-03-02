package com.odoo.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLib 
{
	String filepath;
	
	public ExcelLib(String filepath)
	{
		this.filepath=filepath;
	}
	
	public String[] readData(String testcaseID, String sheetName)
	{
		String[] value=null;
		
		try
		{
			FileInputStream fis=new FileInputStream(new File(filepath));
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			int rowCount = sh.getLastRowNum();
			for (int i = 1; i <= rowCount; i++) 
			{
				Row rw = sh.getRow(i);
				if (rw.getCell(0).toString().equalsIgnoreCase(testcaseID)) 
				{
					int cellCount = rw.getLastCellNum();
					value=new String[cellCount];
					for (int j = 0; j < cellCount; j++) 
					{
						Cell cl = rw.getCell(j);
						switch (cl.getCellType()) 
						{
						case STRING:
							value[j] = cl.getStringCellValue();
							break;
							
						case NUMERIC:
							if (DateUtil.isCellDateFormatted(cl)) 
							{
								SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
								value[j] = sdf.format(cl.getDateCellValue());
							}
							else
							{
								long numValue = (long) cl.getNumericCellValue();
								value[j]=""+numValue;
							}
							break;
							
						case BOOLEAN:
							value[j] = ""+cl.getBooleanCellValue();
							break;
							
						default:
							break;
						}//end of switch
					}//end of cell forLoop
					
					break;
				}//end of if
			}//end of row forLoop
		}
		catch(EncryptedDocumentException | IOException e)
		{
			e.printStackTrace();
		}
		
		
		return value;
	}
}