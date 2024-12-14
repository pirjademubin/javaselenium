package scripts;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaAssignments10OCt {
	WebDriver driver;
	WebElement element;
	
	@BeforeMethod(alwaysRun=true)
	public void beforeTest() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
	}
	
	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		driver.quit();
	}
	
	
	public void dropDown() throws InterruptedException {
		driver.get("https://nichethyself.com/tourism/explore.html#contact");
		
		WebElement dropdown = driver.findElement(By.id("sel"));
		
		Select prefCity = new Select(dropdown);
		prefCity.selectByVisibleText("Mumbai");
		//Thread.sleep(5000);
		prefCity.selectByVisibleText("Kolkata");
		//Thread.sleep(5000);
		prefCity.selectByVisibleText("Jaipur");
		//Thread.sleep(5000);
		
		List<WebElement> allselectedOptions = prefCity.getAllSelectedOptions();
		
		for(WebElement oneOption : allselectedOptions) {
			System.out.println(oneOption.getText());
		}
		
		System.out.println(prefCity.isMultiple());
		
		
	}
	
	
	public void dropdown2() throws InterruptedException {
		driver.get("https://the-internet.herokuapp.com/dropdown");
		
		WebElement dropdown2 = driver.findElement(By.id("dropdown"));
		Select prefOptions = new Select(dropdown2);
		
		prefOptions.selectByVisibleText("Option 1");
		Thread.sleep(3000);
		prefOptions.selectByVisibleText("Option 2");
		
		Thread.sleep(3000);
		List<WebElement> alloptionsSelected = prefOptions.getAllSelectedOptions();
		
		for(WebElement oneSOption : alloptionsSelected) {
			System.out.println(oneSOption.getText());
		}
		
		System.out.println(prefOptions.isMultiple());	
	}
	
	@Test
	public void dropdown3() throws InterruptedException {
		driver.get("https://demoqa.com/automation-practice-form");
		
		WebElement dropdown3 = driver.findElement(By.xpath("//form//div[text()='Select City']"));
		System.out.println(dropdown3.isEnabled());
		
		WebElement firstName = driver.findElement(By.xpath("//form//input[@id='firstName']"));
		firstName.sendKeys("Mubin");
		firstName.submit();
		System.out.println(firstName.getAttribute("value"));
		
		WebElement lastName = driver.findElement(By.xpath("//form//input[@id='lastName']"));
		lastName.sendKeys("Pirjade");
		lastName.submit();
		System.out.println(lastName.getAttribute("value"));
		
		WebElement userEmail = driver.findElement(By.xpath("//form//input[@id='userEmail']"));
		userEmail.sendKeys("mubinbhai@gmail.com");
		userEmail.submit();
		System.out.println(userEmail.getAttribute("value"));
		
		//WebElement genderRadio = driver.findElement(By.xpath("//form//input[@id='gender-radio-1']"));
		// in above case it was not clickable
		WebElement genderRadio = driver.findElement(By.xpath("//form//label[text()='Male']"));
		genderRadio.click();
		//System.out.println(genderRadio.getAttribute("value"));
		//Thread.sleep(3000);
		
		WebElement userNumber = driver.findElement(By.xpath("//form//input[@id='userNumber']"));
		userNumber.sendKeys("1234567890");
		userNumber.submit();
		
		WebElement userDOB = driver.findElement(By.xpath("//form//input[@id='dateOfBirthInput']"));
		userDOB.clear();
		userDOB.sendKeys("17 Mar 1997");
		userDOB.submit();
		
		WebElement subjectInput = driver.findElement(By.xpath("//form//input[@id='subjectsInput']"));
		subjectInput.sendKeys("English");
		subjectInput.submit();
		
		//WebElement hobbies = driver.findElement(By.xpath("//form//input[@id='hobbies-checkbox-2']"));
		WebElement hobbies = driver.findElement(By.xpath("//form//label[text()='Reading']"));
		hobbies.click();
		
		WebElement currentAddress = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
		currentAddress.sendKeys("Pandharpur");
		currentAddress.submit();
		
		WebElement stateIndia = driver.findElement(By.xpath("//form//input[@id='react-select-3-input']"));
		stateIndia.sendKeys("Haryana");
		stateIndia.submit();
		
		WebElement cityIndia = driver.findElement(By.xpath("//form//div[@id='city']"));
		cityIndia.sendKeys("Panipat");
		cityIndia.submit();
		
		Thread.sleep(10000);
		
		
	}
	
	
		
}

