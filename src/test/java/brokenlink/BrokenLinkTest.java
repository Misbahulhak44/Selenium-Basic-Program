package brokenlink;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utility.BaseClass;

public class BrokenLinkTest extends BaseClass {
  @Test
  public void ToTestBrokenLink() {
	  List<WebElement> list=driver.findElements(By.tagName("a"));
	  System.out.println("Size of link is="+list.size());
	  for(int i=0;i<list.size();i++)
	  {
		  WebElement ele=list.get(i);
		  String url=ele.getAttribute("href");
		  verifyLinkActive(url);
	  }
	  
  }
  public static void verifyLinkActive(String linkUrl)
  
  
  {
	  try {
		URL url=new URL(linkUrl);
		HttpURLConnection connection=(HttpURLConnection)url.openConnection();
		//connection.setConnectTimeout(3000);
		connection.connect();
		
		if(connection.getResponseCode()==200)
		{
			System.out.println(linkUrl+" - "+connection.getResponseMessage());
		}
		if(connection.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND) {
			System.out.println(linkUrl+" - "+connection.getResponseMessage()+" - "+HttpURLConnection.HTTP_NOT_FOUND);
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
}
