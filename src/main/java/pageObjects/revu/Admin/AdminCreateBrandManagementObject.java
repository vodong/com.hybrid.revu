package pageObjects.revu.Admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.GlobalConstants;
import pageUIs.revu.admin.AdminAdvertiserPageUI;
import pageUIs.revu.admin.AdminCreateBrandPageUI;

public class AdminCreateBrandManagementObject extends BasePage {
	private WebDriver driver;
	private long shorttime = GlobalConstants.SHORT_TIME_OUT_WAIT_ELEMENT;

	public AdminCreateBrandManagementObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getTitleComPanyInformation() {
		waitForElementVisible(driver, AdminCreateBrandPageUI.TITLE_COMPANY_INFORMATION_NAME);
		return getElementText(driver, AdminCreateBrandPageUI.TITLE_COMPANY_INFORMATION_NAME);
	}

	public String getTitleAccountInformation() {
		waitForElementVisible(driver, AdminCreateBrandPageUI.TITLE_ACCOUNT_INFORMATION_NAME);
		return getElementText(driver, AdminCreateBrandPageUI.TITLE_ACCOUNT_INFORMATION_NAME);
	}

	public boolean isPlaceHolderByLabelNameDisplayed(String labelName, String placeholderName) {
		waitForElementVisible(driver, AdminCreateBrandPageUI.PLACE_HOLDER_BY_LABEL_NAME, labelName, placeholderName);
		return isElementDisplayed(driver, AdminCreateBrandPageUI.PLACE_HOLDER_BY_LABEL_NAME, labelName, placeholderName);
	}

	public boolean isButtonNameDisplayed(String textValue) {
		waitForElementVisible(driver, AdminCreateBrandPageUI.BUTTON_NAME, textValue);
		return isElementDisplayed(driver, AdminCreateBrandPageUI.BUTTON_NAME, textValue);
	}

	public boolean isPlaceHolderByDropDownListNameDisplayed(String labelName, String placeholderName) {
		waitForElementVisible(driver, AdminCreateBrandPageUI.PLACE_HOLDER_BY_DROPDOWN_LIST_NAME, labelName, placeholderName);
		return isElementDisplayed(driver, AdminCreateBrandPageUI.PLACE_HOLDER_BY_DROPDOWN_LIST_NAME, labelName, placeholderName);
	}

	public void selectField(String textValue) {
		waitForElementVisible(driver, AdminCreateBrandPageUI.FIELD_DROPDOWN_LIST);
		selectitemindropdownlist(driver, AdminCreateBrandPageUI.FIELD_DROPDOWN_LIST, AdminCreateBrandPageUI.FIELD_DROPDOWN_LIST_OPTION, textValue);
	}

	public boolean isAccountSettingDisplayed(String textValue) {
		waitForElementVisible(driver, AdminCreateBrandPageUI.ACCOUNT_SETTING_LABEL, textValue);
		return isElementDisplayed(driver, AdminCreateBrandPageUI.ACCOUNT_SETTING_LABEL, textValue);
	}

	public boolean isLabelByNameDisplayed(String textValue) {
		waitForElementVisible(driver, AdminCreateBrandPageUI.DYNAMIC_LABEL_NAME, textValue);
		return isElementDisplayed(driver, AdminCreateBrandPageUI.DYNAMIC_LABEL_NAME, textValue);
	}

	public void clickOnButtonByName(String textValue) {
		waitForElementClickable(driver, AdminCreateBrandPageUI.BUTTON_NAME, textValue);
		clickToElement(driver, AdminCreateBrandPageUI.BUTTON_NAME, textValue);
	}

	public String getTextResetPasswordButton() {
		waitForElementVisible(driver, AdminCreateBrandPageUI.RESET_PASSWORD_BUTTON);
		return getElementText(driver, AdminCreateBrandPageUI.RESET_PASSWORD_BUTTON);
	}

	public boolean isSaveButtonDisplayed(String textValue) {
		waitForElementVisible(driver, AdminCreateBrandPageUI.SAVE_BUTTON_TEXT, textValue);
		return isElementDisplayed(driver, AdminCreateBrandPageUI.SAVE_BUTTON_TEXT, textValue);
	}

	public boolean isSaveButtonDisabled(String textValue) {
		waitForElementVisible(driver, AdminCreateBrandPageUI.SAVE_BUTTON_ATTRIBUTE, textValue);
		return isElementEnabled(driver, AdminCreateBrandPageUI.SAVE_BUTTON_ATTRIBUTE, textValue);
	}

