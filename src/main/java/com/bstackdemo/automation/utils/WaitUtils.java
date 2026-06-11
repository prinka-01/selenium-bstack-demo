package com.bstackdemo.automation.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class WaitUtils {

    public static void waitForElementVisible(WebDriver driver, By locator) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

	public static void waitForUrlContains(WebDriver driver, String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains(string));
		
	}
}





















/*package com.bstackdemo.automation.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    private static final int DEFAULT_TIMEOUT = 20;

    // ===============================
    // Wait for Element to be Visible
    // ===============================
    public static WebElement waitForVisibility(WebDriver driver, By locator) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // ===============================
    // Wait for Element to be Clickable
    // ===============================
    public static WebElement waitForClickability(WebDriver driver, By locator) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    // ===============================
    // Wait for Element to be Present in DOM
    // ===============================
    public static WebElement waitForPresence(WebDriver driver, By locator) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    // ===============================
    // Wait for URL to Contain Text
    // ===============================
    public static void waitForUrlContains(WebDriver driver, String partialUrl) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        wait.until(ExpectedConditions.urlContains(partialUrl));
    }

    // ===============================
    // Wait for Page Title
    // ===============================
    public static void waitForTitleContains(WebDriver driver, String title) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        wait.until(ExpectedConditions.titleContains(title));
    }

    // ===============================
    // Custom Wait with Timeout
    // ===============================
    public static WebElement waitForVisibility(WebDriver driver, By locator, int timeoutInSeconds) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}*/