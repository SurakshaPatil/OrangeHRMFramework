package com.orangehrm.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.utilities.WaitUtility;

public class PIMPage {

    WebDriver driver;

    private static final Logger logger =
            LogManager.getLogger(PIMPage.class);

    public PIMPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//span[text()='PIM']")
    WebElement pimMenu;

    @FindBy(xpath="//a[text()='Add Employee']")
    WebElement addEmployeeMenu;

    public void clickPIM() {

        WaitUtility.waitForElementClickable(driver, pimMenu);

        logger.info("Clicking PIM Menu");

        pimMenu.click();
    }

    public void clickAddEmployee() {

        WaitUtility.waitForElementClickable(driver, addEmployeeMenu);

        logger.info("Clicking Add Employee");

        addEmployeeMenu.click();
    }

    public void navigateToAddEmployee() {

        clickPIM();

        clickAddEmployee();
    }

}