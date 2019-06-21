package com.class4;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestOfParameters {
	
	
	@Parameters ({"userName1"})
	@Test
	public void userNames(String user) {
		System.out.println(user);
	}



}
