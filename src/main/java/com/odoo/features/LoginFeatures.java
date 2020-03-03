package com.odoo.features;

import org.openqa.selenium.WebDriver;

import com.odoo.steps.CommonSteps;
import com.odoo.steps.LoginSteps;

import io.qameta.allure.Story;

public class LoginFeatures 
{
	LoginSteps ls;
	CommonSteps cs;
	
	public LoginFeatures(WebDriver driver)
	{
		ls=new LoginSteps(driver);
		cs=new CommonSteps(driver);
	}
	
	@Story("Performing login using credentials {0} and {1}")
	public void validLogin(String username, String password)
	{
		ls.enterUsername(username);
		ls.enterPassword(password);
		ls.clickLoginBtn();
		cs.verifyHomePage(username);
	}
	
}
