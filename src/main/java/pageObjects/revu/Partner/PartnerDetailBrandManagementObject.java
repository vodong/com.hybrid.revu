package pageObjects.revu.Partner;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.revu.Partner.PartnerDetailBrandPageUI;
import pageUIs.revu.admin.BasePageUI;

public class PartnerDetailBrandManagementObject extends BasePage {
	private WebDriver driver;

	public PartnerDetailBrandManagementObject (WebDriver driver) {
		this.driver = driver;
	}

	public String getSeeBrandTextButton() {
		waitForElementVisible(driver, PartnerDetailBrandPageUI.SEE_BRAND_PAGE_BUTTON);
		return getElementText(driver, PartnerDetailBrandPageUI.SEE_BRAND_PAGE_BUTTON);
	}

	public void clickToSeeBrandPageButton() {
		waitForElementClickable(driver, PartnerDetailBrandPageUI.SEE_BRAND_PAGE_BUTTON);
		clickToElement(driver, PartnerDetailBrandPageUI.SEE_BRAND_PAGE_BUTTON);
	}

	public void switchTab(String urlValue) {
		switchtowindowbylink(driver, urlValue);
	}

	public void clickOnButtonByName(String textValue) {
		waitForElementClickable(driver, BasePageUI.BUTTON_NAME, textValue);
		clickToElement(driver, BasePageUI.BUTTON_NAME, textValue);
	}

	public void enterToEmailTextBox(String emailaddress) {
		waitForElementVisible(driver, BasePageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, BasePageUI.EMAIL_TEXTBOX, emailaddress);
	}

	public void clickToPasswordSettingButton(String textValue) {
		waitForElementClickable(driver, BasePageUI.DYNAMIC_RESET_PASSWORD_BUTTON, textValue);
		clickToElement(driver, BasePageUI.DYNAMIC_RESET_PASSWORD_BUTTON, textValue);
	}

	public void enterToPasswordTextBox(String passwordValue) {
		waitForElementVisible(driver, BasePageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, BasePageUI.PASSWORD_TEXTBOX, passwordValue);
	}

	public void enterToConfirmPasswordTextBox(String confirmPasswordValue) {
		waitForElementVisible(driver, BasePageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, BasePageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPasswordValue);
	}

	public void clickSaveButton(String textValue) {
		waitForElementClickable(driver, BasePageUI.SAVE_BUTTON_TEXT, textValue);
		clickToElement(driver, BasePageUI.SAVE_BUTTON_TEXT, textValue);
	}

	public String getErrorMessageAtEmailTextBox() {
		waitForElementVisible(driver, PartnerDetailBrandPageUI.ERROR_MESSAGE_AT_EMAIl_TEXTBOX);
		return getElementText(driver, PartnerDetailBrandPageUI.ERROR_MESSAGE_AT_EMAIl_TEXTBOX);
	}

	public void clickOnLogOutButton() {
		waitForElementClickable(driver, BasePageUI.LOGOUT_LINK_HEADER);
		clickToElement(driver, BasePageUI.LOGOUT_LINK_HEADER);
	}
}
