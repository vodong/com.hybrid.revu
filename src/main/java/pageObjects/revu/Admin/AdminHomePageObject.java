package pageObjects.revu.Admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObjects.revu.Advertiser.AdvertiserDashBoardPageObject;
import pageObjects.revu.Manager.ManagerBrandManagementPageObject;
import pageObjects.revu.Partner.PartnerBrandManagementPageObject;
import pageUIs.revu.admin.AdminHomePageUI;
import pageUIs.revu.admin.BasePageUI;

public class AdminHomePageObject extends BasePage {
	private WebDriver driver;
	private long ShortTime = GlobalConstants.getGlobalConstants().getShortTimeoutWaiElement();

	public AdminHomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openLoginPopup() {
		waitForElementClickable(driver, AdminHomePageUI.LOGIN_LINK);
		clickToElement(driver, AdminHomePageUI.LOGIN_LINK);
	}

	public void openCountryList() {
		waitForElementClickable(driver, AdminHomePageUI.COUNTRY_LIST);
		clickToElement(driver, AdminHomePageUI.COUNTRY_LIST);
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

	public void hoverCountryName(String countryName) {
		waitForElementVisible(driver, AdminHomePageUI.COUNTRY_DROPDOWN_LIST, countryName);
		hoverMouseToElement(driver, AdminHomePageUI.COUNTRY_DROPDOWN_LIST, countryName);
	}
	
	public void selectLanguage(String languageValue) {
		waitForElementClickable(driver, AdminHomePageUI.COUNTRY_DROPDOWN_LIST, languageValue);
		clickToElement(driver, AdminHomePageUI.COUNTRY_DROPDOWN_LIST, languageValue);
		sleepInSecond(ShortTime);
	}

	public AdminDashBoardPageObject openAdminDashBoardPage(String textBoxName) {
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

	public void enterToEmailAdvertiserTextBox(String emailValue) {
		waitForElementVisible(driver, BasePageUI.EMAIL_TEXTBOX_ADVERTISER_TAB);
		sendkeyToElement(driver, BasePageUI.EMAIL_TEXTBOX_ADVERTISER_TAB, emailValue);
	}

	public void enterToPasswordAdvertiserTextBox(String passwordValue) {
		waitForElementVisible(driver, BasePageUI.PASSWORD_TEXTBOX_LOGIN_ADVERTISER_TAB);
		sendkeyToElement(driver, BasePageUI.PASSWORD_TEXTBOX_LOGIN_ADVERTISER_TAB, passwordValue);
	}

	public AdvertiserDashBoardPageObject openAdvertiserPage(String textBoxName) {
		waitForElementClickable(driver, AdminHomePageUI.LOGIN_BUTTON_ADVERTISER, textBoxName);
		clickToElement(driver, AdminHomePageUI.LOGIN_BUTTON_ADVERTISER, textBoxName);
		sleepInSecond(ShortTime);
		return PageGeneratorManager.getAdvertiserDashBoardPage(driver);
	}

	public ManagerBrandManagementPageObject openBrandManagementPage(String textValue) {
		waitForElementClickable(driver, AdminHomePageUI.LOGIN_BUTTON_PARTNER_MANAGER_ROLE, textValue);
		clickToElement(driver, AdminHomePageUI.LOGIN_BUTTON_PARTNER_MANAGER_ROLE, textValue);
		sleepInSecond(ShortTime);
		return PageGeneratorManager.getManagementPage(driver);
	}

	public PartnerBrandManagementPageObject openBrandManagementPartnerPage(String textValue) {
		waitForElementClickable(driver, AdminHomePageUI.LOGIN_BUTTON_PARTNER_MANAGER_ROLE, textValue);
		clickToElement(driver, AdminHomePageUI.LOGIN_BUTTON_PARTNER_MANAGER_ROLE, textValue);
		sleepInSecond(ShortTime);
		return PageGeneratorManager.getPartnerBrandMangementPage(driver);
	}

	public boolean isOpenLoginLinkDisplayed() {
		waitForElementVisible(driver, AdminHomePageUI.LOGIN_LINK);
		return isElementDisplayed(driver,  AdminHomePageUI.LOGIN_LINK);
	}
}
