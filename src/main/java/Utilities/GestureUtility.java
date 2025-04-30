package Utilities;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class GestureUtility {

	AndroidDriver driver;

	public GestureUtility(AndroidDriver driver) {
		this.driver = driver;
	}

	public void clickByElements(WebElement element) {
		((JavascriptExecutor) driver).executeScript("mobile:clickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId()));
	}

	public void clickByCordinates(int x, int y) {
		((JavascriptExecutor) driver).executeScript("mobile:clickGesture", ImmutableMap.of("x", x, "y", y));
	}

	public void longClickByElement(WebElement element, int time) {
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "duration", time));
	}

	public void longClickByCordinates(int x, int y, int time) {
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("x", x, "y", y, "duration", time));
	}

	public void doubleClickByElement(WebElement element) {
		((JavascriptExecutor) driver).executeScript("mobile: doubleClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId()));
	}

	public void doubleClickByCordinates(int x, int y) {
		((JavascriptExecutor) driver).executeScript("mobile: doubleClickGesture", ImmutableMap.of("x", x, "y", y));
	}

	public void dragAndDrop(WebElement element, int x, int y) {
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "endX", x, "endY", y));
	}

	public void zoomIn(WebElement element, double percent) {
		((JavascriptExecutor) driver).executeScript("mobile: pinchOpenGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "percent", percent));
	}

	public void zoomOut(WebElement element, double percent) {
		((JavascriptExecutor) driver).executeScript("mobile: pinchCloseGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "percent", percent));
	}

	public void swipeByCordinates(int left, int top, int width, int height, String direction, double percent) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("left", left, "top", top,
				"width", width, "height", height, "direction", direction, "percent", percent));
	}

	public void swipeByElement(WebElement element, String direction, double percent) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",
				((RemoteWebElement) element).getId(), "direction", direction, "percent", percent));
	}

	public WebElement scrollByText(String text) {
		WebElement elementText = driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));"));
		return elementText;
	}

	public WebElement scrollByxPath(String xpath) {
		WebElement elementxPath = driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(xpath(\"" + xpath + "\"));"));
		return elementxPath;
	}

	public void scrollOnElement(WebElement element, String direction) {
		try {
			((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",
					((RemoteWebElement) element).getId(), "direction", direction, "percent", 1));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void dragScrollOnElement(WebElement element, int startXOffset, int startYOffset, int endXOffset,
			int endYOffset, int durationMs) {
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "startX", startXOffset, "startY",
						startYOffset, "endX", endXOffset, "endY", endYOffset, "duration", durationMs));
	}

	public void scrollToAndClickCheckbox(String taskName) {
	    boolean isElementFound = false;

	    while (!isElementFound) {
	        try {
	            String dynamicXpath = "//android.widget.Button[@content-desc[contains(.,\""+taskName+"\")]]/following-sibling::android.widget.CheckBox";
	            RemoteWebElement checkbox = (RemoteWebElement) driver.findElement(AppiumBy.xpath(dynamicXpath));
	            checkbox.click();
	            isElementFound = true;
	        } catch (NoSuchElementException e) {
	            // Scroll if not found
	            Map<String, Object> scrollParams = new HashMap<>();
	            scrollParams.put("direction", "down");
	            scrollParams.put("strategy", "accessibility id"); // can be "xpath" too
	            scrollParams.put("scrollable", true);
	            scrollParams.put("maxSwipes", 1);

	            // Just to initiate scroll on generic scrollable container
	            scrollParams.put("element", ((RemoteWebElement) driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Pantry Cleaning   15 min\"]"))).getId());
	            driver.executeScript("mobile: scrollGesture", scrollParams);
	        }
	    }
	}

}
