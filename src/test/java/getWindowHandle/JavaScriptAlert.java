package getWindowHandle;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JavaScriptAlert {

	 public static void main(String[] args) throws InterruptedException {
	      System.setProperty("webdriver.gecko.driver","./driver/geckodriver.exe");
	      WebDriver driver = new FirefoxDriver();
	      //implicit wait
	      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	      //URL launch
	      driver.get("https://the-internet.herokuapp.com/javascript_alerts");
	      // identify element
	      WebElement a =driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
	      a.click();
	      Thread.sleep(5000);
	      //switch alert
	      Alert al =  driver.switchTo().alert();
	      Thread.sleep(5000);
	      //obtain text
	      String st = al.getText();
	      Thread.sleep(5000);
	      System.out.println("Text is: " + st);
	      //alert dismiss
	      al.dismiss();
	      a.click();
	      //alert accept
	      al.accept();
	      driver.close();
	      
	   }
}
