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
import commons.GlobalConstants_TW;
import commons.PageGeneratorManager;
import environmentConfig.Environment;
import pageObjects.revu.Admin.AdminBrandManagementObject;
import pageObjects.revu.Admin.AdminCreateBrandManagementObject;
import pageObjects.revu.Admin.AdminDashBoardObject;
import pageObjects.revu.Admin.AdminDetailBrandManagementObject;
import pageObjects.revu.Admin.AdminHomePageObject;
import pageObjects.revu.Advertiser.AdvertiserDashBoardPageObject;
import reportConfig.ExtentTestManager;

public class Advertiser_Taiwan_Management_Role extends BaseTest {

	WebDriver driver;
	AdminDashBoardObject adminDashBoardPage;
	AdminHomePageObject adminHomePage;
	AdminBrandManagementObject adminBrandManagementPage;
	AdvertiserDashBoardPageObject advertiserDashBoardPage;
	AdminDetailBrandManagementObject adminDetailBrandPage;
	AdminCreateBrandManagementObject adminCreateNewBrandPage;
	String partnerEmailAddress, getCurrentUrl, getCurrentPageID, representativeName;
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
	public void TC_01_Open_Admin_Page_And_Select_Country(Method method) {
		ExtentTestManager.startTest(method.getName(), "Open Admin Page And Select Country");
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 01: Open Country List");
		adminHomePage.openCountryList();

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 02: Select Country");
		adminHomePage.hoverCountryName("Taiwan");

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 03: Select language");
		adminHomePage.selectLanguage("繁體中文");

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 04: Open Login Form");
		adminHomePage.openLoginPopup();
	}

	@Test
	public void TC_02_Login_To_DashBoard_Page(Method method) {
		ExtentTestManager.startTest(method.getName(), "Login To DasbhBoard Page");
		ExtentTestManager.getTest().log(Status.INFO,
				"Admin Page - Step 01: Enter Email'" + GlobalConstants_TW.EMAIL_MANAGER_ROLE + "'");
		adminHomePage.enterToEmailTextbox(GlobalConstants_TW.EMAIL_MANAGER_ROLE);

		ExtentTestManager.getTest().log(Status.INFO,
				"Admin Page - Step 02: Enter Password'" + GlobalConstants_TW.PASSWORD + "'");
		adminHomePage.enterToPasswordTextbox(GlobalConstants_TW.PASSWORD);

		ExtentTestManager.getTest().log(Status.INFO, "Admin Page - Step 03: Click on Submit button");
		adminDashBoardPage = adminHomePage.openAdminDashBoardPage(GlobalConstants_TW.LOGIN_BUTTON);

		ExtentTestManager.getTest().log(Status.INFO, "Admin Page - Step 04: Verify Login Successfull");
		assertTrue(adminDashBoardPage.isLogOutLinkDisplayed());
	}

