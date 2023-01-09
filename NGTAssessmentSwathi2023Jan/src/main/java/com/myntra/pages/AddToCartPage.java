package com.myntra.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AddToCartPage {
	
WebDriver driver;
	
	
	public AddToCartPage(WebDriver driver){
		this.driver=driver;
	}
	
public void launchAddToCart() throws Exception {
	Properties propObj=new Properties();
	String rootFolder= System.getProperty("user.dir");
	propObj.load(new FileInputStream(rootFolder +"//src//test//resources//myntra.properties"));
	String value3=propObj.getProperty("bagurl");
		
	driver.findElement(By.xpath(value3)).click();
	

	}
public void verifyAddToCart() throws Exception {
	String expectedTitle = "Hey, it feels so light!";
	Properties propObj=new Properties();
	String rootFolder= System.getProperty("user.dir");
	propObj.load(new FileInputStream(rootFolder +"//src//test//resources//myntra.properties"));
	String value4=propObj.getProperty("bagempty");
	String actualTitle=driver.findElement(By.xpath(value4)).getText();;
	Assert.assertEquals(actualTitle,expectedTitle,"Bag is not empty");
	Thread.sleep(2000);
	
	driver.navigate().back();
	
	Thread.sleep(2000);
	String value5=propObj.getProperty("product");
	
	driver.findElement(By.xpath("//*[@id=\"desktop-header-cnt\"]/div[2]/div[3]/input")).sendKeys(value5,Keys.ENTER);
	String value6=propObj.getProperty("selectproduct");
	//driver.findElement(By.xpath(value6)).click();
	Thread.sleep(2000);
	String value7=propObj.getProperty("productpage");
	driver.get(value7);
	Thread.sleep(2000);
	String value8=propObj.getProperty("searchbutton");
	driver.findElement(By.xpath(value8)).click();
	Thread.sleep(2000);
	String value9=propObj.getProperty("gotobag");
	driver.findElement(By.xpath(value9)).click();
	String value10=propObj.getProperty("verifybag");
	String expectedTitle1 = "PLACE ORDER";
	String actualTitle1=driver.findElement(By.xpath(value10)).getText().trim();
	System.out.println("expectedTitle1: " + expectedTitle1);
	System.out.println("actualTitle1: " + actualTitle1);
	Assert.assertEquals(actualTitle1,expectedTitle1,"Bag is empty");
	
	
	
	
}

}
