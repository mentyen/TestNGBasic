package com.class4;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import util.CommonMethods;

public class SouceDemo extends CommonMethods{
	
	@BeforeMethod(alwaysRun=true,groups="Smoke")
	public void setUp() {
		setUpDriver("chrome","https://www.saucedemo.com/");
	}
	
	@Test(groups="Smoke")
	public void UsernameOne() {
		sendText(findByCSS("input#user-name"),"standard_user");
		sendText(findByCSS("input#password"),"secret_sauce");
		click(findByCSS("input.btn_action"));
		
		Assert.assertEquals(findByCSS("div[class='product_label']").getText(), "Products");
	}
	
	@Test(groups="Regression")
	public void UsernameTwo() {
		sendText(findByCSS("input#user-name"),"problem_user");
		sendText(findByCSS("input#password"),"secret_sauce");
		click(findByCSS("input.btn_action"));
		
		Assert.assertEquals(findByCSS("div[class='product_label']").getText(), "Products");
	}
	
	
	
	@AfterMethod (alwaysRun=true,groups="Smoke")
	public void tearDown() {
		driver.close();
	}

}
