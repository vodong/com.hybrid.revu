package pageObjects.revu.Admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageUIs.revu.admin.AdminHomePageUI;

public class AdminHomePageObject extends BasePage {
	private WebDriver driver;
	private long ShortTime = GlobalConstants.SHORT_TIME_OUT_WAIT_ELEMENT;

	public AdminHomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openLoginPopup() {
		waitForElementClickable(driver, AdminHomePageUI.LOGIN_LINK_HEADER);
		clickToElement(driver, AdminHomePageUI.LOGIN_LINK_HEADER);
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
		waitForElementClickable(driver, AdminHomePageUI.LOGIN_BUTTON, textBoxName);
		clickToElement(driver, AdminHomePageUI.LOGIN_BUTTON, textBoxName);
		sleepInSecond(ShortTime);
		return PageGeneratorManager.getDashboardPage(driver);
	}
}
