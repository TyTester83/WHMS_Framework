package com_taskMaster_AdminRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TaskMasterOverviewPage {

	public AndroidDriver driver;

	public TaskMasterOverviewPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.ImageView[1]")
	private WebElement taskMasterLogo;
	
	@AndroidFindBy(accessibility = "TASKMASTER")
	private WebElement taskMasterTextView;
	
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Monitor your hygiene withWoloo’s\r\n"
			+ "Smart Hygiene Technology Service.\"]")
	private WebElement quotesTextView;
	
	@AndroidFindBy(accessibility = "Explore")
	private WebElement exploreButton;
	
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.ImageView[2]")
	private WebElement tabTextView;

	public WebElement getTaskMasterLogo() {
		return taskMasterLogo;
	}

	public WebElement getTaskMasterTextView() {
		return taskMasterTextView;
	}

	public WebElement getQuotesTextView() {
		return quotesTextView;
	}

	public WebElement getExploreButton() {
		return exploreButton;
	}

	public WebElement getTabTextView() {
		return tabTextView;
	}
	
	
	
}
