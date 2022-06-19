package pageObjects.revu.Admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.GlobalConstants;
import pageUIs.revu.admin.AdminAdvertiserPageUI;
import pageUIs.revu.admin.AdminDashboardPageUI;

public class AdminBrandManagementObject extends BasePage {
	private WebDriver driver;
	long shortTimeOut = GlobalConstants.SHORT_TIME_OUT;

	public AdminBrandManagementObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isLogOutLinkDisplayed() {
		waitForAllElementInVisible(driver, AdminDashboardPageUI.LOGOUT_LINK_HEADER);
		return isElementDisplayed(driver, AdminDashboardPageUI.LOGOUT_LINK_HEADER);
	}

	public boolean isPlaceHolderDisplayed(String labelName, String placeHolderName) {
		waitForElementVisible(driver, AdminAdvertiserPageUI.SEARCH_FILTER_AREA, labelName, placeHolderName);
		return isElementDisplayed(driver, AdminAdvertiserPageUI.SEARCH_FILTER_AREA, labelName, placeHolderName);
	}

	public boolean isPlaceHolderFieldDropDownListDisplayed(String labelName, String placeHolderName) {
		waitForElementVisible(driver, AdminAdvertiserPageUI.SEARCH_FILTER_AREA_FIELD_DROPDOWN_LIST, placeHolderName, labelName);
		return isElementDisplayed(driver, AdminAdvertiserPageUI.SEARCH_FILTER_AREA_FIELD_DROPDOWN_LIST, placeHolderName, labelName);
	}

	public boolean isColumnNameDisplayed(String columnName) {
		waitForElementVisible(driver, AdminAdvertiserPageUI.COLUMN_NAME, columnName);
		return isElementDisplayed(driver, AdminAdvertiserPageUI.COLUMN_NAME, columnName);
	}

	public boolean isTextAtRowDisplayed(String columnName, String rowNumber, String textValue) {
		int totalNumberIndex = getElementSize(driver, AdminAdvertiserPageUI.COLUMN_INDEX_BY_NAME, columnName, textValue) +1;
		waitForElementVisible(driver, AdminAdvertiserPageUI.TEXT_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, textValue, String.valueOf(totalNumberIndex));
		return isElementDisplayed(driver, AdminAdvertiserPageUI.TEXT_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, textValue, String.valueOf(totalNumberIndex));
	}

	public boolean isButtonDisplayed(String textValue) {
		waitForElementVisible(driver, AdminAdvertiserPageUI.DYNAMIC_TEXT_BUTTON, textValue);
		return isElementDisplayed(driver, AdminAdvertiserPageUI.DYNAMIC_TEXT_BUTTON, textValue);
	}

	public void openCreateANewBrand(String textValue) {
		waitForElementClickable(driver, AdminAdvertiserPageUI.CREATE_NEW_BRAND_BUTTON, textValue);
		clickToElement(driver, AdminAdvertiserPageUI.CREATE_NEW_BRAND_BUTTON, textValue);
		sleepInSecond(shortTimeOut);
	}

	public boolean isTextCreatedBrandAtRowDisplayed(String columnName, String rowNumber, String textValue) {
		int totalNumberIndex = getElementSize(driver, AdminAdvertiserPageUI.COLUMN_INDEX_BY_NAME, columnName, textValue) +1;
		waitForElementVisible(driver, AdminAdvertiserPageUI.TEXT_BRAND_CREATED_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, textValue, String.valueOf(totalNumberIndex));
		return isElementDisplayed(driver, AdminAdvertiserPageUI.TEXT_BRAND_CREATED_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, textValue, String.valueOf(totalNumberIndex));
	}
}
