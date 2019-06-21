package com.class1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import util.CommonMethods;

public class orangehrm extends CommonMethods {
	
	@BeforeMethod
		public void setUp() {
		String url="https://opensource-demo.orangehrmlive.com/";
		setUpDriver("chrome",url);
		
	}
	@Test
	
	public void logIn() {
		CommonMethods.sendText(driver.findElement(By.cssSelector("input#txtUsername")),"Admin");
		CommonMethods.sendText(driver.findElement(By.cssSelector("input#txtPassword")),"admin123");
		click(driver.findElement(By.cssSelector("input#btnLogin")));
	}
	
	@AfterMethod
	public void Close() {
		driver.close();
	}

}
