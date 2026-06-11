package com.bstackdemo.automation.pages;

import com.bstackdemo.automation.driver.DriverManager;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

    private WebDriver driver;
    private WebDriverWait wait;
    
    //Initialization
    
    public CartPage(WebDriver driver) {
    	this.driver= driver;
    	wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    
    //Locators
 
    By removeBtn = By.className("shelf-item__del");
    By cartCount = By.className("bag__quantity");
    By totalAmount = By.className("sub-price__val");
    By subtotalText = By.className("sub-price__installment");
    By continueShoppingbtn = By.className("buy-btn");
    By checkoutBtn = By.xpath("//*[@id=\"__next\"]/div/div/div[2]/div[2]/div[3]/div[3]");

    
    public String getAppURL() {
    	return driver.getCurrentUrl();
    }
    public void removeItem() {
        driver.findElement(removeBtn).click();
    }

    public String getCartCount() {
        return driver.findElement(cartCount).getText();
    }
    
    public String getTotalAmount() {
    	return driver.findElement(totalAmount).getText();
    }
    public void continueShopping() {
    	driver.findElement(continueShoppingbtn).click();
    }
    public void checkout() {
    	//driver.findElement(checkoutBtn).click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutBtn)).click();;
    }
    
  
}