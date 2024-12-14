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

public class draggableDroppable {
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
	
	//@Test
	public void dragandDrop() throws InterruptedException {
		driver.get("http://icefaces-showcase.icesoft.org/showcase.jsf");
		Actions builder = new Actions(driver);
		driver.findElement(By.xpath("//h3//a[text()='Miscellaneous']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='ace:draggable/droppable']")).click();
		Thread.sleep(3000);
		
		WebElement source1 = driver.findElement(By.id("form:sortingList:0:item"));
		WebElement target1 = driver.findElement(By.id("form:electronicsDrop1_content"));
		
		WebElement source2 = driver.findElement(By.id("form:sortingList:1:item"));
		WebElement target2 = driver.findElement(By.id("form:electronicsDrop2_content"));
		
		WebElement source3 = driver.findElement(By.id("form:sortingList:2:item"));
		WebElement target3 = driver.findElement(By.id("form:groceriesDrop1_content"));
		
		WebElement source4 = driver.findElement(By.id("form:sortingList:3:item"));
		WebElement target4 = driver.findElement(By.id("form:groceriesDrop2_content"));
		
		builder.dragAndDrop(source1, target1).dragAndDrop(source2, target2).dragAndDrop(source3, target3).dragAndDrop(source4, target4).build().perform();
		Thread.sleep(5000);
	}
	
	@Test
	public void tableRowSelect() throws InterruptedException {
		driver.get("http://icefaces-showcase.icesoft.org/showcase.jsf");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3//a[text()='Datatable']")));
		driver.findElement(By.xpath("//h3//a[text()='Datatable']")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='ace:dataTable']")));
		driver.findElement(By.xpath("//a[text()='ace:dataTable']")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='sm:j_idt646_content']//a[text()='Selection']")));
		driver.findElement(By.xpath("//div[@id='sm:j_idt646_content']//a[text()='Selection']")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Multiple Rows']")));
		driver.findElement(By.xpath("//label[text()='Multiple Rows']")).click();
		Thread.sleep(3000);
		// if above wait is removed
		// then getting stale element exception
		Actions builder1 = new Actions(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[@id='form:selectionTable_row_1']//span[text()='2']")));
		WebElement tamale = driver.findElement(By.xpath("//tr[@id='form:selectionTable_row_1']//span[text()='2']"));
		//tamale.click();
		//builder1.click(tamale).perform();
		//Thread.sleep(3000);
		//builder1.click(tamale);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[@id='form:selectionTable_row_4']//span[text()='5']")));
		WebElement iguana = driver.findElement(By.xpath("//tr[@id='form:selectionTable_row_4']//span[text()='5']"));
		//iguana.click();
		//Thread.sleep(3000);
		//builder1.click(iguana);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[@id='form:selectionTable_row_6']//span[text()='7']")));
		WebElement pisces = driver.findElement(By.xpath("//tr[@id='form:selectionTable_row_6']//span[text()='7']"));
		//pisces.click();
//		//Thread.sleep(3000);
		builder1.click(tamale).click(iguana).click(pisces).build().perform();
		//builder1.click(pisces);
		//builder1.perform();
		System.out.println("Tamale selected: "+ driver.findElement(By.xpath("//tr[@id='form:selectionTable_row_1']")).isSelected());
//		System.out.println("Tamale selected: "+ iguana.isSelected());
//		System.out.println("Tamale selected: "+ pisces.isSelected());
		Thread.sleep(5000);
	}
	
}
