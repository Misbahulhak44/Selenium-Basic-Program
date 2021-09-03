package getWindowHandle;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardEventsUsingActions {

	public static void main(String[] args) throws InterruptedException {
		
		//Set system properties for geckodriver This is required since Selenium 3.0 
				System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe"); 
				WebDriver driver=new FirefoxDriver();
       
        //Navigate to the demo site
        driver.get("https://demoqa.com/text-box");
        
        //Create object of the Actions class
        Actions actions = new Actions(driver);
       
        
        // Enter the Full Name
        WebElement fullName = driver.findElement(By.id("userName"));
        fullName.sendKeys("Mr.Peter Haynes");
        Thread.sleep(4000);
        //Enter the Email
        WebElement email=driver.findElement(By.id("userEmail"));
        email.sendKeys("PeterHaynes@toolsqa.com");
        
        Thread.sleep(4000);
        // Enter the Current Address
        WebElement currentAddress=driver.findElement(By.id("currentAddress"));
        
        currentAddress.sendKeys("43 School Lane London EC71 9GO");
        
        Thread.sleep(4000);
        // Select the Current Address using CTRL + A
        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("a");
        Thread.sleep(4000);
        actions.keyUp(Keys.CONTROL);
        actions.build().perform();
        Thread.sleep(4000);
        // Copy the Current Address using CTRL + C
        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("c");
        Thread.sleep(4000);
        actions.keyUp(Keys.CONTROL);
        actions.build().perform();
        Thread.sleep(4000);
        //Press the TAB Key to Switch Focus to Permanent Address
        actions.sendKeys(Keys.TAB);
        actions.build().perform();
        Thread.sleep(4000);
        //Paste the Address in the Permanent Address field using CTRL + V
        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("v");
        Thread.sleep(4000);
        actions.keyUp(Keys.CONTROL);
        actions.build().perform();
        
        Thread.sleep(4000);
        //Compare Text of current Address and Permanent Address
        WebElement permanentAddress=driver.findElement(By.id("permanentAddress"));
        assertEquals(currentAddress.getAttribute("value"),permanentAddress.getAttribute("value"));
        
        
        driver.close();

	}

}