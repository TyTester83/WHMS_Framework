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
import org.testng.Assert;
import org.testng.annotations.Test;

import com_taskMaster_objectRepo_Supervisor.ClusterPage;
import com_taskMaster_objectRepo_Supervisor.SupervisorAccountPage;
import com_taskMaster_objectRepo_Supervisor.SupervisorHomePage;
import com_taskMaster_objectRepo_Supervisor.SupervisorLoginPage;
import com_taskMaster_objectRepo_Supervisor.SupervisorOTPVerficationPage;
import com_taskMaster_objectRepo_Supervisor.WelcomePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;

public class VerifyClusterFunctionalityTest {
	@Test
	public void clusterFunctionalityTest() throws MalformedURLException, URISyntaxException, InterruptedException {
		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability("platformName", "android");
		caps.setCapability("automationName", "UiAutomator2");
		caps.setCapability("UDID", "UK8545P7JV9SZ9SO");
		caps.setCapability("ignoreHiddenApiPolicyError", true);
		caps.setCapability("noReset", true);
		caps.setCapability("autoGrantPermission", true);
		caps.setCapability("autoAcceptAlerts", true);

		AndroidDriver driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), caps);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		Activity activity = new Activity("com.woloo.smarthygiene", "com.woloo.smarthygiene.MainActivity");
		driver.startActivity(activity);
		Thread.sleep(5000);

		/* Select available cluster */

		SupervisorHomePage supervisorHomePage = new SupervisorHomePage(driver);
		supervisorHomePage.getClusterButton().click();

		WebElement clusterId = driver
				.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc,\"CLUST001\")]"));
		clusterId.isDisplayed();

		clusterId.click();

		/* Navigate to janitors page */

		String selectedJanitor = "janitor1";
		WebElement janitorId = driver
				.findElement(AppiumBy.xpath("//android.widget.ImageView[contains(@content-desc,\"janitor1\")]"));
		String janitorTextValue = janitorId.getAttribute("content-desc");

		/* Validate the clusterId with janitors */
		boolean actualresults = janitorTextValue.contains(selectedJanitor);
		Assert.assertEquals(actualresults, true);

	}

	@Test
	public void searchWithValidJanitorsTest()
			throws MalformedURLException, URISyntaxException, InterruptedException {

		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability("platformName", "android");
		caps.setCapability("automationName", "UiAutomator2");
		caps.setCapability("UDID", "UK8545P7JV9SZ9SO");
		caps.setCapability("ignoreHiddenApiPolicyError", true);
		caps.setCapability("noReset", true);
		caps.setCapability("autoGrantPermission", true);
		caps.setCapability("autoAcceptAlerts", true);

		AndroidDriver driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), caps);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

