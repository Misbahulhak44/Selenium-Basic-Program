package handle.Exception;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import utility.BaseClass;

public class ElementNotVisibleExceptionEx extends BaseClass{
	@Test
	public void Test1()
	{
		driver.get("http://omayo.blogspot.com/");
		try {
			driver.findElement(By.id("submit")).click();
			} 
		catch (ElementNotVisibleException e)
		{
			System.out.println("Element Not Visible exception");
		}
		driver.close();
	}
	@Test
	public void SecondMethod()
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, (10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit")));
			try {
			driver.findElement(By.id("submit")).click();
			} catch (WebDriverException e) {
			System.out.println("Exceptional case");
			}
			} 
		catch (Exception e)
		{
			System.out.println("WebDriver couldn’t find this element visible");
			}
	}

}
