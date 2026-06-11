package com.bstackdemo.automation.tests;

import com.bstackdemo.automation.base.BaseTest;
import com.bstackdemo.automation.listners.TestListener;
import com.bstackdemo.automation.pages.CartPage;
import com.bstackdemo.automation.pages.CheckoutPage;
import com.bstackdemo.automation.pages.LoginPage;
import com.bstackdemo.automation.pages.ProductPage;
import com.bstackdemo.automation.utils.WaitUtils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)

public class CheckoutTest extends BaseTest {

	private CheckoutPage checkout;
	private ProductPage plp;
	private CartPage cart;

	@BeforeTest
	public void setUp() {

		loadProperties();
		launchBrowser();
		launchURL();

		lp = new LoginPage(driver);
		lp.clickSignIn();
		lp.login(prop.getProperty("userid"), prop.getProperty("pwd"));

		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("bstack"));

		plp = new ProductPage(driver);
		plp.searchBox();
		plp.cart();

		cart = new CartPage(driver);
		checkout = new CheckoutPage(driver);
		
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	@Test(priority = 1)
	public void validateProduct() {
		String product = checkout.productName();
		Assert.assertTrue(product.contains("iPhone"), "Test Failed - Incorrect product added");
		System.out.println("Test Passed - Correct product added");

	}

	@Test(priority = 2)
	public void verifyPrice() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		cart.checkout();

		System.out.println(driver.getPageSource().contains("price"));
		
		System.out.println(checkout.totalAmount());
		
		/*String actualPrice = wait.until(
			    ExpectedConditions.visibilityOfElementLocated(
			        By.cssSelector(".cart-priceItem-value")
			)).getText();*/

			String expectedPrice = "$799.00"; 

			Assert.assertEquals(checkout.totalAmount(),  expectedPrice, "Test Failed: Mismatch in total price");
			System.out.println("Test Passed: Price matched");
		
		/*String payment = checkout.totalAmount();
		System.out.println(payment);
		Assert.assertEquals(payment, "799.00");*/

	}

	@Test(priority = 3)
	public void validateRequiredFieldMessage() {

		//cart.checkout();

		driver.findElement(By.id("firstNameInput")).sendKeys("Priyanka");

		driver.findElement(By.xpath("//button[text()='Submit']")).click();

		WebElement lastName = driver.findElement(By.id("lastNameInput"));
		

		String validationMessage = (String) ((JavascriptExecutor) driver)
				.executeScript("return arguments[0].validationMessage;", lastName);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(validationMessage);

		Assert.assertEquals(validationMessage, "Please fill out this field.");
	}

}