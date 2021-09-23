package com.crm_autodesk.ContactsTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericLibraries.ExcelFileUtility;
import com.crm.autodesk.GenericLibraries.JSONFileUtility;
import com.crm.autodesk.GenericLibraries.JavaUtility;
import com.crm.autodesk.GenericLibraries.WebDriverUtility;


public class TC_01_CreateContactWithOrganization {
	WebDriver driver;
	

	@Test
	public void createContact() throws Throwable {
		//read all the data
		//then we create JSON file
		JSONFileUtility Jsonlib = new JSONFileUtility();
		ExcelFileUtility ELib = new ExcelFileUtility();
		WebDriverUtility WebLib = new WebDriverUtility();
		JavaUtility JLib = new JavaUtility();

		//Accessing common data from Json file
		String URL = Jsonlib.readDataFromJSON("url");
		String USERNAME = Jsonlib.readDataFromJSON("username");
		String PASSWORD = Jsonlib.readDataFromJSON("password");
		String BROWSER = Jsonlib.readDataFromJSON("browser");
		String OrgName = ELib.getExcelData("Sheet1", 1, 3);
		String Contact = ELib.getExcelData("Sheet1", 1, 2);
		//Launch Browser
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			System.out.println("invalid browser");
		}

		//Apply Implicit wait
		WebLib.waitForPageLoad(driver);

		driver.get(URL);
		

		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(Contact);
		driver.findElement(By.xpath("//img[@title='Select']")).click();

		WebLib.switchToWindow(driver, "Accounts" );

		driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(OrgName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText("ch")).click();
		//Switch back to parent window
		WebLib.switchToWindow(driver, "Contact");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//WebLib.waitForElementVisibility(driver, driver.findElement(By.xpath("//a[contains(text(),'TestYantra')]")));

		

}
}