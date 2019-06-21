package com.Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(Test_Listeners.class)

public class FirstTastCase {
	
	
	@Test
	public void googleTitle() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "src\\drivers\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.yahoo.com");
		
		WebElement notificationsBtn=driver.findElement(By.xpath("//button[@title='Notifications']"));
		Actions action=new Actions(driver);
		action.moveToElement(notificationsBtn).build().perform();
		Thread.sleep(3000);
		action.moveToElement(driver.findElement(By.id("uh-mail-link"))).build().perform();
		
		Thread.sleep(3000);
		


		driver.close();
		
	}

}
