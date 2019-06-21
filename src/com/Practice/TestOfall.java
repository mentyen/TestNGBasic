package com.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import util.CommonMethods;

public class TestOfall extends CommonMethods{
	


	@Parameters({"browser","url"})
	@Test()
	public void openNameOne(String browser,String url) {
		
		if(browser.contains("chrome")) {
			setUpDriver(browser,url);
			
			new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("input#uh-search-box"))));
		
			sendText(driver.findElement(By.cssSelector("input#uh-search-box")),"twitter in chrome");
			click(driver.findElement(By.cssSelector("button#uh-search-button")));
			
			driver.close();
			
		}
		
		if(browser.contains("firefox")) {
			setUpDriver(browser,url);
			sendText(findByCSS("input#uh-search-box"),"facebook in firefox");
			click(findByCSS("button#uh-search-button"));
			driver.close();
		}
		
	}
	
	
	
	


}
