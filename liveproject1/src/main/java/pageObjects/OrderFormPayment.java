package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BasePage;
import utils.DriverFactory;

public class OrderFormPayment extends BasePage{

	By payByCheck = By.xpath("//span[.='Pay by Check']");
	By payByWire = By.xpath("//span[.='Pay by bank wire']");
	By termsAndConditions = By.xpath("//input[@id='conditions_to_approve[terms-and-conditions]']");
	By orderBtn = By.xpath("//div[@id='payment-confirmation']//button[@type='submit']");

	public OrderFormPayment() throws IOException {
		super();
	}

	public WebElement getPayByCheckRadioBtn() throws IOException {
		return DriverFactory.getDriver().findElement(payByCheck);
	}

	public WebElement getPayByWireRadioBtn() throws IOException {
		return DriverFactory.getDriver().findElement(payByWire);
	}

	public WebElement getTermsConditionsCheckbox() throws IOException {
		return DriverFactory.getDriver().findElement(termsAndConditions);
	}

	public WebElement getOrderBtn() throws IOException {
		return DriverFactory.getDriver().findElement(orderBtn);
	}

}
