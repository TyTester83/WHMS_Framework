package com_taskMaster_supervisorTest;

import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.BaseClass;
import com_taskMaster_supervisorRepo.SupervisorAccountPage;
import com_taskMaster_supervisorRepo.SupervisorDashboardPage;
import com_taskMaster_supervisorRepo.SupervisorLoginPage;
import com_taskMaster_supervisorRepo.SupervisorOTPVerficationPage;
import com_taskMaster_supervisorRepo.WelcomePage;

//@Listeners(ListenerImpUtility.class)
public class SupervisorLoginTest extends BaseClass {
	@Test
	public void verifySupervisorLoginWithValidOTPTest() throws URISyntaxException, InterruptedException, Exception {

		/* Select Supervisor from Drop down */

		WelcomePage welcomePage = new WelcomePage(driver);
		welcomePage.getLoginDropdown().click();
		welcomePage.getSupervisorButton().click();

		/* Enter valid Mobile number to login */
		SupervisorLoginPage supervisorLoginPage = new SupervisorLoginPage(driver);
		supervisorLoginPage.getSelectLanguageButton().click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement mobileNumTextfield = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText[@index=1]")));
		mobileNumTextfield.click();
		Thread.sleep(1000);
		driver.hideKeyboard();
		mobileNumTextfield.sendKeys("9626409660");
		Thread.sleep(2000);
		supervisorLoginPage.getSendOTPButton().click();

		/* Validate Supervisor with valid OTP */
		SupervisorOTPVerficationPage supervisorOTPVerficationPage = new SupervisorOTPVerficationPage(driver);
		supervisorOTPVerficationPage.getOtpTextfield().click();
		driver.hideKeyboard();
		Thread.sleep(2000);
		supervisorOTPVerficationPage.getOtpTextfield().sendKeys("1234");
		Thread.sleep(1000);
		supervisorOTPVerficationPage.getSubmitButton().click();

		String supervisorName="Iniya";
		SupervisorDashboardPage supervisorHomePage = new SupervisorDashboardPage(driver);
		String actualResults=supervisorHomePage.getSupervisorNameTextview().getAttribute("content-desc").trim();
		Assert.assertEquals(actualResults.contains(supervisorName), true);

		/* Logout */

		supervisorHomePage.getAccountButton().click();
		Thread.sleep(1000);
		SupervisorAccountPage supervisorAccountPage = new SupervisorAccountPage(driver);
		supervisorAccountPage.getLogoutButton().click();

		Assert.assertEquals(supervisorLoginPage.getSelectLanguageButton().isDisplayed(), true);

	}

	@Test
	public void verifySupervisorLoginWithInValidOTPTest() throws URISyntaxException, InterruptedException, Exception {

		/* Select Supervisor from Drop down */

		WelcomePage welcomePage = new WelcomePage(driver);
		welcomePage.getLoginDropdown().click();
		welcomePage.getSupervisorButton().click();

		/* Enter valid Mobile number to login */
		SupervisorLoginPage supervisorLoginPage = new SupervisorLoginPage(driver);
		supervisorLoginPage.getSelectLanguageButton().click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement mobileNumTextfield = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText[@index=1]")));
		mobileNumTextfield.click();
		Thread.sleep(1000);
		driver.hideKeyboard();
		mobileNumTextfield.sendKeys("9626409660");
		Thread.sleep(2000);
		supervisorLoginPage.getSendOTPButton().click();

		/* Validate Superviosr with valid OTP */
		SupervisorOTPVerficationPage supervisorOTPVerficationPage = new SupervisorOTPVerficationPage(driver);
		supervisorOTPVerficationPage.getOtpTextfield().click();
		driver.hideKeyboard();
		Thread.sleep(2000);
		supervisorOTPVerficationPage.getOtpTextfield().sendKeys("2345");
		Thread.sleep(1000);
		supervisorOTPVerficationPage.getSubmitButton().click();

		Assert.assertEquals(supervisorOTPVerficationPage.getSubmitButton().isDisplayed(), true);

	}

	@Test
	public void verfifySupervisorLoginWithEmptyMobileFieldTest()
			throws URISyntaxException, InterruptedException, Exception {

		/* Select Supervisor from Drop down */

		WelcomePage welcomePage = new WelcomePage(driver);
		welcomePage.getLoginDropdown().click();
		welcomePage.getSupervisorButton().click();

		/* Enter valid Mobile number to login */
		SupervisorLoginPage supervisorLoginPage = new SupervisorLoginPage(driver);
		supervisorLoginPage.getSelectLanguageButton().click();

		supervisorLoginPage.getSendOTPButton().click();

		/* Validate the Error message */
		Assert.assertEquals(supervisorLoginPage.getMobileNumErrorMessageText().isDisplayed(), true);

	}

}
