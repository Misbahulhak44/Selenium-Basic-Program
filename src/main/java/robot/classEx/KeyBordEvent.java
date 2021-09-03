package robot.classEx;

import org.testng.annotations.Test;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class KeyBordEvent {
	WebDriver driver;
	@BeforeSuite
	public void setBrowser( )
	{
		System.setProperty("webdriver.edge.driver", "./driver/msedgedriver.exe");
		driver =new EdgeDriver();
	}
	/*
	 Let us automate the following scenario :

step1:-Launch the web browser and launch our practice page https://demoqa.com/keyboard-events/
step2:-Click on ‘Click here to browse’ button
step3:-Press Shift Key
step4:-Enter d to type it as D as the modifier Shift key press
step5:-Release Shift Key
step6:-Enter remaining part of the file name, i.e., 1.txt to display it as D1.txt
step7:-Press Enter key
step8:-Click on the Upload button and close the alert
step9:-Close the browser to end the program
	 */
	
	@Test(priority=0)
	public void KeyboardEvent() throws InterruptedException, AWTException
	{
		driver.get("https://wetransfer.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//this will click on browse button
		WebElement element=driver.findElement(By.xpath("//*[contains(text(),'Or select a folder')]"));
		
		//click on browse button
		element.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		
	}
	@Test(priority=1)
	public void keyEvent() throws FileNotFoundException, AWTException, InterruptedException
	{
		String URL = "https://demoqa.com/keyboard-events/";
		
		//Start Browser
		driver.get(URL);
		
		//maximize browser
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		
		
		//Create object of Robot class
		Robot robot = new Robot();
		//Code to Enter D1.txt 
		//Press Shify key 
		robot.keyPress(KeyEvent.VK_SHIFT);
		//Press d , it gets typed as upper case D as Shift key is pressed
		robot.keyPress(KeyEvent.VK_D);
		//Release SHIFT key to release upper case effect
		robot.keyRelease(KeyEvent.VK_SHIFT);
		robot.keyPress(KeyEvent.VK_1);
		robot.keyPress(KeyEvent.VK_PERIOD);
		robot.keyPress(KeyEvent.VK_T);
		robot.keyPress(KeyEvent.VK_X);
		robot.keyPress(KeyEvent.VK_T);
		
		//Press ENTER to close the popup
        robot.keyPress(KeyEvent.VK_ENTER);  

        //Wait for 1 sec
        Thread.sleep(1000);
			 
		//This is just a verification part, accept alert
       // WebElement ele= driver.findElement(By.id("uploadButton"));
		
		//ele.click();				 
		//WebDriverWait wait = new WebDriverWait(driver, 10);		 
		//Alert myAlert = wait.until(ExpectedConditions.alertIsPresent());	       	 
		//Accept the Alert		 
		//myAlert.accept();

		
	}
	@Test
	public void KeyEvent() throws AWTException
	{
		 driver.get("http://www.facebook.com");
		 
		  // Enter Username
		  driver.findElement(By.id("email")).sendKeys("Selenium@gmail.com");
		 
		  // Enter password
		  driver.findElement(By.id("pass")).sendKeys("mukesh");
		 
		  // Create object of Robot class
		  Robot r=new Robot();
		 
		   // Press Enter
		   r.keyPress(KeyEvent.VK_ENTER);
		 
		   // Release Enter
		   r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	@AfterSuite
	public void quiteDriver()
	{
		driver.quit();
	}

}
