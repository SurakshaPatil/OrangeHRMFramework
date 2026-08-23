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
        boolean isCI = System.getenv("CI") != null;

        if (browser.equalsIgnoreCase("chrome")) {

            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();

            if (isCI) {
                options.addArguments("--headless=new");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--window-size=1920,1080");
            }

            driver = new ChromeDriver(options);

        } else if (browser.equalsIgnoreCase("firefox")) {

            WebDriverManager.firefoxdriver().setup();

            FirefoxOptions options = new FirefoxOptions();

            if (isCI) {
                options.addArguments("-headless");
            }

            driver = new FirefoxDriver(options);

        } else if (browser.equalsIgnoreCase("edge")) {

            WebDriverManager.edgedriver().setup();

            EdgeOptions options = new EdgeOptions();

            if (isCI) {
                options.addArguments("--headless=new");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--window-size=1920,1080");
            }

            driver = new EdgeDriver(options);
        }

        logger.info("Launching Browser");

        driver.manage().window().maximize();

        driver.get(config.getProperty("url"));

        logger.info("Application Launched");
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {

            logger.info("Closing Browser");

            driver.quit();
        }
    }
}