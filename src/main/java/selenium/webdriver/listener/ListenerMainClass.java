package selenium.webdriver.listener;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class ListenerMainClass {
	public static void main (String [] args) throws InterruptedException{
		
	
		System.setProperty("webdriver.edge.driver", "./driver/msedgedriver.exe");
		WebDriver driver =new EdgeDriver();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		EventFiringWebDriver eventHandler = new EventFiringWebDriver(driver);
		
		EventCapture eCapture = new EventCapture();
		
		//Registering with EventFiringWebDriver
		//Register method allows to register our implementation of WebDriverEventListner to listen to the WebDriver events
		eventHandler.register(eCapture);
		
		//navigating to the webpage "www.edureka.co"
		eventHandler.navigate().to("https://www.edureka.co/blog/");
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(6000);
		
		eventHandler.findElement(By.linkText("Software Testing")).click();
		Thread.sleep(3000);
		//navigating to the webpage "www.edureka.co/all-courses/"
		eventHandler.navigate().to("https://www.edureka.co/all-courses");
		Thread.sleep(3000);
		//navigating back to the first page
		eventHandler.navigate().back();
		Thread.sleep(3000);
		eventHandler.quit();
		//Unregister allows to detach
		eventHandler.unregister(eCapture);
		System.out.println("End of Listners Class");

}
}