package com.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.utilities.WaitUtility;

public class DashboardPage {

	WebDriver driver;
	WaitUtility wait;
    public DashboardPage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);
        wait = new WaitUtility(driver);
    }

    @FindBy(xpath = "//h6[text()='Dashboard']")
    private WebElement dashboardHeading;

    public boolean isDashboardDisplayed() {

        try {

            WaitUtility.waitForVisibility(driver, dashboardHeading);

            return dashboardHeading.isDisplayed();

        } catch (Exception e) {

            return false;

        }
    }
}
