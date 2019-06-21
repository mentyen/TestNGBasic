package com.class4;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import util.CommonMethods;

public class ParameterExempleTwo extends CommonMethods {
	@Parameters({"browser","url"})
	
	@Test
	public void testGoogle(String browser,String url) {
		setUpDriver(browser,url);
	}
	
	

}
