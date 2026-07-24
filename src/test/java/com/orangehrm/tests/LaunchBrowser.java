package com.orangehrm.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {

    public static void main(String[] args) {

        // Download and configure ChromeDriver automatically
        WebDriverManager.chromedriver().setup();

        // Launch Chrome browser
        WebDriver driver = new ChromeDriver();

        // Maximize browser window
        driver.manage().window().maximize();

        // Open OrangeHRM website
        driver.get("https://opensource-demo.orangehrmlive.com/");

        // Print page title in Console
        System.out.println(driver.getTitle());

        // Close browser
        driver.quit();

    }

}