package com_taskMaster_AdminRepo;

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

	@AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,\"Assign Tasks\")]")
	private WebElement assignTaskFrame;

	@AndroidFindBy(accessibility = "Select Cleaning Tasks *")
	private WebElement selectCleaningTaskDropdown;

	@AndroidFindBy(accessibility = "Start Time *")
	private WebElement startTimeButton;

	@AndroidFindBy(accessibility = "Add Timings")
	private WebElement addTimingsButton;

	@AndroidFindBy(accessibility = "Next")
	private WebElement nextButton;

	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[3]/android.view.View/android.view.View/android.view.View")
	private WebElement taskOptionTab;

	@AndroidFindBy(accessibility = "OK")
	private WebElement okButton;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Bathroom Cleaning   15 min\"]/android.widget.Button[1]") // dynamic
																															// xpath
	private WebElement taskCancelButton;

	public WebElement getAssignTaskFrame() {
		return assignTaskFrame;
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

	public WebElement getTaskOptionTab() {
		return taskOptionTab;
	}

	public WebElement getOkButton() {
		return okButton;
	}

	public WebElement getTaskCancelButton() {
		return taskCancelButton;
	}

}
