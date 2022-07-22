package com.revu.admin.kr;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import environmentConfig.Environment;
import pageObjects.revu.Admin.AdminDashBoardPageObject;
import pageObjects.revu.Admin.AdminHomePageObject;
import pageObjects.revu.Manager.ManagerCreateCampaignPageObject;
import reportConfig.ExtentTestManager;

public class Create_Edit_Campaign_Korea_Manager_Role extends BaseTest {

	WebDriver driver;
	AdminDashBoardPageObject adminDashBoardPage;
	AdminHomePageObject adminHomePage;
	ManagerCreateCampaignPageObject managerCreateCampaignPage;
	String getCurrentUrl, getCurrentPageID;

	Environment environment;

	@Parameters({ "envName", "serverName", "browser", "osName", "osVersion", "ipAddress", "portNumber" })
	@BeforeClass
	public void beforeClass(@Optional("local") String envName, @Optional("DEV") String serverName,
			@Optional("chrome") String browserName, @Optional("Windows") String osName,
			@Optional("10") String osVersion, @Optional("localhost") String ipAddress,
			@Optional("4444") String portNumber) {

		driver = getBrowserDriver(envName, serverName, browserName, osName, osVersion, ipAddress, portNumber);

		adminHomePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void Manage_Role_KR_TC_01_Open_Admin_Page_And_Select_Country(Method method) {
		ExtentTestManager.startTest(method.getName(), "Open Admin Page And Select Country");
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 01: Open Country List");
		adminHomePage.openCountryList();

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 02: Select Country");
		adminHomePage.hoverCountryName(GlobalConstants.getGlobalConstants().getKoreaCountry());

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 03: Select language");
		adminHomePage.selectLanguage(GlobalConstants.getGlobalConstants().getKoreaLanguage());

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 04: Open Login Form");
		adminHomePage.openLoginPopup();
	}
	
	@Test
	public void Manage_Role_KR_TC_02_Login_To_DashBoard_Page(Method method) {
		ExtentTestManager.startTest(method.getName(), "Login To DasbhBoard Page");
		ExtentTestManager.getTest().log(Status.INFO,
				"Admin Page - Step 01: Enter Email'" + GlobalConstants.getGlobalConstants().getEmailKoreaManagerRole() + "'");
		adminHomePage.enterToEmailTextbox(GlobalConstants.getGlobalConstants().getEmailKoreaManagerRole());
		
		ExtentTestManager.getTest().log(Status.INFO,
				"Admin Page - Step 02: Enter Password'" + GlobalConstants.getGlobalConstants().getPassword() + "'");
		adminHomePage.enterToPasswordTextbox(GlobalConstants.getGlobalConstants().getPassword());
		
		ExtentTestManager.getTest().log(Status.INFO, "Admin Page - Step 03: Click on Submit button");
		adminDashBoardPage = adminHomePage.openAdminDashBoardPage(GlobalConstants.getGlobalConstants().getLoginButtonKR());
		
		ExtentTestManager.getTest().log(Status.INFO, "Admin Page - Step 04: Verify Login Successfull");
		assertTrue(adminDashBoardPage.isLogOutLinkDisplayed());
	}
	
	@Test
	public void Manage_Role_KR_TC_03_Open_Campaign_Menu(Method method) {
		ExtentTestManager.startTest(method.getName(), "Open Campaign Menu");
		ExtentTestManager.getTest().log(Status.INFO, "Admin Page - Step 01: Change to English Language");
		adminDashBoardPage.openSelectLanguageList(driver, GlobalConstants.getGlobalConstants().getEnglishLangguage());
		
		ExtentTestManager.getTest().log(Status.INFO, "Admin Page - Step 02: Click On Campaign Link");
		adminDashBoardPage.clickOnByMenuNameLink(driver, GlobalConstants.getGlobalConstants().getCampaignLinkEN());
	}
	
	@Test
	public void Manage_Role_KR_TC_04_Check_Campaign_Menu_Translate_To_English(Method method) {
		ExtentTestManager.startTest(method.getName(), "Check Translate To English Campaign Menu");		
		ExtentTestManager.getTest().log(Status.INFO, "Admin Page - Step 01: Verify Campaign Screening Link Is Displayed");
		assertTrue(adminDashBoardPage.isCampaignScreeningLinkIsDisplayed(GlobalConstants.getGlobalConstants().getCampaignScreeningLinkEN()));
		
		ExtentTestManager.getTest().log(Status.INFO, "Admin Page - Step 02: Verify Campaign List Link Is Displayed");
		assertTrue(adminDashBoardPage.isCampaignListLinkIsDisplayed(GlobalConstants.getGlobalConstants().getCampaignListLinkEN()));
		
		ExtentTestManager.getTest().log(Status.INFO, "Admin Page - Step 03: Verify New Campaign Registration Link Is Displayed");
		assertTrue(adminDashBoardPage.isNewCampaignRegistrationLinkIsDisplayed(GlobalConstants.getGlobalConstants().getNewCampaignRegistrationEN()));
	}
	
	@Test
	public void Manage_Role_KR_TC_05_Check_Campaign_Menu_Translate_To_Korea(Method method) {
		ExtentTestManager.startTest(method.getName(), "Check Translate To Korea Campaign Menu");	
		ExtentTestManager.getTest().log(Status.INFO, "Admin Page - Step 01: Change to Korea Language");
		adminDashBoardPage.openSelectLanguageList(driver, GlobalConstants.getGlobalConstants().getKoreaLanguage());
		
		ExtentTestManager.getTest().log(Status.INFO, "Admin Page - Step 02: Verify Campaign Screening Link Is Displayed");
		assertTrue(adminDashBoardPage.isCampaignScreeningLinkIsDisplayed(GlobalConstants.getGlobalConstants().getCampaignScreeningLinkKR()));
		
		ExtentTestManager.getTest().log(Status.INFO, "Admin Page - Step 03: Verify Campaign List Link Is Displayed");
		assertTrue(adminDashBoardPage.isCampaignListLinkIsDisplayed(GlobalConstants.getGlobalConstants().getCampaignListLinkKR()));
		
		ExtentTestManager.getTest().log(Status.INFO, "Admin Page - Step 04: Verify New Campaign Registration Link Is Displayed");
		assertTrue(adminDashBoardPage.isNewCampaignRegistrationLinkIsDisplayed(GlobalConstants.getGlobalConstants().getNewCampaignRegistrationKR()));
	}

	@Test
	public void Manage_Role_KR_TC_06_Open_New_Campaign_Registration_Page(Method method) {
		ExtentTestManager.startTest(method.getName(), "Open New Campaign Registration Page");	
		ExtentTestManager.getTest().log(Status.INFO, "Admin Page - Step 01: Click On New Campaign Registration Link");
		adminDashBoardPage.clickOnNewCampaignRegistrationLink(GlobalConstants.getGlobalConstants().getCampaignRegisterTitleKR());
		managerCreateCampaignPage = PageGeneratorManager.getManagerCreateCampaignPage(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 02: Verify Open Campaign Registration Successfully");
		assertEquals(managerCreateCampaignPage.getTitleCampaignRegistratior(driver), GlobalConstants.getGlobalConstants().getCampaignRegisterTitleKR());
	}

	@Parameters({ "browser"})
	@AfterClass(alwaysRun = true)
	public void afterClass(String browserName) {
		ExtentTestManager.getTest().log(Status.INFO, "Close broser '" + browserName + "'");
		closeBrowserAndDriver();
	}
}
