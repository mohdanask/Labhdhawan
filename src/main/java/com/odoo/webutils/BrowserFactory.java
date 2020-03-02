package com.odoo.webutils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory
{
	public static WebDriver launchBrowser(String platformName, String browserName, String headless)
	{
		WebDriver driver=null;
		
		if (platformName.equalsIgnoreCase("Windows") || platformName.contains("Windows")) 
		{
			if (browserName.equalsIgnoreCase("chrome")) 
			{
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver(ChromeCapabilities.getChromeSettings(headless));
			}
			else if(browserName.equalsIgnoreCase("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver(FirefoxCapabilities.getFirefoxSettings(headless));
			}
		}
		else if(platformName.equalsIgnoreCase("Linux") || platformName.contains("Ubuntu"))
		{
			if (browserName.equalsIgnoreCase("chrome")) 
			{
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver(ChromeCapabilities.getChromeSettings(headless));
			}
			else if(browserName.equalsIgnoreCase("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver(FirefoxCapabilities.getFirefoxSettings(headless));
			}
			
		}
		else if(platformName.equalsIgnoreCase("mac") || platformName.contains("mac"))
		{
			if (browserName.equalsIgnoreCase("chrome")) 
			{
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver(ChromeCapabilities.getChromeSettings(headless));
			}
			else if(browserName.equalsIgnoreCase("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver(FirefoxCapabilities.getFirefoxSettings(headless));
			}
		}
		
		return driver;
	}
}
