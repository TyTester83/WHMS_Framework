package Utilities;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.ScreenOrientation;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.appmanagement.ApplicationState;

public class AndroidUtility {

	AndroidDriver driver;
	
	public AndroidUtility(AndroidDriver driver) {
		this.driver=driver;
	}
	
	public void installApp(String path) {
		driver.installApp(path);
	}
	
	public void isAppInstalled(String appPackage) {
		boolean result =driver.isAppInstalled(appPackage);
		System.out.println(result);
	}
	
	public void deleteApp(String appPackage) {
		driver.removeApp(appPackage);
	}
	
	public void activateApp(String packageName) {
		driver.activateApp(packageName);
	}
	
	public void runInBackground(int time) {
		driver.runAppInBackground(Duration.ofSeconds(time));
	}
	
	public void appStatus(String packageName) {
		ApplicationState status = driver.queryAppState(packageName);
		System.out.println(status.toString());
	}
	
	public void currentActivity() {
		String activity = driver.currentActivity();
		System.out.println(activity);
	}
	
	public void closeApp(String packageName) {
		driver.terminateApp(packageName);
	}
	
	public void notification() {
		driver.openNotifications();
	}
	
	public void keyboard() {
		driver.hideKeyboard();
	}
	
	public void data() {
		driver.toggleData();
	}
	
	public void wifi() {
		driver.toggleWifi();
	}
	
	public void airplaneMode() {
		driver.toggleAirplaneMode();
	}
	
	public void potraitOrientation() {
		ScreenOrientation screen = driver.getOrientation();
		driver.rotate(screen.PORTRAIT);
	}
	
	public void landscapeOrientation() {
		ScreenOrientation screen = driver.getOrientation();
		driver.rotate(screen.LANDSCAPE);
	}
	
	public void setClipboard(String text) {
		driver.setClipboardText(text);
	}
	
	public void getClipboard() {
		String txt = driver.getClipboardText();
		System.out.println(txt);
	}
	
	public void implicitWait(int time) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}
	
	public void toast() {
		String msg = driver.findElement(AppiumBy.xpath("//android.widget.Toast[1]")).getText();
		System.out.println(msg);
	}
	
	public void getContexts() {
		Set<String> contexts = driver.getContextHandles();
		System.out.println(contexts.size());
		for (String ch : contexts) {
			System.out.println(ch);
			if(ch.contains("WEBVIEW_")) {
				driver.context(ch);
				break;
			}
		}
	}
}
