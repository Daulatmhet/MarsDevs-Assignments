package com.marsdevs.Reports;
import Constants.FramworkConstants;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class ExtentReport {


    private ExtentReport() {
    }

    private static ExtentReports extent;
    public static ExtentTest test;
    private static boolean isReportOpened = false;

    public static void initReports() throws Exception {

        if (Objects.isNull(extent)) {
            //ExplicitWaitFactory.waitForPageToLoad();
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(FramworkConstants.getExtentreportFilePath());
            extent.attachReporter(spark);
            spark.config().setTheme(Theme.STANDARD);
            spark.config().setDocumentTitle("MarsDevs");
            spark.config().setReportName("MarsDevsReport");
        }

    }
    public static void flushreports() throws Exception {
        if (extent != null) {

            extent.flush();
        }
        if (!isReportOpened) {
            isReportOpened = true;  // Mark as opened to avoid opening again
            Desktop.getDesktop().browse(new File(FramworkConstants.getExtentreportFilePath()).toURI());
        }

        //  Desktop.getDesktop().browse(new File(FramworkConstants.getExtentreportFilePath()).toURI());
    }

    public static void createTest(String testName)
    {
        if (testName == null || testName.trim().isEmpty()) {
            testName = "Unnamed_Test_" + System.currentTimeMillis();
        }
        //  extent.createTest(testName);

        ExtentTest test = extent.createTest(testName);
        ExtentManager.setExtenttest(test);


    }

}
