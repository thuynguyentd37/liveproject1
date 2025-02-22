package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BasePage;
import utils.DriverFactory;

public class OrderFormShippingMethod extends BasePage{

	By deliveryMsgTextbox = By.cssSelector("textarea#delivery_message");
	By continueBtn = By.cssSelector("[name='confirmDeliveryOption']");

	public OrderFormShippingMethod() throws IOException {
		super();
	}
	
	public WebElement getDeliveryMsgTextbox() throws IOException {
		return DriverFactory.getDriver().findElement(deliveryMsgTextbox);
	}

	public WebElement getContinueBtn() throws IOException {
		return DriverFactory.getDriver().findElement(continueBtn);
	}

}
