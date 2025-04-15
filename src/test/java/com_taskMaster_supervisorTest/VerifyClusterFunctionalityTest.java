package com_taskMaster_supervisorTest;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com_taskMaster_ObjectRepo.SupervisorHomePage;
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
		WebElement janitorId = driver.findElement(AppiumBy.xpath("//android.widget.ImageView[contains(@content-desc,\"janitor1\")]"));
		String janitorTextValue = janitorId.getAttribute("content-desc");

		/* Validate the clusterId with janitors */
		boolean actualresults = janitorTextValue.contains(selectedJanitor);
		Assert.assertEquals(actualresults, true);

	}

}
