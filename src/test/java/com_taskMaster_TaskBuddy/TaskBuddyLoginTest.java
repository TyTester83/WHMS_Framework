package com_taskMaster_TaskBuddy;

import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.BaseClass;
import com_taskMaster_supervisorRepo.WelcomePage;
import com_taskMaster_taskBuddyRepo.TaskBuddyDashboardPage;
import com_taskMaster_taskBuddyRepo.TaskBuddyLanguagePopup;
import com_taskMaster_taskBuddyRepo.TaskBuddyLoginPage;
import com_taskMaster_taskBuddyRepo.TaskBuddyOTPPage;

public class TaskBuddyLoginTest extends BaseClass {

	@Test
	public void verifyTaskBuddyLoginTest() throws Exception, URISyntaxException {

		/* Select User from Drop down */

		WelcomePage welcomePage = new WelcomePage(driver);
		welcomePage.getLoginDropdown().click();
		welcomePage.getTaskBuddyButton().click();

		/* Enter taskbuddy login credentials */

		TaskBuddyLanguagePopup languagePopup = new TaskBuddyLanguagePopup(driver);
		languagePopup.getLanguagePopup().isDisplayed();
		languagePopup.getEnglishButton().click();

		TaskBuddyLoginPage loginPage = new TaskBuddyLoginPage(driver);
		loginPage.getMobileNumberTextfield().click();
		loginPage.getMobileNumberTextfield().sendKeys("9845200005");
		driver.hideKeyboard();
		loginPage.getSendOTPButton().click();

		/* Enter Otp to login taskbuddy page */

		TaskBuddyOTPPage otpPage = new TaskBuddyOTPPage(driver);
		
		Thread.sleep(3000);
		otpPage.getOtpTextfield().click();
		otpPage.getOtpTextfield().sendKeys("1234");
		driver.hideKeyboard();
		otpPage.getSubmitButton().click();
		
		/* Validate the user login */
		
		TaskBuddyDashboardPage taskBuddyHomepage=new TaskBuddyDashboardPage(driver);
		boolean actualResults = taskBuddyHomepage.getMyDashboardTextview().isDisplayed();
		Assert.assertEquals(actualResults, true);

	}
}
