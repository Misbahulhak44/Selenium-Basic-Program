package handle.webTable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utility.BaseClass;

public class HandleWebTable2 extends BaseClass{
  @Test
  public void handleWebTable() {
	  driver.get("http://km.aifb.kit.edu/sites/webdatacommons/webtables/index.html");
	  List<WebElement> NoOfRows=driver.findElements(By.xpath("//*[@id=\"toccontent\"]/table[2]/tbody/tr[1]/td"));
	  System.out.println("Total No of Rows="+NoOfRows.size());
	  System.out.println("========================================================================");
	  for(WebElement rowsData:NoOfRows)
	  {
		  System.out.println(rowsData.getText());
		 
	  }
	  List<WebElement> SecondRows=driver.findElements(By.xpath("//*[@id=\"toccontent\"]/table[2]/tbody/tr[2]/td"));
	  System.out.println("Total number of 2nd Rows="+SecondRows.size());
	  System.out.println("========================================================================");
	  for(WebElement SecondRow:SecondRows)
	  {
		  System.out.println(SecondRow.getText());
	  }
	  List<WebElement> TotalData=driver.findElements(By.xpath("//*[@id=\"toccontent\"]/table[2]/tbody/tr[2]/following-sibling::tr"));
	  System.out.println("Total number of Data Present="+TotalData.size());
	  System.out.println("========================================================================");
	  for(WebElement totalData:TotalData)
	  {
		  System.out.println(totalData.getText());
	  }
	  //System.out.println("");
  }
}
