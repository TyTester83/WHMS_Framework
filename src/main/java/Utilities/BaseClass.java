package Utilities;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseClass {

	public AppiumDriverLocalService service;
	public AndroidDriver driver;
	public ExcelUtility exUtil=new ExcelUtility();
	public AndroidUtility andUtil=new AndroidUtility(driver);
	public FileUtility fUtil = new FileUtility(); 
	
	@BeforeSuite
	public void startServer() {
		
		File f = new File("C:\\Users\\admin\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");
		service = new AppiumServiceBuilder().
		withAppiumJS(f).withIPAddress("127.0.0.1").usingPort(4723).
		withTimeout(Duration.ofSeconds(300)).build();
		
		service.start();
	}
	
	@BeforeClass
	public void launchApp() throws IOException, URISyntaxException  {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platformName", fUtil.dataFromPropertiesFile("platformName"));
		caps.setCapability("automationName", fUtil.dataFromPropertiesFile("automationName"));
		caps.setCapability("deviceName", fUtil.dataFromPropertiesFile("deviceName"));
		caps.setCapability("UDID", fUtil.dataFromPropertiesFile("udid"));
		caps.setCapability("appPackage", fUtil.dataFromPropertiesFile("appPackage"));
		caps.setCapability("appActivity", fUtil.dataFromPropertiesFile("appActivity"));
		caps.setCapability("noReset", true);
		caps.setCapability("autoGrantPermission", true);
		
		URL u = new URI("http://127.0.0.1:4723").toURL();
		driver = new AndroidDriver(u,caps);
		UtilityClassObject.setDriver(driver);
		UtilityClassObject.getDriver();
		
	}
	
	@BeforeMethod
	public void login()  {
		
		
	}
	
	@AfterMethod
	public void logout()  {
		
		
	}
	
	@AfterClass
	public void closeApp() throws IOException  {
		String pName=System.getProperty("packageName",fUtil.dataFromPropertiesFile("packageName"));
		andUtil.closeApp(pName);
		
	}
	
	@AfterSuite
	public void stopServer() {
		service.stop();
	}
}
