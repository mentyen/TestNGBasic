package com.class3_Dependency;

import org.testng.annotations.Test;

public class DependsOnGroups {
	
	@Test(groups="Smoke1")

	public void one() {
		System.out.println("one");
	}

	@Test(groups = "Smoke2",dependsOnGroups="Smoke1")

	public void two() {
		System.out.println("two");
	}

	@Test(groups = "Smoke3",dependsOnGroups="Smoke2")

	public void three() {
		System.out.println("three");
	}

}
