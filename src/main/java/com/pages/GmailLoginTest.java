package com.pages;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Test;

import utility.BaseClass;

public class GmailLoginTest extends BaseClass {
	 @Test    
     public void init() throws Exception {    
          GmailHomePage gmailHomePage = new GmailHomePage(driver);    
          GmailLoginPage gmailLoginpage =  gmailHomePage.clickSignInButton();    
          gmailLoginpage.setEmail("misbahulhak44@gmail.com");    
          gmailLoginpage.clickOnNextButton();    
          gmailLoginpage.setPassword("23456@qwe");    
          GmailInboxPage gmailInboxPage=  gmailLoginpage.clickOnNextButton();    
          Assert.assertTrue(gmailInboxPage.gmailHeaderVisibility());    
     }    

}
