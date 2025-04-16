package com_taskMaster_adminTest;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com_taskMaster_objectRepo_Supervisor.WelcomePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class AdminLoginTest {

	@Test
	public void verifyAdminLoginTest() throws URISyntaxException, IOException {
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", "UK8545P7JV9SZ9SO");
		capabilities.setCapability("automationName", "UiAutomator2");
//		capabilities.setCapability("app", "C:\\Users\\User\\Downloads\\TaskMasterApkFile\\app-debug (11).apk");
		capabilities.setCapability("appPackage", "com.woloo.smarthygiene");
		capabilities.setCapability("appActivity", "com.woloo.smarthygiene.MainActivity"); 
		capabilities.setCapability("autoGrantPermissions", true);
		capabilities.setCapability("noReset", true);
		capabilities.setCapability("ignoreHiddenApiPolicyError", true);

		AndroidDriver driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), capabilities);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		/* Select Supervisor from Drop down */
		if(!driver.isAppInstalled("com.woloo.smarthygiene"))
		driver.findElement(AppiumBy.id("com.android.packageinstaller:id/permission_allow_button")).click();

		WelcomePage welcomePage = new WelcomePage(driver);
		welcomePage.getLoginDropdown().click();
		welcomePage.getAdminButton().click();

	}

}
