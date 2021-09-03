package getWindowHandle.switchTo;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowHandleWithSwitchToMethod {

	WebDriver driver;
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("Before Method");
		System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
	}
	
	//Test Scenario:-Navigate to the Browserstack Home page.
	//This is the parent window.from the parent window lets see how to handle the child windowand the again navigate to the parent windows
	
	//Steps to execute
	/*
	 1.Get the handle of the parent window using the command: String parentWindowHandle = driver.getWindowHandle();
     2.Print the window handle of the parent window.
     3.Find the element on the web page using an ID which is an element locator.
     4.Open multiple child windows.
     5.Iterate through child windows.
     6.Get the handles of all the windows that are currently open using the command: Set<String> allWindowHandles = driver.getWindowHandles(); which returns the set of handles.
     7.Use the SwitchTo command to switch to the desired window and also pass the URL of the web page.
	 
	 */
	@Test(enabled=false)
	public void getWindowHandle() throws InterruptedException
	{
		System.out.println("Test Method Started");
		driver.get("https://www.naukri.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//return the parent window name as a sring
		String parent=driver.getWindowHandle();
		Thread.sleep(2000);
		Set<String>s=driver.getWindowHandles();
		Thread.sleep(2000);
		//iterate using Iterator
		Iterator <String>  I1=s.iterator();
		
		while(I1.hasNext())
		{
			String child_window=I1.next();
			if(!parent.equals(child_window)){
				driver.switchTo().window(child_window);
				Thread.sleep(2000);
				
				System.out.println(driver.switchTo().window(child_window).getTitle());
				Thread.sleep(2000);
			}
		}
		
		//switch to parent windows
		driver.switchTo().window(parent);
		Thread.sleep(2000);
	
	}
	@Test
	public void scrollWithJavascriptExecutor() throws InterruptedException
	{
		driver.get("https://www.browserstack.com/"); 
		String title = driver.getTitle(); System.out.println(title);

		JavascriptExecutor js = (JavascriptExecutor) driver; 
		driver.findElement(By.xpath("//*[@id=\"product-nav\"]/ul/li[3]/a")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//*[@id=\"menu-item-25035\"]/a/span")).click();
		js.executeScript("window.scrollBy(0,40)"); 
		Thread.sleep(2000);
		WebElement link = driver.findElement(By.xpath("//*[@id=\"menu-item-25039\"]/a/span[1]")); 
		Actions newwin = new Actions(driver); 
		newwin.keyDown(Keys.SHIFT).click(link).keyUp(Keys.SHIFT).build().perform(); 
		
		//Thread.sleep(2000); 
		//js.executeScript("window.scrollBy(0,400)"); 
		Thread.sleep(3000); 
		Set<String> windows = driver.getWindowHandles(); 
		System.out.println(windows); 
		System.out.println("a1"); 
		for (String window : windows) 
		{ 
		driver.switchTo().window(window); 
		if (driver.getTitle().contains("Most Reliable App & Cross Browser Testing Platform | Browserstack")) 
		{ 
		System.out.println("a2"); 
		js.executeScript("window.scrollBy(0,1000)"); 
		Thread.sleep(2000);
		System.out.println("b1");
		driver.findElement(By.xpath("//*[@id=\"logo\"]/svg/g/g[1]/path[8]")).click();

		driver.findElement(By.xpath("//a[@id='signupModalButton']")).click(); 
		driver.manage().window().setPosition(new Point(2000, 0)); 
		} 
		} 
		Thread.sleep(3000); 
		Set<String> windows1 = driver.getWindowHandles(); 
		System.out.println(windows1); 
		System.out.println("a3"); 
		for (String window : windows1) 
		{ 
		driver.switchTo().window(window); 
		System.out.println("a4"); 
		js.executeScript("window.scrollBy(0,400)"); 
		}
	}
	@AfterMethod
	public void terminate()
	{
		System.out.println("Close The Browser");
		driver.quit();
	}
}

