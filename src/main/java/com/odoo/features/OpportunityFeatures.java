package com.odoo.features;

import org.openqa.selenium.WebDriver;

import com.odoo.steps.CommonSteps;
import com.odoo.steps.SalesTeamSteps;
import com.odoo.steps.SettingsSteps;

import io.qameta.allure.Feature;

public class OpportunityFeatures 
{
	CommonSteps cs;
	SalesTeamSteps sts;
	SettingsSteps ss;
	
	public OpportunityFeatures(WebDriver driver)
	{
		cs=new CommonSteps(driver);
		sts=new SalesTeamSteps(driver);
		ss=new SettingsSteps(driver);
	}
	
	@Feature("Convert Lead to Opportunity")
	public void convertLeadToOpportunity(String[] details)
	{
		cs.clickCRM();
		cs.clickConfiguration();
		cs.clickSalesTeam();
		sts.createSalesTeam(details[0], details[1], details[2], details[3], details[4]);
		cs.clickConfiguration();
		cs.clickSettings();
		ss.checkLeadCheckbox();
		ss.saveSettings();
	}
}
