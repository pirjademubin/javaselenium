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

public class tripHobo17Nov {
	WebDriver driver;
	WebElement element;
	WebDriverWait wait;
	
	@BeforeMethod(alwaysRun = true)
	public void init() {
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	
	@AfterMethod(alwaysRun = true)
	public void deinit() {
		driver.quit();
	}
	
	@Test
	public void annaActions() throws InterruptedException {
		driver.get("https://www.triphobo.com/");
		driver.findElement(By.xpath("//a[text()='Plan Your Next Vacation']")).click();
		
		// search Houston, Texas, United States
		driver.findElement(By.xpath("//input[@placeholder='Where do you want to go?']")).sendKeys("Hou");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='js-suggestions']//*[text()='Houston, Texas, United States']")));
		driver.findElement(By.xpath("//div[@id='js-suggestions']//*[text()='Houston, Texas, United States']")).click();
		//Actions builder = new Actions(driver);
		//builder.moveToElement(departments).perform();
		//Thread.sleep(5000);
		//getting timeout exception
		//Thread.sleep(5000);
		
		driver.findElement(By.xpath("//input[@placeholder='Start Date']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='ui-datepicker-div']//td[@data-month='11'][@data-year='2024']//a[text()='1']")));
		driver.findElement(By.xpath("//div[@id='ui-datepicker-div']//td[@data-month='11'][@data-year='2024']//a[text()='1']")).click();
		//System.out.println(datepicker.getText());
		//Thread.sleep(5000);
		
		driver.findElement(By.xpath("//input[@placeholder='End Date']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='ui-datepicker-div']//td[@data-month='11'][@data-year='2024']//a[text()='12']")));
		driver.findElement(By.xpath("//div[@id='ui-datepicker-div']//td[@data-month='11'][@data-year='2024']//a[text()='12']")).click();
		driver.findElement(By.xpath("//div[@class='button-box']//span")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='js_city_step_next']")));
		driver.findElement(By.xpath("//span[@id='js_city_step_next']")).click();
		Thread.sleep(3000);
		// if above wait is not given then, element not interceptable error is coming
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='js_city_step_next']")));
		// wait until clickable
		driver.findElement(By.xpath("//span[@id='js_city_step_next']")).click();
		Thread.sleep(3000);
		// if above wait is not given then, element not interceptable error is coming
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='js_city_step_next']")));
		driver.findElement(By.xpath("//span[@id='js_city_step_next']")).click();
		Thread.sleep(3000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='icon-close']")));
		driver.findElement(By.xpath("//span[@class='icon-close']")).click();
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='icon-close-modal']")));
		//driver.findElement(By.xpath("//div[@class='icon-close-modal']")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Edit This Plan']")));
		driver.findElement(By.xpath("//span[text()='Edit This Plan']")).click();
		Thread.sleep(3000);
		
//		WebElement source = driver.findElement(By.xpath("//div[text()='Johnson Space Center']"));
//		WebElement target = driver.f
	}
}
