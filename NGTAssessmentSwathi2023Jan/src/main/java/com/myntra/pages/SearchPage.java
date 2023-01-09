package com.myntra.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SearchPage {
WebDriver driver;
	
	
	public SearchPage(WebDriver driver){
		this.driver=driver;
	}
	
public void launchSearch() throws Exception {
	Properties propObj=new Properties();
	String rootFolder= System.getProperty("user.dir");
	propObj.load(new FileInputStream(rootFolder +"//src//test//resources//myntra.properties"));
	String value2=propObj.getProperty("product");
		
	driver.findElement(By.xpath("//*[@id=\"desktop-header-cnt\"]/div[2]/div[3]/input")).sendKeys(value2,Keys.ENTER);
	

	}
public void verifySearch() throws Exception {
	String expectedTitle = "Oneplus 7t - Buy Oneplus 7t online in India";
	String actualTitle=driver.getTitle();
	Assert.assertEquals(actualTitle,expectedTitle,"Product page not loaded");
	Thread.sleep(2000);
	
}


}
