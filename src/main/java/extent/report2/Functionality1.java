package extent.report2;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class Functionality1 extends BaseTest {
	 WebDriver driver;
@Test
public void functionality1Test1() {
test = extent.createTest("functionality1Test1");
AssertJUnit.assertTrue(1 > 0);
}

@Test
public void functionality1Test2() {
test = extent.createTest("functionality1Test2");
AssertJUnit.assertEquals("xx", "xx");
}

@Test
public void functionality1Test3() {
test = extent.createTest("functionality1Test3");
AssertJUnit.assertEquals("xx", "xx");
}
@Test
public void failedTest()
{
	System.setProperty("webdriver.edge.driver", "./driver/msedgedriver.exe");
	driver=new EdgeDriver();
	driver.get("https://www.google.com");
	AssertJUnit.assertEquals(true, false);
}


@AfterClass
void closeBrowser()
{
 driver.quit();
} 

}
