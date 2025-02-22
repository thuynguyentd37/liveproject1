package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BasePage;
import utils.DriverFactory;

public class OrderFormDelivery extends BasePage{

	By firstNameField = By.cssSelector("input[name='firstname']");
	By lastNameField = By.cssSelector("input[name='lastname']");
	By companyNameField = By.cssSelector("input[name='company']");
	By addressField = By.cssSelector("input[name='address1']");
	By addressComplementField = By.cssSelector("input[name='address2']");
	By cityField = By.cssSelector("input[name='city']");
	By stateDropdown = By.cssSelector("select[name='id_state']");
	By postcodeField = By.cssSelector("input[name='postcode']");
	By countryDropdown = By.cssSelector("select[name='id_country']");
	By phoneField = By.cssSelector("input[name='phone']");
	By invoiceSameAddCheckboc = By.cssSelector("input#use_same_address");
	By continueBtn = By.cssSelector("button[name='confirm-addresses']");

	public OrderFormDelivery() throws IOException {
		super();
	}

	public WebElement getFirstNameField() throws IOException {

		return DriverFactory.getDriver().findElement(firstNameField);
	}

	public WebElement getLastnameField() throws IOException {

		return DriverFactory.getDriver().findElement(lastNameField);
	}

	public WebElement getCompanyField() throws IOException {

		return DriverFactory.getDriver().findElement(companyNameField);
	}

	public WebElement getAddressField() throws IOException {

		return DriverFactory.getDriver().findElement(addressField);
	}

	public WebElement getAddressCompField() throws IOException {

		return DriverFactory.getDriver().findElement(addressComplementField);
	}

	public WebElement getCityField() throws IOException {

		return DriverFactory.getDriver().findElement(cityField);
	}

	public WebElement getStateDropdown() throws IOException {

		return DriverFactory.getDriver().findElement(stateDropdown);
	}

	public WebElement getPostcodeField() throws IOException {

		return DriverFactory.getDriver().findElement(postcodeField);
	}

	public WebElement getCountryDropdown() throws IOException {

		return DriverFactory.getDriver().findElement(countryDropdown);
	}

	public WebElement getPhoneField() throws IOException {

		return DriverFactory.getDriver().findElement(phoneField);
	}

	public WebElement getInvoiceSameAddCheckbox() throws IOException {

		return DriverFactory.getDriver().findElement(invoiceSameAddCheckboc);
	}

	public WebElement getContinueBtn() throws IOException {

		return DriverFactory.getDriver().findElement(continueBtn);
	}

}
