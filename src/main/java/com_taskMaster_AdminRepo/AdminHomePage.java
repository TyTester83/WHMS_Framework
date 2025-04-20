package com_taskMaster_AdminRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AdminHomePage {
	public AndroidDriver driver;

	public AdminHomePage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(accessibility = "Dashboard Overview")
	private WebElement adminDashboardText;
	
	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc,\"Profile\")]")
	private WebElement profileTab;

	public WebElement getAdminDashboardText() {
		return adminDashboardText;
	}

	public WebElement getProfileTab() {
		return profileTab;
	}
	
	

}
