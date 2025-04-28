package com_taskMaster_taskBuddyRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TaskBuddyDashboardPage {

	public AndroidDriver driver;

	public TaskBuddyDashboardPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(accessibility = "My Dashboard")
	private WebElement myDashboardTextview;
	
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[1]/android.widget.ImageView[1]")
	private WebElement languageImageview;
	
	@AndroidFindBy(xpath="//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[1]/android.widget.ImageView[2]")
	private WebElement myProfileImageview;
	
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"janitor\"]")
	private WebElement profileNameTextview;// dynamic locators
	
	@AndroidFindBy(xpath="//android.view.View[@content-desc=\"7,7, Kempapura Agrahara,Bangalore Division, Karnataka,560026\"]")
	private WebElement locationTextview;//dynamic locators
	
	@AndroidFindBy(accessibility = "Present")
	private WebElement presentTextview;
	
	@AndroidFindBy(accessibility = "IN")
	private WebElement inTextview;
	
	@AndroidFindBy(accessibility = "OUT")
	private WebElement outTextview;
	
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"21:37:50\"]")
	private WebElement outTimeTextview;//dynamic locators

	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"22-4-2025\"]")
	private WebElement outDateTextview;//dynamic locators
	
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"21:54:7\"]")
	private WebElement inTimeTextview;//dynamic locators
	
	@AndroidFindBy(xpath = "(//android.view.View[@content-desc=\"22-4-2025\"])[1]")
	private WebElement inDateTextview;//dynamic locators
	
	@AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,\"Pending task\")]")
	private WebElement pendingTaskTab;
	
	@AndroidFindBy(accessibility = "There is no task assigned to you")
	private WebElement pendingTaskFrame;
	
	@AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,\"Accepted\")]")
	private WebElement acceptedTaskTab;
	
	@AndroidFindBy(accessibility = "There are no tasks available for you to start")
	private WebElement acceptedTaskFrame;
	
	@AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,\"Ongoing\")]")
	private WebElement ongoingTab;
	
	@AndroidFindBy(accessibility = "There are no tasks on which you are currently working.")
	private WebElement ongoingTaskFrame;
	
	@AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,\"Request for Closure\")]")
	private WebElement requestClosureTab;

	public WebElement getMyDashboardTextview() {
		return myDashboardTextview;
	}

	public WebElement getLanguageImageview() {
		return languageImageview;
	}

	public WebElement getMyProfileImageview() {
		return myProfileImageview;
	}

	public WebElement getProfileNameTextview() {
		return profileNameTextview;
	}

	public WebElement getLocationTextview() {
		return locationTextview;
	}

	public WebElement getPresentTextview() {
		return presentTextview;
	}

	public WebElement getInTextview() {
		return inTextview;
	}

	public WebElement getOutTextview() {
		return outTextview;
	}

	public WebElement getOutTimeTextview() {
		return outTimeTextview;
	}

	public WebElement getOutDateTextview() {
		return outDateTextview;
	}

	public WebElement getInTimeTextview() {
		return inTimeTextview;
	}

	public WebElement getInDateTextview() {
		return inDateTextview;
	}

	public WebElement getPendingTaskTab() {
		return pendingTaskTab;
	}

	public WebElement getPendingTaskFrame() {
		return pendingTaskFrame;
	}

	public WebElement getAcceptedTaskTab() {
		return acceptedTaskTab;
	}

	public WebElement getAcceptedTaskFrame() {
		return acceptedTaskFrame;
	}

	public WebElement getOngoingTab() {
		return ongoingTab;
	}

	public WebElement getOngoingTaskFrame() {
		return ongoingTaskFrame;
	}

	public WebElement getRequestClosureTab() {
		return requestClosureTab;
	}
	
	
	
}
