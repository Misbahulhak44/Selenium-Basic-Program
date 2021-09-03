package com.extent.report;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportDemo {
	static ExtentTest test;
	static ExtentReports report;
	public static WebDriver driver;
	@BeforeClass
	public static void startTest()
	{
	report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
	test = report.startTest("ExtentReportDemo");
	}
	@BeforeTest
	public void beforeTest()
	{
		System.setProperty("webdriver.edge.driver", "./driver/msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.co.in");
	}
	@Test
	public void extentReportsDemo()
	{
	
	
	if(driver.getTitle().equals("Google"))
	{
		test.log(LogStatus.INFO, "details of page");
	test.log(LogStatus.PASS, "Navigated to the specified URL");
	}
	else
	{
	test.log(LogStatus.FAIL, "Test Failed");
	}
	}
	@Test
	public void SecondMethod()
	{
		driver.findElement(By.name("q")).sendKeys("cricbuz");
		driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[1]/div[1]/div[3]/div[2]/ul/li[2]/div/div[2]/div[1]/span")).click();
		Actions act=new Actions(driver);
		act.click();
	}
	@AfterTest
	public void close()
	{
		driver.close();
	}
	
	@AfterClass
	public static void endTest()
	{
	report.endTest(test);
	report.flush();
	}
	}