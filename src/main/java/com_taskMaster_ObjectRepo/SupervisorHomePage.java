package com_taskMaster_ObjectRepo;

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

	@AndroidFindBy(accessibility  = "Pending task\r\n"
			+ "Tab 1 of 4")
	private WebElement pendingtaskTab;

}
