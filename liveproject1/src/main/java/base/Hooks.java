package base;

import java.io.IOException;
import drivers.DriverFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Hooks extends BasePage {

	public Hooks() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeTest(alwaysRun=true)
	public void setup() throws IOException {
		getDriver().get(getUrl());

	}
	
	
	@AfterTest(alwaysRun=true)
	public void tearDown() {
		DriverFactory.quitDriver();
	}
}
