package com_taskMaster_taskBuddyRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TaskBuddyLanguagePopup {
	public AndroidDriver driver;

	public TaskBuddyLanguagePopup(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(accessibility = "Select Language")
	private WebElement languagePopup;
	
	@AndroidFindBy(accessibility = "English")
	private WebElement englishButton;
	
	@AndroidFindBy(accessibility = "हिंदी")
	private WebElement hindiButton;
	
	@AndroidFindBy(accessibility = "मराठी")
	private WebElement marathiButton;

	public WebElement getLanguagePopup() {
		return languagePopup;
	}

	public WebElement getEnglishButton() {
		return englishButton;
	}

	public WebElement getHindiButton() {
		return hindiButton;
	}

	public WebElement getMarathiButton() {
		return marathiButton;
	}
	
	

}
