package com.bstackdemo.automation.base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bstackdemo.automation.pages.CartPage;
import com.bstackdemo.automation.pages.LoginPage;
import com.bstackdemo.automation.pages.ProductPage;
import com.bstackdemo.automation.utils.ScreenshotUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
	
	protected static final Logger logger =
			LogManager.getLogger(BaseTest.class);
	
	public static WebDriver driver;
	public  LoginPage lp;
	public static Properties prop;
	 private static final String FILEPATH = "src/test/resources/config.properties";

	    // ============================
	    // Load Properties
	    // ============================
	    public static void loadProperties() {
	        prop = new Properties();

	        try (FileInputStream fis = new FileInputStream(FILEPATH)) {
	            prop.load(fis);
	        } catch (IOException e) {
	            throw new RuntimeException("Failed to load config.properties", e);
	        }
	    }

    //@BeforeTest
    public void launchBrowser() {

        if (prop == null) {
            loadProperties();
        }

        String browser = prop.getProperty("Browser");

        if (browser == null) {
            throw new RuntimeException("Browser not specified in config.properties");
        }

        if (browser.equalsIgnoreCase("chrome")) {
        	logger.info("Launching Chrome Browser");
        	driver = new ChromeDriver();

        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();

        }else if (browser.equalsIgnoreCase("edge")) {
        	driver = new EdgeDriver();
        }else {
            throw new RuntimeException("Only Chrome and Firefox are supported!");
        }

        driver.manage().window().maximize();
        logger.info("Browser launched successfully");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    // ============================
    // Launch URL
    // ============================
   // @BeforeTest
    public void launchURL() {

        if (prop == null) {
            loadProperties();
        }  

        String url = prop.getProperty("URL");

        if (url == null) {
            throw new RuntimeException("URL not specified in config.properties");
        }

        driver.get(url);
        logger.info("Navigated to URL : " + url);
        
    }
    
    
    
 // ============================
    // Screenshot After Each Test
    // ============================
    @AfterMethod
    public void takeScreenshotAfterEachTest(ITestResult result) {

        if (driver == null) return;

        String testName = result.getName();

        switch (result.getStatus()) {
            case ITestResult.FAILURE:
                testName += "_FAILED";
                break;
            case ITestResult.SUCCESS:
                testName += "_PASSED";
                break;
            case ITestResult.SKIP:
                testName += "_SKIPPED";
                break;
        }

        String timestamp = String.valueOf(System.currentTimeMillis());
        testName = testName + "_" + timestamp;

        ScreenshotUtils.captureScreenshot(driver, testName);
    }

    // ============================
    // Close Browser
    // ============================
    @AfterTest
    public void closeBrowser() {

        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}