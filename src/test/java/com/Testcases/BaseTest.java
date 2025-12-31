package com.Testcases;
import com.marsdevs.Driver.Driver;
import com.marsdevs.Driver.DriverManager;
import com.marsdevs.Reports.ExtentReport;
import factories.ExplicitWaitFactory;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class BaseTest {

    protected BaseTest() {
    }

    @BeforeSuite
    public void beforeSuite() throws Exception {
        // Initialize ExtentReports before the suite starts
        ExtentReport.initReports();
    }

    @BeforeMethod
    // @Parameters({"waitTimeout"})
    public void setup(Method m) throws Exception {
        //       ExtentReport.createTest(m.getName());
        //        Driver.initDriver();

        String testName;

        if (m == null || m.getName() == null || m.getName().trim().isEmpty()) {
            testName = "Unnamed_Test_" + System.currentTimeMillis(); // Fallback
        } else {
            testName = m.getName();
        }


        //  System.err.println("Test name: " + testName);
        ExtentReport.createTest(testName);

        // Initialize the WebDriver
        Driver.initDriver();

    }

    @AfterMethod
    public void teardown() throws Exception {
          Driver.quitDriver();


    }

    @AfterSuite
    public void afterSuite() throws Exception {
        // Flush the ExtentReports after the suite ends
        ExtentReport.flushreports();



    }
}
