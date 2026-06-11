package com.bstackdemo.automation.utils;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

    public static ExtentReports extent;

    public static ExtentReports getReportObject() {

        String path = System.getProperty("user.dir")
                + "/reports/ExtentReport.html";

        ExtentSparkReporter sparkReporter  = new ExtentSparkReporter(path);
        
        ExtentReports report = new ExtentReports();
        report.attachReporter(sparkReporter );
        
        report.setSystemInfo("Project Name", "MavenAutomationReport");
        report.setSystemInfo("Machine", "Windows");
        report.setSystemInfo("Browser", "Chrome");
        report.setSystemInfo("Company", "ExtentReport");
        report.setSystemInfo("User", "Priyanka");
        report.setSystemInfo("Application", "BStack Demo Automation");

        sparkReporter .config().setReportName("BStack Demo Automation");
        sparkReporter .config().setDocumentTitle("Automation Results");
        sparkReporter .config().setTheme(Theme.DARK);
        

        extent = new ExtentReports();

        extent.attachReporter(sparkReporter );

        extent.setSystemInfo("Project", "BStack Demo Automation");
        extent.setSystemInfo("Tester", "Priyanka Dhumal");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Java Version", System.getProperty("java.version"));
        extent.setSystemInfo("Browser", "Chrome / Firefox / Edge");
        extent.setSystemInfo("Execution Type", "Regression Suite");

        return extent;
    }
}