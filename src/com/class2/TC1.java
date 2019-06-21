package com.class2;

import java.awt.Desktop.Action;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import util.CommonMethods;

public class TC1 extends CommonMethods{
	String ID;
	String firstName="Name";
	String lastName="LastName";
	
	
	@BeforeClass
	
	public void setUp() {
		setUpDriver("chrome","https://opensource-demo.orangehrmlive.com/");
	}
	
	
	
	@Test
	public void title() {
		final String actual=driver.getTitle();
		final String expected="OrangeHRM";
		Assert.assertTrue(actual.equals(expected), "title is not correct");
		System.out.println("title is correct");
	
	}
	
	@Test(priority=1)
	public void logIn() {
		
		sendText(driver.findElement(By.cssSelector("input#txtUsername")), "Admin");
		sendText(driver.findElement(By.cssSelector("input#txtPassword")), "admin123");
		click(driver.findElement(By.cssSelector("input#btnLogin")));
				
		Assert.assertTrue(driver.findElement(By.cssSelector("a#welcome")).isDisplayed(), "User did not logIn");
		System.out.println("User logIn");
	}
	
	
	@Test(priority=2)
	public void addEmployee() {
			
		
		SoftAssert soft=new SoftAssert();
		soft.assertTrue(driver.findElement(By.cssSelector("a#menu_pim_viewPimModule")).isDisplayed(), "Pim button is not displayed on a page");
		click(driver.findElement(By.cssSelector("a#menu_pim_viewPimModule")));
		soft.assertAll();
		
	
		soft.assertTrue(driver.findElement(By.cssSelector("input#btnAdd")).isDisplayed());
		click(driver.findElement(By.cssSelector("input#btnAdd")));
		soft.assertAll();
		//sending a value				
		sendText(driver.findElement(By.cssSelector("input#firstName")),firstName);
		sendText(driver.findElement(By.cssSelector("input#lastName")),lastName);
		
		//getting a unic ID
		ID=driver.findElement(By.cssSelector("input#employeeId")).getAttribute("value");
		System.out.println(ID);
		
		
		click(driver.findElement(By.cssSelector("input#btnSave")));
		
		//comparing the entry
		String actual=driver.findElement(By.cssSelector("input#personal_txtEmpFirstName")).getText();
		soft.assertSame(firstName, actual);
		System.out.println("firstName match");
				
		actual=driver.findElement(By.cssSelector("input#personal_txtEmpLastName")).getText();
		soft.assertSame(lastName, actual);
		System.out.println("lastName match");
		
		actual=driver.findElement(By.cssSelector("input#personal_txtEmployeeId")).getText();
		soft.assertSame(ID, actual);
		System.out.println("ID match");
		
		
		
	}
	
	@Test (priority=3)
	public void employeeDetailsVerification() {
				
		click(driver.findElement(By.cssSelector("a#menu_pim_viewPimModule")));
		click(driver.findElement(By.cssSelector("a#menu_pim_viewEmployeeList")));
		
		List<WebElement>table=driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr/td"));
		
		tableCompareEachCell(table, firstName);
		tableCompareEachCell(table, lastName);
		tableCompareEachCell(table, ID);
		
		
		
	}
	@Test(dependsOnMethods="employeeDetailsVerification")
	public void removingEmployee() {
		Actions action=new Actions(driver);
		
		List<WebElement>table=driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
		for(int i=1;i<table.size();i++) {
			String line=driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr["+i+"]")).getText();
			if(line.contains(firstName)) {
				action.moveToElement(findByXpath("//table[@id='resultTable']/tbody/tr["+i+"]/td[1]")).click().perform();
			}	
		}			
	
		click(findByCSS("input#btnDelete"));
		
		action.moveToElement(findByCSS("input#dialogDeleteBtn")).click().perform();
			
		
	}
		
	
	
	@AfterClass
	
	public void Close() {
		driver.close();
	}
	
	

}
