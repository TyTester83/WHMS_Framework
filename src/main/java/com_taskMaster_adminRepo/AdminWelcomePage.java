package com_taskMaster_adminRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AdminWelcomePage {
	
	public AndroidDriver driver;

	public AdminWelcomePage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(accessibility = "Welcome to your")
	private WebElement welcomeTextView;
	
	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.ImageView[1]")
	private WebElement taskMasterLogo;
	
	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.ImageView[2]")
	private WebElement serviceImage;
	
	@AndroidFindBy(accessibility = "You’re there! Just a few more steps to get you started with your Smart Hygiene Journey.")
	private WebElement quotesTexView;
	
	@AndroidFindBy(accessibility = "Get Started")
	private WebElement getStartButton;

	public WebElement getWelcomeTextView() {
		return welcomeTextView;
	}

	public WebElement getTaskMasterLogo() {
		return taskMasterLogo;
	}

	public WebElement getServiceImage() {
		return serviceImage;
	}

	public WebElement getQuotesTexView() {
		return quotesTexView;
	}

	public WebElement getGetStartButton() {
		return getStartButton;
	}
	
	

}
