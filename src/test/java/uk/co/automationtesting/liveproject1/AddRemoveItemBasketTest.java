package uk.co.automationtesting.liveproject1;

import base.ExtentManager;
import base.Hooks;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.*;
import utils.WebDriverHelper;
import utils.DriverFactory;
import java.io.IOException;

@Listeners(resources.Listeners.class)
@Test(groups= {"regression"})

public class AddRemoveItemBasketTest extends Hooks {
	private WebDriverHelper helper;
	public AddRemoveItemBasketTest() throws IOException {
		super();
		this.helper = new WebDriverHelper();
	}

	@Test
	public void addRemoveItem() throws IOException, InterruptedException {
		
		ExtentManager.log("Starting AddRemoveItemBasketTest...");
		
		// creating an object of the automationtesting.co.uk webpage
		Homepage home = new Homepage();

		//handle cookie visibility using JSE - added 20230217
		JavascriptExecutor jse = (JavascriptExecutor) DriverFactory.getDriver();
		jse.executeScript("arguments[0].scrollIntoView()", home.getTestStoreLink());
		helper.clickElement(home.getTestStoreLink());

		// creating an object of the test store homepage
		ShopHomepage shopHome = new ShopHomepage();
		Thread.sleep(1000);
		ExtentManager.pass("Reached the shop homepage");
		helper.clickElement(shopHome.getProdOne());

		// creating an object of the shop products page (when a product has been
		// selected)
		ShopProductPage shopProd = new ShopProductPage();
		ExtentManager.pass("Reached the shop product page");
		Select option = new Select(shopProd.getSizeOption());
		option.selectByVisibleText("M");
		ExtentManager.pass("Have successfully selected product size");
		helper.clickElement(shopProd.getQuantIncrease());
		ExtentManager.pass("Have successfully increased quantity");
		helper.clickElement(shopProd.getAddToCartBtn());
		ExtentManager.pass("Have successfully added product to basket");

		// creating an object of the cart content panel (once an item was added)
		ShopContentPanel cPanel = new ShopContentPanel();
		Thread.sleep(1000);
		helper.clickElement(cPanel.getContinueShopBtn());
		helper.clickElement(shopProd.getHomepageLink());
		helper.clickElement(shopHome.getProdTwo());
		helper.clickElement(shopProd.getAddToCartBtn());
		//SeleniumHelper helper = new SeleniumHelper();
		//helper.clickElementByXPath("//*[text()='Proceed to checkout']");
		Thread.sleep(3000);
		WebElement checkoutBtn = cPanel.getCheckoutBtn();
		helper.waitForElementToBeClickable(checkoutBtn,5);
		helper.clickElement(checkoutBtn);

		// creating an object for the shopping cart page and deleting item 2
		ShoppingCart cart = new ShoppingCart();
		helper.clickElement(cart.getDeleteItemTwo());

		// using a wait to ensure the deletion has taken place
		helper.waitForElementInvisible(cart.getDeleteItemTwo(), 10);

		// printing the total amount to console
		System.out.println(cart.getTotalAmount().getText());
		
		try {
			// using an assertion to make sure the total amount is what we are expecting
			Assert.assertEquals(cart.getTotalAmount().getText(), "$45.23");
			ExtentManager.pass("The total amount matches the expected amount.");
		} catch (AssertionError e) {
			Assert.fail("Cart amount did not match the expected amount, it found" + cart.getTotalAmount().getText() +
					" expected $45.23");
			ExtentManager.fail("The total amount did not match the expected amount.");
		}

	}

}