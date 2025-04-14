package Utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class WebDriverUtility {

	public void waitforpageLoad(WebDriver webDriver,int t)
	{
		
		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(t));
	}
	public void waitforElementPresent(WebDriver webDriver,WebElement ele)
	{
		WebDriverWait wait=new WebDriverWait(webDriver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	public void switchtoNewBrowserTab(WebDriver webDriver,String partialurl)
	{
		 Set<String> ele = webDriver.getWindowHandles();
		 Iterator<String> it = ele.iterator();
		 while(it.hasNext())
		 {
			String windowId= it.next();
			webDriver.switchTo().window(windowId);
			String P_url=webDriver.getCurrentUrl();
			if(P_url.contains(partialurl))
			{
				break;
			}
		 }
	}
	public void switchtoTabOnTitle(WebDriver webDriver,String partialTitle)
	{
		 Set<String> ele = webDriver.getWindowHandles();
		 Iterator<String> it = ele.iterator();
		 while(it.hasNext())
		 {
			String windowId= it.next();
			webDriver.switchTo().window(windowId);
			String title=webDriver.getTitle();
			if(title.contains(partialTitle))
			{
				break;
			}
		 }
	}

	public void switchtoFrame(WebDriver webDriver,int index) 
	{
		webDriver.switchTo().frame(index);
	}

	public void switchtoFrame(WebDriver webDriver,String nameId) 
	{
		webDriver.switchTo().frame(nameId);
	}

	public void switchtoFrame(WebDriver webDriver,WebElement ele) 
	{
		webDriver.switchTo().frame(ele);
	}

	public void switchtoAlertandAccept(WebDriver webDriver)
	{  Alert alt = webDriver.switchTo().alert();
		alt.accept();
	}

	public String switchtoAlertAcceptMessage(WebDriver webDriver)
	{  Alert alt = webDriver.switchTo().alert(); 
	String act_message=alt.getText();
	alt.accept();
	return act_message;
	}
	public void switchtoAlertandCancel(WebDriver webDriver)
	{
		webDriver.switchTo().alert().dismiss();
	}

	public void select(WebElement ele,int index)
	{
		Select sel=new Select(ele);
		sel.selectByIndex(index);
	}
	public void select(WebElement ele,String text)
	{
		Select sel=new Select(ele);
		sel.selectByVisibleText(text);
	}
	public void selectvalue(WebElement ele,String text)
	{
		Select sel=new Select(ele);
		sel.selectByValue(text);
	}

	public void mousemoveOnElement(WebDriver webDriver,WebElement ele)
	{
		Actions act=new Actions(webDriver);
		act.moveToElement(ele).perform();
	}
	public void doubleclick(WebDriver webDriver,WebElement ele)
	{
		Actions act=new Actions(webDriver);
		act.doubleClick(ele).perform();
	}
	public void rightClick(WebDriver webDriver,WebElement ele) {
		Actions act=new Actions(webDriver);
		act.contextClick(ele).perform();
	}
	public void leftClick(WebDriver webDriver,WebElement ele) {
		Actions act=new Actions(webDriver);
		act.click(ele).perform();
	}
	public void dragAndDrop(WebDriver webDriver,WebElement src,WebElement dst) {
		Actions act=new Actions(webDriver);
		act.dragAndDrop(src,dst).perform();
	}
	public void scrollToElementAction(WebDriver webDriver,WebElement ele) {
		Actions act=new Actions(webDriver);
		act.scrollToElement(ele).perform();
	}


	public void screenshotOnBrowser(WebDriver webDriver) throws IOException
	{
		Date d=new Date();
		String s=d.toString();
		s.replaceAll(":", "-");
		TakesScreenshot ts=(TakesScreenshot)webDriver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dst=new File("./photo/"+s+".jpeg");
		FileHandler.copy(src, dst);
	}
	public void screenshotOnElement(WebElement ele) throws IOException
	{
		Date d=new Date();
		String s=d.toString();
		s.replaceAll(":", "-");
		File src=ele.getScreenshotAs(OutputType.FILE);
		File dst=new File("./photo/"+s+".jpeg");
		FileHandler.copy(src, dst);
	}
	public WebDriver launchingBrowser(String browser) {
		WebDriver webDriver=null;
		
		if(browser.equals("chrome"))
		{
			webDriver=new ChromeDriver();
		}
		else if (browser.equals("firefox")) {
			webDriver =new FirefoxDriver();
		}
		else if(browser.equals("edge"))
		{
			webDriver =new EdgeDriver();
		}
		
		return webDriver;
	}
	public void navigateAction(WebDriver webDriver,String act)
	{
		
		if (act.contains("refresh")) {
			webDriver.navigate().refresh();
		}
		else if (act.contains("back")) {
			webDriver.navigate().back();
		}
		else if (act.contains("forward")) {
			webDriver.navigate().forward();
		}
		else
		{
			webDriver.manage().window().maximize();
		}
	}
	public void sendDatatoDisbledElement(WebDriver webDriver,String data,String id)
	{
		JavascriptExecutor js=(JavascriptExecutor) webDriver;
		js.executeScript("document.getElementById('"+id+"').value='"+data+"'");
	}
	public void scrollByElement(WebDriver webDriver,int x,int y)
	{
		JavascriptExecutor js=(JavascriptExecutor) webDriver;
		js.executeScript("window.scrollBy("+x+","+y+")");
	}

	public void zoominAndzoomOut(WebDriver webDriver,int x) {
		JavascriptExecutor js=(JavascriptExecutor) webDriver;
		js.executeScript("document.body.style.zoom='"+x+"%'");
	}

	public void closeTab(WebDriver webDriver)
	{
		webDriver.close();
	}
	public void closeTabAll(WebDriver webDriver)
	{
		webDriver.quit();
	}

	}

