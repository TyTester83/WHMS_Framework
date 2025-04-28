package com_taskMaster_adminRepo;

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

	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.ImageView")
	private WebElement switchIcon;

	@AndroidFindBy(accessibility = "Add Facility/Task")
	private WebElement addFacilityTaskButton;

	@AndroidFindBy(xpath = "//android.widget.Button")
	private WebElement taskAuditButton;

	@AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,\"Efficiency\")]")
	private WebElement buddyEfficiencyChart;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\" Completed Task :\"]/following-sibling::android.view.View[1]")
	private WebElement completedTaskCountText;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Accpeted Task :\"]/following-sibling::android.view.View[1]")
	private WebElement acceptedTaskCountText;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"On Going  Task :\"]/following-sibling::android.view.View[1]")
	private WebElement onGoingTaskCountText;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Pending Task :\"]/following-sibling::android.view.View[1]")
	private WebElement pendingTaskCountText;

	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc,\"Profile\")]")
	private WebElement profileTab;

	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc,\"Home\")]")
	private WebElement homeTab;

	public WebElement getAdminDashboardText() {
		return adminDashboardText;
	}

	public WebElement getSwitchIcon() {
		return switchIcon;
	}

	public WebElement getAddFacilityTaskButton() {
		return addFacilityTaskButton;
	}

	public WebElement getTaskAuditButton() {
		return taskAuditButton;
	}

	public WebElement getBuddyEfficiencyChart() {
		return buddyEfficiencyChart;
	}

	public WebElement getCompletedTaskCountText() {
		return completedTaskCountText;
	}

	public WebElement getAcceptedTaskCountText() {
		return acceptedTaskCountText;
	}

	public WebElement getOnGoingTaskCountText() {
		return onGoingTaskCountText;
	}

	public WebElement getPendingTaskCountText() {
		return pendingTaskCountText;
	}

	public WebElement getHomeTab() {
		return homeTab;
	}

	public WebElement getProfileTab() {
		return profileTab;
	}

}
