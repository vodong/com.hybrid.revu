package com.revu.admin.tw;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
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
import commons.GlobalConstantsCreateBrandAdvertiser;
import commons.PageGeneratorManager;
import environmentConfig.Environment;
import pageObjects.revu.Admin.AdminDashBoardPageObject;
import pageObjects.revu.Admin.AdminHomePageObject;
import pageObjects.revu.Advertiser.AdvertiserDashBoardPageObject;
import pageObjects.revu.Partner.PartnerBrandManagementPageObject;
import pageObjects.revu.Partner.PartnerCreateBrandManagementPageObject;
import pageObjects.revu.Partner.PartnerDetailBrandManagementPageObject;
import reportConfig.ExtentTestManager;

public class Create_Edit_Login_Advertiser_Taiwan_Partner_Role extends BaseTest {

	WebDriver driver;
	AdminDashBoardPageObject adminDashBoardPage;
	AdminHomePageObject adminHomePage;
	PartnerBrandManagementPageObject partnerBrandManagementPage;
	AdvertiserDashBoardPageObject advertiserDashBoardPage;
	PartnerDetailBrandManagementPageObject partnerDetailBrandPage;
	PartnerCreateBrandManagementPageObject partnerCreateNewBrandPage;
	String partnerEmailAddress, getCurrentUrl, getCurrentPageID, representativeName, getCurrentUrlAfterRefesh;
	String imageAvatart = "Avatar.jpg";
	String brandName;

	Environment environment;

	@Parameters({ "envName", "serverName", "browser", "osName", "osVersion", "ipAddress", "portNumber" })
	@BeforeClass
	public void beforeClass(@Optional("local") String envName, @Optional("DEV") String serverName,
			@Optional("chrome") String browserName, @Optional("Windows") String osName,
			@Optional("10") String osVersion, @Optional("localhost") String ipAddress,
			@Optional("4444") String portNumber) {
		// Maven
//		String environmentName = System.getProperty("envMaven");
//		ConfigFactory.setProperty("envOwner", environmentName);
//		environment = ConfigFactory.create(Environment.class);
//		driver = getBrowserDriver(browserName, environment.appUrl());

		driver = getBrowserDriver(envName, serverName, browserName, osName, osVersion, ipAddress, portNumber);

		adminHomePage = PageGeneratorManager.getHomePage(driver);
		brandName = "Automation_Brand_" + generateNumber();
		partnerEmailAddress = "Automation_Email_" + generateNumber() + "@yopmail.com";
		representativeName = "Automation_Representative" + generateNumber();
	}

	@Test
	public void Partner_Role_TW_TC_01_Open_Admin_Page_And_Select_Country(Method method) {
		ExtentTestManager.startTest(method.getName(), "Open Admin Page And Select Country");
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 01: Open Country List");
		adminHomePage.openCountryList();

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 02: Select Country");
		adminHomePage.hoverCountryName(GlobalConstants.getGlobalConstants().getTaiwanCountry());

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 03: Select language");
		adminHomePage.selectLanguage(GlobalConstants.getGlobalConstants().getTaiwanLanguage());

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 04: Open Login Form");
		adminHomePage.openLoginPopup();
	}

	@Test
	public void Partner_Role_TW_TC_02_Login_To_DashBoard_Page(Method method) {
		ExtentTestManager.startTest(method.getName(), "Login To DasbhBoard Page");
		ExtentTestManager.getTest().log(Status.INFO, "Admin Page - Step 01: Enter Email'"
				+ GlobalConstants.getGlobalConstants().getEmailTaiwanPartnerRole() + "'");
		adminHomePage.enterToEmailTextbox(GlobalConstants.getGlobalConstants().getEmailTaiwanPartnerRole());

		ExtentTestManager.getTest().log(Status.INFO,
				"Admin Page - Step 02: Enter Password'" + GlobalConstants.getGlobalConstants().getPassword() + "'");
		adminHomePage.enterToPasswordTextbox(GlobalConstants.getGlobalConstants().getPassword());

		ExtentTestManager.getTest().log(Status.INFO, "Admin Page - Step 03: Click on Submit button");
		adminDashBoardPage = adminHomePage
				.openAdminDashBoardPage(GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getLoginButtonTW());

		ExtentTestManager.getTest().log(Status.INFO, "Admin Page - Step 04: Verify Login Successfull");
		assertTrue(adminDashBoardPage.isLogOutLinkDisplayed());
	}

