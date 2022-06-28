package pageObjects.revu.Partner;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.GlobalConstants;
import pageUIs.revu.Partner.PartnerPageUI;

public class PartnerBrandPageObject extends BasePage {
	private WebDriver driver;
	long shortTimeOut = GlobalConstants.SHORT_TIME_OUT;

	public PartnerBrandPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getPartnerName() {
		waitForElementVisible(driver, PartnerPageUI.PARTNER_NAME);
		return getElementText(driver, PartnerPageUI.PARTNER_NAME);
	}
}
