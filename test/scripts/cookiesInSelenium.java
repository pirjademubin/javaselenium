package scripts;

import static org.testng.Assert.assertEquals;

import java.util.Set;

import org.dataloader.impl.Assertions;
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

public class cookiesInSelenium {
	WebDriver driver;
	WebElement element;
	
	@Test
	public void addCookies() throws InterruptedException {
		driver.get("https://www.selenium.dev/selenium/web/blank.html");
		
		// Add cookie into current browser context
		driver.manage().addCookie(new Cookie("key", "value"));	
		Thread.sleep(10);
	}
	
	@Test
	public void getNamedCookie() throws InterruptedException {
		driver.get("https://www.selenium.dev/selenium/web/blank.html");
		
		// Add cookie into current browser context
		driver.manage().addCookie(new Cookie("foo", "bar"));
		
		// Get cookie details with named cookie 'foo'
		Cookie cookie = driver.manage().getCookieNamed("foo");
		System.out.println(cookie.getValue());
		Thread.sleep(10);
		assertEquals(cookie.getValue(), "bar");
	}
	
	@Test
	public void getAllCookies() throws InterruptedException {
		driver.get("https://www.selenium.dev/selenium/web/blank.html");
		
		// add cookies
		driver.manage().addCookie(new Cookie("test1", "value1"));
		driver.manage().addCookie(new Cookie("test2", "value2"));
		Thread.sleep(10);
		// get all cookies
		Set<Cookie> cookies = driver.manage().getCookies();
		
		//
		for(Cookie cookie: cookies) {
			if(cookie.getName().equals("test1")) {
				assertEquals(cookie.getValue(), "value1");
				Thread.sleep(10);
			}
		}	
		
	}
	
	@Test
	public void deleteCookieNamed() {
		driver.get("https://www.selenium.dev/selenium/web/blank.html");
		
		// add cookies
		driver.manage().addCookie(new Cookie("test1", "set1"));
		
		// delete cookie named test1
		driver.manage().deleteCookieNamed("test1");
	}
	
	@Test
	public void deleteCookieObject() {
		driver.get("https://www.selenium.dev/selenium/web/blank.html");
		
		// add coockie object
		Cookie cookie = new Cookie("test3", "value3");
		driver.manage().addCookie(cookie);
		
		/*
        Selenium Java bindings also provides a way to delete
        cookie by passing cookie object of current browsing context
        */
		driver.manage().deleteCookie(cookie);
	}
	
	@Test
    public void deleteAllCookies() {
     
        driver.get("https://www.selenium.dev/selenium/web/blank.html");
        
        // Add cookies into current browser context
        driver.manage().addCookie(new Cookie("test1", "cookie1"));
        driver.manage().addCookie(new Cookie("test2", "cookie2"));
        
        // Delete All cookies
        driver.manage().deleteAllCookies();
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
