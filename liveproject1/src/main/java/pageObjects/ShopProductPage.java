package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BasePage;
import utils.DriverFactory;

public class ShopProductPage extends BasePage{

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

		return DriverFactory.getDriver().findElement(sizeOption);
	}
	
	public WebElement getQuantIncrease() throws IOException {

		return DriverFactory.getDriver().findElement(quantityIncrease);
	}
	
	public WebElement getQuantDecrease() throws IOException {

		return DriverFactory.getDriver().findElement(quantityDecrease);	
	}
	
	public WebElement getWhiteOption() throws IOException {

		return DriverFactory.getDriver().findElement(whiteOption);	
	}
	
	public WebElement getBlackOption() throws IOException {

		return DriverFactory.getDriver().findElement(blackOption);	
	}
	
	public WebElement getAddToCartBtn() throws IOException {

		return DriverFactory.getDriver().findElement(addToCart);	
	}
	
	public WebElement getHomepageLink() throws IOException {

		return DriverFactory.getDriver().findElement(homePage);	
	}
	
}
