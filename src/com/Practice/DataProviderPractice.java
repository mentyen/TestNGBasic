package com.Practice;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
	private static final String TimeUnits = null;
	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
		String url="http://www.facebook.com";
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(35,TimeUnit.SECONDS);
		driver.get(url);
		
	}
	
	@DataProvider(name="gmailLoginData")
	public String[][] getData(){
		
		String[][]data=new String[2][2];
		
		data[0][0]="name";
		data[0][1]="password";
		
		data[1][0]="admin1@gmail.com";
		data[1][1]="password1";
		
		
		
		
		
		return data;
	}
	@Test(dataProvider="gmailLoginData")
	
	public void logIn(String name,String passw) {
					
		driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys(name);
		driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys(passw);		
		driver.findElement(By.cssSelector("button[name='websubmit']")).click();
	
		
	
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
