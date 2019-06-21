package com.class1;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class beforeAndAfterMethod {
	
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method");
	}
	@Test
	public void testMethodOne() {
		System.out.println("testMethod-One");
	}
	
	@Test
	public void testMethodTwo() {
		System.out.println("testMethod-Two");
	}
	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
	}
	

}
