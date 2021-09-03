package getWindowHandle;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
  We get the ElementNotInteractableException in Selenium if an element is available in DOM but not in a condition to be interacted. 
  Some of the reasons for this exception are −

There may be a covering of another element on the element with which we want to interact with.
 This overspread of an element over the other can be temporary or permanent. To resolve a temporary overspread, 
 we can wait for an expected condition for the element.

We can wait for the expected condition of invisibilityOfElementLocated for the overlay element.
 Or, wait for the expected condition of elementToBeClickable for the element with which we want to interact.
  
 */

public class ElementNotInteractableException {
	
	 public static void main(String[] args) {
	      System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	      WebDriver driver = new ChromeDriver();
	      //launch URL
	      driver.get("https://login.yahoo.com/");
	      //identify element
	      WebElement l = driver.findElement(By.xpath("//input[@id='persistent']"));
	      
	      //Method1
	      //JavascriptExecutor to click element
	      JavascriptExecutor j = (JavascriptExecutor) driver;
	      j.executeScript("arguments[0].click();", l);
	      boolean t = l.isSelected();
	      if (t) {
	         System.out.println("Checkbox is not checked");
	      }else {
	         System.out.println("Checkbox is checked");
	      }
	      
	      //Method 2
//	      WebDriverWait w= (new WebDriverWait(driver, 7));
//	      w.until(ExpectedConditions.elementToBeClickable (By.xpath("//input[@id='persistent")));
//	      //alternate solution
//	      w.until(ExpectedConditions.invisibilityOfElementLocated(By.id("persistent")));
//	      l.click();
	      
	      driver.quit();
	   }

}
