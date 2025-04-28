package com_taskMaster_adminRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AdminAssignTaskPage {

	public AndroidDriver driver;

	public AdminAssignTaskPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(accessibility = "Tasks")
	private WebElement taskTextview;

	@AndroidFindBy(accessibility = "Select Cleaning Tasks *")
	private WebElement selectCleaningTaskDropdown;

	@AndroidFindBy(accessibility = "Start Time *")
	private WebElement startTimeButton;

	@AndroidFindBy(accessibility = "Add Timings")
	private WebElement addTimingsButton;

	@AndroidFindBy(accessibility = "Next")
	private WebElement nextButton;

	@AndroidFindBy(accessibility = "OK")
	private WebElement okButton;

	public WebElement gettaskTextview() {
		return taskTextview;
	}

	public WebElement getSelectCleaningTaskDropdown() {
		return selectCleaningTaskDropdown;
	}

	public WebElement getStartTimeButton() {
		return startTimeButton;
	}

	public WebElement getAddTimingsButton() {
		return addTimingsButton;
	}

	public WebElement getNextButton() {
		return nextButton;
	}

	public WebElement getOkButton() {
		return okButton;
	}

}
