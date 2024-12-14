package ddt;

import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileNotFoundException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class DDTExampleXLS {
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
		Object[][] dataFromXls = readDataFromXLS("test/resources/data/Credentials.xls", "NT", "NTStartEnd");
		return dataFromXls;

	}

	public String[][] readDataFromXLS(String xlFilePath, String sheetName, String marker) {
		String[][] tabArray = null;
		try {
			Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));
			// Workbook class is provied by jxl.jar
			// WebDriver provided by Selenium
			// File is class provided by Java to read a physical file
			Sheet sheet = workbook.getSheet(sheetName);
			Cell tableStart = sheet.findCell(marker);

			int startRow, startCol, endRow, endCol, ci, cj;

			startRow = tableStart.getRow();// 2
			startCol = tableStart.getColumn();// 1

			Cell tableEnd = sheet.findCell(marker, startCol + 1, startRow + 1, 100, 64000, false);

			endRow = tableEnd.getRow();// 7
			endCol = tableEnd.getColumn();// 5
			System.out.println("startRow=" + startRow + ", endRow=" + endRow + ", " + "startCol=" + startCol
					+ ", endCol=" + endCol);
			tabArray = new String[endRow - startRow - 1][endCol - startCol - 1];// 4, 3
			ci = 0; // array row
			// ci=0,i=3, j=3,cj=1
			for (int i = startRow + 1; i < endRow; i++, ci++) {// i represents
																// xls row
				cj = 0;// array column
				for (int j = startCol + 1; j < endCol; j++, cj++) {// j
																	// represents
																	// xls
																	// column
					tabArray[ci][cj] = sheet.getCell(j, i).getContents();
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("The file you specified does not exist");
		} catch (Exception e) {
			System.out.println("Please check if file path, sheet name and tag name are correct");
			e.toString();
		}
		return (tabArray);
	}

}
