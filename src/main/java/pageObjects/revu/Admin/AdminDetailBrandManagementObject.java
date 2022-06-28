package pageObjects.revu.Admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.GlobalConstants;
import pageUIs.revu.Partner.PartnerPageUI;
import pageUIs.revu.admin.AdminDetailBrandPageUI;

public class AdminDetailBrandManagementObject extends BasePage {
	private WebDriver driver;
	private long shorttime = GlobalConstants.SHORT_TIME_OUT_WAIT_ELEMENT;

	public AdminDetailBrandManagementObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToSeeBrandPageButton() {
		waitForElementClickable(driver, AdminDetailBrandPageUI.SEE_BRAND_PAGE_BUTTON);
		clickToElement(driver, AdminDetailBrandPageUI.SEE_BRAND_PAGE_BUTTON);
	}

	public void switchToWinDowByLink(String textValue) {
		switchtowindowbylink(driver, textValue);
	}

	public String getSeeBrandTextButton() {
		waitForElementVisible(driver, AdminDetailBrandPageUI.SEE_BRAND_PAGE_BUTTON);
		return getElementText(driver, AdminDetailBrandPageUI.SEE_BRAND_PAGE_BUTTON);
	}

	public void enterToEmailTextBox(String emailaddress) {
		waitForElementInVisible(driver, PartnerPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, PartnerPageUI.EMAIL_TEXTBOX, emailaddress);
	}

	public void clickToPasswordSettingButton(String textValue) {
		waitForElementInVisible(driver, PartnerPageUI.DYNAMIC_RESET_PASSWORD_BUTTON);
		sendkeyToElement(driver, PartnerPageUI.DYNAMIC_RESET_PASSWORD_BUTTON, textValue);
	}

	public void enterToPasswordTextBox(String password) {
		waitForElementInVisible(driver, PartnerPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, PartnerPageUI.PASSWORD_TEXTBOX, password);
	}

	public void enterToConfirmPasswordTextBox(String confirmPassword) {
		waitForElementInVisible(driver, PartnerPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, PartnerPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
	}

	public void clickSaveButton(String textValue) {
		waitForElementClickable(driver, PartnerPageUI.SAVE_BUTTON_TEXT, textValue);
		clickToElement(driver, PartnerPageUI.SAVE_BUTTON_TEXT, textValue);
	}

	public void clickOnButtonByName(String textValue) {
		waitForElementClickable(driver, PartnerPageUI.BUTTON_NAME, textValue);
		clickToElement(driver, PartnerPageUI.BUTTON_NAME, textValue);
	}

	public void switchToWinDownById(String id) {
		switchToWindowById(driver, id);
	}

}
