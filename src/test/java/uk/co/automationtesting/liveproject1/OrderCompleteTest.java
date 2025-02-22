package uk.co.automationtesting.liveproject1;

import java.io.IOException;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.ExtentManager;
import base.Hooks;
import pageObjects.Homepage;
import pageObjects.OrderFormDelivery;
import pageObjects.OrderFormPayment;
import pageObjects.OrderFormPersInfo;
import pageObjects.OrderFormShippingMethod;
import pageObjects.ShopContentPanel;
import pageObjects.ShopHomepage;
import pageObjects.ShopProductPage;
import pageObjects.ShoppingCart;
import utils.WebDriverHelper;


@Listeners(resources.Listeners.class)
@Test(groups= {"smoke","regression"})
public class OrderCompleteTest extends Hooks {
	private WebDriverHelper helper;
	public OrderCompleteTest() throws IOException {
		super();
		this.helper = new WebDriverHelper();
	}

	@Test
	public void endToEndTest() throws InterruptedException, IOException {

		ExtentManager.log("Starting OrderCompleteTest...");

		// Creating an object of the automationtesting.co.uk webpage
		Homepage home = new Homepage();

		// Handles cookie prompt
		helper.clickElement(home.getCookie());

		helper.clickElement(home.getTestStoreLink());
		ExtentManager.pass("Have successfully reached store homepage");

		// Creating an object of the test store homepage
		ShopHomepage shopHome = new ShopHomepage();
		helper.clickElement(shopHome.getProdOne());
		ExtentManager.pass("Have successfully clicked on product");

		// Creating an object of the shop products page (when a product has been selected)
		ShopProductPage shopProd = new ShopProductPage();
		ExtentManager.pass("Have successfully reached shop product page");

		Select option = new Select(shopProd.getSizeOption());
		option.selectByVisibleText("M");
		ExtentManager.pass("Have successfully selected product size");

		helper.clickElement(shopProd.getQuantIncrease());
		ExtentManager.pass("Have successfully increased quantity");

		helper.clickElement(shopProd.getAddToCartBtn());
		ExtentManager.pass("Have successfully added item to cart");

		// Creating an object of the cart content panel (once an item was added)
		ShopContentPanel cPanel = new ShopContentPanel();
		Thread.sleep(2000);
		helper.clickElement(cPanel.getCheckoutBtn());

		// Creating an object of the shopping cart page (all items selected)
		ShoppingCart cart = new ShoppingCart();
		ExtentManager.pass("Have successfully reached the shopping cart page");

		helper.clickElement(cart.getHavePromo());
		ExtentManager.pass("Have successfully selected the promo button");
		helper.sendKeysElement(cart.getPromoTextbox(),"20OFF");
		helper.clickElement(cart.getPromoAddBtn());

		helper.clickElement(cart.getProceedCheckoutBtn());
		ExtentManager.pass("Have successfully selected the check out button");

		// Creating an object of the order personal information page
		OrderFormPersInfo pInfo = new OrderFormPersInfo();
		Thread.sleep(2000);
		pInfo.getGenderMrs().click();
		//helper.clickElement(pInfo.getGenderMr());
		helper.sendKeysElement(pInfo.getFirstNameField(),"Thuy");
		helper.sendKeysElement(pInfo.getLastNameField(), "Smith");
		helper.sendKeysElement(pInfo.getEmailField(),"thuysmith@test.com");
		helper.clickElement(pInfo.getTermsConditionsCheckbox());
		helper.clickElement(pInfo.getContinueBtn());
		ExtentManager.pass("Have successfully entered customer details");

		// Creating an object of the order delivery info page
		OrderFormDelivery orderDelivery = new OrderFormDelivery();
		Thread.sleep(5000);
		helper.sendKeysElement(orderDelivery.getAddressField(),"123 Main Street");
		helper.sendKeysElement(orderDelivery.getCityField(),"Houston");

		Select state = new Select(orderDelivery.getStateDropdown());
		state.selectByVisibleText("Texas");

		helper.sendKeysElement(orderDelivery.getPostcodeField(),"77021");
		helper.clickElement(orderDelivery.getContinueBtn());
		ExtentManager.pass("Have successfully entered delivery info");

		// Creating an object of the shipping method page
		OrderFormShippingMethod shipMethod = new OrderFormShippingMethod();
		helper.sendKeysElement(shipMethod.getDeliveryMsgTextbox(),"If I am not in, please leave my delivery on my porch.");
		helper.clickElement(shipMethod.getContinueBtn());
		ExtentManager.pass("Have successfully selected the shipping method");

		// Creating an object of the payment options page
		OrderFormPayment orderPay = new OrderFormPayment();
		helper.clickElement(orderPay.getPayByCheckRadioBtn());
		helper.clickElement(orderPay.getTermsConditionsCheckbox());
		helper.clickElement(orderPay.getOrderBtn());
		ExtentManager.pass("Have successfully placed order");
	}

}
