package com.crm.autodesk.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.GenericLibraries.WebDriverUtility;

public class HomePage extends WebDriverUtility {
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
@FindBy(linkText = "Organizations")
private WebElement organizatonLnk;

@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
private WebElement administatorImg;

@FindBy(xpath = "//a[text()='Sign Out']")
private WebElement signoutLnk;

@FindBy(linkText = "Contacts")
private WebElement contactsLnk;

@FindBy(linkText = "Products")
private WebElement productsLnk;

@FindBy(linkText = "Email")
private WebElement emailLnk;

@FindBy(xpath = "//a[. = 'Opportunities']")
private WebElement opportunitiesLnk;

@FindBy(linkText = "Leads")
private WebElement leadsLnk;

//generate getters

public WebElement getOrganizatonLnk() {
	return organizatonLnk;
}

public WebElement getAdministatorImg() {
	return administatorImg;
}

public WebElement getSignoutLnk() {
	return signoutLnk;
}

public WebElement getContactsLnk() {
	return contactsLnk;
}

public WebElement getProductsLnk() {
	return productsLnk;
}

public WebElement getEmailLnk() {
	return emailLnk;
}

public WebElement getOpportunitiesLnk() {
	return opportunitiesLnk;
}

public WebElement getLeadsLnk() {
	return leadsLnk;
}

//provide buisness logic

public void clickOnOrganizations() {
	organizatonLnk.click();
}
public void cliclOnContacts() {
	contactsLnk.click();
}
public void signout(WebDriver driver) {
	mouseOver(driver, administatorImg);
	signoutLnk.click();
	}
public void clickOnLeads() {
	leadsLnk.click();
}
public void clickOnOpportunities() {
	opportunitiesLnk.click();
	
}



}
