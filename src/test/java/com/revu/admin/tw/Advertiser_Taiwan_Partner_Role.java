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
import commons.GlobalConstants_TW;
import commons.PageGeneratorManager;
import environmentConfig.Environment;
import pageObjects.revu.Admin.AdminDashBoardObject;
import pageObjects.revu.Admin.AdminHomePageObject;
import pageObjects.revu.Advertiser.AdvertiserDashBoardPageObject;
import pageObjects.revu.Partner.PartnerBrandManagementObject;
import pageObjects.revu.Partner.PartnerCreateBrandManagementObject;
import pageObjects.revu.Partner.PartnerDetailBrandManagementObject;
import reportConfig.ExtentTestManager;

public class Advertiser_Taiwan_Partner_Role extends BaseTest {

	WebDriver driver;
	AdminDashBoardObject adminDashBoardPage;
	AdminHomePageObject adminHomePage;
	PartnerBrandManagementObject partnerBrandManagementPage;
	AdvertiserDashBoardPageObject advertiserDashBoardPage;
	PartnerDetailBrandManagementObject partnerDetailBrandPage;
	PartnerCreateBrandManagementObject partnerCreateNewBrandPage;
	String partnerEmailAddress, getCurrentUrl, getCurrentPageID, representativeName;
	String imageAvatart = "Avatar.jpg";
	String brandName;

	Environment environment;
	@Parameters({"envName", "serverName", "browser" , "osName", "osVersion"})
	@BeforeClass
	public void beforeClass(@Optional("local") String envName, @Optional("DEV") String serverName,@Optional("chrome") String browserName,@Optional("Windows") String osName,@Optional("10") String osVersion) {
		// Maven
//		String environmentName = System.getProperty("envMaven");
//		ConfigFactory.setProperty("envOwner", environmentName);
//		environment = ConfigFactory.create(Environment.class);
//		driver = getBrowserDriver(browserName, environment.appUrl());

		driver = getBrowserDriver(envName, serverName, browserName, osName, osVersion);

		adminHomePage = PageGeneratorManager.getHomePage(driver);
		brandName = "Automation_Brand_" + generateNumber();
		partnerEmailAddress = "Automation_Email_" + generateNumber() + "@yopmail.com";
		representativeName = "Automation_Representative" + generateNumber();
	}

	@Test
	public void TC_01_Open_Admin_Page_And_Select_Country(Method method) {
		ExtentTestManager.startTest(method.getName(), "Open Admin Page And Select Country");
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 01: Open Login popup");

		adminHomePage.openLoginPopup();

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 02: Select Country");
		adminHomePage.openSelectCountryList();
		adminHomePage.selectCountry("Taiwan");
	}

