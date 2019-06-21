package com.Practice;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.CommonMethods;

public class GroupTest extends CommonMethods{
	@BeforeClass
	public void setUp() {
		setUpDriver("chrome","http://tut.by");
	}
	@DataProvider
	public void getData() {
		
	}
	@Test(groups="smoke")
	public void one(String username,String password) {
		System.out.println("Test from group:smoke1");
	}
	@Test(groups="smoke")
	public void two() {
		Assert.assertEquals(1, 1);
		System.out.println("Test from group:smoke2");
	}
	@Test(groups= {"smoke","regression"})
	public void three() {
		System.out.println("Test from group:smoke3/reg3");
	}
	@Test(groups= {"smoke","regression"})
	public void four() {
		System.out.println("Test from group:smoke4/reg4");
	}
	@Test(dependsOnMethods = "two")
	public void five() {
		System.out.println("Test from group:reg5");
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
