package com.orangehrm.pages;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.orangehrm.utilities.WaitUtility;

public class LoginPage {
	WebDriver driver;
	WaitUtility wait;
	private static final Logger logger =
	        LogManager.getLogger(LoginPage.class);
	
    public LoginPage(WebDriver driver){

        this.driver = driver;
        wait = new WaitUtility(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "username")
    private WebElement txtUsername;

    @FindBy(name = "password")
    private WebElement txtPassword;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnLogin;


    public void enterUsername(String username) {
    	WaitUtility.waitForVisibility(driver, txtUsername);
    	logger.info("Entering Username");
        txtUsername.sendKeys(username);

    }

    public void enterPassword(String password) {
    	logger.info("Entering Password");
        txtPassword.sendKeys(password);

    }

    public void clickLogin() {
    	logger.info("Clicking Login Button");
        btnLogin.click();

    }

    public void login(String username,String password){

        enterUsername(username);

        enterPassword(password);

        clickLogin();
    }
    
    public boolean isLoginPageDisplayed() {
    	WaitUtility.waitForVisibility(driver,txtUsername);

        return txtUsername.isDisplayed();
    }
}
