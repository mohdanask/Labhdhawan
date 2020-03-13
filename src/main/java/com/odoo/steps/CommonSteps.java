package com.odoo.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.odoo.generic.PageLib;
import com.odoo.pageobjects.BasePage;

import io.qameta.allure.Step;

public class CommonSteps 
{
	WebDriver driver;
	BasePage bp;
	PageLib plib;
	
	public CommonSteps(WebDriver driver)
	{
		this.driver=driver;
		plib=new PageLib(driver);
		bp=new BasePage();
	}
	
	@Step("Verifying Home Page")
	public void verifyHomePage(String expUsername)
	{
		//plib.eWaitForelementPresent(20, bp.usernameMenu);
		String actualUsername = driver.findElement(By.xpath(bp.usernameMenu)).getText();
		Assert.assertEquals(actualUsername, expUsername);
		//plib.eWaitForelementPresent(20, bp.crmMenu);
		Assert.assertTrue(driver.findElement(By.xpath(bp.crmMenu)).isDisplayed());
	}
	
	@Step("Clicking Crm")
	public void clickCRM()
	{
		driver.findElement(By.xpath(bp.crmMenu)).click();
	}
	
	@Step("Clicking Configuration")
	public void clickConfiguration()
	{
		driver.findElement(By.xpath(bp.configurationMenu)).click();
	}
	
	@Step("Clicking SalesTeam")
	public void clickSalesTeam()
	{
		driver.findElement(By.xpath(bp.salesTeamSubMenu)).click();
	}
	
	@Step("Clicking SalesTeam")
	public void clickSettings()
	{
		driver.findElement(By.xpath(bp.settingsSubMenu)).click();
	}
	
	
}
