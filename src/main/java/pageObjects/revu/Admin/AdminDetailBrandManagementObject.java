package pageObjects.revu.Admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.GlobalConstants;
import pageUIs.revu.admin.AdminAdvertiserPageUI;
import pageUIs.revu.admin.AdminCreateBrandPageUI;
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

}
