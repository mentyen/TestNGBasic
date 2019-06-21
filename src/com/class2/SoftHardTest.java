package com.class2;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import util.CommonMethods;

public class SoftHardTest extends CommonMethods{
	
	@BeforeClass
	public void setUp() {
		setUpDriver("chrome","https://opensource-demo.orangehrmlive.com/");
	}
	@Test
	public void LogInScreen() {
		String title=driver.getTitle();
		String expected="OrangeHRM";
		
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(title, expected);//if assert fail cod will continue 
		System.out.println("After soft assert");
		//
		Assert.assertEquals(title, expected);//if assert fail cod will stop
		System.out.println("After assert");
	}
	@Test
	public void Logo() {
		
		boolean logo=driver.findElement(By.xpath("//img[contains(@src,'logo.png')]")).isDisplayed();
		SoftAssert soft=new SoftAssert();
		soft.assertTrue(logo);
		System.out.println("After soft Assert");
		//
		//Assert.assertTrue(logo);
		//System.out.println("After logo Assert");
		//driver.close();
	}
	

}
