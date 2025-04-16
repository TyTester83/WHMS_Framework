package com_taskMaster_objectRepo_Supervisor;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SupervisorAccountPage {

	public AndroidDriver driver;

	public SupervisorAccountPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]/android.widget.ImageView")
	private WebElement profilePhotoEditIcon;

	@AndroidFindBy(accessibility = "Log Out")
	private WebElement logoutButton;

	public WebElement getProfilePhotoEditIcon() {
		return profilePhotoEditIcon;
	}

	public WebElement getLogoutButton() {
		return logoutButton;
	}

}
