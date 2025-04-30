package com_taskMaster_adminRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class AssignSupervisorPage {

	public AppiumDriver driver;

	public AssignSupervisorPage(AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@iOSXCUITFindBy()
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Assign\r\n"
			+ "Supervisor\"]/android.widget.EditText[1]")
	private WebElement supervisorNameTextfield;

	@iOSXCUITFindBy()
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Assign\r\n"
			+ "Supervisor\"]/android.widget.EditText[2]")
	private WebElement mobileNumTextfield;

	@iOSXCUITFindBy()
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Next\"]")
	private WebElement nextButton;
	
	@iOSXCUITFindBy()
	@AndroidFindBy(accessibility = "Name is required")
	private WebElement nameErrorMessage;
	
	@iOSXCUITFindBy()
	@AndroidFindBy(accessibility = "Mobile number is required")
	private WebElement mobileNumErrorMessage;

	public WebElement getSupervisorNameTextfield() {
		return supervisorNameTextfield;
	}

	public WebElement getMobileNumTextfield() {
		return mobileNumTextfield;
	}

	public WebElement getNextButton() {
		return nextButton;
	}

	public WebElement getNameErrorMessage() {
		return nameErrorMessage;
	}

	public WebElement getMobileNumErrorMessage() {
		return mobileNumErrorMessage;
	}

}
