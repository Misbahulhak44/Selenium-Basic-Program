package robot.classEx;

import org.testng.annotations.Test;
import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

//import com.gargoylesoftware.htmlunit.javascript.host.geo.Coordinates;
 

public class PressEscapeKeyUsingRobot {
	WebDriver driver;
	@BeforeSuite
	public void setBrowser( )
	{
		System.setProperty("webdriver.edge.driver", "./driver/msedgedriver.exe");
		driver =new EdgeDriver();
	}
	@Test(priority=0)
	public void PressEscapeKey() throws AWTException, InterruptedException
	{
		driver.get("https://en.key-test.ru/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//create object of robot class
		Robot robot=new Robot();
		
		//press Escape key on keyboard
		robot.keyPress(KeyEvent.VK_ESCAPE);
		Thread.sleep(2000);
		
		//release the capslock
		robot.keyRelease(KeyEvent.VK_CAPS_LOCK);
		Thread.sleep(2000);
		
		//this will press left mouse button
		robot.mousePress(InputEvent.BUTTON1_MASK);
		Thread.sleep(2000);
		// This will release Left mouse button.
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		Thread.sleep(2000);
		//Point coordinates = driver.findElement(By.id("img_location")).getLocation();
		 
		//robot.mouseMove(coordinates.getX(), coordinates.getY());
	}
	
	@Test(priority=1)
	public void ScrolMouse() throws AWTException, InterruptedException
	{
		driver.get("https://www.stqatools.com");
		 
		// Create object of Robot class
		Robot robot = new Robot();
		 
		// Scroll MouseWheel
		robot.mouseWheel(10);
		Thread.sleep(5000);
	}
	@Test(priority=2)
	public void ScreenCapture() throws AWTException, IOException
	{
		driver.get("https://www.fb.com");
		 
		// Create object of Robot class
		Robot robot = new Robot();
		 
		// Get Screen Size
		java.awt.Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		 
		// Capture ScreenShot
		BufferedImage img = robot.createScreenCapture(new Rectangle(size));
		 
		// Store image into file
		File path = new File("./xcelfile/profile.jpg");
		 
		// Write image path
		ImageIO.write(img, "JPG", path);
	}
	@Test(priority=4)
	public void MouseHover()
	{

		/*
		 * driver.get("https://www.stqatools.com");
		 * 
		 * // Find element using locator and store into WebElement WebElement
		 * elementToHover = driver.findElement(By.id("elementToHover "));
		 * 
		 * // Find element using locator and store into WebElement WebElement
		 * elementToClick = driver.findElement(By.id("elementToClick "));
		 * 
		 * // Create object of Action class Actions action = new Actions(driver);
		 * 
		 * // Perform moveToElement operation using action (object) on element.
		 * action.moveToElement(elementToHover).click(elementToClick).build().perform();
		 */
		// Go to URL
		driver.get("https://www.stqatools.com/");
		 
		// Return The List of all Cookies
		driver.manage().getCookies();
		 
		// Return specific cookie according to name
		driver.manage().getCookieNamed("");
		 
		// Create and add the cookie
		//driver.manage().addCookie(null);
		 
		// Delete specific cookie
		driver.manage().deleteCookie(null);
		 
		// Delete specific cookie according Name
		driver.manage().deleteCookieNamed("");
		 
		// Delete all cookies
		driver.manage().deleteAllCookies();
	}
	@AfterSuite
	public void quiteDriver()
	{
		driver.quit();
	}


}
