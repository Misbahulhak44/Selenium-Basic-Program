package extentreport;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class LoginTest1 {

	 WebDriver driver;
	 
	 @Test(priority=1)
	 void loginTest() throws InterruptedException
	 {
	  System.setProperty("webdriver.chrome.driver", "./driver//chromedriver.exe");
	  
	  driver = new ChromeDriver();
	  driver.get("http://opensource.demo.orangehrmlive.com");
	  driver.findElement(By.name("txtUsername")).sendKeys("Admin");
	  driver.findElement(By.name("txtPassword")).sendKeys("admin");
	  driver.findElement(By.name("Submit")).click();
	  Thread.sleep(2000);
	  AssertJUnit.assertEquals(driver.getTitle(), "OrangeHRM");
	 }
	 
	 @Test(priority=2)
	 void checkTotalNoOfEmployees()
	 {
	  AssertJUnit.assertTrue(true);
	 }
	 
	 @Test(priority=3,dependsOnMethods={"loginTest"})
	 void checkNoOfEmployeesEnabled()
	 {
	  AssertJUnit.assertTrue(true);
	 }
	 
	 @AfterMethod
	 public void captureScreen(ITestResult result) throws IOException
	 {
	  if(result.getStatus()==ITestResult.FAILURE)
	  {
	   TakesScreenshot ts=(TakesScreenshot)driver;
	   File source=ts.getScreenshotAs(OutputType.FILE); // capture screenshot file
	   File target=new File(System.getProperty("user.dir")+"/Screenshots/"+result.getName()+".png");
	   
	   FileUtils.copyFile(source,target);
	   System.out.println("screenshot captured");
	  }
	   
	 }
	 
	 @AfterClass
	 void closeBrowser()
	 {
	  driver.quit();
	 } 
	 
	}