package scripts;

import java.util.Set;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class navigateMethods {
	private static final Point point = null;
	WebDriver driver;
	WebElement element;
	
	@Test(alwaysRun = false)
	public void navigateTo() throws InterruptedException {
		driver.navigate().to("https://nichethyself.com/tourism/home.html");
		Thread.sleep(1000);
		String title = driver.getTitle();
		System.out.println(title);
	}
	
	@Test(alwaysRun = false)
	public void navigateBack() throws InterruptedException {
		driver.get("https://www.google.com/");
		
		driver.navigate().to("https://nichethyself.com/tourism/home.html");
		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(1000);
		String title = driver.getTitle();
		driver.navigate().forward();
		Thread.sleep(1000);
		driver.navigate().refresh();
		Thread.sleep(1000);
		System.out.println(title);
	}
	
	@Test
	public void windowMethods() throws InterruptedException {
		driver.get("https://www.google.com/");
		
		// window fullscreen
		driver.manage().window().fullscreen();
		Thread.sleep(1000);
		
		// maximize
		driver.manage().window().maximize();
		Thread.sleep(1000);
		
		// minimize
		driver.manage().window().minimize();
		Thread.sleep(1000);
		
		// get window position
		System.out.println(driver.manage().window().getPosition());
		
		// set window position
		System.out.println(driver.manage().window().getSize());
		
		driver.manage().window().setPosition(point);
		driver.manage().window().setSize(null);
	}
	
	@BeforeMethod(alwaysRun = true)
	public void initSelenium() {
		driver = new ChromeDriver();
		//driver.manage().window().maximize();
	}
	
	@AfterMethod(alwaysRun = true)
	public void deinitSelenium() {
		driver.quit();
	}
	
	
	
}


