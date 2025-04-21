package com_taskMaster_adminRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AdminLoginPage {
	public AndroidDriver driver;

	public AdminLoginPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.ImageView")
	private WebElement taskMasterLogo;

	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.widget.EditText[1]")
	private WebElement emailIDTextfield;

	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.widget.EditText[2]")
	private WebElement passwordTextfield;

	@AndroidFindBy(accessibility = "Login")
	private WebElement loginButton;

	@AndroidFindBy(accessibility = "Register Now")
	private WebElement registerNowLink;

	@AndroidFindBy(accessibility = "Forgot Password?")
	private WebElement forgotPasswordButton;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Email is required\"]")
	private WebElement emailErrorMessage;
	
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Password is required\"]")
	private WebElement passwordErrorMessage;
	
	public WebElement getTaskMasterLogo() {
		return taskMasterLogo;
	}

	public WebElement getEmailIDTextfield() {
		return emailIDTextfield;
	}

	public WebElement getPasswordTextfield() {
		return passwordTextfield;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getRegisterNowLink() {
		return registerNowLink;
	}

	public WebElement getForgotPasswordButton() {
		return forgotPasswordButton;
	}

	public WebElement getEmailErrorMessage() {
		return emailErrorMessage;
	}

	public WebElement getPasswordErrorMessage() {
		return passwordErrorMessage;
	}
	
	

}
