package getWindowHandle;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandleCalender {

	 public static void main(String[] args) throws InterruptedException {
	      System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	      WebDriver driver = new ChromeDriver();
	      String frdate = "20";
	      String todate = "26";
	      driver.get("https://jqueryui.com/datepicker/#date−range");
	      // wait of 4 seconds
	      driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
	      // maximize browser
	      driver.manage().window().maximize();
	      // identify frame and switch to it
	      WebElement e = driver.findElement(By.xpath("//*[@id='content']/iframe"));
	      driver.switchTo().frame(e);
	      // choose from date
	      driver.findElement(By.id("datepicker")).click();
	      Thread.sleep(1000);
	      // choose month from dropdown
	      WebElement m = driver .findElement(By.xpath("//div/select[@class='ui− datepicker−month']"));
	      Select s = new Select(m);
	      s.selectByVisibleText("Jan");
	      Thread.sleep(1000);
	      // select day
	      driver.findElement(By.xpath("//td[not(contains(@class,'ui−datepicker− month'))]/a[text()='"+frdate+"']")).click();
	      Thread.sleep(1000);
	      // choose to date
	      driver.findElement(By.xpath("//input[@id='to']")).click();
	      Thread.sleep(1000);
	      // choose month from dropdown
	      WebElement n = driver
	      .findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]"));
	      Select sel = new Select(n);
	      sel.selectByVisibleText("Feb");
	      Thread.sleep(1000);
	      // select day
	      driver.findElement(By.xpath("//td[not(contains(@class,'ui−datepicker− month'))]/a[text()='"+todate+"']")).click();
	      Thread.sleep(1000);
	   }
}
