package getWindowHandle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ToolTipDemo {

	
	public static WebDriver driver; 
	
	public static void main(String[] args) { 
	//Set system properties for geckodriver This is required since Selenium 3.0 
	System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe"); 
	driver=new FirefoxDriver();
	//Create a new instance of the Firefox driver driver = new FirefoxDriver(); 
	
	//CASE 1: Using getAttribute 
	// Launch the URL driver.get("https://demoqa.com/tool-tips/");
	driver.get("https://demoqa.com/tool-tips/");
	System.out.println("Tooltip web Page Displayed");

	//Maximise browser window 
	driver.manage().window().maximize();

	// Get element for which we need to find tooltip 
	WebElement ageTextBox = driver.findElement(By.id("toolTipTextField"));

	//Get title attribute value 
	String tooltipText = ageTextBox.getAttribute("title"); 
	
	System.out.println("Retrieved tooltip text as :"+tooltipText); 
	
	//Verification if tooltip text is matching expected value 
	if(tooltipText.equalsIgnoreCase("you hovered over the text field")){ 
		System.out.println("Pass : Tooltip matching expected value");
		}
	else{ 
		System.out.println("Fail : Tooltip NOT matching expected value"); 
	} 
	
	// Close the main window 
	driver.close(); 
} 
}
