package com.marsdevs.Reports;

import Utils.PropertyUtil;
import Utils.ScreenshotUtils;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.marsdevs.Enums.ConfigProperies;

public class ExtentLogger {


    private ExtentLogger(){}


    public static void pass(String message){
        ExtentManager.getExtentTest().pass(message);
    }

    public static void fail(String message){
        ExtentManager.getExtentTest().fail(message);
    }

    public static void skip(String message){
        ExtentManager.getExtentTest().skip(message);
    }

    public static void pass(String message, boolean isscreenshotNeeded) throws Exception
    {
        // ExplicitWaitFactory.waitForPageToLoad();
        // ExplicitWaitFactory.waitForFullLoad();

        if(PropertyUtil.get(ConfigProperies.PASSEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")
                && isscreenshotNeeded)
        {
            ExtentManager.getExtentTest().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
        }
        else {
            pass(message);
        }
    }

    public static void fail(String message, boolean isscreenshotNeeded) throws Exception
    {
        // ExplicitWaitFactory.waitForPageToLoad();
        // ExplicitWaitFactory.waitForFullLoad();

        if(PropertyUtil.get(ConfigProperies.FAILEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")
                && isscreenshotNeeded)
        {
            ExtentManager.getExtentTest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
        }
        else {
            fail(message);
        }
    }

    public static void skip(String message, boolean isscreenshotNeeded) throws Exception
    {
        // ExplicitWaitFactory.waitForPageToLoad();


        if(PropertyUtil.get(ConfigProperies.SKIPPEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")
                && isscreenshotNeeded)
        {
            ExtentManager.getExtentTest().skip(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
        }
        else {
            skip(message);
        }
    }

}
