package orangeHRM23NovpageFactory;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class orangeHRMDashboard extends LoadableComponent<orangeHRMDashboard> {
	
	private WebDriver driver;
	String expectedPageTitle = "OrangeHRM";
	
	@FindBy(xpath = "//a[@href = '/web/index.php/admin/viewAdminModule']")
	private WebElement adminPage;
	
	public orangeHRMDashboard(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@Override
	protected void isLoaded() throws Error {
		// TODO Auto-generated method stub
		assertEquals(driver.getTitle(), expectedPageTitle, "My Account Page Not Loaded" );
	}

	@Override
	protected void load() {
		// TODO Auto-generated method stub
		
	}
	
	public orangeHRMDashboard goToAdminPage() throws InterruptedException {
		Thread.sleep(3000);
		adminPage.click();
		return this;
	}
	
	public orangeHRMAdminPage AdminPageActions() {
		orangeHRMAdminPage adPage = new orangeHRMAdminPage(driver);
		return adPage;
	}

}
