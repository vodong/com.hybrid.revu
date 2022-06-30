package pageObjects.revu.Admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObjects.revu.Partner.PartnerBrandPageObject;
import pageUIs.revu.admin.AdminHomePageUI;
import pageUIs.revu.admin.BasePageUI;

public class AdminHomePageObject extends BasePage {
	private WebDriver driver;
	private long ShortTime = GlobalConstants.SHORT_TIME_OUT_WAIT_ELEMENT;

	public AdminHomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openLoginPopup() {
		waitForElementClickable(driver, AdminHomePageUI.LOGIN_LINK);
		clickToElement(driver, AdminHomePageUI.LOGIN_LINK);
	}

	public void openSelectCountryList() {
		waitForElementClickable(driver, AdminHomePageUI.COUNTRY_DROPDOWN_LIST);
		clickToElement(driver, AdminHomePageUI.COUNTRY_DROPDOWN_LIST);
	}

	public void enterToEmailTextbox(String emailaddress) {
		waitForElementClickable(driver, AdminHomePageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, AdminHomePageUI.EMAIL_TEXTBOX, emailaddress);
		sleepInSecond(ShortTime);
	}

	public void enterToPasswordTextbox(String password) {
		waitForElementClickable(driver, AdminHomePageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, AdminHomePageUI.PASSWORD_TEXTBOX, password);
		sleepInSecond(ShortTime);
	}

	public void selectCountry(String countryName) {
		waitForElementClickable(driver, AdminHomePageUI.COUNTRY_DROPDOWN_LIST_POPUP, countryName);
		clickToElement(driver, AdminHomePageUI.COUNTRY_DROPDOWN_LIST_POPUP, countryName);
		sleepInSecond(ShortTime);
	}

	public AdminDashBoardObject openAdminDashBoardPage(String textBoxName) {
		waitForElementClickable(driver, AdminHomePageUI.LOGIN_BUTTON_PARTNER_MANAGER_ROLE, textBoxName);
		clickToElement(driver, AdminHomePageUI.LOGIN_BUTTON_PARTNER_MANAGER_ROLE, textBoxName);
		sleepInSecond(ShortTime);
		return PageGeneratorManager.getDashboardPage(driver);
	}

	public boolean isLoginButtonDisplayed() {
		waitForElementVisible(driver, AdminHomePageUI.LOGIN_LINK);
		return isElementDisplayed(driver, AdminHomePageUI.LOGIN_LINK);
	}

	public void clickToAdvertiserTab(String textValue) {
		waitForElementClickable(driver, BasePageUI.PARTNER_ADVERTISER_TAB, textValue);
		clickToElement(driver, BasePageUI.PARTNER_ADVERTISER_TAB, textValue);
	}

	public PartnerBrandPageObject openAdvertiserPage(String textBoxName) {
		waitForElementClickable(driver, AdminHomePageUI.LOGIN_BUTTON_ADVERTISER, textBoxName);
		clickToElement(driver, AdminHomePageUI.LOGIN_BUTTON_ADVERTISER, textBoxName);
		sleepInSecond(ShortTime);
		return PageGeneratorManager.getPartnerBrandPage(driver);
	}

	public void enterToEmailAdvertiserTextBox(String emailValue) {
		waitForElementVisible(driver, BasePageUI.EMAIL_TEXTBOX_ADVERTISER_TAB);
		sendkeyToElement(driver, BasePageUI.EMAIL_TEXTBOX_ADVERTISER_TAB, emailValue);
	}

	public void enterToPasswordAdvertiserTextBox(String passwordValue) {
		waitForElementVisible(driver, BasePageUI.PASSWORD_TEXTBOX_LOGIN_ADVERTISER_TAB);
		sendkeyToElement(driver, BasePageUI.PASSWORD_TEXTBOX_LOGIN_ADVERTISER_TAB, passwordValue);
	}
}
