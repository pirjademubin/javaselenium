package ddt;

import org.testng.annotations.Test;



import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class DDTExampleXLSX {
	WebDriver driver;

	@Test(dataProvider = "LoginData")
	public void testDataFromXls(String id, String pass) {
		driver.findElement(By.name("username")).sendKeys(id);
		driver.findElement(By.name("password")).sendKeys(pass);
		driver.findElement(By.xpath("//form[@name='loginform']/button")).submit();
	}

	@BeforeMethod
	public void beforeMethod() {
		driver = new ChromeDriver();
		driver.get("https://nichethyself.com/tourism/home.html");
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

	// Test case "TestDataFromArray" gets data from dp data provider
	// dp provides data to test case "TestDataFromArray"
	//  @DataProvider
	//  public Object[][] dp() {
	//    return new Object[][] {
	//      new Object[] { 1, "a" },
	//      new Object[] { 2, "b" },
	//    };
	//  }

	@DataProvider(name = "LoginData")
	public Object[][] dp1() {
		Object[][] dataFromXls = readDataFromXLSX("test/resources/data/Credentials.xls", "NT", "NTStartEnd");
		return dataFromXls;

	}
	
	public String[][] readDataFromXLSX(String xlFilePath, String sheetName, String marker) {
		String[][] tabArray = null;
		try {
			FileInputStream fis = new FileInputStream(xlFilePath);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			Row row = sheet.getRow(0);
			Cell cell = row.getCell(0);
			int startRow, startCol, endRow, endCol, ci, cj;
			String rowVal;
			for(int rowNum = 0; rowNum < 100; rowNum++, ci++, cj++) {
				String rowVal1 = row.getCell(rowNum).getStringCellValue();
			}
			
			
			
			//startRow = cell.getRow()
			
			
		}catch (FileNotFoundException e) {
			System.out.println("The file you specified does not exist");
		} catch (Exception e) {
			System.out.println("Please check if file path, sheet name and tag name are correct");
			e.toString();
		}
		return (tabArray);
	

}
}
