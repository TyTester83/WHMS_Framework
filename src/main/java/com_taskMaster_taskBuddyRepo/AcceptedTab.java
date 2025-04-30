package com_taskMaster_taskBuddyRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AcceptedTab {
	public AndroidDriver driver;

	public AcceptedTab(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(accessibility = "Direction")
	private WebElement directionImageview;

	@AndroidFindBy(xpath = "start")
	private WebElement startImageview;

	@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"start\"]/parent::android.view.View")
	private WebElement acceptTaskTemplate;

	@AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,\"AcceptedTask\")]")
	private WebElement acceptTaskCount;

	@AndroidFindBy(accessibility = "There are no tasks available for you to start")
	private WebElement acceptedTaskFrame;

	public WebElement getDirectionImageview() {
		return directionImageview;
	}

	public WebElement getStartImageview() {
		return startImageview;
	}

	public WebElement getAcceptTaskTemplate() {
		return acceptTaskTemplate;
	}

	public WebElement getAcceptTaskCount() {
		return acceptTaskCount;
	}

	public WebElement getAcceptedTaskFrame() {
		return acceptedTaskFrame;
	}

}
