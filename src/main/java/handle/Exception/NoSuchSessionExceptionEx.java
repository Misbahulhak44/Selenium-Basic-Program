package handle.Exception;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import utility.BaseClass;

public class NoSuchSessionExceptionEx extends BaseClass {
	@Test
	public void estEx()
	{
		driver.quit();
		Select dropdown = new Select(driver.findElement(By.id("swift")));
	}

}
