package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath ="//a[@id = 'nav-logo-sprites']")
	WebElement amazonlogo;
	
	@FindBy(xpath ="//a[text()='Sell']")
	WebElement Sellscreen;
	
	@FindBy(xpath = "//div[@class='has-max-width']//h2[text()='Sell on Amazon']")
	WebElement sellsreenname;
	
	
	// Initializing the page object 
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions :
	public boolean validatesitelogo() {
		return amazonlogo.isDisplayed();
	}
	
    public String validatesellscreen() throws InterruptedException {
    	Thread.sleep(2000);
    	Sellscreen.click();
    	return Sellscreen.getText();
    	
    	
    }
		
	}

