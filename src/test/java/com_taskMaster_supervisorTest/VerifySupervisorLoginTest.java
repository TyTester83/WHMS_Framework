package com_taskMaster_supervisorTest;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com_taskMaster_ObjectRepo.SupervisorLoginPage;
import com_taskMaster_ObjectRepo.SupervisorOTPVerficationPage;
import com_taskMaster_ObjectRepo.WelcomePage;
import io.appium.java_client.android.AndroidDriver;

public class VerifySupervisorLoginTest {
	@Test
	public void adminLoginTest() throws MalformedURLException, URISyntaxException, InterruptedException {

		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability("platformName", "android");
		caps.setCapability("automationName", "UiAutomator2");
		caps.setCapability("UDID", "UK8545P7JV9SZ9SO");
//		caps.setCapability("appPackage", "com.woloo.smarthygiene");
//		caps.setCapability("appActivity", "com.woloo.smarthygiene.MainActivity");
		caps.setCapability("ignoreHiddenApiPolicyError", true);
		caps.setCapability("noReset", true);
		caps.setCapability("autoGrantPermission", true);
		caps.setCapability("autoAcceptAlerts", true);

		AndroidDriver driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), caps);
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
		Thread.sleep(1000);
		supervisorOTPVerficationPage.getOtpTextfield().click();
		driver.hideKeyboard();
		Thread.sleep(1000);
		supervisorOTPVerficationPage.getOtpTextfield().sendKeys("1234", Keys.ENTER);
		Thread.sleep(1000);
		supervisorOTPVerficationPage.getSubmitButton().click();

		

	}

}
