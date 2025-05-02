package com_taskMaster_adminTest;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.BaseClass;
import Utilities.GestureUtility;
import com_taskMaster_adminRepo.AdminAssignTaskPage;
import com_taskMaster_adminRepo.AdminLoginPage;
import com_taskMaster_adminRepo.AdminWelcomePage;
import com_taskMaster_adminRepo.ListYourFacilityPage;
import com_taskMaster_adminRepo.NewUserRegisterPage;
import com_taskMaster_adminRepo.ScheduleTaskTimingsPage;
import com_taskMaster_adminRepo.StartTimePage;
import com_taskMaster_adminRepo.TaskMasterOverviewPage;
import com_taskMaster_supervisorRepo.WelcomePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class NewUserRegisterTest extends BaseClass {

	@Test
	public void verifyNewRegisterationTextfieldTest() throws URISyntaxException, IOException, InterruptedException {

		/* Select Client from Drop down */

		WelcomePage welcomePage = new WelcomePage(driver);
		welcomePage.getLoginDropdown().click();
		welcomePage.getAdminButton().click();

		/* Navigate to register page and enter details to register as a new user */

		AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
		adminLoginPage.getRegisterNowLink().click();

		NewUserRegisterPage registerPage = new NewUserRegisterPage(driver);

		/* Validate all the text field is visible */
		Thread.sleep(2000);
		Assert.assertEquals(registerPage.getNameTextfield().isDisplayed(), true);
		Assert.assertEquals(registerPage.getEmailTextfield().isDisplayed(), true);
		Assert.assertEquals(registerPage.getMobileNoTextfield().isDisplayed(), true);
		Assert.assertEquals(registerPage.getAddressTextfield().isDisplayed(), true);
		Assert.assertEquals(registerPage.getCityTextfield().isDisplayed(), true);
		Assert.assertEquals(registerPage.getPincodeTextfield().isDisplayed(), true);
		Assert.assertEquals(registerPage.getPasswordTextfield().isDisplayed(), true);
		Assert.assertEquals(registerPage.getConfirmPasswordTextfield().isDisplayed(), true);
		Assert.assertEquals(registerPage.getRegisterButton().isDisplayed(), true);

	}

	@Test
	public void emptyFieldValidationOfRegisterationTest() throws URISyntaxException, IOException, InterruptedException {

		/* Select Client from Drop down */

		WelcomePage welcomePage = new WelcomePage(driver);
		welcomePage.getLoginDropdown().click();
		welcomePage.getAdminButton().click();

		/* Navigate to register page and enter details to register as a new user */

		AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
		adminLoginPage.getRegisterNowLink().click();

		NewUserRegisterPage registerPage = new NewUserRegisterPage(driver);

		/* Validate all the text field error message */
		Thread.sleep(2000);
		GestureUtility gUtil = new GestureUtility(driver);
		gUtil.dragAndDrop(registerPage.getCityTextfield(), 410, 746);
		driver.hideKeyboard();
		registerPage.getRegisterButton().click();

		Assert.assertEquals(registerPage.getNameErrorMessage().isDisplayed(), true);
		Assert.assertEquals(registerPage.getEmailErrorMessage().isDisplayed(), true);
		Assert.assertEquals(registerPage.getMobileNoErrorMessage().isDisplayed(), true);
		Assert.assertEquals(registerPage.getAddressErrorMessage().isDisplayed(), true);
		Assert.assertEquals(registerPage.getCityErrorMessage().isDisplayed(), true);
		Assert.assertEquals(registerPage.getPincodeErrorMessage().isDisplayed(), true);
		gUtil.dragAndDrop(registerPage.getPasswordErrorMessage(), 410, 746);
		driver.hideKeyboard();
		Assert.assertEquals(registerPage.getPasswordErrorMessage().isDisplayed(), true);
		Assert.assertEquals(registerPage.getConfirmPasswordErrorMessage().isDisplayed(), true);

	}

	@Test
	public void verifyNewRegisterationTest() throws URISyntaxException, IOException, InterruptedException {

		/* Select Client from Drop down */

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
	public void verfiyListYourFacilityPageTest() throws EncryptedDocumentException, IOException, InterruptedException {

		String email = exUtil.readDataFromExcel("Sheet1", 2, 2);
		String password = exUtil.readDataFromExcel("Sheet1", 2, 7);

		/* Select User from Drop down */

		WelcomePage welcomePage = new WelcomePage(driver);
		AdminWelcomePage adminWelcomePage = new AdminWelcomePage(driver);
		driver.activateApp("com.woloo.smarthygiene");

		boolean vaildate = adminWelcomePage.getGetStartButton().isDisplayed();
		if (!vaildate) {

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
		boolean actFacilityPage = listYourFacilityPage.getListYourFacilityTextview().isDisplayed();
		Assert.assertEquals(actFacilityPage, true);

	}

	@Test
	public void verifyAssignTaskPageTest() throws InterruptedException, Exception, IOException {

		String email = exUtil.readDataFromExcel("Sheet1", 2, 2);
		String password = exUtil.readDataFromExcel("Sheet1", 2, 7);

		/* Select User from Drop down */

		WelcomePage welcomePage = new WelcomePage(driver);
		AdminWelcomePage adminWelcomePage = new AdminWelcomePage(driver);
		driver.activateApp("com.woloo.smarthygiene");

		boolean isLoggedOut;
		try {
			isLoggedOut = adminWelcomePage.getGetStartButton().isDisplayed();
		} catch (Exception e) {
			isLoggedOut = false;
		}

		if (!isLoggedOut) {

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
			Thread.sleep(1000);
			taskMasterOverviewPage.getExploreButton().click();
		}

		adminWelcomePage.getGetStartButton().click();
		Thread.sleep(1000);

		/* Validate the List Your Facility Page */

		ListYourFacilityPage listYourFacilityPage = new ListYourFacilityPage(driver);

		String expectedLocation = "Bangalore";
		listYourFacilityPage.getFacilityNameTextfield().click();
		listYourFacilityPage.getFacilityNameTextfield().sendKeys("BathRoom");

		listYourFacilityPage.getLocationTextfield().click();
		listYourFacilityPage.getLocationTextfield().sendKeys(expectedLocation);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement location = wait.until(ExpectedConditions.elementToBeClickable(
				AppiumBy.xpath("//android.view.View[contains(@content-desc,'" + expectedLocation + "')]")));
		location.click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		listYourFacilityPage.getOfficeFacilityImage().click();
		Thread.sleep(1000);
		listYourFacilityPage.getNextButton().click();

		/* Validate the Assign Task Page */

		AdminAssignTaskPage taskPage = new AdminAssignTaskPage(driver);

		boolean actTaskPage = taskPage.gettaskTextview().isDisplayed();
		Assert.assertEquals(actTaskPage, true);

	}

	@Test
	public void newUserAddingFacilityTest() throws Exception, URISyntaxException {

		// Read data from Excel

		String email = exUtil.readDataFromExcel("Sheet1", 2, 2);
		String password = exUtil.readDataFromExcel("Sheet1", 2, 7);
		System.out.println("Logging in with email: " + email);

		// Initialize welcome page
		AdminWelcomePage adminWelcomePage = new AdminWelcomePage(driver);

		boolean isLoggedOut;
		try {
			isLoggedOut = adminWelcomePage.getGetStartButton().isDisplayed();
		} catch (Exception e) {
			isLoggedOut = false;
		}

		if (!isLoggedOut) {
			WelcomePage welcomePage = new WelcomePage(driver);
			welcomePage.getLoginDropdown().click();
			welcomePage.getAdminButton().click();

			AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

			wait.until(ExpectedConditions.elementToBeClickable(adminLoginPage.getEmailIDTextfield())).click();
			adminLoginPage.getEmailIDTextfield().sendKeys(email);
			driver.hideKeyboard();

			wait.until(ExpectedConditions.elementToBeClickable(adminLoginPage.getPasswordTextfield())).click();
			adminLoginPage.getPasswordTextfield().sendKeys(password);
			driver.hideKeyboard();

			adminLoginPage.getLoginButton().click();

			TaskMasterOverviewPage taskMasterOverviewPage = new TaskMasterOverviewPage(driver);
			wait.until(ExpectedConditions.visibilityOf(taskMasterOverviewPage.getExploreButton())).click();
		}

		// Proceed from Get Started button
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(adminWelcomePage.getGetStartButton())).click();

		// Fill facility details
		ListYourFacilityPage listYourFacilityPage = new ListYourFacilityPage(driver);
		Assert.assertTrue(listYourFacilityPage.getListYourFacilityTextview().isDisplayed());

		String expectedLocation = "Bangalore";
		listYourFacilityPage.getFacilityNameTextfield().sendKeys("BathRoom");
		listYourFacilityPage.getLocationTextfield().sendKeys(expectedLocation);

		WebElement location = wait.until(ExpectedConditions.elementToBeClickable(
				AppiumBy.xpath("//android.view.View[contains(@content-desc,'" + expectedLocation + "')]")));
		location.click();

		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		listYourFacilityPage.getOfficeFacilityImage().click();
		listYourFacilityPage.getNextButton().click();

		// Assign task
		AdminAssignTaskPage taskPage = new AdminAssignTaskPage(driver);
		Assert.assertTrue(taskPage.gettaskTextview().isDisplayed());

		GestureUtility gUtil = new GestureUtility(driver);
		taskPage.getSelectCleaningTaskDropdown().click();

		String cleaningTask = "Toilet Cleaning   15 min";
		for (int i = 0; i < 5; i++) {
			List<WebElement> options = driver
					.findElements(AppiumBy.xpath("//android.widget.Button[@content-desc='" + cleaningTask + "']"));
			if (!options.isEmpty()) {
				options.get(0).click();
				break;
			}
			WebElement scrollView = driver
					.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc='Pantry Cleaning   15 min']"));
			gUtil.swipeByElement(scrollView, "up", 1.0);
			Thread.sleep(800);
		}
		taskPage.getOkButton().click();
		taskPage.getStartTimeButton().click();

		// Select shift start time
		StartTimePage shiftStartTimePage = new StartTimePage(driver);
		Assert.assertTrue(shiftStartTimePage.getSelectTimeTextView().isDisplayed());
		shiftStartTimePage.getSwitchTimeIcon().click();
		Assert.assertTrue(shiftStartTimePage.getEnterTimeTextView().isDisplayed());

		String hours = "10";
		String minutes = "30";
		String shift = "am";

		shiftStartTimePage.getHrsTextfield().clear();
		shiftStartTimePage.getHrsTextfield().sendKeys(hours);
		Thread.sleep(500);

		shiftStartTimePage.getMinTextfield().clear();
		shiftStartTimePage.getMinTextfield().sendKeys(minutes);
		Thread.sleep(500);

		if (shift.equalsIgnoreCase("am")) {
			shiftStartTimePage.getAmRadioButton().click();
		} else {
			shiftStartTimePage.getPmRadioButton().click();
		}
		shiftStartTimePage.getOkButton().click();

		// Schedule task timing using scroll pickers
		taskPage.getAddTimingsButton().click();
		ScheduleTaskTimingsPage addTimingsPage = new ScheduleTaskTimingsPage(driver);
		Assert.assertTrue(addTimingsPage.getScheduleTaskTextView().isDisplayed());

		// Locate time picker elements
		WebElement hourWheel = driver.findElement(AppiumBy.xpath(
				"//android.view.View[@content-desc='Schedule Task *']/parent::android.view.View/child::android.view.View[2]/descendant::android.view.View[5]"));
		WebElement minuteWheel = driver.findElement(AppiumBy.xpath(
				"//android.view.View[@content-desc='Schedule Task *']/parent::android.view.View/child::android.view.View[2]/descendant::android.view.View[10]"));
		WebElement meridiemWheel = driver.findElement(AppiumBy.xpath(
				"//android.view.View[@content-desc='Schedule Task *']/parent::android.view.View/child::android.view.View[2]/descendant::android.view.View[15]"));

		String expectedHour = hours; // Example: "10"
		String expectedMinute = minutes; // Example: "30"
		String expectedMeridiem = shift.toLowerCase(); // "am" or "pm"

		// --- Adjust Hour Wheel ---
		int maxTries = 20; // fail-safe to avoid infinite loop
		int tries = 0;
		while (tries++ < maxTries) {
			String currentHour = hourWheel.getAttribute("content-desc").trim();
			if (currentHour.equals(expectedHour))
				break;
			int currentHrInt = Integer.parseInt(currentHour);
			int expectedHrInt = Integer.parseInt(expectedHour);
			String direction = (expectedHrInt > currentHrInt) ? "up" : "down";
			gUtil.scrollOnElement(hourWheel, direction);
			Thread.sleep(500);
		}

		// --- Adjust Minute Wheel ---
		tries = 0;
		while (tries++ < maxTries) {
			String currentMinute = minuteWheel.getAttribute("content-desc").trim();
			if (currentMinute.equals(expectedMinute))
				break;
			int currentMinInt = Integer.parseInt(currentMinute);
			int expectedMinInt = Integer.parseInt(expectedMinute);
			String direction = (expectedMinInt > currentMinInt) ? "up" : "down";
			gUtil.scrollOnElement(minuteWheel, direction);
			Thread.sleep(500);
		}

		// --- Adjust AM/PM Wheel ---
		tries = 0;
		while (tries++ < maxTries) {
			String currentMeridiem = meridiemWheel.getAttribute("content-desc").trim().toLowerCase();
			if (currentMeridiem.equals(expectedMeridiem))
				break;
			gUtil.scrollOnElement(meridiemWheel, "up"); // Usually AM/PM is just toggled
			Thread.sleep(500);
		}

		// Click Add and proceed
		addTimingsPage.getAddButton().click();
		taskPage.getNextButton().click();
	}

	@Test
	public void checkTheContextView() throws Throwable {

		String email = exUtil.readDataFromExcel("Sheet1", 2, 2);
		String password = exUtil.readDataFromExcel("Sheet1", 2, 7);
		System.out.println(email);

		AdminWelcomePage adminWelcomePage = new AdminWelcomePage(driver);

		boolean isLoggedOut;

		try {
			isLoggedOut = adminWelcomePage.getGetStartButton().isDisplayed();
		} catch (Exception e) {
			isLoggedOut = false;
		}

		if (!isLoggedOut) {
			WelcomePage welcomePage = new WelcomePage(driver);
			welcomePage.getLoginDropdown().click();
			welcomePage.getAdminButton().click();

			AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
			Thread.sleep(1000);
			adminLoginPage.getEmailIDTextfield().click();
			adminLoginPage.getEmailIDTextfield().sendKeys("tester573@gmail.com");
			driver.hideKeyboard();

			Thread.sleep(1000);
			adminLoginPage.getPasswordTextfield().click();
			adminLoginPage.getPasswordTextfield().sendKeys(password);
			driver.hideKeyboard();

			Thread.sleep(1000);
			adminLoginPage.getLoginButton().click();

			Thread.sleep(1000);
			TaskMasterOverviewPage taskMasterOverviewPage = new TaskMasterOverviewPage(driver);
			Assert.assertTrue(taskMasterOverviewPage.getExploreButton().isDisplayed());
			taskMasterOverviewPage.getExploreButton().click();
		}

		Assert.assertTrue(adminWelcomePage.getGetStartButton().isDisplayed());
		adminWelcomePage.getGetStartButton().click();

		ListYourFacilityPage listYourFacilityPage = new ListYourFacilityPage(driver);
		Assert.assertTrue(listYourFacilityPage.getListYourFacilityTextview().isDisplayed());

		String expectedLocation = "Bangalore";
		listYourFacilityPage.getFacilityNameTextfield().click();
		listYourFacilityPage.getFacilityNameTextfield().sendKeys("BathRoom");
		listYourFacilityPage.getLocationTextfield().click();
		listYourFacilityPage.getLocationTextfield().sendKeys(expectedLocation);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement location = wait.until(ExpectedConditions.elementToBeClickable(
				AppiumBy.xpath("//android.view.View[contains(@content-desc,'" + expectedLocation + "')]")));
		location.click();

		driver.pressKey(new KeyEvent(AndroidKey.BACK)); // Android only
		listYourFacilityPage.getOfficeFacilityImage().click();
		listYourFacilityPage.getNextButton().click();

		// Task creation
		AdminAssignTaskPage taskPage = new AdminAssignTaskPage(driver);
		Assert.assertTrue(taskPage.gettaskTextview().isDisplayed());

		GestureUtility gUtil = new GestureUtility(driver);

		taskPage.getSelectCleaningTaskDropdown().click();

		// scroll till the element visible
		String cleaning = "Toilet Cleaning   15 min";

		for (int i = 0; i < 5; i++) {
			List<WebElement> options = driver
					.findElements(AppiumBy.xpath("//android.widget.Button[@content-desc='" + cleaning + "']"));
			if (!options.isEmpty()) {
				options.get(0).click();
				break;
			}
			WebElement scrollView = driver
					.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Pantry Cleaning   15 min\"]"));
			gUtil.swipeByElement(scrollView, "up", 1.0);// custom method
			Thread.sleep(800);
		}
		taskPage.getOkButton().click();
		taskPage.getStartTimeButton().click();

		// Time selection
		StartTimePage shiftStartTimePage = new StartTimePage(driver);
		Assert.assertTrue(shiftStartTimePage.getSelectTimeTextView().isDisplayed());
		shiftStartTimePage.getSwitchTimeIcon().click();

		Assert.assertTrue(shiftStartTimePage.getEnterTimeTextView().isDisplayed());

		String hours = "10";
		String minutes = "30";
		String shift = "am";

		// Entering time manually
		shiftStartTimePage.getHrsTextfield().click();
		shiftStartTimePage.getHrsTextfield().clear();
		shiftStartTimePage.getHrsTextfield().sendKeys(hours);
		Thread.sleep(500);
		shiftStartTimePage.getMinTextfield().clear();
		shiftStartTimePage.getMinTextfield().sendKeys(minutes);
		Thread.sleep(500);

		if (shift.equals("am")) {
			shiftStartTimePage.getAmRadioButton().click();
		} else {
			shiftStartTimePage.getPmRadioButton().click();
		}
		shiftStartTimePage.getOkButton().click();

		// Add timings
		taskPage.getAddTimingsButton().click();
		ScheduleTaskTimingsPage addTimingsPage = new ScheduleTaskTimingsPage(driver);
		Assert.assertTrue(addTimingsPage.getScheduleTaskTextView().isDisplayed());

		// Scroll wheel pickers
		WebElement hourWheel = driver.findElement(AppiumBy.xpath(
				"//android.view.View[@content-desc=\"Schedule Task *\"]/parent::android.view.View/child::android.view.View[2]/descendant::android.view.View[5]"));
		WebElement minuteWheel = driver.findElement(AppiumBy.xpath(
				"//android.view.View[@content-desc=\"Schedule Task *\"]/parent::android.view.View/child::android.view.View[2]/descendant::android.view.View[10]"));
		WebElement meridiem = driver.findElement(AppiumBy.xpath(
				"//android.view.View[@content-desc=\"Schedule Task *\"]/parent::android.view.View/child::android.view.View[2]/descendant::android.view.View[15]"));

		// Scroll hour
		String currentHour = hourWheel.getAttribute("content-desc").trim();
		int currentHr = Integer.parseInt(currentHour);
		int expectedHr = Integer.parseInt(hours);
		int diffHr = expectedHr - currentHr;
		System.out.println(diffHr);

		for (int i = 0; i < Math.abs(diffHr); i++) {
			gUtil.scrollOnElement(hourWheel, diffHr > 0 ? "up" : "down");
			Thread.sleep(600);
		}

		// Scroll minute
		String currentMin = minuteWheel.getAttribute("content-desc").trim();
		int currentMinute = Integer.parseInt(currentMin);
		int expectedMinute = Integer.parseInt(minutes);
		int diffMin = expectedMinute - currentMinute;
		System.out.println(diffMin);

		for (int i = 0; i < Math.abs(diffMin); i++) {
			gUtil.scrollOnElement(minuteWheel, diffMin > 0 ? "up" : "down");
			Thread.sleep(600);
		}

		// Scroll AM/PM
		String currentMeridiem = meridiem.getAttribute("content-desc").trim().toLowerCase();
		if (!currentMeridiem.equals(shift)) {
			gUtil.scrollOnElement(meridiem, shift.equals("am") ? "down" : "up");
		}

		addTimingsPage.getAddButton().click();

		taskPage.getNextButton().click();
	}

}
