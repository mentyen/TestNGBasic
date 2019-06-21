package com.class4;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import util.CommonMethods;

public class ParametersSauceDemo extends CommonMethods{
	@Parameters({"browser","url"})
	@BeforeMethod(alwaysRun=true)
	public void setUp(String browser,String url) {
		setUpDriver(browser,url);
	}
	@Parameters({"userName1","password"})
	@Test(groups="Smoke")
	public void UsernameOne(String userName,String password) {
		sendText(findByCSS("input#user-name"),userName);
		sendText(findByCSS("input#password"),password);
		click(findByCSS("input.btn_action"));
		
		Assert.assertEquals(findByCSS("div[class='product_label']").getText(), "Products");
	}
	@Parameters({"userName2","password"})
	@Test(groups="Regression")
	public void UsernameTwo(String userName,String password) {
		sendText(findByCSS("input#user-name"),userName);
		sendText(findByCSS("input#password"),password);
		click(findByCSS("input.btn_action"));
		
		Assert.assertEquals(findByCSS("div[class='product_label']").getText(), "Products");
	}
	
	
	
	@AfterMethod (alwaysRun=true)
	public void tearDown() {
		driver.close();
	}

}