//		Activity activity = new Activity("com.woloo.smarthygiene", "com.woloo.smarthygiene.MainActivity");
//		driver.startActivity(activity);
//		Thread.sleep(5000);

		/* Select Supervisor from Drop down */
		driver.activateApp("com.woloo.smarthygiene");
		Thread.sleep(2000);

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
		Thread.sleep(2000);
		supervisorOTPVerficationPage.getOtpTextfield().sendKeys("1234", Keys.ENTER);
		Thread.sleep(2000);
		supervisorOTPVerficationPage.getSubmitButton().click();
		Thread.sleep(3000);

		/* Select available cluster */

		SupervisorHomePage supervisorHomePage = new SupervisorHomePage(driver);
		supervisorHomePage.getClusterButton().click();

		WebElement clusterId = driver
				.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc,\"CLUST001\")]"));
		clusterId.isDisplayed();

		clusterId.click();

		/* Navigate to janitors page */

		String selectedJanitor = "janitor1";
		WebElement janitorId = driver
				.findElement(AppiumBy.xpath("//android.widget.ImageView[contains(@content-desc,\"janitor1\")]"));
		String janitorTextValue = janitorId.getAttribute("content-desc");

		/* Validate the clusterId with janitors */

		boolean actualresults = janitorTextValue.contains(selectedJanitor);
		Assert.assertEquals(actualresults, true);

		ClusterPage clusterPage = new ClusterPage(driver);
		clusterPage.getBackButton().click();

		/* navigate to Janitors page and search the valid janitors Name */

		Thread.sleep(2000);
		supervisorHomePage.getJanitorsButton().click();
		Thread.sleep(2000);
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[contains(@content-desc, \"janitor1\")]")));

		WebElement searchedJanitor = driver
				.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc,\"" + selectedJanitor + "\")]"));
		
		String janitorDetails = searchedJanitor.getAttribute("content-desc");

		Thread.sleep(2000);
		boolean actualJanitor = janitorDetails.contains(selectedJanitor);
		Assert.assertEquals(actualJanitor, true);

		/* Logout */

		supervisorHomePage.getAccountButton().click();
		Thread.sleep(1000);
		SupervisorAccountPage supervisorAccountPage = new SupervisorAccountPage(driver);
		supervisorAccountPage.getLogoutButton().click();

		driver.terminateApp("com.woloo.smarthygiene");

	}
	
	@Test
	public void searchWithInvalidJanitorsTest()
			throws MalformedURLException, URISyntaxException, InterruptedException {

		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability("platformName", "android");
		caps.setCapability("automationName", "UiAutomator2");
		caps.setCapability("UDID", "UK8545P7JV9SZ9SO");
		caps.setCapability("ignoreHiddenApiPolicyError", true);
		caps.setCapability("noReset", true);
		caps.setCapability("autoGrantPermission", true);
		caps.setCapability("autoAcceptAlerts", true);

		AndroidDriver driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), caps);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		Activity activity = new Activity("com.woloo.smarthygiene", "com.woloo.smarthygiene.MainActivity");
		driver.startActivity(activity);
		Thread.sleep(5000);

//		/* Select Supervisor from Drop down */
//		driver.activateApp("com.woloo.smarthygiene");
//		Thread.sleep(2000);
//
//		WelcomePage welcomePage = new WelcomePage(driver);
//		welcomePage.getLoginDropdown().click();
//		welcomePage.getSupervisorButton().click();
//
//		/* Enter valid Mobile number to login */
//		SupervisorLoginPage supervisorLoginPage = new SupervisorLoginPage(driver);
//		supervisorLoginPage.getSelectLanguageButton().click();
//
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//		WebElement mobileNumTextfield = wait
//				.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText")));
//		mobileNumTextfield.click();
//		Thread.sleep(1000);
//		driver.hideKeyboard();
//		mobileNumTextfield.sendKeys("7975433721", Keys.ENTER);
//		Thread.sleep(2000);
//		supervisorLoginPage.getSendOTPButton().click();
//
//		/* Validate OTP */
//		SupervisorOTPVerficationPage supervisorOTPVerficationPage = new SupervisorOTPVerficationPage(driver);
//		Thread.sleep(2000);
//		supervisorOTPVerficationPage.getOtpTextfield().click();
//		driver.hideKeyboard();
//		Thread.sleep(2000);
//		supervisorOTPVerficationPage.getOtpTextfield().sendKeys("1234", Keys.ENTER);
//		Thread.sleep(2000);
//		supervisorOTPVerficationPage.getSubmitButton().click();
//		Thread.sleep(3000);

		/* Select available cluster */

		SupervisorHomePage supervisorHomePage = new SupervisorHomePage(driver);
		supervisorHomePage.getClusterButton().click();

		WebElement clusterId = driver
				.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc,\"CLUST001\")]"));
		clusterId.isDisplayed();

		clusterId.click();

		/* Navigate to janitors page */

		String selectedJanitor = "janitor1";
		WebElement janitorId = driver
				.findElement(AppiumBy.xpath("//android.widget.ImageView[contains(@content-desc,\"janitor1\")]"));
		String janitorTextValue = janitorId.getAttribute("content-desc");

		/* Validate the clusterId with janitors */

		boolean actualresults = janitorTextValue.contains(selectedJanitor);
		Assert.assertEquals(actualresults, true);

		ClusterPage clusterPage = new ClusterPage(driver);
		clusterPage.getBackButton().click();

		/* navigate to Janitors page and search the valid janitors Name */

		Thread.sleep(2000);
		supervisorHomePage.getJanitorsButton().click();
		
		
		

	}

}
