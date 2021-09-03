package brokenlink;

import org.testng.annotations.Test;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class ToTestBrokenLink{
	WebDriver driver;
	@Test
	public void verifyLink() throws IOException
	{
		System.setProperty("webdriver.edge.driver", "./driver/msedgedriver.exe");
		driver=new EdgeDriver();
		
		driver.get("https://madanswer.com/41930/how-do-you-find-broken-links-in-selenium-webdriver");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<WebElement> links=driver.findElements(By.tagName("a"));
		System.out.println("Total No of Links are="+links.size());
		
		for(int i=0;i<links.size();i++)
		{
			WebElement element=links.get(i);
			
			String url=element.getAttribute("href");
			verifyLink(url);
		}
		
		
	}
	public static void verifyLink(String urlLink) throws IOException
	{
		try {
			URL urllinks=new URL(urlLink);
			
			HttpURLConnection con=(HttpURLConnection)urllinks.openConnection();
			con.connect();
			if(con.getResponseCode()== 200)
			{
				System.out.println(urlLink+" - "+con.getResponseMessage());
			}
			else
			{
				System.out.println("Broken Links");
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
