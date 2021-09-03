package handle.webTable;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class ToHandleWebTableEx {
	WebDriver driver;
  @Test
  public void HandleWebTable() {
	  System.setProperty("webdriver.edge.driver", "./driver/msedgedriver.exe");
		driver=new EdgeDriver();
	  driver.get("https://www.espncricinfo.com/series/icc-world-test-championship-2019-2021-1195334/points-table-standings");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String title=driver.getTitle();
		System.out.println("Title of The Page is="+title);
		
		//find the number of rows 
		List<WebElement> noOfRows=driver.findElements(By.xpath("//*[@class='table table-sm standings-widget-table text-center mb-0 border-bottom']/thead/tr/th"));
		 System.out.println("Headers in table are below:");
	      System.out.println("Total headers found: "+noOfRows.size());
	      for(WebElement header:noOfRows)
	      {
	         System.out.println(header.getText());
	      }
		//Finding number of Columns
		List<WebElement> columnsNumber = driver.findElements(By.xpath("//*[@id=\"main-container\"]/div[1]/div/div[2]/div/div[2]/div/div/div/table/tbody/tr/td"));

		int columnCount = columnsNumber.size();
		System.out.println("No of columns in this table : " + columnCount);
		for(WebElement columnsOfTable:columnsNumber)
		{
			System.out.println(columnsOfTable.getText());
		}
		driver.close();
  }
}
