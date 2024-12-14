package pageObjectDesignPattern;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class orangeHRM {
	
	WebDriver driver;
	WebDriverWait wait;
	String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	
	By username = By.name("username");
	By password = By.name("password");
	By submit = By.xpath("//form//button[@type='submit']");
	
	public orangeHRM() {
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(url);		
	}
	
	public void signIn(String user, String pass) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(username));
		driver.findElement(username).sendKeys(user);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(submit).click();
	}
	
	public String getPageTitleAfterLogin() {
		return driver.getTitle();
	}
	
	public void closeBrowser() {
		driver.quit();
	}
	
	
	
}
