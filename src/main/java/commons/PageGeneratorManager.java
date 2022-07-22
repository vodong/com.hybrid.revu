package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.revu.Admin.AdminDashBoardPageObject;
import pageObjects.revu.Admin.AdminHomePageObject;
import pageObjects.revu.Advertiser.AdvertiserDashBoardPageObject;
import pageObjects.revu.Manager.ManagerBrandManagementPageObject;
import pageObjects.revu.Manager.ManagerCreateBrandManagementPageObject;
import pageObjects.revu.Manager.ManagerCreateCampaignPageObject;
import pageObjects.revu.Manager.ManagerDetailBrandManagementPageObject;
import pageObjects.revu.Partner.PartnerBrandManagementPageObject;
import pageObjects.revu.Partner.PartnerCreateBrandManagementPageObject;
import pageObjects.revu.Partner.PartnerDetailBrandManagementPageObject;

public class PageGeneratorManager {

	public static AdminHomePageObject getHomePage(WebDriver driver) {
		return new AdminHomePageObject(driver);
	}

	public static AdminDashBoardPageObject getDashboardPage(WebDriver driver) {
		return new AdminDashBoardPageObject(driver);
	}

	public static ManagerBrandManagementPageObject getManagementPage(WebDriver driver) {
		return new ManagerBrandManagementPageObject(driver);
	}

	public static ManagerCreateBrandManagementPageObject getCreateANewBrandPage(WebDriver driver) {
		return new ManagerCreateBrandManagementPageObject(driver);
	}
	
	public static ManagerDetailBrandManagementPageObject getDetailBrandPage(WebDriver driver) {
		return new ManagerDetailBrandManagementPageObject(driver);
	}
	
	public static AdvertiserDashBoardPageObject getAdvertiserDashBoardPage(WebDriver driver) {
		return new AdvertiserDashBoardPageObject(driver);
	}

	public static PartnerBrandManagementPageObject getPartnerBrandMangementPage(WebDriver driver) {
		return new PartnerBrandManagementPageObject(driver);
	}
	
	public static PartnerCreateBrandManagementPageObject getPartnerCreateANewBrandPage(WebDriver driver) {
		return new PartnerCreateBrandManagementPageObject(driver);
	}
	
	public static PartnerDetailBrandManagementPageObject getPartnerDetailBrandPage(WebDriver driver) {
		return new PartnerDetailBrandManagementPageObject(driver);
	}

	public static ManagerCreateCampaignPageObject getManagerCreateCampaignPage(WebDriver driver) {
		return new ManagerCreateCampaignPageObject(driver);
	}
}
