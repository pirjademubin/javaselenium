package scripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AnnaAssignment17Nov {
	
	WebDriver driver;
	WebElement element;
	WebDriverWait wait;
	
	@BeforeMethod(alwaysRun = true)
	public void init() {
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	@AfterMethod(alwaysRun = true)
	public void deinit() {
		driver.quit();
	}
	
	@Test
	public void annaActions() throws InterruptedException {
		driver.get("https://www.annauniv.edu");
		
		Actions builder = new Actions(driver);		
		WebElement departments = driver.findElement(By.xpath("//a[text()='Departments']"));
		builder.moveToElement(departments).click().perform();
		
		WebElement branch = driver.findElement(By.xpath("//a[text()='Mechanical Engineering ']"));
		builder.moveToElement(branch).click().perform();
		//MoveTargetOutOfBoundsException got 
		Thread.sleep(10000);
		
		
	}
	
	

}
