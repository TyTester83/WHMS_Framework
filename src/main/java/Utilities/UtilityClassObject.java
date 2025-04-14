package Utilities;

import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.android.AndroidDriver;

public class UtilityClassObject {
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
	private static ThreadLocal<AndroidDriver> driver = new ThreadLocal<AndroidDriver>();

	public static ExtentTest getTest() {
		return test.get();
	}

	public static void setTest(ExtentTest actualTest) {
		test.set(actualTest);
	}

	public static AndroidDriver getDriver() {
		return driver.get();
	}

	public static void setDriver(AndroidDriver actualDriver) {
		driver.set(actualDriver);
	}

}
