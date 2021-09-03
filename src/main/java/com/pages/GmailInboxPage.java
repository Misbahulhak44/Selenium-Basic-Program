package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailInboxPage {
	  WebDriver driver;  
      
	     @FindBy(xpath = "//a[@title='Gmail']")  
	     WebElement gmailHeader; 
	    
	     public GmailInboxPage (WebDriver driver) {  
	          this.driver = driver;  
	          PageFactory.initElements(driver, this);  
	     }  
	   
	     // This method is to verify if gmail header is visible  
	     public Boolean gmailHeaderVisibility() {  
	          return gmailHeader.isSelected();  
	     }  

}
