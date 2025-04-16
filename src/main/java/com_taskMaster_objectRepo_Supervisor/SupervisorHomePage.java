package com_taskMaster_objectRepo_Supervisor;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SupervisorHomePage {

	public AndroidDriver driver;

	public SupervisorHomePage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(accessibility = "Pending task\r\n" + "Tab 1 of 4")
	private WebElement pendingtaskTab;

	@AndroidFindBy(accessibility = "Request for Closure\r\n" + "Tab 2 of 4")
	private WebElement requestClosureTab;

	@AndroidFindBy(accessibility = "Completed Task\r\n" + "Tab 3 of 4")
	private WebElement completedTaskTab;

	@AndroidFindBy(accessibility = "Rejected\r\n" + "Tab 4 of 4")
	private WebElement rejectedTaskTab;

	@AndroidFindBy(accessibility = "Regular Task\r\n" + "Tab 1 of 2")
	private WebElement regularTaskTab;

	@AndroidFindBy(accessibility = "IOT Task\r\n" + "Tab 2 of 2")
	private WebElement iotTaskTab;

	@AndroidFindBy(accessibility = "Cluster")
	private WebElement clusterButton;

	@AndroidFindBy(accessibility = "Janitors")
	private WebElement janitorsButton;

	@AndroidFindBy(accessibility = "Report an Issue")
	private WebElement reportingIssueButton;

	@AndroidFindBy(accessibility = "Account")
	private WebElement accountButton;

	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.ImageView")
	private WebElement homeButton;

	public WebElement getPendingtaskTab() {
		return pendingtaskTab;
	}

	public WebElement getRequestClosureTab() {
		return requestClosureTab;
	}

	public WebElement getCompletedTaskTab() {
		return completedTaskTab;
	}

	public WebElement getRejectedTaskTab() {
		return rejectedTaskTab;
	}

	public WebElement getRegularTaskTab() {
		return regularTaskTab;
	}

	public WebElement getIotTaskTab() {
		return iotTaskTab;
	}

	public WebElement getClusterButton() {
		return clusterButton;
	}

	public WebElement getJanitorsButton() {
		return janitorsButton;
	}

	public WebElement getReportingIssueButton() {
		return reportingIssueButton;
	}

	public WebElement getAccountButton() {
		return accountButton;
	}

	public WebElement getHomeButton() {
		return homeButton;
	}
	
	

}
