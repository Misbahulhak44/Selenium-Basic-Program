package handle.Exception;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.net.MalformedURLException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import utility.BaseClass;

public class TimeoutExceptionEx extends BaseClass {
	@BeforeMethod
	@BeforeSuite
	public void setUp() throws MalformedURLException {
	
	}
	@Test
	@AfterSuite
	public void testDown() {
	driver.quit();
	}
	@Test
	public void TestEx()
	{
		
		WebDriverWait wait = new WebDriverWait(driver, (30));
		 
		wait.until(driver -> ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete"));
		 
		driver.get("https://www.softwaretestinghelp.com");
		driver.close();
	}

}
