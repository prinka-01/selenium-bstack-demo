package com.bstackdemo.automation.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.bstackdemo.automation.base.BaseTest;
import com.bstackdemo.automation.listners.TestListener;
import com.bstackdemo.automation.pages.LoginPage;
import com.bstackdemo.automation.pages.ProductPage;

@Listeners(TestListener.class)

public class ProductPageTest extends BaseTest{
	
	private ProductPage plp;

	
	@BeforeClass
	public void setUp() {
		loadProperties();
		launchBrowser();
		launchURL();
		lp = new LoginPage(driver);
		
		lp.clickSignIn();
		lp.login(prop.getProperty("userid"), prop.getProperty("pwd"));
		
		plp = new ProductPage(driver);
	}
	
	@Test(priority=1)
	public void verifyURL() {
		
		String actURL = plp.verifyURL();
		Assert.assertTrue(actURL.contains("signin"),"Test Failed");
		System.out.println("Test Passed");
		System.out.println(actURL);
		
	}
	
	@Test(priority=2)
	public void verifyTitle() {

		String actTitle = plp.verifyTitle();
		Assert.assertTrue(actTitle.contains("StackDemo"),"Test Failed");
		System.out.println("Test Passed");
		
	}
	
	@Test(priority=3)
	public void ValidateAppleFilter() {
		
		plp.checkBox();
		
		try {
	        Thread.sleep(3000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
		
		List<WebElement> productTitles = driver.findElements(By.cssSelector(".shelf-item__title"));
		
		
		
		for (WebElement product:productTitles) {
			String ProductText= product.getText().toLowerCase();
		
		Assert.assertTrue(ProductText.contains("iphone")|| (ProductText.contains("apple")), "non apple product found: "+ ProductText);
	
	}
		
		System.out.println("apple products filtered");
	}
	
	
	@Test(priority=4)
	public void ValidateSearch() {
		plp.searchBox();
		
	}
	
	@Test(priority=5)
	public void ValidateAddToCart() {
		plp.cart();
		plp.isCartDisplayed();
		
		
		Assert.assertEquals(plp.getCartCount(), "1");
		
		Assert.assertTrue(plp.isCartDisplayed(), "Test Failed - Cart is not displayed");
		System.out.println("Test Passed");
	}

	  
		
		@Test(priority=6)
		public void ValidateWishlist() {
			plp.wishlist();
			Assert.assertTrue(plp.isWishlistSelected(), "Test Failed - Wishlist icon not selected");
			System.out.println("Test Passed - Wishlist icon selected");
		}
		
		@AfterClass
		public void tearDown() {
			driver.quit();
		}

}