	@Test
	public void TC_02_Login_To_DashBoard_Page(Method method) {
		ExtentTestManager.startTest(method.getName(), "Login To DasbhBoard Page");
		ExtentTestManager.getTest().log(Status.INFO, "Admin Page - Step 01: Enter Email'" + GlobalConstants_TW.EMAIL_PARTNER_ROLE + "'");
		adminHomePage.enterToEmailTextbox(GlobalConstants_TW.EMAIL_PARTNER_ROLE);

		ExtentTestManager.getTest().log(Status.INFO, "Admin Page - Step 02: Enter Password'" + GlobalConstants_TW.PASSWORD + "'");
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
		partnerBrandManagementPage = PageGeneratorManager.getPartnerBrandMangementPage(driver);
		
		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 03: Verify Title Brand Management Page is Displayed");
		assertEquals(partnerBrandManagementPage.getTitlePageName(driver), GlobalConstants_TW.TITLE_BRAND_MANGEMENT_PAGE_TW);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 04: Verify Place Holder Of Search Text Box is Taiwan Text");
		assertTrue(partnerBrandManagementPage.isSearchTextBoxDisplayed(GlobalConstants_TW.PLACE_HOLDER_SEARCH_TEXTBOX_TW));

//		ExtentTestManager.getTest().log(Status.INFO,
//				"Brand Management Page - Step 04: Verify Brand label is Taiwan languages");
//		assertTrue(partnerBrandManagementPage.isPlaceHolderDisplayed("브랜드명", GlobalConstants.PLACE_HOLDER_TEXTBOX_KR));
//
//		ExtentTestManager.getTest().log(Status.INFO,
//				"Brand Management Page - Step 05: Verify Field label is Taiwan languages");
//		assertTrue(partnerBrandManagementPage.isPlaceHolderFieldDropDownListDisplayed("분야", GlobalConstants.PLACE_HOLDER_FIELD_DROPDOWN_LIST_KR));
//
//		ExtentTestManager.getTest().log(Status.INFO,
//				"Brand Management Page - Step 07: Verify Representative label is Taiwan languages");
//		assertTrue(partnerBrandManagementPage.isPlaceHolderDisplayed("담당자명", GlobalConstants.PLACE_HOLDER_TEXTBOX_KR));
//
//		ExtentTestManager.getTest().log(Status.INFO,
//				"Brand Management Page - Step 08: Verify Partner label is Taiwan languages");
//		assertTrue(partnerBrandManagementPage.isPlaceHolderDisplayed("브랜드명", GlobalConstants.PLACE_HOLDER_TEXTBOX_KR));
//
//		ExtentTestManager.getTest().log(Status.INFO,
//				"Brand Management Page - Step 09: Verify Email label is Taiwan languages");
//		assertTrue(partnerBrandManagementPage.isPlaceHolderDisplayed("이메일", GlobalConstants.PLACE_HOLDER_TEXTBOX_KR));
//
//		ExtentTestManager.getTest().log(Status.INFO,
//				"Brand Management Page - Step 10: Verify Phone label is Taiwan languages");
//		assertTrue(partnerBrandManagementPage.isPlaceHolderDisplayed("휴대전화", GlobalConstants.PLACE_HOLDER_PHONE_TEXTBOX_KR));
//
//		ExtentTestManager.getTest().log(Status.INFO,
//				"Brand Management Page - Step 11: Verify Search button is Taiwan languages");
//		assertTrue(partnerBrandManagementPage.isButtonDisplayed("검색"));
//
//		ExtentTestManager.getTest().log(Status.INFO,
//				"Brand Management Page - Step 12: Verify Reset button is Taiwan languages");
//		assertTrue(partnerBrandManagementPage.isButtonDisplayed("초기화"));
//
//		ExtentTestManager.getTest().log(Status.INFO,
//				"Brand Management Page - Step 06: Verify Brand No. column is Taiwan languages");
//		assertTrue(partnerBrandManagementPage.isColumnNameDisplayed("브랜드 번호"));
//
//		ExtentTestManager.getTest().log(Status.INFO,
//				"Brand Management Page - Step 07: Verify Partner column is Taiwan languages");
//		assertTrue(partnerBrandManagementPage.isColumnNameDisplayed("파트너명"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 05: Verify Brand column is Taiwan languages");
		assertTrue(partnerBrandManagementPage.isColumnNameDisplayed("品牌管理"));

//		ExtentTestManager.getTest().log(Status.INFO,
//				"Brand Management Page - Step 06: Verify Field column is Taiwan languages");
//		assertTrue(partnerBrandManagementPage.isColumnNameDisplayed("분야"));

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
//
//		ExtentTestManager.getTest().log(Status.INFO,
//				"Brand Management Page - Step 15: Verify Date of Creation column is Taiwan languages");
//		assertTrue(partnerBrandManagementPage.isColumnNameDisplayed("생성 일자"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 11: Verify Delete column is Taiwan languages");
		assertTrue(partnerBrandManagementPage.isColumnNameDisplayed("刪除品牌"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 12: Verify Delete button is Taiwan languages");
		assertTrue(partnerBrandManagementPage.isTextAtRowDisplayed("삭제", "1", GlobalConstants_TW.DELETE_BUTTON_AT_BRAND_MANAGEMENT_PAGE_TW));
	}

	@Test
	public void TC_04_Check_Translate_To_English_Brand_Management_Page(Method method) {
		ExtentTestManager.startTest(method.getName(), "Check Translate To English At Brand Management Page");
		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 01: Change to English Language");
		partnerBrandManagementPage.openSelectLanguageList(driver, GlobalConstants_TW.ENGLISH_LANGUAGE);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 02: Verify Brand Management Page is Displayed");
		assertEquals(partnerBrandManagementPage.getTitlePageName(driver), GlobalConstants_TW.TITLE_BRAND_MANGEMENT_PAGE_EN);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 03: Verify Place Holder Of Search Text Box is English Text");
		assertTrue(partnerBrandManagementPage.isSearchTextBoxDisplayed(GlobalConstants_TW.PLACE_HOLDER_SEARCH_TEXTBOX_EN));

//		ExtentTestManager.getTest().log(Status.INFO,
//				"Brand Management Page - Step 03: Verify Brand label is English languages");
//		assertTrue(partnerBrandManagementPage.isPlaceHolderDisplayed("Brand", GlobalConstants.PLACE_HOLDER_TEXTBOX_EN));
//
//		ExtentTestManager.getTest().log(Status.INFO,
//				"Brand Management Page - Step 04: Verify Field label is English languages");
//		assertTrue(partnerBrandManagementPage.isPlaceHolderFieldDropDownListDisplayed("Field", GlobalConstants.PLACE_HOLDER_FIELD_DROPDOWN_LIST_EN));
//
//		ExtentTestManager.getTest().log(Status.INFO,
//				"Brand Management Page - Step 05: Verify Representative label is English languages");
//		assertTrue(partnerBrandManagementPage.isPlaceHolderDisplayed("Representative", GlobalConstants.PLACE_HOLDER_TEXTBOX_EN));
//
//		ExtentTestManager.getTest().log(Status.INFO,
//				"Brand Management Page - Step 06: Verify Partner label is English languages");
//		assertTrue(partnerBrandManagementPage.isPlaceHolderDisplayed("Partner", GlobalConstants.PLACE_HOLDER_TEXTBOX_EN));
//
//		ExtentTestManager.getTest().log(Status.INFO,
//				"Brand Management Page - Step 07: Verify Email label is English languages");
//		assertTrue(partnerBrandManagementPage.isPlaceHolderDisplayed("Email", GlobalConstants.PLACE_HOLDER_TEXTBOX_EN));
//
//		ExtentTestManager.getTest().log(Status.INFO,
//				"Brand Management Page - Step 08: Verify Phone label is English languages");
//		assertTrue(partnerBrandManagementPage.isPlaceHolderDisplayed("Phone", GlobalConstants.PLACE_HOLDER_PHONE_TEXTBOX_EN));
//
//		ExtentTestManager.getTest().log(Status.INFO,
//				"Brand Management Page - Step 09: Verify Search button is English languages");
//		assertTrue(partnerBrandManagementPage.isButtonDisplayed("Search"));
//
//		ExtentTestManager.getTest().log(Status.INFO,
//				"Brand Management Page - Step 10: Verify Reset button is English languages");
//		assertTrue(partnerBrandManagementPage.isButtonDisplayed("Reset"));
//
//		ExtentTestManager.getTest().log(Status.INFO,
//				"Brand Management Page - Step 04: Verify Brand No. column is English languages");
//		assertTrue(partnerBrandManagementPage.isColumnNameDisplayed("Brand No."));
//
//		ExtentTestManager.getTest().log(Status.INFO,
//				"Brand Management Page - Step 05: Verify Partner column is English languages");
//		assertTrue(partnerBrandManagementPage.isColumnNameDisplayed("Partner"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 04: Verify Brand column is English languages");
		assertTrue(partnerBrandManagementPage.isColumnNameDisplayed("Brand"));

//		ExtentTestManager.getTest().log(Status.INFO,
//				"Brand Management Page - Step 05: Verify Field column is English languages");
//		assertTrue(partnerBrandManagementPage.isColumnNameDisplayed("Field"));

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

//		ExtentTestManager.getTest().log(Status.INFO,
//				"Brand Management Page - Step 13: Verify Date of Creation column is English languages");
//		assertTrue(partnerBrandManagementPage.isColumnNameDisplayed("Date of Creation"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 10: Verify Delete column is English languages");
		assertTrue(partnerBrandManagementPage.isColumnNameDisplayed("Delete"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 11: Verify Delete button is English languages");
		assertTrue(partnerBrandManagementPage.isTextAtRowDisplayed("Delete", "1", GlobalConstants_TW.DELETE_BUTTON_AT_BRAND_MANAGEMENT_PAGE_EN));

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 12: Change to Taiwan Language");
		partnerBrandManagementPage.openSelectLanguageList(driver, GlobalConstants_TW.TAIWAN_LANGUAGE);
	}

	@Test
	public void TC_05_Check_Translate_To_Taiwan_Create_Brand_Page(Method method) {
		ExtentTestManager.startTest(method.getName(), "Check Translate To Taiwan At Create Brand Page");
		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 01: Click on 'Create a new Brand' Button");
		partnerBrandManagementPage.openCreateANewBrand(GlobalConstants_TW.CREATE_A_NEW_BRAND_BUTTON);
		partnerCreateNewBrandPage = PageGeneratorManager.getPartnerCreateANewBrandPage(driver);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 02: Verify Open 'Create New Brand Page' Successfull");
		assertEquals(partnerCreateNewBrandPage.getTitlePageName(driver), GlobalConstants_TW.TITLE_BRAND_MANGEMENT_DETAIL_PAGE_TW);
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
		assertTrue(partnerCreateNewBrandPage.isPlaceHolderByLabelNameDisplayed("品牌", GlobalConstants_TW.PLACE_HOLDER_TEXTBOX_TW));

//		ExtentTestManager.getTest().log(Status.INFO,
//				"Create Brand Page - Step 07: Verify Partner area translate to Taiwan");
//		assertTrue(partnerCreateNewBrandPage.isPlaceHolderByLabelNameDisplayed("파트너", GlobalConstants.PLACE_HOLDER_PARTNER_DROPDOWN_LIST_KR));
//
		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 07: Verify Account Setting area translate to Taiwan");
		assertTrue(partnerCreateNewBrandPage.isAccountSettingDisplayed("帳戶設定"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 08: Verify Use button translate to Taiwan");
		assertTrue(partnerCreateNewBrandPage.isButtonNameDisplayed(GlobalConstants_TW.USE_BUTTON_TW));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 09: Verify Nonuse button translate to Taiwan");
		assertTrue(partnerCreateNewBrandPage.isButtonNameDisplayed(GlobalConstants_TW.NON_USE_BUTTON_TW));

//		ExtentTestManager.getTest().log(Status.INFO,
//				"Create Brand Page - Step 10: Verify Field area translate to Taiwan");
//		assertTrue(
//				partnerCreateNewBrandPage.isPlaceHolderByDropDownListNameDisplayed("분야", GlobalConstants_TW.PLACE_HOLDER_FIELD_DROPDOWN_LIST_KR));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 10: Verify Save button translate to Taiwan");
		assertTrue(partnerCreateNewBrandPage.isSaveButtonDisplayed(GlobalConstants_TW.SAVE_BUTTON_TW));

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 11: Verify Save button is disabled");
		assertFalse(partnerCreateNewBrandPage.isSaveButtonDisabled(GlobalConstants_TW.SAVE_BUTTON_TW));

//		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 12: Verify Field after selecting value");
//		partnerCreateNewBrandPage.selectField(GlobalConstants_TW.FIELD_DROPDOWN_LIST);
//		assertTrue(partnerCreateNewBrandPage.isPlaceHolderByDropDownListNameDisplayed("분야", GlobalConstants_TW.FIELD_DROPDOWN_LIST));

//		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 12: Verify Save button is disabled");
//		assertTrue(partnerCreateNewBrandPage.isSaveButtonDisabled(GlobalConstants_TW.SAVE_BUTTON_TW));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 13: Verify Account Information After Clicking On 'Use' Button");
		partnerCreateNewBrandPage.clickOnButtonByName(GlobalConstants_TW.USE_BUTTON_TW);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 14: Verify Email area translate to Taiwan");
		assertTrue(partnerCreateNewBrandPage.isPlaceHolderByLabelNameDisplayed("電子信件", GlobalConstants_TW.PLACE_HOLDER_TEXTBOX_TW));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 15: Verify Password area translate to Taiwan");
		assertTrue(partnerCreateNewBrandPage.isLabelByNameDisplayed("密碼"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 16: Verify Password Setting button translate to Taiwan");
		assertEquals(partnerCreateNewBrandPage.getTextResetPasswordButton(), GlobalConstants_TW.PASSWORD_SETTING_TW);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 17: Verify Representative area translate to Taiwan");
		assertTrue(partnerCreateNewBrandPage.isPlaceHolderByLabelNameDisplayed("負責人", GlobalConstants_TW.PLACE_HOLDER_TEXTBOX_TW));

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 18: Input Representative");
		partnerCreateNewBrandPage.enterToRepresentativeTextBox(representativeName);
		
		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 19: Verify Phone area translate to Taiwan");
		assertTrue(partnerCreateNewBrandPage.isPlaceHolderByLabelNameDisplayed("電話", GlobalConstants_TW.PLACE_HOLDER_PHONE_TEXTBOX_TW));

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 20: Verify Refesh Current Page");
		partnerCreateNewBrandPage.refeshCurrentPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 21: Verify Save button is disabled");
		assertFalse(partnerCreateNewBrandPage.isSaveButtonDisabled(GlobalConstants_TW.SAVE_BUTTON_TW));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 22: Verify Account Information After Clicking On 'Use' Button");
		partnerCreateNewBrandPage.clickOnButtonByName(GlobalConstants_TW.USE_BUTTON_TW);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 24: Click on Password Setting Button");
		partnerCreateNewBrandPage.clickToPasswordSettingButton(GlobalConstants_TW.PASSWORD_SETTING_TW);
		
		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 25: Verify Passwors Setting will be changed to Cancel Setting");
		assertEquals(partnerCreateNewBrandPage.getTextResetPasswordButton(), GlobalConstants_TW.CANCEL_SETTING_TW);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 26: Enter Password '" + GlobalConstants_TW.PASSWORD + "'");
		partnerCreateNewBrandPage.enterToPasswordTextBox(GlobalConstants_TW.PASSWORD);
		
		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 27: Enter Confirm Password is not match '" + GlobalConstants_TW.INCORRECT_PASSWORD + "'");
		partnerCreateNewBrandPage.enterToConfirmPasswordTextBox(GlobalConstants_TW.INCORRECT_PASSWORD);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 28: Click on 'Save' Button");
		partnerCreateNewBrandPage.clickSaveButton(GlobalConstants_TW.SAVE_BUTTON_TW);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 29: Verify Error Message At Brand Name textbox translate to Taiwan");
		assertEquals(partnerCreateNewBrandPage.getErrorMessageAtBrandNameTextBox(), "此欄位為必填。");

//		ExtentTestManager.getTest().log(Status.INFO,
//				"Create Brand Page - Step 31: Verify Error Message At Field DropDown List translate to Taiwan");
//		assertEquals(partnerCreateNewBrandPage.getErrorMessageAtFieldDropdownList(), "필수입력사항 입니다.");

//		ExtentTestManager.getTest().log(Status.INFO,
//				"Create Brand Page - Step 32: Verify Error Message At Partner dropdown list translate to Taiwan");
//		assertEquals(partnerCreateNewBrandPage.getErrorMessageAtPartnerDropdownList(), "필수입력사항 입니다.");

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 30: Verify Error Message At Email textbox translate to Taiwan");
		assertEquals(partnerCreateNewBrandPage.getErrorMessageAtEmailTextBox(), "此欄位為必填。");

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 31: Verify Error Message At Confirm Password textbox translate to Taiwan");
		assertEquals(partnerCreateNewBrandPage.getErrorMessageAtConfirmPasswordTextBox(), "確認不相符.");
		
		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 32: Enter To Email TextBox Wrong Email Format");
		partnerCreateNewBrandPage.enterToEmailTextBox(GlobalConstants_TW.WRONG_EMAIL_FORMAT);
		
		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 33: Click On Save Button");
		partnerCreateNewBrandPage.clickSaveButton(GlobalConstants_TW.SAVE_BUTTON_TW);
		
		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 34: Verify Error Message At Email textbox translate to Taiwan When Inputting Wrong Email Format");
		assertEquals(partnerCreateNewBrandPage.getErrorMessageAtEmailTextBox(), "無效的輸入.");
	}

	@Test
	public void TC_06_Check_Translate_To_English_Create_Brand_Page(Method method) {
		ExtentTestManager.startTest(method.getName(), "Check Translate To English At Create Brand Page");
		ExtentTestManager.getTest().log(Status.INFO,"Create Brand Page - Step 01: Refresh Current Page");
		partnerCreateNewBrandPage.refeshCurrentPage(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 02: Change to English Language");
		partnerCreateNewBrandPage.openSelectLanguageList(driver, GlobalConstants_TW.ENGLISH_LANGUAGE);
		
		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 03: Verify Title of Company Information section translate to English");
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
		assertTrue(partnerCreateNewBrandPage.isPlaceHolderByLabelNameDisplayed("Brand",GlobalConstants_TW.PLACE_HOLDER_TEXTBOX_EN));
//
//		ExtentTestManager.getTest().log(Status.INFO,
//				"Create Brand Page - Step 08: Verify Partner area translate to English");
//		assertTrue(
//				partnerCreateNewBrandPage.isPlaceHolderByLabelNameDisplayed("Partner", GlobalConstants.PLACE_HOLDER_PARTNER_DROPDOWN_LIST_EN));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 08: Verify Account Setting area translate to English");
		assertTrue(partnerCreateNewBrandPage.isAccountSettingDisplayed("Account Setting"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 09: Verify Use button translate to English");
		assertTrue(partnerCreateNewBrandPage.isButtonNameDisplayed(GlobalConstants_TW.USE_BUTTON_EN));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 10: Verify Nonuse button translate to English");
		assertTrue(partnerCreateNewBrandPage.isButtonNameDisplayed(GlobalConstants_TW.NON_USE_BUTTON_EN));

//		ExtentTestManager.getTest().log(Status.INFO,
//				"Create Brand Page - Step 11: Verify Field area translate to English");
//		assertTrue(partnerCreateNewBrandPage.isPlaceHolderByDropDownListNameDisplayed("Field",GlobalConstants_TW.PLACE_HOLDER_FIELD_DROPDOWN_LIST_EN));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 11: Verify Save button translate to English");
		assertTrue(partnerCreateNewBrandPage.isSaveButtonDisplayed(GlobalConstants_TW.SAVE_BUTTON_EN));

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 12: Verify Save button is disabled");
		assertFalse(partnerCreateNewBrandPage.isSaveButtonDisabled(GlobalConstants_TW.SAVE_BUTTON_EN));

//		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 14: Verify Field after selecting value");
//		partnerCreateNewBrandPage.selectField(GlobalConstants_TW.FIELD_DROPDOWN_LIST);
//		assertTrue(partnerCreateNewBrandPage.isPlaceHolderByDropDownListNameDisplayed("Field", GlobalConstants_TW.FIELD_DROPDOWN_LIST));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 13: Verify Account Information After Clicking On 'Use' Button");
		partnerCreateNewBrandPage.clickOnButtonByName(GlobalConstants_TW.USE_BUTTON_EN);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 14: Verify Email area translate to English");
		assertTrue(partnerCreateNewBrandPage.isPlaceHolderByLabelNameDisplayed("Email", GlobalConstants_TW.PLACE_HOLDER_TEXTBOX_EN));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 15: Verify Password area translate to English");
		assertTrue(partnerCreateNewBrandPage.isLabelByNameDisplayed("Password"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 16: Verify Reset Password button translate to English");
		assertEquals(partnerCreateNewBrandPage.getTextResetPasswordButton(), GlobalConstants_TW.PASSWORD_SETTING_EN);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 17: Verify Representative area translate to English");
		assertTrue(partnerCreateNewBrandPage.isPlaceHolderByLabelNameDisplayed("Representative", GlobalConstants_TW.PLACE_HOLDER_TEXTBOX_EN));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 18: Verify Phone area translate to English");
		assertTrue(partnerCreateNewBrandPage.isPlaceHolderByLabelNameDisplayed("Phone", GlobalConstants_TW.PLACE_HOLDER_PHONE_TEXTBOX_EN));

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 19: Verify Refesh Current Page");
		partnerCreateNewBrandPage.refeshCurrentPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 20: Verify Save button is disabled");
		assertFalse(partnerCreateNewBrandPage.isSaveButtonDisabled(GlobalConstants_TW.SAVE_BUTTON_EN));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 21: Verify Account Information After Clicking On 'Use' Button");
		partnerCreateNewBrandPage.clickOnButtonByName(GlobalConstants_TW.USE_BUTTON_EN);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 22: Click On Password Setting Button");
		partnerCreateNewBrandPage.clickToPasswordSettingButton(GlobalConstants_TW.PASSWORD_SETTING_EN);
		
		ExtentTestManager.getTest().log(Status.INFO,"Create Brand Page - Step 23: Verify Reset Password will be changed to Cancel Setting");
		assertEquals(partnerCreateNewBrandPage.getTextResetPasswordButton(), GlobalConstants_TW.CANCEL_SETTING_EN);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 24: Enter Password '" + GlobalConstants_TW.PASSWORD + "'");
		partnerCreateNewBrandPage.enterToPasswordTextBox(GlobalConstants_TW.PASSWORD);
		
		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 25: Enter Confirm Password is not match '" + GlobalConstants_TW.INCORRECT_PASSWORD + "'");
		partnerCreateNewBrandPage.enterToConfirmPasswordTextBox(GlobalConstants_TW.INCORRECT_PASSWORD);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 26: Click on 'Save' Button");
		partnerCreateNewBrandPage.clickSaveButton(GlobalConstants_TW.SAVE_BUTTON_EN);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 27: Verify Error Message At Brand Name textbox translate to English");
		assertEquals(partnerCreateNewBrandPage.getErrorMessageAtBrandNameTextBox(), "This field is required.");
		
		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 28: Verify Error Message At Confirm Password textbox translate to English");
		assertEquals(partnerCreateNewBrandPage.getErrorMessageAtConfirmPasswordTextBox(),
				"The confirmation does not match.");

//		ExtentTestManager.getTest().log(Status.INFO,
//				"Create Brand Page - Step 31: Verify Error Message At Field DropDown List translate to English");
//		assertEquals(partnerCreateNewBrandPage.getErrorMessageAtFieldDropdownList(), "The selected value is invalid.");

//		ExtentTestManager.getTest().log(Status.INFO,
//				"Create Brand Page - Step 33: Verify Error Message At Partner dropdown list translate to English");
//		assertEquals(partnerCreateNewBrandPage.getErrorMessageAtPartnerDropdownList(), "This field is required.");

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 29: Verify Error Message At Email textbox translate to English");
		assertEquals(partnerCreateNewBrandPage.getErrorMessageAtEmailTextBox(),
				"The email field is required when account setting is use.");

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 30: Enter To Email TextBox Wrong Email Format");
		partnerCreateNewBrandPage.enterToEmailTextBox(GlobalConstants_TW.WRONG_EMAIL_FORMAT);
		
		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 31: Click On Save Button");
		partnerCreateNewBrandPage.clickSaveButton(GlobalConstants_TW.SAVE_BUTTON_EN);
		
		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 32: Verify Error Message At Email textbox translate to Taiwan When Inputting Wrong Email Format");
		assertEquals(partnerCreateNewBrandPage.getErrorMessageAtEmailTextBox(), "The email must be a valid email address.");
	}

	@Test
	public void TC_07_Create_Brand_Non_Use_Option(Method method) {
		ExtentTestManager.startTest(method.getName(), "Create Brand By Nonuse Option");
		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 01: Refesh Current Page");
		partnerCreateNewBrandPage.refeshCurrentPage(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 02: Change to Taiwan Language");
		partnerCreateNewBrandPage.openSelectLanguageList(driver, GlobalConstants_TW.TAIWAN_LANGUAGE);
		
		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 03: Upload Avatar");
		partnerCreateNewBrandPage.upLoadMultipleFiles(driver, imageAvatart);
		
		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 04: Verify Image Is Uploaded Successfully");
		assertTrue(partnerCreateNewBrandPage.isAvatarUpLoaded());

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 05: Input Brand Name '" + brandName + "'");
		partnerCreateNewBrandPage.enterToBrandNameTextBox(brandName);

//		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 06: Select Field '" + GlobalConstants_TW.FIELD_DROPDOWN_LIST + "'");
//		partnerCreateNewBrandPage.selectField(GlobalConstants_TW.FIELD_DROPDOWN_LIST);

//		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 07: Input Partner Name '" + GlobalConstants.PARTNER_NAME_SEARCH_FIELD + "'");
//		partnerCreateNewBrandPage.enterToPartNameTextBox(GlobalConstants.PARTNER_NAME_SEARCH_FIELD);
//
//		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 08: Select Partner Name '" + GlobalConstants.PARTNER_NAME_AND_EMAIL_SEARCH_FIELD + "'");
//		partnerCreateNewBrandPage.selectPartnerByName(GlobalConstants.PARTNER_NAME_AND_EMAIL_SEARCH_FIELD);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 06: Click on 'Save' button");
		partnerCreateNewBrandPage.clickSaveButton(GlobalConstants_TW.SAVE_BUTTON_TW);
		partnerBrandManagementPage = PageGeneratorManager.getPartnerBrandMangementPage(driver);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management - Step 07: Verify Brand has just been created in Brand Management list");
//		assertTrue(partnerBrandManagementPage.isTextCreatedBrandAtRowDisplayed("파트너명", "1", GlobalConstants.PARTNER_NAME_SEARCH_FIELD));
		assertTrue(partnerBrandManagementPage.isTextCreatedBrandAtRowDisplayed("브랜드명", "1", brandName));
//		assertTrue(partnerBrandManagementPage.isTextCreatedBrandAtRowDisplayed("분야", "1", GlobalConstants_TW.FIELD_DROPDOWN_LIST));

	}

	@Test
	public void TC_08_Delete_Brand_Advertiser_Do_Not_Have_CamPaign(Method method) {
		ExtentTestManager.startTest(method.getName(), "Delete Brand Do Not Have Campaign");
		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 01: Input Brand Name '" + brandName + "'");
		partnerBrandManagementPage.enterToSearchBrandTextBox(brandName);

		//ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 02: Click on Search Button");
		//partnerBrandManagementPage.clickToSearchButton();

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 03: Click on Delete Button");
		partnerBrandManagementPage.clickToDeleteButtonByRownNumber("1", GlobalConstants_TW.DELETE_BUTTON);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 04: Verify Message Popup is Displayed");
		assertTrue(partnerBrandManagementPage.isPopupDisplayed());

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 05: Verify Message Popup translate to English");
		partnerBrandManagementPage.openSelectLanguageList(driver, "English");
		assertEquals(partnerBrandManagementPage.getTitlePopup(), "Delete Brand");
		assertEquals(partnerBrandManagementPage.getTextMessage(),
				"Are you sure you want to delete this brand? You can't undo this action.");
		assertEquals(partnerBrandManagementPage.getDeleteButtonText(), "Delete");
		assertEquals(partnerBrandManagementPage.getCancelButtonText(), "Cancel");

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 06: Verify Message Popup translate to Taiwan");
		partnerBrandManagementPage.openSelectLanguageList(driver, GlobalConstants_TW.TAIWAN_LANGUAGE);
		assertEquals(partnerBrandManagementPage.getTitlePopup(), "刪除品牌");
		assertEquals(partnerBrandManagementPage.getTextMessage(), "您確定想要刪除這個品牌？您將無法回復此步驟。");
		assertEquals(partnerBrandManagementPage.getDeleteButtonText(), "刪除");
		assertEquals(partnerBrandManagementPage.getCancelButtonText(), "取消");

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 07: Close Popup By X Icon");
		partnerBrandManagementPage.clickToClosePopupByIcon();

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 08: Click To Delete Button");
		partnerBrandManagementPage.clickToDeleteButtonByRownNumber("1", GlobalConstants_TW.DELETE_BUTTON);
		
		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 09: Close Popup By Clicking On Cancel Button");
		partnerBrandManagementPage.clickToClosePopupCancelButton();

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 10: Delete Brand");
		partnerBrandManagementPage.clickToDeleteButtonByRownNumber("1", GlobalConstants_TW.DELETE_BUTTON);
		partnerBrandManagementPage.clickToDeleteButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 11: Refesh Current Page");
		partnerBrandManagementPage.refeshCurrentPage(driver);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 11: Click on 'Advertiser Management Link");
		partnerBrandManagementPage.clickOnByMenuNameLink(driver, GlobalConstants_TW.ADVERTISER_MANAGEMENT_LINK);
		
		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 12: Click on 'Brand Management Link");
		partnerBrandManagementPage.openByNameLink(driver, GlobalConstants_TW.BRAND_MANAGEMENT_LINK);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 13: Verify Brand Is Deleted '" + brandName + "'");
		assertNotEquals(partnerBrandManagementPage.getBrandNameByRownNumber("1", "1"), brandName);
	}

	@Test
	public void TC_09_Create_Brand_Use_Option(Method method) {
		ExtentTestManager.startTest(method.getName(), "Create Brand By Use Option");
		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 01: Open Create A New Brand Page");
		partnerBrandManagementPage.openCreateANewBrand(GlobalConstants_TW.CREATE_A_NEW_BRAND_BUTTON);
		
		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 02: Upload Avatar");
		partnerCreateNewBrandPage.upLoadMultipleFiles(driver, imageAvatart);
		
		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 03: Verify Image Upload Successfully");
		assertTrue(partnerCreateNewBrandPage.isAvatarUpLoaded());

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 04: Input Brand Name '" + brandName + "'");
		partnerCreateNewBrandPage.enterToBrandNameTextBox(brandName);

//		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 05: Select Field '" + GlobalConstants_TW.FIELD_DROPDOWN_LIST + "'");
//		partnerCreateNewBrandPage.selectField(GlobalConstants_TW.FIELD_DROPDOWN_LIST);

//		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 06: Input Partner Name '" + GlobalConstants.PARTNER_NAME_SEARCH_FIELD + "'");
//		partnerCreateNewBrandPage.enterToPartNameTextBox(GlobalConstants.PARTNER_NAME_SEARCH_FIELD);
//
//		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 07: Select Partner Name '" + GlobalConstants.PARTNER_NAME_AND_EMAIL_SEARCH_FIELD + "'");
//		partnerCreateNewBrandPage.selectPartnerByName(GlobalConstants.PARTNER_NAME_AND_EMAIL_SEARCH_FIELD);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 05: Click on 'Use' button");
		partnerCreateNewBrandPage.clickOnButtonByName(GlobalConstants_TW.USE_BUTTON_TW);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 06: Input Email '" + partnerEmailAddress + "'");
		partnerCreateNewBrandPage.enterToEmailTextBox(partnerEmailAddress);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 07: Click On Password Setting Button");
		partnerCreateNewBrandPage.clickToPasswordSettingButton(GlobalConstants_TW.PASSWORD_SETTING_TW);
		
		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 08: Input Password '" + GlobalConstants_TW.PASSWORD + "'");
		partnerCreateNewBrandPage.enterToPasswordTextBox(GlobalConstants_TW.PASSWORD);
		
		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 09: Input Confirm Password '" + GlobalConstants_TW.PASSWORD + "'");
		partnerCreateNewBrandPage.enterToConfirmPasswordTextBox(GlobalConstants_TW.PASSWORD);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 10: Click on 'Save' button");
		partnerCreateNewBrandPage.clickSaveButton(GlobalConstants_TW.SAVE_BUTTON_TW);
		partnerBrandManagementPage = PageGeneratorManager.getPartnerBrandMangementPage(driver);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management - Step 11: Verify Brand has just been created in Brand Management list");
//		partnerBrandManagementPage.isTextCreatedBrandAtRowDisplayed("파트너명", "1", GlobalConstants.PARTNER_NAME_SEARCH_FIELD);
		partnerBrandManagementPage.isTextCreatedBrandAtRowDisplayed("브랜드명", "1", brandName);
//		partnerBrandManagementPage.isTextCreatedBrandAtRowDisplayed("분야", "1", GlobalConstants_TW.FIELD_DROPDOWN_LIST);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 12: Delete Brand");
		partnerBrandManagementPage.clickToDeleteButtonByRownNumber("1", GlobalConstants_TW.DELETE_BUTTON_AT_BRAND_MANAGEMENT_PAGE_TW);
		
		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 13: Close Delete Brand Popup");
		partnerBrandManagementPage.clickToClosePopupCancelButton();
	}

	@Test
	public void TC_10_Delete_Brand_Advertiser_Has_CamPaign(Method method) {
		ExtentTestManager.startTest(method.getName(), "Delete Brand Has Campaign");
		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 01: Search Brand '" + GlobalConstants_TW.BRAND_NAME_HAS_CAMPAIGN_PARTNER_ROLE_KR + "'");
		partnerBrandManagementPage.enterToSearchBrandTextBox(GlobalConstants_TW.BRAND_NAME_HAS_CAMPAIGN_PARTNER_ROLE_KR);

//		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 02: Click on Search Button");
//		partnerBrandManagementPage.clickToResetButton();

//		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 02: Search Brand '" + GlobalConstants.BRAND_NAME_HAS_CAMPAIGN_PARTNER_ROLE_KR + "'");
//		partnerBrandManagementPage.enterToSearchBrandTextBox(GlobalConstants.BRAND_NAME_HAS_CAMPAIGN_PARTNER_ROLE_KR);

//		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 03: Click on Search Button");
//		partnerBrandManagementPage.clickToSearchButton();

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 03: Click on Delete Button");
		partnerBrandManagementPage.clickToDeleteButtonByRownNumber("1", GlobalConstants_TW.DELETE_BUTTON_AT_BRAND_MANAGEMENT_PAGE_TW);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 04: Verify Message Popup is Displayed");
		assertTrue(partnerBrandManagementPage.isPopupDisplayed());

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 05: Change to English Language");
		partnerBrandManagementPage.openSelectLanguageList(driver, GlobalConstants_TW.ENGLISH_LANGUAGE);
		
		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 06: Verify Message Popup translate to English");
		assertEquals(partnerBrandManagementPage.getTitlePopup(), "Delete Brand");
		assertEquals(partnerBrandManagementPage.getTextMessage(),"You cannot delete the brand that has any campaign history.");
		assertEquals(partnerBrandManagementPage.getDeleteButtonText(), "Confirm");

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 07: Change to Taiwan Language");
		partnerBrandManagementPage.openSelectLanguageList(driver, GlobalConstants_TW.TAIWAN_LANGUAGE);
		
		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 08: Verify Message Popup translate to Taiwan");
		assertEquals(partnerBrandManagementPage.getTitlePopup(), "刪除品牌");
		assertEquals(partnerBrandManagementPage.getTextMessage(), "您無法刪除具有任何專案活動記錄的品牌。");
		assertEquals(partnerBrandManagementPage.getDeleteButtonText(), "確認");
		
		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 09: Click On Confirm Button");
		partnerBrandManagementPage.clickToDeleteButton();

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 10: Verify Brand Is Not Deleted");
		assertEquals(partnerBrandManagementPage.getBrandNameByRownNumber("1", "1"), GlobalConstants_TW.BRAND_NAME_HAS_CAMPAIGN_PARTNER_ROLE_KR);
	}

	@Test
	public void TC_11_Edit_Brand_Information(Method method) {
		ExtentTestManager.startTest(method.getName(), "Edit Brand Information");
		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 01: Refesh Page");
		partnerBrandManagementPage.refeshCurrentPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 02: Click on 'Advertiser Brand Management Link");
		partnerBrandManagementPage.clickOnByMenuNameLink(driver, GlobalConstants_TW.ADVERTISER_MANAGEMENT_LINK);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 03: Click on 'Brand Management Link");
		partnerBrandManagementPage.openByNameLink(driver, GlobalConstants_TW.BRAND_MANAGEMENT_LINK);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 01: Click on 'Create a new Brand' Button");
		partnerBrandManagementPage.openCreateANewBrand(GlobalConstants_TW.CREATE_A_NEW_BRAND_BUTTON);
		partnerCreateNewBrandPage = PageGeneratorManager.getPartnerCreateANewBrandPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 02: Upload Avatar");
		partnerCreateNewBrandPage.upLoadMultipleFiles(driver, imageAvatart);
		assertTrue(partnerCreateNewBrandPage.isAvatarUpLoaded());

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 03: Input Brand Name");
		partnerCreateNewBrandPage.enterToBrandNameTextBox(brandName);

//		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 04: Select Field");
//		partnerCreateNewBrandPage.selectField(GlobalConstants_TW.FIELD_DROPDOWN_LIST);

//		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 05: Input Partner Name '" + GlobalConstants.PARTNER_NAME_SEARCH_FIELD + "'");
//		partnerCreateNewBrandPage.enterToPartNameTextBox(GlobalConstants.PARTNER_NAME_SEARCH_FIELD);
//
//		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 06: Select Partner Name '" + GlobalConstants.PARTNER_NAME_AND_EMAIL_SEARCH_FIELD + "'");
//		partnerCreateNewBrandPage.selectPartnerByName(GlobalConstants.PARTNER_NAME_AND_EMAIL_SEARCH_FIELD);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 05: Click on 'Save' button");
		partnerCreateNewBrandPage.clickSaveButton(GlobalConstants_TW.SAVE_BUTTON_TW);
		partnerBrandManagementPage = PageGeneratorManager.getPartnerBrandMangementPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 06: Search Brand '" + brandName + "'");
		partnerBrandManagementPage.enterToSearchBrandTextBox(brandName);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 07: Click on Search Button");
		partnerBrandManagementPage.clickToSearchButton();

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 08: Open Brand Information Detail Page");
		partnerBrandManagementPage.clickToBrandNameByRownNumber("1", brandName);
		partnerDetailBrandPage = PageGeneratorManager.getPartnerDetailBrandPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 09: Get Current Page URL");
		getCurrentUrl = partnerDetailBrandPage.getPageUrl(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 10: Get Current Page ID");
		getCurrentPageID = partnerDetailBrandPage.getParentID(driver);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management - Step 11: Verify Brand Information Detail Page");
		assertEquals(partnerDetailBrandPage.getSeeBrandTextButton(), GlobalConstants_TW.SEE_BRAND_BUTTON);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 12: Open See Brand Partner Page");
		partnerDetailBrandPage.clickToSeeBrandPageButton();

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 13: Switch To Advertiser Page");
		partnerDetailBrandPage.switchTab(GlobalConstants_TW.ADVERTISER_TEST_URL);
		advertiserDashBoardPage = PageGeneratorManager.getAdvertiserDashBoardPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 14: Verify Advertiser Name '" + brandName + "'");
		assertEquals(advertiserDashBoardPage.getPartnerName(), brandName);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 15: Switch To Edit Brand Page");
		advertiserDashBoardPage.switchTab(getCurrentUrl);
		partnerDetailBrandPage = PageGeneratorManager.getPartnerDetailBrandPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 16: Close Advertiser Page");
		advertiserDashBoardPage.closeTab(getCurrentPageID);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management - Step 17: Verify Change To Brand Information Successfully");
		assertEquals(partnerDetailBrandPage.getSeeBrandTextButton(), GlobalConstants_TW.SEE_BRAND_BUTTON);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 18: Click on Use Button");
		partnerDetailBrandPage.clickOnButtonByName(GlobalConstants_TW.USE_BUTTON_TW);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management - Step 19: Enter Emaill Address'" + partnerEmailAddress + "'");
		partnerDetailBrandPage.enterToEmailTextBox(partnerEmailAddress);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 20: Open Setting Password");
		partnerDetailBrandPage.clickToPasswordSettingButton("직접 설정");

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 21: Enter To Password TextBox");
		partnerDetailBrandPage.enterToPasswordTextBox(GlobalConstants_TW.PASSWORD);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 22: Enter To Confirm Password TextBox");
		partnerDetailBrandPage.enterToConfirmPasswordTextBox(GlobalConstants_TW.PASSWORD);
		
		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 23: Click On Save Button");
		partnerDetailBrandPage.clickSaveButton(GlobalConstants_TW.SAVE_BUTTON_TW);
		
		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 24: Verify Email Alerady Exists In System Taiwan Language");
		assertEquals(partnerDetailBrandPage.getErrorMessageAtEmailTextBox(),"此信箱已註冊");
		
		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 25: Change To English Language");
		partnerDetailBrandPage.openSelectLanguageList(driver, GlobalConstants_TW.ENGLISH_LANGUAGE);
		
		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 26: Verify Email Alerady Exists In System English Language");
		assertEquals(partnerDetailBrandPage.getErrorMessageAtEmailTextBox(),"The email has already been taken.");

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 27: Change To Taiwan Language");
		partnerDetailBrandPage.openSelectLanguageList(driver, GlobalConstants_TW.TAIWAN_LANGUAGE);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 28: Log Out Manager Account");
		partnerDetailBrandPage.clickOnLogOutButton();
		adminHomePage = PageGeneratorManager.getHomePage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 29: Verify Login Page");
		assertTrue(adminHomePage.isLoginButtonDisplayed());

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 30: Open Login Form");
		adminHomePage.openLoginPopup();

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 31: Switch To Advertiser Tab");
		adminHomePage.clickToAdvertiserTab("客戶");

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 32: Enter To Email TextBox");
		adminHomePage.enterToEmailAdvertiserTextBox(partnerEmailAddress);

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 33: Enter To Password TextBox");
		adminHomePage.enterToPasswordAdvertiserTextBox(GlobalConstants_TW.PASSWORD);

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 34: Open Advertiser Page");
		advertiserDashBoardPage = adminHomePage.openAdvertiserPage(GlobalConstants_TW.LOGIN_BUTTON);
		advertiserDashBoardPage = PageGeneratorManager.getAdvertiserDashBoardPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 35: Open Advertiser Page Successfull");
		assertTrue(advertiserDashBoardPage.isDeliveryMenuDisplayed());
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}
}
