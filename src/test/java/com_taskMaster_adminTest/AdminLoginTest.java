package com_taskMaster_adminTest;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.BaseClass;
import com_taskMaster_AdminRepo.AdminHomePage;
import com_taskMaster_AdminRepo.AdminLoginPage;
import com_taskMaster_AdminRepo.AdminProfilePage;
import com_taskMaster_objectRepo_Supervisor.WelcomePage;
import io.appium.java_client.android.Activity;

public class AdminLoginTest extends BaseClass {

	@Test
	public void verifyAdminLoginTest() throws URISyntaxException, IOException, InterruptedException {

		/* Select Admin from Drop down */

		WelcomePage welcomePage = new WelcomePage(driver);
		welcomePage.getLoginDropdown().isDisplayed();
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

		/* Logout */
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement profileTab = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//android.widget.ImageView[contains(@content-desc, 'Profile')]")));
		profileTab.click();

		AdminProfilePage adminProfilePage = new AdminProfilePage(driver);
		adminProfilePage.getLogoutButton().click();

	}

	@Test
	public void verifyAdminLoginWithInvalidCredentialsTest()
			throws URISyntaxException, IOException, InterruptedException {

		/* Select Admin from Drop down */

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

		/* validate the invalid admin login */
		boolean actualResults = adminLoginPage.getLoginButton().isDisplayed();
		Assert.assertEquals(actualResults, true);

	}

	@Test
	public void verifyLogout() throws Exception {

		Activity activity = new Activity(fUtil.dataFromPropertiesFile("appPackage"),
				fUtil.dataFromPropertiesFile("appActivity"));
		activity.setAppWaitPackage(fUtil.dataFromPropertiesFile("appPackage"));
		activity.setAppWaitActivity(fUtil.dataFromPropertiesFile("appActivity"));

		// Start the activity
		driver.startActivity(activity);

		/* Logout */
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement profileTab = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//android.widget.ImageView[contains(@content-desc, 'Profile')]")));
		profileTab.click();

		AdminProfilePage adminProfilePage = new AdminProfilePage(driver);
		adminProfilePage.getLogoutButton().click();
	}

}
