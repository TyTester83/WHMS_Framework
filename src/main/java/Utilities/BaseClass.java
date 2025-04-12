package Utilities;

import java.io.File;
import java.time.Duration;

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
	public ExcelUtility exUtil;
	public AndroidUtility andUtil;
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
	public void launchApp()  {
		
		
	}
	
	@BeforeMethod
	public void login()  {
		
	}
	
	@AfterMethod
	public void logout()  {
		
		
	}
	
	@AfterClass
	public void closeApp()  {
		
	}
	
	@AfterSuite
	public void stopServer() {
		service.stop();
	}
}
