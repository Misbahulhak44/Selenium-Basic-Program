package brokenlink;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class ToFindTotalLinksOnPage {
	WebDriver driver;
	@Test
	public void verifyBrokenLinks()
	
	{
		System.setProperty("webdriver.edge.driver", "./driver/msedgedriver.exe");
		driver=new EdgeDriver();
		driver.get("https://www.wikipedia.org/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Store all the links on webpage in list
		List <WebElement>allLinks=driver.findElements(By.tagName("a"));
		System.out.println("Total No of Links: "+allLinks.size());
		
		for(WebElement link: allLinks)
		{
			System.out.println("Link Text" +link.getAttribute("href"));
		}
		driver.close();
		
	}

}
