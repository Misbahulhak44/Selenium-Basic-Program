package radioButton;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class MultipleSelectEx {

	public static void main(String[] args) throws InterruptedException {


		System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://courses.letskodeit.com/practice");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement mulSel=driver.findElement(By.id("multiple-select-example"));
		Select sel=new Select(mulSel);
		if(sel.isMultiple())
		{
		sel.selectByIndex(0);
		sel.selectByIndex(1);
		sel.selectByIndex(2);
		
		List<WebElement> getAll=	sel.getAllSelectedOptions();
		//Looping through the options and printing dropdown options
        System.out.println("The dropdown options are:");
        for(WebElement options: getAll)
            System.out.println(options.getText());
        
		System.out.println(getAll);
		sel.deselectAll();
	
		}
		Thread.sleep(5000);
		driver.close();
	}

}
