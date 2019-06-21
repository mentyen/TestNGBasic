package com.class3_Dependency;

import org.openqa.selenium.By;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import util.CommonMethods;

public class NewTourExample extends CommonMethods {
	
	//@BeforeGroups({"Smoke","Regression"})
	@BeforeMethod(alwaysRun=true,groups={"Smoke","Regression"})
	public void setUp() {
		setUpDriver("chrome", "http://newtours.demoaut.com/");
		driver.findElement(By.linkText("REGISTER")).click();
	}
	
	
	@Test(groups="Smoke")
	public void userInformation() {
		sendText(findByCSS("input#email"),"name");
		sendText(findByCSS("input[name='password']"),"password");
		sendText(findByCSS("input[name='confirmPassword']"),"password");
		findByCSS("input[name='register']").click();
	}
	
	
	@Test(groups="Regression")
	public void contactInformation() {
		sendText(findByCSS("input[name='firstName']"),"name");
		sendText(findByCSS("input[name='lastName']"),"lastName");
		sendText(findByCSS("input[name='phone']"),"2221113334");
		sendText(findByCSS("input[name='userName']"),"test@gmail.com");
		findByCSS("input[name='register']").click();
		//driver.findElement(By.linkText("REGISTER")).click();
	}
	
	@Test(groups="Regression",dependsOnMethods="contactInformation")
	public void mailingInformation() {
		
		sendText(findByCSS("input[name='address1']"),"streetTest");
		sendText(findByCSS("input[name='city']"),"cityTest");
		sendText(findByCSS("input[name='state']"),"stateTest");
		sendText(findByCSS("input[name='postalCode']"),"11111");
		selectValueFromDD(findByCSS("select[name='country']"), "AUSTRIA ");
	}
	
	
	

	//@AfterGroups({"Smoke","Regression"})
	@AfterMethod (alwaysRun=true, groups={"Smoke","Regression"})
	public void tearDown() {
		driver.close();

	}

}
