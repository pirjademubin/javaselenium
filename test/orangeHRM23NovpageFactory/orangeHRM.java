package orangeHRM23NovpageFactory;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

public class orangeHRM extends LoadableComponent<orangeHRM>{
	
	WebDriver driver;
	WebElement element;
	WebDriverWait wait;
	String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	
	@FindBy(name = "username")
	private WebElement user;
	
	@FindBy(name = "password")
	private WebElement pass;
	
	@FindBy(xpath = "//form//button[@type='submit']")
	private WebElement submit;
	
	public orangeHRM() {
		driver = new ChromeDriver();
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
		get();
	}
	
	public orangeHRM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
		get();
	}
	
	@Override
	protected void isLoaded() throws Error {
		// TODO Auto-generated method stub
		assertEquals(driver.getTitle(), "OrangeHRM","Application Loading Error!!" );
	}

	@Override
	protected void load() {
		// TODO Auto-generated method stub
		driver.get(url);
	}
	
	public orangeHRMDashboard signIn(String user, String pass) {
		wait.until(ExpectedConditions.visibilityOfAllElements(this.user));
		this.user.sendKeys(user);
		this.pass.sendKeys(pass);
		this.submit.click();
		orangeHRMDashboard od = new orangeHRMDashboard(driver);
		return od;
	}
	
	public String getPageTitleAfterLogin() {
		return driver.getTitle();
	}
	
	public void closeBrowser() {
		driver.quit();
	}

	
	
	
	
}
