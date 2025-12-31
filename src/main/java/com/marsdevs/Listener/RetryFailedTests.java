package com.marsdevs.Listener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTests implements IRetryAnalyzer {


    private int count =0;
    private int retries =1;


    @Override
    public boolean retry(ITestResult result){

        boolean value = count<retries;
        return value;
    }
}

