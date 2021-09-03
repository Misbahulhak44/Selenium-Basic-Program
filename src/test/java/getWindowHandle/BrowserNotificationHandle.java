package getWindowHandle;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserNotificationHandle {

	  public static void main(String[] args) throws InterruptedException {
	      System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	      //ChromeOptions object
	      ChromeOptions op = new ChromeOptions();
	      Thread.sleep(5000);
	      //disable notification parameter
	      op.addArguments("--disable-notifications");
	      // configure options parameter to Chrome driver
	      WebDriver driver = new ChromeDriver(op);
	      driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
	      driver.get("https://www.redbus.in/");
	      driver.quit();
	  }
}
