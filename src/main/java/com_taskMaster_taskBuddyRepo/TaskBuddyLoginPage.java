package com_taskMaster_taskBuddyRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TaskBuddyLoginPage {
	
	public AndroidDriver driver;

	public TaskBuddyLoginPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath = "//android.widget.ImageView")
	private WebElement taskMasterImage;
	
	@AndroidFindBy(xpath = "//android.widget.EditText")
	private WebElement mobileNumberTextfield;
	
	@AndroidFindBy(accessibility = "Send OTP")
	private WebElement sendOTPButton;
	
	public WebElement getTaskMasterImage() {
		return taskMasterImage;
	}

	public WebElement getMobileNumberTextfield() {
		return mobileNumberTextfield;
	}

	public WebElement getSendOTPButton() {
		return sendOTPButton;
	}
	
	

}
