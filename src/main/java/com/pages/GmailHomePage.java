package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailHomePage {
	WebDriver driver;
	
	@FindBy(linkText="Sign in")
	WebElement signInButton;

	public GmailHomePage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	 // This method is to click on signIn button  
    public GmailLoginPage clickSignInButton() {  
         signInButton.click();  
         return new GmailLoginPage(driver);  
    }  

}
