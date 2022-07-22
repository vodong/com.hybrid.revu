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

	public boolean isCampaignScreeningLinkIsDisplayed(String textValue) {
		waitForElementVisible(driver, BasePageUI.DYNAMIC_SIDER_CAMPAIGN_LINK_BY_NAME , textValue);
		return isElementDisplayed(driver, BasePageUI.DYNAMIC_SIDER_CAMPAIGN_LINK_BY_NAME , textValue);
	}

	public boolean isCampaignListLinkIsDisplayed(String textValue) {
		waitForElementVisible(driver, BasePageUI.DYNAMIC_SIDER_CAMPAIGN_LINK_BY_NAME , textValue);
		return isElementDisplayed(driver, BasePageUI.DYNAMIC_SIDER_CAMPAIGN_LINK_BY_NAME , textValue);
	}

	public boolean isNewCampaignRegistrationLinkIsDisplayed(String textValue) {
		waitForElementVisible(driver, BasePageUI.DYNAMIC_SIDER_CAMPAIGN_LINK_BY_NAME , textValue);
		return isElementDisplayed(driver, BasePageUI.DYNAMIC_SIDER_CAMPAIGN_LINK_BY_NAME , textValue);
	}

	public void clickOnNewCampaignRegistrationLink(String textValue) {
		waitForElementClickable(driver, BasePageUI.DYNAMIC_SIDER_CAMPAIGN_LINK_BY_NAME , textValue);
		clickToElement(driver, BasePageUI.DYNAMIC_SIDER_CAMPAIGN_LINK_BY_NAME , textValue);
	}
}
