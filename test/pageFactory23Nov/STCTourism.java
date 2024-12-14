package pageFactory23Nov;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

public class STCTourism extends LoadableComponent<STCTourism> {
	
	WebDriver driver;
	WebElement element;
	WebDriverWait wait;
	
	@FindBy(name = "username")
	private WebElement user;
	
	@FindBy(name = "password")
	private WebElement pass;
	
	@FindBy(xpath = "//form[@name='loginform']/button")
	private WebElement submit;
	
	private String url = "https://nichethyself.com/tourism/home.html";
	
	public STCTourism() {
		//driver = new ChromeDriver();
		driver = new FirefoxDriver();
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
		get();
	} 
	
	public STCTourism(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
		get();

	}

	@Override
	protected void isLoaded() throws Error {
		// TODO Auto-generated method stub
		assertEquals(driver.getTitle(), "STC Tourism","Application Loading Error!!" );
	}

	@Override
	protected void load() {
		// TODO Auto-generated method stub
		driver.get(url);
	}
	
	public myAccount login(String user, String pass) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfAllElements(this.user));
		this.user.clear();
		// driver.navigate().refresh();
		this.user.sendKeys(user);
		//Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfAllElements(this.pass));
		this.pass.sendKeys(pass);
		submit.click();
		myAccount acc = new myAccount(driver);
		return acc;
	}
	
	
//	public contactUs cuActions() {
//		Alert myAlert;
//		
//		try {
//			myAlert = driver.switchTo().alert();
//			myAlert.sendKeys("London");
//			myAlert.accept();	
//			driver.close();
//		} catch(NoAlertPresentException e) {
//			fail("Alert did not found");
//		}
//		contactUs cu = new contactUs(driver);
//		return cu;
//	}
	
	public String getPageTitleAfterLogin() {

		return driver.getTitle();
	}
	
	public void closeBrowser() {
		driver.quit();
	}
}
