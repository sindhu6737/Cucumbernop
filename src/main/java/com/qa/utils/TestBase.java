
package com.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;



public class TestBase {
	// Define the variables globally, make it Public here so that these can be used in TestBase as well as child classes
	public static WebDriver driver;
	public static Properties prop;
	

	public static WebDriver initializeDriver() throws IOException {
		
		// Read the properties defined in the Config.properties file
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\config\\config.properties");
		prop.load(fis);
		
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);
		if (browserName.contains("chrome")) {
			// This is used to fix Timed out receiving message from renderer : System.setProperty("webdriver.chrome.silentOutput", "true");
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\chromedriver.exe");
		
			driver = new ChromeDriver();

		} 
		else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\geckodriver.exe");
			driver = new FirefoxDriver();
		} 
		else if (browserName == "IE") {
			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		

		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		return driver;
	}
//	public void takeScreenShot(String testCaseName, WebDriver driver) throws IOException {
//		TakesScreenshot scrshot = (TakesScreenshot) driver;
//		File source = scrshot.getScreenshotAs(OutputType.FILE);
//		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
//		//FileUtils.copyFile(source, new File(destinationFile));
//	}

	
}
