package com_taskMaster_adminRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class StartTimePage {

	public AndroidDriver driver;

	public StartTimePage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(accessibility = "Select time")
	private WebElement selectTimeTextView;

	@AndroidFindBy(accessibility = "Cancel")
	private WebElement cancelButton;

	@AndroidFindBy(accessibility = "OK")
	private WebElement okButton;

	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Cancel\"]/preceding-sibling::android.widget.Button")
	private WebElement switchTimeIcon;

	@AndroidFindBy(accessibility = "Enter time")
	private WebElement enterTimeTextView;

	@AndroidFindBy(xpath = "//android.widget.EditText[1]")
	private WebElement hrsTextfield;

	@AndroidFindBy(xpath = "//android.widget.EditText[2]")
	private WebElement minTextfield;

	@AndroidFindBy(accessibility = "AM")
	private WebElement amRadioButton;

	@AndroidFindBy(accessibility = "PM")
	private WebElement pmRadioButton;

	public WebElement getSelectTimeTextView() {
		return selectTimeTextView;
	}

	public WebElement getCancelButton() {
		return cancelButton;
	}

	public WebElement getOkButton() {
		return okButton;
	}

	public WebElement getSwitchTimeIcon() {
		return switchTimeIcon;
	}

	public WebElement getEnterTimeTextView() {
		return enterTimeTextView;
	}

	public WebElement getHrsTextfield() {
		return hrsTextfield;
	}

	public WebElement getMinTextfield() {
		return minTextfield;
	}

	public WebElement getAmRadioButton() {
		return amRadioButton;
	}

	public WebElement getPmRadioButton() {
		return pmRadioButton;
	}

}
