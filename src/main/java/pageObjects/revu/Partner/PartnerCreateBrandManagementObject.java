package pageObjects.revu.Partner;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.GlobalConstants_KR;
import pageUIs.revu.Partner.PartnerCreateBrandManagementUI;
import pageUIs.revu.admin.AdminCreateBrandPageUI;

public class PartnerCreateBrandManagementObject extends BasePage{
	private WebDriver driver;
	private long shorttime = GlobalConstants_KR.SHORT_TIME_OUT_WAIT_ELEMENT;

	public PartnerCreateBrandManagementObject (WebDriver driver) {
		this.driver = driver;
	}

	public String getTitleComPanyInformation() {
		waitForElementVisible(driver, PartnerCreateBrandManagementUI.TITLE_COMPANY_INFORMATION_NAME);
		return getElementText(driver, PartnerCreateBrandManagementUI.TITLE_COMPANY_INFORMATION_NAME);
	}

	public String getTitleAccountInformation() {
		waitForElementVisible(driver, PartnerCreateBrandManagementUI.TITLE_ACCOUNT_INFORMATION_NAME);
		return getElementText(driver, PartnerCreateBrandManagementUI.TITLE_ACCOUNT_INFORMATION_NAME);
	}

	public boolean isLabelByNameDisplayed(String textValue) {
		waitForElementVisible(driver, PartnerCreateBrandManagementUI.DYNAMIC_LABEL_NAME, textValue);
		return isElementDisplayed(driver, PartnerCreateBrandManagementUI.DYNAMIC_LABEL_NAME, textValue);
	}

	public boolean isPlaceHolderByLabelNameDisplayed(String labelName, String placeholderName) {
		waitForElementVisible(driver, PartnerCreateBrandManagementUI.PLACE_HOLDER_BY_LABEL_NAME, labelName, placeholderName);
		return isElementDisplayed(driver, PartnerCreateBrandManagementUI.PLACE_HOLDER_BY_LABEL_NAME, labelName, placeholderName);
	}

	public boolean isAccountSettingDisplayed(String textValue) {
		waitForElementVisible(driver, PartnerCreateBrandManagementUI.ACCOUNT_SETTING_LABEL, textValue);
		return isElementDisplayed(driver, PartnerCreateBrandManagementUI.ACCOUNT_SETTING_LABEL, textValue);
	}

	public boolean isButtonNameDisplayed(String textValue) {
		waitForElementVisible(driver, PartnerCreateBrandManagementUI.BUTTON_NAME, textValue);
		return isElementDisplayed(driver, PartnerCreateBrandManagementUI.BUTTON_NAME, textValue);
	}

	public boolean isPlaceHolderByDropDownListNameDisplayed(String labelName, String placeholderName) {
		waitForElementVisible(driver, PartnerCreateBrandManagementUI.PLACE_HOLDER_BY_DROPDOWN_LIST_NAME, labelName, placeholderName);
		return isElementDisplayed(driver, PartnerCreateBrandManagementUI.PLACE_HOLDER_BY_DROPDOWN_LIST_NAME, labelName, placeholderName);
	}

	public boolean isSaveButtonDisplayed(String textValue) {
		waitForElementVisible(driver, PartnerCreateBrandManagementUI.SAVE_BUTTON_TEXT, textValue);
		return isElementDisplayed(driver, PartnerCreateBrandManagementUI.SAVE_BUTTON_TEXT, textValue);
	}

	public boolean isSaveButtonDisabled(String textValue) {
		waitForElementVisible(driver, PartnerCreateBrandManagementUI.SAVE_BUTTON_ATTRIBUTE, textValue);
		return isElementEnabled(driver, PartnerCreateBrandManagementUI.SAVE_BUTTON_ATTRIBUTE, textValue);
	}

	public String getTextResetPasswordButton() {
		waitForElementVisible(driver, PartnerCreateBrandManagementUI.RESET_PASSWORD_BUTTON);
		return getElementText(driver, PartnerCreateBrandManagementUI.RESET_PASSWORD_BUTTON);
	}

	public void clickOnButtonByName(String textValue) {
		waitForElementClickable(driver, PartnerCreateBrandManagementUI.BUTTON_NAME, textValue);
		clickToElement(driver, PartnerCreateBrandManagementUI.BUTTON_NAME, textValue);
	}

	public void selectField(String textValue) {
		waitForElementVisible(driver, PartnerCreateBrandManagementUI.FIELD_DROPDOWN_LIST);
		selectitemindropdownlist(driver, PartnerCreateBrandManagementUI.FIELD_DROPDOWN_LIST, AdminCreateBrandPageUI.FIELD_DROPDOWN_LIST_OPTION, textValue);
	}

