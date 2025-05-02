package com_taskMaster_supervisorRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SupervisorOTPVerficationPage {

	public AndroidDriver driver;

	public SupervisorOTPVerficationPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.EditText[@index=2]")
	private WebElement otpTextfield;

	@AndroidFindBy(accessibility = "Submit")
	private WebElement submitButton;

	public WebElement getOtpTextfield() {
		return otpTextfield;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}

}
