package pageObjects.revu.Manager;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.GlobalConstants;
import pageUIs.revu.admin.ManagerCreateBrandPageUI;

public class ManagerCreateBrandManagementPageObject extends BasePage {
	private WebDriver driver;
	private long shorttime = GlobalConstants.getGlobalConstants().getShortTimeoutWaiElement();

	public ManagerCreateBrandManagementPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getTitleComPanyInformation() {
		waitForElementVisible(driver, ManagerCreateBrandPageUI.TITLE_COMPANY_INFORMATION_NAME);
		return getElementText(driver, ManagerCreateBrandPageUI.TITLE_COMPANY_INFORMATION_NAME);
	}

	public String getTitleAccountInformation() {
		waitForElementVisible(driver, ManagerCreateBrandPageUI.TITLE_ACCOUNT_INFORMATION_NAME);
		return getElementText(driver, ManagerCreateBrandPageUI.TITLE_ACCOUNT_INFORMATION_NAME);
	}

	public boolean isPlaceHolderByLabelNameDisplayed(String labelName, String placeholderName) {
		waitForElementVisible(driver, ManagerCreateBrandPageUI.PLACE_HOLDER_BY_LABEL_NAME, labelName, placeholderName);
		return isElementDisplayed(driver, ManagerCreateBrandPageUI.PLACE_HOLDER_BY_LABEL_NAME, labelName, placeholderName);
	}

	public boolean isButtonNameDisplayed(String textValue) {
		waitForElementVisible(driver, ManagerCreateBrandPageUI.BUTTON_NAME, textValue);
		return isElementDisplayed(driver, ManagerCreateBrandPageUI.BUTTON_NAME, textValue);
	}

	public boolean isPlaceHolderByDropDownListNameDisplayed(String labelName, String placeholderName) {
		waitForElementVisible(driver, ManagerCreateBrandPageUI.PLACE_HOLDER_BY_DROPDOWN_LIST_NAME, labelName, placeholderName);
		return isElementDisplayed(driver, ManagerCreateBrandPageUI.PLACE_HOLDER_BY_DROPDOWN_LIST_NAME, labelName, placeholderName);
	}

	public void selectField(String textValue) {
		waitForElementVisible(driver, ManagerCreateBrandPageUI.FIELD_DROPDOWN_LIST);
		selectitemindropdownlist(driver, ManagerCreateBrandPageUI.FIELD_DROPDOWN_LIST, ManagerCreateBrandPageUI.FIELD_DROPDOWN_LIST_OPTION, textValue);
	}

	public boolean isAccountSettingDisplayed(String textValue) {
		waitForElementVisible(driver, ManagerCreateBrandPageUI.ACCOUNT_SETTING_LABEL, textValue);
		return isElementDisplayed(driver, ManagerCreateBrandPageUI.ACCOUNT_SETTING_LABEL, textValue);
	}

	public boolean isLabelByNameDisplayed(String textValue) {
		waitForElementVisible(driver, ManagerCreateBrandPageUI.DYNAMIC_LABEL_NAME, textValue);
		return isElementDisplayed(driver, ManagerCreateBrandPageUI.DYNAMIC_LABEL_NAME, textValue);
	}

	public void clickOnButtonByName(String textValue) {
		waitForElementClickable(driver, ManagerCreateBrandPageUI.BUTTON_NAME, textValue);
		clickToElement(driver, ManagerCreateBrandPageUI.BUTTON_NAME, textValue);
	}

	public String getTextResetPasswordButton() {
		waitForElementVisible(driver, ManagerCreateBrandPageUI.RESET_PASSWORD_BUTTON);
		return getElementText(driver, ManagerCreateBrandPageUI.RESET_PASSWORD_BUTTON);
	}

	public boolean isSaveButtonDisplayed(String textValue) {
		waitForElementVisible(driver, ManagerCreateBrandPageUI.SAVE_BUTTON_TEXT, textValue);
		return isElementDisplayed(driver, ManagerCreateBrandPageUI.SAVE_BUTTON_TEXT, textValue);
	}

	public boolean isSaveButtonDisabled(String textValue) {
		waitForElementVisible(driver, ManagerCreateBrandPageUI.SAVE_BUTTON_ATTRIBUTE, textValue);
		return isElementEnabled(driver, ManagerCreateBrandPageUI.SAVE_BUTTON_ATTRIBUTE, textValue);
	}

	public void enterToPasswordTextBox(String passwordValue) {
		waitForElementVisible(driver, ManagerCreateBrandPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, ManagerCreateBrandPageUI.PASSWORD_TEXTBOX, passwordValue);
	}

