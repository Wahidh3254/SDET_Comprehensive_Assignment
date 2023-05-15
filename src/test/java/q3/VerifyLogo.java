package q3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class VerifyLogo {

	public static void main(String[] args) {
		// Set the GeckoDriver path
        System.setProperty("webdriver.gecko.driver",  System.getProperty("user.dir") + "/src/test/resources/drivers/geckodriver.exe");
        
        String binaryPath="C:/Program Files/Mozilla Firefox/firefox.exe";
     // Set the Firefox binary location as a system property
        System.setProperty("webdriver.firefox.bin", binaryPath);
        
        // Set the FirefoxOptions to use the binary location
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary(binaryPath);
        
        // Launch Firefox
        WebDriver driver = new FirefoxDriver();
        
        // Navigate to the Makemytrip website
        driver.get("https://www.makemytrip.com/");
        
        // Find the Makemytrip logo element
        WebElement logo = driver.findElement(By.xpath("//img[@alt='Make My Trip']"));
        
        // Verify if the logo is present on the page
        if (logo.isDisplayed()) {
            System.out.println("Makemytrip logo is present on the page");
        } else {
            System.out.println("Makemytrip logo is not present on the page");
        }
        
        // Close the browser
        driver.quit();
		
	}

}
