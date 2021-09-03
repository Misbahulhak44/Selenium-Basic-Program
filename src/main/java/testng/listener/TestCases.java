package testng.listener;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ListenerTest.class)
public class TestCases {
public WebDriver driver;

//Test to pass as to verify listeners.
@Test
public void Login() throws Exception
{

	System.setProperty("webdriver.edge.driver", "./driver/msedgedriver.exe");
	WebDriver driver =new EdgeDriver();
driver.get("https://www.edureka.co/");
JavascriptExecutor js = (JavascriptExecutor) driver;
driver.manage().window().maximize();
try {
//WebDriverWait wait=new WebDriverWait(driver,20);
//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='search-input']")));
driver.findElement(By.xpath("//*[@id='search-input']")).sendKeys("Test Automation Engineer Masters Program");
driver.findElement(By.className("typeahead__button")).click();
}
catch(ElementNotInteractableException e)
{
	System.out.println("Element not found");
}
js.executeScript("window.scrollBy(0,500)");
Thread.sleep(3000);
js.executeScript("window.scrollBy(0,700)");
Thread.sleep(4000);
js.executeScript("window.scrollBy(0,700)");
Thread.sleep(4000);
}

//Forcefully failed this test as verify listener.
@Test
public void TestToFail()
{
System.out.println("This method going to fail");
AssertJUnit.assertTrue(false);
}}