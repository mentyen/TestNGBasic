package com.class2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import util.CommonMethods;

public class smartbears_LOGIN extends CommonMethods{
	
	@BeforeClass
	public static void setUp() {
		setUpDriver("chrome", "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");
	}
	@Test(priority = 1)
	public void loginScreenTitle() {
		String title=driver.getTitle();
		
		String url="Web Orders Login";
		if(title.contains(url)) {
			System.out.println("Title is correct");
		}else {
			System.out.println("Title is not correct");
		}
	}
	
	@Test(priority=2)
	public  void logIn() {
		sendText(driver.findElement(By.xpath("//input[contains(@id,'_username')]")),"Tester");
		sendText(driver.findElement(By.xpath("//input[contains(@id,'_password')]")),"test");
		driver.findElement(By.xpath("//input[contains(@id,'_login_button')]")).click();
	}
	
	@Test(priority=3)
	public void webOrders() {
		WebElement webOrderTitle=driver.findElement(By.xpath("//h1[text()='Web Orders']"));
		
		if(webOrderTitle.isDisplayed()) {
			System.out.println("Text is Displayed");
		}else {
			System.out.println("Text is Displayed");
		}
	}
	
	//will close the browser if use AfterMethod it will close the browser after each Test
	@AfterClass
	public void closed() {
		//driver.close();
	}
	
}
