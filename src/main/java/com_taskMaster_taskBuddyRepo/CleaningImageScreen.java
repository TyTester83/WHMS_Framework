package com_taskMaster_taskBuddyRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CleaningImageScreen {

	public AndroidDriver driver;

	public CleaningImageScreen(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.Button")
	private WebElement takeSelfiButton;

	@AndroidFindBy(accessibility = "Submit")
	private WebElement submitButton;

	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[7]")
	private WebElement selfiButton;

	@AndroidFindBy(xpath = "//android.view.View/child::android.widget.ImageView[2]")
	private WebElement deleteImageview;

	@AndroidFindBy(xpath = "//android.view.View/child::android.widget.ImageView[1]")
	private WebElement retakeImageview;

	public WebElement getTakeSelfiButton() {
		return takeSelfiButton;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}

	public WebElement getSelfiButton() {
		return selfiButton;
	}

	public WebElement getDeleteImageview() {
		return deleteImageview;
	}

	public WebElement getRetakeImageview() {
		return retakeImageview;
	}

}
