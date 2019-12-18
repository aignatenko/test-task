package listener;

import logger.TestsLogger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class EventListener implements ITestListener {
    public void onTestStart(ITestResult result) {
        TestsLogger.info("TEST STARTED: " + result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        TestsLogger.info("TEST FINISHED SUCCESSFULLY: " + result.getName());
    }

    public void onTestFailure(ITestResult result) {
        TestsLogger.info("TEST FAILED: " + result.getName());
    }

    public void onTestSkipped(ITestResult result) {
        TestsLogger.info("TEST SKIPPED: " + result.getName());
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    public void onStart(ITestContext context) {
        TestsLogger.info("TESTS SUITE STARTED: " + context.getSuite().getName());
    }

    public void onFinish(ITestContext context) {
        System.out.println("TESTS SUITE FINISHED");
    }
}
