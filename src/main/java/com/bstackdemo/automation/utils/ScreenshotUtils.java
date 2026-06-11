package com.bstackdemo.automation.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import org.apache.commons.io.FileUtils;

public class ScreenshotUtils {


public static String captureScreenshot(WebDriver driver, String testName) {

String path = System.getProperty("user.dir") + "/screenshots/" + testName + ".png";

try {

File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
File dest = new File(path);
FileUtils.copyFile(src, dest);

} catch (Exception e) {

e.printStackTrace();

}

return path;

}
}
