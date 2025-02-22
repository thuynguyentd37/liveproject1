package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import base.BasePage;
import utils.DriverFactory;

public class OrderFormPersInfo extends BasePage{
	
	By genderMr = By.cssSelector("label:nth-of-type(1) > .custom-radio > input[name='id_gender']");
	By genderMrs = By.cssSelector("label:nth-of-type(2) > .custom-radio > input[name='id_gender']");
	By firstNameField = By.cssSelector("input[name='firstname']");
	By lastNameField = By.cssSelector("input[name='lastname']");
//depricated:	By emailField = By.cssSelector("form#customer-form > section input[name='email']");
	By emailField = By.cssSelector("input#field-email"); //ADDDED 2024-03-15
	By passwordField = By.cssSelector("form#customer-form > section input[name='password']");
	By birthDateField = By.cssSelector("input[name='birthday']");
	By receiveOffersCheckbox = By.cssSelector("div:nth-of-type(7)  span > label > span");
	By newsletterCheckbox = By.cssSelector("div:nth-of-type(8)  span > label > span");
	By termsConditionsCheckbox = By.cssSelector("input[name='psgdpr']");
	By continueBtn = By.cssSelector("form#customer-form  button[name='continue']");
	
	public OrderFormPersInfo() throws IOException {
		super();
	}
	
	public WebElement getGenderMr() throws IOException {

		return DriverFactory.getDriver().findElement(genderMr);
	}

	public WebElement getGenderMrs() throws IOException {

		return DriverFactory.getDriver().findElement(genderMrs);
	}

	public WebElement getFirstNameField() throws IOException {

		return DriverFactory.getDriver().findElement(firstNameField);
	}
	
	public WebElement getLastNameField() throws IOException {

		return DriverFactory.getDriver().findElement(lastNameField);
	}

	public WebElement getEmailField() throws IOException {

		return DriverFactory.getDriver().findElement(emailField);
	}
	
	public WebElement getPasswordField() throws IOException {

		return DriverFactory.getDriver().findElement(passwordField);
	}
	
	public WebElement getBirthDateField() throws IOException {

		return DriverFactory.getDriver().findElement(birthDateField);
	}
	
	public WebElement getRecOfferCheckbox() throws IOException {

		return DriverFactory.getDriver().findElement(receiveOffersCheckbox);
	}
	
	public WebElement getNewsletterCheckbox() throws IOException {

		return DriverFactory.getDriver().findElement(newsletterCheckbox);
	}
	
	public WebElement getTermsConditionsCheckbox() throws IOException {

		return DriverFactory.getDriver().findElement(termsConditionsCheckbox);
	}
	
	public WebElement getContinueBtn() throws IOException {

		return DriverFactory.getDriver().findElement(continueBtn);
	}


}
