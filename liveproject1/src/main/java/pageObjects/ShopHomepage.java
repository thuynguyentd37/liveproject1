package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BasePage;
import utils.DriverFactory;

public class ShopHomepage extends BasePage{
	
	By productOne = By.linkText("Hummingbird Printed T-Shirt");
	By productTwo = By.linkText("Hummingbird Printed Sweater");
	By productThree = By.linkText("The Best Is Yet To Come'...");
	By productFour = By.linkText("The Adventure Begins Framed...");
	By productFive = By.linkText("Today Is A Good Day Framed...");
	By productSix = By.linkText("Mug The Best Is Yet To Come");
	By productSeven = By.linkText("Mug The Adventure Begins");
	By productEight = By.linkText("Mug Today Is A Good Day");
	
	public ShopHomepage() throws IOException {
		super();
	}
	
	public WebElement getProdOne() throws IOException {

		return DriverFactory.getDriver().findElement(productOne);
	}
	
	public WebElement getProdTwo() throws IOException {

		return DriverFactory.getDriver().findElement(productTwo);
	}
	
	public WebElement getProdThree() throws IOException {

		return DriverFactory.getDriver().findElement(productThree);
	}	
	
	public WebElement getProdFour() throws IOException {

		return DriverFactory.getDriver().findElement(productFour);
	}	

	public WebElement getProdFive() throws IOException {

		return DriverFactory.getDriver().findElement(productFive);
	}	
	
	public WebElement getProdSix() throws IOException {

		return DriverFactory.getDriver().findElement(productSix);
	}	
	
	public WebElement getProdSeven() throws IOException {

		return DriverFactory.getDriver().findElement(productSeven);
	}	
	
	public WebElement getProdEight() throws IOException {

		return DriverFactory.getDriver().findElement(productEight);
	}

}
