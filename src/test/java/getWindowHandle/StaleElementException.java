package getWindowHandle;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleElementException {

	public static void main(String[] args) {
	      System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	      WebDriver driver = new ChromeDriver();
	      
	      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	      driver.get("https://www.tutorialspoint.com/about/about_careers.htm");
	      // identify element
	      WebElement l = driver.findElement(By.id("search-strings"));
	      l.sendKeys("Selenium");
	      //refresh page
	      driver.navigate().refresh();
	      //fix exception with try−catch block
	      try{
	         l.sendKeys("Selenium");
	      }
	      catch(StaleElementReferenceException e){
	         l = driver.findElement(By.id("search-strings"));
	         l.sendKeys("Selenium");
	         //obtain value entered
	         String s= l.getAttribute("value");
	         System.out.println("Value entered is: " +s);
	      }
	      driver.quit();
}
}