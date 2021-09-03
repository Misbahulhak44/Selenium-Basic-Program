package handle.Exception;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import utility.BaseClass;

public class NoAlertPresentException extends BaseClass {
	
	  @Test(enabled=false) 
	  public void AlertPopupTest() throws InterruptedException {
	  driver.get("http://omayo.blogspot.com/");
	  driver.findElement(By.xpath("//*[@id=\"HTML42\"]/div[1]/form/input[3]")).
	  click();//click on button to get alert popup Thread.sleep(5000);
	  String abc=driver.switchTo().alert().getText();//get the text of alert popup
	  System.out.println("Text Of Alert Windows is:-"+abc);//print the text
	  driver.switchTo().alert().accept();//switch to alert popup and click on Ok to close 
	  driver.close(); }
	 
	@Test(priority=1)
	public void getAlertException()
	{
		driver.get("http://omayo.blogspot.com/");
		//driver.findElement(By.id("abc")).click();
		driver.switchTo().alert().accept();//here we get NoAlertException
		driver.quit();//this line not be executed bcoz exception will be occure in above line
	}
	@Test
	public void HandledAlertException()
	{
		driver.get("http://omayo.blogspot.com/");
		//here we can handled alert exception by using try and catch
		try {
			WebDriverWait wait = new WebDriverWait(driver, (10));
			wait.until(ExpectedConditions.alertIsPresent());
			try {
			driver.switchTo().alert().accept();
			} catch (Exception e) {
			System.out.println("An exceptional case");
			}
			} catch (Exception e)
		{
			System.out.println("WebDriver couldn’t locate the Alert");
			}
		
		
	}

}
