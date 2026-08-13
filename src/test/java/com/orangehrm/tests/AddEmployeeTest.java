package com.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.orangehrm.base.BaseClass;
import com.orangehrm.listeners.TestListener;
import com.orangehrm.pages.AddEmployeePage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.pages.PIMPage;

@Listeners(TestListener.class)
public class AddEmployeeTest extends BaseClass {

    @Test
    public void verifyNavigationToAddEmployee(){

        LoginPage login = new LoginPage(driver);

        login.login("Admin","admin123");

        PIMPage pim = new PIMPage(driver);

        pim.navigateToAddEmployee();

        AddEmployeePage addEmployee =
                new AddEmployeePage(driver);

        addEmployee.addEmployee("Suraksha", "Patil");

        Assert.assertTrue(
                addEmployee.isEmployeeCreated(),
                "Employee was not created successfully");

    }

}