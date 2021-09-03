package handle.Exception;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import utility.BaseClass;

public class ElementNotSelectableException extends BaseClass{
	@Test
	public void TestException()
	{
		driver.get("http://omayo.blogspot.com/");
		try {
			WebDriverWait wait = new WebDriverWait(driver, (10));
			wait.until(ExpectedConditions. elementToBeClickable(By.id("swift")));
			try {
			Select dropdown = new Select(driver.findElement(By.id("swift")));
			} catch (WebDriverException e) {
			System.out.println("Exceptional case");
			}
			} catch (Exception e) {
			System.out.println("WebDriver found that this element was not selectable.");
			}
	}
	

}
