package base;

// Import necessary libraries
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

// Class to manage WebDriver instances using ThreadLocal
public class WebDriverInstance {

	// ThreadLocal to hold WebDriver instances for each thread
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	// Method to get the WebDriver instance for the current thread
	public static WebDriver getDriver() throws IOException {
		if (driver.get() == null) {
			// Set up the WebDriver (e.g., ChromeDriver)
			driver.set(createDriver());
		}
		return driver.get();
	}

	// Method to create and configure a new WebDriver instance
	public static WebDriver createDriver() throws IOException {
		// Retrieve the browser and headless mode from Maven properties or environment
		// variables
		String browser = System.getProperty("browser");
		String headless = System.getProperty("headless", "false"); // Default to false if not set

		// If Maven property is not set, load from properties file
		if (browser == null || browser.isEmpty()) {
			Properties prop = new Properties();
			FileInputStream input = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\config.properties");
			prop.load(input);
			browser = prop.getProperty("browser", "chrome"); // Default to Chrome if not set
		}

		WebDriver driver = null;

		// Initialize the WebDriver based on the browser value
		switch (browser.toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\drivers\\chromedriver.exe");
			ChromeOptions chromeOptions = new ChromeOptions();
			if (Boolean.parseBoolean(headless)) {
				chromeOptions.addArguments("--headless"); // Enable headless mode
				chromeOptions.addArguments("--disable-gpu"); // Disable GPU acceleration (optional)
				//chromeOptions.addArguments("--window-size=1920,1080"); // Set window size if needed
			}
			driver = new ChromeDriver(chromeOptions);
			break;

		case "firefox":
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\drivers\\geckodriver.exe");
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			if (Boolean.parseBoolean(headless)) {
				firefoxOptions.addArguments("-headless"); // Enable headless mode
				//firefoxOptions.addArguments("--width=1920"); // Set window width (optional)
				//firefoxOptions.addArguments("--height=1080"); // Set window height (optional)
			}
			driver = new FirefoxDriver(firefoxOptions);
			break;

		default:
			throw new IllegalArgumentException("Unsupported browser: " + browser);
		}

		// Set implicit wait timeout and maximize browser window
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();

		return driver;
	}

	// Method to clean up WebDriver instance for the current thread
	public static void cleanupDriver() {
		if (driver.get() != null) {
			driver.get().quit(); // Quit the WebDriver instance
			driver.remove(); // Remove the WebDriver instance from ThreadLocal
		}
	}
}