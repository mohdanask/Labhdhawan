package com.odoo.scripts;

import org.testng.annotations.Test;

import com.odoo.generic.ExcelLib;
import com.odoo.generic.GenericLib;

public class CreateOpportunityTest extends BaseAbstractTest
{
	@Test
	public void convertLeadToOpportunity()
	{
		ExcelLib elib=new ExcelLib(GenericLib.dir+"/testdata/Odoodata.xlsx");
		String[] data = elib.readData("", "Sheet1");
		lf.validLogin(data[1], data[2]);
		
		String[] details=null;
		for (int i = 3; i < data.length; i++) 
		{
			details=new String[data.length-3];
			details[i-3]=data[i];
		}
		
		of.convertLeadToOpportunity(details);
		
	}
	
	
	
}
