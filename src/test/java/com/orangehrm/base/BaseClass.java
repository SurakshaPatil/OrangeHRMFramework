package com.orangehrm.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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

        if (browser.equalsIgnoreCase("chrome")) {

            WebDriverManager.chromedriver().setup();

            driver = new ChromeDriver();

        } else if (browser.equalsIgnoreCase("firefox")) {

            WebDriverManager.firefoxdriver().setup();

            driver = new FirefoxDriver();

        }else if (browser.equalsIgnoreCase("edge")) {

            WebDriverManager.edgedriver().setup();

            driver = new EdgeDriver();
        }

        logger.info("Launching Browser");
        driver.manage().window().maximize();

        driver.get(config.getProperty("url"));
        logger.info("Application Launched");
    }

    @AfterMethod
    public void tearDown() {

        if(driver != null) {
        	logger.info("Closing Browser");
            driver.quit();
        }
    }
}
