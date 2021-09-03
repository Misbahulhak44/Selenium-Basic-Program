package extentreport;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {

	 @Test
	 void setup()
	 {
	  AssertJUnit.fail();
	 }
	 
	 @Test
	 void loginByEmail()
	 {
	  AssertJUnit.assertTrue(true);
	 }
	 
	 @Test(dependsOnMethods={"setup"})
	 void loginByFacebook()
	 {
	  AssertJUnit.assertTrue(true);
	 }
	 
	}