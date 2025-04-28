package com_taskMaster_taskBuddyRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TaskBuddyOTPPage {

	public AndroidDriver driver;

	public TaskBuddyOTPPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.widget.ImageView[1]")
	private WebElement taskMasterImage;
	
	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc,\"Please enter the verification code\")]")
	private WebElement backToPreviousPageEditIcon;
	
	@AndroidFindBy(xpath = "//android.widget.EditText")
	private WebElement otpTextfield;
	
	@AndroidFindBy(accessibility = "Didn’t receive OTP code?")
	private WebElement notReceivedOTPTextview;
	
	@AndroidFindBy(accessibility = "Submit")
	private WebElement submitButton;

	public WebElement getTaskMasterImage() {
		return taskMasterImage;
	}

	public WebElement getBackToPreviousPageEditIcon() {
		return backToPreviousPageEditIcon;
	}

	public WebElement getOtpTextfield() {
		return otpTextfield;
	}

	public WebElement getNotReceivedOTPTextview() {
		return notReceivedOTPTextview;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}
	
	
}
