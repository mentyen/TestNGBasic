package com.class2;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class softAndHardSeert {
	@Test
	public void soft() {
		
		SoftAssert soft=new SoftAssert();
		System.out.println("soft before");
		soft.assertTrue(false);
		
		System.out.println("soft after");
		soft.assertAll();
	}
	
	@Test
	public void hard() {
		System.out.println("hard before");
		Assert.assertTrue(false);
	
	}

}
