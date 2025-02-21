package pageObjects;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.DriverFactory;

import java.io.IOException;

public class Homepage extends BasePage{

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

		return DriverFactory.getDriver().findElement(cookie);
	}

	public WebElement getToggle() throws IOException {

		return DriverFactory.getDriver().findElement(toggle);
	}

	public WebElement getHomePageLink() throws IOException {

		return DriverFactory.getDriver().findElement(homePageLink);
	}

	public WebElement getAccordionLink() throws IOException {

		return DriverFactory.getDriver().findElement(accordionLink);
	}

	public WebElement getActionslink() throws IOException {

		return DriverFactory.getDriver().findElement(actionslink);
	}

	public WebElement getBrowserTabLink() throws IOException {

		return DriverFactory.getDriver().findElement(browserTabLink);
	}

	public WebElement getButtonsLink() throws IOException {

		return DriverFactory.getDriver().findElement(buttonsLink);
	}

	public WebElement getCalcLink() throws IOException {

		return DriverFactory.getDriver().findElement(calcLink);
	}

	public WebElement getContactUsLink() throws IOException {

		return DriverFactory.getDriver().findElement(contactUsLink);
	}

	public WebElement getDatePickerLink() throws IOException {

		return DriverFactory.getDriver().findElement(datePickerLink);
	}

	public WebElement getDropdownLink() throws IOException {

		return DriverFactory.getDriver().findElement(dropdownLink);
	}

	public WebElement getFileUpload() throws IOException {

		return DriverFactory.getDriver().findElement(fileUpload);
	}

	public WebElement getHiddenElementsLink() throws IOException {

		return DriverFactory.getDriver().findElement(hiddenElementsLink);
	}

	public WebElement getIFrameLink() throws IOException {

		return DriverFactory.getDriver().findElement(iFrameLink);
	}

	public WebElement getLoaderLink() throws IOException {

		return DriverFactory.getDriver().findElement(loaderLink);
	}

	public WebElement getLoaderTwoLink() throws IOException {

		return DriverFactory.getDriver().findElement(loaderTwoLink);
	}

	public WebElement getLoginPortalLink() throws IOException {

		return DriverFactory.getDriver().findElement(loginPortalLink);
	}

	public WebElement getMouseLink() throws IOException {

		return DriverFactory.getDriver().findElement(mouseLink);
	}

	public WebElement getPopupLink() throws IOException {

		return DriverFactory.getDriver().findElement(popupLink);
	}

	public WebElement getPredictiveLink() throws IOException {

		return DriverFactory.getDriver().findElement(predictiveLink);
	}

	public WebElement getTablesLink() throws IOException {

		return DriverFactory.getDriver().findElement(tablesLink);
	}

	public WebElement getTestStoreLink() throws IOException {

		return DriverFactory.getDriver().findElement(testStoreLink);
	}

	public WebElement getAboutMeLink() throws IOException {

		return DriverFactory.getDriver().findElement(aboutMeLink);
	}

}
