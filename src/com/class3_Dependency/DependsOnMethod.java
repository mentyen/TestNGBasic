package com.class3_Dependency;

import org.testng.annotations.Test;

public class DependsOnMethod {
	
	
	@Test

	public void one() {
		System.out.println("one");
	}

	@Test(dependsOnMethods = "one")

	public void two() {
		System.out.println("two");
	}

	@Test(dependsOnMethods = "two")

	public void three() {
		System.out.println("three");
	}

}
