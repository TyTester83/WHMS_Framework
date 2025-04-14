package Utilities;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImpUtility implements ITestListener, ISuiteListener {
	public ExtentReports reports;
	public static ExtentTest test;

	@Override
	public void onStart(ISuite suite) {

		// spark report configure

		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report_" + time + ".html");
		spark.config().setDocumentTitle("WHMS Test Results");
		spark.config().setReportName("WHMS");
		spark.config().setTheme(Theme.DARK);

		// Adding environment information and create test

		reports = new ExtentReports();
		reports.attachReporter(spark);
		reports.setSystemInfo("AndroidVersion", "9"); // need to change the version of android version
		reports.setSystemInfo("Model", "RMX1833");// model also i want to change
	}

	@Override
	public void onFinish(ISuite suite) {

		reports.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		test = reports.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		UtilityClassObject.getTest().log(Status.INFO, result.getMethod().getMethodName() + "==>STARTED<==");
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		UtilityClassObject.getTest().log(Status.PASS, result.getMethod().getMethodName() + "==>COMPLETED<==");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		UtilityClassObject.getTest().log(Status.INFO, result.getMethod().getMethodName() + "==>SKIPPED<==");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {

		String testName = result.getMethod().getMethodName();
		TakesScreenshot ts = (TakesScreenshot) UtilityClassObject.getDriver();
		String filepath = ts.getScreenshotAs(OutputType.BASE64);
		String time = new Date().toString().replace(" ", "_").replace(":", "_");

		test.addScreenCaptureFromBase64String(filepath, testName + "_" + time);

		UtilityClassObject.getTest().log(Status.FAIL, result.getThrowable());
		UtilityClassObject.getTest().log(Status.FAIL, result.getMethod().getMethodName() + "==>FAILED<==");
	}

}