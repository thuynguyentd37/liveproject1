package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DriverFactory {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    //private static Properties prop;
    static {
        PropertyUtils.loadProperties();  // Ensure properties are loaded
    }


    public static WebDriver getDriver() {
        if (driver.get() == null) {
            driver.set(createDriver());
        }
        return driver.get();
    }

    private static WebDriver createDriver() {
        String browser = System.getProperty("browser", PropertyUtils.getProperty("browser")).toLowerCase();
        String runMode = System.getProperty("runMode", PropertyUtils.getProperty("runMode")).toLowerCase();
        boolean headless = Boolean.parseBoolean(System.getProperty("headless", PropertyUtils.getProperty("headless")));

        WebDriver driverInstance;

        if (runMode.equals("remote")) {
            driverInstance = setupRemoteLambdatestDriver();
        } else {
            driverInstance = setupLocalDriver(browser, headless);
        }

        driverInstance.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driverInstance.manage().window().maximize();
        return driverInstance;
    }

    private static WebDriver setupLocalDriver(String browser, boolean headless) {
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                if (headless) {
                    chromeOptions.addArguments("--headless"); // Enable headless mode
                    chromeOptions.addArguments("--disable-gpu"); // Disable GPU acceleration (optional)
                    //chromeOptions.addArguments("--window-size=1920,1080"); // Set window size if needed
                }
                return new ChromeDriver(chromeOptions);
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            case "edge":
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }

    private static WebDriver setupRemoteLambdatestDriver() {

        String username = PropertyUtils.getProperty("lt_username");
        String accessKey = PropertyUtils.getProperty("lt_access_key");

        String hubURL = "https://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub";

        // Setting up LambdaTest Chrome browser options
        Map<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("platformName", "Windows 10");
        ltOptions.put("browserName", "Chrome");
        ltOptions.put("browserVersion", "latest");
        ltOptions.put("resolution", "1920x1080");
        ltOptions.put("w3c", true);
        ltOptions.put("build", "LambdaTest-Windows-Chrome");
        ltOptions.put("name", "Chrome on Windows Test");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("LT:Options", ltOptions);

        try {
            return new RemoteWebDriver(new URL(hubURL), chromeOptions);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid LambdaTest URL", e);
        }
    }



    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
