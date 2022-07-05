package com.revu.admin.kr;

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
import commons.GlobalConstants_KR;
import commons.PageGeneratorManager;
import environmentConfig.Environment;
import pageObjects.revu.Admin.AdminDashBoardObject;
import pageObjects.revu.Admin.AdminHomePageObject;
import pageObjects.revu.Advertiser.AdvertiserDashBoardPageObject;
import pageObjects.revu.Partner.PartnerBrandManagementObject;
import pageObjects.revu.Partner.PartnerCreateBrandManagementObject;
import pageObjects.revu.Partner.PartnerDetailBrandManagementObject;
import reportConfig.ExtentTestManager;

public class Advertiser_Korea_Partner_Role extends BaseTest {

	WebDriver driver;
	AdminDashBoardObject adminDashBoardPage;
	AdminHomePageObject adminHomePage;
	PartnerBrandManagementObject partnerBrandManagementPage;
	AdvertiserDashBoardPageObject advertiserDashBoardPage;
	PartnerDetailBrandManagementObject partnerDetailBrandPage;
	PartnerCreateBrandManagementObject partnerCreateNewBrandPage;
	String partnerEmailAddress, getCurrentUrl, getCurrentPageID;
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
	}

	@Test
	public void TC_01_Open_Admin_Page_And_Select_Country(Method method) {
		ExtentTestManager.startTest(method.getName(), "Open Admin Page And Select Country");
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 01: Open Login popup");

		adminHomePage.openLoginPopup();

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 02: Select Country");
		adminHomePage.openSelectCountryList();
		adminHomePage.selectCountry("Korea");
	}

	@Test
	public void TC_02_Login_To_DashBoard_Page(Method method) {
		ExtentTestManager.startTest(method.getName(), "Login To DasbhBoard Page");
		ExtentTestManager.getTest().log(Status.INFO, "Admin Page - Step 01: Enter Email'" + GlobalConstants_KR.EMAIL_PARTNER_ROLE + "'");
		adminHomePage.enterToEmailTextbox(GlobalConstants_KR.EMAIL_PARTNER_ROLE);

		ExtentTestManager.getTest().log(Status.INFO, "Admin Page - Step 02: Enter Password'" + GlobalConstants_KR.PASSWORD + "'");
		adminHomePage.enterToPasswordTextbox(GlobalConstants_KR.PASSWORD);

		ExtentTestManager.getTest().log(Status.INFO, "Admin Page - Step 03: Click on Submit button");
		adminDashBoardPage = adminHomePage.openAdminDashBoardPage("로그인");

		ExtentTestManager.getTest().log(Status.INFO, "Admin Page - Step 04: Verify Login Successfull");
		assertTrue(adminDashBoardPage.isLogOutLinkDisplayed());
	}

	@Test
	public void TC_03_Check_Translate_To_Korea_Brand_Management_Page(Method method) {
		ExtentTestManager.startTest(method.getName(), "Check Translate To Korea At Brand Management Page");
		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 01: Click on 'Advertiser Brand Management Link");
		adminDashBoardPage.clickOnByMenuNameLink(driver, GlobalConstants_KR.ADVERTISER_MANAGEMENT_LINK);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 02: Click on 'Brand Management Link");
		adminDashBoardPage.openByNameLink(driver, GlobalConstants_KR.BRAND_MANAGEMENT_LINK);
		partnerBrandManagementPage = PageGeneratorManager.getPartnerBrandMangementPage(driver);
		
		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 03: Verify (브랜드 관리) Brand Management Page is Displayed");
		assertEquals(partnerBrandManagementPage.getTitlePageName(driver), "브랜드 관리\n+ 새 브랜드 생성");

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 04: Verify Place Holder Of Search Text Box is Korea Text");
		assertTrue(partnerBrandManagementPage.isSearchTextBoxDisplayed(GlobalConstants_KR.PLACE_HOLDER_SEARCH_TEXTBOX_KR));

//		ExtentTestManager.getTest().log(Status.INFO,
//				"Brand Management Page - Step 04: Verify Brand label is Korea languages");
//		assertTrue(partnerBrandManagementPage.isPlaceHolderDisplayed("브랜드명", GlobalConstants.PLACE_HOLDER_TEXTBOX_KR));
//
//		ExtentTestManager.getTest().log(Status.INFO,
//				"Brand Management Page - Step 05: Verify Field label is Korea languages");
//		assertTrue(partnerBrandManagementPage.isPlaceHolderFieldDropDownListDisplayed("분야", GlobalConstants.PLACE_HOLDER_FIELD_DROPDOWN_LIST_KR));
//
//		ExtentTestManager.getTest().log(Status.INFO,
//				"Brand Management Page - Step 07: Verify Representative label is Korea languages");
//		assertTrue(partnerBrandManagementPage.isPlaceHolderDisplayed("담당자명", GlobalConstants.PLACE_HOLDER_TEXTBOX_KR));
//
//		ExtentTestManager.getTest().log(Status.INFO,
//				"Brand Management Page - Step 08: Verify Partner label is Korea languages");
//		assertTrue(partnerBrandManagementPage.isPlaceHolderDisplayed("브랜드명", GlobalConstants.PLACE_HOLDER_TEXTBOX_KR));
//
//		ExtentTestManager.getTest().log(Status.INFO,
//				"Brand Management Page - Step 09: Verify Email label is Korea languages");
//		assertTrue(partnerBrandManagementPage.isPlaceHolderDisplayed("이메일", GlobalConstants.PLACE_HOLDER_TEXTBOX_KR));
//
//		ExtentTestManager.getTest().log(Status.INFO,
//				"Brand Management Page - Step 10: Verify Phone label is Korea languages");
//		assertTrue(partnerBrandManagementPage.isPlaceHolderDisplayed("휴대전화", GlobalConstants.PLACE_HOLDER_PHONE_TEXTBOX_KR));
//
//		ExtentTestManager.getTest().log(Status.INFO,
//				"Brand Management Page - Step 11: Verify Search button is Korea languages");
//		assertTrue(partnerBrandManagementPage.isButtonDisplayed("검색"));
//
//		ExtentTestManager.getTest().log(Status.INFO,
//				"Brand Management Page - Step 12: Verify Reset button is Korea languages");
//		assertTrue(partnerBrandManagementPage.isButtonDisplayed("초기화"));
//
//		ExtentTestManager.getTest().log(Status.INFO,
//				"Brand Management Page - Step 06: Verify Brand No. column is Korea languages");
//		assertTrue(partnerBrandManagementPage.isColumnNameDisplayed("브랜드 번호"));
//
//		ExtentTestManager.getTest().log(Status.INFO,
//				"Brand Management Page - Step 07: Verify Partner column is Korea languages");
//		assertTrue(partnerBrandManagementPage.isColumnNameDisplayed("파트너명"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 05: Verify Brand column is Korea languages");
		assertTrue(partnerBrandManagementPage.isColumnNameDisplayed("브랜드명"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 06: Verify Field column is Korea languages");
		assertTrue(partnerBrandManagementPage.isColumnNameDisplayed("분야"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 07: Verify Email	column is Korea languages");
		assertTrue(partnerBrandManagementPage.isColumnNameDisplayed("이메일"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 08: Verify Representative column is Korea languages");
		assertTrue(partnerBrandManagementPage.isColumnNameDisplayed("담당자명"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 09: Verify Phone column is Korea languages");
		assertTrue(partnerBrandManagementPage.isColumnNameDisplayed("휴대전화"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 10: Verify Camp. On-going column is Korea languages");
		assertTrue(partnerBrandManagementPage.isColumnNameDisplayed("캠페인 진행중"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 11: Verify Camp. Completed column is Korea languages");
		assertTrue(partnerBrandManagementPage.isColumnNameDisplayed("캠페인 종료"));
//
//		ExtentTestManager.getTest().log(Status.INFO,
//				"Brand Management Page - Step 15: Verify Date of Creation column is Korea languages");
//		assertTrue(partnerBrandManagementPage.isColumnNameDisplayed("생성 일자"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 12: Verify Delete column is Korea languages");
		assertTrue(partnerBrandManagementPage.isColumnNameDisplayed("삭제"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 13: Verify Delete button is Korea languages");
		assertTrue(partnerBrandManagementPage.isTextAtRowDisplayed("삭제", "1", "삭제하기"));
	}

	@Test
	public void TC_04_Check_Translate_To_English_Brand_Management_Page(Method method) {
		ExtentTestManager.startTest(method.getName(), "Check Translate To English At Brand Management Page");
		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 01: Change to English Language");
		partnerBrandManagementPage.openSelectLanguageList(driver, GlobalConstants_KR.ENGLISH_LANGUAGE);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 02: Verify Brand Management Page is Displayed");
		assertEquals(partnerBrandManagementPage.getTitlePageName(driver), "Brand Management\n+ Create a new brand");

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 03: Verify Place Holder Of Search Text Box is English Text");
		assertTrue(partnerBrandManagementPage.isSearchTextBoxDisplayed(GlobalConstants_KR.PLACE_HOLDER_SEARCH_TEXTBOX_EN));

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

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 05: Verify Field column is English languages");
		assertTrue(partnerBrandManagementPage.isColumnNameDisplayed("Field"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 06: Verify Email	column is English languages");
		assertTrue(partnerBrandManagementPage.isColumnNameDisplayed("Email"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 07: Verify Representative column is English languages");
		assertTrue(partnerBrandManagementPage.isColumnNameDisplayed("Representative"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 08: Verify Phone column is English languages");
		assertTrue(partnerBrandManagementPage.isColumnNameDisplayed("Phone"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 09: Verify Camp. On-going column is English languages");
		assertTrue(partnerBrandManagementPage.isColumnNameDisplayed("Camp. On-going"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 10: Verify Camp. Completed column is English languages");
		assertTrue(partnerBrandManagementPage.isColumnNameDisplayed("Camp. Completed"));

//		ExtentTestManager.getTest().log(Status.INFO,
//				"Brand Management Page - Step 13: Verify Date of Creation column is English languages");
//		assertTrue(partnerBrandManagementPage.isColumnNameDisplayed("Date of Creation"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 11: Verify Delete column is English languages");
		assertTrue(partnerBrandManagementPage.isColumnNameDisplayed("Delete"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 12: Verify Delete button is English languages");
		assertTrue(partnerBrandManagementPage.isTextAtRowDisplayed("Delete", "1", "Delete"));

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 13: Change to Korea Language");
		partnerBrandManagementPage.openSelectLanguageList(driver, GlobalConstants_KR.KOREA_LANGUAGE);
	}

	@Test
	public void TC_05_Check_Translate_To_Korea_Create_Brand_Page(Method method) {
		ExtentTestManager.startTest(method.getName(), "Check Translate To Korea At Create Brand Page");
		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 01: Click on 'Create a new Brand' Button");
		partnerBrandManagementPage.openCreateANewBrand(GlobalConstants_KR.CREATE_A_NEW_BRAND_BUTTON);
		partnerCreateNewBrandPage = PageGeneratorManager.getPartnerCreateANewBrandPage(driver);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 02: Verify Open 'Create New Brand Page' Successfull");
		assertEquals(partnerCreateNewBrandPage.getTitlePageName(driver), "브랜드 정보");
		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 03: Verify Title of Company Information section translate to Korea");
		assertEquals(partnerCreateNewBrandPage.getTitleComPanyInformation(), "회사 정보");

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 04: Verify Title of Account Information section translate to Korea");
		assertEquals(partnerCreateNewBrandPage.getTitleAccountInformation(), "계정 정보");

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 05: Verify Profile area translate to Korea");
		assertTrue(partnerCreateNewBrandPage.isLabelByNameDisplayed("프로필"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 06: Verify Brand area translate to Korea");
		assertTrue(partnerCreateNewBrandPage.isPlaceHolderByLabelNameDisplayed("브랜드명", GlobalConstants_KR.PLACE_HOLDER_TEXTBOX_KR));

//		ExtentTestManager.getTest().log(Status.INFO,
//				"Create Brand Page - Step 07: Verify Partner area translate to Korea");
//		assertTrue(partnerCreateNewBrandPage.isPlaceHolderByLabelNameDisplayed("파트너", GlobalConstants.PLACE_HOLDER_PARTNER_DROPDOWN_LIST_KR));
//
		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 07: Verify Account Setting area translate to Korea");
		assertTrue(partnerCreateNewBrandPage.isAccountSettingDisplayed("계정 설정"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 08: Verify Use button translate to Korea");
		assertTrue(partnerCreateNewBrandPage.isButtonNameDisplayed(GlobalConstants_KR.USE_BUTTON_KR));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 09: Verify Nonuse button translate to Korea");
		assertTrue(partnerCreateNewBrandPage.isButtonNameDisplayed(GlobalConstants_KR.NON_USE_BUTTON_KR));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 10: Verify Field area translate to Korea");
		assertTrue(
				partnerCreateNewBrandPage.isPlaceHolderByDropDownListNameDisplayed("분야", GlobalConstants_KR.PLACE_HOLDER_FIELD_DROPDOWN_LIST_KR));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 11: Verify Save button translate to Korea");
		assertTrue(partnerCreateNewBrandPage.isSaveButtonDisplayed(GlobalConstants_KR.SAVE_BUTTON_KR));

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 12: Verify Save button is disabled");
		assertFalse(partnerCreateNewBrandPage.isSaveButtonDisabled(GlobalConstants_KR.SAVE_BUTTON_KR));

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 13: Verify Field after selecting value");
		partnerCreateNewBrandPage.selectField(GlobalConstants_KR.FIELD_DROPDOWN_LIST);
		assertTrue(partnerCreateNewBrandPage.isPlaceHolderByDropDownListNameDisplayed("분야", GlobalConstants_KR.FIELD_DROPDOWN_LIST));

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 14: Verify Save button is disabled");
		assertTrue(partnerCreateNewBrandPage.isSaveButtonDisabled(GlobalConstants_KR.SAVE_BUTTON_KR));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 15: Verify Account Information After Clicking On 'Use' Button");
		partnerCreateNewBrandPage.clickOnButtonByName(GlobalConstants_KR.USE_BUTTON_KR);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 16: Verify Email area translate to Korea");
		assertTrue(partnerCreateNewBrandPage.isPlaceHolderByLabelNameDisplayed("이메일", GlobalConstants_KR.PLACE_HOLDER_TEXTBOX_KR));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 17: Verify Password area translate to Korea");
		assertTrue(partnerCreateNewBrandPage.isLabelByNameDisplayed("비밀번호"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 18: Verify Reset Password button translate to Korea");
		assertEquals(partnerCreateNewBrandPage.getTextResetPasswordButton(), GlobalConstants_KR.RESET_PASSWORD_BUTTON_KR);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 19: Verify Representative area translate to Korea");
		assertTrue(partnerCreateNewBrandPage.isPlaceHolderByLabelNameDisplayed("담당자명", GlobalConstants_KR.PLACE_HOLDER_TEXTBOX_KR));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 20: Verify Phone area translate to Korea");
		assertTrue(partnerCreateNewBrandPage.isPlaceHolderByLabelNameDisplayed("휴대전화", GlobalConstants_KR.PLACE_HOLDER_PHONE_TEXTBOX_KR));

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 21: Verify Refesh Current Page");
		partnerCreateNewBrandPage.refeshCurrentPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 22: Verify Save button is disabled");
		assertFalse(partnerCreateNewBrandPage.isSaveButtonDisabled(GlobalConstants_KR.SAVE_BUTTON_KR));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 23: Verify Account Information After Clicking On 'Use' Button");
		partnerCreateNewBrandPage.clickOnButtonByName(GlobalConstants_KR.USE_BUTTON_KR);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 24: Verify Reset Password button translate to Korea");
		assertEquals(partnerCreateNewBrandPage.getTextResetPasswordButton(), GlobalConstants_KR.PASSWORD_SETTING_KR);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 25: Click on Password Setting Button");
		partnerCreateNewBrandPage.clickToPasswordSettingButton(GlobalConstants_KR.PASSWORD_SETTING_KR);
		
		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 26: Verify Reset Password will be changed to Cancel Setting");
		assertEquals(partnerCreateNewBrandPage.getTextResetPasswordButton(), GlobalConstants_KR.CANCEL_SETTING_KR);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 27: Enter Password '" + GlobalConstants_KR.PASSWORD + "'");
		partnerCreateNewBrandPage.enterToPasswordTextBox(GlobalConstants_KR.PASSWORD);
		
		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 28: Enter Confirm Password is not match '" + GlobalConstants_KR.INCORRECT_PASSWORD + "'");
		partnerCreateNewBrandPage.enterToConfirmPasswordTextBox(GlobalConstants_KR.INCORRECT_PASSWORD);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 29: Click on 'Save' Button");
		partnerCreateNewBrandPage.clickSaveButton(GlobalConstants_KR.SAVE_BUTTON_KR);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 30: Verify Error Message At Brand Name textbox translate to Korea");
		assertEquals(partnerCreateNewBrandPage.getErrorMessageAtBrandNameTextBox(), "필수입력사항 입니다.");

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 31: Verify Error Message At Field DropDown List translate to Korea");
		assertEquals(partnerCreateNewBrandPage.getErrorMessageAtFieldDropdownList(), "필수입력사항 입니다.");

//		ExtentTestManager.getTest().log(Status.INFO,
//				"Create Brand Page - Step 32: Verify Error Message At Partner dropdown list translate to Korea");
//		assertEquals(partnerCreateNewBrandPage.getErrorMessageAtPartnerDropdownList(), "필수입력사항 입니다.");

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 32: Verify Error Message At Email textbox translate to Korea");
		assertEquals(partnerCreateNewBrandPage.getErrorMessageAtEmailTextBox(), "필수입력사항 입니다.");

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 33: Verify Error Message At Confirm Password textbox translate to Korea");
		assertEquals(partnerCreateNewBrandPage.getErrorMessageAtConfirmPasswordTextBox(), "정보가 일치하지 않습니다.");
	}

	@Test
	public void TC_06_Check_Translate_To_English_Create_Brand_Page(Method method) {
		ExtentTestManager.startTest(method.getName(), "Check Translate To English At Create Brand Page");
		ExtentTestManager.getTest().log(Status.INFO,"Create Brand Page - Step 01: Refresh Current Page");
		partnerCreateNewBrandPage.refeshCurrentPage(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 02: Change to English Language");
		partnerCreateNewBrandPage.openSelectLanguageList(driver, GlobalConstants_KR.ENGLISH_LANGUAGE);
		
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
		assertTrue(partnerCreateNewBrandPage.isPlaceHolderByLabelNameDisplayed("Brand",GlobalConstants_KR.PLACE_HOLDER_TEXTBOX_EN));
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
		assertTrue(partnerCreateNewBrandPage.isButtonNameDisplayed(GlobalConstants_KR.USE_BUTTON_EN));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 10: Verify Nonuse button translate to English");
		assertTrue(partnerCreateNewBrandPage.isButtonNameDisplayed(GlobalConstants_KR.NON_USE_BUTTON_EN));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 11: Verify Field area translate to English");
		assertTrue(partnerCreateNewBrandPage.isPlaceHolderByDropDownListNameDisplayed("Field",GlobalConstants_KR.PLACE_HOLDER_FIELD_DROPDOWN_LIST_EN));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 12: Verify Save button translate to English");
		assertTrue(partnerCreateNewBrandPage.isSaveButtonDisplayed(GlobalConstants_KR.SAVE_BUTTON_EN));

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 13: Verify Save button is disabled");
		assertFalse(partnerCreateNewBrandPage.isSaveButtonDisabled(GlobalConstants_KR.SAVE_BUTTON_EN));

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 14: Verify Field after selecting value");
		partnerCreateNewBrandPage.selectField(GlobalConstants_KR.FIELD_DROPDOWN_LIST);
		assertTrue(partnerCreateNewBrandPage.isPlaceHolderByDropDownListNameDisplayed("Field", GlobalConstants_KR.FIELD_DROPDOWN_LIST));

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 15: Verify Save button is disabled");
		assertTrue(partnerCreateNewBrandPage.isSaveButtonDisabled(GlobalConstants_KR.SAVE_BUTTON_EN));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 16: Verify Account Information After Clicking On 'Use' Button");
		partnerCreateNewBrandPage.clickOnButtonByName(GlobalConstants_KR.USE_BUTTON_EN);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 17: Verify Email area translate to English");
		assertTrue(partnerCreateNewBrandPage.isPlaceHolderByLabelNameDisplayed("Email", GlobalConstants_KR.PLACE_HOLDER_TEXTBOX_EN));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 18: Verify Password area translate to English");
		assertTrue(partnerCreateNewBrandPage.isLabelByNameDisplayed("Password"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 19: Verify Reset Password button translate to English");
		assertEquals(partnerCreateNewBrandPage.getTextResetPasswordButton(), GlobalConstants_KR.PASSWORD_SETTING_EN);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 20: Verify Representative area translate to English");
		assertTrue(partnerCreateNewBrandPage.isPlaceHolderByLabelNameDisplayed("Representative", GlobalConstants_KR.PLACE_HOLDER_TEXTBOX_EN));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 21: Verify Phone area translate to English");
		assertTrue(partnerCreateNewBrandPage.isPlaceHolderByLabelNameDisplayed("Phone", GlobalConstants_KR.PLACE_HOLDER_PHONE_TEXTBOX_EN));

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 22: Verify Refesh Current Page");
		partnerCreateNewBrandPage.refeshCurrentPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 23: Verify Save button is disabled");
		assertFalse(partnerCreateNewBrandPage.isSaveButtonDisabled(GlobalConstants_KR.SAVE_BUTTON_EN));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 24: Verify Account Information After Clicking On 'Use' Button");
		partnerCreateNewBrandPage.clickOnButtonByName(GlobalConstants_KR.USE_BUTTON_EN);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 25: Click On Password Setting Button");
		partnerCreateNewBrandPage.clickToPasswordSettingButton(GlobalConstants_KR.PASSWORD_SETTING_EN);
		
		ExtentTestManager.getTest().log(Status.INFO,"Create Brand Page - Step 26: Verify Reset Password will be changed to Cancel Setting");
		assertEquals(partnerCreateNewBrandPage.getTextResetPasswordButton(), GlobalConstants_KR.CANCEL_SETTING_EN);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 27: Enter Password '" + GlobalConstants_KR.PASSWORD + "'");
		partnerCreateNewBrandPage.enterToPasswordTextBox(GlobalConstants_KR.PASSWORD);
		
		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 28: Enter Confirm Password is not match '" + GlobalConstants_KR.INCORRECT_PASSWORD + "'");
		partnerCreateNewBrandPage.enterToConfirmPasswordTextBox(GlobalConstants_KR.INCORRECT_PASSWORD);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 29: Click on 'Save' Button");
		partnerCreateNewBrandPage.clickSaveButton(GlobalConstants_KR.SAVE_BUTTON_EN);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 30: Verify Error Message At Brand Name textbox translate to English");
		assertEquals(partnerCreateNewBrandPage.getErrorMessageAtBrandNameTextBox(), "This field is required.");

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 31: Verify Error Message At Field DropDown List translate to English");
		assertEquals(partnerCreateNewBrandPage.getErrorMessageAtFieldDropdownList(), "The selected value is invalid.");

//		ExtentTestManager.getTest().log(Status.INFO,
//				"Create Brand Page - Step 33: Verify Error Message At Partner dropdown list translate to English");
//		assertEquals(partnerCreateNewBrandPage.getErrorMessageAtPartnerDropdownList(), "This field is required.");

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 32: Verify Error Message At Email textbox translate to English");
		assertEquals(partnerCreateNewBrandPage.getErrorMessageAtEmailTextBox(),
				"The email field is required when account setting is use.");

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 33: Verify Error Message At Confirm Password textbox translate to English");
		assertEquals(partnerCreateNewBrandPage.getErrorMessageAtConfirmPasswordTextBox(),
				"The confirmation does not match.");
	}

	@Test
	public void TC_07_Create_Brand_Non_Use_Option(Method method) {
		ExtentTestManager.startTest(method.getName(), "Create Brand By Nonuse Option");
		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 01: Refesh Current Page");
		partnerCreateNewBrandPage.refeshCurrentPage(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 02: Change to Korea Language");
		partnerCreateNewBrandPage.openSelectLanguageList(driver, GlobalConstants_KR.KOREA_LANGUAGE);
		
		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 03: Upload Avatar");
		partnerCreateNewBrandPage.upLoadMultipleFiles(driver, imageAvatart);
		
		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 04: Verify Image Is Uploaded Successfully");
		assertTrue(partnerCreateNewBrandPage.isAvatarUpLoaded());

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 05: Input Brand Name '" + brandName + "'");
		partnerCreateNewBrandPage.enterToBrandNameTextBox(brandName);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 06: Select Field '" + GlobalConstants_KR.FIELD_DROPDOWN_LIST + "'");
		partnerCreateNewBrandPage.selectField(GlobalConstants_KR.FIELD_DROPDOWN_LIST);

//		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 07: Input Partner Name '" + GlobalConstants.PARTNER_NAME_SEARCH_FIELD + "'");
//		partnerCreateNewBrandPage.enterToPartNameTextBox(GlobalConstants.PARTNER_NAME_SEARCH_FIELD);
//
//		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 08: Select Partner Name '" + GlobalConstants.PARTNER_NAME_AND_EMAIL_SEARCH_FIELD + "'");
//		partnerCreateNewBrandPage.selectPartnerByName(GlobalConstants.PARTNER_NAME_AND_EMAIL_SEARCH_FIELD);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 07: Click on 'Save' button");
		partnerCreateNewBrandPage.clickSaveButton(GlobalConstants_KR.SAVE_BUTTON_KR);
		partnerBrandManagementPage = PageGeneratorManager.getPartnerBrandMangementPage(driver);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management - Step 08: Verify Brand has just been created in Brand Management list");
//		assertTrue(partnerBrandManagementPage.isTextCreatedBrandAtRowDisplayed("파트너명", "1", GlobalConstants.PARTNER_NAME_SEARCH_FIELD));
		assertTrue(partnerBrandManagementPage.isTextCreatedBrandAtRowDisplayed("브랜드명", "1", brandName));
		assertTrue(partnerBrandManagementPage.isTextCreatedBrandAtRowDisplayed("분야", "1", GlobalConstants_KR.FIELD_DROPDOWN_LIST));

	}

	@Test
	public void TC_08_Delete_Brand_Advertiser_Do_Not_Have_CamPaign(Method method) {
		ExtentTestManager.startTest(method.getName(), "Delete Brand Do Not Have Campaign");
		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 01: Input Brand Name '" + brandName + "'");
		partnerBrandManagementPage.enterToSearchBrandTextBox(brandName);

		//ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 02: Click on Search Button");
		//partnerBrandManagementPage.clickToSearchButton();

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 02: Click on Delete Button");
		partnerBrandManagementPage.clickToDeleteButtonByRownNumber("1", GlobalConstants_KR.DELETE_BUTTON);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 03: Verify Message Popup is Displayed");
		assertTrue(partnerBrandManagementPage.isPopupDisplayed());

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 04: Verify Message Popup translate to English");
		partnerBrandManagementPage.openSelectLanguageList(driver, "English");
		assertEquals(partnerBrandManagementPage.getTitlePopup(), "Delete Brand");
		assertEquals(partnerBrandManagementPage.getTextMessage(),
				"Are you sure you want to delete this brand? You can't undo this action.");
		assertEquals(partnerBrandManagementPage.getDeleteButtonText(), "Delete");
		assertEquals(partnerBrandManagementPage.getCancelButtonText(), "Cancel");

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 05: Verify Message Popup translate to Korea");
		partnerBrandManagementPage.openSelectLanguageList(driver, "한국어");
		assertEquals(partnerBrandManagementPage.getTitlePopup(), "브랜드 삭제");
		assertEquals(partnerBrandManagementPage.getTextMessage(), "브랜드를 삭제 하시겠습니까? 삭제된 후에는 다시 복구할 수 없습니다.");
		assertEquals(partnerBrandManagementPage.getDeleteButtonText(), "삭제하기");
		assertEquals(partnerBrandManagementPage.getCancelButtonText(), "취소");

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 06: Close Popup By X Icon");
		partnerBrandManagementPage.clickToClosePopupByIcon();

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 07: Click To Delete Button");
		partnerBrandManagementPage.clickToDeleteButtonByRownNumber("1", GlobalConstants_KR.DELETE_BUTTON);
		
		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 08: Close Popup By Clicking On Cancel Button");
		partnerBrandManagementPage.clickToClosePopupCancelButton();

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 09: Delete Brand");
		partnerBrandManagementPage.clickToDeleteButtonByRownNumber("1", GlobalConstants_KR.DELETE_BUTTON);
		partnerBrandManagementPage.clickToDeleteButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 10: Refesh Current Page");
		partnerBrandManagementPage.refeshCurrentPage(driver);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 11: Click on 'Advertiser Management Link");
		partnerBrandManagementPage.clickOnByMenuNameLink(driver, GlobalConstants_KR.ADVERTISER_MANAGEMENT_LINK);
		
		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 12: Click on 'Brand Management Link");
		partnerBrandManagementPage.openByNameLink(driver, GlobalConstants_KR.BRAND_MANAGEMENT_LINK);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 13: Verify Brand Is Deleted '" + brandName + "'");
		assertNotEquals(partnerBrandManagementPage.getBrandNameByRownNumber("1", "1"), brandName);
	}

	@Test
	public void TC_09_Create_Brand_Use_Option(Method method) {
		ExtentTestManager.startTest(method.getName(), "Create Brand By Use Option");
		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 01: Open Create A New Brand Page");
		partnerBrandManagementPage.openCreateANewBrand(GlobalConstants_KR.CREATE_A_NEW_BRAND_BUTTON);
		
		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 02: Upload Avatar");
		partnerCreateNewBrandPage.upLoadMultipleFiles(driver, imageAvatart);
		
		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 03: Verify Image Upload Successfully");
		assertTrue(partnerCreateNewBrandPage.isAvatarUpLoaded());

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 04: Input Brand Name '" + brandName + "'");
		partnerCreateNewBrandPage.enterToBrandNameTextBox(brandName);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 05: Select Field '" + GlobalConstants_KR.FIELD_DROPDOWN_LIST + "'");
		partnerCreateNewBrandPage.selectField(GlobalConstants_KR.FIELD_DROPDOWN_LIST);

//		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 06: Input Partner Name '" + GlobalConstants.PARTNER_NAME_SEARCH_FIELD + "'");
//		partnerCreateNewBrandPage.enterToPartNameTextBox(GlobalConstants.PARTNER_NAME_SEARCH_FIELD);
//
//		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 07: Select Partner Name '" + GlobalConstants.PARTNER_NAME_AND_EMAIL_SEARCH_FIELD + "'");
//		partnerCreateNewBrandPage.selectPartnerByName(GlobalConstants.PARTNER_NAME_AND_EMAIL_SEARCH_FIELD);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 06: Click on 'Use' button");
		partnerCreateNewBrandPage.clickOnButtonByName(GlobalConstants_KR.USE_BUTTON_KR);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 07: Input Email '" + partnerEmailAddress + "'");
		partnerCreateNewBrandPage.enterToEmailTextBox(partnerEmailAddress);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 08: Click On Password Setting Button");
		partnerCreateNewBrandPage.clickToPasswordSettingButton(GlobalConstants_KR.PASSWORD_SETTING_KR);
		
		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 09: Input Password '" + GlobalConstants_KR.PASSWORD + "'");
		partnerCreateNewBrandPage.enterToPasswordTextBox(GlobalConstants_KR.PASSWORD);
		
		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 10: Input Confirm Password '" + GlobalConstants_KR.PASSWORD + "'");
		partnerCreateNewBrandPage.enterToConfirmPasswordTextBox(GlobalConstants_KR.PASSWORD);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 11: Click on 'Save' button");
		partnerCreateNewBrandPage.clickSaveButton(GlobalConstants_KR.SAVE_BUTTON_KR);
		partnerBrandManagementPage = PageGeneratorManager.getPartnerBrandMangementPage(driver);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management - Step 12: Verify Brand has just been created in Brand Management list");
//		partnerBrandManagementPage.isTextCreatedBrandAtRowDisplayed("파트너명", "1", GlobalConstants.PARTNER_NAME_SEARCH_FIELD);
		partnerBrandManagementPage.isTextCreatedBrandAtRowDisplayed("브랜드명", "1", brandName);
		partnerBrandManagementPage.isTextCreatedBrandAtRowDisplayed("분야", "1", GlobalConstants_KR.FIELD_DROPDOWN_LIST);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 13: Delete Brand");
		partnerBrandManagementPage.clickToDeleteButtonByRownNumber("1", "삭제하기");
		
		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 14: Close Delete Brand Popup");
		partnerBrandManagementPage.clickToClosePopupCancelButton();
	}

	@Test
	public void TC_10_Delete_Brand_Advertiser_Has_CamPaign(Method method) {
		ExtentTestManager.startTest(method.getName(), "Delete Brand Has Campaign");
		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 01: Search Brand '" + GlobalConstants_KR.BRAND_NAME_HAS_CAMPAIGN_PARTNER_ROLE_KR + "'");
		partnerBrandManagementPage.enterToSearchBrandTextBox(GlobalConstants_KR.BRAND_NAME_HAS_CAMPAIGN_PARTNER_ROLE_KR);

//		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 02: Click on Search Button");
//		partnerBrandManagementPage.clickToResetButton();

//		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 02: Search Brand '" + GlobalConstants.BRAND_NAME_HAS_CAMPAIGN_PARTNER_ROLE_KR + "'");
//		partnerBrandManagementPage.enterToSearchBrandTextBox(GlobalConstants.BRAND_NAME_HAS_CAMPAIGN_PARTNER_ROLE_KR);

//		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 03: Click on Search Button");
//		partnerBrandManagementPage.clickToSearchButton();

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 02: Click on Delete Button");
		partnerBrandManagementPage.clickToDeleteButtonByRownNumber("1", "삭제하기");

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 03: Verify Message Popup is Displayed");
		assertTrue(partnerBrandManagementPage.isPopupDisplayed());

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 04: Change to English Language");
		partnerBrandManagementPage.openSelectLanguageList(driver, GlobalConstants_KR.ENGLISH_LANGUAGE);
		
		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 05: Verify Message Popup translate to English");
		assertEquals(partnerBrandManagementPage.getTitlePopup(), "Delete Brand");
		assertEquals(partnerBrandManagementPage.getTextMessage(),"You cannot delete the brand that has any campaign history.");
		assertEquals(partnerBrandManagementPage.getDeleteButtonText(), "Confirm");

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 06: Change to Korea Language");
		partnerBrandManagementPage.openSelectLanguageList(driver, GlobalConstants_KR.KOREA_LANGUAGE);
		
		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 07: Verify Message Popup translate to Korea");
		assertEquals(partnerBrandManagementPage.getTitlePopup(), "브랜드 삭제");
		assertEquals(partnerBrandManagementPage.getTextMessage(), "캠페인을 진행한 이력이 있는 광고주는 삭제할 수 없습니다.");
		assertEquals(partnerBrandManagementPage.getDeleteButtonText(), "확인");
		
		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 08: Click On Confirm Button");
		partnerBrandManagementPage.clickToDeleteButton();

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 09: Verify Brand Is Not Deleted");
		assertEquals(partnerBrandManagementPage.getBrandNameByRownNumber("1", "1"), GlobalConstants_KR.BRAND_NAME_HAS_CAMPAIGN_PARTNER_ROLE_KR);
	}

	@Test
	public void TC_11_Edit_Brand_Information(Method method) {
		ExtentTestManager.startTest(method.getName(), "Edit Brand Information");
		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 01: Refesh Page");
		partnerBrandManagementPage.refeshCurrentPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 02: Click on 'Advertiser Brand Management Link");
		partnerBrandManagementPage.clickOnByMenuNameLink(driver, GlobalConstants_KR.ADVERTISER_MANAGEMENT_LINK);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 03: Click on 'Brand Management Link");
		partnerBrandManagementPage.openByNameLink(driver, GlobalConstants_KR.BRAND_MANAGEMENT_LINK);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 04: Click on 'Create a new Brand' Button");
		partnerBrandManagementPage.openCreateANewBrand(GlobalConstants_KR.CREATE_A_NEW_BRAND_BUTTON);
		partnerCreateNewBrandPage = PageGeneratorManager.getPartnerCreateANewBrandPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 05: Upload Avatar");
		partnerCreateNewBrandPage.upLoadMultipleFiles(driver, imageAvatart);
		assertTrue(partnerCreateNewBrandPage.isAvatarUpLoaded());

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 06: Input Brand Name");
		partnerCreateNewBrandPage.enterToBrandNameTextBox(brandName);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 07: Select Field");
		partnerCreateNewBrandPage.selectField(GlobalConstants_KR.FIELD_DROPDOWN_LIST);

//		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 05: Input Partner Name '" + GlobalConstants.PARTNER_NAME_SEARCH_FIELD + "'");
//		partnerCreateNewBrandPage.enterToPartNameTextBox(GlobalConstants.PARTNER_NAME_SEARCH_FIELD);
//
//		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 06: Select Partner Name '" + GlobalConstants.PARTNER_NAME_AND_EMAIL_SEARCH_FIELD + "'");
//		partnerCreateNewBrandPage.selectPartnerByName(GlobalConstants.PARTNER_NAME_AND_EMAIL_SEARCH_FIELD);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 08: Click on 'Save' button");
		partnerCreateNewBrandPage.clickSaveButton("저장하기");
		partnerBrandManagementPage = PageGeneratorManager.getPartnerBrandMangementPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 09: Search Brand '" + brandName + "'");
		partnerBrandManagementPage.enterToSearchBrandTextBox(brandName);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 10: Click on Search Button");
		partnerBrandManagementPage.clickToSearchButton();

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 11: Open Brand Information Detail Page");
		partnerBrandManagementPage.clickToBrandNameByRownNumber("1", brandName);
		partnerDetailBrandPage = PageGeneratorManager.getPartnerDetailBrandPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 12: Get Current Page URL");
		getCurrentUrl = partnerDetailBrandPage.getPageUrl(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 13: Get Current Page ID");
		getCurrentPageID = partnerDetailBrandPage.getParentID(driver);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management - Step 14: Verify Brand Information Detail Page");
		assertEquals(partnerDetailBrandPage.getSeeBrandTextButton(), GlobalConstants_KR.TITLE_BRAND_MANGEMENT_PAGE);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 15: Open See Brand Partner Page");
		partnerDetailBrandPage.clickToSeeBrandPageButton();

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 16: Switch To Advertiser Page");
		partnerDetailBrandPage.switchTab(GlobalConstants_KR.ADVERTISER_TEST_URL);
		advertiserDashBoardPage = PageGeneratorManager.getAdvertiserDashBoardPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 17: Verify Advertiser Name '" + brandName + "'");
		assertEquals(advertiserDashBoardPage.getPartnerName(), brandName);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 18: Switch To Edit Brand Page");
		advertiserDashBoardPage.switchTab(getCurrentUrl);
		partnerDetailBrandPage = PageGeneratorManager.getPartnerDetailBrandPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 19: Close Advertiser Page");
		advertiserDashBoardPage.closeTab(getCurrentPageID);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management - Step 20: Verify Change To Brand Information Successfully");
		assertEquals(partnerDetailBrandPage.getSeeBrandTextButton(), "브랜드 화면 보기");

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 21: Click on Use Button");
		partnerDetailBrandPage.clickOnButtonByName("설정함");

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management - Step 22: Enter Emaill Address'" + partnerEmailAddress + "'");
		partnerDetailBrandPage.enterToEmailTextBox(partnerEmailAddress);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 23: Open Setting Password");
		partnerDetailBrandPage.clickToPasswordSettingButton("직접 설정");

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 24: Enter To Password TextBox");
		partnerDetailBrandPage.enterToPasswordTextBox(GlobalConstants_KR.PASSWORD);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 25: Enter To Confirm Password TextBox");
		partnerDetailBrandPage.enterToConfirmPasswordTextBox(GlobalConstants_KR.PASSWORD);
		
		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 26: Click On Save Button");
		partnerDetailBrandPage.clickSaveButton("저장하기");
		
		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 27: Verify Email Alerady Exists In System Korea Language");
		assertEquals(partnerDetailBrandPage.getErrorMessageAtEmailTextBox(),"이미 사용 중 입니다.");
		
		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 28: Change To English Language");
		partnerDetailBrandPage.openSelectLanguageList(driver, GlobalConstants_KR.ENGLISH_LANGUAGE);
		
		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 29: Verify Email Alerady Exists In System English Language");
		assertEquals(partnerDetailBrandPage.getErrorMessageAtEmailTextBox(),"The email has already been taken.");

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 30: Change To Korea Language");
		partnerDetailBrandPage.openSelectLanguageList(driver, GlobalConstants_KR.KOREA_LANGUAGE);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 31: Log Out Manager Account");
		partnerDetailBrandPage.clickOnLogOutButton();
		adminHomePage = PageGeneratorManager.getHomePage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 32: Verify Login Page");
		assertTrue(adminHomePage.isLoginButtonDisplayed());

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 33: Open Login Form");
		adminHomePage.openLoginPopup();

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 34: Switch To Advertiser Tab");
		adminHomePage.clickToAdvertiserTab("광고주");

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 35: Enter To Email TextBox");
		adminHomePage.enterToEmailAdvertiserTextBox(partnerEmailAddress);

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 36: Enter To Password TextBox");
		adminHomePage.enterToPasswordAdvertiserTextBox(GlobalConstants_KR.PASSWORD);

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 37: Open Advertiser Page");
		advertiserDashBoardPage = adminHomePage.openAdvertiserPage("로그인");
		advertiserDashBoardPage = PageGeneratorManager.getAdvertiserDashBoardPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 38: Open Advertiser Page Successfull");
		assertTrue(advertiserDashBoardPage.isDeliveryMenuDisplayed());
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}
}
