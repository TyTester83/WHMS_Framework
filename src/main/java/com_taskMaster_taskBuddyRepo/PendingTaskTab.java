package com_taskMaster_taskBuddyRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PendingTaskTab {

	public AndroidDriver driver;

	public PendingTaskTab(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(accessibility = "Accept")
	private WebElement acceptImageview;

	@AndroidFindBy(accessibility = "Reject")
	private WebElement rejectImageview;

	@AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,\"PendingTask\")]")
	private WebElement pendingTaskCount;

	@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Accept\"]/parent::android.view.View")
	private WebElement taskTemplate;

	@AndroidFindBy(accessibility = "There is no task assigned to you")
	private WebElement pendingTaskFrame;

	public WebElement getAcceptImageview() {
		return acceptImageview;
	}

	public WebElement getRejectImageview() {
		return rejectImageview;
	}

	public WebElement getPendingTaskCount() {
		return pendingTaskCount;
	}

	public WebElement getTaskTemplate() {
		return taskTemplate;
	}

	public WebElement getPendingTaskFrame() {
		return pendingTaskFrame;
	}

}
