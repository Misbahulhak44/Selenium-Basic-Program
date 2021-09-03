package handle.Exception;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import utility.BaseClass;

public class NoSuchFrameException extends BaseClass{
	@Test
	public void NoSuchFrameExceptionEx() throws Throwable
	{
		driver.get("http://omayo.blogspot.com/");
		//By finding all the web elements using iframe tag
		//driver.switchTo().frame("iframe1");//valid scenario...here we get iFrame
		try {
		driver.switchTo().frame("iframe");//Now i take invalid Iframe id to find get NoSuchIframe Exception
		}
		catch(Exception e)
		{
			System.out.println("NoSuchFrame Exception Handled Successfully");
		}
		Thread.sleep(5000);
		driver.quit();
	}

}
