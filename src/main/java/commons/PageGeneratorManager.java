package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.revu.Admin.AdminBrandManagementPageObject;
import pageObjects.revu.Admin.AdminCreateBrandManagementPageObject;
import pageObjects.revu.Admin.AdminDashBoardPageObject;
import pageObjects.revu.Admin.AdminDetailBrandManagementPageObject;
import pageObjects.revu.Admin.AdminHomePageObject;
import pageObjects.revu.Advertiser.AdvertiserDashBoardPageObject;
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

	public static AdminBrandManagementPageObject getManagementPage(WebDriver driver) {
		return new AdminBrandManagementPageObject(driver);
	}

	public static AdminCreateBrandManagementPageObject getCreateANewBrandPage(WebDriver driver) {
		return new AdminCreateBrandManagementPageObject(driver);
	}
	
	public static AdminDetailBrandManagementPageObject getDetailBrandPage(WebDriver driver) {
		return new AdminDetailBrandManagementPageObject(driver);
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
}