	@Test
	public void TC_03_Check_Translate_To_Taiwan_Brand_Management_Page(Method method) {
		ExtentTestManager.startTest(method.getName(), "Check Translate To Taiwan At Brand Management Page");
		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 01: Click on 'Advertiser Brand Management Link");
		adminDashBoardPage.clickOnByMenuNameLink(driver, GlobalConstants_TW.ADVERTISER_MANAGEMENT_LINK);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 02: Click on 'Brand Management Link");
		adminDashBoardPage.openByNameLink(driver, GlobalConstants_TW.BRAND_MANAGEMENT_LINK);
		adminBrandManagementPage = PageGeneratorManager.getManagementPage(driver);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 03: Verify Title Brand Management Page is Displayed");
		assertEquals(adminBrandManagementPage.getTitlePageName(driver),
				GlobalConstants_TW.TITLE_BRAND_MANGEMENT_PAGE_TW);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 04: Verify Brand label is Taiwan languages");
		assertTrue(adminBrandManagementPage.isPlaceHolderDisplayed("品牌", GlobalConstants_TW.PLACE_HOLDER_TEXTBOX_TW));

//		ExtentTestManager.getTest().log(Status.INFO,
//				"Brand Management Page - Step 05: Verify Field label is Taiwan languages");
//		assertTrue(adminBrandManagementPage.isPlaceHolderFieldDropDownListDisplayed("분야", GlobalConstants_TW.PLACE_HOLDER_FIELD_DROPDOWN_LIST_KR));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 05: Verify Representative label is Taiwan languages");
		assertTrue(adminBrandManagementPage.isPlaceHolderDisplayed("負責人", GlobalConstants_TW.PLACE_HOLDER_TEXTBOX_TW));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 06: Verify Partner label is Taiwan languages");
		assertTrue(adminBrandManagementPage.isPlaceHolderDisplayed("合作夥伴", GlobalConstants_TW.PLACE_HOLDER_TEXTBOX_TW));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 07: Verify Email label is Taiwan languages");
		assertTrue(adminBrandManagementPage.isPlaceHolderDisplayed("電子信件", GlobalConstants_TW.PLACE_HOLDER_TEXTBOX_TW));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 08: Verify Phone label is Taiwan languages");
		assertTrue(adminBrandManagementPage.isPlaceHolderDisplayed("電話",
				GlobalConstants_TW.PLACE_HOLDER_PHONE_TEXTBOX_TW));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 09: Verify Search button is Taiwan languages");
		assertTrue(adminBrandManagementPage.isButtonDisplayed("搜尋"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 10: Verify Reset button is Taiwan languages");
		assertTrue(adminBrandManagementPage.isButtonDisplayed("重新設定"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 11: Verify Brand No. column is Taiwan languages");
		assertTrue(adminBrandManagementPage.isColumnNameDisplayed("品牌號嗎"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 12: Verify Partner column is Taiwan languages");
		assertTrue(adminBrandManagementPage.isColumnNameDisplayed("合作夥伴"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 13: Verify Brand column is Taiwan languages");
		assertTrue(adminBrandManagementPage.isColumnNameDisplayed("品牌管理"));

//		ExtentTestManager.getTest().log(Status.INFO,
//				"Brand Management Page - Step 16: Verify Field column is Taiwan languages");
//		assertTrue(adminBrandManagementPage.isColumnNameDisplayed("분야"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 14: Verify Email	column is Taiwan languages");
		assertTrue(adminBrandManagementPage.isColumnNameDisplayed("電子信件"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 15: Verify Representative column is Taiwan languages");
		assertTrue(adminBrandManagementPage.isColumnNameDisplayed("負責人"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 16: Verify Phone column is Taiwan languages");
		assertTrue(adminBrandManagementPage.isColumnNameDisplayed("電話"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 17: Verify Camp. On-going column is Taiwan languages");
		assertTrue(adminBrandManagementPage.isColumnNameDisplayed("專案進行中"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 18: Verify Camp. Completed column is Taiwan languages");
		assertTrue(adminBrandManagementPage.isColumnNameDisplayed("專案完成"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 19: Verify Date of Creation column is Taiwan languages");
		assertTrue(adminBrandManagementPage.isColumnNameDisplayed("建立日期"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 20: Verify Delete column is Taiwan languages");
		assertTrue(adminBrandManagementPage.isColumnNameDisplayed("刪除"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 21: Verify Delete button is Taiwan languages");
		assertTrue(adminBrandManagementPage.isTextAtRowDisplayed("刪除", "1",
				GlobalConstants_TW.DELETE_BUTTON_AT_BRAND_MANAGEMENT_PAGE_TW));
	}

	@Test
	public void TC_04_Check_Translate_To_English_Brand_Management_Page(Method method) {
		ExtentTestManager.startTest(method.getName(), "Check Translate To English At Brand Management Page");
		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 01: Change to English Language");
		adminBrandManagementPage.openSelectLanguageList(driver, GlobalConstants_TW.ENGLISH_LANGUAGE);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 02: Verify Brand Management Page is Displayed");
		assertEquals(adminBrandManagementPage.getTitlePageName(driver),
				GlobalConstants_TW.TITLE_BRAND_MANGEMENT_PAGE_TW);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 03: Verify Brand label is English languages");
		assertTrue(
				adminBrandManagementPage.isPlaceHolderDisplayed("Brand", GlobalConstants_TW.PLACE_HOLDER_TEXTBOX_EN));

//		ExtentTestManager.getTest().log(Status.INFO,
//				"Brand Management Page - Step 4: Verify Field label is English languages");
//		assertTrue(adminBrandManagementPage.isPlaceHolderFieldDropDownListDisplayed("Field", GlobalConstants_TW.PLACE_HOLDER_FIELD_DROPDOWN_LIST_EN));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 04: Verify Representative label is English languages");
		assertTrue(adminBrandManagementPage.isPlaceHolderDisplayed("Representative",
				GlobalConstants_TW.PLACE_HOLDER_TEXTBOX_EN));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 05: Verify Partner label is English languages");
		assertTrue(
				adminBrandManagementPage.isPlaceHolderDisplayed("Partner", GlobalConstants_TW.PLACE_HOLDER_TEXTBOX_EN));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 06: Verify Email label is English languages");
		assertTrue(
				adminBrandManagementPage.isPlaceHolderDisplayed("Email", GlobalConstants_TW.PLACE_HOLDER_TEXTBOX_EN));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 07: Verify Phone label is English languages");
		assertTrue(adminBrandManagementPage.isPlaceHolderDisplayed("Phone",
				GlobalConstants_TW.PLACE_HOLDER_PHONE_TEXTBOX_EN));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 08: Verify Search button is English languages");
		assertTrue(adminBrandManagementPage.isButtonDisplayed("Search"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 09: Verify Reset button is English languages");
		assertTrue(adminBrandManagementPage.isButtonDisplayed("Reset"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 10: Verify Brand No. column is English languages");
		assertTrue(adminBrandManagementPage.isColumnNameDisplayed("Brand No."));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 11: Verify Partner column is English languages");
		assertTrue(adminBrandManagementPage.isColumnNameDisplayed("Partner"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 12: Verify Brand column is English languages");
		assertTrue(adminBrandManagementPage.isColumnNameDisplayed("Brand"));

//		ExtentTestManager.getTest().log(Status.INFO,
//				"Brand Management Page - Step 13: Verify Field column is English languages");
//		assertTrue(adminBrandManagementPage.isColumnNameDisplayed("Field"));

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
				GlobalConstants_TW.DELETE_BUTTON_AT_BRAND_MANAGEMENT_PAGE_EN));

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 21: Change to Taiwan Language");
		adminBrandManagementPage.openSelectLanguageList(driver, GlobalConstants_TW.TAIWAN_LANGUAGE);
	}

	@Test
	public void TC_05_Check_Translate_To_Taiwan_Create_Brand_Page(Method method) {
		ExtentTestManager.startTest(method.getName(), "Check Translate To Taiwan At Create Brand Page");
		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 01: Click on 'Create a new Brand' Button");
		adminBrandManagementPage.openCreateANewBrand(GlobalConstants_TW.CREATE_A_NEW_BRAND_BUTTON);
		adminCreateNewBrandPage = PageGeneratorManager.getCreateANewBrandPage(driver);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 02: Verify Open 'Create New Brand Page' Successfull");
		assertEquals(adminCreateNewBrandPage.getTitlePageName(driver),
				GlobalConstants_TW.TITLE_BRAND_MANGEMENT_DETAIL_PAGE_TW);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 03: Verify Title of Company Information section translate to Taiwan");
		assertEquals(adminCreateNewBrandPage.getTitleComPanyInformation(), "公司資訊");

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 04: Verify Title of Account Information section translate to Taiwan");
		assertEquals(adminCreateNewBrandPage.getTitleAccountInformation(), "帳戶資訊");

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 05: Verify Profile area translate to Taiwan");
		assertTrue(adminCreateNewBrandPage.isLabelByNameDisplayed("簡介"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 06: Verify Brand area translate to Taiwan");
		assertTrue(adminCreateNewBrandPage.isPlaceHolderByLabelNameDisplayed("品牌",
				GlobalConstants_TW.PLACE_HOLDER_TEXTBOX_TW));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 07: Verify Partner area translate to Taiwan");
		assertTrue(adminCreateNewBrandPage.isPlaceHolderByLabelNameDisplayed("合作夥伴",
				GlobalConstants_TW.PLACE_HOLDER_PARTNER_DROPDOWN_LIST_TW));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 08: Verify Account Setting area translate to Taiwan");
		assertTrue(adminCreateNewBrandPage.isAccountSettingDisplayed("帳戶設定"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 09: Verify Use button translate to Taiwan");
		assertTrue(adminCreateNewBrandPage.isButtonNameDisplayed(GlobalConstants_TW.USE_BUTTON_TW));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 10: Verify Nonuse button translate to Taiwan");
		assertTrue(adminCreateNewBrandPage.isButtonNameDisplayed(GlobalConstants_TW.NON_USE_BUTTON_TW));

//		ExtentTestManager.getTest().log(Status.INFO,
//				"Create Brand Page - Step 11: Verify Field area translate to Taiwan");
//		assertTrue(
//				adminCreateNewBrandPage.isPlaceHolderByDropDownListNameDisplayed("분야", GlobalConstants_TW.PLACE_HOLDER_FIELD_DROPDOWN_LIST_TW));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 12: Verify Save button translate to Taiwan");
		assertTrue(adminCreateNewBrandPage.isSaveButtonDisplayed(GlobalConstants_TW.SAVE_BUTTON_TW));

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 13: Verify Save button is disabled");
		assertFalse(adminCreateNewBrandPage.isSaveButtonDisabled(GlobalConstants_TW.SAVE_BUTTON_TW));

//		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 14: Verify Field after selecting value");
//		adminCreateNewBrandPage.selectField(GlobalConstants_KR.FIELD_DROPDOWN_LIST);
//		assertTrue(adminCreateNewBrandPage.isPlaceHolderByDropDownListNameDisplayed("분야", GlobalConstants_TW.FIELD_DROPDOWN_LIST));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 14: Verify Account Information After Clicking On 'Use' Button");
		adminCreateNewBrandPage.clickOnButtonByName(GlobalConstants_TW.USE_BUTTON_TW);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 15: Verify Email area translate to Taiwan");
		assertTrue(adminCreateNewBrandPage.isPlaceHolderByLabelNameDisplayed("電子信件",
				GlobalConstants_TW.PLACE_HOLDER_TEXTBOX_TW));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 16: Verify Password area translate to Taiwan");
		assertTrue(adminCreateNewBrandPage.isLabelByNameDisplayed("密碼"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 17: Verify Password Setting button translate to Taiwan");
		assertEquals(adminCreateNewBrandPage.getTextResetPasswordButton(), GlobalConstants_TW.PASSWORD_SETTING_TW);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 18: Verify Representative area translate to Taiwan");
		assertTrue(adminCreateNewBrandPage.isPlaceHolderByLabelNameDisplayed("負責人",
				GlobalConstants_TW.PLACE_HOLDER_TEXTBOX_TW));

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 19: Input Representative");
		adminCreateNewBrandPage.enterToRepresentativeTextBox(representativeName);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 20: Verify Phone area translate to Taiwan");
		assertTrue(adminCreateNewBrandPage.isPlaceHolderByLabelNameDisplayed("電話",
				GlobalConstants_TW.PLACE_HOLDER_PHONE_TEXTBOX_TW));

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 21: Verify Refesh Current Page");
		adminCreateNewBrandPage.refeshCurrentPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 22: Verify Save button is disabled");
		assertFalse(adminCreateNewBrandPage.isSaveButtonDisabled(GlobalConstants_TW.SAVE_BUTTON_TW));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 23: Verify Account Information After Clicking On 'Use' Button");
		adminCreateNewBrandPage.clickOnButtonByName(GlobalConstants_TW.USE_BUTTON_TW);

//		ExtentTestManager.getTest().log(Status.INFO,
//				"Create Brand Page - Step 25: Verify Reset Password button translate to Taiwan");
//		assertEquals(adminCreateNewBrandPage.getTextResetPasswordButton(), GlobalConstants_TW.PASSWORD_SETTING_TW);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 24: Click on Password Setting Button");
		adminCreateNewBrandPage.clickToPasswordSettingButton(GlobalConstants_TW.PASSWORD_SETTING_TW);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 25: Verify Reset Password will be changed to Cancel Setting");
		assertEquals(adminCreateNewBrandPage.getTextResetPasswordButton(), GlobalConstants_TW.RESET_PASSWORD_BUTTON_TW);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 26: Enter Password '" + GlobalConstants_TW.PASSWORD + "'");
		adminCreateNewBrandPage.enterToPasswordTextBox(GlobalConstants_TW.PASSWORD);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 27: Enter Confirm Password is not match '"
						+ GlobalConstants_TW.INCORRECT_PASSWORD + "'");
		adminCreateNewBrandPage.enterToConfirmPasswordTextBox(GlobalConstants_TW.INCORRECT_PASSWORD);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 28: Click on 'Save' Button");
		adminCreateNewBrandPage.clickSaveButton(GlobalConstants_TW.SAVE_BUTTON_TW);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 29: Verify Error Message At Brand Name textbox translate to Taiwan");
		assertEquals(adminCreateNewBrandPage.getErrorMessageAtBrandNameTextBox(), "此欄位為必填。");

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 30: Verify Error Message At Confirm Password textbox translate to Taiwan");
		assertEquals(adminCreateNewBrandPage.getErrorMessageAtConfirmPasswordTextBox(), "確認不相符.");

//		ExtentTestManager.getTest().log(Status.INFO,
//				"Create Brand Page - Step 32: Verify Error Message At Field DropDown List translate to Taiwan");
//		assertEquals(adminCreateNewBrandPage.getErrorMessageAtFieldDropdownList(), "필수입력사항 입니다.");

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 31: Verify Error Message At Partner dropdown list translate to Taiwan");
		assertEquals(adminCreateNewBrandPage.getErrorMessageAtPartnerDropdownList(), "此欄位為必填。");

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 32: Verify Error Message At Email textbox translate to Taiwan");
		assertEquals(adminCreateNewBrandPage.getErrorMessageAtEmailTextBox(), "此欄位為必填。");

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 33: Enter To Email TextBox Wrong Email Format");
		adminCreateNewBrandPage.enterToEmailTextBox(GlobalConstants_TW.WRONG_EMAIL_FORMAT);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 34: Click On Save Button");
		adminCreateNewBrandPage.clickSaveButton(GlobalConstants_TW.SAVE_BUTTON_TW);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 35: Verify Error Message At Email textbox translate to Taiwan When Inputting Wrong Email Format");
		assertEquals(adminCreateNewBrandPage.getErrorMessageAtEmailTextBox(), "無效的輸入.");

	}

	@Test
	public void TC_06_Check_Translate_To_English_Create_Brand_Page(Method method) {
		ExtentTestManager.startTest(method.getName(), "Check Translate To English At Create Brand Page");
		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 01: Refresh Current Page");
		adminCreateNewBrandPage.refeshCurrentPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 02: Change to English Language");
		adminCreateNewBrandPage.openSelectLanguageList(driver, GlobalConstants_TW.ENGLISH_LANGUAGE);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 03: Verify Title of Company Information section translate to English");
		assertEquals(adminCreateNewBrandPage.getTitlePageName(driver),
				GlobalConstants_TW.TITLE_BRAND_MANGEMENT_DETAIL_PAGE_EN);

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
				GlobalConstants_TW.PLACE_HOLDER_TEXTBOX_EN));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 08: Verify Partner area translate to English");
		assertTrue(adminCreateNewBrandPage.isPlaceHolderByLabelNameDisplayed("Partner",
				GlobalConstants_TW.PLACE_HOLDER_PARTNER_DROPDOWN_LIST_EN));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 09: Verify Account Setting area translate to English");
		assertTrue(adminCreateNewBrandPage.isAccountSettingDisplayed("Account Setting"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 10: Verify Use button translate to English");
		assertTrue(adminCreateNewBrandPage.isButtonNameDisplayed(GlobalConstants_TW.USE_BUTTON_EN));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 11: Verify Nonuse button translate to English");
		assertTrue(adminCreateNewBrandPage.isButtonNameDisplayed(GlobalConstants_TW.NON_USE_BUTTON_EN));

//		ExtentTestManager.getTest().log(Status.INFO,
//				"Create Brand Page - Step 12: Verify Field area translate to English");
//		assertTrue(adminCreateNewBrandPage.isPlaceHolderByDropDownListNameDisplayed("Field",GlobalConstants_TW.PLACE_HOLDER_PARTNER_DROPDOWN_LIST_TW));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 12: Verify Save button translate to English");
		assertTrue(adminCreateNewBrandPage.isSaveButtonDisplayed(GlobalConstants_TW.SAVE_BUTTON_EN));

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 13: Verify Save button is disabled");
		assertFalse(adminCreateNewBrandPage.isSaveButtonDisabled(GlobalConstants_TW.SAVE_BUTTON_EN));

//		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 14: Verify Field after selecting value");
//		adminCreateNewBrandPage.selectField(GlobalConstants_KR.FIELD_DROPDOWN_LIST);
//		assertTrue(adminCreateNewBrandPage.isPlaceHolderByDropDownListNameDisplayed("Field", GlobalConstants_TW.FIELD_DROPDOWN_LIST));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 14: Verify Account Information After Clicking On 'Use' Button");
		adminCreateNewBrandPage.clickOnButtonByName(GlobalConstants_TW.USE_BUTTON_EN);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 15: Verify Email area translate to English");
		assertTrue(adminCreateNewBrandPage.isPlaceHolderByLabelNameDisplayed("Email",
				GlobalConstants_TW.PLACE_HOLDER_TEXTBOX_EN));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 16: Verify Password area translate to English");
		assertTrue(adminCreateNewBrandPage.isLabelByNameDisplayed("Password"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 17: Verify Reset Password button translate to English");
		assertEquals(adminCreateNewBrandPage.getTextResetPasswordButton(), GlobalConstants_TW.PASSWORD_SETTING_EN);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 18: Verify Representative area translate to English");
		assertTrue(adminCreateNewBrandPage.isPlaceHolderByLabelNameDisplayed("Representative",
				GlobalConstants_TW.PLACE_HOLDER_TEXTBOX_EN));

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 19: Input Representative");
		adminCreateNewBrandPage.enterToRepresentativeTextBox(representativeName);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 20: Verify Phone area translate to English");
		assertTrue(adminCreateNewBrandPage.isPlaceHolderByLabelNameDisplayed("Phone",
				GlobalConstants_TW.PLACE_HOLDER_PHONE_TEXTBOX_EN));

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 21: Verify Refesh Current Page");
		adminCreateNewBrandPage.refeshCurrentPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 22: Verify Save button is disabled");
		assertFalse(adminCreateNewBrandPage.isSaveButtonDisabled(GlobalConstants_TW.SAVE_BUTTON_EN));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 23: Verify Account Information After Clicking On 'Use' Button");
		adminCreateNewBrandPage.clickOnButtonByName(GlobalConstants_TW.USE_BUTTON_EN);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 24: Click On Password Setting Button");
		adminCreateNewBrandPage.clickToPasswordSettingButton(GlobalConstants_TW.PASSWORD_SETTING_EN);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 25: Verify Reset Password will be changed to Cancel Setting");
		assertEquals(adminCreateNewBrandPage.getTextResetPasswordButton(), GlobalConstants_TW.CANCEL_SETTING_EN);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 26: Enter Password '" + GlobalConstants_TW.PASSWORD + "'");
		adminCreateNewBrandPage.enterToPasswordTextBox(GlobalConstants_TW.PASSWORD);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 27: Enter Confirm Password is not match '"
						+ GlobalConstants_TW.INCORRECT_PASSWORD + "'");
		adminCreateNewBrandPage.enterToConfirmPasswordTextBox(GlobalConstants_TW.INCORRECT_PASSWORD);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 28: Click on 'Save' Button");
		adminCreateNewBrandPage.clickSaveButton(GlobalConstants_TW.SAVE_BUTTON_EN);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 29: Verify Error Message At Brand Name textbox translate to English");
		assertEquals(adminCreateNewBrandPage.getErrorMessageAtBrandNameTextBox(), "This field is required.");

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 30: Verify Error Message At Confirm Password textbox translate to English");
		assertEquals(adminCreateNewBrandPage.getErrorMessageAtConfirmPasswordTextBox(),
				"The confirmation does not match.");

//		ExtentTestManager.getTest().log(Status.INFO,
//				"Create Brand Page - Step 32: Verify Error Message At Field DropDown List translate to English");
//		assertEquals(adminCreateNewBrandPage.getErrorMessageAtFieldDropdownList(), "The selected value is invalid.");
//
		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 31: Verify Error Message At Partner dropdown list translate to English");
		assertEquals(adminCreateNewBrandPage.getErrorMessageAtPartnerDropdownList(), "This field is required.");

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 32: Verify Error Message At Email textbox translate to English");
		assertEquals(adminCreateNewBrandPage.getErrorMessageAtEmailTextBox(),
				"The email field is required when account setting is use.");

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 33: Enter To Email TextBox Wrong Email Format");
		adminCreateNewBrandPage.enterToEmailTextBox(GlobalConstants_TW.WRONG_EMAIL_FORMAT);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 34: Click On Save Button");
		adminCreateNewBrandPage.clickSaveButton(GlobalConstants_TW.SAVE_BUTTON_EN);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 35: Verify Error Message At Email textbox translate to Taiwan When Inputting Wrong Email Format");
		assertEquals(adminCreateNewBrandPage.getErrorMessageAtEmailTextBox(),
				"The email must be a valid email address.");
	}

	@Test
	public void TC_07_Create_Brand_Non_Use_Option(Method method) {
		ExtentTestManager.startTest(method.getName(), "Create Brand By Nonuse Option");
		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 01: Refesh Current Page");
		adminCreateNewBrandPage.refeshCurrentPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 02: Change to Taiwan Language");
		adminCreateNewBrandPage.openSelectLanguageList(driver, GlobalConstants_TW.TAIWAN_LANGUAGE);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 03: Upload Avatar");
		adminCreateNewBrandPage.upLoadMultipleFiles(driver, imageAvatart);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 04: Verify Image Is Uploaded Successfully");
		assertTrue(adminCreateNewBrandPage.isAvatarUpLoaded());

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 05: Input Brand Name '" + brandName + "'");
		adminCreateNewBrandPage.enterToBrandNameTextBox(brandName);

//		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 06: Select Field '" + GlobalConstants_TW.FIELD_DROPDOWN_LIST + "'");
//		adminCreateNewBrandPage.selectField(GlobalConstants_TW.FIELD_DROPDOWN_LIST);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 06: Input Partner Name '"
				+ GlobalConstants_TW.PARTNER_NAME_SEARCH_FIELD + "'");
		adminCreateNewBrandPage.enterToPartNameTextBox(GlobalConstants_TW.PARTNER_NAME_SEARCH_FIELD);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 07: Select Partner Name '"
				+ GlobalConstants_TW.PARTNER_NAME_AND_EMAIL_SEARCH_FIELD + "'");
		adminCreateNewBrandPage.selectPartnerByName(GlobalConstants_TW.PARTNER_NAME_AND_EMAIL_SEARCH_FIELD);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 08: Click on 'Save' button");
		adminCreateNewBrandPage.clickSaveButton(GlobalConstants_TW.SAVE_BUTTON_TW);
		adminBrandManagementPage = PageGeneratorManager.getManagementPage(driver);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management - Step 09: Verify Brand has just been created in Brand Management list");
		assertTrue(adminBrandManagementPage.isTextCreatedBrandAtRowDisplayed("合作夥伴", "1",
				GlobalConstants_TW.PARTNER_NAME_SEARCH_FIELD));
		assertTrue(adminBrandManagementPage.isTextCreatedBrandAtRowDisplayed("品牌管理", "1", brandName));
		// assertTrue(adminBrandManagementPage.isTextCreatedBrandAtRowDisplayed("분야",
		// "1", GlobalConstants_TW.FIELD_DROPDOWN_LIST));
	}

	@Test
	public void TC_08_Delete_Brand_Advertiser_Do_Not_Have_CamPaign(Method method) {
		ExtentTestManager.startTest(method.getName(), "Delete Brand Do Not Have Campaign");
		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 01: Input Brand Name '" + brandName + "'");
		adminBrandManagementPage.enterToSearchBrandTextBox(brandName);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 02: Click on Search Button");
		adminBrandManagementPage.clickToSearchButton();

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 03: Click on Delete Button");
		adminBrandManagementPage.clickToDeleteButtonByRownNumber("1", GlobalConstants_TW.DELETE_BUTTON);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 04: Verify Message Popup is Displayed");
		assertTrue(adminBrandManagementPage.isPopupDisplayed());

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 05: Verify Message Popup translate to English");
		adminBrandManagementPage.openSelectLanguageList(driver, "English");
		assertEquals(adminBrandManagementPage.getTitlePopup(), "Delete Brand");
		assertEquals(adminBrandManagementPage.getTextMessage(),
				"Are you sure you want to delete this brand? You can't undo this action.");
		assertEquals(adminBrandManagementPage.getDeleteButtonText(), "Delete");
		assertEquals(adminBrandManagementPage.getCancelButtonText(), "Cancel");

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 06: Verify Message Popup translate to Taiwan");
		adminBrandManagementPage.openSelectLanguageList(driver, GlobalConstants_TW.TAIWAN_LANGUAGE);
		assertEquals(adminBrandManagementPage.getTitlePopup(), "刪除品牌");
		assertEquals(adminBrandManagementPage.getTextMessage(), "您確定想要刪除這個品牌？您將無法回復此步驟。");
		assertEquals(adminBrandManagementPage.getDeleteButtonText(), "刪除");
		assertEquals(adminBrandManagementPage.getCancelButtonText(), "取消");

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 07: Close Popup By X Icon");
		adminBrandManagementPage.clickToClosePopupByIcon();

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 08: Click To Delete Button");
		adminBrandManagementPage.clickToDeleteButtonByRownNumber("1", GlobalConstants_TW.DELETE_BUTTON);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 09: Close Popup By Clicking On Cancel Button");
		adminBrandManagementPage.clickToClosePopupCancelButton();

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 10: Delete Brand");
		adminBrandManagementPage.clickToDeleteButtonByRownNumber("1", GlobalConstants_TW.DELETE_BUTTON);
		adminBrandManagementPage.clickToDeleteButton();

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 11: Click on 'Brand Management Link");
		adminBrandManagementPage.openByNameLink(driver, GlobalConstants_TW.BRAND_MANAGEMENT_LINK);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 12: Verify Brand Is Deleted '" + brandName + "'");
		assertNotEquals(adminBrandManagementPage.getBrandNameByRownNumber("1", "2"), brandName);
	}

	@Test
	public void TC_09_Create_Brand_Use_Option(Method method) {
		ExtentTestManager.startTest(method.getName(), "Create Brand By Use Option");
		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 01: Open Create A New Brand Page");
		adminBrandManagementPage.openCreateANewBrand(GlobalConstants_TW.CREATE_A_NEW_BRAND_BUTTON);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 02: Upload Avatar");
		adminCreateNewBrandPage.upLoadMultipleFiles(driver, imageAvatart);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 03: Verify Image Upload Successfully");
		assertTrue(adminCreateNewBrandPage.isAvatarUpLoaded());

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 04: Input Brand Name '" + brandName + "'");
		adminCreateNewBrandPage.enterToBrandNameTextBox(brandName);

//		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 05: Select Field '" + GlobalConstants_TW.FIELD_DROPDOWN_LIST + "'");
//		adminCreateNewBrandPage.selectField(GlobalConstants_TW.FIELD_DROPDOWN_LIST);

//		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 05: Input Partner Name '" + GlobalConstants_TW.PARTNER_NAME_SEARCH_FIELD + "'");
//		adminCreateNewBrandPage.enterToPartNameTextBox(GlobalConstants_TW.PARTNER_NAME_SEARCH_FIELD);
//
//		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 06: Select Partner Name '" + GlobalConstants_TW.PARTNER_NAME_AND_EMAIL_SEARCH_FIELD + "'");
//		adminCreateNewBrandPage.selectPartnerByName(GlobalConstants_TW.PARTNER_NAME_AND_EMAIL_SEARCH_FIELD);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 07: Click on 'Use' button");
		adminCreateNewBrandPage.clickOnButtonByName(GlobalConstants_TW.USE_BUTTON_TW);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 08: Input Email '" + partnerEmailAddress + "'");
		adminCreateNewBrandPage.enterToEmailTextBox(partnerEmailAddress);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 09: Click On Password Setting Button");
		adminCreateNewBrandPage.clickToPasswordSettingButton(GlobalConstants_TW.PASSWORD_SETTING_TW);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 10: Input Password '" + GlobalConstants_TW.PASSWORD + "'");
		adminCreateNewBrandPage.enterToPasswordTextBox(GlobalConstants_TW.PASSWORD);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 11: Input Confirm Password '" + GlobalConstants_TW.PASSWORD + "'");
		adminCreateNewBrandPage.enterToConfirmPasswordTextBox(GlobalConstants_TW.PASSWORD);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 12: Click on 'Save' button");
		adminCreateNewBrandPage.clickSaveButton(GlobalConstants_TW.SAVE_BUTTON_TW);
		adminBrandManagementPage = PageGeneratorManager.getManagementPage(driver);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management - Step 13: Verify Brand has just been created in Brand Management list");
		adminBrandManagementPage.isTextCreatedBrandAtRowDisplayed("合作夥伴", "1",
				GlobalConstants_TW.PARTNER_NAME_SEARCH_FIELD);
		adminBrandManagementPage.isTextCreatedBrandAtRowDisplayed("品牌管理", "1", brandName);
		// adminBrandManagementPage.isTextCreatedBrandAtRowDisplayed("분야", "1",
		// GlobalConstants_TW.FIELD_DROPDOWN_LIST);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 14: Delete Brand");
		adminBrandManagementPage.clickToDeleteButtonByRownNumber("1",
				GlobalConstants_TW.DELETE_BUTTON_AT_BRAND_MANAGEMENT_PAGE_TW);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 15: Close Delete Brand Popup");
		adminBrandManagementPage.clickToClosePopupCancelButton();
	}

	@Test
	public void TC_10_Delete_Brand_Advertiser_Has_CamPaign(Method method) {
		ExtentTestManager.startTest(method.getName(), "Delete Brand Has Campaign");
		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 01: Search Brand '"
				+ GlobalConstants_TW.BRAND_NAME_HAS_CAMPAIGN_MANAGER_ROLE_TW + "'");
		adminBrandManagementPage.enterToSearchBrandTextBox(GlobalConstants_TW.BRAND_NAME_HAS_CAMPAIGN_MANAGER_ROLE_TW);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 02: Click on Search Button");
		adminBrandManagementPage.clickToResetButton();

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 03: Search Brand '"
				+ GlobalConstants_TW.BRAND_NAME_HAS_CAMPAIGN_MANAGER_ROLE_TW + "'");
		adminBrandManagementPage.enterToSearchBrandTextBox(GlobalConstants_TW.BRAND_NAME_HAS_CAMPAIGN_MANAGER_ROLE_TW);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 04: Click on Search Button");
		adminBrandManagementPage.clickToSearchButton();

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 05: Click on Delete Button");
		adminBrandManagementPage.clickToDeleteButtonByRownNumber("1",
				GlobalConstants_TW.DELETE_BUTTON_AT_BRAND_MANAGEMENT_PAGE_TW);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 06: Verify Message Popup is Displayed");
		assertTrue(adminBrandManagementPage.isPopupDisplayed());

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 07: Change to English Language");
		adminBrandManagementPage.openSelectLanguageList(driver, GlobalConstants_TW.ENGLISH_LANGUAGE);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 08: Verify Message Popup translate to English");
		assertEquals(adminBrandManagementPage.getTitlePopup(), "Delete Brand");
		assertEquals(adminBrandManagementPage.getTextMessage(),
				"You cannot delete the brand that has any campaign history.");
		assertEquals(adminBrandManagementPage.getDeleteButtonText(), "Confirm");

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 09: Change to Taiwan Language");
		adminBrandManagementPage.openSelectLanguageList(driver, GlobalConstants_TW.TAIWAN_LANGUAGE);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 10: Verify Message Popup translate to Taiwan");
		assertEquals(adminBrandManagementPage.getTitlePopup(), "刪除品牌");
		assertEquals(adminBrandManagementPage.getTextMessage(), "您無法刪除具有任何專案活動記錄的品牌。");
		assertEquals(adminBrandManagementPage.getDeleteButtonText(), "確認");

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 11: Click On Confirm Button");
		adminBrandManagementPage.clickToDeleteButton();

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 12: Verify Brand Is Not Deleted");
		assertEquals(adminBrandManagementPage.getBrandNameByRownNumber("1", "3"),
				GlobalConstants_TW.BRAND_NAME_HAS_CAMPAIGN_MANAGER_ROLE_TW);
	}

	@Test
	public void TC_11_Edit_Brand_Information(Method method) {
		ExtentTestManager.startTest(method.getName(), "Edit Brand Information");
		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 01: Refesh Page");
		adminBrandManagementPage.refeshCurrentPage(driver);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 02: Click on 'Advertiser Brand Management Link");
		adminBrandManagementPage.clickOnByMenuNameLink(driver, GlobalConstants_TW.ADVERTISER_MANAGEMENT_LINK);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 03: Click on 'Brand Management Link");
		adminBrandManagementPage.openByNameLink(driver, GlobalConstants_TW.BRAND_MANAGEMENT_LINK);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 01: Click on 'Create a new Brand' Button");
		adminBrandManagementPage.openCreateANewBrand(GlobalConstants_TW.CREATE_A_NEW_BRAND_BUTTON);
		adminCreateNewBrandPage = PageGeneratorManager.getCreateANewBrandPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 02: Upload Avatar");
		adminCreateNewBrandPage.upLoadMultipleFiles(driver, imageAvatart);
		assertTrue(adminCreateNewBrandPage.isAvatarUpLoaded());

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 03: Input Brand Name");
		adminCreateNewBrandPage.enterToBrandNameTextBox(brandName);

//		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 04: Select Field");
//		adminCreateNewBrandPage.selectField(GlobalConstants_TW.FIELD_DROPDOWN_LIST);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 05: Input Partner Name '"
				+ GlobalConstants_TW.PARTNER_NAME_SEARCH_FIELD + "'");
		adminCreateNewBrandPage.enterToPartNameTextBox(GlobalConstants_TW.PARTNER_NAME_SEARCH_FIELD);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 05: Select Partner Name '"
				+ GlobalConstants_TW.PARTNER_NAME_AND_EMAIL_SEARCH_FIELD + "'");
		adminCreateNewBrandPage.selectPartnerByName(GlobalConstants_TW.PARTNER_NAME_AND_EMAIL_SEARCH_FIELD);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 06: Click on 'Save' button");
		adminCreateNewBrandPage.clickSaveButton(GlobalConstants_TW.SAVE_BUTTON_TW);
		adminBrandManagementPage = PageGeneratorManager.getManagementPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 08: Search Brand '" + brandName + "'");
		adminBrandManagementPage.enterToSearchBrandTextBox(brandName);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 09: Click on Search Button");
		adminBrandManagementPage.clickToSearchButton();

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 10: Open Brand Information Detail Page");
		adminBrandManagementPage.clickToBrandNameByRownNumber("1", brandName);
		adminDetailBrandPage = PageGeneratorManager.getDetailBrandPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 11: Get Current Page URL");
		getCurrentUrl = adminDetailBrandPage.getPageUrl(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 12: Get Current Page ID");
		getCurrentPageID = adminDetailBrandPage.getParentID(driver);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management - Step 13: Verify Brand Information Detail Page");
		assertEquals(adminDetailBrandPage.getSeeBrandTextButton(), GlobalConstants_TW.SEE_BRAND_BUTTON);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 14: Open See Brand Partner Page");
		adminDetailBrandPage.clickToSeeBrandPageButton();

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 15: Switch To Advertiser Page");
		adminDetailBrandPage.switchTab(GlobalConstants_TW.ADVERTISER_TEST_URL);
		advertiserDashBoardPage = PageGeneratorManager.getAdvertiserDashBoardPage(driver);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management - Step 16: Verify Advertiser Name '" + brandName + "'");
		assertEquals(advertiserDashBoardPage.getPartnerName(), brandName);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 17: Switch To Edit Brand Page");
		advertiserDashBoardPage.switchTab(getCurrentUrl);
		adminDetailBrandPage = PageGeneratorManager.getDetailBrandPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 18: Close Advertiser Page");
		advertiserDashBoardPage.closeTab(getCurrentPageID);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management - Step 19: Verify Change To Brand Information Successfully");
		assertEquals(adminDetailBrandPage.getSeeBrandTextButton(),
				GlobalConstants_TW.TITLE_BRAND_MANGEMENT_DETAIL_PAGE_TW);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 20: Click on Use Button");
		adminDetailBrandPage.clickOnButtonByName(GlobalConstants_TW.USE_BUTTON_TW);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management - Step 21: Enter Emaill Address'" + partnerEmailAddress + "'");
		adminDetailBrandPage.enterToEmailTextBox(partnerEmailAddress);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 22: Open Setting Password");
		adminDetailBrandPage.clickToPasswordSettingButton(GlobalConstants_TW.PASSWORD_SETTING_TW);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 23: Enter To Password TextBox");
		adminDetailBrandPage.enterToPasswordTextBox(GlobalConstants_TW.PASSWORD);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 24: Enter To Confirm Password TextBox");
		adminDetailBrandPage.enterToConfirmPasswordTextBox(GlobalConstants_TW.PASSWORD);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 25: Click On Save Button");
		adminDetailBrandPage.clickSaveButton(GlobalConstants_TW.SAVE_BUTTON_TW);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management - Step 26: Verify Email Alerady Exists In System Taiwan Language");
		assertEquals(adminDetailBrandPage.getErrorMessageAtEmailTextBox(), "此信箱已註冊");

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 27: Change To English Language");
		adminDetailBrandPage.openSelectLanguageList(driver, GlobalConstants_TW.ENGLISH_LANGUAGE);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management - Step 28: Verify Email Alerady Exists In System English Language");
		assertEquals(adminDetailBrandPage.getErrorMessageAtEmailTextBox(), "The email has already been taken.");

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 29: Change To Taiwan Language");
		adminDetailBrandPage.openSelectLanguageList(driver, GlobalConstants_TW.TAIWAN_LANGUAGE);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 30: Log Out Manager Account");
		adminDetailBrandPage.clickOnLogOutButton();
		adminHomePage = PageGeneratorManager.getHomePage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 31: Verify Login Page");
		assertTrue(adminHomePage.isLoginButtonDisplayed());

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 32: Open Login Form");
		adminHomePage.openLoginPopup();

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 33: Switch To Advertiser Tab");
		adminHomePage.clickToAdvertiserTab("客戶");

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 34: Enter To Email TextBox");
		adminHomePage.enterToEmailAdvertiserTextBox(partnerEmailAddress);

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 35: Enter To Password TextBox");
		adminHomePage.enterToPasswordAdvertiserTextBox(GlobalConstants_TW.PASSWORD);

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 36: Open Advertiser Page");
		advertiserDashBoardPage = adminHomePage.openAdvertiserPage(GlobalConstants_TW.LOGIN_BUTTON);
		advertiserDashBoardPage = PageGeneratorManager.getAdvertiserDashBoardPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 37: Open Advertiser Page Successfull");
		assertTrue(advertiserDashBoardPage.isDeliveryMenuDisplayed());
	}

	@Parameters({ "browser" })
	@AfterClass(alwaysRun = true)
	public void afterClass(String browserName) {
		ExtentTestManager.getTest().log(Status.INFO, "Close broser '" + browserName + "'");
		closeBrowserAndDriver();
	}
}
