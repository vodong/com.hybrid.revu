package pageObjects.revu.Admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.revu.admin.AdminDashboardPageUI;

public class AdminDashBoardObject extends BasePage {
	private WebDriver driver;

	public AdminDashBoardObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isLogOutLinkDisplayed() {
		waitForElementVisible(driver, AdminDashboardPageUI.LOGOUT_LINK_HEADER);
		return isElementDisplayed(driver, AdminDashboardPageUI.LOGOUT_LINK_HEADER);
	}
}
