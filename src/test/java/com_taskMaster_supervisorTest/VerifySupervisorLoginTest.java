package com_taskMaster_supervisorTest;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.FileUtility;
import com_taskMaster_objectRepo_Supervisor.SupervisorAccountPage;
import com_taskMaster_objectRepo_Supervisor.SupervisorHomePage;
import com_taskMaster_objectRepo_Supervisor.SupervisorLoginPage;
import com_taskMaster_objectRepo_Supervisor.SupervisorOTPVerficationPage;
import com_taskMaster_objectRepo_Supervisor.WelcomePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

//@Listeners(ListenerImpUtility.class)
public class VerifySupervisorLoginTest {
	@Test
	public void adminLoginTest() throws URISyntaxException, InterruptedException, Exception {

		FileUtility fUtil=new FileUtility();
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("platformName", fUtil.dataFromPropertiesFile("platformName"));
		capabilities.setCapability("automationName", fUtil.dataFromPropertiesFile("automationName"));
		capabilities.setCapability("app", fUtil.dataFromPropertiesFile("app"));
		capabilities.setCapability("deviceName", fUtil.dataFromPropertiesFile("deviceName"));
		capabilities.setCapability("appPackage", fUtil.dataFromPropertiesFile("appPackage"));
		capabilities.setCapability("appActivity", fUtil.dataFromPropertiesFile("appActivity"));
		capabilities.setCapability("autoGrantPermission", true);
		capabilities.setCapability("noReset", true);
		capabilities.setCapability("ignoreHiddenApiPolicyError", true);

		AndroidDriver driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), capabilities);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		/* Select Supervisor from Drop down */
		driver.activateApp("com.woloo.smarthygiene");

		WelcomePage welcomePage = new WelcomePage(driver);
		welcomePage.getLoginDropdown().click();
		welcomePage.getSupervisorButton().click();

		/* Enter valid Mobile number to login */
		SupervisorLoginPage supervisorLoginPage = new SupervisorLoginPage(driver);
		supervisorLoginPage.getSelectLanguageButton().click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement mobileNumTextfield = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText")));
		mobileNumTextfield.click();
		Thread.sleep(1000);
		driver.hideKeyboard();
		mobileNumTextfield.sendKeys("7975433721", Keys.ENTER);
		Thread.sleep(2000);
		supervisorLoginPage.getSendOTPButton().click();

		/* Validate OTP */
		SupervisorOTPVerficationPage supervisorOTPVerficationPage = new SupervisorOTPVerficationPage(driver);
		Thread.sleep(2000);
		supervisorOTPVerficationPage.getOtpTextfield().click();
		driver.hideKeyboard();
		Thread.sleep(1000);
		supervisorOTPVerficationPage.getOtpTextfield().sendKeys("1234", Keys.ENTER);
		Thread.sleep(1000);
		supervisorOTPVerficationPage.getSubmitButton().click();
		Thread.sleep(1000);
		boolean actualResult = driver.findElement(AppiumBy.accessibilityId("Hello, Tadmin ")).isDisplayed();
		Assert.assertEquals(actualResult, true);

		/* Logout */
		SupervisorHomePage supervisorHomePage = new SupervisorHomePage(driver);
		supervisorHomePage.getAccountButton().click();
		Thread.sleep(1000);
		SupervisorAccountPage supervisorAccountPage = new SupervisorAccountPage(driver);
		supervisorAccountPage.getLogoutButton().click();
		
		driver.terminateApp("com.woloo.smarthygiene");

	}

}
