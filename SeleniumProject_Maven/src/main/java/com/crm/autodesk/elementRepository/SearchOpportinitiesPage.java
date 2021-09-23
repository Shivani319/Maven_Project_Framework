package com.crm.autodesk.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.GenericLibraries.ExcelFileUtility;
import com.crm.autodesk.GenericLibraries.WebDriverUtility;

public class SearchOpportinitiesPage extends WebDriverUtility {
	WebDriver driver;
	public SearchOpportinitiesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//locate all elements
	
	@FindBy(xpath = "//body[@class='small']")
	private WebElement framelement;
	
	@FindBy(xpath = "//input[@name='search_text']")
	private WebElement createSearchEdt;
	
	@FindBy(name = "search")
	private WebElement searchBtn;
	
	@FindBy(xpath = "//a[@id=1]")
	private WebElement orgData;
	
	
	//provide getters
	
	
	public WebElement getFramelement() {
		return framelement;
	}

	public WebElement getCreateSearchEdt() {
		return createSearchEdt;
	}
	
	public WebElement getSearchBtn() {
		return searchBtn;
	}

	
	public WebElement getOrgData() {
		return orgData;
	}

	public void createSearchOrganization() throws Throwable {
		ExcelFileUtility exlib = new ExcelFileUtility();
		String OrgName=exlib.getExcelData("Sheet1", 1, 3);
		createSearchEdt.sendKeys(OrgName);
		searchBtn.click();
        orgData.click();
		//switchToWindow(driver, "Potentials");
		
		
		
	}
	
	
	

}
