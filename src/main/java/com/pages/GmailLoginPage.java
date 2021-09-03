package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailLoginPage {
	  WebDriver driver;  
      
	     @FindBy(xpath = "//*[@id='identifierId']")  
	     WebElement emailTextBox;  
	    
	     @FindBy(xpath = "//input[@type='password']")  
	     WebElement passwordTextBox;  
	   
	     @FindBy(xpath = "//*[@linkText='Next' or @id='identifierNext']")  
	     WebElement nextButton;  
	     
	   
	     public GmailLoginPage(WebDriver driver) {  
	          this.driver = driver;  
	          PageFactory.initElements(driver, this);  
	     }  
	   
	     // This method is to set Email in the email text box  
	     public void setEmail(String strEmail) {  
	          emailTextBox.sendKeys(strEmail);  
	     }  
	     // This method is to set Password in the password text box  
	     public void setPassword(String strPassword) {  
	          passwordTextBox.sendKeys(strPassword);  
	     }  
	     
	     // This method is to click on Next Button  
	     public GmailInboxPage clickOnNextButton() {  
	          nextButton.click();  
	          return new GmailInboxPage (driver);  
	     }  

}
