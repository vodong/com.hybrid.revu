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
import pageObjects.revu.Manager.ManagerBrandManagementPageObject;
import pageObjects.revu.Manager.ManagerCreateBrandManagementPageObject;
import pageObjects.revu.Manager.ManagerDetailBrandManagementPageObject;
import reportConfig.ExtentTestManager;

public class Create_Edit_Login_Advertiser_Taiwan_Manager_Role extends BaseTest {

	WebDriver driver;
	AdminDashBoardPageObject adminDashBoardPage;
	AdminHomePageObject adminHomePage;
	ManagerBrandManagementPageObject adminBrandManagementPage;
	AdvertiserDashBoardPageObject advertiserDashBoardPage;
	ManagerDetailBrandManagementPageObject adminDetailBrandPage;
	ManagerCreateBrandManagementPageObject adminCreateNewBrandPage;
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

		driver = getBrowserDriver(envName, serverName, browserName, osName, osVersion, ipAddress, portNumber);

		adminHomePage = PageGeneratorManager.getHomePage(driver);
		brandName = "Automation_Brand_" + generateNumber();
		partnerEmailAddress = "Automation_Email_" + generateNumber() + "@yopmail.com";
		representativeName = "Automation_Representative" + generateNumber();
	}

	@Test
	public void Manager_Role_TW_TC_01_Open_Admin_Page_And_Select_Country(Method method) {
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
	public void Manager_Role_TW_TC_02_Login_To_DashBoard_Page(Method method) {
		ExtentTestManager.startTest(method.getName(), "Login To DasbhBoard Page");
		ExtentTestManager.getTest().log(Status.INFO,
				"Admin Page - Step 01: Enter Email'" + GlobalConstants.getGlobalConstants().getEmailTaiwanManagerRole() + "'");
		adminHomePage.enterToEmailTextbox(GlobalConstants.getGlobalConstants().getEmailTaiwanManagerRole());

		ExtentTestManager.getTest().log(Status.INFO,
				"Admin Page - Step 02: Enter Password'" + GlobalConstants.getGlobalConstants().getPassword() + "'");
		adminHomePage.enterToPasswordTextbox(GlobalConstants.getGlobalConstants().getPassword());

		ExtentTestManager.getTest().log(Status.INFO, "Admin Page - Step 03: Click on Submit button");
		adminDashBoardPage = adminHomePage.openAdminDashBoardPage( GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getLoginButtonTW());

		ExtentTestManager.getTest().log(Status.INFO, "Admin Page - Step 04: Verify Login Successfull");
		assertTrue(adminDashBoardPage.isLogOutLinkDisplayed());
	}

	@Test
	public void Manager_Role_TW_TC_03_Check_Translate_To_Taiwan_Brand_Management_Page(Method method) {
		ExtentTestManager.startTest(method.getName(), "Check Translate To Taiwan At Brand Management Page");
		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 01: Click on 'Advertiser Brand Management Link");
		adminDashBoardPage.clickOnByMenuNameLink(driver,  GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getAdvertiserManagementLinkTW());

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 02: Click on 'Brand Management Link");
		adminDashBoardPage.openByNameLink(driver,  GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getBrandManagementLinkTW());
		adminBrandManagementPage = PageGeneratorManager.getManagementPage(driver);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 03: Verify Title Brand Management Page is Displayed");
		assertEquals(adminBrandManagementPage.getTitlePageName(driver),
				 GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getTitleBrandManagementPageTW());

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 04: Verify Brand label is Taiwan languages");
		assertTrue(adminBrandManagementPage.isPlaceHolderDisplayed("??????",  GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getPlaceholderTextBoxTW()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 05: Verify Representative label is Taiwan languages");
		assertTrue(adminBrandManagementPage.isPlaceHolderDisplayed("?????????",  GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getPlaceholderTextBoxTW()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 06: Verify Partner label is Taiwan languages");
		assertTrue(adminBrandManagementPage.isPlaceHolderDisplayed("????????????",  GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getPlaceholderTextBoxTW()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 07: Verify Email label is Taiwan languages");
		assertTrue(adminBrandManagementPage.isPlaceHolderDisplayed("????????????",  GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getPlaceholderTextBoxTW()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 08: Verify Phone label is Taiwan languages");
		assertTrue(adminBrandManagementPage.isPlaceHolderDisplayed("??????",
				 GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getPlaceholderPhoneTextBoxTW()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 09: Verify Search button is Taiwan languages");
		assertTrue(adminBrandManagementPage.isButtonDisplayed( GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getSearchButtonAtSearchFilterTW()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 10: Verify Reset button is Taiwan languages");
		assertTrue(adminBrandManagementPage.isButtonDisplayed( GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getResetButtonAtSearchFilterTW()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 11: Verify Brand No. column is Taiwan languages");
		assertTrue(adminBrandManagementPage.isColumnNameDisplayed("????????????"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 12: Verify Partner column is Taiwan languages");
		assertTrue(adminBrandManagementPage.isColumnNameDisplayed("????????????"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 13: Verify Brand column is Taiwan languages");
		assertTrue(adminBrandManagementPage.isColumnNameDisplayed("????????????"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 14: Verify Email	column is Taiwan languages");
		assertTrue(adminBrandManagementPage.isColumnNameDisplayed("????????????"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 15: Verify Representative column is Taiwan languages");
		assertTrue(adminBrandManagementPage.isColumnNameDisplayed("?????????"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 16: Verify Phone column is Taiwan languages");
		assertTrue(adminBrandManagementPage.isColumnNameDisplayed("??????"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 17: Verify Camp. On-going column is Taiwan languages");
		assertTrue(adminBrandManagementPage.isColumnNameDisplayed("???????????????"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 18: Verify Camp. Completed column is Taiwan languages");
		assertTrue(adminBrandManagementPage.isColumnNameDisplayed("????????????"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 19: Verify Date of Creation column is Taiwan languages");
		assertTrue(adminBrandManagementPage.isColumnNameDisplayed("????????????"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 20: Verify Delete column is Taiwan languages");
		assertTrue(adminBrandManagementPage.isColumnNameDisplayed("??????"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 21: Verify Delete button is Taiwan languages");
		assertTrue(adminBrandManagementPage.isTextAtRowDisplayed("??????", "1",
				 GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getDeleteButtonAtRowTW()));
	}

	@Test
	public void Manager_Role_TW_TC_04_Check_Translate_To_English_Brand_Management_Page(Method method) {
		ExtentTestManager.startTest(method.getName(), "Check Translate To English At Brand Management Page");
		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 01: Change to English Language");
		adminBrandManagementPage.openSelectLanguageList(driver, GlobalConstants.getGlobalConstants().getEnglishLangguage());

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 02: Verify Brand Management Page is Displayed");
		assertEquals(adminBrandManagementPage.getTitlePageName(driver),
				 GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getTitleBrandManagementPageEN());

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 03: Verify Brand label is English languages");
		assertTrue(
				adminBrandManagementPage.isPlaceHolderDisplayed("Brand",  GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getPlaceholderTextBoxEN()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 04: Verify Representative label is English languages");
		assertTrue(adminBrandManagementPage.isPlaceHolderDisplayed("Representative",
				 GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getPlaceholderTextBoxEN()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 05: Verify Partner label is English languages");
		assertTrue(
				adminBrandManagementPage.isPlaceHolderDisplayed("Partner", GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getPlaceholderTextBoxEN()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 06: Verify Email label is English languages");
		assertTrue(
				adminBrandManagementPage.isPlaceHolderDisplayed("Email", GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getPlaceholderTextBoxEN()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 07: Verify Phone label is English languages");
		assertTrue(adminBrandManagementPage.isPlaceHolderDisplayed("Phone",
				 GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getPlaceholderPhoneTextBoxEN()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 08: Verify Search button is English languages");
		assertTrue(adminBrandManagementPage.isButtonDisplayed( GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getSearchButtonAtSearchFilterEN()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 09: Verify Reset button is English languages");
		assertTrue(adminBrandManagementPage.isButtonDisplayed( GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getResetButtonAtSearchFilterEN()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 10: Verify Brand No. column is English languages");
		assertTrue(adminBrandManagementPage.isColumnNameDisplayed("Brand No."));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 11: Verify Partner column is English languages");
		assertTrue(adminBrandManagementPage.isColumnNameDisplayed("Partner"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 12: Verify Brand column is English languages");
		assertTrue(adminBrandManagementPage.isColumnNameDisplayed("Brand"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 13: Verify Email	column is English languages");
		assertTrue(adminBrandManagementPage.isColumnNameDisplayed("Email"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 14: Verify Representative column is English languages");
		assertTrue(adminBrandManagementPage.isColumnNameDisplayed("Representative"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 15: Verify Phone column is English languages");
		assertTrue(adminBrandManagementPage.isColumnNameDisplayed("Phone"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 16: Verify Camp. On-going column is English languages");
		assertTrue(adminBrandManagementPage.isColumnNameDisplayed("Camp. On-going"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 17: Verify Camp. Completed column is English languages");
		assertTrue(adminBrandManagementPage.isColumnNameDisplayed("Camp. Completed"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 18: Verify Date of Creation column is English languages");
		assertTrue(adminBrandManagementPage.isColumnNameDisplayed("Date of Creation"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 19: Verify Delete column is English languages");
		assertTrue(adminBrandManagementPage.isColumnNameDisplayed("Delete"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 20: Verify Delete button is English languages");
		assertTrue(adminBrandManagementPage.isTextAtRowDisplayed("Delete", "1",
				 GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getDeleteButtonEN()));

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 21: Change to Taiwan Language");
	}

	@Test
	public void Manager_Role_TW_TC_05_Check_Translate_To_Taiwan_Create_Brand_Page(Method method) {
		ExtentTestManager.startTest(method.getName(), "Check Translate To Taiwan At Create Brand Page");
		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 01: Click on 'Create a new Brand' Button");
		adminBrandManagementPage.openCreateANewBrand( GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getCreateANewBrandButtonTW());
		adminCreateNewBrandPage = PageGeneratorManager.getCreateANewBrandPage(driver);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 02: Verify Open 'Create New Brand Page' Successfull");
		assertEquals(adminCreateNewBrandPage.getTitlePageName(driver),
				 GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getTitleBrandManagementDetailPageTW());

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 03: Verify Title of Company Information section translate to Taiwan");
		assertEquals(adminCreateNewBrandPage.getTitleComPanyInformation(), "????????????");

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 04: Verify Title of Account Information section translate to Taiwan");
		assertEquals(adminCreateNewBrandPage.getTitleAccountInformation(), "????????????");

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 05: Verify Profile area translate to Taiwan");
		assertTrue(adminCreateNewBrandPage.isLabelByNameDisplayed("??????"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 06: Verify Brand area translate to Taiwan");
		assertTrue(adminCreateNewBrandPage.isPlaceHolderByLabelNameDisplayed("??????",
				 GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getPlaceholderTextBoxTW()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 07: Verify Partner area translate to Taiwan");
		assertTrue(adminCreateNewBrandPage.isPlaceHolderByLabelNameDisplayed("????????????",
				 GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getPlaceholderPartnerDropDownListTW()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 08: Verify Account Setting area translate to Taiwan");
		assertTrue(adminCreateNewBrandPage.isAccountSettingDisplayed("????????????"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 09: Verify Use button translate to Taiwan");
		assertTrue(adminCreateNewBrandPage.isButtonNameDisplayed( GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getUseButtonTW()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 10: Verify Nonuse button translate to Taiwan");
		assertTrue(adminCreateNewBrandPage.isButtonNameDisplayed( GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getNonUseButtonTW()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 12: Verify Save button translate to Taiwan");
		assertTrue(adminCreateNewBrandPage.isSaveButtonDisplayed( GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getSaveButtonTW()));

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 13: Verify Save button is disabled");
		assertFalse(adminCreateNewBrandPage.isSaveButtonDisabled( GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getSaveButtonTW()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 14: Verify Account Information After Clicking On 'Use' Button");
		adminCreateNewBrandPage.clickOnButtonByName( GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getUseButtonTW());

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 15: Verify Email area translate to Taiwan");
		assertTrue(adminCreateNewBrandPage.isPlaceHolderByLabelNameDisplayed("????????????",
				 GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getPlaceholderTextBoxTW()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 16: Verify Password area translate to Taiwan");
		assertTrue(adminCreateNewBrandPage.isLabelByNameDisplayed("??????"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 17: Verify Password Setting button translate to Taiwan");
		assertEquals(adminCreateNewBrandPage.getTextResetPasswordButton(), GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getPasswordSettingTW());

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 18: Verify Representative area translate to Taiwan");
		assertTrue(adminCreateNewBrandPage.isPlaceHolderByLabelNameDisplayed("?????????",
				 GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getPlaceholderTextBoxTW()));

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 19: Input Representative");
		adminCreateNewBrandPage.enterToRepresentativeTextBox(representativeName);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 20: Verify Phone area translate to Taiwan");
		assertTrue(adminCreateNewBrandPage.isPlaceHolderByLabelNameDisplayed("??????",
				 GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getPlaceholderPhoneTextBoxTW()));

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 21: Verify Refesh Current Page");
		adminCreateNewBrandPage.refeshCurrentPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 22: Verify Save button is disabled");
		assertFalse(adminCreateNewBrandPage.isSaveButtonDisabled( GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getSaveButtonTW()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 23: Verify Account Information After Clicking On 'Use' Button");
		adminCreateNewBrandPage.clickOnButtonByName( GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getUseButtonTW());

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 24: Click on Password Setting Button");
		adminCreateNewBrandPage.clickToPasswordSettingButton( GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getPasswordSettingTW());

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 25: Verify Reset Password will be changed to Cancel Setting");
		assertEquals(adminCreateNewBrandPage.getTextResetPasswordButton(),  GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getResetPasswordButtonTW());

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 26: Enter Password '" + GlobalConstants.getGlobalConstants().getPassword() + "'");
		adminCreateNewBrandPage.enterToPasswordTextBox(GlobalConstants.getGlobalConstants().getPassword());

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 27: Enter Confirm Password is not match '"
						+ GlobalConstants.getGlobalConstants().getIncorrectPassword() + "'");
		adminCreateNewBrandPage.enterToConfirmPasswordTextBox(GlobalConstants.getGlobalConstants().getIncorrectPassword());

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 28: Click on 'Save' Button");
		adminCreateNewBrandPage.clickSaveButton( GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getSaveButtonTW());

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 29: Verify Error Message At Brand Name textbox translate to Taiwan");
		assertEquals(adminCreateNewBrandPage.getErrorMessageAtBrandNameTextBox(), "?????????????????????");

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 30: Verify Error Message At Confirm Password textbox translate to Taiwan");
		assertEquals(adminCreateNewBrandPage.getErrorMessageAtConfirmPasswordTextBox(), "???????????????.");

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 31: Verify Error Message At Partner dropdown list translate to Taiwan");
		assertEquals(adminCreateNewBrandPage.getErrorMessageAtPartnerDropdownList(), "?????????????????????");

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 32: Verify Error Message At Email textbox translate to Taiwan");
		assertEquals(adminCreateNewBrandPage.getErrorMessageAtEmailTextBox(), "?????????????????????");

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 33: Enter To Email TextBox Wrong Email Format");
		adminCreateNewBrandPage.enterToEmailTextBox(GlobalConstants.getGlobalConstants().getWrongEmailFormat());

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 34: Click On Save Button");
		adminCreateNewBrandPage.clickSaveButton( GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getSaveButtonTW());

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 35: Verify Error Message At Email textbox translate to Taiwan When Inputting Wrong Email Format");
		assertEquals(adminCreateNewBrandPage.getErrorMessageAtEmailTextBox(), "???????????????.");

	}

	@Test
	public void Manager_Role_TW_TC_06_Check_Translate_To_English_Create_Brand_Page(Method method) {
		ExtentTestManager.startTest(method.getName(), "Check Translate To English At Create Brand Page");
		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 01: Refresh Current Page");
		adminCreateNewBrandPage.refeshCurrentPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 02: Change to English Language");
		adminCreateNewBrandPage.openSelectLanguageList(driver, GlobalConstants.getGlobalConstants().getEnglishLangguage());

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 03: Verify Title of Company Information section translate to English");
		assertEquals(adminCreateNewBrandPage.getTitlePageName(driver),
				 GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getTitleBrandManagementDetailPageEN());

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 04: Verify Open 'Create New Brand Page' Successfull");
		assertEquals(adminCreateNewBrandPage.getTitleComPanyInformation(), "Company Information");

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 05: Verify Title of Account Information section translate to English");
		assertEquals(adminCreateNewBrandPage.getTitleAccountInformation(), "Account Information");

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 06: Verify Profile area translate to English");
		assertTrue(adminCreateNewBrandPage.isLabelByNameDisplayed("Profile"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 07: Verify Brand area translate to English");
		assertTrue(adminCreateNewBrandPage.isPlaceHolderByLabelNameDisplayed("Brand",
				 GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getPlaceholderTextBoxEN()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 08: Verify Partner area translate to English");
		assertTrue(adminCreateNewBrandPage.isPlaceHolderByLabelNameDisplayed("Partner",
				 GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getPlaceholderPartnerDropDownListEN()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 09: Verify Account Setting area translate to English");
		assertTrue(adminCreateNewBrandPage.isAccountSettingDisplayed("Account Setting"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 10: Verify Use button translate to English");
		assertTrue(adminCreateNewBrandPage.isButtonNameDisplayed( GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getUseButtonEN()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 11: Verify Nonuse button translate to English");
		assertTrue(adminCreateNewBrandPage.isButtonNameDisplayed( GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getNonUseButtonEN()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 12: Verify Save button translate to English");
		assertTrue(adminCreateNewBrandPage.isSaveButtonDisplayed( GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getSaveButtonEN()));

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 13: Verify Save button is disabled");
		assertFalse(adminCreateNewBrandPage.isSaveButtonDisabled(GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getSaveButtonEN()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 14: Verify Account Information After Clicking On 'Use' Button");
		adminCreateNewBrandPage.clickOnButtonByName( GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getUseButtonEN());

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 15: Verify Email area translate to English");
		assertTrue(adminCreateNewBrandPage.isPlaceHolderByLabelNameDisplayed("Email",
				 GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getPlaceholderTextBoxEN()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 16: Verify Password area translate to English");
		assertTrue(adminCreateNewBrandPage.isLabelByNameDisplayed("Password"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 17: Verify Reset Password button translate to English");
		assertEquals(adminCreateNewBrandPage.getTextResetPasswordButton(),  GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getPasswordSettingEN());

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 18: Verify Representative area translate to English");
		assertTrue(adminCreateNewBrandPage.isPlaceHolderByLabelNameDisplayed("Representative",
				 GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getPlaceholderTextBoxEN()));

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 19: Input Representative");
		adminCreateNewBrandPage.enterToRepresentativeTextBox(representativeName);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 20: Verify Phone area translate to English");
		assertTrue(adminCreateNewBrandPage.isPlaceHolderByLabelNameDisplayed("Phone",
				 GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getPlaceholderPhoneTextBoxEN()));

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 21: Verify Refesh Current Page");
		adminCreateNewBrandPage.refeshCurrentPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 22: Verify Save button is disabled");
		assertFalse(adminCreateNewBrandPage.isSaveButtonDisabled( GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getSaveButtonEN()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 23: Verify Account Information After Clicking On 'Use' Button");
		adminCreateNewBrandPage.clickOnButtonByName( GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getUseButtonEN());

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 24: Click On Password Setting Button");
		adminCreateNewBrandPage.clickToPasswordSettingButton( GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getPasswordSettingEN());

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 25: Verify Reset Password will be changed to Cancel Setting");
		assertEquals(adminCreateNewBrandPage.getTextResetPasswordButton(),  GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getCancelSettingEN());

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 26: Enter Password '" + GlobalConstants.getGlobalConstants().getPassword() + "'");
		adminCreateNewBrandPage.enterToPasswordTextBox(GlobalConstants.getGlobalConstants().getPassword());

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 27: Enter Confirm Password is not match '"
						+ GlobalConstants.getGlobalConstants().getIncorrectPassword() + "'");
		adminCreateNewBrandPage.enterToConfirmPasswordTextBox(GlobalConstants.getGlobalConstants().getIncorrectPassword());

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 28: Click on 'Save' Button");
		adminCreateNewBrandPage.clickSaveButton( GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getSaveButtonEN());

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 29: Verify Error Message At Brand Name textbox translate to English");
		assertEquals(adminCreateNewBrandPage.getErrorMessageAtBrandNameTextBox(), "This field is required.");

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 30: Verify Error Message At Confirm Password textbox translate to English");
		assertEquals(adminCreateNewBrandPage.getErrorMessageAtConfirmPasswordTextBox(),
				"The confirmation does not match.");
		
		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 31: Verify Error Message At Partner dropdown list translate to English");
		assertEquals(adminCreateNewBrandPage.getErrorMessageAtPartnerDropdownList(), "This field is required.");

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 32: Verify Error Message At Email textbox translate to English");
		assertEquals(adminCreateNewBrandPage.getErrorMessageAtEmailTextBox(),
				"The email field is required when account setting is use.");

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 33: Enter To Email TextBox Wrong Email Format");
		adminCreateNewBrandPage.enterToEmailTextBox(GlobalConstants.getGlobalConstants().getWrongEmailFormat());

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 34: Click On Save Button");
		adminCreateNewBrandPage.clickSaveButton( GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getSaveButtonEN());

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 35: Verify Error Message At Email textbox translate to Taiwan When Inputting Wrong Email Format");
		assertEquals(adminCreateNewBrandPage.getErrorMessageAtEmailTextBox(),
				"The email must be a valid email address.");
	}

	@Test
	public void Manager_Role_TW_TC_07_Create_Brand_Non_Use_Option(Method method) {
		ExtentTestManager.startTest(method.getName(), "Create Brand By Nonuse Option");
		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 01: Refesh Current Page");
		adminCreateNewBrandPage.refeshCurrentPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 02: Change to Taiwan Language");
		adminCreateNewBrandPage.openSelectLanguageList(driver, GlobalConstants.getGlobalConstants().getTaiwanLanguage());

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 03: Upload Avatar");
		adminCreateNewBrandPage.upLoadMultipleFiles(driver, imageAvatart);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 04: Verify Image Is Uploaded Successfully");
		assertTrue(adminCreateNewBrandPage.isAvatarUpLoaded());

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 05: Input Brand Name '" + brandName + "'");
		adminCreateNewBrandPage.enterToBrandNameTextBox(brandName);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 06: Input Partner Name '"
				+  GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getPartnerNameSearchFieldTaiwan() + "'");
		adminCreateNewBrandPage.enterToPartNameTextBox( GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getPartnerNameSearchFieldTaiwan());

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 07: Select Partner Name '"
				+  GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getPartnerNameAndEmailSearchFieldTaiwan() + "'");
		adminCreateNewBrandPage.selectPartnerByName( GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getPartnerNameAndEmailSearchFieldTaiwan());

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 08: Click on 'Save' button");
		adminCreateNewBrandPage.clickSaveButton( GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getSaveButtonTW());
		adminBrandManagementPage = PageGeneratorManager.getManagementPage(driver);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management - Step 09: Verify Brand has just been created in Brand Management list");
		assertTrue(adminBrandManagementPage.isTextCreatedBrandAtRowDisplayed("????????????", "1",
				 GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getPartnerNameSearchFieldTaiwan()));
		assertTrue(adminBrandManagementPage.isTextCreatedBrandAtRowDisplayed("????????????", "1", brandName));
	}

	@Test
	public void Manager_Role_TW_TC_08_Delete_Brand_Advertiser_Do_Not_Have_CamPaign(Method method) {
		ExtentTestManager.startTest(method.getName(), "Delete Brand Do Not Have Campaign");
		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 01: Input Brand Name '" + brandName + "'");
		adminBrandManagementPage.enterToSearchBrandTextBox(brandName);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 02: Click on Search Button");
		adminBrandManagementPage.clickToSearchButton();
		
//		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 03: Get Title Current Page");
//		getCurrentUrl = adminBrandManagementPage.getPageUrl(driver);
//		System.out.println("TC 08_Manager " + getCurrentUrl);
		
		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 04: Refesh Current Page");
		adminBrandManagementPage.refeshCurrentPage(driver);
		
//		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 05: Get Title Current Page After Reloading");
//		getCurrentUrlAfterRefesh = adminBrandManagementPage.getPageUrl(driver);
//		System.out.println("TC 08_Manager " + getCurrentUrlAfterRefesh);
//		adminHomePage = PageGeneratorManager.getHomePage(driver);
		
//		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 06: Compare Previous Title To Current Page After Reloading");
//		if(adminBrandManagementPage.isOpenLoginLinkDisplayed()) {
//			adminHomePage.openLoginPopup();
//			adminBrandManagementPage = adminHomePage.openBrandManagementPage(GlobalConstants.getGlobalConstants().getLoginButtonTW());	
//			ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 07: Click on Delete Button");
//			adminBrandManagementPage.clickToDeleteButtonByRownNumber("1", GlobalConstants.getGlobalConstants().getDeleteButtonAtRowTW());
//		}else {
//			ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 07: Click on Delete Button");
//			adminBrandManagementPage.clickToDeleteButtonByRownNumber("1", GlobalConstants.getGlobalConstants().getDeleteButtonAtRowTW());
//		}
		
		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 07: Click on Delete Button");
		adminBrandManagementPage.clickToDeleteButtonByRownNumber("1",  GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getDeleteButtonAtRowTW());

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 08: Verify Message Popup is Displayed");
		assertTrue(adminBrandManagementPage.isPopupDisplayed());

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 09: Verify Message Popup translate to English");
		adminBrandManagementPage.openSelectLanguageList(driver, "English");
		assertEquals(adminBrandManagementPage.getTitlePopup(), "Delete Brand");
		assertEquals(adminBrandManagementPage.getTextMessage(),
				"Are you sure you want to delete this brand? You can't undo this action.");
		assertEquals(adminBrandManagementPage.getDeleteButtonText(), "Delete");
		assertEquals(adminBrandManagementPage.getCancelButtonText(), "Cancel");

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 10: Verify Message Popup translate to Taiwan");
		adminBrandManagementPage.openSelectLanguageList(driver, GlobalConstants.getGlobalConstants().getTaiwanLanguage());
		assertEquals(adminBrandManagementPage.getTitlePopup(), "????????????");
		assertEquals(adminBrandManagementPage.getTextMessage(), "??????????????????????????????????????????????????????????????????");
		assertEquals(adminBrandManagementPage.getDeleteButtonText(), "??????");
		assertEquals(adminBrandManagementPage.getCancelButtonText(), "??????");

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 11: Close Popup By X Icon");
		adminBrandManagementPage.clickToClosePopupByIcon();

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 12: Click To Delete Button");
		adminBrandManagementPage.clickToDeleteButtonByRownNumber("1",  GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getDeleteButtonAtRowTW());

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 13: Close Popup By Clicking On Cancel Button");
		adminBrandManagementPage.clickToClosePopupCancelButton();

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 14: Delete Brand");
		adminBrandManagementPage.clickToDeleteButtonByRownNumber("1",  GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getDeleteButtonAtRowTW());
		adminBrandManagementPage.clickToDeleteButton();

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 15: Click on 'Brand Management Link");
		adminBrandManagementPage.openByNameLink(driver,  GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getBrandManagementLinkTW());

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 16: Verify Brand Is Deleted '" + brandName + "'");
		assertNotEquals(adminBrandManagementPage.getBrandNameByRownNumber("1", "2"), brandName);
	}

	@Test
	public void Manager_Role_TW_TC_09_Create_Brand_Use_Option(Method method) {
		ExtentTestManager.startTest(method.getName(), "Create Brand By Use Option");
		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 01: Open Create A New Brand Page");
		adminBrandManagementPage.openCreateANewBrand( GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getCreateANewBrandButtonTW());

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 02: Upload Avatar");
		adminCreateNewBrandPage.upLoadMultipleFiles(driver, imageAvatart);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 03: Verify Image Upload Successfully");
		assertTrue(adminCreateNewBrandPage.isAvatarUpLoaded());

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 04: Input Brand Name '" + brandName + "'");
		adminCreateNewBrandPage.enterToBrandNameTextBox(brandName);
		
		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 05: Input Partner Name '"
				+  GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getPartnerNameSearchFieldTaiwan() + "'");
		adminCreateNewBrandPage.enterToPartNameTextBox( GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getPartnerNameSearchFieldTaiwan());
		
		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 06: Select Partner Name '"
				+  GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getPartnerNameAndEmailSearchFieldKorea() + "'");
		adminCreateNewBrandPage.selectPartnerByName( GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getPartnerNameAndEmailSearchFieldTaiwan());

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 07: Click on 'Use' button");
		adminCreateNewBrandPage.clickOnButtonByName( GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getUseButtonTW());

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 08: Input Email '" + partnerEmailAddress + "'");
		adminCreateNewBrandPage.enterToEmailTextBox(partnerEmailAddress);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 09: Click On Password Setting Button");
		adminCreateNewBrandPage.clickToPasswordSettingButton( GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getPasswordSettingTW());

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 10: Input Password '" + GlobalConstants.getGlobalConstants().getPassword() + "'");
		adminCreateNewBrandPage.enterToPasswordTextBox(GlobalConstants.getGlobalConstants().getPassword());

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 11: Input Confirm Password '" + GlobalConstants.getGlobalConstants().getPassword()+ "'");
		adminCreateNewBrandPage.enterToConfirmPasswordTextBox(GlobalConstants.getGlobalConstants().getPassword());

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 12: Click on 'Save' button");
		adminCreateNewBrandPage.clickSaveButton( GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getSaveButtonTW());
		adminBrandManagementPage = PageGeneratorManager.getManagementPage(driver);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management - Step 13: Verify Brand has just been created in Brand Management list");
		adminBrandManagementPage.isTextCreatedBrandAtRowDisplayed("????????????", "1",
				 GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getPartnerNameSearchFieldTaiwan());
		adminBrandManagementPage.isTextCreatedBrandAtRowDisplayed("????????????", "1", brandName);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 14: Delete Brand");
		adminBrandManagementPage.clickToDeleteButtonByRownNumber("1",
				 GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getDeleteButtonAtRowTW());

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 15: Close Delete Brand Popup");
		adminBrandManagementPage.clickToClosePopupCancelButton();
	}

	@Test
	public void Manager_Role_TW_TC_10_Delete_Brand_Advertiser_Has_CamPaign(Method method) {
		ExtentTestManager.startTest(method.getName(), "Delete Brand Has Campaign");
		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 01: Search Brand '"
				+  GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getBrandNameHasCampaignManagerRoleTW() + "'");
		adminBrandManagementPage.enterToSearchBrandTextBox( GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getBrandNameHasCampaignManagerRoleTW());

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 02: Click on Search Button");
		adminBrandManagementPage.clickToResetButton();

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 03: Search Brand '"
				+  GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getBrandNameHasCampaignManagerRoleTW() + "'");
		adminBrandManagementPage.enterToSearchBrandTextBox( GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getBrandNameHasCampaignManagerRoleTW());

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 04: Click on Search Button");
		adminBrandManagementPage.clickToSearchButton();
		
//		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 05: Get Title Current Page");
//		getCurrentUrl = adminBrandManagementPage.getPageUrl(driver);
//		System.out.println("TC 10_Manager " + getCurrentUrl);
		
		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 06: Refesh current page");
		adminBrandManagementPage.refeshCurrentPage(driver);
		
//		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 07: Get Title Current Page After Reloading");	
//		getCurrentUrlAfterRefesh = adminBrandManagementPage.getPageTitle(driver);
//		System.out.println("TC 10_Manager " + getCurrentUrlAfterRefesh);
//		adminHomePage = PageGeneratorManager.getHomePage(driver);
		
//		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 08: Compare Previous Title Page To Title Current Page After Reloading");
//		if(adminBrandManagementPage.isOpenLoginLinkDisplayed()) {
//			adminHomePage.openLoginPopup();
//			adminBrandManagementPage = adminHomePage.openBrandManagementPage(GlobalConstants.getGlobalConstants().getLoginButtonTW());
//			ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 09: Click on Delete Button");
//			adminBrandManagementPage.clickToDeleteButtonByRownNumber("1",
//					GlobalConstants.getGlobalConstants().getDeleteButtonAtRowTW());
//		}else {
//			ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 09: Click on Delete Button");
//			adminBrandManagementPage.clickToDeleteButtonByRownNumber("1",
//					GlobalConstants.getGlobalConstants().getDeleteButtonAtRowTW());
//		}
		
		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 09: Click on Delete Button");
		adminBrandManagementPage.clickToDeleteButtonByRownNumber("1",
				 GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getDeleteButtonAtRowTW());

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 10: Verify Message Popup is Displayed");
		assertTrue(adminBrandManagementPage.isPopupDisplayed());

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 11: Change to English Language");
		adminBrandManagementPage.openSelectLanguageList(driver, GlobalConstants.getGlobalConstants().getEnglishLangguage());

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 12: Verify Message Popup translate to English");
		assertEquals(adminBrandManagementPage.getTitlePopup(), "Delete Brand");
		assertEquals(adminBrandManagementPage.getTextMessage(),
				"You cannot delete the brand that has any campaign history.");
		assertEquals(adminBrandManagementPage.getDeleteButtonText(), "Confirm");

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 13: Change to Taiwan Language");
		adminBrandManagementPage.openSelectLanguageList(driver, GlobalConstants.getGlobalConstants().getTaiwanLanguage());

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 14: Verify Message Popup translate to Taiwan");
		assertEquals(adminBrandManagementPage.getTitlePopup(), "????????????");
		assertEquals(adminBrandManagementPage.getTextMessage(), "?????????????????????????????????????????????????????????");
		assertEquals(adminBrandManagementPage.getDeleteButtonText(), "??????");

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 15: Click On Confirm Button");
		adminBrandManagementPage.clickToDeleteButton();

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 16: Verify Brand Is Not Deleted");
		assertEquals(adminBrandManagementPage.getBrandNameByRownNumber("1", "3"),
				 GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getBrandNameHasCampaignManagerRoleTW());
	}

	@Test
	public void Manager_Role_TW_TC_11_Edit_Brand_Information(Method method) {
		ExtentTestManager.startTest(method.getName(), "Edit Brand Information");
		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 01: Refesh Page");
		adminBrandManagementPage.refeshCurrentPage(driver);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 02: Click on 'Advertiser Brand Management Link");
		adminBrandManagementPage.clickOnByMenuNameLink(driver, GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getAdvertiserManagementLinkTW());

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 03: Click on 'Brand Management Link");
		adminBrandManagementPage.openByNameLink(driver, GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getBrandManagementLinkTW());

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 04: Get Title Current");
//		getCurrentUrl = adminBrandManagementPage.getPageUrl(driver);
//		System.out.println("TC 11_Manager " + getCurrentUrl);
		
		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 05: Refesh Current Page");
		adminBrandManagementPage.refeshCurrentPage(driver);
		
//		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 06: Get Title Current Page After Reloading");
//		getCurrentUrlAfterRefesh = adminBrandManagementPage.getPageUrl(driver);
//		System.out.println("TC 11_Manager " + getCurrentUrlAfterRefesh);
//		adminHomePage = PageGeneratorManager.getHomePage(driver);
		
//		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 07: Compare Previous Title Page To Title Current Page After Reloading");
//		if(adminBrandManagementPage.isOpenLoginLinkDisplayed()) {
//			adminHomePage.openLoginPopup();
//			adminBrandManagementPage = adminHomePage.openBrandManagementPage(GlobalConstants.getGlobalConstants().getLoginButtonTW());
//			ExtentTestManager.getTest().log(Status.INFO,
//					"Brand Management Page - Step 08: Click on 'Create a new Brand' Button");
//			adminBrandManagementPage.openCreateANewBrand(GlobalConstants.getGlobalConstants().getCreateANewBrandButtonTW());
//			adminCreateNewBrandPage = PageGeneratorManager.getCreateANewBrandPage(driver);
//		}else {
//			ExtentTestManager.getTest().log(Status.INFO,
//					"Brand Management Page - Step 08: Click on 'Create a new Brand' Button");
//			adminBrandManagementPage.openCreateANewBrand(GlobalConstants.getGlobalConstants().getCreateANewBrandButtonTW());
//			adminCreateNewBrandPage = PageGeneratorManager.getCreateANewBrandPage(driver);
//		}
		
		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 08: Click on 'Create a new Brand' Button");
		adminBrandManagementPage.openCreateANewBrand(GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getCreateANewBrandButtonTW());
		adminCreateNewBrandPage = PageGeneratorManager.getCreateANewBrandPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 09: Upload Avatar");
		adminCreateNewBrandPage.upLoadMultipleFiles(driver, imageAvatart);
		assertTrue(adminCreateNewBrandPage.isAvatarUpLoaded());

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 10: Input Brand Name");
		adminCreateNewBrandPage.enterToBrandNameTextBox(brandName);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 11: Input Partner Name '"
				+ GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getPartnerNameSearchFieldTaiwan() + "'");
		adminCreateNewBrandPage.enterToPartNameTextBox(GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getPartnerNameSearchFieldTaiwan());

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 12: Select Partner Name '"
				+ GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getPartnerNameAndEmailSearchFieldTaiwan() + "'");
		adminCreateNewBrandPage.selectPartnerByName(GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getPartnerNameAndEmailSearchFieldTaiwan());

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 13: Click on 'Save' button");
		adminCreateNewBrandPage.clickSaveButton(GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getSaveButtonTW());
		adminBrandManagementPage = PageGeneratorManager.getManagementPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 14: Search Brand '" + brandName + "'");
		adminBrandManagementPage.enterToSearchBrandTextBox(brandName);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 15: Click on Search Button");
		adminBrandManagementPage.clickToSearchButton();

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 16: Open Brand Information Detail Page");
		adminBrandManagementPage.clickToBrandNameByRownNumber("1", brandName);
		adminDetailBrandPage = PageGeneratorManager.getDetailBrandPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 17: Get Current Page URL");
		getCurrentUrl = adminDetailBrandPage.getPageUrl(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 18: Get Current Page ID");
		getCurrentPageID = adminDetailBrandPage.getParentID(driver);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management - Step 19: Verify Brand Information Detail Page");
		assertEquals(adminDetailBrandPage.getSeeBrandTextButton(), GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getSeeBrandButtonTW());

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 20: Open See Brand Partner Page");
		adminDetailBrandPage.clickToSeeBrandPageButton();

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 21: Switch To Advertiser Page");
		adminDetailBrandPage.switchTab(GlobalConstants.getGlobalConstants().getAdvertiserTestUrl());
		advertiserDashBoardPage = PageGeneratorManager.getAdvertiserDashBoardPage(driver);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management - Step 22: Verify Advertiser Name '" + brandName + "'");
		assertEquals(advertiserDashBoardPage.getPartnerName(), brandName);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 23: Switch To Edit Brand Page");
		advertiserDashBoardPage.switchTab(getCurrentUrl);
		adminDetailBrandPage = PageGeneratorManager.getDetailBrandPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 24: Close Advertiser Page");
		advertiserDashBoardPage.closeTab(getCurrentPageID);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management - Step 25: Verify Change To Brand Information Successfully");
		assertEquals(adminDetailBrandPage.getSeeBrandTextButton(),
				GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getSeeBrandButtonTW());

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 26: Click on Use Button");
		adminDetailBrandPage.clickOnButtonByName(GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getUseButtonTW());

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management - Step 27: Enter Emaill Address'" + partnerEmailAddress + "'");
		adminDetailBrandPage.enterToEmailTextBox(partnerEmailAddress);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 28: Open Setting Password");
		adminDetailBrandPage.clickToPasswordSettingButton(GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getPasswordSettingTW());

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 29: Enter To Password TextBox");
		adminDetailBrandPage.enterToPasswordTextBox(GlobalConstants.getGlobalConstants().getPassword());

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 30: Enter To Confirm Password TextBox");
		adminDetailBrandPage.enterToConfirmPasswordTextBox(GlobalConstants.getGlobalConstants().getPassword());

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 31: Click On Save Button");
		adminDetailBrandPage.clickSaveButton(GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getSaveButtonTW());

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management - Step 32: Verify Email Alerady Exists In System Taiwan Language");
		assertEquals(adminDetailBrandPage.getErrorMessageAtEmailTextBox(), "??????????????????");

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 33: Change To English Language");
		adminDetailBrandPage.openSelectLanguageList(driver, GlobalConstants.getGlobalConstants().getEnglishLangguage());

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management - Step 34: Verify Email Alerady Exists In System English Language");
		assertEquals(adminDetailBrandPage.getErrorMessageAtEmailTextBox(), "The email has already been taken.");

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 35: Change To Taiwan Language");
		adminDetailBrandPage.openSelectLanguageList(driver, GlobalConstants.getGlobalConstants().getTaiwanLanguage());

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 36: Log Out Manager Account");
		adminDetailBrandPage.clickOnLogOutButton();
		adminHomePage = PageGeneratorManager.getHomePage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 37: Verify Login Page");
		assertTrue(adminHomePage.isLoginButtonDisplayed());

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 38: Open Login Form");
		adminHomePage.openLoginPopup();

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 39: Switch To Advertiser Tab");
		adminHomePage.clickToAdvertiserTab("??????");

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 40: Enter To Email TextBox");
		adminHomePage.enterToEmailAdvertiserTextBox(partnerEmailAddress);

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 41: Enter To Password TextBox");
		adminHomePage.enterToPasswordAdvertiserTextBox(GlobalConstants.getGlobalConstants().getPassword());

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 42: Open Advertiser Page");
		advertiserDashBoardPage = adminHomePage.openAdvertiserPage(GlobalConstantsCreateBrandAdvertiser.getGlobalConstantsCreateBrandAdvertiser().getLoginButtonTW());
		advertiserDashBoardPage = PageGeneratorManager.getAdvertiserDashBoardPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 43: Open Advertiser Page Successfull");
		assertTrue(advertiserDashBoardPage.isDeliveryMenuDisplayed());
	}

	@Parameters({ "browser" })
	@AfterClass(alwaysRun = true)
	public void afterClass(String browserName) {
		ExtentTestManager.getTest().log(Status.INFO, "Close browser '" + browserName + "'");
		closeBrowserAndDriver();
	}
}
