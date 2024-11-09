package com.doms.WebDriverLibrary;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


/**
 * This Class Provides the Reusable Method To Perform All Browser Related Actions Actions
 * @author bhavani
 * */

public class WebDriverUtility 
{
	public WebDriver driver;
	public static WebDriver driver_static;
	public Select selectobj;
	public Actions actionsobj;
	public Robot robotobj;
	public WebDriverWait wait;
	
	/**
	 * This Method Used To Launch The Specific The Browser
	 * 
	 * @param String Browser Name
	 * @return void*/
	public void launchBrowser(String browser)
	{
		   switch(browser)
		    {
		    case "chrome":
		    	WebDriverManager.chromedriver().setup();
		    	driver = new ChromeDriver();
		    	driver_static = driver;
		    	break;
		    case "edge":
		    	WebDriverManager.edgedriver().setup();
		    	driver = new EdgeDriver();
		    	driver_static = driver;
		    	break;
		    case "firefox":
		    	WebDriverManager.firefoxdriver().setup();
		    	driver = new FirefoxDriver();
		    	driver_static = driver;
		    	break;
		    default:
		    	System.out.println("u have entered incorrect browser name");
		    	break;
		    
		    }
	}
	
	/**
	 * This Method Used To Navigate The Application
	 * 
	 * @param String URL
	 * @return void*/
	
	public void NavigateToApplication(String url)
	{
		driver.get(url);
	}
	
	/**
	 * This Method Used To Maximize The Browser
	 * 
	 * @return void*/
	
	
	public void maximizeTheBrowser()
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This Method Used To Close The Browser
	 * 
	 * @return void*/
	
	public void closeTheBrowser()
	{
		driver.close();
	}
	
	/**
	 * This Method Used To Terminate The Browser
	 * 
	 * @return void*/
	
	public void closeAllBrowser()
	{
		driver.quit();
	}
	
	
	/**
	 * This Method Used To wait 
	 * 
	 * @param Long Duration
	 * @return void*/
	
	public void waitImplicitly(long duration)
	{	
		driver.manage().timeouts().implicitlyWait(duration, TimeUnit.SECONDS);
	}

	public void waitExplicitly(long duration, WebElement element)
	{
		wait = new WebDriverWait(driver, duration);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void selectOptionsInDropdown(WebElement element, int index) //overloading
	{
		selectobj.selectByIndex(index);
	}
	
	public void selectOptionsInDropdown(WebElement element, String visibletext) //overloading
	{
		selectobj.selectByVisibleText(visibletext);
	}
	
	public void selectOptionsInDropdown(String value, WebElement element) //overloading
	{
		selectobj.deselectByValue(value);
	}
	
	public void mouseHovering(WebElement element)
	{
		actionsobj.moveToElement(element).perform();
	}
	
	// remaining actions write the click(), doubleclick(),dragAnddrop(), contextclick()
	
	public void pressTheKey_pageDown()
	{
		robotobj.keyPress(KeyEvent.VK_PAGE_DOWN);
	}
	public void ReleaseTheKey_pageDown()
	{
		robotobj.keyRelease(KeyEvent.VK_PAGE_DOWN);
	}
	
	public void alertPopupAccept()
	{
		driver.switchTo().alert().accept();
	}
	public void alertPopupDismiss()
	{
		driver.switchTo().alert().dismiss();
	}
	
	public void switchControlToFrame(int index) // method overloading
	{
		driver.switchTo().frame(0);
	}
	public void switchControlToFrame(WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	public void switchBackControlToMain()
	{
		driver.switchTo().defaultContent();
	}
	
	public void switchControlToWindow(String window_address)
	{
		//String window_id = driver.getWindowHandle();
		driver.switchTo().window(window_address);
	}
}




















