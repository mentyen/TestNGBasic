package com.class1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import util.CommonMethods;

public class priorityTest extends CommonMethods {
	@BeforeMethod
	public void setUp() {
		setUpDriver("chrome","http://saucedemo.com");
		boolean title=driver.findElement(By.xpath("//title[text()=Swag Labs']")).isDisplayed();
		if(title) {
			System.out.println("correct title");
		}else {
			System.out.println("wrong title");
		}
	}

}
