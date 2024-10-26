package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {

    // Declare instance variables
	private String url;
	private Properties prop;
	public static String screenShotDestinationPath;

	// Constructor to initialize properties
	public BasePage() throws IOException {
		prop = new Properties();
		// Load properties from config file
		FileInputStream data = new FileInputStream(
				System.getProperty("user.dir")
						+ File.separator + "src"
						+ File.separator + "main"
						+ File.separator + "java"
						+ File.separator + "resources"
						+ File.separator + "config.properties");
		prop.load(data);
	}

	// Method to get WebDriver instance
	public static WebDriver getDriver() throws IOException {
		return WebDriverInstance.getDriver();
	}

	// Method to get URL from properties file
	public String getUrl() throws IOException {
		url = prop.getProperty("url");
		//System.out.println(url);
		return url;
	}

	// Method to take a screenshot with a given name
	public static String takeSnapShot(String name) throws IOException {
		File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);

		String destFile = System.getProperty("user.dir")
				+ File.separator + "target"
				+ File.separator + "screenshots"
				+ File.separator + timestamp() + ".png";
        screenShotDestinationPath = destFile;
		
		try {
			FileUtils.copyFile(srcFile, new File(destFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return name;
		
	}

	// Method to generate a timestamp
	public static String timestamp() {
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}
	
	public static String getScreenshotDestinationPath() {
		return screenShotDestinationPath;
	}
	
	public static void waitForElementInvisible(WebElement element, int timer) throws IOException {
		WebDriverWait wait = new WebDriverWait(getDriver(), timer);
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	public static void waitForElementToBeClickable(WebElement element, int timer) throws IOException {
		WebDriverWait wait = new WebDriverWait(getDriver(), timer);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
}
