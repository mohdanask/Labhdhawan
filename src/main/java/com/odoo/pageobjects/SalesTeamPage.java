package com.odoo.pageobjects;

public class SalesTeamPage 
{
	public String createBtn="//button[contains(text(),'Create')]";
	public String salesTeamtxtBx="//label[text()='Sales Team']/following-sibling::h1/input";
	public String teamLeadTxtBx="//div[@name='user_id']//input";
	public String createNEditTeamLead="//a[text()='Create and Edit...']";
	public String newLeadTxtBx="//label[text()='Name']/following-sibling::h1/input";
	public String leadEmailTxtBx="//label[text()='Email Address']/following-sibling::h2/input";
	public String saveLead="//span[text()='Save']";
	public String memberAddBtn="//a[text()='Team Members']/ancestor::ul/following-sibling::div//button[contains(text(),'Add')]";
	public String memberCreateBtn="//span[text()='Create']/parent::button";
	public String memberTxtBx="//label[text()='Name']/following-sibling::h1/input";
	public String memberEmailTxtBx="//label[text()='Email Address']/following-sibling::h2/input";
	public String saveCloseBtn="//span[text()='Save & Close']/parent::button";
	public String saveSalesTeam="(//button[contains(text(),'Save')])[1]";
}
