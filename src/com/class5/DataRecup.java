package com.class5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.CommonMethods;

public class DataRecup extends CommonMethods {
	
	
	@BeforeMethod(alwaysRun=true)
	public void setUp() {
		setUpDriver("firefox","https://www.saucedemo.com");
	}
	
	
	@DataProvider(name="userCredentials")
	@Test
	public Object[][] setUpdata(){
		
		Object[][]data= new Object[3][2];
		
		data[0][0]="standard_user";
		data[0][1]="secret_sauce";
				
		data[1][0]="problem_user";
		data[1][1]="secret_sauce";
		
		data[2][0]="performance_glitch_user";
		data[2][1]="secret_sauce";
				
		return data;
	}
	
	
	@Test(dataProvider="userCredentials")
	public void runingData(String name,String password) {
		sendText(driver.findElement(By.id("user-name")),name);
		sendText(driver.findElement(By.id("password")),password);
		click(findByCSS("input[class='btn_action']"));
		WebElement product=findByXpath("//div[text()='Products']");
		Assert.assertTrue(product.isDisplayed());
	
	}
	
	


	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	

}
