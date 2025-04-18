package com_taskMaster_adminTest;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import com_taskMaster_AdminRepo.AdminHomePage;
import com_taskMaster_AdminRepo.AdminLoginPage;
import com_taskMaster_AdminRepo.AdminProfilePage;
import com_taskMaster_objectRepo_Supervisor.WelcomePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class AdminLoginTest {

	@Test
	public void verifyAdminLoginTest() throws URISyntaxException, IOException, InterruptedException {
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", "UK8545P7JV9SZ9SO");
		capabilities.setCapability("automationName", "UiAutomator2");
		capabilities.setCapability("app", "C:\\Users\\User\\Downloads\\TaskMasterApkFile\\app-debug (11).apk");
		capabilities.setCapability("appPackage", "com.woloo.smarthygiene");
		capabilities.setCapability("appActivity", "com.woloo.smarthygiene.MainActivity");
		capabilities.setCapability("autoGrantPermissions", true);
		capabilities.setCapability("noReset", true);
		capabilities.setCapability("ignoreHiddenApiPolicyError", true);

		AndroidDriver driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), capabilities);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		/* Select Admin from Drop down */

		if (!driver.isAppInstalled("com.woloo.smarthygiene"))
			driver.findElement(AppiumBy.id("com.android.packageinstaller:id/permission_allow_button")).click();

		WelcomePage welcomePage = new WelcomePage(driver);
		welcomePage.getLoginDropdown().click();
		welcomePage.getAdminButton().click();

		/* Admin Login page */

		AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
		adminLoginPage.getEmailIDTextfield().isDisplayed();
		adminLoginPage.getEmailIDTextfield().click();
		adminLoginPage.getEmailIDTextfield().sendKeys("dilipvinoth94@gmail.com");

		driver.hideKeyboard();
		Thread.sleep(1000);
		adminLoginPage.getPasswordTextfield().click();
		adminLoginPage.getPasswordTextfield().sendKeys("pass123");

		driver.hideKeyboard();
		adminLoginPage.getLoginButton().click();

		/* Validate the admin login */

		AdminHomePage adminHomePage = new AdminHomePage(driver);
		boolean actualResults = adminHomePage.getAdminDashboardText().isDisplayed();
		Assert.assertEquals(actualResults, true);



	}

	@Test
	public void verifyAdminLoginWithInvalidCredentialsTest()
			throws URISyntaxException, IOException, InterruptedException {
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", "UK8545P7JV9SZ9SO");
		capabilities.setCapability("automationName", "UiAutomator2");
		capabilities.setCapability("app", "C:\\Users\\User\\Downloads\\TaskMasterApkFile\\app-debug (11).apk");
		capabilities.setCapability("appPackage", "com.woloo.smarthygiene");
		capabilities.setCapability("appActivity", "com.woloo.smarthygiene.MainActivity");
		capabilities.setCapability("autoGrantPermissions", true);
		capabilities.setCapability("noReset", true);
		capabilities.setCapability("ignoreHiddenApiPolicyError", true);

		AndroidDriver driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), capabilities);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		/* Select Admin from Drop down */

		if (!driver.isAppInstalled("com.woloo.smarthygiene"))
			driver.findElement(AppiumBy.id("com.android.packageinstaller:id/permission_allow_button")).click();

		WelcomePage welcomePage = new WelcomePage(driver);
		welcomePage.getLoginDropdown().click();
		welcomePage.getAdminButton().click();

		/* Admin Login page */

		AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
		adminLoginPage.getEmailIDTextfield().isDisplayed();
		Thread.sleep(1000);
		adminLoginPage.getEmailIDTextfield().click();
		adminLoginPage.getEmailIDTextfield().sendKeys("dilipvinoth94@gmail.com");

		driver.hideKeyboard();
		Thread.sleep(1000);
		adminLoginPage.getPasswordTextfield().click();
		adminLoginPage.getPasswordTextfield().sendKeys("pass1234");

		driver.hideKeyboard();
		adminLoginPage.getLoginButton().click();
		
		String toastMessage = driver.findElement(AppiumBy.xpath("//android.widget.Toast[1]")).getText();
		System.out.println("Toast Message: " + toastMessage);
		
//		/* Logout */
//		
//		if(adminHomePage.getProfileTab().isDisplayed())
//		adminHomePage.getProfileTab().click();
//
//		AdminProfilePage adminProfilePage = new AdminProfilePage(driver);
//		adminProfilePage.getLogoutButton().click();
//
//		driver.terminateApp("com.woloo.smarthygiene");

	}
	

}
