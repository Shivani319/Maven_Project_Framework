package com.crm.autodesk.GenericLibraries;



/**
 * This class contains all the generic methods related to webdriver actions.
 * @author saday kumar
 *
 */
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.text.Element;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;




public class WebDriverUtility {
	
	
	/**
	 * this method will wait for the page load for 20 seconds
	 */
	public void waitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	public void maximizeWindow (WebDriver driver)
	{driver.manage().window().maximize();
	}
	

	
	
	
		
		/**
		 * this method will select from dropdown using index
		 * @param element
		 * @param value
		 */
		public void select(WebElement element, String value) {
			Select sel = new Select(element);
			sel.selectByVisibleText(value);
		}
	
		/**
		 * this method will select from dropdown Using Index
		 * @param element
		 * @param value
		 */
		
		public void select(WebElement element, int index) {
			Select sel = new Select(element);
			sel.selectByIndex(index);
		}
		/**
		 *this method Using Mouse Over method using actions class
		 * @param webElement
		 * @param value
		 */
		
	
		public void mouseOver(WebDriver driver, WebElement webElement) {
			Actions act = new Actions(driver);
			act.moveToElement(webElement).perform();
		}
		public void rightClick(WebDriver driver, WebElement element) {
			Actions act = new Actions(driver);
			act.contextClick(element).perform();
		}
		public void doubleClick(WebDriver driver, WebElement element) {
			Actions act = new Actions(driver);
			act.doubleClick(element).perform();
		}
		public void acceptAlert(WebDriver driver)
		{
			driver.switchTo().alert().accept();
	
		}
		public void dismissAlert(WebDriver driver)
		{
			driver.switchTo().alert().dismiss();
		}
		public void switchToFrame(WebDriver driver, int index)
		{
			driver.switchTo().frame(index);
		}
		public void switchToFrame(WebDriver driver, String frameid)
		{
			driver.switchTo().frame(frameid);
		}
		public void switchToFrame(WebDriver driver, WebElement frameElement)
		{
			driver.switchTo().frame(frameElement);
		}
			public void switchToWindow(WebDriver driver, String partialWinTitle)
			   {
				   Set<String> window = driver.getWindowHandles();
				   Iterator<String> it = window.iterator();
				   while(it.hasNext())
				   {
					   String winId=it.next();
					   String title=driver.switchTo().window(winId).getTitle();
			           if(title.contains(partialWinTitle))
			           {
			        	   
			        	   break;
			           }
		} }
			/**
			 * This method helps to switch from one window to another
			 * 
			 * @param driver
			 * @param partialWinTitle
			 */
			public void switchwindow(WebDriver driver, String partialWinTitle) {
				String mainID = driver.getWindowHandle();
				Set<String> allID = driver.getWindowHandles();

				for (String id : allID) {
					if (!mainID.equals(allID)) {
						driver.switchTo().window(id);
						driver.close();
					}
				}
			}

	    public void waitForElementVisibility(WebDriver driver,WebElement element)
		   {
			  WebDriverWait wait = new WebDriverWait(driver, 20);
			  wait.until(ExpectedConditions.visibilityOf(element));
		   }
	    
	    
	   
//	public WebDriverUtility(WebDriver driver) {
//		PageFactory.initElements(driver, this);
//	}
	

	

}
