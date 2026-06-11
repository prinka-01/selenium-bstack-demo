package com.bstackdemo.automation.tests;

import com.bstackdemo.automation.base.BaseTest;
import com.bstackdemo.automation.listners.TestListener;
import com.bstackdemo.automation.pages.CartPage;
import com.bstackdemo.automation.pages.LoginPage;
import com.bstackdemo.automation.pages.ProductPage;
import com.bstackdemo.automation.utils.WaitUtils;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)

public class CartTest extends BaseTest {
	
	private ProductPage plp;
	private CartPage cart;
    

	@BeforeClass

	public void setUp() {
		
		loadProperties();
		launchBrowser();
		launchURL();
		
		lp = new LoginPage(driver);
		lp.clickSignIn();
		lp.login(prop.getProperty("userid"), prop.getProperty("pwd"));
		
		// wait for product page / dashboard to load
	    new WebDriverWait(driver, Duration.ofSeconds(10))
	            .until(ExpectedConditions.urlContains("bstack"));
   
	    plp = new ProductPage(driver);
	    plp.searchBox();
	    plp.cart();
	    //plp.getCartCount();
	    
	    cart = new CartPage(driver);
	    
	    try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}
	
	  // Validate correct product added
			@Test(priority=1)
			public void ValidateProductTitle() {
		    String actualProduct = plp.getCartProductTitle();

		    Assert.assertTrue(actualProduct.contains("iPhone"), "Incorrect product added to cart");

		    System.out.println("Product added to cart successfully");
		
		}
	
	/*@Test(priority = 1)
    public void validateCartCountAfterAddingProduct() {

        plp.cart(); // add to cart

        Assert.assertEquals(cart.getCartCount(), "1");
   
    }*/
    @Test(priority = 2)
    public void validateTotalAmountDisplayed() {

        String total = cart.getTotalAmount();

        Assert.assertTrue(
                total.length() > 0,
                "Total amount is not displayed"
        );

        System.out.println("Total amount: " + total);
    }

    @Test(priority = 3)
    public void validateRemoveItemFromCart() {

        cart.removeItem();

        Assert.assertEquals(
                cart.getCartCount(),
                "0",
                "Item not removed from cart"
        );
    }
    
    @Test(priority=4)
    public void validateContinueShoppingBtn() {
    	cart.continueShopping();
    }
    
    @Test(priority=5)
    public void ValidateAddAnotherProduct() {
    	plp.addotherProduct();
    	String actualProduct = plp.getCartProductTitle();

	    Assert.assertTrue(actualProduct.contains("iPhone"), "Incorrect product added to cart");

	    System.out.println("Product added to cart successfully");
    }
    
    @Test(priority=6)
    public void validateCheckoutButton() {
    	cart.checkout();
    	
    	/*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.urlContains("checkout"));*/
        
        WaitUtils.waitForUrlContains(driver, "checkout");
    	System.out.println(cart.getAppURL());
    	Assert.assertTrue(cart.getAppURL().contains("checkout"), "Test Failed - Not on checkout page!");
    	System.out.println("Test Passed - Landed on checkout page!");
    
    }
    
    @AfterClass
	public void tearDown() {
		driver.quit();
	}
}