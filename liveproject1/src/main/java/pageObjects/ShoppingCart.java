package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import base.BasePage;
import utils.DriverFactory;

public class ShoppingCart extends BasePage{
	
	By havePromo = By.linkText("Have a promo code?");
	By promoTextbox = By.cssSelector("input[name='discount_name']");
	By promoAddBtn = By.cssSelector("form[method='post']  span");
	By proceedToCheckoutBtn = By.linkText("PROCEED TO CHECKOUT");
	By deleteItemOne = By.cssSelector(".cart-items .cart-item:nth-of-type(1) .float-xs-left");
	By deleteItemTwo = By.cssSelector(".cart-items .cart-item:nth-of-type(2) .float-xs-left");
	By totalValue = By.cssSelector(".cart-total .value");
	
	public ShoppingCart() throws IOException {
		super();
	}
	
	public WebElement getHavePromo() throws IOException {
		return DriverFactory.getDriver().findElement(havePromo);
	}
	
	public WebElement getPromoTextbox() throws IOException {
		return DriverFactory.getDriver().findElement(promoTextbox);
	}
	
	public WebElement getPromoAddBtn() throws IOException {
		return DriverFactory.getDriver().findElement(promoAddBtn);
	}
	
	public WebElement getProceedCheckoutBtn() throws IOException {
		return DriverFactory.getDriver().findElement(proceedToCheckoutBtn);
	}
	
	public WebElement getDeleteItemOne() throws IOException {
		return DriverFactory.getDriver().findElement(deleteItemOne);
	}
	
	public WebElement getDeleteItemTwo() throws IOException {
		return DriverFactory.getDriver().findElement(deleteItemTwo);
	}
	
	public WebElement getTotalAmount() throws IOException {
		return DriverFactory.getDriver().findElement(totalValue);
	}

}
