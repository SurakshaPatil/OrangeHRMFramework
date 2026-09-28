package com.orangehrm.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "loginData")
    public Object[][] loginDataProvider() throws IOException {

        ExcelUtility excel = new ExcelUtility(
                "/testData/LoginData.xlsx",
                "LoginData");

        return excel.getExcelData();

    }

}