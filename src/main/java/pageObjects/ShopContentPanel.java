package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BasePage;
import utils.DriverFactory;

public class ShopContentPanel extends BasePage {


	By continueShoppingBtn = By.xpath("//button[contains(text(), 'Continue')]");
	By checkoutBtn = By.xpath("//*[text()='Proceed to checkout']");

	public ShopContentPanel() throws IOException {

	}

	public WebElement getContinueShopBtn() throws IOException {

		return DriverFactory.getDriver().findElement(continueShoppingBtn);
	}

	public WebElement getCheckoutBtn() throws IOException {

		return DriverFactory.getDriver().findElement(checkoutBtn);
	}

}
