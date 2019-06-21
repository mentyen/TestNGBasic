package com.class2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import util.CommonMethods;

public class Test_2 extends CommonMethods{
	/*
	 * TC 2: OrangeHRM Successful Login 
https://opensource-demo.orangehrmlive.com/
Please make sure to use the following:
 annotations:
	@BeforeMethod
	@AfterMethod
	@Test

What would you do if you do not want to execute any specific test case?
What would you do if you want to execute any specific test case first?
	 */
	@BeforeMethod
	public void setUp() {
		String url="https://opensource-demo.orangehrmlive.com/";
		CommonMethods.setUpDriver("chrome", url);
	}
	
	@Test
	public void logIn() {
		WebElement element=driver.findElement(By.cssSelector("input#txtUsername"));
		CommonMethods.sendText(element, "Admin");
		element=driver.findElement(By.cssSelector("input#txtPassword"));
		CommonMethods.sendText(element, "admin123");
		
		element=driver.findElement(By.cssSelector("input#btnLogin"));
		click(element);
		
	}
	@AfterMethod
	
	public void close() {
		driver.close();
	}
	

}
