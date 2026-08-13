package com.orangehrm.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.utilities.WaitUtility;

public class AddEmployeePage {

    WebDriver driver;
    
    private static final Logger logger =
	        LogManager.getLogger(LoginPage.class);

    public AddEmployeePage(WebDriver driver){

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//h6[text()='Add Employee']")
    WebElement addEmployeeHeader;

    public boolean isAddEmployeePageDisplayed(){

        WaitUtility.waitForVisibility(driver, addEmployeeHeader);

        return addEmployeeHeader.isDisplayed();

    }
    
    @FindBy(name = "firstName")
    WebElement txtFirstName;

    @FindBy(name = "lastName")
    WebElement txtLastName;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnSave;
    
    public void enterFirstName(String firstName) {

        WaitUtility.waitForVisibility(driver, txtFirstName);

        logger.info("Entering First Name");

        txtFirstName.clear();

        txtFirstName.sendKeys(firstName);
    }
    
    public void enterLastName(String lastName) {

        logger.info("Entering Last Name");

        txtLastName.clear();

        txtLastName.sendKeys(lastName);
    }
    
    public void clickSave() {

        WaitUtility.waitForElementClickable(driver, btnSave);

        logger.info("Clicking Save Button");

        btnSave.click();
    }
    
    public void addEmployee(String firstName, String lastName) {

        enterFirstName(firstName);

        enterLastName(lastName);

        clickSave();
    }
    
    @FindBy(xpath = "//h6[text()='Personal Details']")
    WebElement personalDetailsHeader;
    
    public boolean isEmployeeCreated() {

        WaitUtility.waitForVisibility(driver, personalDetailsHeader);

        return personalDetailsHeader.isDisplayed();
    }
    

}