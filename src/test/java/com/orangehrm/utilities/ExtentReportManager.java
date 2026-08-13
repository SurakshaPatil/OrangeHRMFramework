package com.orangehrm.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    public static ExtentReports extent;

    public static ExtentReports getReportInstance() {

        if (extent == null) {

            String path = System.getProperty("user.dir")
                    + "/test-output/ExtentReport.html";

            ExtentSparkReporter reporter =
                    new ExtentSparkReporter(path);

            reporter.config().setReportName(
                    "OrangeHRM Automation Report");

            reporter.config().setDocumentTitle(
                    "Test Execution Report");

            extent = new ExtentReports();

            extent.attachReporter(reporter);

            extent.setSystemInfo("Project", "OrangeHRM");
            extent.setSystemInfo("Browser", "Chrome");
        }

        return extent;
    }
}