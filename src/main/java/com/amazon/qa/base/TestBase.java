package com.amazon.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.amazon.qa.util.TestUtil;

public class TestBase {

	protected static WebDriver driver;
	static Properties prop;
	
	public TestBase() {

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\manish\\eclipse-workspace\\Practiceproject\\src"
					+ "\\main\\java\\com\\amazon\\qa\\config\\Config.properties");
			prop.load(ip);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
		e.printStackTrace();
	}
	}
	
	
	public static void intiallization () {
		String browsername = prop.getProperty("browser");

		if (browsername.equals("chrome")) {
        driver = new ChromeDriver();
		}
		else if(browsername.equals("Firefox")) {
			driver = new FirefoxDriver();
		}
	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.page_load_timeout));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.implicit_wait));
		
		
		driver.get(prop.getProperty("url"));
	}
}
