package scripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertsPopups10Oct {
	WebDriver driver;
	WebElement element;
	
	@BeforeMethod(alwaysRun = true)
	public void init() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	
	@AfterMethod(alwaysRun= true)
	public void deinit() {
		driver.quit();
	}
	
	
	public void firstAssgnment() throws InterruptedException {
		driver.get("https://nichethyself.com/tourism/home.html");
		String parentwindow = driver.getWindowHandle();
		
		WebElement first = driver.findElement(By.xpath("//a[text()='Customized tours']"));
		first.click();
		//Thread.sleep(3000);
		
		Set<String> childWindow = driver.getWindowHandles();
		for(String oneWindow : childWindow) {
			if(oneWindow != parentwindow) {
				driver.switchTo().window(oneWindow);
			}
		}
		//driver.switchTo().activeElement();
		String changedWindow = driver.getWindowHandle();
		WebElement nextPage = driver.findElement(By.id("days"));
		
		Select prefStay = new Select(nextPage);
		
		prefStay.selectByVisibleText("Home Stay");
		//Thread.sleep(5000);		
		
		WebElement checkbox = driver.findElement(By.xpath("//form//div[3]/label"));
		checkbox.click();
		
		WebElement contactUs = driver.findElement(By.xpath("//button[text()='Contact us!']"));
		contactUs.click();
		
		driver.switchTo().window("Contact");
		driver.findElement(By.className("glyphicon-search")).click();
		Thread.sleep(5000);
		
		Alert myAlert;
		
		try {
			myAlert = driver.switchTo().alert();
			myAlert.sendKeys("London");
			
			myAlert.accept();	
			driver.close();
		} catch(NoAlertPresentException e) {
			fail("Alert did not found");
		}
		
		driver.switchTo().window(changedWindow);
		
		
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		Thread.sleep(5000);
		Alert newAlert;
		newAlert = driver.switchTo().alert();
		newAlert.accept();
		Thread.sleep(5000);
	}	
	
	
	public void goIbibo() throws InterruptedException {
		driver.get("https://www.goibibo.com/");
		Thread.sleep(5000);
		//String popupwindow = driver.getWindowHandle();
		
		WebElement closepopup = driver.findElement(By.xpath("//span[@class='logSprite icClose']"));
		closepopup.click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Ben");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(text(),'luru')]")).click();
		Thread.sleep(3000);
		/*
		Alert ibiboAlert;
		try {
			ibiboAlert = driver.switchTo().alert();
			ibiboAlert.dismiss();	
			Thread.sleep(5000);
			//driver.close();
		} catch(NoAlertPresentException e) {
			fail("Alert did not found");
		}
		*/
		//Thread.sleep(5000);
	}
	
	
	public void herokuapp() throws InterruptedException {
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		driver.findElement(By.xpath("//div//button[text()='Click for JS Alert']")).click();
		Alert JSAlert;
		try {
			JSAlert = driver.switchTo().alert();
			Thread.sleep(3000);
			JSAlert.accept();
			Thread.sleep(3000);
			//driver.close();
		} catch(NoAlertPresentException e) {
			fail("Alert did not found");
		}
		
		driver.findElement(By.xpath("//div//button[text()='Click for JS Confirm']")).click();
		Alert JSConfirmAlert;
		try {
			JSConfirmAlert = driver.switchTo().alert();
			Thread.sleep(3000);
			JSConfirmAlert.dismiss(); // to dismiss or cancel the alert
			//JSConfirmAlert.accept(); //to accept the alert
			Thread.sleep(3000);
			//driver.close();
		} catch(NoAlertPresentException e) {
			fail("Alert did not found");
		}
		
		driver.findElement(By.xpath("//div//button[text()='Click for JS Prompt']")).click();
		Alert JSPromptAlert;
		try {
			JSPromptAlert = driver.switchTo().alert();
			Thread.sleep(3000);
			JSPromptAlert.sendKeys("India");
			JSPromptAlert.accept();
			Thread.sleep(3000);
			//driver.close();
		} catch(NoAlertPresentException e) {
			fail("Alert did not found");
		}
		
	}
	
	@Test
	public void multiWindows() throws InterruptedException {
		driver.get("https://the-internet.herokuapp.com");
		driver.findElement(By.xpath("//a[text()='Multiple Windows']")).click();
		String parentHandle1 = driver.getWindowHandle();
		
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();
		
		Set<String> childWindow1 = driver.getWindowHandles();
		for(String oneWindow : childWindow1) {
			if(oneWindow != parentHandle1) {
				driver.switchTo().window(oneWindow);
			}
		}
		
		String data = driver.findElement(By.xpath("//h3[text()='New Window']")).getText();
		assertEquals(data, "New Window");
		Thread.sleep(3000);
		
		
	}

}