	public void enterToConfirmPasswordTextBox(String confirmPasswordValue) {
		waitForElementVisible(driver, ManagerCreateBrandPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, ManagerCreateBrandPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPasswordValue);
	}

	public void clickSaveButton(String textValue) {
		waitForElementClickable(driver, ManagerCreateBrandPageUI.SAVE_BUTTON_TEXT, textValue);
		clickToElement(driver, ManagerCreateBrandPageUI.SAVE_BUTTON_TEXT, textValue);
	}

	public String getErrorMessageAtBrandNameTextBox() {
		waitForElementVisible(driver, ManagerCreateBrandPageUI.ERROR_MESSAGE_AT_BRAND_NAME);
		return getElementText(driver, ManagerCreateBrandPageUI.ERROR_MESSAGE_AT_BRAND_NAME);
	}

	public String getErrorMessageAtFieldDropdownList() {
		waitForElementVisible(driver, ManagerCreateBrandPageUI.ERROR_MESSAGE_AT_FIELD_DROPDOWN_LIST);
		return getElementText(driver, ManagerCreateBrandPageUI.ERROR_MESSAGE_AT_FIELD_DROPDOWN_LIST);
	}

	public String getErrorMessageAtPartnerDropdownList() {
		waitForElementVisible(driver, ManagerCreateBrandPageUI.ERROR_MESSAGE_AT_PARTNER_DROPDOWN_LIST);
		return getElementText(driver, ManagerCreateBrandPageUI.ERROR_MESSAGE_AT_PARTNER_DROPDOWN_LIST);
	}

	public String getErrorMessageAtEmailTextBox() {
		waitForElementVisible(driver, ManagerCreateBrandPageUI.ERROR_MESSAGE_AT_EMAIl_TEXTBOX);
		return getElementText(driver, ManagerCreateBrandPageUI.ERROR_MESSAGE_AT_EMAIl_TEXTBOX);
	}

	public String getErrorMessageAtConfirmPasswordTextBox() {
		waitForElementVisible(driver, ManagerCreateBrandPageUI.ERROR_MESSAGE_AT_CONFIRM_PASSWORD_TEXTBOX);
		return getElementText(driver, ManagerCreateBrandPageUI.ERROR_MESSAGE_AT_CONFIRM_PASSWORD_TEXTBOX);
	}

	public void clickToPasswordSettingButton(String textValue) {
		waitForElementClickable(driver, ManagerCreateBrandPageUI.DYNAMIC_RESET_PASSWORD_BUTTON, textValue);
		clickToElement(driver, ManagerCreateBrandPageUI.DYNAMIC_RESET_PASSWORD_BUTTON, textValue);
	}

	public boolean isAvatarUpLoaded() {
		waitForElementVisible(driver, ManagerCreateBrandPageUI.AVATAR_UPLOADED);
		sleepInSecond(shorttime);
		return isImageLoaded(driver, ManagerCreateBrandPageUI.AVATAR_UPLOADED);
	}
	
	public void enterToBrandNameTextBox(String textValue) {
		waitForElementVisible(driver, ManagerCreateBrandPageUI.BRAND_NAME_TEXTBOX);
		sendkeyToElement(driver, ManagerCreateBrandPageUI.BRAND_NAME_TEXTBOX, textValue);
	}

	public void enterToPartNameTextBox(String textValue) {
		waitForElementVisible(driver, ManagerCreateBrandPageUI.PARTNER_TEXTBOX);
		sendkeyToElement(driver, ManagerCreateBrandPageUI.PARTNER_TEXTBOX, textValue);
		sleepInSecond(shorttime);
	}

	public void selectPartnerByName(String textValue) {
		waitForElementVisible(driver, ManagerCreateBrandPageUI.PARTNER_TEXTBOX);
		selectitemindropdownlist(driver, ManagerCreateBrandPageUI.PARTNER_TEXTBOX, ManagerCreateBrandPageUI.PARTNER_DROPDOWN_LIST, textValue);
		sleepInSecond(shorttime);
	}

	public void enterToEmailTextBox(String emailAddress) {
		waitForElementVisible(driver, ManagerCreateBrandPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, ManagerCreateBrandPageUI.EMAIL_TEXTBOX, emailAddress);
	}

	public void enterToRepresentativeTextBox(String textValue) {
		waitForElementVisible(driver, ManagerCreateBrandPageUI.REPRESENTATIVE_TEXTBOX);
		sendkeyToElement(driver, ManagerCreateBrandPageUI.REPRESENTATIVE_TEXTBOX, textValue);
	}
}