	@Test
	public void Partner_Role_TW_TC_03_Check_Translate_To_Taiwan_Brand_Management_Page(Method method) {
		ExtentTestManager.startTest(method.getName(), "Check Translate To Taiwan At Brand Management Page");
		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 01: Click on 'Advertiser Brand Management Link");
		adminDashBoardPage.clickOnByMenuNameLink(driver,
				GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getAdvertiserManagementLinkTW());

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 02: Click on 'Brand Management Link");
		adminDashBoardPage.openByNameLink(driver, GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getBrandManagementLinkTW());
		partnerBrandManagementPage = PageGeneratorManager.getPartnerBrandMangementPage(driver);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 03: Verify Title Brand Management Page is Displayed");
		assertEquals(partnerBrandManagementPage.getTitlePageName(driver),
				GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getTitleBrandManagementPageTW());

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 04: Verify Place Holder Of Search Text Box is Taiwan Text");
		assertTrue(partnerBrandManagementPage
				.isSearchTextBoxDisplayed(GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getPlaceholderSearchTextBoxTW()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 05: Verify Brand column is Taiwan languages");
		assertTrue(partnerBrandManagementPage.isColumnNameDisplayed("品牌管理"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 06: Verify Email	column is Taiwan languages");
		assertTrue(partnerBrandManagementPage.isColumnNameDisplayed("電子信件"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 07: Verify Representative column is Taiwan languages");
		assertTrue(partnerBrandManagementPage.isColumnNameDisplayed("負責人"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 08: Verify Phone column is Taiwan languages");
		assertTrue(partnerBrandManagementPage.isColumnNameDisplayed("電話"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 09: Verify Camp. On-going column is Taiwan languages");
		assertTrue(partnerBrandManagementPage.isColumnNameDisplayed("專案進行中"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 10: Verify Camp. Completed column is Taiwan languages");
		assertTrue(partnerBrandManagementPage.isColumnNameDisplayed("專案完成"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 11: Verify Delete column is Taiwan languages");
		assertTrue(partnerBrandManagementPage.isColumnNameDisplayed("刪除品牌"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 12: Verify Delete button is Taiwan languages");
		assertTrue(partnerBrandManagementPage.isTextAtRowDisplayed("삭제", "1",
				GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getDeleteButtonAtRowTW()));
	}

	@Test
	public void Partner_Role_TW_TC_04_Check_Translate_To_English_Brand_Management_Page(Method method) {
		ExtentTestManager.startTest(method.getName(), "Check Translate To English At Brand Management Page");
		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 01: Change to English Language");
		partnerBrandManagementPage.openSelectLanguageList(driver,
				GlobalConstants.getGlobalConstants().getEnglishLangguage());

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 02: Verify Brand Management Page is Displayed");
		assertEquals(partnerBrandManagementPage.getTitlePageName(driver),
				GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getTitleBrandManagementPageEN());

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 03: Verify Place Holder Of Search Text Box is English Text");
		assertTrue(partnerBrandManagementPage
				.isSearchTextBoxDisplayed(GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getPlaceholderSearchTextBoxEN()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 04: Verify Brand column is English languages");
		assertTrue(partnerBrandManagementPage.isColumnNameDisplayed("Brand"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 05: Verify Email	column is English languages");
		assertTrue(partnerBrandManagementPage.isColumnNameDisplayed("Email"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 06: Verify Representative column is English languages");
		assertTrue(partnerBrandManagementPage.isColumnNameDisplayed("Representative"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 07: Verify Phone column is English languages");
		assertTrue(partnerBrandManagementPage.isColumnNameDisplayed("Phone"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 08: Verify Camp. On-going column is English languages");
		assertTrue(partnerBrandManagementPage.isColumnNameDisplayed("Camp. On-going"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 09: Verify Camp. Completed column is English languages");
		assertTrue(partnerBrandManagementPage.isColumnNameDisplayed("Camp. Completed"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 10: Verify Delete column is English languages");
		assertTrue(partnerBrandManagementPage.isColumnNameDisplayed("Delete"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 11: Verify Delete button is English languages");
		assertTrue(partnerBrandManagementPage.isTextAtRowDisplayed("Delete", "1",
				GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getDeleteButtonEN()));

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 12: Change to Taiwan Language");
		partnerBrandManagementPage.openSelectLanguageList(driver,
				GlobalConstants.getGlobalConstants().getTaiwanLanguage());
	}

	@Test
	public void Partner_Role_TW_TC_05_Check_Translate_To_Taiwan_Create_Brand_Page(Method method) {
		ExtentTestManager.startTest(method.getName(), "Check Translate To Taiwan At Create Brand Page");
		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 01: Click on 'Create a new Brand' Button");
		partnerBrandManagementPage
				.openCreateANewBrand(GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getCreateANewBrandButtonTW());
		partnerCreateNewBrandPage = PageGeneratorManager.getPartnerCreateANewBrandPage(driver);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 02: Verify Open 'Create New Brand Page' Successfull");
		assertEquals(partnerCreateNewBrandPage.getTitlePageName(driver),
				GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getTitleBrandManagementDetailPageTW());
		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 03: Verify Title of Company Information section translate to Taiwan");
		assertEquals(partnerCreateNewBrandPage.getTitleComPanyInformation(), "公司資訊");

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 04: Verify Title of Account Information section translate to Taiwan");
		assertEquals(partnerCreateNewBrandPage.getTitleAccountInformation(), "帳戶資訊");

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 05: Verify Profile area translate to Taiwan");
		assertTrue(partnerCreateNewBrandPage.isLabelByNameDisplayed("簡介"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 06: Verify Brand area translate to Taiwan");
		assertTrue(partnerCreateNewBrandPage.isPlaceHolderByLabelNameDisplayed("品牌",
				GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getPlaceholderTextBoxTW()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 07: Verify Account Setting area translate to Taiwan");
		assertTrue(partnerCreateNewBrandPage.isAccountSettingDisplayed("帳戶設定"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 08: Verify Use button translate to Taiwan");
		assertTrue(
				partnerCreateNewBrandPage.isButtonNameDisplayed(GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getUseButtonTW()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 09: Verify Nonuse button translate to Taiwan");
		assertTrue(partnerCreateNewBrandPage
				.isButtonNameDisplayed(GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getNonUseButtonTW()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 10: Verify Save button translate to Taiwan");
		assertTrue(partnerCreateNewBrandPage
				.isSaveButtonDisplayed(GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getSaveButtonTW()));

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 11: Verify Save button is disabled");
		assertFalse(
				partnerCreateNewBrandPage.isSaveButtonDisabled(GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getSaveButtonTW()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 13: Verify Account Information After Clicking On 'Use' Button");
		partnerCreateNewBrandPage.clickOnButtonByName(GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getUseButtonTW());

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 14: Verify Email area translate to Taiwan");
		assertTrue(partnerCreateNewBrandPage.isPlaceHolderByLabelNameDisplayed("電子信件",
				GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getPlaceholderTextBoxTW()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 15: Verify Password area translate to Taiwan");
		assertTrue(partnerCreateNewBrandPage.isLabelByNameDisplayed("密碼"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 16: Verify Password Setting button translate to Taiwan");
		assertEquals(partnerCreateNewBrandPage.getTextResetPasswordButton(),
				GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getPasswordSettingTW());

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 17: Verify Representative area translate to Taiwan");
		assertTrue(partnerCreateNewBrandPage.isPlaceHolderByLabelNameDisplayed("負責人",
				GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getPlaceholderTextBoxTW()));

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 18: Input Representative");
		partnerCreateNewBrandPage.enterToRepresentativeTextBox(representativeName);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 19: Verify Phone area translate to Taiwan");
		assertTrue(partnerCreateNewBrandPage.isPlaceHolderByLabelNameDisplayed("電話",
				GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getPlaceholderPhoneTextBoxTW()));

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 20: Verify Refesh Current Page");
		partnerCreateNewBrandPage.refeshCurrentPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 21: Verify Save button is disabled");
		assertFalse(
				partnerCreateNewBrandPage.isSaveButtonDisabled(GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getSaveButtonTW()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 22: Verify Account Information After Clicking On 'Use' Button");
		partnerCreateNewBrandPage.clickOnButtonByName(GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getUseButtonTW());

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 24: Click on Password Setting Button");
		partnerCreateNewBrandPage
				.clickToPasswordSettingButton(GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getPasswordSettingTW());

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 25: Verify Passwors Setting will be changed to Cancel Setting");
		assertEquals(partnerCreateNewBrandPage.getTextResetPasswordButton(),
				GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getCancelSettingTW());

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 26: Enter Password '"
				+ GlobalConstants.getGlobalConstants().getPassword() + "'");
		partnerCreateNewBrandPage.enterToPasswordTextBox(GlobalConstants.getGlobalConstants().getPassword());

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 27: Enter Confirm Password is not match '"
						+ GlobalConstants.getGlobalConstants().getIncorrectPassword() + "'");
		partnerCreateNewBrandPage
				.enterToConfirmPasswordTextBox(GlobalConstants.getGlobalConstants().getIncorrectPassword());

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 28: Click on 'Save' Button");
		partnerCreateNewBrandPage.clickSaveButton(GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getSaveButtonTW());

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 29: Verify Error Message At Brand Name textbox translate to Taiwan");
		assertEquals(partnerCreateNewBrandPage.getErrorMessageAtBrandNameTextBox(), "此欄位為必填。");

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 30: Verify Error Message At Email textbox translate to Taiwan");
		assertEquals(partnerCreateNewBrandPage.getErrorMessageAtEmailTextBox(), "此欄位為必填。");

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 31: Verify Error Message At Confirm Password textbox translate to Taiwan");
		assertEquals(partnerCreateNewBrandPage.getErrorMessageAtConfirmPasswordTextBox(), "確認不相符.");

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 32: Enter To Email TextBox Wrong Email Format");
		partnerCreateNewBrandPage.enterToEmailTextBox(GlobalConstants.getGlobalConstants().getWrongEmailFormat());

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 33: Click On Save Button");
		partnerCreateNewBrandPage.clickSaveButton(GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getSaveButtonTW());

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 34: Verify Error Message At Email textbox translate to Taiwan When Inputting Wrong Email Format");
		assertEquals(partnerCreateNewBrandPage.getErrorMessageAtEmailTextBox(), "無效的輸入.");
	}

	@Test
	public void Partner_Role_TW_TC_06_Check_Translate_To_English_Create_Brand_Page(Method method) {
		ExtentTestManager.startTest(method.getName(), "Check Translate To English At Create Brand Page");
		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 01: Refresh Current Page");
		partnerCreateNewBrandPage.refeshCurrentPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 02: Change to English Language");
		partnerCreateNewBrandPage.openSelectLanguageList(driver,
				GlobalConstants.getGlobalConstants().getEnglishLangguage());

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 03: Verify Title of Company Information section translate to English");
		assertEquals(partnerCreateNewBrandPage.getTitlePageName(driver), "Brand Information");

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 04: Verify Open 'Create New Brand Page' Successfull");
		assertEquals(partnerCreateNewBrandPage.getTitleComPanyInformation(), "Company Information");

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 05: Verify Title of Account Information section translate to English");
		assertEquals(partnerCreateNewBrandPage.getTitleAccountInformation(), "Account Information");

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 06: Verify Profile area translate to English");
		assertTrue(partnerCreateNewBrandPage.isLabelByNameDisplayed("Profile"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 07: Verify Brand area translate to English");
		assertTrue(partnerCreateNewBrandPage.isPlaceHolderByLabelNameDisplayed("Brand",
				GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getPlaceholderTextBoxEN()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 08: Verify Account Setting area translate to English");
		assertTrue(partnerCreateNewBrandPage.isAccountSettingDisplayed("Account Setting"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 09: Verify Use button translate to English");
		assertTrue(
				partnerCreateNewBrandPage.isButtonNameDisplayed(GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getUseButtonEN()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 10: Verify Nonuse button translate to English");
		assertTrue(partnerCreateNewBrandPage
				.isButtonNameDisplayed(GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getNonUseButtonEN()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 11: Verify Save button translate to English");
		assertTrue(partnerCreateNewBrandPage
				.isSaveButtonDisplayed(GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getSaveButtonEN()));

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 12: Verify Save button is disabled");
		assertFalse(
				partnerCreateNewBrandPage.isSaveButtonDisabled(GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getSaveButtonEN()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 13: Verify Account Information After Clicking On 'Use' Button");
		partnerCreateNewBrandPage.clickOnButtonByName(GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getUseButtonEN());

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 14: Verify Email area translate to English");
		assertTrue(partnerCreateNewBrandPage.isPlaceHolderByLabelNameDisplayed("Email",
				GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getPlaceholderTextBoxEN()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 15: Verify Password area translate to English");
		assertTrue(partnerCreateNewBrandPage.isLabelByNameDisplayed("Password"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 16: Verify Reset Password button translate to English");
		assertEquals(partnerCreateNewBrandPage.getTextResetPasswordButton(),
				GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getPasswordSettingEN());

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 17: Verify Representative area translate to English");
		assertTrue(partnerCreateNewBrandPage.isPlaceHolderByLabelNameDisplayed("Representative",
				GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getPlaceholderTextBoxEN()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 18: Verify Phone area translate to English");
		assertTrue(partnerCreateNewBrandPage.isPlaceHolderByLabelNameDisplayed("Phone",
				GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getPlaceholderPhoneTextBoxEN()));

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 19: Verify Refesh Current Page");
		partnerCreateNewBrandPage.refeshCurrentPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 20: Verify Save button is disabled");
		assertFalse(
				partnerCreateNewBrandPage.isSaveButtonDisabled(GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getSaveButtonEN()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 21: Verify Account Information After Clicking On 'Use' Button");
		partnerCreateNewBrandPage.clickOnButtonByName(GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getUseButtonEN());

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 22: Click On Password Setting Button");
		partnerCreateNewBrandPage
				.clickToPasswordSettingButton(GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getPasswordSettingEN());

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 23: Verify Reset Password will be changed to Cancel Setting");
		assertEquals(partnerCreateNewBrandPage.getTextResetPasswordButton(),
				GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getCancelSettingEN());

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 24: Enter Password '"
				+ GlobalConstants.getGlobalConstants().getPassword() + "'");
		partnerCreateNewBrandPage.enterToPasswordTextBox(GlobalConstants.getGlobalConstants().getPassword());

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 25: Enter Confirm Password is not match '"
						+ GlobalConstants.getGlobalConstants().getIncorrectPassword() + "'");
		partnerCreateNewBrandPage
				.enterToConfirmPasswordTextBox(GlobalConstants.getGlobalConstants().getIncorrectPassword());

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 26: Click on 'Save' Button");
		partnerCreateNewBrandPage.clickSaveButton(GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getSaveButtonEN());

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 27: Verify Error Message At Brand Name textbox translate to English");
		assertEquals(partnerCreateNewBrandPage.getErrorMessageAtBrandNameTextBox(), "This field is required.");

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 28: Verify Error Message At Confirm Password textbox translate to English");
		assertEquals(partnerCreateNewBrandPage.getErrorMessageAtConfirmPasswordTextBox(),
				"The confirmation does not match.");

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 29: Verify Error Message At Email textbox translate to English");
		assertEquals(partnerCreateNewBrandPage.getErrorMessageAtEmailTextBox(),
				"The email field is required when account setting is use.");

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 30: Enter To Email TextBox Wrong Email Format");
		partnerCreateNewBrandPage.enterToEmailTextBox(GlobalConstants.getGlobalConstants().getWrongEmailFormat());

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 31: Click On Save Button");
		partnerCreateNewBrandPage.clickSaveButton(GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getSaveButtonEN());

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 32: Verify Error Message At Email textbox translate to Taiwan When Inputting Wrong Email Format");
		assertEquals(partnerCreateNewBrandPage.getErrorMessageAtEmailTextBox(),
				"The email must be a valid email address.");
	}

	@Test
	public void Partner_Role_TW_TC_07_Create_Brand_Non_Use_Option(Method method) {
		ExtentTestManager.startTest(method.getName(), "Create Brand By Nonuse Option");
		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 01: Refesh Current Page");
		partnerCreateNewBrandPage.refeshCurrentPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 02: Change to Taiwan Language");
		partnerCreateNewBrandPage.openSelectLanguageList(driver,
				GlobalConstants.getGlobalConstants().getTaiwanLanguage());

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 03: Upload Avatar");
		partnerCreateNewBrandPage.upLoadMultipleFiles(driver, imageAvatart);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 04: Verify Image Is Uploaded Successfully");
		assertTrue(partnerCreateNewBrandPage.isAvatarUpLoaded());

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 05: Input Brand Name '" + brandName + "'");
		partnerCreateNewBrandPage.enterToBrandNameTextBox(brandName);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 06: Click on 'Save' button");
		partnerCreateNewBrandPage.clickSaveButton(GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getSaveButtonTW());
		partnerBrandManagementPage = PageGeneratorManager.getPartnerBrandMangementPage(driver);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management - Step 07: Verify Brand has just been created in Brand Management list");
		assertTrue(partnerBrandManagementPage.isTextCreatedBrandAtRowDisplayed("브랜드명", "1", brandName));

	}

	@Test
	public void Partner_Role_TW_TC_08_Delete_Brand_Advertiser_Do_Not_Have_CamPaign(Method method) {
		ExtentTestManager.startTest(method.getName(), "Delete Brand Do Not Have Campaign");
		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 01: Input Brand Name '" + brandName + "'");
		partnerBrandManagementPage.enterToSearchBrandTextBox(brandName);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 03: Click on Delete Button");
		partnerBrandManagementPage.clickToDeleteButtonByRownNumber("1",
				GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getDeleteButtonAtRowTW());

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 04: Verify Message Popup is Displayed");
		assertTrue(partnerBrandManagementPage.isPopupDisplayed());

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 05: Verify Message Popup translate to English");
		partnerBrandManagementPage.openSelectLanguageList(driver,
				GlobalConstants.getGlobalConstants().getEnglishLangguage());
		assertEquals(partnerBrandManagementPage.getTitlePopup(), "Delete Brand");
		assertEquals(partnerBrandManagementPage.getTextMessage(),
				"Are you sure you want to delete this brand? You can't undo this action.");
		assertEquals(partnerBrandManagementPage.getDeleteButtonText(), "Delete");
		assertEquals(partnerBrandManagementPage.getCancelButtonText(), "Cancel");

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 06: Verify Message Popup translate to Taiwan");
		partnerBrandManagementPage.openSelectLanguageList(driver,
				GlobalConstants.getGlobalConstants().getTaiwanLanguage());
		assertEquals(partnerBrandManagementPage.getTitlePopup(), "刪除品牌");
		assertEquals(partnerBrandManagementPage.getTextMessage(), "您確定想要刪除這個品牌？您將無法回復此步驟。");
		assertEquals(partnerBrandManagementPage.getDeleteButtonText(), "刪除");
		assertEquals(partnerBrandManagementPage.getCancelButtonText(), "取消");

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 07: Close Popup By X Icon");
		partnerBrandManagementPage.clickToClosePopupByIcon();

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 08: Click To Delete Button");
		partnerBrandManagementPage.clickToDeleteButtonByRownNumber("1",
				GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getDeleteButtonAtRowTW());

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 09: Close Popup By Clicking On Cancel Button");
		partnerBrandManagementPage.clickToClosePopupCancelButton();

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 10: Delete Brand");
		partnerBrandManagementPage.clickToDeleteButtonByRownNumber("1",
				GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getDeleteButtonAtRowTW());
		partnerBrandManagementPage.clickToDeleteButton();

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 12: Refesh Current Page");
		partnerBrandManagementPage.refeshCurrentPage(driver);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 11: Click on 'Advertiser Management Link");
		partnerBrandManagementPage.clickOnByMenuNameLink(driver,
				GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getAdvertiserManagementLinkTW());

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 12: Click on 'Brand Management Link");
		partnerBrandManagementPage.openByNameLink(driver,
				GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getBrandManagementLinkTW());

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 13: Verify Brand Is Deleted '" + brandName + "'");
		assertNotEquals(partnerBrandManagementPage.getBrandNameByRownNumber("1", "1"), brandName);
	}

	@Test
	public void Partner_Role_TW_TC_09_Create_Brand_Use_Option(Method method) {
		ExtentTestManager.startTest(method.getName(), "Create Brand By Use Option");
		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 01: Open Create A New Brand Page");
		partnerBrandManagementPage
				.openCreateANewBrand(GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getCreateANewBrandButtonTW());

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 02: Upload Avatar");
		partnerCreateNewBrandPage.upLoadMultipleFiles(driver, imageAvatart);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 03: Verify Image Upload Successfully");
		assertTrue(partnerCreateNewBrandPage.isAvatarUpLoaded());

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 04: Input Brand Name '" + brandName + "'");
		partnerCreateNewBrandPage.enterToBrandNameTextBox(brandName);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 05: Click on 'Use' button");
		partnerCreateNewBrandPage.clickOnButtonByName(GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getUseButtonTW());

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 06: Input Email '" + partnerEmailAddress + "'");
		partnerCreateNewBrandPage.enterToEmailTextBox(partnerEmailAddress);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 07: Click On Password Setting Button");
		partnerCreateNewBrandPage
				.clickToPasswordSettingButton(GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getPasswordSettingTW());

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 08: Input Password '"
				+ GlobalConstants.getGlobalConstants().getPassword() + "'");
		partnerCreateNewBrandPage.enterToPasswordTextBox(GlobalConstants.getGlobalConstants().getPassword());

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 09: Input Confirm Password '"
				+ GlobalConstants.getGlobalConstants().getPassword() + "'");
		partnerCreateNewBrandPage.enterToConfirmPasswordTextBox(GlobalConstants.getGlobalConstants().getPassword());

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 10: Click on 'Save' button");
		partnerCreateNewBrandPage.clickSaveButton(GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getSaveButtonTW());
		partnerBrandManagementPage = PageGeneratorManager.getPartnerBrandMangementPage(driver);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management - Step 11: Verify Brand has just been created in Brand Management list");
		partnerBrandManagementPage.isTextCreatedBrandAtRowDisplayed("브랜드명", "1", brandName);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 12: Delete Brand");
		partnerBrandManagementPage.clickToDeleteButtonByRownNumber("1",
				GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getDeleteButtonAtRowTW());

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 13: Close Delete Brand Popup");
		partnerBrandManagementPage.clickToClosePopupCancelButton();
	}

	@Test
	public void Partner_Role_TW_TC_10_Delete_Brand_Advertiser_Has_CamPaign(Method method) {
		ExtentTestManager.startTest(method.getName(), "Delete Brand Has Campaign");
		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 01: Search Brand '"
				+ GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getBrandNameHasCampaignPartnerRoleTW() + "'");
		partnerBrandManagementPage
				.enterToSearchBrandTextBox(GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getBrandNameHasCampaignPartnerRoleTW());

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 03: Click on Delete Button");
		partnerBrandManagementPage.clickToDeleteButtonByRownNumber("1",
				GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getDeleteButtonAtRowTW());

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 04: Verify Message Popup is Displayed");
		assertTrue(partnerBrandManagementPage.isPopupDisplayed());

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 05: Change to English Language");
		partnerBrandManagementPage.openSelectLanguageList(driver,
				GlobalConstants.getGlobalConstants().getEnglishLangguage());

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 06: Verify Message Popup translate to English");
		assertEquals(partnerBrandManagementPage.getTitlePopup(), "Delete Brand");
		assertEquals(partnerBrandManagementPage.getTextMessage(),
				"You cannot delete the brand that has any campaign history.");
		assertEquals(partnerBrandManagementPage.getDeleteButtonText(), "Confirm");

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 07: Change to Taiwan Language");
		partnerBrandManagementPage.openSelectLanguageList(driver,
				GlobalConstants.getGlobalConstants().getTaiwanLanguage());

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 08: Verify Message Popup translate to Taiwan");
		assertEquals(partnerBrandManagementPage.getTitlePopup(), "刪除品牌");
		assertEquals(partnerBrandManagementPage.getTextMessage(), "您無法刪除具有任何專案活動記錄的品牌。");
		assertEquals(partnerBrandManagementPage.getDeleteButtonText(), "確認");

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 09: Click On Confirm Button");
		partnerBrandManagementPage.clickToDeleteButton();

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 10: Verify Brand Is Not Deleted");
		assertEquals(partnerBrandManagementPage.getBrandNameByRownNumber("1", "1"),
				GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getBrandNameHasCampaignPartnerRoleTW());
	}

	@Test
	public void Partner_Role_TW_TC_11_Edit_Brand_Information(Method method) {
		ExtentTestManager.startTest(method.getName(), "Edit Brand Information");
		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 01: Refesh Page");
		partnerBrandManagementPage.refeshCurrentPage(driver);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 02: Click on 'Advertiser Brand Management Link");
		partnerBrandManagementPage.clickOnByMenuNameLink(driver,
				GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getAdvertiserManagementLinkTW());

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 03: Click on 'Brand Management Link");
		partnerBrandManagementPage.openByNameLink(driver,
				GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getBrandManagementLinkTW());

//		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 04: Get Title Current Page");
//		getCurrentUrl = partnerBrandManagementPage.getPageUrl(driver);
//		System.out.println("TC 11 " + getCurrentUrl);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 05: Refesh Current Page");
		partnerBrandManagementPage.refeshCurrentPage(driver);

//		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 06: Get Title Current Page After Reloading");
//		getCurrentUrlAfterRefesh = partnerBrandManagementPage.getPageUrl(driver);
//		System.out.println("TC 11 " + getCurrentUrlAfterRefesh);
//		adminHomePage = PageGeneratorManager.getHomePage(driver);

//		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 07: Compare Previous Title To Current Page After Reloading");
//		if(partnerBrandManagementPage.isOpenLoginLinkDisplayed()) {
//			adminHomePage.openLoginPopup();
//			partnerBrandManagementPage = adminHomePage.openBrandManagementPartnerPage(GlobalConstants.getGlobalConstants().getLoginButtonTW());
//			ExtentTestManager.getTest().log(Status.INFO,
//					"Brand Management Page - Step 08: Click on 'Create a new Brand' Button");
//			partnerBrandManagementPage.openCreateANewBrand(GlobalConstants.getGlobalConstants().getCreateANewBrandButtonTW());
//			partnerCreateNewBrandPage = PageGeneratorManager.getPartnerCreateANewBrandPage(driver);
//		}else {
//			ExtentTestManager.getTest().log(Status.INFO,
//					"Brand Management Page - Step 08: Click on 'Create a new Brand' Button");
//			partnerBrandManagementPage.openCreateANewBrand(GlobalConstants.getGlobalConstants().getCreateANewBrandButtonTW());
//			partnerCreateNewBrandPage = PageGeneratorManager.getPartnerCreateANewBrandPage(driver);
//		}

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 08: Click on 'Create a new Brand' Button");
		partnerBrandManagementPage
				.openCreateANewBrand(GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getCreateANewBrandButtonTW());
		partnerCreateNewBrandPage = PageGeneratorManager.getPartnerCreateANewBrandPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 09: Upload Avatar");
		partnerCreateNewBrandPage.upLoadMultipleFiles(driver, imageAvatart);
		assertTrue(partnerCreateNewBrandPage.isAvatarUpLoaded());

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 10: Input Brand Name");
		partnerCreateNewBrandPage.enterToBrandNameTextBox(brandName);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 11: Click on 'Save' button");
		partnerCreateNewBrandPage.clickSaveButton(GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getSaveButtonTW());
		partnerBrandManagementPage = PageGeneratorManager.getPartnerBrandMangementPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 12: Search Brand '" + brandName + "'");
		partnerBrandManagementPage.enterToSearchBrandTextBox(brandName);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 13: Click on Search Button");
		partnerBrandManagementPage.clickToSearchButton();

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 14: Open Brand Information Detail Page");
		partnerBrandManagementPage.clickToBrandNameByRownNumber("1", brandName);
		partnerDetailBrandPage = PageGeneratorManager.getPartnerDetailBrandPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 15: Get Current Page URL");
		getCurrentUrl = partnerDetailBrandPage.getPageUrl(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 16: Get Current Page ID");
		getCurrentPageID = partnerDetailBrandPage.getParentID(driver);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management - Step 17: Verify Brand Information Detail Page");
		assertEquals(partnerDetailBrandPage.getSeeBrandTextButton(),
				GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getSeeBrandButtonTW());

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 18: Open See Brand Partner Page");
		partnerDetailBrandPage.clickToSeeBrandPageButton();

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 19: Switch To Advertiser Page");
		partnerDetailBrandPage.switchTab(GlobalConstants.getGlobalConstants().getAdvertiserTestUrl());
		advertiserDashBoardPage = PageGeneratorManager.getAdvertiserDashBoardPage(driver);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management - Step 20: Verify Advertiser Name '" + brandName + "'");
		assertEquals(advertiserDashBoardPage.getPartnerName(), brandName);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 21: Switch To Edit Brand Page");
		advertiserDashBoardPage.switchTab(getCurrentUrl);
		partnerDetailBrandPage = PageGeneratorManager.getPartnerDetailBrandPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 22: Close Advertiser Page");
		advertiserDashBoardPage.closeTab(getCurrentPageID);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management - Step 23: Verify Change To Brand Information Successfully");
		assertEquals(partnerDetailBrandPage.getSeeBrandTextButton(),
				GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getSeeBrandButtonTW());

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 24: Click on Use Button");
		partnerDetailBrandPage.clickOnButtonByName(GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getUseButtonTW());

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management - Step 25: Enter Emaill Address'" + partnerEmailAddress + "'");
		partnerDetailBrandPage.enterToEmailTextBox(partnerEmailAddress);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 26: Open Setting Password");
		partnerDetailBrandPage
				.clickToPasswordSettingButton(GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getPasswordSettingTW());

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 27: Enter To Password TextBox");
		partnerDetailBrandPage.enterToPasswordTextBox(GlobalConstants.getGlobalConstants().getPassword());

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 28: Enter To Confirm Password TextBox");
		partnerDetailBrandPage.enterToConfirmPasswordTextBox(GlobalConstants.getGlobalConstants().getPassword());

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 29: Click On Save Button");
		partnerDetailBrandPage.clickSaveButton(GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getSaveButtonTW());

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management - Step 30: Verify Email Alerady Exists In System Taiwan Language");
		assertEquals(partnerDetailBrandPage.getErrorMessageAtEmailTextBox(), "此信箱已註冊");

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 31: Change To English Language");
		partnerDetailBrandPage.openSelectLanguageList(driver,
				GlobalConstants.getGlobalConstants().getEnglishLangguage());

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management - Step 32: Verify Email Alerady Exists In System English Language");
		assertEquals(partnerDetailBrandPage.getErrorMessageAtEmailTextBox(), "The email has already been taken.");

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 33: Change To Taiwan Language");
		partnerDetailBrandPage.openSelectLanguageList(driver, GlobalConstants.getGlobalConstants().getTaiwanLanguage());

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 34: Log Out Manager Account");
		partnerDetailBrandPage.clickOnLogOutButton();
		adminHomePage = PageGeneratorManager.getHomePage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 35: Verify Login Page");
		assertTrue(adminHomePage.isLoginButtonDisplayed());

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 36: Open Login Form");
		adminHomePage.openLoginPopup();

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 37: Switch To Advertiser Tab");
		adminHomePage.clickToAdvertiserTab("客戶");

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 38: Enter To Email TextBox");
		adminHomePage.enterToEmailAdvertiserTextBox(partnerEmailAddress);

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 39: Enter To Password TextBox");
		adminHomePage.enterToPasswordAdvertiserTextBox(GlobalConstants.getGlobalConstants().getPassword());

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 40: Open Advertiser Page");
		advertiserDashBoardPage = adminHomePage
				.openAdvertiserPage(GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getLoginButtonTW());
		advertiserDashBoardPage = PageGeneratorManager.getAdvertiserDashBoardPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 41: Open Advertiser Page Successfull");
		assertTrue(advertiserDashBoardPage.isDeliveryMenuDisplayed());
	}

	@Parameters({ "browser" })
	@AfterClass(alwaysRun = true)
	public void afterClass(String browserName) {
		ExtentTestManager.getTest().log(Status.INFO, "Close browser '" + browserName + "'");
		closeBrowserAndDriver();
	}
}