	public void clickToPasswordSettingButton(String textValue) {
		waitForElementClickable(driver, PartnerCreateBrandManagementUI.DYNAMIC_RESET_PASSWORD_BUTTON, textValue);
		clickToElement(driver, PartnerCreateBrandManagementUI.DYNAMIC_RESET_PASSWORD_BUTTON, textValue);
	}

	public void enterToPasswordTextBox(String passwordValue) {
		waitForElementVisible(driver, PartnerCreateBrandManagementUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, PartnerCreateBrandManagementUI.PASSWORD_TEXTBOX, passwordValue);
	}

	public void enterToConfirmPasswordTextBox(String confirmPasswordValue) {
		waitForElementVisible(driver, PartnerCreateBrandManagementUI.CONFIRM_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, PartnerCreateBrandManagementUI.CONFIRM_PASSWORD_TEXTBOX, confirmPasswordValue);
	}

	public void clickSaveButton(String textValue) {
		waitForElementClickable(driver, PartnerCreateBrandManagementUI.SAVE_BUTTON_TEXT, textValue);
		clickToElement(driver, PartnerCreateBrandManagementUI.SAVE_BUTTON_TEXT, textValue);
	}

	public String getErrorMessageAtBrandNameTextBox() {
		waitForElementVisible(driver, PartnerCreateBrandManagementUI.ERROR_MESSAGE_AT_BRAND_NAME);
		return getElementText(driver, PartnerCreateBrandManagementUI.ERROR_MESSAGE_AT_BRAND_NAME);
	}

	public String getErrorMessageAtFieldDropdownList() {
		waitForElementVisible(driver, PartnerCreateBrandManagementUI.ERROR_MESSAGE_AT_FIELD_DROPDOWN_LIST);
		return getElementText(driver, PartnerCreateBrandManagementUI.ERROR_MESSAGE_AT_FIELD_DROPDOWN_LIST);
	}

	public String getErrorMessageAtPartnerDropdownList() {
		waitForElementVisible(driver, PartnerCreateBrandManagementUI.ERROR_MESSAGE_AT_PARTNER_DROPDOWN_LIST);
		return getElementText(driver, PartnerCreateBrandManagementUI.ERROR_MESSAGE_AT_PARTNER_DROPDOWN_LIST);
	}

	public String getErrorMessageAtEmailTextBox() {
		waitForElementVisible(driver, PartnerCreateBrandManagementUI.ERROR_MESSAGE_AT_EMAIl_TEXTBOX);
		return getElementText(driver, PartnerCreateBrandManagementUI.ERROR_MESSAGE_AT_EMAIl_TEXTBOX);
	}

	public String getErrorMessageAtConfirmPasswordTextBox() {
		waitForElementVisible(driver, PartnerCreateBrandManagementUI.ERROR_MESSAGE_AT_CONFIRM_PASSWORD_TEXTBOX);
		return getElementText(driver, PartnerCreateBrandManagementUI.ERROR_MESSAGE_AT_CONFIRM_PASSWORD_TEXTBOX);
	}

	public boolean isAvatarUpLoaded() {
		waitForElementVisible(driver, PartnerCreateBrandManagementUI.AVATAR_UPLOADED);
		sleepInSecond(shorttime);
		return isImageLoaded(driver, PartnerCreateBrandManagementUI.AVATAR_UPLOADED);
	}

	public void enterToBrandNameTextBox(String textValue) {
		waitForElementVisible(driver, PartnerCreateBrandManagementUI.BRAND_NAME_TEXTBOX);
		sendkeyToElement(driver, PartnerCreateBrandManagementUI.BRAND_NAME_TEXTBOX, textValue);
	}

	public void enterToPartNameTextBox(String textValue) {
		waitForElementVisible(driver, PartnerCreateBrandManagementUI.PARTNER_TEXTBOX);
		sendkeyToElement(driver, PartnerCreateBrandManagementUI.PARTNER_TEXTBOX, textValue);
		sleepInSecond(shorttime);
	}

	public void selectPartnerByName(String textValue) {
		waitForElementVisible(driver, PartnerCreateBrandManagementUI.PARTNER_TEXTBOX);
		selectitemindropdownlist(driver, PartnerCreateBrandManagementUI.PARTNER_TEXTBOX, AdminCreateBrandPageUI.PARTNER_DROPDOWN_LIST, textValue);
		sleepInSecond(shorttime);
	}

	public void enterToEmailTextBox(String emailAddress) {
		waitForElementVisible(driver, PartnerCreateBrandManagementUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, PartnerCreateBrandManagementUI.EMAIL_TEXTBOX, emailAddress);
	}

	public void enterToRepresentativeTextBox(String textValue) {
		waitForElementVisible(driver, PartnerCreateBrandManagementUI.REPRESENTATIVE_TEXTBOX);
		sendkeyToElement(driver, PartnerCreateBrandManagementUI.REPRESENTATIVE_TEXTBOX, textValue);
	}

}
