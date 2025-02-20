package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DriverFactory {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static Properties prop;

    static {
        loadProperties();
    }

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            driver.set(createDriver());
        }
        return driver.get();
    }

    private static WebDriver createDriver() {
        String browser = System.getProperty("browser", prop.getProperty("browser", "chrome")).toLowerCase();
        String runMode = System.getProperty("runMode", prop.getProperty("runMode", "local")).toLowerCase();
        boolean headless = Boolean.parseBoolean(System.getProperty("headless", prop.getProperty("headless", "false")));

        WebDriver driverInstance;

        if (runMode.equals("remote")) {
            driverInstance = setupRemote_LambdatestDriver(browser);
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

    private static WebDriver setupRemote_LambdatestDriver(String browser) {
        String username = prop.getProperty("lt_username");
        String accessKey = prop.getProperty("lt_access_key");
        String hubURL = "https://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", browser);
        capabilities.setCapability("platformName", "Windows 10");
        capabilities.setCapability("version", "latest");
        capabilities.setCapability("resolution", "1920x1080");
        capabilities.setCapability("build", "LambdaTest-Build");
        capabilities.setCapability("name", "LambdaTest Execution");

        try {
            return new RemoteWebDriver(new URL(hubURL), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid LambdaTest URL", e);
        }
    }

    private static void loadProperties() {
        prop = new Properties();
        try (FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/resources/config.properties")) {
            prop.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
