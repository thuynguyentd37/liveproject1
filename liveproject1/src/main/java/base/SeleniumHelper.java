package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import static utils.DriverFactory.getDriver;

public class SeleniumHelper {

    WebDriver driver;

    // Constructor to initialize the WebDriver
    public SeleniumHelper() throws IOException {
        this.driver = getDriver();
    }

    // Method to click element by XPath using explicit wait
    public void clickElementByXPath(String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Explicit wait with 10 seconds timeout
        try {
            // Wait for the element to be clickable
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            element.click(); // Click the element
            System.out.println("Element clicked successfully.");
        } catch (Exception e) {
            System.out.println("Element could not be clicked. Error: " + e.getMessage());
        }
    }
}
