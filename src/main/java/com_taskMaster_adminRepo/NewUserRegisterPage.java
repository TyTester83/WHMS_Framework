package com_taskMaster_adminRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class NewUserRegisterPage {
	public AndroidDriver driver;

	public NewUserRegisterPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.ImageView")
	private WebElement taskMasterLogo;

	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.EditText[1]")
	private WebElement nameTextfield;

	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.EditText[2]")
	private WebElement emailTextfield;

	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.EditText[3]")
	private WebElement mobileNoTextfield;

	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.EditText[4]")
	private WebElement addressTextfield;

	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.EditText[5]")
	private WebElement cityTextfield;

	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.EditText[6]")
	private WebElement pincodeTextfield;

	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.EditText[7]")
	private WebElement passwordTextfield;

	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.EditText[8]")
	private WebElement confirmPasswordTextfield;

	@AndroidFindBy(accessibility = "Register")
	private WebElement registerButton;

	@AndroidFindBy(accessibility = "Login Now")
	private WebElement alreadyuserLoginNowLink;

	@AndroidFindBy(accessibility = "Name is required")
	private WebElement nameErrorMessage;

	@AndroidFindBy(accessibility = "Email is required")
	private WebElement emailErrorMessage;

	@AndroidFindBy(accessibility = "Mobile number is required")
	private WebElement mobileNoErrorMessage;

	@AndroidFindBy(accessibility = "Address is required")
	private WebElement addressErrorMessage;

	@AndroidFindBy(accessibility = "City is required")
	private WebElement cityErrorMessage;

	@AndroidFindBy(accessibility = "Pincode is required")
	private WebElement pincodeErrorMessage;

	@AndroidFindBy(accessibility = "Password is required")
	private WebElement passwordErrorMessage;

	@AndroidFindBy(accessibility = "Confirm Password is required")
	private WebElement confirmPasswordErrorMessage;

	public WebElement getTaskMasterLogo() {
		return taskMasterLogo;
	}

	public WebElement getNameTextfield() {
		return nameTextfield;
	}

	public WebElement getEmailTextfield() {
		return emailTextfield;
	}

	public WebElement getMobileNoTextfield() {
		return mobileNoTextfield;
	}

	public WebElement getAddressTextfield() {
		return addressTextfield;
	}

	public WebElement getCityTextfield() {
		return cityTextfield;
	}

	public WebElement getPincodeTextfield() {
		return pincodeTextfield;
	}

	public WebElement getPasswordTextfield() {
		return passwordTextfield;
	}

	public WebElement getConfirmPasswordTextfield() {
		return confirmPasswordTextfield;
	}

	public WebElement getRegisterButton() {
		return registerButton;
	}

	public WebElement getAlreadyuserLoginNowLink() {
		return alreadyuserLoginNowLink;
	}

	public WebElement getNameErrorMessage() {
		return nameErrorMessage;
	}

	public WebElement getEmailErrorMessage() {
		return emailErrorMessage;
	}

	public WebElement getMobileNoErrorMessage() {
		return mobileNoErrorMessage;
	}

	public WebElement getAddressErrorMessage() {
		return addressErrorMessage;
	}

	public WebElement getCityErrorMessage() {
		return cityErrorMessage;
	}

	public WebElement getPincodeErrorMessage() {
		return pincodeErrorMessage;
	}

	public WebElement getPasswordErrorMessage() {
		return passwordErrorMessage;
	}

	public WebElement getConfirmPasswordErrorMessage() {
		return confirmPasswordErrorMessage;
	}

}
