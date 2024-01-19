package utilities;


import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import java.util.ArrayList;
import java.util.List;

public class TestResultListener implements ITestListener {
    static List<ITestNGMethod> passedTests=new ArrayList<>();
    static List<ITestNGMethod> failedTests=new ArrayList<>();
    ScreenShotUtility screenshotUtility=new ScreenShotUtility();

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        passedTests.add(result.getMethod());
        screenshotUtility.takeScreenshot(AppConfig.readFromConfig("resultFolder"),result.getMethod().getMethodName().trim()+"-passed",
                (WebDriver) result.getTestContext().getAttribute("driver"));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        failedTests.add(result.getMethod());
        screenshotUtility.takeScreenshot(AppConfig.readFromConfig("resultFolder"),result.getMethod().getMethodName().trim()+"-failed",
                (WebDriver) result.getTestContext().getAttribute("driver"));
    }
}
