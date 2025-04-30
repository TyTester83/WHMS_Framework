package com_taskMaster_adminTest;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

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
	public void verfiyListYourFacilityPageTest() throws EncryptedDocumentException, IOException, InterruptedException {
		String name = exUtil.readDataFromExcel("Sheet1", 2, 1);
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
		String name = exUtil.readDataFromExcel("Sheet1", 2, 1);
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
		boolean actFacilityPage = listYourFacilityPage.getListYourFacilityTextview().isDisplayed();
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
		driver.pressKey(new KeyEvent(AndroidKey.BACK));// this one for android
		listYourFacilityPage.getOfficeFacilityImage().click();
		listYourFacilityPage.getNextButton().click();

		/* Navigate to assign task page and create task for janitor */

		AdminAssignTaskPage taskPage = new AdminAssignTaskPage(driver);

		boolean actTaskPage = taskPage.gettaskTextview().isDisplayed();
		Assert.assertEquals(actTaskPage, true);

		taskPage.getSelectCleaningTaskDropdown().click();
		String cleaning = "Pantry Cleaning   15 min";

		driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc='" + cleaning + "']")).click();

		taskPage.getOkButton().click();
		taskPage.getStartTimeButton().click();

		StartTimePage shiftStartTimePage = new StartTimePage(driver);
		boolean actSelectTimePage = shiftStartTimePage.getSelectTimeTextView().isDisplayed();
		Assert.assertEquals(actSelectTimePage, true);

		shiftStartTimePage.getSwitchTimeIcon().click();

		/* Enter the time for Shift */

		boolean actEnterTimePage = shiftStartTimePage.getEnterTimeTextView().isDisplayed();
		Assert.assertEquals(actEnterTimePage, true);

		String hours = "10";
		String minutes = "30";
		String shift = "am";

		shiftStartTimePage.getHrsTextfield().click();
		shiftStartTimePage.getHrsTextfield().clear();
		shiftStartTimePage.getHrsTextfield().sendKeys(hours);

		shiftStartTimePage.getMinTextfield().clear();
		Thread.sleep(1000);
		shiftStartTimePage.getMinTextfield().sendKeys(minutes);

		if (shift.equals("am")) {
			shiftStartTimePage.getAmRadioButton().click();
		}

		else {
			shiftStartTimePage.getPmRadioButton().click();
		}

		shiftStartTimePage.getOkButton().click();

		/* Add task timings */

		taskPage.getAddTimingsButton().click();

		ScheduleTaskTimingsPage addTimingsPage = new ScheduleTaskTimingsPage(driver);
		boolean actScheduleTaskText = addTimingsPage.getScheduleTaskTextView().isDisplayed();
		Assert.assertEquals(actScheduleTaskText, true);

		/* Scroll hour wheel */
		
		WebElement hourWheel = driver.findElement(AppiumBy.xpath(
				"//android.view.View[@content-desc=\"Schedule Task *\"]/parent::android.view.View/child::android.view.View[2]/descendant::android.view.View[5]"));
		WebElement minuteWheel = driver.findElement(AppiumBy.xpath(
				"//android.view.View[@content-desc=\"Schedule Task *\"]/parent::android.view.View/child::android.view.View[2]/descendant::android.view.View[10]"));

		GestureUtility gUtil = new GestureUtility(driver);

		String currentHour = hourWheel.getAttribute("content-desc");
//		while (!currentHour.trim().equals(hours)) {
//			currentHour = hourWheel.getAttribute("content-desc");
//			if (currentHour.equals(hours))
//				break;
//			gUtil.scrollOnElement(hourWheel, "up");
//			Thread.sleep(1000);
//		}

		System.out.println(currentHour);
		int n=0;
		int expectHours=10;
		if(Integer.parseInt(currentHour)>expectHours)
		{
			n=Integer.parseInt(currentHour)-expectHours;
		}
		else
		{
			n=expectHours-Integer.parseInt(currentHour);
		}
		
		for(int i=1;i<=6;i++)
		{
			gUtil.scrollOnElement(hourWheel, "up");
			Thread.sleep(1000);
			
		}
//		/* Scroll minute wheel */
//		
//		String currentMinute = minuteWheel.getAttribute("content-desc");
//		while (!currentMinute.trim().equals(minutes)) {
//			currentMinute = minuteWheel.getAttribute("content-desc");
//			if (currentMinute.equals("45"))
//				break;
//			gUtil.scrollOnElement(minuteWheel, "up");
//			Thread.sleep(500);
//		}
//
//		WebElement meridiem = driver.findElement(AppiumBy.xpath(
//				"//android.view.View[@content-desc=\"Schedule Task *\"]/parent::android.view.View/child::android.view.View[2]/descendant::android.view.View[15]"));
//
//		String currentMeridiem=meridiem.getAttribute("content-desc");
//		String actShift="AM";
//		if(currentMeridiem.trim().equals("PM")&&actShift.equals("AM"))
//		{
//			gUtil.scrollOnElement(meridiem, "down");
//		}
//		else
//		{
//			gUtil.scrollOnElement(meridiem, "up");
//		}
	}
	@Test
	public void checkTheContextView() throws Throwable
	{
		
		String name = exUtil.readDataFromExcel("Sheet1", 2, 1);
		String email = exUtil.readDataFromExcel("Sheet1", 2, 2);
		String password = exUtil.readDataFromExcel("Sheet1", 2, 7);

		AdminWelcomePage adminWelcomePage = new AdminWelcomePage(driver);
		driver.activateApp("com.woloo.smarthygiene");

		// Check if already logged in
		if (!adminWelcomePage.getGetStartButton().isDisplayed()) {
		    WelcomePage welcomePage = new WelcomePage(driver);
		    welcomePage.getLoginDropdown().click();
		    welcomePage.getAdminButton().click();

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
		
		//scroll till the element visible
		String cleaning = "Toilet Cleaning   15 min";

		for (int i = 0; i < 5; i++) {
		    List<WebElement> options = driver.findElements(AppiumBy.xpath("//android.widget.Button[@content-desc='" + cleaning + "']"));
		    if (!options.isEmpty()) {
		        options.get(0).click();
		        break;
		    }
			WebElement scrollView = driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Pantry Cleaning   15 min\"]"));
		    gUtil.swipeByElement(scrollView, "up", 1.0) ;// custom method
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
