package com.OrangeHRM.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	//1
	public WebDriver driver;
	public Properties prop;
	public Logger logger = LogManager.getLogger(this.getClass());
			
	//2
	@BeforeMethod
	@Parameters("browser")
	public void setup(String br) throws IOException {
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream(".\\resources\\config.properties");
		prop.load(fis);
		
		if (br.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			logger.info("Chrome Browser is launched.....");
		} else if(br.equalsIgnoreCase("edge")){
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			logger.info("Edge Browser is launched.....");
		} else if(br.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			logger.info("Firefox Browser is launched.....");
		}else {
			logger.info("Please pass browser name as chrome / edge / firefox.....");
		}
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		//System.out.println("Orange HRM application is opened!!!!!");
		logger.info("Orange HRM application is opened!!!!!");
	}
	
	//3. Close browser
	@AfterMethod
	public void teardown() {
		driver.quit();
		//System.out.println("Orange HRM application is closed!!!!!");
		logger.info("Orange HRM application is closed!!!!!");
	}
	
	public void capturescreen(WebDriver driver,String testname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"\\screenshots\\"+testname+".png");
		FileUtils.copyFile(source, target);
		logger.info("Screenshot captured successfully");
	}
	
	
}
