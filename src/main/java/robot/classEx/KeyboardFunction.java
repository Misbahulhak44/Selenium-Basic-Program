package robot.classEx;

import org.testng.annotations.Test;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

//Robot class in the Java AWT package. It is generally used to simulate real-time keyboard and mouse operations which we do manually.
public class KeyboardFunction {
	WebDriver driver;
	@BeforeSuite
	public void setBrowser( )
	{
		System.setProperty("webdriver.edge.driver", "./driver/msedgedriver.exe");
		driver =new EdgeDriver();
	}
	@Test
	public void KeyEvent() throws AWTException, InterruptedException
	{
		driver.get("http://www.edureka.co");
			driver.manage().window().maximize();
			driver.findElement(By.linkText("Courses")).click();
			Robot robot = new Robot();
			Thread.sleep(4000);
			robot.keyPress(KeyEvent.VK_DOWN);
			Thread.sleep(4000);
			robot.keyPress(KeyEvent.VK_TAB);
			Thread.sleep(4000);
			System.out.println("a");
			robot.keyPress(KeyEvent.VK_TAB);
			Thread.sleep(4000);
			System.out.println("b");
			robot.keyPress(KeyEvent.VK_TAB);
			Thread.sleep(4000);
			System.out.println("c");
			robot.mouseMove(30,100);
			Thread.sleep(4000);
			
			System.out.println("d");
	}
	
	@AfterSuite
	public void quiteDriver()
	{
		driver.quit();
	}

}
