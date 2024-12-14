package pageFactory23Nov;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class myAccount extends LoadableComponent<myAccount> {
	
	private WebDriver driver;
	String expectedPageTitle = "My account";
	
	@FindBy(xpath = "//a[@href = 'home.html']")
	private WebElement signOutLink;

	@FindBy(xpath = "//button[text()='Contact us!']")
	private WebElement contactUs;

	public myAccount(WebDriver driver) {
		this.driver = driver;
		// driver = new ChromDriver();
		// above statement is not required
		// as we dont want to open new instance of browser
		// but want to use existing one which is 
		// in STCTourism class
		PageFactory.initElements(driver, this);
	}
	
	@Override
	protected void isLoaded() throws Error {
		assertEquals(driver.getTitle(),expectedPageTitle, "My Account Page Not Loaded" );	
	}


	@Override
	protected void load() {	
		// Nothing is needed as page is already loaded and 
		// it is supposed to be in My account webpage
	}
	
	
	public myAccount goToContactUs() {		
		contactUs.click();
		return this;
	}
	
	
	public myAccount actualSwitchToWindow() {
		driver.switchTo().window("Contact");
		return this;
	}
	
	public contactUs cuActions() {
		contactUs cu = new contactUs(driver);
		return cu;
	}
	
	public Boolean switchToContactUs() {
		try {
		driver.switchTo().window("Contact");
		} catch (NoSuchWindowException e) {
			return false;
		}
		return true;
	}
	
	
	public STCTourism signOut() {
		signOutLink.click();
		return new STCTourism(driver);
	}
	
	
	public void closeBrowser() {
		driver.quit();
	}
}
