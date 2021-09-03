package handle.Exception;

import org.testng.annotations.Test;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import utility.BaseClass;

public class NoSuchElementExceptionEx extends BaseClass{
	@Test(priority=0)
	public void NoSuchElementExceptionDemo()
	{
		driver.get("https://www.softwaretestinghelp.com/exception-handling-framework-selenium-tutorial-19/");
		try {
		WebElement ele=driver.findElement(By.id("content"));
		System.out.println("Tag Name of Locator="+ele.getTagName());
		}
		catch(Exception e)
		{
			System.out.println("Element not found");
		}
		
	}
	@Test(priority=1)
	public void HandleNoSuchException() throws TimeoutException
	{
		driver.get("https://www.softwaretestinghelp.com/exception-handling-framework-selenium-tutorial-19/");
		try {
		WebDriverWait wait=new WebDriverWait(driver,(5));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("content1")));
		 
			driver.findElement(By.id("content1"));
		}
		catch(WebDriverException e)
		{
			System.out.println("Element could not found in specified timeout ");
		}

	}
}
