package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class configAnnotations2 {
  @Test
  public void test1() {
	  System.out.println("In Test1 of class2");
  }
  
  @Test
  public void test2() {
	  System.out.println("In Test2 of class2");
  }
  
  @Test
  public void test3() {
	  System.out.println("In Test3 of class2");
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("In BM of class2");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("In AM of class2");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("In BC of class2");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("In AC of class2");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("In BT of class2");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("In AT of class2");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("In BS of class2");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("In AS of class2");
  }

}
