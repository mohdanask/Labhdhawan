package com.odoo.webutils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.google.common.io.Files;
import com.odoo.generic.Driver;
import com.odoo.generic.GenericLib;

public class OdooListeners implements ITestListener, WebDriverEventListener
{
	public static int executionCount, passCount, failCount, skipCount = 0;
	public static Logger log;
	long startTime;
	String platformName, browserName, headless = null;
	
	public void beforeFindBy(By by, WebElement element, WebDriver driver) 
	{
		log.info("Finding Element with locator: "+by);
	}
	
	public void onException(Throwable t, WebDriver driver) 
	{
		log.fatal(t.getMessage());
	}
	
	public void onStart(ITestContext context) 
	{
		startTime = System.currentTimeMillis();
		System.setProperty("logpath", GenericLib.dir+"/reports/logfiles");
		System.setProperty("htmlpath", GenericLib.dir+"/reports/htmlreports");
		SimpleDateFormat sdf=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		System.setProperty("timestamp", sdf.format(new Date()));
		PropertyConfigurator.configure("log4j.properties");
		log=Logger.getLogger(OdooListeners.class);
		log.info("Suite Execution starts");
		platformName = System.getProperty("platform");
		browserName  = System.getProperty("browser");
		headless  = System.getProperty("headless");
		WebDriver driver = BrowserFactory.launchBrowser(platformName, browserName, headless);
		log.info(browserName+ " launched in "+platformName+
				                       " platform and headless: "+headless);
		Driver.setDriver(driver);
	}
	
	public void onFinish(ITestContext context) 
	{
		RemoteWebDriver rwd= (RemoteWebDriver) Driver.getDriver();
		String browserVersion = rwd.getCapabilities().getVersion();
		long stopTime = System.currentTimeMillis();
		double totalTime = (stopTime-startTime)/1000;
		log.info("Total suite execution time: "+totalTime+"seconds");
		log.info("Suite Execution ends");
		Driver.getDriver().close();
		log.info("Browser Closed");
		log.info("Total scripts executed: "+executionCount);
		log.info("Total scripts passed: "+passCount);
		log.info("Total scripts failed: "+failCount);
		log.info("Total scripts skipped: "+skipCount);
		
		Properties prop=new Properties();
		prop.setProperty("Platform", platformName);
		prop.setProperty("Browser", browserName);
		prop.setProperty("Browser version", browserVersion);
		prop.setProperty("Headless Execution", headless);
		try
		{
			FileOutputStream fos=new FileOutputStream(new File(GenericLib.dir+"/target/allure-results"));
			prop.store(fos, "Environment details");
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void onTestStart(ITestResult result)
	{
		executionCount++;
		log.info(result.getName()+" script execution starts");
	}
	
	public void onTestSuccess(ITestResult result) 
	{
		passCount++;
		log.info(result.getName()+" script is passed");
	}
	
	public void onTestFailure(ITestResult result) 
	{
		failCount++;
		log.error(result.getName()+" script is failed");
		TakesScreenshot ts=(TakesScreenshot) Driver.getDriver();
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		File destFile=new File(GenericLib.dir+"/screenshots/"+
		                                          result.getName()+".png");
		try 
		{
			Files.copy(srcFile, destFile);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		log.info("Screenshot has been taken");
	}
	
	public void onTestSkipped(ITestResult result) 
	{
		skipCount++;
		log.warn(result.getName()+" script is skipped");
	}
	
	
	
	public void beforeAlertAccept(WebDriver driver) {
	}
	public void afterAlertAccept(WebDriver driver) {
	}
	public void afterAlertDismiss(WebDriver driver) {
	}
	public void beforeAlertDismiss(WebDriver driver) {
	}
	public void beforeNavigateTo(String url, WebDriver driver) {
	}
	public void afterNavigateTo(String url, WebDriver driver) {
	}
	public void beforeNavigateBack(WebDriver driver) {
	}
	public void afterNavigateBack(WebDriver driver) {
	}
	public void beforeNavigateForward(WebDriver driver) {
	}
	public void afterNavigateForward(WebDriver driver) {
	}
	public void beforeNavigateRefresh(WebDriver driver) {
	}
	public void afterNavigateRefresh(WebDriver driver) {
	}
	
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
	}
	public void beforeClickOn(WebElement element, WebDriver driver) {
	}
	public void afterClickOn(WebElement element, WebDriver driver) {
	}
	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
	}
	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
	}
	public void beforeScript(String script, WebDriver driver) {
	}
	public void afterScript(String script, WebDriver driver) {
	}
	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
	}
	public void afterSwitchToWindow(String windowName, WebDriver driver) {
	}
	
	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
	}
	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
	}
	public void beforeGetText(WebElement element, WebDriver driver) {
	}
	public void afterGetText(WebElement element, WebDriver driver, String text) {
	}
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}
	public void onTestFailedWithTimeout(ITestResult result) {
	}
	
}
