package com.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.orangehrm.base.BaseClass;
import com.orangehrm.listeners.TestListener;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.pages.LogoutPage;

@Listeners(TestListener.class)
public class LogoutTest extends BaseClass {

    @Test
    public void verifyLogout() {

        LoginPage login = new LoginPage(driver);

        login.login("Admin", "admin123");

        LogoutPage logout = new LogoutPage(driver);

        logout.logout();
   
        Assert.assertTrue(
                login.isLoginPageDisplayed(),
                "Logout Failed");
    }
}