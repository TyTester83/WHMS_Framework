package com_taskMaster_adminRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CongratulationPopup {

	public AndroidDriver driver;

	public CongratulationPopup(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(accessibility = "Congratulations!")
	private WebElement congratsTextview;

	@AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,\"You have assigned the Task\")]")
	private WebElement taskText;

	@AndroidFindBy(accessibility = "Tasks scheduled before the current time will start tracking from the next day, as today's time may have already passed at the time of assignment")
	private WebElement taskAlertTextview;

	@AndroidFindBy(accessibility = "Thanks. Start Monitoring")
	private WebElement startMonitorButton;

	public WebElement getCongratsTextview() {
		return congratsTextview;
	}

	public WebElement getTaskText() {
		return taskText;
	}

	public WebElement getTaskAlertTextview() {
		return taskAlertTextview;
	}

	public WebElement getStartMonitorButton() {
		return startMonitorButton;
	}

}
