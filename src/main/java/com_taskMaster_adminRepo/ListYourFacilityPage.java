package com_taskMaster_adminRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ListYourFacilityPage {

	public AndroidDriver driver;

	public ListYourFacilityPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(accessibility = "Facility")
	private WebElement listYourFacilityTextview;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Facility\"]/following-sibling::android.widget.EditText[1]")
	private WebElement facilityNameTextfield;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Facility\"]/following-sibling::android.widget.EditText[2]")
	private WebElement locationTextfield;

	@AndroidFindBy(accessibility = "Home")
	private WebElement homeFacilityImage;

	@AndroidFindBy(accessibility = "Office")
	private WebElement officeFacilityImage;

	@AndroidFindBy(accessibility = "Restraunt")
	private WebElement restrauntFacilityImage;

	@AndroidFindBy(accessibility = "Other")
	private WebElement othersFacilityImage;

	@AndroidFindBy(xpath = "//android.widget.EditText[3]")
	private WebElement othersFacilityTextfield;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Next\"]")
	private WebElement nextButton;

	@AndroidFindBy(accessibility = "Facility Name is required")
	private WebElement facilityNameErrorMessage;

	@AndroidFindBy(accessibility = "Location is required")
	private WebElement locationErrorMessage;

	@AndroidFindBy(accessibility = "Please select a facility")
	private WebElement facilityTypeErrorMessage;

	@AndroidFindBy(accessibility = "Please mention other type")
	private WebElement otherTypeErrorMessage;

	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[4]/android.view.View")
	private WebElement autoSuggestLocationFrame;

	@AndroidFindBy(xpath = "//android.widget.Button")
	private WebElement locationCancelButton;

	public WebElement getListYourFacilityTextview() {
		return listYourFacilityTextview;
	}

	public WebElement getFacilityNameTextfield() {
		return facilityNameTextfield;
	}

	public WebElement getLocationTextfield() {
		return locationTextfield;
	}

	public WebElement getHomeFacilityImage() {
		return homeFacilityImage;
	}

	public WebElement getOfficeFacilityImage() {
		return officeFacilityImage;
	}

	public WebElement getRestrauntFacilityImage() {
		return restrauntFacilityImage;
	}

	public WebElement getOthersFacilityImage() {
		return othersFacilityImage;
	}

	public WebElement getOthersFacilityTextfield() {
		return othersFacilityTextfield;
	}

	public WebElement getNextButton() {
		return nextButton;
	}

	public WebElement getFacilityNameErrorMessage() {
		return facilityNameErrorMessage;
	}

	public WebElement getLocationErrorMessage() {
		return locationErrorMessage;
	}

	public WebElement getFacilityTypeErrorMessage() {
		return facilityTypeErrorMessage;
	}

	public WebElement getOtherTypeErrorMessage() {
		return otherTypeErrorMessage;
	}

	public WebElement getAutoSuggestLocationFrame() {
		return autoSuggestLocationFrame;
	}

	public WebElement getLocationCancelButton() {
		return locationCancelButton;
	}

}
