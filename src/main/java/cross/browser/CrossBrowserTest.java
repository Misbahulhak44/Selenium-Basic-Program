package cross.browser;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTest {
	public WebDriver driver;
	
	//expected header value
	public String headerValue="Applied Selenium";
	
	@Test
	@Parameters("browser")
	
	//the method should accept a string variable
	public void verifyHeaderValue(String BrowserName)
	{
		//check for the browser value and invoke the called browser
		if(BrowserName.equalsIgnoreCase("gecko"))
		{
			System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		if(BrowserName.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", "./driver/msedgedriver.exe");
			driver=new EdgeDriver();
		}
		if(BrowserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
			driver=new FirefoxDriver();
		}
		 //print which browser is started
		System.out.println(BrowserName+ "Started");
		driver.get("http://www.appliedselenium.com/");
		
		//Locate the header value get its text value and store in a string variable
		String actualValue=driver.findElement(By.xpath("//h1[@class='bestwp-site-title']/a[contains(text(),'Applied Selenium')]")).getText();
		((JavascriptExecutor) driver).executeScript("window.scrollBy(5000,5000)");
		//Verify if values are equal. Upon inequality the test would fail
		Assert.assertEquals(headerValue, actualValue);
		
		//print which browser is closed
		System.out.println(BrowserName+"closed");
		driver.quit();
	}

}
