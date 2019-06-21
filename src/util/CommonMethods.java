package util;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods {
	// CTRL+o will give you list of the functions

	public static WebDriver driver;

	public static void setUpDriver(String browser, String url) {

		if (browser.equalsIgnoreCase("chrome")) {
			// System.setProperty("webdriver.chrome.driver","c:\\Users\\Tolik\\Selenium\\chromedriver.exe");

			System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			// System.setProperty("webdriver.gecko.driver","c:\\Users\\Tolik\\Selenium\\geckodriver.exe");

			System.setProperty("webdriver.gecko.driver", "src/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		} else {
			System.out.println("We only accept chrome or firefox browsers");
		}

		driver.manage().window().fullscreen();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
	}
	
	
	public static WebElement findByCSS(String element) {
		WebElement el=driver.findElement(By.cssSelector(element));
		return el;
	}
	
	public static WebElement findByXpath(String element) {
		WebElement el=driver.findElement(By.xpath(element));
		return el;
	}
	public static WebElement findByLinkText(String element) {
		WebElement el=driver.findElement(By.linkText(element));
		return el;
	}
	

	/*
	 * @author Tolik This method will select specific value from a drop down by Text
	 * 
	 * @param Select element,String text
	 */

	public static void selectValueFromDD(WebElement element, String text) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		boolean flag = false;

		for (WebElement option : options) {

			String optionText = option.getText();

			if (optionText.equals(text)) {
				// select.deselectByVisibleText(text);
				option.click();
				flag = true;
				break;
			}
		}
		if (!flag) {
			System.out.println("Option with text " + text + " is not available");

		}
	}
	/*
	 * @author TT
	 * This method will select specific value from a drop down by Text
	 * 
	 * @param Select element,int index
	 */

	public static void selectValueFromDD(WebElement element, int index) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		if (options.size() > index) {
			select.selectByIndex(index);
		} else {
			System.out.println("Invalid index has been passed");
		}
	}
	
	/*
	 * @author TT
	 * This method will send specific text 
	 * 
	 * @param Select element,String value
	 */

	public static void sendText(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}
	
	/*
	 * @author TT
	 * This method will click 
	 * 
	 * @param Select element
	 */

	public static void click(WebElement element) {
		element.click();
	}
	
	/*
	 * @author TT
	 * This method will disable all pictures from chrome 
	 * 
	 * @param Select element
	 */


	public static void disableImageChrome(ChromeOptions options) {
		HashMap<String, Object> images = new HashMap();

		images.put("images", 2);
		HashMap<String, Object> pref = new HashMap();
		pref.put("profile.default_content_setting_values", images);

		options.setExperimentalOption("prefs", pref);
	}
	
	/*
	 * @author TT
	 * This method will disable all pictures from fox 
	 * 
	 * @param Select element
	 */

	public static void disableImageFirefox(FirefoxOptions options) {
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("permissions.default.image", 2);
		options.setProfile(profile);
		options.setCapability(FirefoxDriver.PROFILE, profile);
	}

	/*
	 * Method will capture alert
	 * 
	 * @throws NoAlertPresentException if alert is not present
	 * 
	 * @return accept the alert
	 */
	public static void acceptAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (NoAlertPresentException e) {
			System.out.println("Alert was not present");
		}

	}

	/*
	 * Method will capture alert
	 * 
	 * @throws NoAlertPresentException if alert is not present
	 * 
	 * @action dismiss the alert
	 * 
	 */
	public static void dismissAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
		} catch (NoAlertPresentException e) {
			System.out.println("Alert was not present");
		}

	}

	/*
	 * Method will get text of a alert
	 * 
	 * @throws NoAlertPresentException if alert is not present
	 * 
	 * @return String text
	 * 
	 */
	public static String getAlertText() {
		try {
			Alert alert = driver.switchTo().alert();
			return alert.getText();
		} catch (NoAlertPresentException e) {
			System.out.println("Alert was not present");
			return null;
		}

	}

	/*
	 * Method will switch to a frame
	 * 
	 * @param frame id,frame name
	 * 
	 * @throw NoSuchFrameException if were is no frame on a page
	 */
	public static void switchToFrame(String idOrName) {

		try {
			driver.switchTo().frame(idOrName);
		} catch (NoSuchFrameException e) {
			System.out.println("Frame is not present");
		}

	}

	/*
	 * Method will switch to a frame
	 * 
	 * @param WebElement element
	 * 
	 * @throw NoSuchFrameException if were is no frame on a page
	 */
	public static void switchToFrame(WebElement element) {

		try {
			driver.switchTo().frame(element);
		} catch (NoSuchFrameException e) {
			System.out.println("Frame is not present");
		}

	}

	/*
	 * Method will switch to a frame
	 * 
	 * @param index
	 * 
	 * @throw NoSuchFrameException if were is no frame on a page
	 */
	public static void switchToFrame(int index) {

		try {
			driver.switchTo().frame(index);
		} catch (NoSuchFrameException e) {
			System.out.println("Frame is not present");
		}

	}

	/*
	 * Wethod will move mouse over the element
	 * 
	 * @param WebElement
	 */
	public static void mouseOver(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

	/*
	 * Method will select radio button/comparing text
	 * 
	 * @param WebElement
	 */
	public static void radioButtonClick(List<WebElement> element,String value) {
		boolean flag=false;
		for (WebElement run : element) {
			if (run.isDisplayed() && run.isEnabled()) {
			String text=run.getText();
				if (text.contains(value)) {
					run.click();
					flag=true;
					break;
				}

			}
		}
		if(!flag) {
			System.out.println("Expected value "+value+ "was not selected.Test FAIL");
		}

	}
	/*
	 * Method will select radio button/comparing attribute value 
	 * 
	 * @param WebElement
	 */
	public static void radioButtonComparingValue(List<WebElement> element,String value) {
		boolean flag=false;
		for (WebElement run : element) {
			if (run.isDisplayed() && run.isEnabled()) {
			String text=run.getAttribute("value");
				if (text.contains(value)) {
					run.click();
					flag=true;
					break;
				}

			}
		}
		if(!flag) {
			System.out.println("Expected value "+value+ "was not selected.Test FAIL");
		}

	}
	
	/*
	 * Method will mark checkbox  
	 * 
	 * @param WebElement,String
	 */

	public static void checkBoxClick(List<WebElement> element, String value) {
		boolean flag=false;

		for (WebElement run : element) {
			if (run.isDisplayed() && run.isEnabled()) {
				String text=run.getAttribute("value");
				if (value.contains(value)) {
					run.click();
					flag=true;
					break;
				}
			}

		}
		if(!flag) {
			System.out.println("Excpected value "+value+" was not selected.Test FAIL");
		}
	}
	
	/*
	 * Method will  compare 2 strings  
	 * 
	 * @param WebElement,String
	 */

	public static void compareValue(WebElement element, String value) {
		String present = element.getAttribute("value");
		if (present.contains(value)) {
			System.out.println(value + "  are matching.PASS");
		} else {
			System.out.println(value + " are not maching.FAIL");
		}
	}
	
	
	/*
	 * Method drawBorder will draw a RED line around the specific element
	 * 
	 * @param WebElement 
	 */
	public static void drawBorder(WebElement element) {
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.border='4px solid red'", element);
	}
	
	/*Method will scroll down
	 * @param int pixel
	 * 
	 */
	public static void scrollDown(int pixel) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,"+pixel+")");
	}
	/*Method will scroll Up
	 * @param int pixel
	 * 
	 */
	public static void scrollUp(int pixel) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,-"+pixel+")");
	}
	/*Method will click
	 * @param int pixel
	 * 
	 */
	public static void jsClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", element);


	}
	//This method will take a screenshot and save it with a specific file name
	//@param driver, String
	
	public static void takeScreenshot(String folderName,String fileName)  {
		//TakeScreenshot- interface in selenium
		//getScreenshotAs(OutputType.FILE); method to take a screenshot
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//saving element to desired location
		try {
			FileUtils.copyFile(src,new File("Screenshots/"+folderName+"/"+fileName+".png"));
		} catch (IOException e) {
			
			e.printStackTrace();
			System.out.println("No picture was taken");
		}
	}
	
	//Calendar method will runn thrue each cell and choose your input
	
	public static void calendar(List<WebElement>cell,String value) {
		
	
		for(WebElement run:cell) {
			String a=run.getText();
				if(a.contains(value)) {
					run.click();
					break;
				}
			}
	}
	
	public static void tableFindElementClick(List<WebElement>cell,String value) {
		
		
		for(WebElement run:cell) {
			String a=run.getText();
				if(a.contains(value)) {
					run.click();
					break;
				}
			}
	}
	//Method will go in each cell of the table and compare the value
	
	public static void tableCompareEachCell(List<WebElement>cell,String value) {
		boolean flag=true;
		for(WebElement run:cell) {
			String a=run.getText();
				if(a.contains(value)) {
					System.out.println(value+" is present");
					flag=false;
					break;
				}
			}
		
		if(flag) {
			System.out.println("Were is no such element");
		}
	}

	public static void waitForElementBeClickable(WebElement element,int time) {
		WebDriverWait wait=new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	public static void waitForElementBeClickable(By locator,int time) {
		WebDriverWait wait=new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		
	}
	public static void waitForElementBeVisible(By locator,int time) {
		WebDriverWait wait=new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		
	}
	public static void waitForElementBeVisible(WebElement element,int time) {
		WebDriverWait wait=new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.visibilityOfElementLocated((By) element));
		
	}
}
