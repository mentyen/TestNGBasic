package com.class2;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import util.CommonMethods;
public class ExecutionOrder extends CommonMethods {
	@BeforeClass
	public void setUp() {
		setUpDriver("chrome", "https://www.saucedemo.com/");
		boolean swagLabs = driver.findElement(By.xpath("//title[text()='Swag Labs']")).isDisplayed();
		if(swagLabs=true) {
			System.out.println("this is the right title");
		}
		else {
			System.out.println("this is the wrong title");	
		}
	}
	
	
	@Test()
	public void login() {
		sendText(driver.findElement(By.cssSelector("input#user-name")), "standard_user");
		sendText(driver.findElement(By.cssSelector("input#password")), "secret_sauce");
		driver.findElement(By.cssSelector("input.btn_action")).click();
	}
	
	@Test(priority =1)
	public void mainPage() {
		String actual =driver.findElement(By.xpath("//div[@class='product_label']")).getText();
		String expected ="Products";
		if(expected.equals(actual)) {
			System.out.println("expected matches actual text");
		}
		else {
			System.out.println("expected does not matche actual text");
		}
		
	}
	
	
	@AfterClass
	public void closePage() throws InterruptedException {
		driver.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	  @Test
	    public void methodTest() {
	        System.out.println("Method-Test");
	    }
	    
	    @BeforeMethod
	    public void beforeMethod() {
	        System.out.println("Before-Method");
	    }

	    @AfterMethod
	    public void afterMethod() {
	        System.out.println("After-Method");
	    }
	    
	    @BeforeClass
	    public void beforeClass() {
	        System.out.println("Before-Class");
	    }
	    
	    @AfterClass
	    public void AfterClass() {
	        System.out.println("After-Class");
	    }
	    
	    @BeforeTest
	    public void beforeTest() {
	        System.out.println("Before-Test");
	    }

	    @AfterTest
	    public void afterTest() {
	        System.out.println("After-Test");
	    }
	    
	    @BeforeSuite
	    public void beforeSuite() {
	        System.out.println("Before-Suite");
	    }

	    @AfterSuite
	    public void afterSuite() {
	        System.out.println("After-Suite");
	    }
*/
}
