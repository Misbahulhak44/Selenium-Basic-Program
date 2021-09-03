package extent.report2;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class Functionality2 extends BaseTest {
	WebDriver driver;
@Test
public void functionality2Test1() {
test = extent.createTest("functionality2Test1");
AssertJUnit.assertTrue(1 > 0);
}

@Test
public void functionality2Test2() {
test = extent.createTest("functionality2Test2");
AssertJUnit.assertEquals("xx", "xx");
}

@Test
public void functionality2Test3() {
test = extent.createTest("functionality2Test3");
AssertJUnit.assertEquals("xx", "xx");
}

/*
 * @AfterMethod public void captureScreen(ITestResult result) throws IOException
 * { if(result.getStatus()==ITestResult.FAILURE) { TakesScreenshot
 * ts=(TakesScreenshot)driver; File source=ts.getScreenshotAs(OutputType.FILE);
 * // capture screenshot file File target=new
 * File(System.getProperty("user.dir")+"/Screenshots/"+result.getName()+".png");
 * 
 * FileUtils.copyFile(source,target); System.out.println("screenshot captured");
 * }
 * 
 * }
 */

@AfterClass
void closeBrowser()
{
 driver.quit();
} 
}
