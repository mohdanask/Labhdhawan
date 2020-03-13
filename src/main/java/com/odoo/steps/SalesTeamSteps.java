package com.odoo.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.odoo.generic.PageLib;
import com.odoo.pageobjects.SalesTeamPage;

import io.qameta.allure.Step;

public class SalesTeamSteps
{
	WebDriver driver;
	PageLib plib;
	SalesTeamPage stp;
	
	public SalesTeamSteps(WebDriver driver)
	{
		this.driver=driver;
		plib=new PageLib(driver);
		stp=new SalesTeamPage();
	}
	
	@Step("Creating Sales Team by creating new lead and member {0}, {1}, {2}, {3}, {4}")
	public void createSalesTeam(String salesTeamName, String memberName, String memberEmailID, String teamLeadName, String leadEmailID)
	{
		driver.findElement(By.xpath(stp.createBtn)).click();
		driver.findElement(By.xpath(stp.salesTeamtxtBx)).sendKeys(salesTeamName);
		createTeamLead(teamLeadName, leadEmailID);
		addMember(memberName, memberEmailID);
		driver.findElement(By.xpath(stp.saveSalesTeam)).click();
	}
	
	@Step("Adding Member to the Sales Team providing member name: {0} and emailId: {1}")
	public void addMember(String memberName, String memberEmailID)
	{
		driver.findElement(By.xpath(stp.memberAddBtn)).click();
		driver.findElement(By.xpath(stp.memberCreateBtn)).click();
		driver.findElement(By.xpath(stp.memberTxtBx)).sendKeys(memberName);
		driver.findElement(By.xpath(stp.memberEmailTxtBx)).sendKeys(memberEmailID);
		driver.findElement(By.xpath(stp.saveCloseBtn)).click();
	}
	
	@Step("Creating new Lead to the Sales Team providing Lead name: {0} and emailId: {1}")
	public void createTeamLead(String teamLeadName, String leadEmailID)
	{
		driver.findElement(By.xpath(stp.teamLeadTxtBx)).click();
		driver.findElement(By.xpath(stp.createNEditTeamLead)).click();
		driver.findElement(By.xpath(stp.newLeadTxtBx)).sendKeys(teamLeadName);
		driver.findElement(By.xpath(stp.leadEmailTxtBx)).sendKeys(leadEmailID);
		driver.findElement(By.xpath(stp.saveLead)).click();
	}
	
}
