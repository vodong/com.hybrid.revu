package pageObjects.revu.Partner;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.GlobalConstants_KR;
import pageUIs.revu.Partner.PartnerAdvertiserPageUI;
import pageUIs.revu.admin.AdminAdvertiserPageUI;

public class PartnerBrandManagementObject extends BasePage {
	private WebDriver driver;
	long shortTimeOut = GlobalConstants_KR.SHORT_TIME_OUT;

	public PartnerBrandManagementObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isPlaceHolderDisplayed(String labelName, String placeHolderName) {
		waitForElementVisible(driver, PartnerAdvertiserPageUI.SEARCH_FILTER_AREA, labelName, placeHolderName);
		return isElementDisplayed(driver, PartnerAdvertiserPageUI.SEARCH_FILTER_AREA, labelName, placeHolderName);
	}

	public boolean isPlaceHolderFieldDropDownListDisplayed(String labelName, String placeHolderName) {
		waitForElementVisible(driver, PartnerAdvertiserPageUI.SEARCH_FILTER_AREA_FIELD_DROPDOWN_LIST, placeHolderName,
				labelName);
		return isElementDisplayed(driver, PartnerAdvertiserPageUI.SEARCH_FILTER_AREA_FIELD_DROPDOWN_LIST,
				placeHolderName, labelName);
	}

	public boolean isButtonDisplayed(String textValue) {
		waitForElementVisible(driver, PartnerAdvertiserPageUI.DYNAMIC_TEXT_BUTTON, textValue);
		return isElementDisplayed(driver, PartnerAdvertiserPageUI.DYNAMIC_TEXT_BUTTON, textValue);
	}

	public boolean isColumnNameDisplayed(String columnName) {
		waitForElementVisible(driver, PartnerAdvertiserPageUI.COLUMN_NAME, columnName);
		return isElementDisplayed(driver, PartnerAdvertiserPageUI.COLUMN_NAME, columnName);
	}

	public boolean isTextAtRowDisplayed(String columnName, String rowNumber, String textValue) {
		int totalNumberIndex = getElementSize(driver, PartnerAdvertiserPageUI.COLUMN_INDEX_BY_NAME, columnName, textValue)
				+ 1;
		waitForElementVisible(driver, PartnerAdvertiserPageUI.TEXT_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, textValue,
				String.valueOf(totalNumberIndex));
		return isElementDisplayed(driver, PartnerAdvertiserPageUI.TEXT_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber,
				textValue, String.valueOf(totalNumberIndex));
	}

	public void openCreateANewBrand(String textValue) {
		waitForElementClickable(driver, PartnerAdvertiserPageUI.CREATE_NEW_BRAND_BUTTON, textValue);
		clickToElement(driver, PartnerAdvertiserPageUI.CREATE_NEW_BRAND_BUTTON, textValue);
		sleepInSecond(shortTimeOut);
	}

	public boolean isTextCreatedBrandAtRowDisplayed(String columnName, String rowNumber, String textValue) {
		int totalNumberIndex = getElementSize(driver, PartnerAdvertiserPageUI.COLUMN_INDEX_BY_NAME, columnName, textValue) +1;
		waitForElementVisible(driver, PartnerAdvertiserPageUI.TEXT_BRAND_CREATED_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, textValue, String.valueOf(totalNumberIndex));
		return isElementDisplayed(driver, PartnerAdvertiserPageUI.TEXT_BRAND_CREATED_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, textValue, String.valueOf(totalNumberIndex));
	}

	public void enterToSearchBrandTextBox(String textValue) {
		waitForElementClickable(driver, PartnerAdvertiserPageUI.SEARCH_TEXTBOX);
		sendkeyToElement(driver, PartnerAdvertiserPageUI.SEARCH_TEXTBOX, textValue);
		pressKeyToElement(driver, PartnerAdvertiserPageUI.SEARCH_TEXTBOX_AFTER_INPUTTING, Keys.ENTER);
		sleepInSecond(shortTimeOut);
	}

