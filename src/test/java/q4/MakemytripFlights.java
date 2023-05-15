package q4;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MakemytripFlights {
    private WebDriver driver;
    
    public MakemytripFlights()  {
        // Set the ChromeDriver path as a system property
        String driverPath =System.getProperty("user.dir") +  "/src/test/resources/drivers/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        
        // Launch Chrome
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    
    public void openWebsite()   {
        // Navigate to the Makemytrip website
        driver.get("https://www.makemytrip.com/");
    }
    
    public void clickFlightsTab() {
        // Find and click on the Flights tab element
        WebElement flightsTab = driver.findElement(By.xpath("//span[@class='chNavIcon appendBottom2 chSprite chFlights active']"));
        flightsTab.click();
    }
    
    public void selectOneWay() {
        // Find and click on the OneWay radio button element
        WebElement oneWayRadioButton = driver.findElement(By.xpath("//li[@data-cy='oneWayTrip']"));
        oneWayRadioButton.click();
    }
    
    public void enterFromLocation(String from)  {
        // Find and enter the FROM location element
        WebElement fromLocation = driver.findElement(By.xpath("//input[@id='fromCity']"));
        fromLocation.sendKeys(from);
        
    }
    
    public void enterToLocation(String to) {
        // Find and enter the TO location element
        WebElement toLocation = driver.findElement(By.xpath("//input[@id='toCity']"));
        toLocation.sendKeys(to);
    }
    
    public void closeWebsite() {
        // Close the browser
        driver.quit();
    }
    
    public static void main(String[] args)  {
        MakemytripFlights flights = new MakemytripFlights();
        flights.openWebsite();
        flights.clickFlightsTab();
        flights.selectOneWay();
        flights.enterFromLocation("Chennai");
        flights.enterToLocation("Delhi");
        flights.closeWebsite();
    }
}
