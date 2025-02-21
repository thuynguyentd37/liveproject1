package base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.DriverFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

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
	/*public static WebDriver getDriver() throws IOException {
		return DriverFactory.getDriver();
	}*/

	// Method to get URL from properties file
	public String getUrl() throws IOException {
		url = prop.getProperty("url");
		//System.out.println(url);
		return url;
	}

	// Method to take a screenshot with a given name
	public static String takeSnapShot(String name) throws IOException {
		File srcFile = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);

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
	

}
