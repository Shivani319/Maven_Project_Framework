package com.crm.autodesk.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.GenericLibraries.WebDriverUtility;

public class OpportunitiesPage extends WebDriverUtility {
	
	public OpportunitiesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//locate all elements
	
	@FindBy(xpath = "//img[@alt='Create Opportunity...']")
	private WebElement createOppImg;
	
	@FindBy(name = "search_text")
	private WebElement searchEdt;
	
	@FindBy(name = "submit")
	private WebElement submitBtn;

	//provide getters
	public WebElement getCreateOppImg() {
		return createOppImg;
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	//provide buisness logic
	
	public void clickonCreateOppImg() {
		createOppImg.click();
		
	}
	
	

}
