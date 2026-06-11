package com.bstackdemo.automation.tests;

import org.testng.annotations.Test;
import com.bstackdemo.automation.base.BaseTest;
import com.bstackdemo.automation.listners.TestListener;

import com.bstackdemo.automation.pages.LoginPage;
import com.bstackdemo.automation.utils.DataProviders;
import com.bstackdemo.automation.utils.RetryAnalyzer;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)

public class LoginTest extends BaseTest {
	private LoginPage lp;


	@BeforeClass
	public void pageSetUp() {
		
		logger.info("Test Setup Started");

		loadProperties();
		launchBrowser();
		launchURL();

		lp = new LoginPage(driver);
		logger.info("Page initialized");
	}

	@Test(priority = 1)
	public void verifyURL() {
		logger.info("Verify URL Test Started");

		String actURL = lp.getAppURL();
		Assert.assertTrue(actURL.contains("bstack"), "test failed");
		logger.info("Verify URL Test Passed");

	}

	@Test(priority = 2)
	public void validateSignIn() {
		logger.info("Sign In Test Started");
		lp.clickSignIn();
		logger.info("Sign In Clicked");

	}

	@Test(priority = 3)
	// (priority=3, retryAnalyzer = RetryAnalyzer.class)

	public void validLoginTest() {
		logger.info("Valid Login Test Started");

		lp.login(prop.getProperty("userid"), prop.getProperty("pwd"));

		String currentURL = driver.getCurrentUrl();

		Assert.assertTrue(currentURL.contains("bstackdemo"), "test failed");
		 logger.info("Valid Login Test Passed");
	}

	
	  @Test(priority=4, dataProvider = "invalidLoginData", dataProviderClass =
	  DataProviders.class, retryAnalyzer = RetryAnalyzer.class)
	  
	  public void invalidLoginTest(String username, String password) {
	  
	  
	  lp.login(username, password);
	  
	  String currentURL = driver.getCurrentUrl();
	  
	  Assert.assertFalse(currentURL.contains("checkout")); }
	 

	@AfterClass
	public void tearDown() {
		logger.info("Closing Browser");
		driver.quit();
		logger.info("Browser Closed");
	}
}