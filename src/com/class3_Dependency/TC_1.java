package com.class3_Dependency;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import util.CommonMethods;

public class TC_1 extends CommonMethods{
	
	@BeforeGroups({"Smoke","Regression"})
	public void setUp() {
		setUpDriver("chrome","https://www.saucedemo.com/");
	}
	
	@Test(groups="Smoke")
		public void userOne() {
		sendText(findByCSS("input#user-name"),"standard_user");
		sendText(findByCSS("input#password"),"secret_sauce");
		click(findByCSS("input[type='submit']"));
		
	}
	
	@Test(groups="Regression1")
	public void userTwo() {
	sendText(findByCSS("input#user-name"),"locked_out_user");
	sendText(findByCSS("input#password"),"secret_sauce");
	click(findByCSS("input[type='submit']"));
}
	@Test(groups="Regression2")
	public void userThree() {
	sendText(findByCSS("input#user-name"),"problem_user");
	sendText(findByCSS("input#password"),"secret_sauce");
	click(findByCSS("input[type='submit']"));
}
	
	@AfterGroups({"Smoke","Regression"})
	public void tearDown() {
		driver.close();
	}

}
