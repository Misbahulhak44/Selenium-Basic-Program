package utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	public static WebDriver driver;
	
	@BeforeSuite

	public void setBrowser( )
	{
		System.setProperty("webdriver.edge.driver", "./driver/msedgedriver.exe");
		driver =new EdgeDriver();
		
		//to maximize browser
		driver.manage().window().maximize();
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//to open gmail site
		//driver.get("https://www.google.com/intl/en-GB/gmail/about/#");
		
	}
	@AfterSuite
	public void quiteDriver()
	{
		//driver.quit();
	}
}
