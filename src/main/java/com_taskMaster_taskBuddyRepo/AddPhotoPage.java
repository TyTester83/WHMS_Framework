package com_taskMaster_taskBuddyRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AddPhotoPage {

	public AndroidDriver driver;

	public AddPhotoPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(accessibility = "Back")
	private WebElement backButton;

	@AndroidFindBy(accessibility = "Add Photos of loo")
	private WebElement addPhotoTextview;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Add Photo\"][1]")
	private WebElement addPhoto1View;

	@AndroidFindBy(xpath = "//android.widget.EditText")
	private WebElement remarksTextfield;

	@AndroidFindBy(accessibility = "Submit")
	private WebElement submitButton;

	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[6]")
	private WebElement photoButton;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Add Photos of loo\"]/parent::android.view.View/descendant::android.widget.ImageView[1]/following-sibling::android.view.View[1]")
	private WebElement delete1stPhotoImage;
	
	@AndroidFindBy(accessibility = "Yes")
	private WebElement yesSubmitButton;
	
	@AndroidFindBy(accessibility = "Cancel")
	private WebElement cancelSubmitButton;

	public WebElement getBackButton() {
		return backButton;
	}

	public WebElement getAddPhotoTextview() {
		return addPhotoTextview;
	}

	public WebElement getAddPhoto1View() {
		return addPhoto1View;
	}

	public WebElement getRemarksTextfield() {
		return remarksTextfield;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}

	public WebElement getPhotoButton() {
		return photoButton;
	}

	public WebElement getDelete1stPhotoImage() {
		return delete1stPhotoImage;
	}

	public WebElement getYesSubmitButton() {
		return yesSubmitButton;
	}

	public WebElement getCancelSubmitButton() {
		return cancelSubmitButton;
	}

}
