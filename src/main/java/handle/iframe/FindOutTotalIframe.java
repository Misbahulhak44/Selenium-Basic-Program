package handle.iframe;

import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FindOutTotalIframe {
	WebDriver driver;
	@BeforeMethod
	public void browserStart()
	{
		System.setProperty("webdriver.edge.driver", "./driver/msedgedriver.exe");
		driver=new EdgeDriver();
	}
@Test(priority=0)
public void ToCheckIframe() throws InterruptedException
{
	System.out.println("----------------------First Test Method Started-----------------");
	driver.get("https://demoqa.com/frames");
	
	driver.manage().window().maximize();
	System.out.println("----------------------Maximize the windows-----------------");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	//By executing a java script
	JavascriptExecutor exe = (JavascriptExecutor) driver;
	Integer numberOfFrames = Integer.parseInt(exe.executeScript("return window.length").toString());
	System.out.println("Number of iframes on the page are " + numberOfFrames);

	//By finding all the web elements using iframe tag
	System.out.println("----------------------total frame present in the iframe -----------------");
	List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
	System.out.println("The total number of iframes are " + iframeElements.size());
	
	System.out.println("----------------------Switch to iframe-----------------");
	driver.switchTo().frame("frame1");
//	WebDriverWait wait=new WebDriverWait(driver,(10));
//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sampleHeading")));
	WebElement frameHeading=driver.findElement(By.id("sampleHeading"));
	String gettext=frameHeading.getText();
	
	Thread.sleep(6000);
	
	System.out.println("Text of the frame="+gettext);
	
	
}
@Test(priority=1)
public void nestedFrameDemo()
{
	System.out.println("----------------------Second Test Method Started-----------------");
	 //Navigate to the demo site
    driver.get("https://demoqa.com/nestedframes");
    
    //Number of Frames on a Page
    int countIframesInPage = driver.findElements(By.tagName("iframe")).size();
    System.out.println("Total Number of Frames on a Page:" + countIframesInPage);
    
    //Locate the frame1 on the webPage
    WebElement frame1=driver.findElement(By.id("frame1"));
    
    //Switch to Frame1
    driver.switchTo().frame(frame1);
    
    //Locate the Element inside the Frame1
    WebElement frame1Element= driver.findElement(By.tagName("body"));
    
    //Get the text for frame1 element
    String frame1Text=frame1Element.getText();
    System.out.println("Frame1 Text is :"+frame1Text);
    
    System.out.println("----------------------Nested Frame details -----------------");
    //Number of Frames on a Frame1
    int countIframesInFrame1 =driver.findElements(By.tagName("iframe")).size();
    System.out.println("Number of iFrames inside the Frame1:" + countIframesInFrame1);
    
    //switch to child frame
    driver.switchTo().frame(0);
    
    int countIframesInFrame2 =driver.findElements(By.tagName("iframe")).size();
    System.out.println("Number of iFrames inside the child Frame2:" + countIframesInFrame2);
    
}
@Test(priority=2)
public void SwicthParentToChild()
{
	driver.get("https://demoqa.com/nestedframes");
    
    //Number of Frames on a Page
    int countIframesInPage =driver. findElements(By. tagName("iframe")). size();
    System.out.println("Number of Frames on a Page:"+countIframesInPage);
    
    //Locate the frame1 on the webPage
    WebElement frame1=driver.findElement(By.id("frame1"));
    
    //Switch to Frame1
    driver.switchTo().frame(frame1);
    
     //Number of Frames on a Frame1
    int countIframesInFrame1 =driver. findElements(By. tagName("iframe")). size();
    System.out.println("Number of Frames inside the Frame1:"+countIframesInFrame1);
    
    //Switch to child frame
    driver.switchTo().frame(0);
    int countIframesInFrame2 =driver. findElements(By. tagName("iframe")). size();
    System.out.println("Number of Frames inside the Frame2:"+countIframesInFrame2);
    
    //Locate the Element inside the Frame1
    WebElement frame1Element= driver.findElement(By.tagName("body"));
   
    //Get the text for frame1 element
    String frame1Text=frame1Element.getText();
    
    //Try to Print the text present inside parent frame
    System.out.println("Frame1 is :"+frame1Text);
    
    
}
@Test(priority=3)
public void ChildToParent()
{
	//Navigate to the demo site
    driver.get("https://demoqa.com/nestedframes");
    
    
    //Locate the frame1 on the webPage
    WebElement frame1=driver.findElement(By.id("frame1"));
    
    //Switch to Frame1
    driver.switchTo().frame(frame1);
    
   
    
    //Swiitch to child frame
    driver.switchTo().frame(0);
    int countIframesInFrame2 =driver. findElements(By. tagName("iframe")). size();
    System.out.println("Number of Frames inside the Frame2:"+countIframesInFrame2);

    //Switch to Parent iFrame
    driver.switchTo().parentFrame();
    
    //Locate the Element inside the Frame1
    WebElement frame1Element= driver.findElement(By.tagName("body"));
    
    //Get the text for frame1 element
    String frame1Text=frame1Element.getText();
    
    //Try to Print the text present inside parent frame
    System.out.println("Frame1 is :"+frame1Text);
}
@Test(priority=4)
public void MainToChild()
{
	System.out.println("=============Main To Child Frame start");
	 //Navigate to URL
    driver.get("https://demoqa.com/nestedframes");
    
    //Locate the webelement page heading
    WebElement pageHeadingElement=driver.findElement(By.xpath("//div[@class='main-header']"));
    
    //Find text of the page heading        
    String pageHeading=pageHeadingElement.getText();
    
    //Print the page heading
    System.out.println("Page Heading is :"+pageHeading);
    
    //Switch to Parent iframe
    WebElement frame1=driver.findElement(By.id("frame1"));
    driver.switchTo().frame(frame1);
    WebElement frame1Element= driver.findElement(By.tagName("body"));
    String frame1Text=frame1Element.getText();
    System.out.println("Frame1 is :"+frame1Text);
    
    //Switch to child frame
    driver.switchTo().frame(0);
    WebElement frame2Element= driver.findElement(By.tagName("p"));
    String frame2Text=frame2Element.getText();
    System.out.println("Frame2 is :"+frame1Text);

    //Try to print the heading of the main page without swithcing
//    WebDriverWait wait = new WebDriverWait(driver, (10));
//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("framesWrapper"));
    WebElement mainPageText=driver.findElement(By.xpath("//*[@id=\"framesWrapper\"]/div[1]"));
    System.out.println(mainPageText);
}
@AfterMethod
public void closeBrowser()
{
	driver.close();
}
}
