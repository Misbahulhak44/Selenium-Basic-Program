package brokenlink;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utility.BaseClass;


public class ToFindBrokenLink extends BaseClass{
	@Test
	public void verifyLink() throws IOException
	{
	List <WebElement>links=driver.findElements(By.tagName("a"));
	System.out.println("Total Number OfLink:"+links.size());
	
	//used for loop
	for(int i=0;i<links.size();i++)
	{
		WebElement element=(WebElement) links.get(i);
		//by using href attribute we could get the url of the required link
		String url=element.getAttribute("href");
		
		try {
			URL link=new URL(url);
			//create a coonection using url object
			HttpURLConnection con=(HttpURLConnection)link.openConnection();
			 // Set the timeout for 2 seconds
			   con.setConnectTimeout(2000);
			   // connect using connect method
			con.connect();
			//use getResponseCode() to get the response
			if(con.getResponseCode()>=400)
			{
				System.out.println(url+"-"+"is Broken Link");
			}
			else {
				System.out.println(url+"-"+"is valid Link");
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
}
