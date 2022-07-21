package pageObjects.revu.Admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.revu.admin.BasePageUI;

public class AdminDashBoardPageObject extends BasePage {
	private WebDriver driver;

	public AdminDashBoardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isLogOutLinkDisplayed() {
		waitForElementVisible(driver, BasePageUI.LOGOUT_LINK_HEADER);
		return isElementDisplayed(driver, BasePageUI.LOGOUT_LINK_HEADER);
	}
}