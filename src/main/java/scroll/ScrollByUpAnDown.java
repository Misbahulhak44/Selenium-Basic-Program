package scroll;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ScrollByUpAnDown {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
		
		 WebDriver driver = new FirefoxDriver();

		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		 driver.get("https://www.flipkart.com/womens-clothing/pr?sid=2oq,c1r&otracker=hp_nmenu_sub_women_1_View%20all");

		 driver.manage().window().maximize();

		 JavascriptExecutor jsx = (JavascriptExecutor)driver;

		 jsx.executeScript("window.scrollBy(0,4500)", ""); //scroll down

		 Thread.sleep(3000);

		 jsx.executeScript("window.scrollBy(4500,0)", ""); //scroll up

		 }

}
