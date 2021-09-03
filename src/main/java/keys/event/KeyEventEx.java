package keys.event;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import utility.BaseClass;

public class KeyEventEx extends BaseClass{
	
	//Test Scenario: Visit the Browserstack home page and click on the Get Started Free button.
	@BeforeSuite
	public void setBrowser( )
	{
		System.setProperty("webdriver.edge.driver", "./driver/msedgedriver.exe");
		driver =new EdgeDriver();
	}
	
	@Test(priority=0)
	public void KeyEvent()
	{
		
		driver.get("https://www.browserstack.com/");
		Actions action = new Actions(driver); 
		WebElement element = driver.findElement(By.linkText("Get started free"));

		action.moveToElement(element).click();

		//using click action method
	}
	//Test Scenario: Perform Mouse Hover on Live Tab and App Automate Tab on the Browserstack Website.
	@Test(priority=1)
	public void MouseHover() throws InterruptedException
	{
		driver.get("https://www.browserstack.com/");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("scroll(0,3000)");
		Actions ac=new Actions(driver);
		WebElement live= driver.findElement(By. cssSelector("div.product-cards-wrapper--click a[title='Live']"));     
		ac.moveToElement(live).build().perform();
		Thread.sleep(3000);
		WebElement automate= driver.findElement(By.cssSelector("div.product-cards-wrapper--click a[title='App Automate']"));  
		automate.click();

		Thread.sleep(2000);
		
		
	}
	//3. Perform Double Click Action on the Web Element
	//Test Scenario: Perform Double Click Action on Free Trial Button in the Browserstack Home page.
	@Test(priority=2)
	public void DoubleClick()
	{
		driver.get("https://www.browserstack.com/");

		Actions a = new Actions(driver);


		//Double click on element

		WebElement trialaction = driver.findElement(By.xpath("//a[@id='free-trial-link-anchor']"));

		a.doubleClick(trialaction).perform();
	}
	@AfterSuite
	public void quiteDriver()
	{
		driver.quit();
	}

}
