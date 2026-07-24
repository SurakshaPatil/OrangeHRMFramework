package com.orangehrm.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.utilities.WaitUtility;

public class LoginPage {
	WebDriver driver;
	WaitUtility wait;
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
    	wait.waitForVisibility(txtUsername);
        txtUsername.sendKeys(username);

    }

    public void enterPassword(String password) {

        txtPassword.sendKeys(password);

    }

    public void clickLogin() {

        btnLogin.click();

    }

    public void login(String username,String password){

        enterUsername(username);

        enterPassword(password);

        clickLogin();
    }
}
