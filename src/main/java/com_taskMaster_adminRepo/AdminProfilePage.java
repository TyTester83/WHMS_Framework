package com_taskMaster_adminRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AdminProfilePage {
	public AndroidDriver driver;

	public AdminProfilePage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(accessibility = "Log out")
	private WebElement logoutButton;

	@AndroidFindBy(accessibility = "No")
	private WebElement noButton;

	@AndroidFindBy(accessibility = "Yes")
	private WebElement yesButton;

	public WebElement getLogoutButton() {
		return logoutButton;
	}

	public WebElement getNoButton() {
		return noButton;
	}

	public WebElement getYesButton() {
		return yesButton;
	}

}
