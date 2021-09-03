package radioButton;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RadioButtonExample {
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://courses.letskodeit.com/practice");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement rad=driver.findElement(By.id("bmwradio"));
		boolean enable=rad.isEnabled();
		System.out.println(enable);
		boolean sel=rad.isSelected();
		System.out.println(sel);
		boolean disp=rad.isDisplayed();
		System.out.println(disp);
		rad.click();
		driver.close();
	}

}
