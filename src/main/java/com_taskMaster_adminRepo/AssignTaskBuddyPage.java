package com_taskMaster_adminRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class AssignTaskBuddyPage {

	public AppiumDriver driver;

	public AssignTaskBuddyPage(AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@iOSXCUITFindBy()
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Assign\r\n" + "Task Buddy\r\n"
			+ "Gender *\"]/android.widget.EditText[1]")
	private WebElement taskBuddyNameTextfield;

	@iOSXCUITFindBy()
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Assign\r\n" + "Task Buddy\r\n"
			+ "Gender *\"]/android.widget.EditText[2]")
	private WebElement monileNumTextfield;

	@iOSXCUITFindBy()
	@AndroidFindBy(accessibility = "Female")
	private WebElement femaleImageview;

	@iOSXCUITFindBy()
	@AndroidFindBy(accessibility = "Male")
	private WebElement maleImageview;

	@iOSXCUITFindBy()
	@AndroidFindBy(accessibility = "Submit")
	private WebElement submitButton;

	@iOSXCUITFindBy()
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Female\"]/android.widget.ImageView[2]")
	private WebElement femaleTickIcon;

	@iOSXCUITFindBy()
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Male\"]/android.widget.ImageView[2]")
	private WebElement maleTickIcon;

	@iOSXCUITFindBy()
	@AndroidFindBy(accessibility = "Name is required")
	private WebElement nameErrorMessage;

	@iOSXCUITFindBy()
	@AndroidFindBy(accessibility = "Enter a valid 10-digit number")
	private WebElement mobileNumErrorMessage;

	public WebElement getTaskBuddyNameTextfield() {
		return taskBuddyNameTextfield;
	}

	public WebElement getMonileNumTextfield() {
		return monileNumTextfield;
	}

	public WebElement getFemaleImageview() {
		return femaleImageview;
	}

	public WebElement getMaleImageview() {
		return maleImageview;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}

	public WebElement getFemaleTickIcon() {
		return femaleTickIcon;
	}

	public WebElement getMaleTickIcon() {
		return maleTickIcon;
	}

	public WebElement getNameErrorMessage() {
		return nameErrorMessage;
	}

	public WebElement getMobileNumErrorMessage() {
		return mobileNumErrorMessage;
	}

}
