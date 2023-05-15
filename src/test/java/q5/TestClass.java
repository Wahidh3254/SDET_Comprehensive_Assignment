package q5;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestClass {

	private WebDriver driver;

	@BeforeMethod
	public void launchBrowser() {
		// Set the ChromeDriver path as a system property
		String driverPath = System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);

		// Launch Chrome
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// Navigate to the Makemytrip website
		driver.get("https://www.makemytrip.com/");
	}

	@Test
	public void verifyLogo() {
		// Find the Makemytrip logo element
		WebElement logo = driver.findElement(By.xpath("//img[@alt='Make My Trip']"));

		// Verify if the logo is present on the page
		Assert.assertTrue(logo.isDisplayed(), "Makemytrip logo is not present on the page");
	}

	@Test
	public void searchFlights() {
		driver.findElement(By.xpath("//span[@class='chNavIcon appendBottom2 chSprite chFlights active']")).click();
		driver.findElement(By.xpath("//li[@data-cy='oneWayTrip']")).click();
		driver.findElement(By.xpath("//input[@id='fromCity']")).sendKeys("Chennai");
		driver.findElement(By.xpath("//input[@id='toCity']")).sendKeys("Delhi");
		WebElement searchBtn=driver.findElement(By.xpath("//a[text()='Search']"));
		Assert.assertTrue(searchBtn.isDisplayed(), "Search button is not present on the page");
	}

	@AfterMethod
	public void quitBrowser() {
		// Close the browser
		driver.quit();
	}

}
