package pageFactory23Nov;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestSTCTourism {
	STCTourism homePage;
	myAccount myAcc;//myAcc = STCTourism ka acc in login method
	contactUs cu;
	//@Test
	public void loginToNicheThyselfTourism() throws InterruptedException {
		homePage.login("stc123", "12345");		
		assertEquals(homePage.getPageTitleAfterLogin(), "My account");
	}
	
	//@Test
	public void loginAndTakeActionInMyAccount() throws InterruptedException {
		myAcc = homePage.login("stc123", "12345");		
		myAcc.goToContactUs();		
		assertEquals(myAcc.switchToContactUs(), true, "Contact Us Window is Opened");
	}

	@Test
	public void loginAndTakeActionInMyAccount1() throws InterruptedException {
		//driver.findElement().click()
//		homePage.login("stc123", "12345")
//		        .goToContactUs()
//		        .signOut()
//		        .login("stc123","12345");
//		assertEquals(myAcc.switchToContactUs(), true, "Contact Us Window is Opened");
		homePage.login("stc123", "12345").goToContactUs().actualSwitchToWindow().cuActions().searchIconClick().searchCity();
		Thread.sleep(5000);
	}

	@BeforeMethod(alwaysRun = true)
	public void beforeMethod() {
		homePage = new STCTourism();
		
	}

	@AfterMethod(alwaysRun = true)
	public void closeDriver() {
		homePage.closeBrowser();
	}

}
