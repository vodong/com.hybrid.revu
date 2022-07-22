package pageObjects.revu.Manager;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.GlobalConstants;
import pageUIs.revu.admin.ManagerAdvertiserPageUI;
import pageUIs.revu.admin.AdminDashboardPageUI;
import pageUIs.revu.admin.AdminHomePageUI;
import pageUIs.revu.admin.BasePageUI;

public class ManagerBrandManagementPageObject extends BasePage {
	private WebDriver driver;
	long shortTimeOut = GlobalConstants.getGlobalConstants().getShortTimeout();

	public ManagerBrandManagementPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isLogOutLinkDisplayed() {
		waitForAllElementInVisible(driver, AdminDashboardPageUI.LOGOUT_LINK_HEADER);
		return isElementDisplayed(driver, AdminDashboardPageUI.LOGOUT_LINK_HEADER);
	}

	public boolean isPlaceHolderDisplayed(String labelName, String placeHolderName) {
		waitForElementVisible(driver, ManagerAdvertiserPageUI.SEARCH_FILTER_AREA, labelName, placeHolderName);
		return isElementDisplayed(driver, ManagerAdvertiserPageUI.SEARCH_FILTER_AREA, labelName, placeHolderName);
	}

	public boolean isPlaceHolderFieldDropDownListDisplayed(String labelName, String placeHolderName) {
		waitForElementVisible(driver, ManagerAdvertiserPageUI.SEARCH_FILTER_AREA_FIELD_DROPDOWN_LIST, labelName, placeHolderName);
		return isElementDisplayed(driver, ManagerAdvertiserPageUI.SEARCH_FILTER_AREA_FIELD_DROPDOWN_LIST, labelName, placeHolderName);
	}

	public boolean isColumnNameDisplayed(String columnName) {
		waitForElementVisible(driver, ManagerAdvertiserPageUI.COLUMN_NAME, columnName);
		return isElementDisplayed(driver, ManagerAdvertiserPageUI.COLUMN_NAME, columnName);
	}

	public boolean isTextAtRowDisplayed(String columnName, String rowNumber, String textValue) {
		int totalNumberIndex = getElementSize(driver, ManagerAdvertiserPageUI.COLUMN_INDEX_BY_NAME, columnName, textValue) +1;
		waitForElementVisible(driver, ManagerAdvertiserPageUI.TEXT_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, textValue, String.valueOf(totalNumberIndex));
		return isElementDisplayed(driver, ManagerAdvertiserPageUI.TEXT_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, textValue, String.valueOf(totalNumberIndex));
	}

	public boolean isButtonDisplayed(String textValue) {
		waitForElementVisible(driver, ManagerAdvertiserPageUI.DYNAMIC_TEXT_BUTTON, textValue);
		return isElementDisplayed(driver, ManagerAdvertiserPageUI.DYNAMIC_TEXT_BUTTON, textValue);
	}

	public void openCreateANewBrand(String textValue) {
		waitForElementClickable(driver, ManagerAdvertiserPageUI.CREATE_NEW_BRAND_BUTTON, textValue);
		clickToElement(driver, ManagerAdvertiserPageUI.CREATE_NEW_BRAND_BUTTON, textValue);
		sleepInSecond(shortTimeOut);
	}

	public boolean isTextCreatedBrandAtRowDisplayed(String columnName, String rowNumber, String textValue) {
		int totalNumberIndex = getElementSize(driver, ManagerAdvertiserPageUI.COLUMN_INDEX_BY_NAME, columnName, textValue) +1;
		waitForElementVisible(driver, ManagerAdvertiserPageUI.TEXT_BRAND_CREATED_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, textValue, String.valueOf(totalNumberIndex));
		return isElementDisplayed(driver, ManagerAdvertiserPageUI.TEXT_BRAND_CREATED_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, textValue, String.valueOf(totalNumberIndex));
	}

	public void enterToSearchBrandTextBox(String textValue) {
		waitForElementClickable(driver, ManagerAdvertiserPageUI.BRAND_TEXTBOX);
		sendkeyToElement(driver, ManagerAdvertiserPageUI.BRAND_TEXTBOX, textValue);
	}

