package com_taskMaster_adminTest;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import Utilities.BaseClass;
import com_taskMaster_adminRepo.AdminAssignTaskPage;
import com_taskMaster_adminRepo.AdminLoginPage;
import com_taskMaster_adminRepo.AdminWelcomePage;
import com_taskMaster_adminRepo.ListYourFacilityPage;
import com_taskMaster_adminRepo.NewUserRegisterPage;
import com_taskMaster_adminRepo.StartTimePage;
import com_taskMaster_adminRepo.TaskMasterOverviewPage;
import com_taskMaster_supervisorRepo.WelcomePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class NewUserRegisterTest extends BaseClass {

	@Test
	public void verifyWelcomePageDropdown() {
		/* Select Admin from Drop down */

		WelcomePage welcomePage = new WelcomePage(driver);

		/* Validate the WelcomePage Login as */

		boolean actDropdown = welcomePage.getLoginDropdown().isDisplayed();
		Assert.assertEquals(actDropdown, true);

		/* validate the dropdown option */

		welcomePage.getLoginDropdown().click();

		boolean actAdminOption = welcomePage.getAdminButton().isDisplayed();
		Assert.assertEquals(actAdminOption, true);
		welcomePage.getAdminButton().click();

		/* Validate the proper admin Login page is displayed */

		AdminLoginPage adminLoginPage = new AdminLoginPage(driver);

		boolean actualLoginPage = adminLoginPage.getRegisterNowLink().isDisplayed();
		Assert.assertEquals(actualLoginPage, true);

	}

	@Test
	public void verifyAdminLoginTest() throws URISyntaxException, IOException, InterruptedException {

		/* Select Admin from Drop down */

		WelcomePage welcomePage = new WelcomePage(driver);
		welcomePage.getLoginDropdown().click();
		welcomePage.getAdminButton().click();

		/* Navigate to register page and enter details to register as a new user */

		AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
		adminLoginPage.getRegisterNowLink().click();

		Random ranNumber = new Random();
		int num = ranNumber.nextInt(999);
		String name = exUtil.readDataFromExcel("Sheet1", 1, 1) + num;
		String email = exUtil.readDataFromExcel("Sheet1", 1, 2) + num + "@gmail.com";
		String mobileNumber = exUtil.readDataFromExcel("Sheet1", 1, 3) + num;
		String address = exUtil.readDataFromExcel("Sheet1", 1, 4);
		String city = exUtil.readDataFromExcel("Sheet1", 1, 5);
		String pincode = exUtil.readDataFromExcel("Sheet1", 1, 6);
		String password = exUtil.readDataFromExcel("Sheet1", 1, 7);

		NewUserRegisterPage registerPage = new NewUserRegisterPage(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(registerPage.getNameTextfield()));

		registerPage.getNameTextfield().click();
		registerPage.getNameTextfield().sendKeys(name);

		registerPage.getEmailTextfield().click();
		registerPage.getEmailTextfield().sendKeys(email);

		registerPage.getMobileNoTextfield().click();
		registerPage.getMobileNoTextfield().sendKeys(mobileNumber);

		registerPage.getAddressTextfield().click();
		registerPage.getAddressTextfield().sendKeys(address);

		registerPage.getCityTextfield().click();
		registerPage.getCityTextfield().sendKeys(city);

		registerPage.getPincodeTextfield().click();
		registerPage.getPincodeTextfield().sendKeys(pincode);

		registerPage.getPasswordTextfield().click();
		registerPage.getPasswordTextfield().sendKeys(password);

		registerPage.getConfirmPasswordTextfield().click();
		Thread.sleep(1000);
		driver.hideKeyboard();
		registerPage.getConfirmPasswordTextfield().sendKeys(password);

		Thread.sleep(1000);
		registerPage.getRegisterButton().click();

		/* verify registration */

		boolean actualResults = adminLoginPage.getEmailIDTextfield().isDisplayed();
		Assert.assertEquals(actualResults, true);

		exUtil.writeDataToExcel("sheet1", 2, 1, name);
		exUtil.writeDataToExcel("sheet1", 2, 2, email);
		exUtil.writeDataToExcel("sheet1", 2, 3, mobileNumber);
		exUtil.writeDataToExcel("sheet1", 2, 4, address);
		exUtil.writeDataToExcel("sheet1", 2, 5, city);
		exUtil.writeDataToExcel("sheet1", 2, 6, pincode);
		exUtil.writeDataToExcel("sheet1", 2, 7, password);
		exUtil.writeDataToExcel("sheet1", 2, 8, password);

	}

	@Test
	public void newUserAddingFacilityTest() throws Exception, URISyntaxException {

		String name = exUtil.readDataFromExcel("Sheet1", 2, 1);
		String email = exUtil.readDataFromExcel("Sheet1", 2, 2);
		String password = exUtil.readDataFromExcel("Sheet1", 2, 7);

		/* Select User from Drop down */

		AdminWelcomePage adminWelcomePage = new AdminWelcomePage(driver);
		driver.activateApp("com.woloo.smarthygiene");

		boolean vaildate = adminWelcomePage.getGetStartButton().isDisplayed();
		if (!vaildate) {
			WelcomePage welcomePage = new WelcomePage(driver);
			welcomePage.getLoginDropdown().click();
			welcomePage.getAdminButton().click();

			/* Admin Login page */

			AdminLoginPage adminLoginPage = new AdminLoginPage(driver);

			Thread.sleep(1000);
			adminLoginPage.getEmailIDTextfield().click();
			adminLoginPage.getEmailIDTextfield().sendKeys(email);
			driver.hideKeyboard();
			Thread.sleep(1000);

			adminLoginPage.getPasswordTextfield().click();
			adminLoginPage.getPasswordTextfield().sendKeys(password);
			driver.hideKeyboard();
			Thread.sleep(1000);
			adminLoginPage.getLoginButton().click();

			/* Validate explore button is displayed */

			Thread.sleep(1000);
			TaskMasterOverviewPage taskMasterOverviewPage = new TaskMasterOverviewPage(driver);
			boolean actExploreBtn = taskMasterOverviewPage.getExploreButton().isDisplayed();
			Assert.assertEquals(actExploreBtn, true);
			Thread.sleep(1000);

			taskMasterOverviewPage.getExploreButton().click();
		}

		/* Validate start button is displayed */

		boolean actSatrtBtn = adminWelcomePage.getGetStartButton().isDisplayed();
		Assert.assertEquals(actSatrtBtn, true);

		adminWelcomePage.getGetStartButton().click();
		Thread.sleep(1000);

		/* Validate the List Your Facility Page */

		ListYourFacilityPage listYourFacilityPage = new ListYourFacilityPage(driver);
		boolean actFacilityPage = listYourFacilityPage.getlistYourFacilityTextview().isDisplayed();
		Assert.assertEquals(actFacilityPage, true);

		/* Adding new Facility */

		String expectedLocation = "Bangalore";

		listYourFacilityPage.getFacilityNameTextfield().click();
		listYourFacilityPage.getFacilityNameTextfield().sendKeys("BathRoom");

		listYourFacilityPage.getLocationTextfield().click();
		listYourFacilityPage.getLocationTextfield().sendKeys(expectedLocation);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement location = wait.until(ExpectedConditions.elementToBeClickable(
				AppiumBy.xpath("//android.view.View[contains(@content-desc,'" + expectedLocation + "')]")));
		location.click();
		driver.hideKeyboard();
		adminWelcomePage.getGetStartButton().click();
		Thread.sleep(1000);
		listYourFacilityPage.getOfficeFacilityImage().click();
		
		WebElement nextBtn = wait.until(ExpectedConditions.elementToBeClickable(
				AppiumBy.xpath("//android.view.View[@content-desc=\"Next\"]")));
		nextBtn.click();
		
		System.out.println("Done");

		/* Navigate to assign task page and create task for janitor */

		Thread.sleep(1000);
		AdminAssignTaskPage taskPage = new AdminAssignTaskPage(driver);

		boolean actTaskPage = taskPage.gettaskTextview().isDisplayed();
		Assert.assertEquals(actTaskPage, true);

//		taskPage.getSelectCleaningTaskDropdown().click();
//		String cleaning = "Pantry Cleaning   15 min";
//		WebElement element = driver
//				.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
//						+ ".scrollIntoView(new UiSelector().xpath(\"//android.widget.Button[@content-desc='" + cleaning
//						+ "']/following-sibling::android.widget.CheckBox\"))"));
//		element.click();
//
//		taskPage.getOkButton().click();
//		taskPage.getStartTimeButton().click();
//
//		StartTimePage shiftStartTimePage = new StartTimePage(driver);
//		boolean actSelectTimePage = shiftStartTimePage.getSelectTimeTextView().isDisplayed();
//		Assert.assertEquals(actSelectTimePage, true);
//
//		shiftStartTimePage.getSwitchTimeIcon().click();
//
//		/* Enter the time for Shift */
//
//		boolean actEnterTimePage = shiftStartTimePage.getEnterTimeTextView().isDisplayed();
//		Assert.assertEquals(actEnterTimePage, true);
//
//		String hours = "9";
//		String minutes = "10";
//		String shift = "am";
////		shiftStartTimePage.getHrsTextfield().click();
//		shiftStartTimePage.getHrsTextfield().clear();
//		shiftStartTimePage.getHrsTextfield().sendKeys(hours);
//
//		if (shift.equals("am")) {
//			shiftStartTimePage.getAmRadioButton().click();
//		}
//
//		else {
//			shiftStartTimePage.getPmRadioButton().click();
//		}
//		
//		shiftStartTimePage.getOkButton().click();
	}
}
