package Utilities;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class BrowserstackBaseClass {

	public AppiumDriverLocalService service;
	public AndroidDriver driver;
	public ExcelUtility exUtil = new ExcelUtility();
	public AndroidUtility andUtil = new AndroidUtility(driver);
	public FileUtility fUtil = new FileUtility();

	@BeforeClass
	public void launchApp() throws IOException, URISyntaxException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("browserstack.user", "testerty_DEbPMp");
		caps.setCapability("browserstack.Key", "Cn3Uihyzepjz8DArN8qL");

		caps.setCapability("platformName", "android");
		caps.setCapability("automationName", "UiAutomator2");
		caps.setCapability("deviceName", "Samsung Galaxy S22 Ultra");
		caps.setCapability("platformVersion", "12.0");
		caps.setCapability("projectName", "WHMS");
		caps.setCapability("buildName", "Build v1.0");
		caps.setCapability("app", "bs://80535a43aa31a28f052e023020e70f4ce1923e24");
		caps.setCapability("appPackage", "com.woloo.smarthygiene");
		caps.setCapability("appActivity", "com.woloo.smarthygiene.MainActivity");
		caps.setCapability("autoGrantPermission", true);
		caps.setCapability("autoAcceptAlerts", true);

		AndroidDriver driver = new AndroidDriver(new URI("http://testerty_DEbPMp:Cn3Uihyzepjz8DArN8qL@hub-cloud.browserstack.com/wd/hub").toURL(), caps);
		UtilityClassObject.setDriver(driver);
		UtilityClassObject.getDriver();

	}

	@BeforeMethod
	public void login() {

	}

	@AfterMethod
	public void logout() {

	}

	@AfterClass
	public void closeApp() throws IOException {
		String pName = System.getProperty("packageName", fUtil.dataFromPropertiesFile("packageName"));
		andUtil.closeApp(pName);

	}

}
