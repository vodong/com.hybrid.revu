package pageObjects.revu.Partner;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.GlobalConstants;
import pageUIs.revu.Partner.PartnerCreateBrandManagementPageUI;
import pageUIs.revu.admin.AdminCreateBrandPageUI;

public class PartnerCreateBrandManagementPageObject extends BasePage{
	private WebDriver driver;
	private long shorttime = GlobalConstants.getGlobalConstants().getShortTimeoutWaiElement();

	public PartnerCreateBrandManagementPageObject (WebDriver driver) {
		this.driver = driver;
	}

	public String getTitleComPanyInformation() {
		waitForElementVisible(driver, PartnerCreateBrandManagementPageUI.TITLE_COMPANY_INFORMATION_NAME);
		return getElementText(driver, PartnerCreateBrandManagementPageUI.TITLE_COMPANY_INFORMATION_NAME);
	}

	public String getTitleAccountInformation() {
		waitForElementVisible(driver, PartnerCreateBrandManagementPageUI.TITLE_ACCOUNT_INFORMATION_NAME);
		return getElementText(driver, PartnerCreateBrandManagementPageUI.TITLE_ACCOUNT_INFORMATION_NAME);
	}

	public boolean isLabelByNameDisplayed(String textValue) {
		waitForElementVisible(driver, PartnerCreateBrandManagementPageUI.DYNAMIC_LABEL_NAME, textValue);
		return isElementDisplayed(driver, PartnerCreateBrandManagementPageUI.DYNAMIC_LABEL_NAME, textValue);
	}

	public boolean isPlaceHolderByLabelNameDisplayed(String labelName, String placeholderName) {
		waitForElementVisible(driver, PartnerCreateBrandManagementPageUI.PLACE_HOLDER_BY_LABEL_NAME, labelName, placeholderName);
		return isElementDisplayed(driver, PartnerCreateBrandManagementPageUI.PLACE_HOLDER_BY_LABEL_NAME, labelName, placeholderName);
	}

	public boolean isAccountSettingDisplayed(String textValue) {
		waitForElementVisible(driver, PartnerCreateBrandManagementPageUI.ACCOUNT_SETTING_LABEL, textValue);
		return isElementDisplayed(driver, PartnerCreateBrandManagementPageUI.ACCOUNT_SETTING_LABEL, textValue);
	}

	public boolean isButtonNameDisplayed(String textValue) {
		waitForElementVisible(driver, PartnerCreateBrandManagementPageUI.BUTTON_NAME, textValue);
		return isElementDisplayed(driver, PartnerCreateBrandManagementPageUI.BUTTON_NAME, textValue);
	}

	public boolean isPlaceHolderByDropDownListNameDisplayed(String labelName, String placeholderName) {
		waitForElementVisible(driver, PartnerCreateBrandManagementPageUI.PLACE_HOLDER_BY_DROPDOWN_LIST_NAME, labelName, placeholderName);
		return isElementDisplayed(driver, PartnerCreateBrandManagementPageUI.PLACE_HOLDER_BY_DROPDOWN_LIST_NAME, labelName, placeholderName);
	}

	public boolean isSaveButtonDisplayed(String textValue) {
		waitForElementVisible(driver, PartnerCreateBrandManagementPageUI.SAVE_BUTTON_TEXT, textValue);
		return isElementDisplayed(driver, PartnerCreateBrandManagementPageUI.SAVE_BUTTON_TEXT, textValue);
	}

	public boolean isSaveButtonDisabled(String textValue) {
		waitForElementVisible(driver, PartnerCreateBrandManagementPageUI.SAVE_BUTTON_ATTRIBUTE, textValue);
		return isElementEnabled(driver, PartnerCreateBrandManagementPageUI.SAVE_BUTTON_ATTRIBUTE, textValue);
	}

	public String getTextResetPasswordButton() {
		waitForElementVisible(driver, PartnerCreateBrandManagementPageUI.RESET_PASSWORD_BUTTON);
		return getElementText(driver, PartnerCreateBrandManagementPageUI.RESET_PASSWORD_BUTTON);
	}

	public void clickOnButtonByName(String textValue) {
		waitForElementClickable(driver, PartnerCreateBrandManagementPageUI.BUTTON_NAME, textValue);
		clickToElement(driver, PartnerCreateBrandManagementPageUI.BUTTON_NAME, textValue);
	}

	public void selectField(String textValue) {
		waitForElementVisible(driver, PartnerCreateBrandManagementPageUI.FIELD_DROPDOWN_LIST);
		selectitemindropdownlist(driver, PartnerCreateBrandManagementPageUI.FIELD_DROPDOWN_LIST, AdminCreateBrandPageUI.FIELD_DROPDOWN_LIST_OPTION, textValue);
	}

