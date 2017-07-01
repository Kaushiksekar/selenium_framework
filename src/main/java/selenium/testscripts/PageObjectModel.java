package selenium.testscripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.classes.SearchPage;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PageObjectModel {
	private WebDriver driver;
	private ChromeOptions options;
	private String baseUrl;

	@BeforeClass
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/Users/kaushiksekar/Documents/Selenium/Drivers/chromedriver");
		options=new ChromeOptions();
		options.addArguments("--kiosk");
		driver = new ChromeDriver(options);
		baseUrl = "https://www.expedia.com/";

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void test1() {
		driver.get(baseUrl);
		SearchPage.clickFlightTab(driver);
		SearchPage.fillOriginTextBox(driver, "Chennai, India (MAA-Chennai Intl.)");
		SearchPage.destinationTextBox(driver).sendKeys("Bengaluru, India (BLR-Kempegowda Intl.)");
		SearchPage.departureDateTextBox(driver).sendKeys("01/07/2017");
		SearchPage.returnDateTextBox(driver).clear();
		SearchPage.returnDateTextBox(driver).sendKeys("05/07/2017");
		SearchPage.clickOnSearchButton(driver);
	}
	
	@Test
	public void test2(){
		SearchPage.clickFlightTab(driver);
		SearchPage.fillSignupTextBox(driver, "vadcdafcad");
		SearchPage.clickSignupButton(driver);
		SearchPage.checkSignupError(driver);
	}

	@AfterClass
	public void tearDown() throws Exception {
		SearchPage.exitDriver(driver);
	}
}
