package com_taskMaster_objectRepo_Supervisor;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ClusterPage {
	
	public AndroidDriver driver;

	public ClusterPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Cluster\"]")
	private WebElement clusterTextView;
	
	@AndroidFindBy(xpath = "//android.widget.Button")
	private WebElement searchButton;
	
	@AndroidFindBy(accessibility = "Back")
	private WebElement backButton;
	
	@AndroidBy(className = "android.widget.EditText")
	private WebElement searchTextField;
	

	public WebElement getClusterTextView() {
		return clusterTextView;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public WebElement getBackButton() {
		return backButton;
	}

	public WebElement getSearchTextField() {
		return searchTextField;
	}
	
	 

}
