package com.marsdevs.Reports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentManager {

    private ExtentManager(){}

    private static ThreadLocal<ExtentTest> extest = new ThreadLocal<>();

    static ExtentTest getExtentTest(){
        return extest.get();
    }
    static void setExtenttest(ExtentTest test){
        extest.set(test);
    }

    static void unload(){
        extest.remove();
    }

}
