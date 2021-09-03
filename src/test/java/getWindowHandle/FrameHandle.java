package getWindowHandle;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameHandle {

	public static void main(String[] args) throws InterruptedException {
	      System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	      WebDriver driver = new ChromeDriver();
	      String url = "https://the-internet.herokuapp.com/frames";
	      driver.get(url);
	      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	      // identify element
	      Thread.sleep(5000);
	      driver.findElement(By.linkText("Nested Frames")).click();
	      Thread.sleep(5000);
	      // switch to frame with frame name and identify inside element
	      driver.switchTo().frame("frame-bottom");
	      Thread.sleep(5000);
	      WebElement l = driver.findElement(By.cssSelector("body"));
	      Thread.sleep(5000);
	      System.out.println("Bottom frame text: " +l.getText());
	      // switch to main page
	      driver.switchTo().defaultContent();
	      Thread.sleep(5000);
	      driver.quit();
}
}
