package com.bstackdemo.automation.listners;

import java.io.IOException;

import org.testng.*;
import org.testng.ITestListener;

import com.aventstack.extentreports.*;

import com.bstackdemo.automation.base.*;
import com.bstackdemo.automation.utils.*;

public class TestListener extends BaseTest
        implements ITestListener {

    ExtentReports extent = ExtentManager.getReportObject();

    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {

        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.fail(result.getThrowable());

        String path = ScreenshotUtils.captureScreenshot(
		        driver,
		        result.getMethod().getMethodName());

		test.addScreenCaptureFromPath(path);
    }

    @Override
    public void onFinish(ITestContext context) {

        extent.flush();
    }
}