	public void clickToPasswordSettingButton(String textValue) {
		waitForElementClickable(driver, PartnerCreateBrandManagementPageUI.DYNAMIC_RESET_PASSWORD_BUTTON, textValue);
		clickToElement(driver, PartnerCreateBrandManagementPageUI.DYNAMIC_RESET_PASSWORD_BUTTON, textValue);
	}

	public void enterToPasswordTextBox(String passwordValue) {
		waitForElementVisible(driver, PartnerCreateBrandManagementPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, PartnerCreateBrandManagementPageUI.PASSWORD_TEXTBOX, passwordValue);
	}

	public void enterToConfirmPasswordTextBox(String confirmPasswordValue) {
		waitForElementVisible(driver, PartnerCreateBrandManagementPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, PartnerCreateBrandManagementPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPasswordValue);
	}

	public void clickSaveButton(String textValue) {
		waitForElementClickable(driver, PartnerCreateBrandManagementPageUI.SAVE_BUTTON_TEXT, textValue);
		clickToElement(driver, PartnerCreateBrandManagementPageUI.SAVE_BUTTON_TEXT, textValue);
	}

	public String getErrorMessageAtBrandNameTextBox() {
		waitForElementVisible(driver, PartnerCreateBrandManagementPageUI.ERROR_MESSAGE_AT_BRAND_NAME);
		return getElementText(driver, PartnerCreateBrandManagementPageUI.ERROR_MESSAGE_AT_BRAND_NAME);
	}

	public String getErrorMessageAtFieldDropdownList() {
		waitForElementVisible(driver, PartnerCreateBrandManagementPageUI.ERROR_MESSAGE_AT_FIELD_DROPDOWN_LIST);
		return getElementText(driver, PartnerCreateBrandManagementPageUI.ERROR_MESSAGE_AT_FIELD_DROPDOWN_LIST);
	}

	public String getErrorMessageAtPartnerDropdownList() {
		waitForElementVisible(driver, PartnerCreateBrandManagementPageUI.ERROR_MESSAGE_AT_PARTNER_DROPDOWN_LIST);
		return getElementText(driver, PartnerCreateBrandManagementPageUI.ERROR_MESSAGE_AT_PARTNER_DROPDOWN_LIST);
	}

	public String getErrorMessageAtEmailTextBox() {
		waitForElementVisible(driver, PartnerCreateBrandManagementPageUI.ERROR_MESSAGE_AT_EMAIl_TEXTBOX);
		return getElementText(driver, PartnerCreateBrandManagementPageUI.ERROR_MESSAGE_AT_EMAIl_TEXTBOX);
	}

	public String getErrorMessageAtConfirmPasswordTextBox() {
		waitForElementVisible(driver, PartnerCreateBrandManagementPageUI.ERROR_MESSAGE_AT_CONFIRM_PASSWORD_TEXTBOX);
		return getElementText(driver, PartnerCreateBrandManagementPageUI.ERROR_MESSAGE_AT_CONFIRM_PASSWORD_TEXTBOX);
	}

	public boolean isAvatarUpLoaded() {
		waitForElementVisible(driver, PartnerCreateBrandManagementPageUI.AVATAR_UPLOADED);
		sleepInSecond(shorttime);
		return isImageLoaded(driver, PartnerCreateBrandManagementPageUI.AVATAR_UPLOADED);
	}

	public void enterToBrandNameTextBox(String textValue) {
		waitForElementVisible(driver, PartnerCreateBrandManagementPageUI.BRAND_NAME_TEXTBOX);
		sendkeyToElement(driver, PartnerCreateBrandManagementPageUI.BRAND_NAME_TEXTBOX, textValue);
	}

	public void enterToPartNameTextBox(String textValue) {
		waitForElementVisible(driver, PartnerCreateBrandManagementPageUI.PARTNER_TEXTBOX);
		sendkeyToElement(driver, PartnerCreateBrandManagementPageUI.PARTNER_TEXTBOX, textValue);
		sleepInSecond(shorttime);
	}

	public void selectPartnerByName(String textValue) {
		waitForElementVisible(driver, PartnerCreateBrandManagementPageUI.PARTNER_TEXTBOX);
		selectitemindropdownlist(driver, PartnerCreateBrandManagementPageUI.PARTNER_TEXTBOX, AdminCreateBrandPageUI.PARTNER_DROPDOWN_LIST, textValue);
		sleepInSecond(shorttime);
	}

	public void enterToEmailTextBox(String emailAddress) {
		waitForElementVisible(driver, PartnerCreateBrandManagementPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, PartnerCreateBrandManagementPageUI.EMAIL_TEXTBOX, emailAddress);
	}

	public void enterToRepresentativeTextBox(String textValue) {
		waitForElementVisible(driver, PartnerCreateBrandManagementPageUI.REPRESENTATIVE_TEXTBOX);
		sendkeyToElement(driver, PartnerCreateBrandManagementPageUI.REPRESENTATIVE_TEXTBOX, textValue);
	}

}
