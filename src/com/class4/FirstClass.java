package com.class4;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import util.CommonMethods;

public class FirstClass extends CommonMethods{
	
	@BeforeClass(alwaysRun=true)
	@BeforeMethod(enabled=true)
	public void setUp() {
		System.out.println("Hello");
	}
	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		driver.quit();
	}
	
	
	@Parameters({"a","b"})
	
	@Test(groups="smoke",invocationCount=2,invocationTimeOut=200)
	public void run(String a,String b) {
		System.out.println(a);
		System.out.println(b);
	}
	
	
	@DataProvider(name="data")
	public Object[][]data(){
		
		Object[][]data=new Object[2][2];
		
		data[0][0]="chrome";
		data[0][1]="http://www.amazon.com";
		
		data[1][0]="firefox";
		data[1][1]="http://www.ebay.com";
		
		
		
		
		return data;
	}
		
	

	

	@Test(groups="smoke",dataProvider="data")
	public void chrome(String browser,String url) {
	
		setUpDriver(browser,url);
		
	}
	
	@Parameters({"browser2","url2"})
	@Test(groups= {"smoke","regression"})
	public void fox(String browser,String url) {
		setUpDriver(browser,url);
		
	}
	


}
