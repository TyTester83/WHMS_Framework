package com_taskMaster_taskBuddyRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TaskBuddyProfilePage {
	public AndroidDriver driver;

	public TaskBuddyProfilePage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(accessibility = "Back")
	private WebElement backButton;

	@AndroidFindBy(accessibility = "My Profile")
	private WebElement myProfileTextview;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"My Profile\"]/following-sibling::android.widget.ImageView[2]")
	private WebElement upoadImageview;

	@AndroidFindBy(accessibility = "Attendance history")
	private WebElement attendanceImageview;

	@AndroidFindBy(accessibility = "Log Out")
	private WebElement logoutImageview;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Mob :\"]//following-sibling::android.view.View")
	private WebElement mobileNumTextview;

	public WebElement getBackButton() {
		return backButton;
	}

	public WebElement getMyProfileTextview() {
		return myProfileTextview;
	}

	public WebElement getUpoadImageview() {
		return upoadImageview;
	}

	public WebElement getAttendanceImageview() {
		return attendanceImageview;
	}

	public WebElement getLogoutImageview() {
		return logoutImageview;
	}

	public WebElement getMobileNumTextview() {
		return mobileNumTextview;
	}

}
