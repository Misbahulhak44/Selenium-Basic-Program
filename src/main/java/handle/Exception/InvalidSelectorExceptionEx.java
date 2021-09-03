package handle.Exception;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import utility.BaseClass;

public class InvalidSelectorExceptionEx extends BaseClass {
	@Test
	public void invalidSelectorExcep()
	{
		 driver.get("https://www.gmail.com");
try {
	        WebElement Search = driver.findElement(By.cssSelector("a:contains('About Google')"));  
	        AssertJUnit.fail("Compound class names aren't allowed");
}
catch(InvalidSelectorException e)
{
	System.out.println("Invalid Selector Exception Handled");
	
}
	        driver.close();
	        driver.quit();    
	}
	

}
