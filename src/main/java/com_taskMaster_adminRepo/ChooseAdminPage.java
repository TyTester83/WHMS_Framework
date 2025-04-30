package com_taskMaster_adminRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ChooseAdminPage {

	public AppiumDriver driver;

	public ChooseAdminPage(AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@iOSXCUITFindBy()
	@AndroidFindBy(accessibility = "Monitor \r\n" + "Yourself")
	private WebElement monitorYourselfTextview;

	@iOSXCUITFindBy()
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Monitor \r\n"
			+ "Yourself\"]/android.widget.ImageView[2]")
	private WebElement yourselfTickIcon;

	@iOSXCUITFindBy()
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Assign a \r\n" + "Supervisor\"]")
	private WebElement supervisorTextview;

	@iOSXCUITFindBy()
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Assign a \r\n"
			+ "Supervisor\"]/android.widget.ImageView[2]")
	private WebElement supervisorTickIcon;

	public WebElement getMonitorYourselfTextview() {
		return monitorYourselfTextview;
	}

	public WebElement getYourselfTickIcon() {
		return yourselfTickIcon;
	}

	public WebElement getSupervisorTextview() {
		return supervisorTextview;
	}

	public WebElement getSupervisorTickIcon() {
		return supervisorTickIcon;
	}

}
