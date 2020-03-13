package com.odoo.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.odoo.generic.PageLib;
import com.odoo.pageobjects.SettingsPage;

public class SettingsSteps 
{
	WebDriver driver;
	PageLib plib;
	SettingsPage sp;
	
	public SettingsSteps(WebDriver driver)
	{
		this.driver=driver;
		plib=new PageLib(driver);
		sp=new SettingsPage();
	}
	
	public void checkLeadCheckbox()
	{
		plib.verifyCheckbox(sp.leadChckBx);
	}
	
	public void saveSettings()
	{
		driver.findElement(By.xpath(sp.saveSettingsBtn)).click();
	}
}
