package com_taskMaster_adminTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.BaseClass;
import com_taskMaster_adminRepo.AdminLoginPage;
import com_taskMaster_supervisorRepo.SupervisorLoginPage;
import com_taskMaster_supervisorRepo.WelcomePage;
import com_taskMaster_taskBuddyRepo.TaskBuddyLoginPage;

public class WelcomePageTest extends BaseClass {

	@Test
	public void verifyAdminOptionSelectionDropdown() {

		/* Validate the WelcomePage Login as */

		WelcomePage welcomePage = new WelcomePage(driver);
		Assert.assertEquals(welcomePage.getLoginDropdown().isDisplayed(), true);

		/* validate the dropdown option */

		welcomePage.getLoginDropdown().click();
		Assert.assertEquals(welcomePage.getAdminButton().isDisplayed(), true);
		welcomePage.getAdminButton().click();

		/* Validate the proper admin Login page is displayed */

		AdminLoginPage adminLoginPage = new AdminLoginPage(driver);

		Assert.assertEquals(adminLoginPage.getEmailIDTextfield().isDisplayed(), true);
		Assert.assertEquals(adminLoginPage.getPasswordTextfield().isDisplayed(), true);
		Assert.assertEquals(adminLoginPage.getLoginButton().isDisplayed(), true);
		Assert.assertEquals(adminLoginPage.getRegisterNowLink().isDisplayed(), true);

	}

	@Test
	public void verifySupervisorOptionSelectionDropdown() {

		/* Validate the WelcomePage Login as */

		WelcomePage welcomePage = new WelcomePage(driver);
		Assert.assertEquals(welcomePage.getLoginDropdown().isDisplayed(), true);

		/* validate the dropdown option */

		welcomePage.getLoginDropdown().click();
		Assert.assertEquals(welcomePage.getSupervisorButton().isDisplayed(), true);
		welcomePage.getSupervisorButton().click();
		
		SupervisorLoginPage supervisorLoginPage = new SupervisorLoginPage(driver);
		Assert.assertEquals(supervisorLoginPage.getSelectLanguageButton().isDisplayed(), true);
		supervisorLoginPage.getSelectLanguageButton().click();
		
		/* Validate the proper supervisor login page is displayed */
		
		Assert.assertEquals(supervisorLoginPage.getSupervisorMobileNumberTextfield().isDisplayed(), true);
		Assert.assertEquals(supervisorLoginPage.getSendOTPButton().isDisplayed(), true);

	}

	@Test
	public void verifyTaskBuddyOptionSelectionDropdown() {

		/* Validate the WelcomePage Login as */

		WelcomePage welcomePage = new WelcomePage(driver);
		Assert.assertEquals(welcomePage.getLoginDropdown().isDisplayed(), true);

		/* validate the dropdown option */

		welcomePage.getLoginDropdown().click();
		Assert.assertEquals(welcomePage.getTaskBuddyButton().isDisplayed(), true);
		welcomePage.getSupervisorButton().click();
		
		TaskBuddyLoginPage taskBuddyLogin=new TaskBuddyLoginPage(driver);
		Assert.assertEquals(taskBuddyLogin.getSelectLanguageButton().isDisplayed(), true);
		taskBuddyLogin.getSelectLanguageButton().click();
		
		/* Validate the proper supervisor login page is displayed */
		
		Assert.assertEquals(taskBuddyLogin.getMobileNumberTextfield().isDisplayed(), true);
		Assert.assertEquals(taskBuddyLogin.getSendOTPButton().isDisplayed(), true);

	}
}
