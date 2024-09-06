package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BasePage;

public class ShopProductPage extends BasePage{
	
	public WebDriver driver;
	By sizeOption = By.cssSelector("[aria-label='Size']");
	By quantityIncrease = By.cssSelector(".touchspin-up");
	By quantityDecrease = By.cssSelector(".touchspin-down");
	By whiteOption = By.cssSelector("[aria-label='White'] [type]");
	By blackOption = By.cssSelector("[aria-label='Black'] [type]");
	By addToCart = By.cssSelector("[data-button-action]");
	By homePage = By.xpath("//span[.='Home']");
	
	
	public ShopProductPage() throws IOException {
		super();
	}
	
	public WebElement getSizeOption() throws IOException {
		this.driver = getDriver();
		return driver.findElement(sizeOption);
	}
	
	public WebElement getQuantIncrease() throws IOException {
		this.driver = getDriver();
		return driver.findElement(quantityIncrease);
	}
	
	public WebElement getQuantDecrease() throws IOException {
		this.driver = getDriver();
		return driver.findElement(quantityDecrease);	
	}
	
	public WebElement getWhiteOption() throws IOException {
		this.driver = getDriver();
		return driver.findElement(whiteOption);	
	}
	
	public WebElement getBlackOption() throws IOException {
		this.driver = getDriver();
		return driver.findElement(blackOption);	
	}
	
	public WebElement getAddToCartBtn() throws IOException {
		this.driver = getDriver();
		return driver.findElement(addToCart);	
	}
	
	public WebElement getHomepageLink() throws IOException {
		this.driver = getDriver();
		return driver.findElement(homePage);	
	}
	
}