	public void clickToSearchButton() {
		waitForElementClickable(driver, ManagerAdvertiserPageUI.SEARCH_BUTTON);
		clickToElement(driver, ManagerAdvertiserPageUI.SEARCH_BUTTON);
	}

	public void clickToDeleteButtonByRownNumber(String rowNumber, String textValue) {
		waitForElementClickable(driver, ManagerAdvertiserPageUI.TEXT_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, textValue);
		clickToElement(driver, ManagerAdvertiserPageUI.TEXT_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, textValue);
	}

	public boolean isPopupDisplayed() {
		waitForElementVisible(driver, ManagerAdvertiserPageUI.DELETE_BRAND_POPUP);
		return isElementDisplayed(driver, ManagerAdvertiserPageUI.DELETE_BRAND_POPUP);
	}

	public String getTitlePopup() {
		waitForElementVisible(driver, ManagerAdvertiserPageUI.TITLE_DELETE_BRAND_POPUP);
		return getElementText(driver, ManagerAdvertiserPageUI.TITLE_DELETE_BRAND_POPUP);
	}

	public String getTextMessage() {
		waitForElementVisible(driver, ManagerAdvertiserPageUI.MESSAGE_DELETE_BRAND_POPUP);
		return getElementText(driver, ManagerAdvertiserPageUI.MESSAGE_DELETE_BRAND_POPUP);
	}

	public String getDeleteButtonText() {
		waitForElementVisible(driver, ManagerAdvertiserPageUI.DELETE_BUTTON_POPUP);
		return getElementText(driver, ManagerAdvertiserPageUI.DELETE_BUTTON_POPUP);
	}

	public String getCancelButtonText() {
		waitForElementVisible(driver, ManagerAdvertiserPageUI.CANCEL_BUTTON_POPUP);
		return getElementText(driver, ManagerAdvertiserPageUI.CANCEL_BUTTON_POPUP);
	}

	public void clickToClosePopupByIcon() {
		waitForElementClickable(driver, ManagerAdvertiserPageUI.CLOSE_BUTTON_POPUP);
		clickToElement(driver, ManagerAdvertiserPageUI.CLOSE_BUTTON_POPUP);
	}

	public void clickToClosePopupCancelButton() {
		waitForElementClickable(driver, ManagerAdvertiserPageUI.CANCEL_BUTTON_POPUP);
		clickToElement(driver, ManagerAdvertiserPageUI.CANCEL_BUTTON_POPUP);
	}

	public void clickToDeleteButton() {
		waitForElementClickable(driver, ManagerAdvertiserPageUI.DELETE_BUTTON_POPUP);
		clickToElement(driver, ManagerAdvertiserPageUI.DELETE_BUTTON_POPUP);
	}

	public Object getBrandNameByRownNumber(String rowNumber, String columnNumber) {
		waitForAllElementVisible(driver, ManagerAdvertiserPageUI.BRAND_NAME_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, columnNumber);
		return getElementText(driver, ManagerAdvertiserPageUI.BRAND_NAME_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, columnNumber);
	}

	public void clickToResetButton() {
		waitForElementClickable(driver, ManagerAdvertiserPageUI.RESET_BUTTON);
		clickToElement(driver, ManagerAdvertiserPageUI.RESET_BUTTON);
	}

	public void clickToBrandNameByRownNumber(String rowNumber, String textValue) {
		waitForElementClickable(driver, ManagerAdvertiserPageUI.TEXT_BRAND_CREATED_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, textValue);
		sleepInSecond(shortTimeOut);
		clickToElement(driver, ManagerAdvertiserPageUI.TEXT_BRAND_CREATED_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, textValue);
	}

	public void clickOnLogOutButton() {
		waitForElementClickable(driver, BasePageUI.LOGOUT_LINK_HEADER);
		clickToElement(driver, BasePageUI.LOGOUT_LINK_HEADER);
	}

	public boolean isOpenLoginLinkDisplayed() {
		waitForElementVisible(driver, AdminHomePageUI.LOGIN_LINK);
		return isElementDisplayed(driver,  AdminHomePageUI.LOGIN_LINK);
	}
}
