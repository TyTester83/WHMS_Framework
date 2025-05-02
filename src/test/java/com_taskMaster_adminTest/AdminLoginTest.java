package com_taskMaster_adminTest;

import java.io.IOException;
import java.net.URISyntaxException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.BaseClass;
import com_taskMaster_adminRepo.AdminHomePage;
import com_taskMaster_adminRepo.AdminLoginPage;
import com_taskMaster_adminRepo.AdminProfilePage;
import com_taskMaster_supervisorRepo.WelcomePage;

public class AdminLoginTest extends BaseClass {

	@Test(priority = 2)
	public void verifyAdminLoginWithInvalidCredentialsTest()
			throws URISyntaxException, IOException, InterruptedException {

		/* Select Admin from Drop down */

		WelcomePage welcomePage = new WelcomePage(driver);
		welcomePage.getLoginDropdown().click();
		welcomePage.getAdminButton().click();

		/* Admin Login page */

		AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
		Thread.sleep(1000);
		adminLoginPage.getEmailIDTextfield().click();
		driver.hideKeyboard();
		Thread.sleep(1000);
		adminLoginPage.getEmailIDTextfield().sendKeys("dilipvinoth94@gmail.com");

		Thread.sleep(1000);
		adminLoginPage.getPasswordTextfield().click();
		driver.hideKeyboard();
		Thread.sleep(1000);
		adminLoginPage.getPasswordTextfield().sendKeys("pass1234");
		adminLoginPage.getLoginButton().click();

		/* validate the invalid admin login */
		Assert.assertEquals(adminLoginPage.getLoginButton().isDisplayed(), true);

	}
	
	@Test(priority = 1)
	public void verifyAdminLoginWithEmptyFieldTest()
			throws URISyntaxException, IOException, InterruptedException {

		/* Select Admin from Drop down */

		WelcomePage welcomePage = new WelcomePage(driver);
		welcomePage.getLoginDropdown().click();
		welcomePage.getAdminButton().click();

		/* Admin Login page */

		AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
		adminLoginPage.getLoginButton().click();

		/* validate the empty field with login */
		Assert.assertEquals(adminLoginPage.getEmailErrorMessage().isDisplayed(), true);
		Assert.assertEquals(adminLoginPage.getPasswordErrorMessage().isDisplayed(), true);

	}

	@Test(priority = 3)
	public void verifyLogout() throws Exception {
		/* Select Admin from Drop down */

		WelcomePage welcomePage = new WelcomePage(driver);
		welcomePage.getLoginDropdown().click();
		welcomePage.getAdminButton().click();

		/* Admin Login page */

		AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
		Thread.sleep(1000);
		adminLoginPage.getEmailIDTextfield().click();
		driver.hideKeyboard();
		Thread.sleep(1000);
		adminLoginPage.getEmailIDTextfield().sendKeys("iniya@gmail.com");

		Thread.sleep(1000);
		adminLoginPage.getPasswordTextfield().click();
		driver.hideKeyboard();
		Thread.sleep(1000);
		adminLoginPage.getPasswordTextfield().sendKeys("password");

		driver.hideKeyboard();
		adminLoginPage.getLoginButton().click();

		/* Validate the admin login */

		AdminHomePage adminHomePage = new AdminHomePage(driver);
		Assert.assertEquals(adminHomePage.getAdminDashboardText().isDisplayed(), true);

		/* Logout */
		Thread.sleep(3000);
		adminHomePage.getProfileTab().click();
		AdminProfilePage adminProfilePage = new AdminProfilePage(driver);
		adminProfilePage.getLogoutButton().click();

		Thread.sleep(2000);
		adminProfilePage.getYesButton().click();

		/* Validate the logout */

		Assert.assertEquals(welcomePage.getLoginDropdown().isDisplayed(), true);
	}

}
