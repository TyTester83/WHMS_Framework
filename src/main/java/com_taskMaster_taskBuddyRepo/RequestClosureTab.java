package com_taskMaster_taskBuddyRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class RequestClosureTab {

	public AndroidDriver driver;

	public RequestClosureTab(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,\"Customize Task Template\")]")
	private WebElement taskClosureTemplate;

	@AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,\"Request for closureTask\")]")
	private WebElement requestCloseTaskCount;

	public WebElement getTaskClosureTemplate() {
		return taskClosureTemplate;
	}

	public WebElement getRequestCloseTaskCount() {
		return requestCloseTaskCount;
	}

}
