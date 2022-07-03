package pageObjects.revu.Partner;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.GlobalConstants;

public class PartnerBrandPageObject extends BasePage {
	private WebDriver driver;
	long shortTimeOut = GlobalConstants.SHORT_TIME_OUT;

	public PartnerBrandPageObject(WebDriver driver) {
		this.driver = driver;
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
}
