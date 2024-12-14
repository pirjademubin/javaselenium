package orangeHRM23NovpageFactory;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;

public class orangeHRMAdminPage extends LoadableComponent<orangeHRMAdminPage>{
	
	private WebDriver driver;
	String expectedTitle = "OrangeHRM";
	
//	@FindBy(xpath = "//div[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']")
//	private WebElement dropdown;
//	
//	@FindBy(xpath = "//div[@class='oxd-select-text-input']")
//	private WebElement dropdownSel;
	
	
	public orangeHRMAdminPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@Override
	protected void isLoaded() throws Error {
		// TODO Auto-generated method stub
		assertEquals(driver.getTitle(), expectedTitle, "Admin Page Not Loaded" );
	}

	@Override
	protected void load() {
		// TODO Auto-generated method stub
		
	}
	
	public orangeHRMAdminPage editRecord(String role) throws InterruptedException{
		System.out.println("Inside editRecord");
		List<WebElement> records = driver.findElements(By.xpath(String.format("//div[@class='oxd-table-body']//div[3]//following-sibling::div[text()=%s]", role)));
		
		System.out.println(records);
		for(WebElement record: records) {
			System.out.println(record);
			System.out.println("Inside For loo[");
		}
		return this;
	}
}
