package com.orangehrm.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.listeners.TestListener;
import com.orangehrm.utilities.WaitUtility;

public class LogoutPage {
	private static final Logger logger =
	        LogManager.getLogger(LoginPage.class);

    WebDriver driver;

    public LogoutPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class='oxd-userdropdown-tab']")
    WebElement profileMenu;

    @FindBy(xpath = "//a[text()='Logout']")
    WebElement logoutLink;

    public void clickProfileMenu() {
    	WaitUtility.waitForElementClickable(driver, profileMenu);
    	logger.info("clicking profile menu");
    	TestListener.logStep("click Prfile menu");
        profileMenu.click();
    }

    public void clickLogout() {
    	WaitUtility.waitForElementClickable(driver, logoutLink);
    	logger.info("click logout");
    	TestListener.logStep("Click Logout");
        logoutLink.click();
    }

    public void logout() {
        clickProfileMenu();
        clickLogout();
    }
}