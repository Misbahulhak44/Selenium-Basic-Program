package handle.webTable;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToHandleWebTable {
	 public static void main(String[] args) 
	   {
	      WebDriver driver;
	      System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	      //When The Checkboxes have an Unique ID
	      driver=new ChromeDriver();
	      driver.manage().window().maximize();
	      driver.get("https://softwaretestingo.blogspot.com/2020/09/static-table.html");
	      driver.manage().timeouts().implicitlyWait(15000, TimeUnit.SECONDS);
	      
	      List <WebElement> allHeadersOfTable= driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr/th"));
	      System.out.println("Headers in table are below:");
	      System.out.println("Total headers found: "+allHeadersOfTable.size());
	      for(WebElement header:allHeadersOfTable)
	      {
	         System.out.println(header.getText());
	      }
	      List <WebElement> columnOfTable=driver.findElements(By.xpath("//*[@id=\"post-body-2550359478821280401\"]/table/tbody/tr/td"));
	      System.out.println("Column in table");
	      System.out.println("Total no of column:" +columnOfTable.size());
	      for(WebElement Column1:columnOfTable)
	      {
	    	  System.out.println(Column1.getText());
	      }
	      driver.close();
	   }
	 

}