	public void clickToSearchButton() {
		waitForElementVisible(driver, PartnerAdvertiserPageUI.SEARCH_TEXTBOX);
		pressKeyToElement(driver, PartnerAdvertiserPageUI.SEARCH_TEXTBOX, Keys.ENTER);
	}

	public void clickToDeleteButtonByRownNumber(String rowNumber, String textValue) {
		waitForElementClickable(driver, PartnerAdvertiserPageUI.TEXT_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, textValue);
		clickToElement(driver, PartnerAdvertiserPageUI.TEXT_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, textValue);
	}

	public boolean isPopupDisplayed() {
		waitForElementVisible(driver, PartnerAdvertiserPageUI.DELETE_BRAND_POPUP);
		return isElementDisplayed(driver, PartnerAdvertiserPageUI.DELETE_BRAND_POPUP);
	}

	public String getTitlePopup() {
		waitForElementVisible(driver, PartnerAdvertiserPageUI.TITLE_DELETE_BRAND_POPUP);
		return getElementText(driver, PartnerAdvertiserPageUI.TITLE_DELETE_BRAND_POPUP);
	}

	public String getTextMessage() {
		waitForElementVisible(driver, PartnerAdvertiserPageUI.MESSAGE_DELETE_BRAND_POPUP);
		return getElementText(driver, PartnerAdvertiserPageUI.MESSAGE_DELETE_BRAND_POPUP);
	}

	public String getDeleteButtonText() {
		waitForElementVisible(driver, PartnerAdvertiserPageUI.DELETE_BUTTON_POPUP);
		return getElementText(driver, PartnerAdvertiserPageUI.DELETE_BUTTON_POPUP);
	}

	public String getCancelButtonText() {
		waitForElementVisible(driver, PartnerAdvertiserPageUI.CANCEL_BUTTON_POPUP);
		return getElementText(driver, PartnerAdvertiserPageUI.CANCEL_BUTTON_POPUP);
	}

	public void clickToClosePopupByIcon() {
		waitForElementClickable(driver, PartnerAdvertiserPageUI.CLOSE_BUTTON_POPUP);
		clickToElement(driver, PartnerAdvertiserPageUI.CLOSE_BUTTON_POPUP);
	}

	public void clickToClosePopupCancelButton() {
		waitForElementClickable(driver, PartnerAdvertiserPageUI.CANCEL_BUTTON_POPUP);
		clickToElement(driver, PartnerAdvertiserPageUI.CANCEL_BUTTON_POPUP);
	}

	public void clickToDeleteButton() {
		waitForElementClickable(driver, PartnerAdvertiserPageUI.DELETE_BUTTON_POPUP);
		clickToElement(driver, PartnerAdvertiserPageUI.DELETE_BUTTON_POPUP);
	}

	public Object getBrandNameByRownNumber(String rowNumber, String columnNumber) {
		waitForAllElementVisible(driver, PartnerAdvertiserPageUI.BRAND_NAME_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, columnNumber);
		return getElementText(driver, PartnerAdvertiserPageUI.BRAND_NAME_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, columnNumber);
	}

	public void clickToResetButton() {
		waitForElementClickable(driver, PartnerAdvertiserPageUI.RESET_BUTTON);
		clickToElement(driver, PartnerAdvertiserPageUI.RESET_BUTTON);
	}

	public void clickToBrandNameByRownNumber(String rowNumber, String textValue) {
		waitForElementClickable(driver, PartnerAdvertiserPageUI.TEXT_BRAND_CREATED_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, textValue);
		sleepInSecond(shortTimeOut);
		clickToElement(driver, PartnerAdvertiserPageUI.TEXT_BRAND_CREATED_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, textValue);
	}

	public boolean isSearchTextBoxDisplayed(String textValue) {
		waitForElementVisible(driver, PartnerAdvertiserPageUI.SEARCH_PLACEHOLDER_TEXTBOX, textValue);
		return isElementDisplayed(driver, PartnerAdvertiserPageUI.SEARCH_PLACEHOLDER_TEXTBOX, textValue);
	}
}
