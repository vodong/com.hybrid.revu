package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.revu.Admin.AdminBrandManagementObject;
import pageObjects.revu.Admin.AdminCreateBrandManagementObject;
import pageObjects.revu.Admin.AdminDashBoardObject;
import pageObjects.revu.Admin.AdminHomePageObject;

public class PageGeneratorManager {

	public static AdminHomePageObject getHomePage(WebDriver driver) {
		return new AdminHomePageObject(driver);
	}

	public static AdminDashBoardObject getDashboardPage(WebDriver driver) {
		return new AdminDashBoardObject(driver);
	}

	public static AdminBrandManagementObject getManagementPage(WebDriver driver) {
		return new AdminBrandManagementObject(driver);
	}

	public static AdminCreateBrandManagementObject getCreateANewBrandPage(WebDriver driver) {
		return new AdminCreateBrandManagementObject(driver);
	}
}
