package com.class1;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import util.CommonMethods;

public class HM1 extends CommonMethods {
	/*
	 * TC 1: Swag Lab Title and Login Verification URL www.saucedemo.com

        @BeforeMethod should contain navigation to the URL and title verification

        @Test should contain steps to login and “Product” word verification

        @AfterMethod should logOut from the application and close the browser
	 * 
	 */
	@BeforeMethod
	
	public void setUp() {
		String url="https://www.saucedemo.com/";
		CommonMethods.setUpDriver("chrome", url);
	}
@Test
	
	public void logIn() {
		CommonMethods.sendText(driver.findElement(By.cssSelector("input#user-name")),"standard_user");
		CommonMethods.sendText(driver.findElement(By.cssSelector("input#password")),"secret_sauce");
		click(driver.findElement(By.cssSelector("input[type='submit']")));
		String text=driver.findElement(By.xpath("//div[@class='product_label']")).getText();
		if(text.equals("Products")) {
			System.out.println("Product is ON");
		}else {
			System.out.println("Product is OFF");
		}
		
	}
	
	@AfterMethod
	public void Close() {
		
		
		click(driver.findElement(By.xpath("//button[@style=\"position: absolute; left: 0px; top: 0px; width: 100%; height: 100%; margin: 0px; padding: 0px; border: none; opacity: 0; font-size: 8px; cursor: pointer;\"]")));
		
		WebDriverWait wait=new WebDriverWait(driver,30);		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a#logout_sidebar_link")));
		
		click(driver.findElement(By.cssSelector("a#logout_sidebar_link")));
		driver.close();
	}

}