	public void enterToPasswordTextBox(String passwordValue) {
		waitForElementVisible(driver, AdminCreateBrandPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, AdminCreateBrandPageUI.PASSWORD_TEXTBOX, passwordValue);
	}

	public void enterToConfirmPasswordTextBox(String confirmPasswordValue) {
		waitForElementVisible(driver, AdminCreateBrandPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, AdminCreateBrandPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPasswordValue);
	}

	public void clickSaveButton(String textValue) {
		waitForElementClickable(driver, AdminCreateBrandPageUI.SAVE_BUTTON_TEXT, textValue);
		clickToElement(driver, AdminCreateBrandPageUI.SAVE_BUTTON_TEXT, textValue);
	}

	public String getErrorMessageAtBrandNameTextBox() {
		waitForElementVisible(driver, AdminCreateBrandPageUI.ERROR_MESSAGE_AT_BRAND_NAME);
		return getElementText(driver, AdminCreateBrandPageUI.ERROR_MESSAGE_AT_BRAND_NAME);
	}

	public String getErrorMessageAtFieldDropdownList() {
		waitForElementVisible(driver, AdminCreateBrandPageUI.ERROR_MESSAGE_AT_FIELD_DROPDOWN_LIST);
		return getElementText(driver, AdminCreateBrandPageUI.ERROR_MESSAGE_AT_FIELD_DROPDOWN_LIST);
	}

	public String getErrorMessageAtPartnerDropdownList() {
		waitForElementVisible(driver, AdminCreateBrandPageUI.ERROR_MESSAGE_AT_PARTNER_DROPDOWN_LIST);
		return getElementText(driver, AdminCreateBrandPageUI.ERROR_MESSAGE_AT_PARTNER_DROPDOWN_LIST);
	}

	public String getErrorMessageAtEmailTextBox() {
		waitForElementVisible(driver, AdminCreateBrandPageUI.ERROR_MESSAGE_AT_EMAIl_TEXTBOX);
		return getElementText(driver, AdminCreateBrandPageUI.ERROR_MESSAGE_AT_EMAIl_TEXTBOX);
	}

	public String getErrorMessageAtConfirmPasswordTextBox() {
		waitForElementVisible(driver, AdminCreateBrandPageUI.ERROR_MESSAGE_AT_CONFIRM_PASSWORD_TEXTBOX);
		return getElementText(driver, AdminCreateBrandPageUI.ERROR_MESSAGE_AT_CONFIRM_PASSWORD_TEXTBOX);
	}

	public void clickToPasswordSettingButton(String textValue) {
		waitForElementClickable(driver, AdminCreateBrandPageUI.DYNAMIC_RESET_PASSWORD_BUTTON, textValue);
		clickToElement(driver, AdminCreateBrandPageUI.DYNAMIC_RESET_PASSWORD_BUTTON, textValue);
	}

	public boolean isAvatarUpLoaded() {
		waitForElementVisible(driver, AdminCreateBrandPageUI.AVATAR_UPLOADED);
		sleepInSecond(shorttime);
		return isImageLoaded(driver, AdminCreateBrandPageUI.AVATAR_UPLOADED);
	}
	
	public void enterToBrandNameTextBox(String textValue) {
		waitForElementVisible(driver, AdminCreateBrandPageUI.BRAND_NAME_TEXTBOX);
		sendkeyToElement(driver, AdminCreateBrandPageUI.BRAND_NAME_TEXTBOX, textValue);
	}

	public void enterToPartNameTextBox(String textValue) {
		waitForElementVisible(driver, AdminCreateBrandPageUI.PARTNER_TEXTBOX);
		sendkeyToElement(driver, AdminCreateBrandPageUI.PARTNER_TEXTBOX, textValue);
		sleepInSecond(shorttime);
	}

	public void selectPartnerByName(String textValue) {
		waitForElementVisible(driver, AdminCreateBrandPageUI.PARTNER_TEXTBOX);
		selectitemindropdownlist(driver, AdminCreateBrandPageUI.PARTNER_TEXTBOX, AdminCreateBrandPageUI.PARTNER_DROPDOWN_LIST, textValue);
		sleepInSecond(shorttime);
	}

	public void enterToEmailTextBox(String emailAddress) {
		waitForElementVisible(driver, AdminCreateBrandPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, AdminCreateBrandPageUI.EMAIL_TEXTBOX, emailAddress);
	}
}
