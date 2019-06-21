package com.class5;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import util.CommonMethods;

public class HM2users extends CommonMethods {

	WebElement element;

	@Parameters({ "browser", "username", "password" })
	@BeforeClass
	public void setUp(String browser, String username, String password) {

		if (browser.equalsIgnoreCase("chrome")) {
			setUpDriver(browser,
					"http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete11%2fWebOrders%2fDefault.aspx");
			sendText(findByCSS("input#ctl00_MainContent_username"), username);
			sendText(findByCSS("input#ctl00_MainContent_password"), password);
			click(findByCSS("input#ctl00_MainContent_login_button"));
		}
		if (browser.equalsIgnoreCase("firefox")) {
			setUpDriver(browser,
					"http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete11%2fWebOrders%2fDefault.aspx");
			sendText(findByCSS("input#ctl00_MainContent_username"), username);
			sendText(findByCSS("input#ctl00_MainContent_password"), password);
			click(findByCSS("input#ctl00_MainContent_login_button"));
		}
	}

	@DataProvider(name = "user")
	public Object[][] userOneData() {

		Object[][] data = new Object[2][11];

		data[0][0] = "FamilyAlbum";
		data[0][1] = "20";
		data[0][2] = "Bob";
		data[0][3] = "2307 39th Place";
		data[0][4] = "Queens";
		data[0][5] = "MA";
		data[0][6] = "11104";
		data[0][7] = "4455667789903456";
		data[0][8] = "12/22";
		data[0][9] = "Visa";
		data[0][10] = "user1pic";

		data[1][0] = "MyMoney";
		data[1][1] = "5";
		data[1][2] = "Moss";
		data[1][3] = "3035 47 ave";
		data[1][4] = "Woodside";
		data[1][5] = "CA";
		data[1][6] = "11114";
		data[1][7] = "4455667783303456";
		data[1][8] = "10/22";
		data[1][9] = "MasterCard";
		data[1][10] = "user2pic";

		return data;

	}

	@Test(dataProvider = "user")
	public void addingUsers(String product, String quantiti, String firstName, String address, String city,
			String state, String zip, String ccCard, String ccExp, String ccType, String pic) {

		click(driver.findElement(By.linkText("Order")));

		selectValueFromDD(driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct")), product);
		sendText(driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")), quantiti);
		sendText(driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")), firstName);
		sendText(driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2")), address);
		sendText(driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3")), city);
		sendText(driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4")), state);
		sendText(driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")), zip);

		sendText(driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")), ccCard);
		sendText(driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")), ccExp);
		List<WebElement> radio = driver.findElements(By.xpath("//input[@type='radio']"));
		radioButtonComparingValue(radio, ccType);

		takeScreenshot("screenshots", pic);

		click(driver.findElement(By.linkText("Process")));

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
