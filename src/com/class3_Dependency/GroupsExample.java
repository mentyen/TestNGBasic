package com.class3_Dependency;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupsExample {
	
	@BeforeGroups({"Smoke","Regression"})
	public void beforeGroup() {
		System.out.println("Before");
	}
	
	
	@Test(groups="Smoke")
	public void One() {
		System.out.println("testOne");
	}
	@Test(groups="Regression")
	public void Two() {
		System.out.println("testTwo");
	}
	@Test(groups="Smoke")
	public void Three() {
		System.out.println("testThree");
	}
	@Test(groups="Regression")
	public void Four() {
		System.out.println("testFour");
	}
	
	@AfterGroups({"Smoke","Regretion"})
	
	public void afterGroups() {
		System.out.println("After");
	}

}
