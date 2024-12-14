package pageObjectDesignPatternWithPageFactory;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

public class orangeHRM extends LoadableComponent<orangeHRM> {
	
	WebDriver driver;
	WebDriverWait wait;
	String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	
	@FindBy (name = "username")
	@CacheLookup
	WebElement username;
	
	@FindBy (name = "password")
	WebElement password;
	
	@FindBy (xpath = "//form//button[@type='submit']")
	WebElement submit;
	
	
	public orangeHRM() {
		driver = new ChromeDriver();
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
		// load(); // loads the site
		// isLoaded(); // checks if element loaded or not
		
		// checks first via isLoaded() method if element is loaded or not
		// if not loaded loads it via load() method
		// then agains checks via isLoaded() method if element loaded or not
		get(); 
	}
	
	@Override
	protected void isLoaded() throws Error {		
		assertEquals(driver.getTitle(), "OrangeHRM");
	}

	@Override
	protected void load() {
		driver.get(url);
	}
	
	
	public void signIn(String user, String pass) {
		wait.until(ExpectedConditions.visibilityOfAllElements(username));
		username.sendKeys(user);
		password.sendKeys(pass);
		submit.click();
	}
	
	public String getPageTitleAfterLogin() {
		return driver.getTitle();
	}
	
	public void closeBrowser() {
		driver.quit();
	}
	
	
	
}
