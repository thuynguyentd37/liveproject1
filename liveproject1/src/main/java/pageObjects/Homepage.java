package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BasePage;

public class Homepage extends BasePage{
	public WebDriver driver;

	By toggle = By.cssSelector(".toggle");
	By homePageLink = By.linkText("HOMEPAGE");
	By accordionLink = By.linkText("ACCORDION");
	By actionslink = By.linkText("ACTIONS");
	By browserTabLink = By.linkText("BROWSER TABS");
	By buttonsLink = By.linkText("BUTTONS");
	By calcLink = By.linkText("CALCULATOR (JS)");
	By contactUsLink = By.linkText("CONTACT US FORM TEST");
	By datePickerLink = By.linkText("DATE PICKER");
	By dropdownLink = By.linkText("DROPDOWN CHECKBOX RADIO");
	By fileUpload = By.linkText("FILE UPLOAD");
	By hiddenElementsLink = By.linkText("HIDDEN ELEMENTS");
	By iFrameLink = By.linkText("IFRAMES");
	By loaderLink = By.linkText("LOADER");
	By loaderTwoLink = By.linkText("LOADER TWO");
	By loginPortalLink = By.linkText("LOGIN PORTAL TEST");
	By mouseLink = By.linkText("MOUSE MOVEMENT");
	By popupLink = By.linkText("POP UPS & ALERTS");
	By predictiveLink = By.linkText("PREDICTIVE SEARCH");
	By tablesLink = By.linkText("TABLES");
	By testStoreLink = By.linkText("TEST STORE");
	By aboutMeLink = By.linkText("ABOUT ME");
	By cookie = By.cssSelector(".close-cookie-warning > span");
	
	public Homepage() throws IOException {
		super();
	}
	
	public WebElement getCookie() throws IOException {
		this.driver = getDriver();
		return driver.findElement(cookie);
	}

	public WebElement getToggle() throws IOException {
		this.driver = getDriver();
		return driver.findElement(toggle);
	}

	public WebElement getHomePageLink() throws IOException {
		this.driver = getDriver();
		return driver.findElement(homePageLink);
	}

	public WebElement getAccordionLink() throws IOException {
		this.driver = getDriver();
		return driver.findElement(accordionLink);
	}

	public WebElement getActionslink() throws IOException {
		this.driver = getDriver();
		return driver.findElement(actionslink);
	}

	public WebElement getBrowserTabLink() throws IOException {
		this.driver = getDriver();
		return driver.findElement(browserTabLink);
	}

	public WebElement getButtonsLink() throws IOException {
		this.driver = getDriver();
		return driver.findElement(buttonsLink);
	}

	public WebElement getCalcLink() throws IOException {
		this.driver = getDriver();
		return driver.findElement(calcLink);
	}

	public WebElement getContactUsLink() throws IOException {
		this.driver = getDriver();
		return driver.findElement(contactUsLink);
	}

	public WebElement getDatePickerLink() throws IOException {
		this.driver = getDriver();
		return driver.findElement(datePickerLink);
	}

	public WebElement getDropdownLink() throws IOException {
		this.driver = getDriver();
		return driver.findElement(dropdownLink);
	}

	public WebElement getFileUpload() throws IOException {
		this.driver = getDriver();
		return driver.findElement(fileUpload);
	}

	public WebElement getHiddenElementsLink() throws IOException {
		this.driver = getDriver();
		return driver.findElement(hiddenElementsLink);
	}

	public WebElement getIFrameLink() throws IOException {
		this.driver = getDriver();
		return driver.findElement(iFrameLink);
	}

	public WebElement getLoaderLink() throws IOException {
		this.driver = getDriver();
		return driver.findElement(loaderLink);
	}

	public WebElement getLoaderTwoLink() throws IOException {
		this.driver = getDriver();
		return driver.findElement(loaderTwoLink);
	}

	public WebElement getLoginPortalLink() throws IOException {
		this.driver = getDriver();
		return driver.findElement(loginPortalLink);
	}

	public WebElement getMouseLink() throws IOException {
		this.driver = getDriver();
		return driver.findElement(mouseLink);
	}

	public WebElement getPopupLink() throws IOException {
		this.driver = getDriver();
		return driver.findElement(popupLink);
	}

	public WebElement getPredictiveLink() throws IOException {
		this.driver = getDriver();
		return driver.findElement(predictiveLink);
	}

	public WebElement getTablesLink() throws IOException {
		this.driver = getDriver();
		return driver.findElement(tablesLink);
	}

	public WebElement getTestStoreLink() throws IOException {
		this.driver = getDriver();
		return driver.findElement(testStoreLink);
	}

	public WebElement getAboutMeLink() throws IOException {
		this.driver = getDriver();
		return driver.findElement(aboutMeLink);
	}

}
