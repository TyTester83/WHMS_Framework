package com_taskMaster_taskBuddyRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class OnGoingTaskTab {

	public AndroidDriver driver;

	public OnGoingTaskTab(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(accessibility = "Request for Closure")
	private WebElement closureImageview;

	@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Request for Closure\"]/parent::android.view.View")
	private WebElement closureTaskTemplate;

	@AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,\"OngoingTask\")]")
	private WebElement ongoingTaskCount;

	@AndroidFindBy(accessibility = "There are no tasks on which you are currently working.")
	private WebElement ongoingTaskFrame;

	public WebElement getClosureImageview() {
		return closureImageview;
	}

	public WebElement getClosureTaskTemplate() {
		return closureTaskTemplate;
	}

	public WebElement getOngoingTaskCount() {
		return ongoingTaskCount;
	}

	public WebElement getOngoingTaskFrame() {
		return ongoingTaskFrame;
	}

}
