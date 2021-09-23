package com.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericLibraries.JSONFileUtility;

public class DyanmicWebTable {
	
	WebDriver driver;

@SuppressWarnings("deprecation")
@Test
public void handlingDynamicWebtable() throws Throwable
{
	JSONFileUtility jsonLib = new JSONFileUtility();
	String BROWSER = jsonLib.readDataFromJSON("browser");
	String URL = jsonLib.readDataFromJSON("url");
	String USERNAME = jsonLib.readDataFromJSON("username");
	String PASSWORD = jsonLib.readDataFromJSON("password");
	if(BROWSER.equalsIgnoreCase("chrome"))
	{
		driver = new ChromeDriver();
	}
	else if(BROWSER.equalsIgnoreCase("firefox"))
	{
		driver = new FirefoxDriver();
	}
	driver.get(URL);
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	driver.findElement(By.linkText("Organizations")).click();
	List<WebElement> list = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input[@name='selectall']"));
	for (WebElement web : list) {
		web.click();
	}
	{
	
	
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			
	}
	
	

		

}
}