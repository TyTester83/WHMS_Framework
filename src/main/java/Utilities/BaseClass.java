package Utilities;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseClass {

	public AppiumDriverLocalService service;
	public AndroidDriver driver;
	public ExcelUtility exUtil = new ExcelUtility();
	public AndroidUtility andUtil;
	public FileUtility fUtil = new FileUtility();

	@BeforeSuite
	public void startServer() {

		File f = new File("C:\\Users\\User\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");
		service = new AppiumServiceBuilder().withAppiumJS(f).withIPAddress("127.0.0.1").usingPort(4723)
				.withTimeout(Duration.ofSeconds(300)).build();

		service.start();
	}

	@BeforeClass
	public void launchApp() throws IOException, URISyntaxException, InterruptedException {

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

		driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), capabilities);
		andUtil = new AndroidUtility(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		if (!driver.isAppInstalled(fUtil.dataFromPropertiesFile("appPackage"))) {

			try {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
				WebElement allowBtn = wait.until(ExpectedConditions.presenceOfElementLocated(
						By.id("com.android.permissioncontroller:id/permission_allow_button")));
				allowBtn.click();
			} catch (Exception e) {
				System.out.println("Permission dialog not displayed or already handled.");
			}
		}
	}

	@BeforeMethod
	public void login() {

	}

	@AfterMethod
	public void logout() {

	}

	@AfterClass
	public void closeApp() throws IOException {
		if (driver != null) {
			String pName = System.getProperty("appPackage", fUtil.dataFromPropertiesFile("appPackage"));
			andUtil.closeApp(pName);
		} else {
			System.out.println("AndroidUtility is not initialized. Skipping closeApp.");
		}

	}

	@AfterSuite
	public void stopServer() {
		service.stop();
	}
}
