package com_taskMaster_supervisorRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SupervisorLoginPage {
	public AndroidDriver driver;

	public SupervisorLoginPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(accessibility = "English")
	private WebElement selectLanguageButton;

	@AndroidFindBy(xpath = "//android.widget.EditText[@index=1]")
	private WebElement supervisorMobileNumberTextfield;

	@AndroidFindBy(accessibility = "Send OTP")
	private WebElement sendOTPButton;
	
	@AndroidFindBy(accessibility = "Please enter your mobile number")
	private WebElement mobileNumErrorMessageText;

	public WebElement getSelectLanguageButton() {
		return selectLanguageButton;
	}

	public WebElement getSupervisorMobileNumberTextfield() {
		return supervisorMobileNumberTextfield;
	}

	public WebElement getSendOTPButton() {
		return sendOTPButton;
	}
	
	public WebElement getMobileNumErrorMessageText() {
		return mobileNumErrorMessageText;
	}

	public void supervisorLogin()
	{
		getSelectLanguageButton().click();
		getSupervisorMobileNumberTextfield().sendKeys("7975433721");
		getSendOTPButton().click();
		
	}

}
