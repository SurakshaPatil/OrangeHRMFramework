package com.orangehrm.utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "loginData")
    public Object[][] loginDataProvider() {

        ExcelUtility excel = new ExcelUtility(
                "testData/LoginData.xlsx",
                "LoginData");

        return excel.getExcelData();

    }

}