package handle.Exception;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utility.BaseClass;

public class StaleElementReferenceExceptionEx extends BaseClass {

	/*
	 * StaleElementReferenceException is thrown when an object for a particular web element was created 
	 * in the program without any problem and however; this element is no longer present in the window.
	 *  This can happen if there was a

            Navigation to another page
            DOM has refreshed
            A frame or window switch
         WebElement firstName = driver.findElement(By.id(“firstname”));

         driver.switchTo().window(Child_Window);

         element.sendKeys("Misbah");

        In the code above, object firstName was created and then the window was switched.
         Then, WebDriver tries to type "Misbah" in the form field.
          In this case StaleElementReferenceException is thrown.
	 */

	@Test
	public void TestEx()
	{
		driver.get("https://www.softwaretestinghelp.com");
		try {
			WebElement firstName = driver.findElement(By.id("firstname"));
			driver.switchTo().window("Child_Window");
			firstName.sendKeys("Misbah");
		}
		catch(NoSuchElementException e)
		{
			System.out.println("Exception Handled");
		}

		driver.quit();

	}
	@Test
	public void HandleStaleException()
	{
		driver.get("https://www.softwaretestinghelp.com");
		try {
			driver.findElement(By.xpath("//*[contains(@id,firstname’)]")).sendKeys("Misbah");
			}
		catch (StaleElementReferenceException e)
		{
			System.out.println("HandleStaleException");
		}
		driver.quit();
	}

}
