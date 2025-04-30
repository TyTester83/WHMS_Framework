package com_taskMaster_taskBuddyRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class UploadProfileImagePage {

	public AndroidDriver driver;

	public UploadProfileImagePage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(accessibility = "Upload A Profile Image")
	private WebElement uploadProfileTextview;

	@AndroidFindBy(xpath = "//android.widget.Button")
	private WebElement uploadImageButton;

	@AndroidFindBy(accessibility = "Submit")
	private WebElement submitButton;

	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[5]/android.view.View")
	private WebElement photoClickButton;

	public WebElement getUploadProfileTextview() {
		return uploadProfileTextview;
	}

	public WebElement getUploadImageButton() {
		return uploadImageButton;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}

	public WebElement getPhotoClickButton() {
		return photoClickButton;
	}

}
