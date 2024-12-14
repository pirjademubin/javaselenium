package scripts;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebDriverAndWebElementsMethods {
	WebDriver driver;
	WebElement element;
	
	@Test
	public void webDriverMethods() {
		driver.get("https://nichethyself.com/tourism/home.html");
		
		driver.getCurrentUrl();
		driver.getTitle();
		String pageSource = driver.getPageSource();
		
		// navigate
		driver.navigate().to("https://www.google.co.in/");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		
		// cookies
		driver.manage().deleteAllCookies();
		driver.manage().addCookie(new Cookie("key", "value"));
		
		
		// window position //point class
		driver.manage().window().maximize();
		driver.manage().window().getPosition();
		driver.manage().window().setPosition(null);
		
		
		//window size // dimension class
		driver.manage().window().setSize(null);
		driver.manage().window().getSize();
		
		String expectedPageTitle = "My account";
		element = driver.findElement(By.name("username"));
		element.sendKeys("stc123");
		
		//driver.findElement(By.name("username")).sendKeys("stc123");
		driver.findElement(By.name("password")).sendKeys("12345");
		element.submit();
		
		String actualPageTitle = driver.getTitle();
		assertEquals(actualPageTitle, expectedPageTitle);
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
	}
	
	@Test
	public void webElementMethods() {
		driver.get("https://nichethyself.com/tourism/customised.html");		
		WebElement swiss = driver.findElement(By.xpath("//label[text()='Switzerland']/input"));
		System.out.println("Is username field displayed " + swiss.isDisplayed());
		System.out.println("Is username field enabled " + swiss.isEnabled());
		
		
		driver.get("https://nichethyself.com/tourism/home.html");
		WebElement user = driver.findElement(By.name("username"));
		System.out.println("Is username field displayed " + user.isDisplayed());
		System.out.println("Is username field enabled " + user.isEnabled());
		WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
		System.out.println("Is submit button displayed " + submit.isDisplayed());
		System.out.println("Is submit button enabled " + user.isEnabled());
		
		user.sendKeys("stc123");
		// value attribute gets populated with what u typed
		// value = "stc123"
		System.out.println("username value " + user.getAttribute("value"));
		assertEquals(user.getAttribute("value"), "stc1234");
	}
	
	@BeforeMethod(alwaysRun = true)
	public void beforeMethod() {
		driver = new ChromeDriver(); // it is inside ChromeDriver.exe
		driver.manage().window().maximize();
		//driver = new FirefoxDriver(); // it is inside ChromeDriver.exe
		//driver = new SafariDriver(); // it is inside ChromeDriver.exe
		//driver = new EdgeDriver(); // it is inside ChromeDriver.exe
	}
	
	@AfterMethod(alwaysRun = true)
	public void closeDriver() {
		driver.quit();
	}

}


