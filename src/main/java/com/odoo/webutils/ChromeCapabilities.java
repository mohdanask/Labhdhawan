package com.odoo.webutils;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeCapabilities 
{
	public static ChromeOptions getChromeSettings(String headless)
	{
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setJavascriptEnabled(true);
		
		ChromeOptions options=new ChromeOptions();
		options.setHeadless(Boolean.parseBoolean(headless));
		options.merge(cap);
		
		return options;
	}
}
