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
import commons.GlobalConstantsCreateCampaign;
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
		adminDashBoardPage.clickOnByMenuNameLink(driver, GlobalConstantsCreateCampaign.getGlobalConstantsCreateCampaign().getCampaignLinkEN());
	}
	
	@Test
	public void Manage_Role_KR_TC_04_Check_Campaign_Menu_Translate_To_English(Method method) {
		ExtentTestManager.startTest(method.getName(), "Check Translate To English Campaign Menu");		
		ExtentTestManager.getTest().log(Status.INFO, "Admin Page - Step 01: Verify Campaign Screening Link Is Displayed");
		assertTrue(adminDashBoardPage.isCampaignScreeningLinkIsDisplayed(GlobalConstantsCreateCampaign.getGlobalConstantsCreateCampaign().getCampaignScreeningLinkEN()));
		
		ExtentTestManager.getTest().log(Status.INFO, "Admin Page - Step 02: Verify Campaign List Link Is Displayed");
		assertTrue(adminDashBoardPage.isCampaignListLinkIsDisplayed(GlobalConstantsCreateCampaign.getGlobalConstantsCreateCampaign().getCampaignListLinkEN()));
		
		ExtentTestManager.getTest().log(Status.INFO, "Admin Page - Step 03: Verify New Campaign Registration Link Is Displayed");
		assertTrue(adminDashBoardPage.isNewCampaignRegistrationLinkIsDisplayed(GlobalConstantsCreateCampaign.getGlobalConstantsCreateCampaign().getNewCampaignRegistrationEN()));
	}
	
	@Test
	public void Manage_Role_KR_TC_05_Check_Campaign_Menu_Translate_To_Korea(Method method) {
		ExtentTestManager.startTest(method.getName(), "Check Translate To Korea Campaign Menu");	
		ExtentTestManager.getTest().log(Status.INFO, "Admin Page - Step 01: Change to Korea Language");
		adminDashBoardPage.openSelectLanguageList(driver, GlobalConstants.getGlobalConstants().getKoreaLanguage());
		
		ExtentTestManager.getTest().log(Status.INFO, "Admin Page - Step 02: Verify Campaign Screening Link Is Displayed");
		assertTrue(adminDashBoardPage.isCampaignScreeningLinkIsDisplayed(GlobalConstantsCreateCampaign.getGlobalConstantsCreateCampaign().getCampaignScreeningLinkKR()));
		
		ExtentTestManager.getTest().log(Status.INFO, "Admin Page - Step 03: Verify Campaign List Link Is Displayed");
		assertTrue(adminDashBoardPage.isCampaignListLinkIsDisplayed(GlobalConstantsCreateCampaign.getGlobalConstantsCreateCampaign().getCampaignListLinkKR()));
		
		ExtentTestManager.getTest().log(Status.INFO, "Admin Page - Step 04: Verify New Campaign Registration Link Is Displayed");
		assertTrue(adminDashBoardPage.isNewCampaignRegistrationLinkIsDisplayed(GlobalConstantsCreateCampaign.getGlobalConstantsCreateCampaign().getNewCampaignRegistrationKR()));
	}
	
	@Test
	public void Manage_Role_KR_TC_06_Open_New_Campaign_Registration_Page(Method method) {
		ExtentTestManager.startTest(method.getName(), "Open New Campaign Registration Page");	
		ExtentTestManager.getTest().log(Status.INFO, "Admin Page - Step 01: Click On New Campaign Registration Link");
		adminDashBoardPage.clickOnNewCampaignRegistrationLink(GlobalConstantsCreateCampaign.getGlobalConstantsCreateCampaign().getCampaignRegisterTitleKR());
		managerCreateCampaignPage = PageGeneratorManager.getManagerCreateCampaignPage(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 02: Verify Open Campaign Registration Successfully");
		assertEquals(managerCreateCampaignPage.getTitleCampaignRegistratior(driver), GlobalConstantsCreateCampaign.getGlobalConstantsCreateCampaign().getCampaignRegisterTitleKR());
	}

	@Test
	public void Manage_Role_KR_TC_07_Check_Translate_To_Korea_New_Campaign_Page(Method method) {
		ExtentTestManager.startTest(method.getName(), "Check Translate To Korea Language");	
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 01: Select Korea Country");
		managerCreateCampaignPage.openSelectLanguageList(driver, GlobalConstants.getGlobalConstants().getKoreaLanguage());
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 02: Verify Advertiser Title");
		assertTrue(managerCreateCampaignPage.isTitleAreaDisplayed(GlobalConstantsCreateCampaign.getGlobalConstantsCreateCampaign().getAdvertiserAreaTitleKR()));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 03: Verify Partner Textbox Area");
		assertTrue(managerCreateCampaignPage.isLabelAndPlaceHolderDisplayed("", ""));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 04: Verify Advertiser(Brand) Textbox Area");
		assertTrue(managerCreateCampaignPage.isLabelAndPlaceHolderDisplayed("", ""));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 05: Verify Sales rep Textbox Area");
		assertTrue(managerCreateCampaignPage.isLabelAndPlaceHolderDisplayed("", ""));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 06: Verify Scope Title");
		assertTrue(managerCreateCampaignPage.isTitleAreaDisplayed(GlobalConstantsCreateCampaign.getGlobalConstantsCreateCampaign().getScopeAreaTitleKR()));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 07: Verify Channel Label And Revu Select Radio Button");
		assertTrue(managerCreateCampaignPage.isLabelAndRadioButtonDisplayed("", ""));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 08: Verify Recruitment range Lable And Public Radio Button");
		assertTrue(managerCreateCampaignPage.isLabelAndRadioButtonDisplayed("", ""));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 09: Verify Recruitment range Lable And Pro only Radio Button");
		assertTrue(managerCreateCampaignPage.isLabelAndRadioButtonDisplayed("", ""));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 10: Verify Recruitment range Lable And Private Radio Button");
		assertTrue(managerCreateCampaignPage.isLabelAndRadioButtonDisplayed("", ""));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 11: Verify Influencer Title");
		assertTrue(managerCreateCampaignPage.isTitleAreaDisplayed(GlobalConstantsCreateCampaign.getGlobalConstantsCreateCampaign().getInfluencerAreaTitleKR()));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 12: Verify SNS Lable And Instagram Radio Button");
		assertTrue(managerCreateCampaignPage.isLabelAndRadioButtonDisplayed("", ""));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 13: Verify SNS Lable And Youtube Radio Button");
		assertTrue(managerCreateCampaignPage.isLabelAndRadioButtonDisplayed("", ""));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 13: Verify Number of influencers Area");
		assertTrue(managerCreateCampaignPage.isLabelAndPlaceHolderDisplayed("", ""));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 14: Verify Number of contents (per influencer) Lable And Post Number Radio Button");
		assertTrue(managerCreateCampaignPage.isLabelAndRadioButtonDisplayed("", ""));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 15: Verify Product and Point Title");
		assertTrue(managerCreateCampaignPage.isTitleAreaDisplayed(GlobalConstantsCreateCampaign.getGlobalConstantsCreateCampaign().getProductPointAreaTitleKR()));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 16: Verify Type Lable And Product Radio Button");
		assertTrue(managerCreateCampaignPage.isLabelAndRadioButtonDisplayed("", ""));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 17: Verify Type Lable And Place Radio Button");
		assertTrue(managerCreateCampaignPage.isLabelAndRadioButtonDisplayed("", ""));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 18: Verify Product 1 Textbox Area");
		assertTrue(managerCreateCampaignPage.isLabelAndPlaceHolderDisplayed("", ""));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 19: Verify Add Button Is Displayed");
		assertTrue(managerCreateCampaignPage.isAddButtonDisplayed(""));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 20: Verify Set options Lable And Set Radio Button");
		assertTrue(managerCreateCampaignPage.isLabelAndRadioButtonDisplayed("", ""));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 21: Verify Set options Lable And Not Set Radio Button");
		assertTrue(managerCreateCampaignPage.isLabelAndRadioButtonDisplayed("", ""));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 22: Verify Option information Textbox Area And Option Name Place Holder");
		assertTrue(managerCreateCampaignPage.isLabelAndPlaceHolderDisplayed("", ""));
				
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 23: Verify Option information Textbox Area And Enter option value Place Holder");
		assertTrue(managerCreateCampaignPage.isLabelAndPlaceHolderDisplayed("", ""));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 24: Verify Add Button Is Displayed");
		assertTrue(managerCreateCampaignPage.isPlusButtonDisplayed(""));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 25: Verify Product price Textbox Area");
		assertTrue(managerCreateCampaignPage.isLabelAndPlaceHolderDisplayed("", ""));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 25: Verify Product descriptions Textbox Area");
		assertTrue(managerCreateCampaignPage.isLabelAndPlaceHolderDisplayed("", ""));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 26: Verify Point amount Textbox Area");
		assertTrue(managerCreateCampaignPage.isLabelAndPlaceHolderDisplayed("", ""));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 27: Verify No points provided Checkbox Is Displayed");
		assertTrue(managerCreateCampaignPage.isCheckboxDisplayed("", ""));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 28: Verify Campaign Title");
		assertTrue(managerCreateCampaignPage.isTitleAreaDisplayed(GlobalConstantsCreateCampaign.getGlobalConstantsCreateCampaign().getCampaignAreaTitleKR()));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 29: Verify Campaign Name Textbox Area");
		assertTrue(managerCreateCampaignPage.isLabelAndPlaceHolderDisplayed("", ""));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 30: Verify Main thumbnail Area And Upload Button Are Displayed");
		assertTrue(managerCreateCampaignPage.isUploadAreaDisplayed("",""));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 31: Verify Main thumbnail Area And Caution Text Are Displayed");
		assertTrue(managerCreateCampaignPage.isUploadCautionTextDisplayed("",""));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 32: Verify Detail thumbnails Area And Caution Text Are Displayed");
		assertTrue(managerCreateCampaignPage.isUploadAreaDisplayed("",""));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 33: Verify Detail thumbnail Area And Caution Text Are Displayed");
		assertTrue(managerCreateCampaignPage.isUploadCautionTextDisplayed("",""));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 34: Verify Video URL(Youtube) TextBox Area And Place Holder");
		assertTrue(managerCreateCampaignPage.isLabelAndPlaceHolderDisplayed("",""));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 35: Verify Campaign guideline TextBox Area");
		assertTrue(managerCreateCampaignPage.isLabelAndPlaceHolderDisplayed("",""));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 36: Verify Campaign caution TextBox Area");
		assertTrue(managerCreateCampaignPage.isLabelAndPlaceHolderDisplayed("",""));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 37: Verify Content Title");
		assertTrue(managerCreateCampaignPage.isTitleAreaDisplayed(GlobalConstantsCreateCampaign.getGlobalConstantsCreateCampaign().getContentAreaTitleKR()));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 38: Verify Content missions TextBox Area And Place Holder");
		assertTrue(managerCreateCampaignPage.isLabelAndPlaceHolderDisplayed("",""));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 39: Verify Detail guideline Area And Upload Button Are Displayed");
		assertTrue(managerCreateCampaignPage.isUploadAreaDisplayed("",""));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 40: Verify Detail guideline Area And Caution Text Are Displayed");
		assertTrue(managerCreateCampaignPage.isUploadCautionTextDisplayed("",""));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 41: Verify Required hashtags TextBox Area And Place Holder");
		assertTrue(managerCreateCampaignPage.isLabelAndPlaceHolderDisplayed("",""));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 42: Verify Required hashtags TextBox Area And Add hastags button are Displayed");
		assertTrue(managerCreateCampaignPage.isLabelAndButtonDisplayed("",""));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 43: Verify Required hashtags TextBox Area And Apply individual hashtags are Displayed");
		assertTrue(managerCreateCampaignPage.isLabelAndCheckBoxDisplayed("",""));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 44: Verify Optional hashtags TextBox Area");
		assertTrue(managerCreateCampaignPage.isLabelAndPlaceHolderDisplayed("",""));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 45: Verify Optional hashtags TextBox Area And Add hastags button are Displayed");
		assertTrue(managerCreateCampaignPage.isLabelAndButtonDisplayed("",""));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 46: Verify Person tags TextBox Area");
		assertTrue(managerCreateCampaignPage.isLabelAndPlaceHolderDisplayed("",""));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 47: Verify Person tags TextBox Area And Add hastags button are Displayed");
		assertTrue(managerCreateCampaignPage.isLabelAndButtonDisplayed("",""));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 48: Verify Receive information Area And Phone number Checkbox are Displayed");
		assertTrue(managerCreateCampaignPage.isLabelAndCheckboxDisplayed("",""));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 49: Verify Receive information Area And Shipping Information Checkbox are Displayed");
		assertTrue(managerCreateCampaignPage.isLabelAndCheckboxDisplayed("",""));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 50: Verify Receive information Area And Bank Account Checkbox are Displayed");
		assertTrue(managerCreateCampaignPage.isLabelAndCheckboxDisplayed("",""));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 51: Verify Survey 1 TextBox Area");
		assertTrue(managerCreateCampaignPage.isLabelAndPlaceHolderDisplayed("",""));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 52: Verify Survey 1 TextBox Area And Add surver button are Displayed");
		assertTrue(managerCreateCampaignPage.isLabelAndButtonDisplayed("",""));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 53: Verify Use of Content Lable And Use Radio Button");
		assertTrue(managerCreateCampaignPage.isLabelAndRadioButtonDisplayed("", ""));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 54: Verify Use of Content Lable And Nonuse Radio Button");
		assertTrue(managerCreateCampaignPage.isLabelAndRadioButtonDisplayed("", ""));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 55: Verify Boundaries Lable And Common license Radio Button");
		assertTrue(managerCreateCampaignPage.isLabelAndRadioButtonDisplayed("", ""));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 56: Verify Boundaries Lable And Commercial license Radio Button");
		assertTrue(managerCreateCampaignPage.isLabelAndRadioButtonDisplayed("", ""));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 57: Verify License Column Is Displayed In Boundaries Table");
		assertTrue(managerCreateCampaignPage.isColumNameDisplayed("", ""));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 58: Verify Boundaries Column Is Displayed In Boundaries Table");
		assertTrue(managerCreateCampaignPage.isColumNameDisplayed("", ""));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 59: Verify Content At Common license Row");
		assertTrue(managerCreateCampaignPage.isContentAtRowDisplayed("", ""));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 60: Verify Content At Commercial license Row");
		assertTrue(managerCreateCampaignPage.isContentAtRowDisplayed("", ""));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 61: Verify Periods Lable And 1 month Radio Button");
		assertTrue(managerCreateCampaignPage.isLabelAndRadioButtonDisplayed("", ""));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 62: Verify Periods Lable And 3 months Radio Button");
		assertTrue(managerCreateCampaignPage.isLabelAndRadioButtonDisplayed("", ""));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 63: Verify Periods Lable And 6 months Radio Button");
		assertTrue(managerCreateCampaignPage.isLabelAndRadioButtonDisplayed("", ""));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 64: Verify Periods Lable And 12 months Radio Button");
		assertTrue(managerCreateCampaignPage.isLabelAndRadioButtonDisplayed("", ""));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 65: Verify Schedule Title");
		assertTrue(managerCreateCampaignPage.isTitleAreaDisplayed(GlobalConstantsCreateCampaign.getGlobalConstantsCreateCampaign().getScheduleAreaTitleKR()));	
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 66: Verify Draft review Lable And Review Radio Button");
		assertTrue(managerCreateCampaignPage.isLabelAndRadioButtonDisplayed("", ""));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 67: Verify Draft review Lable And Not Review Radio Button");
		assertTrue(managerCreateCampaignPage.isLabelAndRadioButtonDisplayed("", ""));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 68: Verify Draft Reviewer Lable And Partner Radio Button");
		assertTrue(managerCreateCampaignPage.isLabelAndRadioButtonDisplayed("", ""));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 69: Verify Application TextBox Area And Start Date Datepicker");
		assertTrue(managerCreateCampaignPage.isLabelAndPlaceHolderDisplayed("",""));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 70: Verify Application TextBox Area And End Date Datepicker");
		assertTrue(managerCreateCampaignPage.isLabelAndPlaceHolderDisplayed("",""));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 71: Verify Selection TextBox Area And Start Date Datepicker");
		assertTrue(managerCreateCampaignPage.isLabelAndPlaceHolderDisplayed("",""));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 72: Verify Selection TextBox Area And End Date Datepicker");
		assertTrue(managerCreateCampaignPage.isLabelAndPlaceHolderDisplayed("",""));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 73: Verify Draft submit TextBox Area And Start Date Datepicker");
		assertTrue(managerCreateCampaignPage.isLabelAndPlaceHolderDisplayed("",""));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 74: Verify Draft submit TextBox Area And End Date Datepicker");
		assertTrue(managerCreateCampaignPage.isLabelAndPlaceHolderDisplayed("",""));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 75: Verify Content post TextBox Area And Start Date Datepicker");
		assertTrue(managerCreateCampaignPage.isLabelAndPlaceHolderDisplayed("",""));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 76: Verify Content post TextBox Area And End Date Datepicker");
		assertTrue(managerCreateCampaignPage.isLabelAndPlaceHolderDisplayed("",""));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 09: Verify Temporary Save Button");
		assertTrue(managerCreateCampaignPage.isTemporarySaveCreateButtonDisplayed(GlobalConstantsCreateCampaign.getGlobalConstantsCreateCampaign().getTemprorarySaveButtonKR()));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 10: Verify Create Button");
		assertTrue(managerCreateCampaignPage.isTemporarySaveCreateButtonDisplayed(GlobalConstantsCreateCampaign.getGlobalConstantsCreateCampaign().getCreateButtonKR()));
		
		ExtentTestManager.getTest().log(Status.INFO, "Campaign Registration Page - Step 10: Verify Preview Button");
		assertTrue(managerCreateCampaignPage.isPreviewButtonDisplayed(GlobalConstantsCreateCampaign.getGlobalConstantsCreateCampaign().getPreviewButtonKR()));
	}

	@Parameters({ "browser"})
	@AfterClass(alwaysRun = true)
	public void afterClass(String browserName) {
		ExtentTestManager.getTest().log(Status.INFO, "Close browser '" + browserName + "'");
		closeBrowserAndDriver();
	}
}
