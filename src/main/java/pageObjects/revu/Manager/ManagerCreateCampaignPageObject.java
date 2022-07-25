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

	public boolean isTitleAreaDisplayed(String textValue) {
		waitForElementVisible(driver, ManagerCreateCampaignPageUI.TITLE_EACH_AREA_AT_CAMPAIGN_REGISTER, textValue);
		return isElementDisplayed(driver, ManagerCreateCampaignPageUI.TITLE_EACH_AREA_AT_CAMPAIGN_REGISTER, textValue);
	}

	public boolean isTemporarySaveCreateButtonDisplayed(String textValue) {
		waitForElementVisible(driver, ManagerCreateCampaignPageUI.TEMPORARY_SAVE_CREATE_BUTTON, textValue);
		return isElementDisplayed(driver, ManagerCreateCampaignPageUI.TEMPORARY_SAVE_CREATE_BUTTON, textValue);
	}

	public boolean isPreviewButtonDisplayed(String textValue) {
		waitForElementVisible(driver, ManagerCreateCampaignPageUI.PREVIEW_BUTTON, textValue);
		return isElementDisplayed(driver, ManagerCreateCampaignPageUI.PREVIEW_BUTTON, textValue);
	}
}
