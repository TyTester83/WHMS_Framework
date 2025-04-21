package com_taskMaster_TaskBuddy;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com_taskMaster_supervisorRepo.WelcomePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class TaskBuddyLoginTest {

	@Test
	public void verifyTaskBuddyLoginTest() throws Exception, URISyntaxException {
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", "emulator-5554");
		capabilities.setCapability("automationName", "UiAutomator2");
		capabilities.setCapability("app", "C:\\Users\\User\\Downloads\\TaskMasterApkFile\\app-debug (11).apk");
		capabilities.setCapability("appPackage", "com.woloo.smarthygiene");
		capabilities.setCapability("appActivity", "com.woloo.smarthygiene.MainActivity");
		capabilities.setCapability("autoGrantPermissions", true);
		capabilities.setCapability("noReset", true);
		capabilities.setCapability("ignoreHiddenApiPolicyError", true);

		AndroidDriver driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), capabilities);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		/* Select User from Drop down */

		if (!driver.isAppInstalled("com.woloo.smarthygiene")) {

			driver.findElement(AppiumBy.id("com.android.packageinstaller:id/permission_allow_button")).click();
		}

		driver.activateApp("com.woloo.smarthygiene");
		WelcomePage welcomePage = new WelcomePage(driver);
		welcomePage.getLoginDropdown().click();
		welcomePage.getTaskBuddyButton().click();
		
		driver.findElement(AppiumBy.accessibilityId("English")).click();
		WebElement mobileNoTextField = driver.findElement(AppiumBy.className("android.widget.EditText"));
		mobileNoTextField.click();
		mobileNoTextField.sendKeys("9626409660");
		driver.hideKeyboard();
		
		Thread.sleep(2000);
		driver.findElement(AppiumBy.accessibilityId("Send OTP")).click();
		
		Thread.sleep(3000);
		
		
		
		
	}
}
