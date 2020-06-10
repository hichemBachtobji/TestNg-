package com.utils;

import java.io.ObjectInputFilter.Config;
import java.util.concurrent.TimeUnit;

import javax.management.RuntimeErrorException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

//	public static WebDriver driver;
//	
//	public static void setUp() {
//		
//		ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);
//		
//		switch(ConfigsReader.getProperty("browser").toLowerCase()) {
//		
//		case "chrome":
//			System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
//			driver=new ChromeDriver();
//			break;
//		case "firefox":
//			System.setProperty("webdriver.gecko.driver", Constants.GECKO_DRIVER_PATH);
//			driver=new FirefoxDriver();
//			break;
//		default:
//			throw new RuntimeException("Browser is not supported");
//		}
//		
//		driver.get(ConfigsReader.getProperty("url"));
//	}
//	
//	public static void tearDown() {
//		if(driver!=null) {
//			driver.quit();
//		}
//	}
	public static WebDriver driver;
	
	@BeforeMethod(alwaysRun= true)
	public static WebDriver setUp() {
		
		ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);
		
		switch(ConfigsReader.getProperty("browser").toLowerCase()) {
		
		case "chrome":
			System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
			driver=new ChromeDriver();
		break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", Constants.GECKO_DRIVER_PATH);
			driver= new FirefoxDriver();
			break;
			default:
				throw new RuntimeException("browser is not supported");
		}
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
		driver.get(ConfigsReader.getProperty("url"));
		
		PageInitializer.initialize();
		
		return driver;
		
		
	
	}
	
	@AfterMethod(alwaysRun= true)
public static void  tearDown() {
	if (driver != null) {
		driver.quit();
	}
}
}
