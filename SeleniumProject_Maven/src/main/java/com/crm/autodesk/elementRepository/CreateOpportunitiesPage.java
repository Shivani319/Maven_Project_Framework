package com.crm.autodesk.elementRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.GenericLibraries.ExcelFileUtility;
import com.crm.autodesk.GenericLibraries.WebDriverUtility;

public class CreateOpportunitiesPage extends WebDriverUtility {
	WebDriver driver;

	public CreateOpportunitiesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		//this.driver = driver;
	}
	// locate all the elements

	@FindBy(name = "potentialname")
	private WebElement oppNameEdt;

	@FindBy(xpath = "//img[@src='themes/softed/images/select.gif']")
	private WebElement CreateRelToOrgImg;

	@FindBy(xpath = "//input[@name='search_text']")
	private WebElement createSearchEdt;

	@FindBy(name = "search")
	private WebElement searchBtn;

	@FindBy(xpath = "//a[@id=1]")
	private WebElement chLnk;

	@FindBy(name = "sales_stage")
	private WebElement salesstageDropDown;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	// provide getters
	public WebElement getOppNameEdt() {
		return oppNameEdt;
	}

	public WebElement getCreateRelToOrgImg() {
		return CreateRelToOrgImg;
	}

	public WebElement getSalesstageDropDown() {
		return salesstageDropDown;
	}

	public WebElement getCreateSearchEdt() {
		return createSearchEdt;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	// provide buisness logic

	public void createOpportunities(String OppName) {
		oppNameEdt.sendKeys(OppName);

	}

	public void clickonCreateRelToOrgImg(WebDriver driver) throws InterruptedException {
		CreateRelToOrgImg.click();
		switchToWindow(driver, "Accounts");
		Thread.sleep(2000);
		
	}

	public void clickonCreateSearchEdt(String OrgName) throws Throwable
	{
		ExcelFileUtility exlib = new ExcelFileUtility();
		 OrgName=exlib.getExcelData("Sheet1", 3, 3);
		createSearchEdt.sendKeys(OrgName);
		searchBtn.click();
	}


	public void createOpportunitiesWithSalesStage(String OppName, String salesType) {
		oppNameEdt.sendKeys(OppName);
		select(salesstageDropDown, salesType);
		
		

	}

	//span[contains(text(),'Updated')]
	@FindBy(name = "potentialname")
	private WebElement waitForUpadte;

	public WebElement getWaitForUpadte() 
	{
		return waitForUpadte;
	}
	
	public void waitForUpadte()
	{
		waitForElementVisibility(driver, waitForUpadte);
	}
	
	
	//public void saveCreateOpportunitiesData() {
		//saveBtn.click();
		
		
	//}

}
