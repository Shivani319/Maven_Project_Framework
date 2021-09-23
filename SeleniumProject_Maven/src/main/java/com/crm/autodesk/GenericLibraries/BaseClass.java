package com.crm.autodesk.GenericLibraries;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.crm.autodesk.elementRepository.HomePage;
import com.crm.autodesk.elementRepository.LoginPage;



public class BaseClass {

	public JSONFileUtility jse = new JSONFileUtility();
	public JavaUtility ju = new JavaUtility ();
	public ProprtyFileUtility pfu = new ProprtyFileUtility();
	public ExcelFileUtility exlib = new ExcelFileUtility ();
	//		public WebDriverUtility wlib = new WebDriverUtility (driver);
	public DataBaseUtility dblib = new DataBaseUtility();
	public WebDriver driver;
	public static WebDriver staticDriver;
	
	public WebDriverUtility wlib = new WebDriverUtility ();

	@BeforeSuite
	public void connectToDB() throws Throwable
	{
		//dblib.connectToDb();
		System.out.println("MakeDBConnection");
	}

	@BeforeClass
	public void launchBrowser() throws Throwable
	{
		String BROWSER = jse.readDataFromJSON("browser");
		String URL = jse.readDataFromJSON("url");
		if(BROWSER.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(BROWSER.equals("MsEdge"))
		{
			driver = new EdgeDriver();
		}

		wlib.maximizeWindow(driver);
		wlib.waitForPageLoad(driver);
		driver.get(URL);
		staticDriver = driver;
	}

	@BeforeMethod
	public void loginToApp() throws Throwable
	{
		String USERNAME = jse.readDataFromJSON("username");
		String PASSWORD = jse.readDataFromJSON("password");
		LoginPage lp = new LoginPage(driver);
		lp.login(USERNAME, PASSWORD);
	}

	@AfterMethod
	public void logout()
	{
		HomePage hp = new HomePage(driver);
		hp.signout(driver);		
	}

	@AfterClass
	public void closeBrowser()
	{
		driver.close();
	}

	@AfterSuite
	public void closeDB() throws Throwable
	{
		//dblib.closeDb();
		System.out.println("CloseDBConnection");
	}

	//Screenshots method
	public String getscreenshot(String name) throws IOException 
	{
		File srcfile=((TakesScreenshot)staticDriver).getScreenshotAs(OutputType.FILE);
		String destfile=System.getProperty("user.dir")+"/screenshots/"+name+".png";
		File finaldest=new File(destfile);
		FileUtils.copyFile(srcfile, finaldest);
		//FileUtils.copyFile(srcfile,finaldest);
		return destfile;
	}

}


