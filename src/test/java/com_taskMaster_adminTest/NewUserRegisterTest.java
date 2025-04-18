package com_taskMaster_adminTest;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com_taskMaster_AdminRepo.AdminHomePage;
import com_taskMaster_AdminRepo.AdminLoginPage;
import com_taskMaster_AdminRepo.AdminWelcomePage;
import com_taskMaster_AdminRepo.ListYourFacilityPage;
import com_taskMaster_AdminRepo.NewUserRegisterPage;
import com_taskMaster_AdminRepo.TaskMasterOverviewPage;
import com_taskMaster_objectRepo_Supervisor.WelcomePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class NewUserRegisterTest {

	@Test
	public void verifyAdminLoginTest() throws URISyntaxException, IOException, InterruptedException {
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", "UK8545P7JV9SZ9SO");
		capabilities.setCapability("automationName", "UiAutomator2");
		capabilities.setCapability("app",
				"C:\\\\Users\\\\User\\\\Downloads\\\\TaskMasterApkFile\\\\app-debug (11).apk");
		capabilities.setCapability("appPackage", "com.woloo.smarthygiene");
		capabilities.setCapability("appActivity", "com.woloo.smarthygiene.MainActivity");
		capabilities.setCapability("autoGrantPermissions", true);
		capabilities.setCapability("noReset", true);
		capabilities.setCapability("ignoreHiddenApiPolicyError", true);

		AndroidDriver driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), capabilities);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		/* Select Admin from Drop down */

		if (!driver.isAppInstalled("com.woloo.smarthygiene")) {

			driver.findElement(AppiumBy.id("com.android.packageinstaller:id/permission_allow_button")).click();
		}

		WelcomePage welcomePage = new WelcomePage(driver);
		welcomePage.getLoginDropdown().click();
		welcomePage.getAdminButton().click();

		/* Navigate to register page and enter details to register as a new user */
		AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
		adminLoginPage.getRegisterNowLink().click();

//		ExcelUtility excelUtility = new ExcelUtility();
//		String name = excelUtility.readDataFromExcel("Sheet1", 1, 1);
//		String email = excelUtility.readDataFromExcel("Sheet1", 1, 2);
//		String mobileNo = excelUtility.readDataFromExcel("Sheet1", 1, 3);
//		String address = excelUtility.readDataFromExcel("Sheet1", 1, 4);
//		String city = excelUtility.readDataFromExcel("Sheet1", 1, 5);
//		String pincode = excelUtility.readDataFromExcel("Sheet1", 1, 6);
//		String password = excelUtility.readDataFromExcel("Sheet1", 1, 7);
//		String confirmPassword = excelUtility.readDataFromExcel("Sheet1", 1, 8);

		NewUserRegisterPage registerPage = new NewUserRegisterPage(driver);

//		WebDriverWait waitForRegisterPage=new WebDriverWait(driver,Duration.ofSeconds(20));
//		waitForRegisterPage.until(ExpectedConditions.visibilityOf(registerPage.getTaskMasterLogo()));

		Thread.sleep(2000);
		registerPage.getNameTextfield().click();
		registerPage.getNameTextfield().sendKeys("tester123");

		Random ranNumber = new Random();
		int num = ranNumber.nextInt(999);
		registerPage.getEmailTextfield().click();
		registerPage.getEmailTextfield().sendKeys("tester" + num + "@gmail.com");

		registerPage.getMobileNoTextfield().click();
		registerPage.getMobileNoTextfield().sendKeys("7975433" + num);

		registerPage.getAddressTextfield().click();
		registerPage.getAddressTextfield().sendKeys("address1");

		registerPage.getCityTextfield().click();
		registerPage.getCityTextfield().sendKeys("Bangalore");

		registerPage.getPincodeTextfield().click();
		registerPage.getPincodeTextfield().sendKeys("560023");

		registerPage.getPasswordTextfield().click();
		registerPage.getPasswordTextfield().sendKeys("Password420");
		driver.hideKeyboard();

		Thread.sleep(1000);
		registerPage.getConfirmPasswordTextfield().click();
		registerPage.getConfirmPasswordTextfield().sendKeys("Password420");

		driver.hideKeyboard();
		registerPage.getRegisterButton().click();

		/* verify registration */
		boolean actualResults = adminLoginPage.getEmailIDTextfield().isDisplayed();
		Assert.assertEquals(actualResults, true);

	}

	@Test
	public void newUserAddingFacilityTest() throws Exception, URISyntaxException {
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("platformName", "Android");
//		capabilities.setCapability("deviceName", "UK8545P7JV9SZ9SO");
		capabilities.setCapability("deviceName", "emulator-5554");
//		capabilities.setCapability("platformVersion", "16.0");
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
		welcomePage.getAdminButton().click();

		/* Admin Login page */

		AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
		adminLoginPage.getEmailIDTextfield().isDisplayed();
		Thread.sleep(2000);
		adminLoginPage.getEmailIDTextfield().click();
		adminLoginPage.getEmailIDTextfield().sendKeys("ddddd@gmail.com");

		driver.hideKeyboard();
		Thread.sleep(1000);
		adminLoginPage.getPasswordTextfield().click();
		driver.hideKeyboard();
		adminLoginPage.getPasswordTextfield().sendKeys("passpass");

		adminLoginPage.getLoginButton().click();

		TaskMasterOverviewPage taskMasterOverviewPage = new TaskMasterOverviewPage(driver);
		taskMasterOverviewPage.getExploreButton().isDisplayed();

		Thread.sleep(2000);
		taskMasterOverviewPage.getExploreButton().click();

		Thread.sleep(2000);
		AdminWelcomePage adminWelcomePage = new AdminWelcomePage(driver);

		adminWelcomePage.getGetStartButton().isDisplayed();
		adminWelcomePage.getGetStartButton().click();
		Thread.sleep(2000);

		/* Adding new Facility */
		ListYourFacilityPage listYourFacilityPage = new ListYourFacilityPage(driver);
		listYourFacilityPage.getFacilityNameTextfield().isDisplayed();
		listYourFacilityPage.getFacilityNameTextfield().click();
		Thread.sleep(1000);

		listYourFacilityPage.getFacilityNameTextfield().sendKeys("BathRoom");
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));

		Thread.sleep(1000);
		listYourFacilityPage.getLocationTextfield().click();
		
		WebElement locationInput = driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"List Your Facility\r\n"
				+ "Type of Facility *\"]/android.widget.EditText[2]"));	
		String expectedLocation="Bangalore, Karnataka, India";
		
		locationInput.sendKeys("Bangalore");
		
//		
//
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
//				"//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[4]/android.view.View")));// (//android.view.View[@content-desc="Bangalore,
//																																																	// Karnataka,
//																																																	// India"])[2]
//
//		List<WebElement> suggestions = driver.findElements(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[4]/android.view.View"));
//		
//		for (WebElement item : suggestions) {
//		    String suggestionText = item.getText();
//		    System.out.println("Suggested: " + suggestionText);
//
//		    if (suggestionText.equalsIgnoreCase(expectedLocation)) {
//		        item.click();
//		        break;
//		    }
//		}
		
	}
}
