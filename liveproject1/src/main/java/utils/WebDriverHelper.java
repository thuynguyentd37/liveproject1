package utils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.time.Duration;


import static utils.DriverFactory.getDriver;

public class WebDriverHelper {

    //private WebDriver driver;

    public WebDriverHelper() throws IOException {
        //this.driver = getDriver();
    }

    /**
     * Clicks on an element with retry logic to handle stale elements.
     */
    public void clickElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        try {
                // Ensure element is visible before waiting for it to be clickable
                wait.until(ExpectedConditions.visibilityOf(element));
                wait.until(ExpectedConditions.elementToBeClickable(element)).click();
            } catch (Exception e) {
                System.out.println("⚠️ Timeout: Element not visible, trying JavaScript click.");
                ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", element);
            }

    }

    public void sendKeysElement(WebElement element, String text) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
            try {
                // Ensure element is visible before sending keys
                wait.until(ExpectedConditions.visibilityOf(element));
                element.clear(); // Clear input field before sending keys
                element.sendKeys(text);
            } catch (Exception e) {
                System.out.println("⚠️ Timeout: Element not visible, trying JavaScript sendKeys.");
                ((JavascriptExecutor) getDriver()).executeScript("arguments[0].value = arguments[1];", element, text);
            }

    }


    public void waitForElementInvisible(WebElement element, int timer)  {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timer));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void waitForElementToBeClickable(WebElement element, int timer) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timer));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

}
