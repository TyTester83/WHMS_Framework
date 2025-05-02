package com_taskMaster_TaskBuddy;

import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.BaseClass;
import com_taskMaster_supervisorRepo.WelcomePage;
import com_taskMaster_taskBuddyRepo.TaskBuddyDashboardPage;
import com_taskMaster_taskBuddyRepo.TaskBuddyLanguagePopup;
import com_taskMaster_taskBuddyRepo.TaskBuddyLoginPage;
import com_taskMaster_taskBuddyRepo.TaskBuddyOTPPage;
import io.appium.java_client.AppiumBy;

public class TaskBuddyLoginTest extends BaseClass {

	@Test
	public void verifyTaskBuddyLoginTest() throws Exception, URISyntaxException {

		/* Select User from Drop down */

		WelcomePage welcomePage = new WelcomePage(driver);
		welcomePage.getLoginDropdown().click();
		welcomePage.getTaskBuddyButton().click();

		/* Enter task buddy login credentials */

		TaskBuddyLanguagePopup languagePopup = new TaskBuddyLanguagePopup(driver);
		languagePopup.getLanguagePopup().isDisplayed();
		languagePopup.getEnglishButton().click();

		TaskBuddyLoginPage loginPage = new TaskBuddyLoginPage(driver);
		loginPage.getMobileNumberTextfield().click();
		Thread.sleep(2000);
		driver.hideKeyboard();
		loginPage.getMobileNumberTextfield().sendKeys("7975433721");
		Thread.sleep(1000);
		loginPage.getSendOTPButton().click();

		/* Enter OTP to login task buddy page */

		TaskBuddyOTPPage otpPage = new TaskBuddyOTPPage(driver);
		
		Thread.sleep(2000);
		otpPage.getOtpTextfield().click();
		otpPage.getOtpTextfield().sendKeys("1234");
		driver.hideKeyboard();
		otpPage.getSubmitButton().click();
		
		/* Validate the user login */
		
		List<String> options = Arrays.asList("Allow only while using the app", "Allow", "While using the app");

		for (String option : options) {
		    List<WebElement> allowButtons = driver.findElements(AppiumBy.xpath("//*[@text='" + option + "']"));
		    if (!allowButtons.isEmpty()) {
		        allowButtons.get(0).click();
		        break;
		    }
		}
		String taskBuddy="janitor";
		TaskBuddyDashboardPage taskBuddyHomepage=new TaskBuddyDashboardPage(driver);
		String actualResults = taskBuddyHomepage.getProfileNameTextview().getAttribute("content-desc");
		Assert.assertEquals(actualResults.trim().contains(taskBuddy), true);

	}
}
