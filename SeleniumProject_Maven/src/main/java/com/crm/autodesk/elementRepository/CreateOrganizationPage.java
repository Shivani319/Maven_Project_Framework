package com.crm.autodesk.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.GenericLibraries.WebDriverUtility;

public class CreateOrganizationPage extends WebDriverUtility {
	WebDriver driver;
	//constructor
	public CreateOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//locate all alements
	
	@FindBy(name = "accountname")
	private WebElement orgNameEdt;
	
	@FindBy(name = "industry")
	private WebElement industryDropDown;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//provide getters

	public WebElement getOrgNmaeEdt() {
		return orgNameEdt;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//provide buisness logic
	/**
	 * This method will create organization with manddatory field
	 * @param OrgName
	 */
	
	public void createOrganization(String OrgName) {
		orgNameEdt.sendKeys(OrgName);
		saveBtn.click();
	}
	/**
	 * This method will create Organization by choosing an industry type
	 * @param OrgName
	 * @param indType
	 */
	
	public void createOrganizationWithIndustry(String OrgName, String indType)
	{
		orgNameEdt.sendKeys(OrgName);
		select(industryDropDown, indType);
		saveBtn.click();
		
		
	}

	
	
	

}
