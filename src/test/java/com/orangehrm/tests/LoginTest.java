package com.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.base.BaseClass;
import com.orangehrm.config.ConfigReader;
import com.orangehrm.pages.DashboardPage;
import com.orangehrm.pages.LoginPage;

public class LoginTest extends BaseClass {

	 @Test
	    public void verifyLogin() {

	        ConfigReader config = new ConfigReader();

	        LoginPage login = new LoginPage(driver);

	        login.login(

	                config.getProperty("username"),

	                config.getProperty("password"));
	        
	        DashboardPage dashboard = new DashboardPage(driver);

	        Assert.assertTrue(
	                dashboard.isDashboardDisplayed(),
	                "Dashboard is not displayed. Login Failed.");

	    }
}
