package com.orangehrm.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import com.orangehrm.base.BaseClass;
import com.orangehrm.utilities.ExtentReportManager;
import com.orangehrm.utilities.ScreenshotUtility;

public class TestListener implements ITestListener {

    ExtentReports extent =
            ExtentReportManager.getReportInstance();

    public static ExtentTest test;
    
    public static void logStep(String message) {

        test.info(message);

    }

    @Override
    public void onTestStart(ITestResult result) {

        test = extent.createTest(result.getName());

        test.info("Test Started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.fail(result.getThrowable());

        String screenshotPath =
                ScreenshotUtility.captureScreenshot(
                        BaseClass.driver,
                        result.getName());

        test.addScreenCaptureFromPath(screenshotPath);
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        test.skip("Test Skipped");
    }

    @Override
    public void onFinish(
            org.testng.ITestContext context) {

        extent.flush();
    }
}