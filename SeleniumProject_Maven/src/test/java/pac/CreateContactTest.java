package pac;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class CreateContactTest {
@Test
public void contactTest() throws InterruptedException {
	
	String URL = System.getProperty("url");
	String USERNAME = System.getProperty("username");
	String PASSWORD = System.getProperty("password");
	String browser = System.getProperty("browser");
	String LASTNAME = System.getProperty("lastname");
	WebDriver driver = null;
	if(browser.equals("chrome")) {
		driver = new ChromeDriver();
	}else if(browser.equals("firefox")) {
		driver = new FirefoxDriver();
	}else {
		System.out.println("invalid browser");
	}
	driver.get(URL);
	driver.manage().window().maximize();
	Thread.sleep(1000);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	driver.findElement(By.xpath("//a[text()='Contacts']")).click();
	driver.findElement(By.cssSelector("img[title='Create Contact...']")).click();
	driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
	
	
	
}


	

}
