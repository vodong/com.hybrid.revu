package pageObjects.revu.Manager;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.revu.admin.ManagerCreateCampaignPageUI;

public class ManagerCreateCampaignPageObject extends BasePage {
	private WebDriver driver;
	
	public ManagerCreateCampaignPageObject (WebDriver driver) {
		this.driver = driver;
	}

	public String getTitleCampaignRegistratior(WebDriver driver) {
		waitForElementVisible(driver, ManagerCreateCampaignPageUI.TITLE_CAMPAIGN_REGISTER);
		return getElementText(driver, ManagerCreateCampaignPageUI.TITLE_CAMPAIGN_REGISTER);
	}
}
