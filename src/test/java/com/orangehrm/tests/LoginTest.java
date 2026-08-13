package com.orangehrm.tests;
import org.testng.annotations.Listeners;

import com.orangehrm.listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.base.BaseClass;
import com.orangehrm.pages.DashboardPage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.utilities.DataProviders;

@Listeners(TestListener.class)
public class LoginTest extends BaseClass {
	

	@Test(dataProvider = "loginData",
		      dataProviderClass = DataProviders.class,
		      retryAnalyzer = com.orangehrm.retry.RetryAnalyzer.class)
		public void verifyLogin(String username,
		                        String password,
		                        String expectedResult) {

		    LoginPage login = new LoginPage(driver);

		    login.login(username, password);

		    DashboardPage dashboard = new DashboardPage(driver);

		    boolean actualResult = dashboard.isDashboardDisplayed();

		    TestListener.logStep(
		            "Actual login result: " + actualResult);

		    if (expectedResult.equalsIgnoreCase("Pass")) {

		        Assert.assertTrue(actualResult,
		                "Expected login to succeed, but it failed.");

		    } else {

		        Assert.assertFalse(actualResult,
		                "Expected login to fail, but it succeeded.");
		    }
		}

}