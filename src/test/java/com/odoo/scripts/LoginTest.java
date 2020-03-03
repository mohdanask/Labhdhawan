package com.odoo.scripts;

import org.testng.annotations.Test;

import com.odoo.generic.ExcelLib;
import com.odoo.generic.GenericLib;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class LoginTest extends BaseAbstractTest
{
	@Test
	@Severity(SeverityLevel.BLOCKER)
	@Description("Performing valid login")
	public void validLogin()
	{
		String filepath=GenericLib.dir+"/testdata/Odoodata.xlsx";
		ExcelLib elib=new ExcelLib(filepath);
		String[] data = elib.readData("validLogin_ID", "Sheet1");
		lf.login(data[1], data[2]);	
	}
}
