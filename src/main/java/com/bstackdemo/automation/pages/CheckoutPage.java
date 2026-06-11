package com.bstackdemo.automation.pages;

import com.bstackdemo.automation.driver.DriverManager;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {

    private WebDriver driver;
    private WebDriverWait wait;
    
    public CheckoutPage(WebDriver driver) {
    	this.driver= driver;
    	wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
    

    By submitButton = By.id("checkout-shipping-continue");
    By totalPrice = By.className("cart-priceItem-value");
    By ProductTitle = By.xpath("//p[text()='iPhone 12']");
    By firstName = By.id("firstNameInput");
    By lastName = By.id("lastNameInput");
   

    public void placeOrder(String userfirstname, String userlastname) {

        
        driver.findElement(firstName).sendKeys(userfirstname);
        driver.findElement(lastName).sendKeys(userlastname);
       
        driver.findElement(submitButton).click();
    }

    public String totalAmount() {
        return driver.findElement(totalPrice).getText();
    }
    
    public String productName() {
    	return driver.findElement(ProductTitle).getText();
    }
}