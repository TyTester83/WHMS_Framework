package com_taskMaster_supervisorTest;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;

public class VerifyInvalidOTPTest {
@Test
public void verifyInvalidSupervisorTest() throws MalformedURLException, URISyntaxException
{
	DesiredCapabilities caps = new DesiredCapabilities();

	caps.setCapability("platformName", "android");
	caps.setCapability("automationName", "UiAutomator2");
	caps.setCapability("UDID", "UK8545P7JV9SZ9SO");
//	caps.setCapability("appPackage", "com.woloo.smarthygiene");
//	caps.setCapability("appActivity", "com.woloo.smarthygiene.MainActivity");
	caps.setCapability("ignoreHiddenApiPolicyError", true);
	caps.setCapability("noReset", true);
	caps.setCapability("autoGrantPermission", true);
	caps.setCapability("autoAcceptAlerts", true);

	AndroidDriver driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), caps);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
	Activity activity=new Activity("com.woloo.smarthygiene", "com.woloo.smarthygiene.MainActivity");
	driver.startActivity(activity);
}

}
