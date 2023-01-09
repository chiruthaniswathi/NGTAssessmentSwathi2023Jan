package com.myntra.tests;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.myntra.pages.AddToCartPage;
import com.myntra.pages.SearchPage;



public class MyntraTests {
	WebDriver driver;
	SearchPage search;
	AddToCartPage cart;

	@BeforeMethod
	public void setup() throws Exception {
	
		String rootFolder = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", rootFolder+"//src//test//resources//chromedriver.exe");
		driver = new ChromeDriver();
		
		search = new SearchPage(driver);
		cart = new AddToCartPage(driver);
		driver.manage().window().maximize();
		Properties propObj=new Properties();
		propObj.load(new FileInputStream(rootFolder +"//src//test//resources//myntra.properties"));
		String value1=propObj.getProperty("appurl");
		
		driver.get(value1);
	}
  @Test
  public void verifySearchPage() throws Exception {
	  
	  search.launchSearch();
	  search.verifySearch();
  }
//  
  @Test
  public void verifyAddToCartPage() throws Exception {
	  cart.launchAddToCart();
	  cart.verifyAddToCart();
	  
  }
//  
  @AfterMethod
  public void tearDown() {
	  driver.close();
	  driver.quit();
  }

}
