package com.orangehrm.utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility { 

	WebDriver driver;

    public WaitUtility(WebDriver driver) {

        this.driver = driver;

    }

    public static void waitForVisibility(WebDriver driver, WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(element));
    }
    
    public static void waitForElementClickable(WebDriver driver, WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    
    
}
