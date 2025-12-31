package com.marsdevs.Listener;

import com.marsdevs.Reports.ExtentLogger;
import com.marsdevs.Reports.ExtentReport;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

public class ListenerClass implements ITestListener, ISuiteListener {


    @Override
    public void onStart(ISuite suite) {

        try {
            ExtentReport.initReports();
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(ISuite suite) {

        try {
            ExtentReport.flushreports();
        } catch (Exception e) {

            e.printStackTrace();

        }
    }
    @Override
    public void onTestStart(ITestResult result)
    {
        ExtentReport.createTest(result.getMethod().getMethodName());

    }

    @Override
    public void onTestSuccess (ITestResult result)
    {
        //   ExtentReport.createTest(result.getMethod().getMethodName()+ "is passed" );
        try {
            ExtentLogger.pass(result.getMethod().getMethodName() + " is passed", true);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onTestFailure (ITestResult result)
    {
        try {
            ExtentLogger.fail(result.getMethod().getMethodName() + " is failed", true);
            ExtentLogger.fail(result.getThrowable().toString());
            ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
        } catch (Exception e) {
<<<<<<< HEAD
=======
            // TODO Auto-generated catch block
>>>>>>> 129980a247db5cf38670301b50b8272bef8384e6
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped (ITestResult result)
    {
        //ExtentReport.createTest(result.getMethod().getMethodName()+ "is Skipped");
        try {
            ExtentLogger.skip(result.getMethod().getMethodName() + " is skipped", true);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

