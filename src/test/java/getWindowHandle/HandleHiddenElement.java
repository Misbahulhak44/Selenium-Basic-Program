package getWindowHandle;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 We can click on an element which is hidden with Selenium webdriver.
  The hidden elements are the ones which are present in the DOM but not visible on the page.
   Mostly the hidden elements are defined by the CSS property style="display:none;".
    In case an element is a part of the form tag, it can be hidden by setting the attribute type to the value hidden.

Selenium by default cannot handle hidden elements and throws ElementNotVisibleException while working with them.
 Javascript Executor is used to handle hidden elements on the page.
  Selenium runs the Javascript commands with the executeScript method. The commands to be run are passed as arguments to the method.

First of all, the getElementById method can be used to identify the element.
 Next to enter text to the field, the value method is used to set value to the field.
 */
public class HandleHiddenElement {

	public static void main(String[] args) {
	      System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	      WebDriver driver = new ChromeDriver();
	      driver.get("https://courses.letskodeit.com/practice");
	      driver.manage().window().maximize();
	      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	      // identify element and click
	      driver.findElement(By.id("hide-textbox")).click();
	      // Javascript executor class with executeScript method
	      JavascriptExecutor j = (JavascriptExecutor) driver;
	      // identify element and set value
	      j.executeScript ("document.getElementById('displayed-text').value='Selenium';");
	      String s = (String) j.executeScript("return document.getElementById('displayed-text').value");
	      System.out.print("Value entered in hidden field: " +s);
	      driver.close();
	}
}
