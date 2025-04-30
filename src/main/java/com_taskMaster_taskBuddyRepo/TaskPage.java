package com_taskMaster_taskBuddyRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TaskPage {

	public AndroidDriver driver;

	public TaskPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(accessibility = "Back")
	private WebElement backButton;

	@AndroidFindBy(accessibility = "Task")
	private WebElement taskTextview;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Deep Cleaning\"]/parent::android.view.View")
	private WebElement taskCheckbox;// dynamic element

	@AndroidFindBy(accessibility = "Submit")
	private WebElement submitButton;

	public WebElement getBackButton() {
		return backButton;
	}

	public WebElement getTaskTextview() {
		return taskTextview;
	}

	public WebElement getTaskCheckbox() {
		return taskCheckbox;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}

}
