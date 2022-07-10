package pageObjects.revu.Advertiser;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.GlobalConstants_KR;
import pageUIs.revu.Advertiser.AdvertiserDashBoardPageUI;

public class AdvertiserDashBoardPageObject extends BasePage {
	private WebDriver driver;
	long shortTimeOut = GlobalConstants_KR.shortTimeout;

	public AdvertiserDashBoardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getPartnerName() {
		waitForElementVisible(driver, AdvertiserDashBoardPageUI.ADVERTISER_NAME);
		return getElementText(driver, AdvertiserDashBoardPageUI.ADVERTISER_NAME);
	}

	public void closePartnerBrandPage(String linkValue) {
		CloseAllWindownsWithoutParent(driver, linkValue);
	}

	public void switchTab(String urlValue) {
		switchtowindowbylink(driver, urlValue);
	}

	public void closeTab(String linkValue) {
		CloseAllWindownsWithoutParent(driver, linkValue);
	}

	public boolean isDeliveryMenuDisplayed() {
		waitForElementVisible(driver, AdvertiserDashBoardPageUI.NAVBAR_LEFT_MENU);
		return isElementDisplayed(driver, AdvertiserDashBoardPageUI.NAVBAR_LEFT_MENU);
	}
}
