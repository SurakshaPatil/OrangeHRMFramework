package com.orangehrm.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.orangehrm.config.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

    public static WebDriver driver;

    public static Logger logger =
            LogManager.getLogger(BaseClass.class);

    ConfigReader config = new ConfigReader();

    @BeforeMethod
    public void setup() {

        String browser = config.getProperty("browser");

        // Check whether execution is happening in CI/CD
        boolean isCI = System.getenv("CI") != null
                || System.getenv("TF_BUILD") != null;

        if (browser.equalsIgnoreCase("chrome")) {

            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();

            if (isCI) {

                options.addArguments("--headless=new");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--window-size=1920,1080");

                // Additional stability arguments for Azure DevOps
                options.addArguments("--disable-gpu");
                options.addArguments("--disable-extensions");
                options.addArguments("--remote-allow-origins=*");
            }

            driver = new ChromeDriver(options);
        }

        logger.info("Launching Browser");

        if (!isCI) {
            driver.manage().window().maximize();
        }

        driver.get(config.getProperty("url"));

        logger.info("Application Launched");
    }
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            try {
                driver.quit();
            } finally {
                driver = null;
            }
        }
    
    }
}