package com.bstackdemo.automation.pages;

import com.bstackdemo.automation.driver.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.bstackdemo.automation.utils.WaitUtils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;
    
    private static final Logger logger =
            LogManager.getLogger(LoginPage.class);

    //Initialization
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //Locators
    By signInBtn = By.xpath("//*[@id=\"signin\"]");
    By usernameDropdown = By.id("username");
    By passwordDropdown = By.id("password");
    By loginBtn = By.id("login-btn");
    By errorMsg = By.className("error-message");

    //Actions
    public void clickSignIn() {
    	logger.info("Clicking Sign In");
       driver.findElement(signInBtn).click();
      
    }
    
    public String getStatusofLink() {
    	driver.findElement(signInBtn).click();
    	return driver.getCurrentUrl();
    }
    
    public String getAppURL() {
    	logger.info("Getting current URL");
    	return driver.getCurrentUrl();
    }

    public void selectUsername(String username) {

    	 logger.info("Selecting username: " + username);
        driver.findElement(usernameDropdown).click();

        driver.findElement(By.xpath("//div[text()='" + username + "']")).click();
    }

    public void selectPassword(String password) {
    	 logger.info("Selecting password");

        driver.findElement(passwordDropdown).click();

        driver.findElement(By.xpath("//div[text()='" + password + "']")).click();
    }

    public void clickLogin() {
    	logger.info("Clicking Login button");
        driver.findElement(loginBtn).click();
    }

    public void login(String username, String password) {

        //clickSignIn();
    	 logger.info("Login started");

        selectUsername(username);

        selectPassword(password);

        clickLogin();
    }

    public String getError() {
    	logger.error("Fetching error message");
        return driver.findElement(errorMsg).getText();
    }
}