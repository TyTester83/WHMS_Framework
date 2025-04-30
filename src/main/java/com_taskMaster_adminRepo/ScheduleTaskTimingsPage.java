package com_taskMaster_adminRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ScheduleTaskTimingsPage {

	public AndroidDriver driver;

	public ScheduleTaskTimingsPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(accessibility = "Schedule Task *")
	private WebElement scheduleTaskTextView;

	@AndroidFindBy(accessibility = "Add")
	private WebElement addButton;

	@AndroidFindBy(accessibility = "Okay, Thanks!")
	private WebElement addTimingPopup;

	public WebElement getScheduleTaskTextView() {
		return scheduleTaskTextView;
	}

	public WebElement getAddButton() {
		return addButton;
	}

	public WebElement getAddTimingPopup() {
		return addTimingPopup;
	}

}
