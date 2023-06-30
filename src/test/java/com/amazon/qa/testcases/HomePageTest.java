package com.amazon.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.HomePage;

public class HomePageTest extends TestBase {
    HomePage homepage;
    
    public HomePageTest() {
    	super();
    }
	
    @BeforeMethod
    public void setup() {
    	intiallization();
    }
	
    
    @Test(priority = 1)
    public void validatesitelogoTest() {
    	try {
			Assert.assertTrue(homepage.validatesitelogo());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @Test (priority = 2)
    public void validatesellscreenname() throws InterruptedException {
    	Assert.assertEquals(homepage.validatesellscreen(),"Sell on Amazon");
    }
    
    @AfterMethod
    public void tearDown() {
    	driver.quit();
    }
    
    
}
