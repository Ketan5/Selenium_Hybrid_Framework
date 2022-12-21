package Utilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.relevantcodes.extentreports.LogStatus;

public class ListenersClass extends ExtentManager implements ITestListener {

	public void onTestStart(ITestResult result) {
		ExtentManager.extentTestSetup(result.getName());
		Log.startTestCase(result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(LogStatus.PASS, "Passed Test case is: " + result.getName());
		}
	}

	public void onTestFailure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.FAIL, "Failed Test case is: " + result.getName());
			try {
				test.log(LogStatus.FAIL,
						"Screenshot: " + test.addScreenCapture(captureScreenshot(getDriver(), result.getName())));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void onTestSkipped(ITestResult result) {
		if (result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP, "Skipped Test case is: " + result.getName());
		}

	}

	public void onFinish(ITestContext result) {
		ExtentManager.extentTestTeardown();
		Log.endTestCase(result.getName());
	}

	public void onStart(ITestContext result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

}
