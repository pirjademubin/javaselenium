package scripts;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class orangeHRMPage {
	WebDriver driver;
	WebElement element;
	
	@BeforeMethod(alwaysRun = true)
	public void initSelenium() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.manage().window().maximize();
	}
	
	@AfterMethod(alwaysRun = true)
	public void deinitSelenium() {
		driver.quit();
	}
	
	@Test
	public void orangeLoginPage() throws InterruptedException {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		WebElement user = driver.findElement(By.name("username"));
		if(user.isDisplayed() && user.isEnabled()){
			user.sendKeys("Admin");
			assertEquals(user.getAttribute("value"), "Admin");
			user.submit();
		}
		WebElement pass = driver.findElement(By.name("password"));
		if(pass.isDisplayed() && pass.isEnabled()){
			pass.sendKeys("admin123");
			assertEquals(pass.getAttribute("value"), "admin123");
			pass.submit();
		}
		WebElement submit = driver.findElement(By.xpath("//form//button[@type='submit']"));
		if(submit.isDisplayed() && submit.isEnabled()){
			submit.click();
		}
		Thread.sleep(5000);
		WebElement afterLogin = driver.findElement(By.xpath("//p[text() = 'martina user']"));
		if(afterLogin.isDisplayed()) {
			System.out.println("Login successful");			
		}
		else {
			System.out.println("Login unsuccessful");
		}
		Thread.sleep(5000);
	}
	
	@Test
	public void wikiPediaAssgnment() throws InterruptedException {
		driver.get("https://www.wikipedia.org/");
		driver.manage().window().maximize();
		WebElement eng = driver.findElement(By.xpath("//a//strong[text()='English']"));
		eng.click();
		Thread.sleep(1000);
		WebElement search = driver.findElement(By.xpath("//input[contains(@title,'Search')]"));
		search.sendKeys("Selenium");
		//search.submit();
		Thread.sleep(1000);
		WebElement searchButton = driver.findElement(By.xpath("//form//button[text()='Search']"));
		searchButton.click();
		Thread.sleep(1000);
		String pageTitle = driver.getTitle();
		assertEquals(pageTitle, "Selenium - Wikipedia");
		
		WebElement findText = driver.findElement(By.xpath("//h1[@id='firstHeading']"));
		String actualHeading = findText.getText();
		assertEquals(actualHeading, "Selenium");
		Thread.sleep(1000);
	}
}
