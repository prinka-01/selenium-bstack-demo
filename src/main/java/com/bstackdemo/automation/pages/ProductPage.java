package com.bstackdemo.automation.pages;

import com.bstackdemo.automation.driver.DriverManager;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {

    private WebDriver driver;
    private WebDriverWait wait;
    
    //Initialization
    
    public ProductPage(WebDriver driver) {
    	
    	this.driver=driver;
    	wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
  //Locators - follow encapsulation (private variables, public methods)
	
  	//vendors checklist:
  	
  	private By apple = By.xpath("//*[@id=\"__next\"]/div/div/main/div[1]/div[1]/label/span");
  	private By samsung = By.xpath("//input[@value=\"Samsung\"]");
  	private By google = By.xpath("//input[@value=\"Google\"]");
  	private By onePlus = By.xpath("//input[@value=\"OnePlus\"]");
  	
  	//search
  	private By searchbox = By.xpath("//*[@id=\"__next\"]/div/div/div[1]/div/div/div[2]/div/input");
  	private By searchbutton = By.xpath("//button[@role=\"button\"]");
  	
  	private By wishlist = By.className("MuiSvgIcon-root");
  	
  	private By addToCart = By.className("shelf-item__buy-btn");
  	private By addanother = By.xpath("/html/body/div[1]/div/div/main/div[2]/div[10]/div[4]");
  	private By product = By.xpath("//*[@id=\"__next\"]/div/div/div[2]/div[2]/div[2]/div/div[3]/p[1]");
  	private By closeCartButton = By.className("float-cart__close-btn");
  	private By cartIcon = By.xpath("/html/body/div[1]/div/div/div[2]/span/span");
  	
  	private By cartProductTitle =
  	        By.cssSelector(".float-cart__content .title");

  	private By cartBadge = By.className("bag__quantity");
  	
  	private By cartCount = By.className("bag__quantity");
  	
  //Actions - methods
	
public String verifyURL() {
  		
  		return driver.getCurrentUrl();
  	}
  	
  	public String verifyTitle() {
  		
  		return driver.getTitle();
  	}
  	
  	
  	public void checkBox() {
  		wait.until(ExpectedConditions.elementToBeClickable(apple)).click();
  		//driver.findElement(apple).click();
  	}
  	
  	public void searchBox() {
  		driver.findElement(searchbox).sendKeys("iPhone 12");
  		try {
  			Thread.sleep(3000);
  		} catch (InterruptedException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
  		driver.findElement(searchbutton).click();
  	}
  	
  	public void wishlist() {
  		driver.findElement(wishlist).click();
  		
  		}
  	
  	public boolean isWishlistSelected() {
  	    return driver.findElement(wishlist)
  	                 .getAttribute("class")
  	                 .contains("selected");
  	}
  	
  	public String validateProduct() {
  		
  		return driver.findElement(product).getText();
  	}
  	
  	
  	public void cart() {
  		driver.findElement(addToCart).click();
  		}
  	
  	public void addotherProduct() {
  		driver.findElement(addanother).click();
  	}
  	
  	public String getCartProductTitle() {
  	    wait.until(ExpectedConditions.visibilityOfElementLocated(cartProductTitle));
  	    return driver.findElement(cartProductTitle).getText();
  	}

  	public boolean isCartDisplayed() {
  	    return driver.findElement(cartBadge).isDisplayed();
  	}
  	
  	public String getCartCount() {
  	    return driver.findElement(cartBadge).getText();
  	}
  	
  	public void closeCart() {
  		
  	}
  	
  	public void cartButton() {
  		driver.findElement(cartIcon);
  	} 
    
}