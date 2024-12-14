package pageFactory23Nov;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class contactUs extends LoadableComponent<contactUs> {
	private WebDriver driver;
	String expectedTitle = "Contact Us";
	
	@FindBy(className="glyphicon-search")
	private WebElement searchIcon;
	
	public contactUs(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@Override
	protected void isLoaded() throws Error {
		// TODO Auto-generated method stub
		assertEquals(driver.getTitle(), expectedTitle, "Contact Page Not Loaded" );
	}

	@Override
	protected void load() {
		// TODO Auto-generated method stub
		
	}
	
	
	public contactUs searchIconClick() {
		searchIcon.click();
		return this;
	}
	
	
	public void searchCity() throws InterruptedException {
		Alert myAlert;
		
		try {
			myAlert = driver.switchTo().alert();
			myAlert.sendKeys("London");
			Thread.sleep(5000);
			myAlert.accept();
			Thread.sleep(5000);
			driver.close();
		} catch(NoAlertPresentException e) {
			fail("Alert did not found");
		}
	}
	
}
