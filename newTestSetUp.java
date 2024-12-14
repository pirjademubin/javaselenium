package scripts;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class newTestSetUp {
	
	WebDriver driver;
	WebElement element;
	
	@Test
	public void loginToNicheThyselfTourism() {
		driver.get("https://nichethyself.com/tourism/home.html");
		String expectedPageTitle = "My account";
		element = driver.findElement(By.name("username"));
		element.sendKeys("stc123");
		
		//driver.findElement(By.name("username")).sendKeys("stc123");
		driver.findElement(By.name("password")).sendKeys("12345");
		element.submit();
		
		String actualPageTitle = driver.getTitle();
		assertEquals(actualPageTitle, expectedPageTitle);
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
	}
	
	@BeforeMethod(alwaysRun = true)
	public void beforeMethod() {
		driver = new ChromeDriver(); // it is inside ChromeDriver.exe
		driver.manage().window().maximize();
		//driver = new FirefoxDriver(); // it is inside ChromeDriver.exe
		//driver = new SafariDriver(); // it is inside ChromeDriver.exe
		//driver = new EdgeDriver(); // it is inside ChromeDriver.exe
	}
	
	@AfterMethod(alwaysRun = true)
	public void closeDriver() {
		driver.quit();
	}
}


// locators
// attribute based and structure based
// id (unique, non dynamic means everytime same)
	// driver.findElement(By.id("Email"))
// name (unique, non dynamic means everytime same)
	// driver.findElement(By.name("EmailID"))
// linkText (element with tag 'a')
	// driver.findElement(By.linkText("Gmail"))
	// driver.findElement(By.partialLinkText("Inbox"))
// tagName
	// driver.findElement(By.tagName("input"))
// class (unique, non dynamic means everytime same)
	// driver.findElement(By.className("mandatory"))


// class attribute will have spaces, as class attributes belong to CSS
// so avoid using this
	// driver.findElement(By.class("mandatory"))
	// driver.findElement(By.id("Email"))
// developers will have an additional atrribute for identifying
// the  element specifivally for automation
// test-dataid
// composite class are not supported
// driver.findElement(By.className("o3j99 n1xJcf Ne6nd"))
	// selenium will give error for above one