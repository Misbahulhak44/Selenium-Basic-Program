package handle.Exception;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.testng.annotations.Test;

import utility.BaseClass;

public class NoSuchWindowExceptionEx extends BaseClass{
	@Test
	public void ToTestWindowException()
	{
		driver.get("http://omayo.blogspot.com/");
		driver.findElement(By.xpath("//a[text()='Open a popup window']")).click();
	}
	@Test(dependsOnMethods="ToTestWindowException")
	public void SwitchToWindow()
	{
		String windowId=driver.getWindowHandle();
		//driver.switchTo().window(windowId);//here we not get any windows exception
		try {
		driver.switchTo().window("window");//here we get NoSuchWindowException
		}
		catch(NoSuchWindowException e)
		{
			System.out.println("NoSuchWindowException handles successfully");
		}
		//driver.close();//it will close all windows except current windows
		driver.quit();
	}

}
