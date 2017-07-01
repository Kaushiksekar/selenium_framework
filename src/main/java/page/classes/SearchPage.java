package page.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import page.utilities.UtilitiesClass;

public class SearchPage {
	public static WebElement element = null;
	
	/**
	 * Returns the flight origin text box element
	 * 
	 * @param driver
	 * @return
	 */
	public static WebElement flightTab(WebDriver driver){
		element=driver.findElement(By.id("tab-flight-tab"));
		return element;
	}
	
	public static void clickFlightTab(WebDriver driver){
		element=flightTab(driver);
		//element.click();
		UtilitiesClass.lowRiskClick(element);
	}
	
	/**
	 * Returns the flight origin text box element
	 * 
	 * @param driver
	 * @return
	 */
	public static WebElement originTextBox(WebDriver driver) {
		element = driver.findElement(By.id("flight-origin"));
		return element;
	}

	public static void fillOriginTextBox(WebDriver driver, String origin) {
		element = originTextBox(driver);
//		element.sendKeys(origin);
		UtilitiesClass.lowRiskSendKeys(element,origin);
	}

	/**
	 * Returns the flight destination text box element
	 * 
	 * @param driver
	 * @return
	 */
	public static WebElement destinationTextBox(WebDriver driver) {
		element = driver.findElement(By.id("flight-destination"));
		return element;
	}

	/**
	 * Returns the departure date text box element
	 * 
	 * @param driver
	 * @return
	 */
	public static WebElement departureDateTextBox(WebDriver driver) {
		element = driver.findElement(By.id("flight-departing"));
		return element;
	}

	/**
	 * Returns the return date text box element
	 * 
	 * @param driver
	 * @return
	 */
	public static WebElement returnDateTextBox(WebDriver driver) {
		element = driver.findElement(By.id("flight-returning"));
		return element;
	}

	/**
	 * Returns the search button box element
	 * 
	 * @param driver
	 * @return
	 */
	public static WebElement searchButton(WebDriver driver) {
		element = driver.findElement(By.id("search-button"));
		return element;
	}

	/**
	 * Click on search button
	 * 
	 * @param driver
	 */
	public static void clickOnSearchButton(WebDriver driver) {
		element = searchButton(driver);
		element.click();
	}
	
	/**
	 * Email to signup
	 * 
	 * @param driver
	 */
	public static WebElement signupTextBox(WebDriver driver){
		element=driver.findElement(By.id("email"));
		return element;
	}
	
	public static void fillSignupTextBox(WebDriver driver, String emailID){
		element=signupTextBox(driver);
		UtilitiesClass.lowRiskSendKeys(element, emailID);
	}
	
	/**
	 * Click signup button
	 * 
	 * @param driver
	 */
	public static WebElement signupButton(WebDriver driver){
		element=driver.findElement(By.id("btn-action"));
		return element;
	}
	
	public static void clickSignupButton(WebDriver driver){
		element=signupButton(driver);
		UtilitiesClass.lowRiskClick(element);
	}
	
	/**
	 * Signup error box
	 * 
	 * @param driver
	 */
	public static void checkSignupError(WebDriver driver){
		element=driver.findElement(By.id("errorMessage"));
		Assert.assertTrue(element.isDisplayed());
	}
	
	public static void exitDriver(WebDriver driver){
		driver.close();
	}
}
