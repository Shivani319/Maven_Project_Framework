package com.crm.autodesk.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//rule 1: create a seperate class for every webpage
	
public LoginPage(WebDriver driver) //rule 4: create constructor and use pagefactory class to initilize
{
	PageFactory.initElements(driver, this);
	}

//rule 2: identify all the webelements using @FindBy, @FindBys, and FindAll annotation

@FindBy(name="user_name")
private WebElement userNameEdt;

@FindBy(name="user_password")
private WebElement userPasswordEdt;

@FindBy(id="submitButton")
private WebElement loinBtn;


//rule 3: Declare all the webelements as private and provide Getters

public WebElement getUserNameEdt() {
	return userNameEdt;
}

public WebElement getUserPasswordEdt() {
	return userPasswordEdt;
}

public WebElement getLoinBtn() {
	return loinBtn;
}

//rule 5: access the webelements using getters()/buisness methods
public void login(String username, String password)
{
	userNameEdt.sendKeys(username);
	userPasswordEdt.sendKeys(password);
	loinBtn.click();
	
	
	
}

}
