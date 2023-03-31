package reusableComponents;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import testBase.DriverFactory;
import testBase.ExtentFactory;
import testBase.ExtentReportNG;

public class ListenersImplementation implements ITestListener {

	static ExtentReports report;
	ExtentTest test;

	public void onStart(ITestContext context) {
		try {
			report = ExtentReportNG.createExtentReport();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestStart(ITestResult result) {

		test = report.createTest(result.getMethod().getMethodName());
		ExtentFactory.getInstance().setExtentTest(test);

	}

	public void onTestSuccess(ITestResult result) {
		ExtentFactory.getInstance().getExtentTest().log(Status.PASS, "Test case : " + result.getMethod().getMethodName() + " is PASSED");
		ExtentFactory.getInstance().removeExtentObject();

	}

	public void onTestFailure(ITestResult result) {
		ExtentFactory.getInstance().getExtentTest().log(Status.FAIL, "Test Case : " + result.getMethod().getMethodName() + " is FAILED");
		ExtentFactory.getInstance().getExtentTest().log(Status.FAIL, result.getThrowable());

		// add screenshot for failed tests
		File src = ((TakesScreenshot) DriverFactory.getInstance().getDriver()).getScreenshotAs(OutputType.FILE);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
		Date date = new Date();
		String actualDate = dateFormat.format(date);
		String screenshotPath = System.getProperty("user.dir") + "/Reports/Screenshots/"+ result.getMethod().getMethodName() + "_" + actualDate + ".jpg";
		File dest = new File(screenshotPath);
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ExtentFactory.getInstance().getExtentTest().addScreenCaptureFromPath(screenshotPath, "Testcase failure screenshot");
		ExtentFactory.getInstance().removeExtentObject();

	}

	public void onTestSkipped(ITestResult result) {
		ExtentFactory.getInstance().getExtentTest().log(Status.SKIP, "Test case : " + result.getMethod().getMethodName() + " is SKIPPED");
		ExtentFactory.getInstance().removeExtentObject();

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onFinish(ITestContext context) {
		report.flush();

	}

}
