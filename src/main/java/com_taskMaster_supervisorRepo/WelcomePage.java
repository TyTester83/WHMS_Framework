package com_taskMaster_supervisorRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class WelcomePage {
	public AndroidDriver driver;

	public WelcomePage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(accessibility = "Login as")
	private WebElement loginDropdown;

	@AndroidFindBy(accessibility = "Admin")
	private WebElement adminButton;

	@AndroidFindBy(accessibility = "Task Buddy")
	private WebElement taskBuddyButton;

	@AndroidFindBy(accessibility = "Supervisor")
	private WebElement supervisorButton;

	public WebElement getLoginDropdown() {
		return loginDropdown;
	}

	public WebElement getAdminButton() {
		return adminButton;
	}

	public WebElement getTaskBuddyButton() {
		return taskBuddyButton;
	}

	public WebElement getSupervisorButton() {
		return supervisorButton;
	}
	
	

}
