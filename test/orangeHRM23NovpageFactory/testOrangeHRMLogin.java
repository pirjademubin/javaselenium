package orangeHRM23NovpageFactory;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testOrangeHRMLogin {
	orangeHRM homePage;
	orangeHRMDashboard odash;
	
	
	@BeforeMethod(alwaysRun = true)
	public void initOrangeHRM() {
		homePage = new orangeHRM();
		assertEquals(homePage.getPageTitleAfterLogin(), "OrangeHRM");
	}
	
	@AfterMethod(alwaysRun = true)
	public void deinitOrangeHRM() {
		homePage.closeBrowser();
	}
	
	@Test
	public void loginToOrangeHRM() throws InterruptedException {
		homePage.signIn("Admin", "admin123").goToAdminPage().AdminPageActions().editRecord("Admin");
		Thread.sleep(5000);
	}

}
