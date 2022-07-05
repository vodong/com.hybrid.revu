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
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import environmentConfig.Environment;
import pageObjects.revu.Admin.AdminBrandManagementObject;
import pageObjects.revu.Admin.AdminCreateBrandManagementObject;
import pageObjects.revu.Admin.AdminDashBoardObject;
import pageObjects.revu.Admin.AdminDetailBrandManagementObject;
import pageObjects.revu.Admin.AdminHomePageObject;
import pageObjects.revu.Advertiser.AdvertiserDashBoardPageObject;
import reportConfig.ExtentTestManager;

public class Advertiser_Management_Role extends BaseTest {

	WebDriver driver;
	AdminDashBoardObject adminDashBoardPage;
	AdminHomePageObject adminHomePage;
	AdminBrandManagementObject adminBrandManagementPage;
	AdvertiserDashBoardPageObject advertiserDashBoardPage;
	AdminDetailBrandManagementObject adminDetailBrandPage;
	AdminCreateBrandManagementObject adminCreateNewBrandPage;
	String partnerEmailAddress,getCurrentUrl, getCurrentPageID;
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
		ExtentTestManager.getTest().log(Status.INFO, "Admin Page - Step 01: Enter Email'" + GlobalConstants.EMAIL_MANAGER_ROLE + "'");
		adminHomePage.enterToEmailTextbox(GlobalConstants.EMAIL_MANAGER_ROLE);

		ExtentTestManager.getTest().log(Status.INFO, "Admin Page - Step 02: Enter Password'" + GlobalConstants.PASSWORD + "'");
		adminHomePage.enterToPasswordTextbox(GlobalConstants.PASSWORD);

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
		adminDashBoardPage.clickOnByMenuNameLink(driver, GlobalConstants.ADVERTISER_MANAGEMENT_LINK);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 02: Click on 'Brand Management Link");
		adminDashBoardPage.openByNameLink(driver, GlobalConstants.BRAND_MANAGEMENT_LINK);
		adminBrandManagementPage = PageGeneratorManager.getManagementPage(driver);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 03: Verify (브랜드 관리) Brand Management Page is Displayed");
		assertEquals(adminBrandManagementPage.getTitlePageName(driver), "브랜드 관리\n+ 새 브랜드 생성");

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 04: Verify Brand label is Korea languages");
		assertTrue(adminBrandManagementPage.isPlaceHolderDisplayed("브랜드명", GlobalConstants.PLACE_HOLDER_TEXTBOX_KR));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 05: Verify Field label is Korea languages");
		assertTrue(adminBrandManagementPage.isPlaceHolderFieldDropDownListDisplayed("분야", GlobalConstants.PLACE_HOLDER_FIELD_DROPDOWN_LIST_KR));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 07: Verify Representative label is Korea languages");
		assertTrue(adminBrandManagementPage.isPlaceHolderDisplayed("담당자명", GlobalConstants.PLACE_HOLDER_TEXTBOX_KR));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 08: Verify Partner label is Korea languages");
		assertTrue(adminBrandManagementPage.isPlaceHolderDisplayed("브랜드명", GlobalConstants.PLACE_HOLDER_TEXTBOX_KR));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 09: Verify Email label is Korea languages");
		assertTrue(adminBrandManagementPage.isPlaceHolderDisplayed("이메일", GlobalConstants.PLACE_HOLDER_TEXTBOX_KR));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 10: Verify Phone label is Korea languages");
		assertTrue(adminBrandManagementPage.isPlaceHolderDisplayed("휴대전화", GlobalConstants.PLACE_HOLDER_PHONE_TEXTBOX_KR));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 11: Verify Search button is Korea languages");
		assertTrue(adminBrandManagementPage.isButtonDisplayed("검색"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 12: Verify Reset button is Korea languages");
		assertTrue(adminBrandManagementPage.isButtonDisplayed("초기화"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 13: Verify Brand No. column is Korea languages");
		assertTrue(adminBrandManagementPage.isColumnNameDisplayed("브랜드 번호"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 14: Verify Partner column is Korea languages");
		assertTrue(adminBrandManagementPage.isColumnNameDisplayed("파트너명"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 15: Verify Brand column is Korea languages");
		assertTrue(adminBrandManagementPage.isColumnNameDisplayed("브랜드명"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 16: Verify Field column is Korea languages");
		assertTrue(adminBrandManagementPage.isColumnNameDisplayed("분야"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 17: Verify Email	column is Korea languages");
		assertTrue(adminBrandManagementPage.isColumnNameDisplayed("이메일"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 18: Verify Representative column is Korea languages");
		assertTrue(adminBrandManagementPage.isColumnNameDisplayed("담당자명"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 19: Verify Phone column is Korea languages");
		assertTrue(adminBrandManagementPage.isColumnNameDisplayed("휴대전화"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 20: Verify Camp. On-going column is Korea languages");
		assertTrue(adminBrandManagementPage.isColumnNameDisplayed("캠페인 진행중"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 21: Verify Camp. Completed column is Korea languages");
		assertTrue(adminBrandManagementPage.isColumnNameDisplayed("캠페인 종료"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 22: Verify Date of Creation column is Korea languages");
		assertTrue(adminBrandManagementPage.isColumnNameDisplayed("생성 일자"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 23: Verify Delete column is Korea languages");
		assertTrue(adminBrandManagementPage.isColumnNameDisplayed("삭제"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 24: Verify Delete button is Korea languages");
		assertTrue(adminBrandManagementPage.isTextAtRowDisplayed("삭제", "1", "삭제하기"));
	}

	@Test
	public void TC_04_Check_Translate_To_English_Brand_Management_Page(Method method) {
		ExtentTestManager.startTest(method.getName(), "Check Translate To English At Brand Management Page");
		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 1: Change to English Language");
		adminBrandManagementPage.openSelectLanguageList(driver, GlobalConstants.ENGLISH_LANGUAGE);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 2: Verify Brand Management Page is Displayed");
		assertEquals(adminBrandManagementPage.getTitlePageName(driver), "Brand Management\n+ Create a new brand");

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 3: Verify Brand label is English languages");
		assertTrue(adminBrandManagementPage.isPlaceHolderDisplayed("Brand", GlobalConstants.PLACE_HOLDER_TEXTBOX_EN));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 4: Verify Field label is English languages");
		assertTrue(adminBrandManagementPage.isPlaceHolderFieldDropDownListDisplayed("Field", GlobalConstants.PLACE_HOLDER_FIELD_DROPDOWN_LIST_EN));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 5: Verify Representative label is English languages");
		assertTrue(adminBrandManagementPage.isPlaceHolderDisplayed("Representative", GlobalConstants.PLACE_HOLDER_TEXTBOX_EN));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 6: Verify Partner label is English languages");
		assertTrue(adminBrandManagementPage.isPlaceHolderDisplayed("Partner", GlobalConstants.PLACE_HOLDER_TEXTBOX_EN));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 7: Verify Email label is English languages");
		assertTrue(adminBrandManagementPage.isPlaceHolderDisplayed("Email", GlobalConstants.PLACE_HOLDER_TEXTBOX_EN));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 8: Verify Phone label is English languages");
		assertTrue(adminBrandManagementPage.isPlaceHolderDisplayed("Phone", GlobalConstants.PLACE_HOLDER_PHONE_TEXTBOX_EN));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 9: Verify Search button is English languages");
		assertTrue(adminBrandManagementPage.isButtonDisplayed("Search"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 10: Verify Reset button is English languages");
		assertTrue(adminBrandManagementPage.isButtonDisplayed("Reset"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 11: Verify Brand No. column is English languages");
		assertTrue(adminBrandManagementPage.isColumnNameDisplayed("Brand No."));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 12: Verify Partner column is English languages");
		assertTrue(adminBrandManagementPage.isColumnNameDisplayed("Partner"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 13: Verify Brand column is English languages");
		assertTrue(adminBrandManagementPage.isColumnNameDisplayed("Brand"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 14: Verify Field column is English languages");
		assertTrue(adminBrandManagementPage.isColumnNameDisplayed("Field"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 15: Verify Email	column is English languages");
		assertTrue(adminBrandManagementPage.isColumnNameDisplayed("Email"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 16: Verify Representative column is English languages");
		assertTrue(adminBrandManagementPage.isColumnNameDisplayed("Representative"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 17: Verify Phone column is English languages");
		assertTrue(adminBrandManagementPage.isColumnNameDisplayed("Phone"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 18: Verify Camp. On-going column is English languages");
		assertTrue(adminBrandManagementPage.isColumnNameDisplayed("Camp. On-going"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 19: Verify Camp. Completed column is English languages");
		assertTrue(adminBrandManagementPage.isColumnNameDisplayed("Camp. Completed"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 20: Verify Date of Creation column is English languages");
		assertTrue(adminBrandManagementPage.isColumnNameDisplayed("Date of Creation"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 21: Verify Delete column is English languages");
		assertTrue(adminBrandManagementPage.isColumnNameDisplayed("Delete"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 22: Verify Delete button is English languages");
		assertTrue(adminBrandManagementPage.isTextAtRowDisplayed("Delete", "1", "Delete"));

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 23: Change to Korea Language");
		adminBrandManagementPage.openSelectLanguageList(driver, GlobalConstants.KOREA_LANGUAGE);
	}

	@Test
	public void TC_05_Check_Translate_To_Korea_Create_Brand_Page(Method method) {
		ExtentTestManager.startTest(method.getName(), "Check Translate To Korea At Create Brand Page");
		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 01: Click on 'Create a new Brand' Button");
		adminBrandManagementPage.openCreateANewBrand(GlobalConstants.CREATE_A_NEW_BRAND_BUTTON);
		adminCreateNewBrandPage = PageGeneratorManager.getCreateANewBrandPage(driver);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 02: Verify Open 'Create New Brand Page' Successfull");
		assertEquals(adminCreateNewBrandPage.getTitlePageName(driver), "브랜드 정보");

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 03: Verify Title of Company Information section translate to Korea");
		assertEquals(adminCreateNewBrandPage.getTitleComPanyInformation(), "회사 정보");

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 04: Verify Title of Account Information section translate to Korea");
		assertEquals(adminCreateNewBrandPage.getTitleAccountInformation(), "계정 정보");

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 05: Verify Profile area translate to Korea");
		assertTrue(adminCreateNewBrandPage.isLabelByNameDisplayed("프로필"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 06: Verify Brand area translate to Korea");
		assertTrue(adminCreateNewBrandPage.isPlaceHolderByLabelNameDisplayed("브랜드명", GlobalConstants.PLACE_HOLDER_TEXTBOX_KR));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 07: Verify Partner area translate to Korea");
		assertTrue(adminCreateNewBrandPage.isPlaceHolderByLabelNameDisplayed("파트너", GlobalConstants.PLACE_HOLDER_PARTNER_DROPDOWN_LIST_KR));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 08: Verify Account Setting area translate to Korea");
		assertTrue(adminCreateNewBrandPage.isAccountSettingDisplayed("계정 설정"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 09: Verify Use button translate to Korea");
		assertTrue(adminCreateNewBrandPage.isButtonNameDisplayed(GlobalConstants.USE_BUTTON_KR));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 10: Verify Nonuse button translate to Korea");
		assertTrue(adminCreateNewBrandPage.isButtonNameDisplayed(GlobalConstants.NON_USE_BUTTON_KR));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 11: Verify Field area translate to Korea");
		assertTrue(
				adminCreateNewBrandPage.isPlaceHolderByDropDownListNameDisplayed("분야", GlobalConstants.PLACE_HOLDER_FIELD_DROPDOWN_LIST_KR));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 12: Verify Save button translate to Korea");
		assertTrue(adminCreateNewBrandPage.isSaveButtonDisplayed(GlobalConstants.SAVE_BUTTON_KR));

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 13: Verify Save button is disabled");
		assertFalse(adminCreateNewBrandPage.isSaveButtonDisabled(GlobalConstants.SAVE_BUTTON_KR));

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 14: Verify Field after selecting value");
		adminCreateNewBrandPage.selectField(GlobalConstants.FIELD_DROPDOWN_LIST);
		assertTrue(adminCreateNewBrandPage.isPlaceHolderByDropDownListNameDisplayed("분야", GlobalConstants.FIELD_DROPDOWN_LIST));

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 15: Verify Save button is disabled");
		assertTrue(adminCreateNewBrandPage.isSaveButtonDisabled(GlobalConstants.SAVE_BUTTON_KR));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 16: Verify Account Information After Clicking On 'Use' Button");
		adminCreateNewBrandPage.clickOnButtonByName(GlobalConstants.USE_BUTTON_KR);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 17: Verify Email area translate to Korea");
		assertTrue(adminCreateNewBrandPage.isPlaceHolderByLabelNameDisplayed("이메일", GlobalConstants.PLACE_HOLDER_TEXTBOX_KR));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 18: Verify Password area translate to Korea");
		assertTrue(adminCreateNewBrandPage.isLabelByNameDisplayed("비밀번호"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 19: Verify Reset Password button translate to Korea");
		assertEquals(adminCreateNewBrandPage.getTextResetPasswordButton(), GlobalConstants.RESET_PASSWORD_BUTTON_KR);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 20: Verify Representative area translate to Korea");
		assertTrue(adminCreateNewBrandPage.isPlaceHolderByLabelNameDisplayed("담당자명", GlobalConstants.PLACE_HOLDER_TEXTBOX_KR));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 21: Verify Phone area translate to Korea");
		assertTrue(adminCreateNewBrandPage.isPlaceHolderByLabelNameDisplayed("휴대전화", GlobalConstants.PLACE_HOLDER_PHONE_TEXTBOX_KR));

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 22: Verify Refesh Current Page");
		adminCreateNewBrandPage.refeshCurrentPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 23: Verify Save button is disabled");
		assertFalse(adminCreateNewBrandPage.isSaveButtonDisabled(GlobalConstants.SAVE_BUTTON_KR));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 24: Verify Account Information After Clicking On 'Use' Button");
		adminCreateNewBrandPage.clickOnButtonByName(GlobalConstants.USE_BUTTON_KR);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 25: Verify Reset Password button translate to Korea");
		assertEquals(adminCreateNewBrandPage.getTextResetPasswordButton(), GlobalConstants.PASSWORD_SETTING_KR);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 26: Click on Password Setting Button");
		adminCreateNewBrandPage.clickToPasswordSettingButton(GlobalConstants.PASSWORD_SETTING_KR);
		
		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 27: Verify Reset Password will be changed to Cancel Setting");
		assertEquals(adminCreateNewBrandPage.getTextResetPasswordButton(), GlobalConstants.CANCEL_SETTING_KR);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 28: Enter Password '" + GlobalConstants.PASSWORD + "'");
		adminCreateNewBrandPage.enterToPasswordTextBox(GlobalConstants.PASSWORD);
		
		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 29: Enter Confirm Password is not match '" + GlobalConstants.INCORRECT_PASSWORD + "'");
		adminCreateNewBrandPage.enterToConfirmPasswordTextBox(GlobalConstants.INCORRECT_PASSWORD);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 30: Click on 'Save' Button");
		adminCreateNewBrandPage.clickSaveButton(GlobalConstants.SAVE_BUTTON_KR);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 31: Verify Error Message At Brand Name textbox translate to Korea");
		assertEquals(adminCreateNewBrandPage.getErrorMessageAtBrandNameTextBox(), "필수입력사항 입니다.");

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 32: Verify Error Message At Field DropDown List translate to Korea");
		assertEquals(adminCreateNewBrandPage.getErrorMessageAtFieldDropdownList(), "필수입력사항 입니다.");

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 33: Verify Error Message At Partner dropdown list translate to Korea");
		assertEquals(adminCreateNewBrandPage.getErrorMessageAtPartnerDropdownList(), "필수입력사항 입니다.");

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 34: Verify Error Message At Email textbox translate to Korea");
		assertEquals(adminCreateNewBrandPage.getErrorMessageAtEmailTextBox(), "필수입력사항 입니다.");

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 35: Verify Error Message At Confirm Password textbox translate to Korea");
		assertEquals(adminCreateNewBrandPage.getErrorMessageAtConfirmPasswordTextBox(), "정보가 일치하지 않습니다.");
	}

	@Test
	public void TC_06_Check_Translate_To_English_Create_Brand_Page(Method method) {
		ExtentTestManager.startTest(method.getName(), "Check Translate To English At Create Brand Page");
		ExtentTestManager.getTest().log(Status.INFO,"Create Brand Page - Step 01: Refresh Current Page");
		adminCreateNewBrandPage.refeshCurrentPage(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 02: Change to English Language");
		adminCreateNewBrandPage.openSelectLanguageList(driver, GlobalConstants.ENGLISH_LANGUAGE);
		
		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 03: Verify Title of Company Information section translate to English");
		assertEquals(adminCreateNewBrandPage.getTitlePageName(driver), "Brand Information");

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
		assertTrue(adminCreateNewBrandPage.isPlaceHolderByLabelNameDisplayed("Brand",GlobalConstants.PLACE_HOLDER_TEXTBOX_EN));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 08: Verify Partner area translate to English");
		assertTrue(
				adminCreateNewBrandPage.isPlaceHolderByLabelNameDisplayed("Partner", GlobalConstants.PLACE_HOLDER_PARTNER_DROPDOWN_LIST_EN));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 09: Verify Account Setting area translate to English");
		assertTrue(adminCreateNewBrandPage.isAccountSettingDisplayed("Account Setting"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 10: Verify Use button translate to English");
		assertTrue(adminCreateNewBrandPage.isButtonNameDisplayed(GlobalConstants.USE_BUTTON_EN));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 11: Verify Nonuse button translate to English");
		assertTrue(adminCreateNewBrandPage.isButtonNameDisplayed(GlobalConstants.NON_USE_BUTTON_EN));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 12: Verify Field area translate to English");
		assertTrue(adminCreateNewBrandPage.isPlaceHolderByDropDownListNameDisplayed("Field",GlobalConstants.PLACE_HOLDER_FIELD_DROPDOWN_LIST_EN));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 13: Verify Save button translate to English");
		assertTrue(adminCreateNewBrandPage.isSaveButtonDisplayed(GlobalConstants.SAVE_BUTTON_EN));

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 14: Verify Save button is disabled");
		assertFalse(adminCreateNewBrandPage.isSaveButtonDisabled(GlobalConstants.SAVE_BUTTON_EN));

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 15: Verify Field after selecting value");
		adminCreateNewBrandPage.selectField(GlobalConstants.FIELD_DROPDOWN_LIST);
		assertTrue(adminCreateNewBrandPage.isPlaceHolderByDropDownListNameDisplayed("Field", GlobalConstants.FIELD_DROPDOWN_LIST));

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 16: Verify Save button is disabled");
		assertTrue(adminCreateNewBrandPage.isSaveButtonDisabled(GlobalConstants.SAVE_BUTTON_EN));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 17: Verify Account Information After Clicking On 'Use' Button");
		adminCreateNewBrandPage.clickOnButtonByName(GlobalConstants.USE_BUTTON_EN);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 18: Verify Email area translate to English");
		assertTrue(adminCreateNewBrandPage.isPlaceHolderByLabelNameDisplayed("Email", GlobalConstants.PLACE_HOLDER_TEXTBOX_EN));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 19: Verify Password area translate to English");
		assertTrue(adminCreateNewBrandPage.isLabelByNameDisplayed("Password"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 20: Verify Reset Password button translate to English");
		assertEquals(adminCreateNewBrandPage.getTextResetPasswordButton(), GlobalConstants.PASSWORD_SETTING_EN);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 21: Verify Representative area translate to English");
		assertTrue(adminCreateNewBrandPage.isPlaceHolderByLabelNameDisplayed("Representative", GlobalConstants.PLACE_HOLDER_TEXTBOX_EN));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 22: Verify Phone area translate to English");
		assertTrue(adminCreateNewBrandPage.isPlaceHolderByLabelNameDisplayed("Phone", GlobalConstants.PLACE_HOLDER_PHONE_TEXTBOX_EN));

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 23: Verify Refesh Current Page");
		adminCreateNewBrandPage.refeshCurrentPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 24: Verify Save button is disabled");
		assertFalse(adminCreateNewBrandPage.isSaveButtonDisabled(GlobalConstants.SAVE_BUTTON_EN));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 25: Verify Account Information After Clicking On 'Use' Button");
		adminCreateNewBrandPage.clickOnButtonByName(GlobalConstants.USE_BUTTON_EN);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 26: Click On Password Setting Button");
		adminCreateNewBrandPage.clickToPasswordSettingButton(GlobalConstants.PASSWORD_SETTING_EN);
		
		ExtentTestManager.getTest().log(Status.INFO,"Create Brand Page - Step 27: Verify Reset Password will be changed to Cancel Setting");
		assertEquals(adminCreateNewBrandPage.getTextResetPasswordButton(), GlobalConstants.CANCEL_SETTING_EN);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 28: Enter Password '" + GlobalConstants.PASSWORD + "'");
		adminCreateNewBrandPage.enterToPasswordTextBox(GlobalConstants.PASSWORD);
		
		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 29: Enter Confirm Password is not match '" + GlobalConstants.INCORRECT_PASSWORD + "'");
		adminCreateNewBrandPage.enterToConfirmPasswordTextBox(GlobalConstants.INCORRECT_PASSWORD);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 30: Click on 'Save' Button");
		adminCreateNewBrandPage.clickSaveButton(GlobalConstants.SAVE_BUTTON_EN);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 31: Verify Error Message At Brand Name textbox translate to English");
		assertEquals(adminCreateNewBrandPage.getErrorMessageAtBrandNameTextBox(), "This field is required.");

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 32: Verify Error Message At Field DropDown List translate to English");
		assertEquals(adminCreateNewBrandPage.getErrorMessageAtFieldDropdownList(), "The selected value is invalid.");

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 33: Verify Error Message At Partner dropdown list translate to English");
		assertEquals(adminCreateNewBrandPage.getErrorMessageAtPartnerDropdownList(), "This field is required.");

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 34: Verify Error Message At Email textbox translate to English");
		assertEquals(adminCreateNewBrandPage.getErrorMessageAtEmailTextBox(),
				"The email field is required when account setting is use.");

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 35: Verify Error Message At Confirm Password textbox translate to English");
		assertEquals(adminCreateNewBrandPage.getErrorMessageAtConfirmPasswordTextBox(),
				"The confirmation does not match.");
	}

	@Test
	public void TC_07_Create_Brand_Non_Use_Option(Method method) {
		ExtentTestManager.startTest(method.getName(), "Create Brand By Nonuse Option");
		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 01: Refesh Current Page");
		adminCreateNewBrandPage.refeshCurrentPage(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 02: Change to Korea Language");
		adminCreateNewBrandPage.openSelectLanguageList(driver, GlobalConstants.KOREA_LANGUAGE);
		
		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 03: Upload Avatar");
		adminCreateNewBrandPage.upLoadMultipleFiles(driver, imageAvatart);
		
		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 04: Verify Image Is Uploaded Successfully");
		assertTrue(adminCreateNewBrandPage.isAvatarUpLoaded());

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 05: Input Brand Name '" + brandName + "'");
		adminCreateNewBrandPage.enterToBrandNameTextBox(brandName);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 06: Select Field '" + GlobalConstants.FIELD_DROPDOWN_LIST + "'");
		adminCreateNewBrandPage.selectField(GlobalConstants.FIELD_DROPDOWN_LIST);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 07: Input Partner Name '" + GlobalConstants.PARTNER_NAME_SEARCH_FIELD + "'");
		adminCreateNewBrandPage.enterToPartNameTextBox(GlobalConstants.PARTNER_NAME_SEARCH_FIELD);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 08: Select Partner Name '" + GlobalConstants.PARTNER_NAME_AND_EMAIL_SEARCH_FIELD + "'");
		adminCreateNewBrandPage.selectPartnerByName(GlobalConstants.PARTNER_NAME_AND_EMAIL_SEARCH_FIELD);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 09: Click on 'Save' button");
		adminCreateNewBrandPage.clickSaveButton(GlobalConstants.SAVE_BUTTON_KR);
		adminBrandManagementPage = PageGeneratorManager.getManagementPage(driver);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management - Step 10: Verify Brand has just been created in Brand Management list");
		assertTrue(adminBrandManagementPage.isTextCreatedBrandAtRowDisplayed("파트너명", "1", GlobalConstants.PARTNER_NAME_SEARCH_FIELD));
		assertTrue(adminBrandManagementPage.isTextCreatedBrandAtRowDisplayed("브랜드명", "1", brandName));
		assertTrue(adminBrandManagementPage.isTextCreatedBrandAtRowDisplayed("분야", "1", GlobalConstants.FIELD_DROPDOWN_LIST));

	}

	@Test
	public void TC_08_Delete_Brand_Advertiser_Do_Not_Have_CamPaign(Method method) {
		ExtentTestManager.startTest(method.getName(), "Delete Brand Do Not Have Campaign");
		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 01: Input Brand Name '" + brandName + "'");
		adminBrandManagementPage.enterToSearchBrandTextBox(brandName);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 02: Click on Search Button");
		adminBrandManagementPage.clickToSearchButton();

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 03: Click on Delete Button");
		adminBrandManagementPage.clickToDeleteButtonByRownNumber("1", GlobalConstants.DELETE_BUTTON);

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
				"Brand Management Page - Step 06: Verify Message Popup translate to Korea");
		adminBrandManagementPage.openSelectLanguageList(driver, "한국어");
		assertEquals(adminBrandManagementPage.getTitlePopup(), "브랜드 삭제");
		assertEquals(adminBrandManagementPage.getTextMessage(), "브랜드를 삭제 하시겠습니까? 삭제된 후에는 다시 복구할 수 없습니다.");
		assertEquals(adminBrandManagementPage.getDeleteButtonText(), "삭제하기");
		assertEquals(adminBrandManagementPage.getCancelButtonText(), "취소");

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 07: Close Popup By X Icon");
		adminBrandManagementPage.clickToClosePopupByIcon();

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 08: Click To Delete Button");
		adminBrandManagementPage.clickToDeleteButtonByRownNumber("1", GlobalConstants.DELETE_BUTTON);
		
		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 09: Close Popup By Clicking On Cancel Button");
		adminBrandManagementPage.clickToClosePopupCancelButton();

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 10: Delete Brand");
		adminBrandManagementPage.clickToDeleteButtonByRownNumber("1", GlobalConstants.DELETE_BUTTON);
		adminBrandManagementPage.clickToDeleteButton();

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 11: Click on 'Brand Management Link");
		adminBrandManagementPage.openByNameLink(driver, GlobalConstants.BRAND_MANAGEMENT_LINK);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 12: Verify Brand Is Deleted '" + brandName + "'");
		assertNotEquals(adminBrandManagementPage.getBrandNameByRownNumber("1", "3"), brandName);
	}

	@Test
	public void TC_09_Create_Brand_Use_Option(Method method) {
		ExtentTestManager.startTest(method.getName(), "Create Brand By Use Option");
		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 01: Open Create A New Brand Page");
		adminBrandManagementPage.openCreateANewBrand(GlobalConstants.CREATE_A_NEW_BRAND_BUTTON);
		
		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 02: Upload Avatar");
		adminCreateNewBrandPage.upLoadMultipleFiles(driver, imageAvatart);
		
		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 03: Verify Image Upload Successfully");
		assertTrue(adminCreateNewBrandPage.isAvatarUpLoaded());

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 04: Input Brand Name '" + brandName + "'");
		adminCreateNewBrandPage.enterToBrandNameTextBox(brandName);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 05: Select Field '" + GlobalConstants.FIELD_DROPDOWN_LIST + "'");
		adminCreateNewBrandPage.selectField(GlobalConstants.FIELD_DROPDOWN_LIST);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 06: Input Partner Name '" + GlobalConstants.PARTNER_NAME_SEARCH_FIELD + "'");
		adminCreateNewBrandPage.enterToPartNameTextBox(GlobalConstants.PARTNER_NAME_SEARCH_FIELD);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 07: Select Partner Name '" + GlobalConstants.PARTNER_NAME_AND_EMAIL_SEARCH_FIELD + "'");
		adminCreateNewBrandPage.selectPartnerByName(GlobalConstants.PARTNER_NAME_AND_EMAIL_SEARCH_FIELD);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 08: Click on 'Use' button");
		adminCreateNewBrandPage.clickOnButtonByName(GlobalConstants.USE_BUTTON_KR);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 09: Input Email '" + partnerEmailAddress + "'");
		adminCreateNewBrandPage.enterToEmailTextBox(partnerEmailAddress);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 10: Click On Password Setting Button");
		adminCreateNewBrandPage.clickToPasswordSettingButton(GlobalConstants.PASSWORD_SETTING_KR);
		
		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 11: Input Password '" + GlobalConstants.PASSWORD + "'");
		adminCreateNewBrandPage.enterToPasswordTextBox(GlobalConstants.PASSWORD);
		
		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 12: Input Confirm Password '" + GlobalConstants.PASSWORD + "'");
		adminCreateNewBrandPage.enterToConfirmPasswordTextBox(GlobalConstants.PASSWORD);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 13: Click on 'Save' button");
		adminCreateNewBrandPage.clickSaveButton(GlobalConstants.SAVE_BUTTON_KR);
		adminBrandManagementPage = PageGeneratorManager.getManagementPage(driver);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management - Step 14: Verify Brand has just been created in Brand Management list");
		adminBrandManagementPage.isTextCreatedBrandAtRowDisplayed("파트너명", "1", GlobalConstants.PARTNER_NAME_SEARCH_FIELD);
		adminBrandManagementPage.isTextCreatedBrandAtRowDisplayed("브랜드명", "1", brandName);
		adminBrandManagementPage.isTextCreatedBrandAtRowDisplayed("분야", "1", GlobalConstants.FIELD_DROPDOWN_LIST);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 15: Delete Brand");
		adminBrandManagementPage.clickToDeleteButtonByRownNumber("1", "삭제하기");
		
		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 16: Close Delete Brand Popup");
		adminBrandManagementPage.clickToClosePopupCancelButton();
	}

	@Test
	public void TC_10_Delete_Brand_Advertiser_Has_CamPaign(Method method) {
		ExtentTestManager.startTest(method.getName(), "Delete Brand Has Campaign");
		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 01: Search Brand '" + GlobalConstants.BRAND_NAME_HAS_CAMPAIGN_MANAGER_ROLE_KR + "'");
		adminBrandManagementPage.enterToSearchBrandTextBox(GlobalConstants.BRAND_NAME_HAS_CAMPAIGN_MANAGER_ROLE_KR);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 02: Click on Search Button");
		adminBrandManagementPage.clickToResetButton();

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 03: Search Brand '" + GlobalConstants.BRAND_NAME_HAS_CAMPAIGN_MANAGER_ROLE_KR + "'");
		adminBrandManagementPage.enterToSearchBrandTextBox(GlobalConstants.BRAND_NAME_HAS_CAMPAIGN_MANAGER_ROLE_KR);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 04: Click on Search Button");
		adminBrandManagementPage.clickToSearchButton();

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 05: Click on Delete Button");
		adminBrandManagementPage.clickToDeleteButtonByRownNumber("1", "삭제하기");

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 06: Verify Message Popup is Displayed");
		assertTrue(adminBrandManagementPage.isPopupDisplayed());

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 07: Change to English Language");
		adminBrandManagementPage.openSelectLanguageList(driver, GlobalConstants.ENGLISH_LANGUAGE);
		
		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 08: Verify Message Popup translate to English");
		assertEquals(adminBrandManagementPage.getTitlePopup(), "Delete Brand");
		assertEquals(adminBrandManagementPage.getTextMessage(),"You cannot delete the brand that has any campaign history.");
		assertEquals(adminBrandManagementPage.getDeleteButtonText(), "Confirm");

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 09: Change to Korea Language");
		adminBrandManagementPage.openSelectLanguageList(driver, GlobalConstants.KOREA_LANGUAGE);
		
		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 10: Verify Message Popup translate to Korea");
		assertEquals(adminBrandManagementPage.getTitlePopup(), "브랜드 삭제");
		assertEquals(adminBrandManagementPage.getTextMessage(), "캠페인을 진행한 이력이 있는 광고주는 삭제할 수 없습니다.");
		assertEquals(adminBrandManagementPage.getDeleteButtonText(), "확인");
		
		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 11: Click On Confirm Button");
		adminBrandManagementPage.clickToDeleteButton();

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 12: Verify Brand Is Not Deleted");
		assertEquals(adminBrandManagementPage.getBrandNameByRownNumber("1", "3"), GlobalConstants.BRAND_NAME_HAS_CAMPAIGN_MANAGER_ROLE_KR);
	}

	@Test
	public void TC_11_Edit_Brand_Information(Method method) {
		ExtentTestManager.startTest(method.getName(), "Edit Brand Information");
		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 01: Refesh Page");
		adminBrandManagementPage.refeshCurrentPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 02: Click on 'Advertiser Brand Management Link");
		adminBrandManagementPage.clickOnByMenuNameLink(driver, GlobalConstants.ADVERTISER_MANAGEMENT_LINK);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 03: Click on 'Brand Management Link");
		adminBrandManagementPage.openByNameLink(driver, GlobalConstants.BRAND_MANAGEMENT_LINK);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 01: Click on 'Create a new Brand' Button");
		adminBrandManagementPage.openCreateANewBrand(GlobalConstants.CREATE_A_NEW_BRAND_BUTTON);
		adminCreateNewBrandPage = PageGeneratorManager.getCreateANewBrandPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 02: Upload Avatar");
		adminCreateNewBrandPage.upLoadMultipleFiles(driver, imageAvatart);
		assertTrue(adminCreateNewBrandPage.isAvatarUpLoaded());

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 03: Input Brand Name");
		adminCreateNewBrandPage.enterToBrandNameTextBox(brandName);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 04: Select Field");
		adminCreateNewBrandPage.selectField(GlobalConstants.FIELD_DROPDOWN_LIST);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 05: Input Partner Name '" + GlobalConstants.PARTNER_NAME_SEARCH_FIELD + "'");
		adminCreateNewBrandPage.enterToPartNameTextBox(GlobalConstants.PARTNER_NAME_SEARCH_FIELD);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 06: Select Partner Name '" + GlobalConstants.PARTNER_NAME_AND_EMAIL_SEARCH_FIELD + "'");
		adminCreateNewBrandPage.selectPartnerByName(GlobalConstants.PARTNER_NAME_AND_EMAIL_SEARCH_FIELD);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 07: Click on 'Save' button");
		adminCreateNewBrandPage.clickSaveButton("저장하기");
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
		assertEquals(adminDetailBrandPage.getSeeBrandTextButton(), GlobalConstants.TITLE_BRAND_MANGEMENT_PAGE);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 14: Open See Brand Partner Page");
		adminDetailBrandPage.clickToSeeBrandPageButton();

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 15: Switch To Advertiser Page");
		adminDetailBrandPage.switchTab(GlobalConstants.ADVERTISER_TEST_URL);
		advertiserDashBoardPage = PageGeneratorManager.getAdvertiserDashBoardPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 16: Verify Advertiser Name '" + brandName + "'");
		assertEquals(advertiserDashBoardPage.getPartnerName(), brandName);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 17: Switch To Edit Brand Page");
		advertiserDashBoardPage.switchTab(getCurrentUrl);
		adminDetailBrandPage = PageGeneratorManager.getDetailBrandPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 18: Close Advertiser Page");
		advertiserDashBoardPage.closeTab(getCurrentPageID);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management - Step 19: Verify Change To Brand Information Successfully");
		assertEquals(adminDetailBrandPage.getSeeBrandTextButton(), "브랜드 화면 보기");

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 20: Click on Use Button");
		adminDetailBrandPage.clickOnButtonByName("설정함");

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management - Step 21: Enter Emaill Address'" + partnerEmailAddress + "'");
		adminDetailBrandPage.enterToEmailTextBox(partnerEmailAddress);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 22: Open Setting Password");
		adminDetailBrandPage.clickToPasswordSettingButton("직접 설정");

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 23: Enter To Password TextBox");
		adminDetailBrandPage.enterToPasswordTextBox(GlobalConstants.PASSWORD);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 24: Enter To Confirm Password TextBox");
		adminDetailBrandPage.enterToConfirmPasswordTextBox(GlobalConstants.PASSWORD);
		
		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 25: Click On Save Button");
		adminDetailBrandPage.clickSaveButton("저장하기");
		
		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 26: Verify Email Alerady Exists In System Korea Language");
		assertEquals(adminDetailBrandPage.getErrorMessageAtEmailTextBox(),"이미 사용 중 입니다.");
		
		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 27: Change To English Language");
		adminDetailBrandPage.openSelectLanguageList(driver, GlobalConstants.ENGLISH_LANGUAGE);
		
		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 28: Verify Email Alerady Exists In System English Language");
		assertEquals(adminDetailBrandPage.getErrorMessageAtEmailTextBox(),"The email has already been taken.");

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 29: Change To Korea Language");
		adminDetailBrandPage.openSelectLanguageList(driver, GlobalConstants.KOREA_LANGUAGE);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 30: Log Out Manager Account");
		adminDetailBrandPage.clickOnLogOutButton();
		adminHomePage = PageGeneratorManager.getHomePage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 31: Verify Login Page");
		assertTrue(adminHomePage.isLoginButtonDisplayed());

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 32: Open Login Form");
		adminHomePage.openLoginPopup();

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 33: Switch To Advertiser Tab");
		adminHomePage.clickToAdvertiserTab("광고주");

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 34: Enter To Email TextBox");
		adminHomePage.enterToEmailAdvertiserTextBox(partnerEmailAddress);

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 35: Enter To Password TextBox");
		adminHomePage.enterToPasswordAdvertiserTextBox(GlobalConstants.PASSWORD);

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 36: Open Advertiser Page");
		advertiserDashBoardPage = adminHomePage.openAdvertiserPage("로그인");
		advertiserDashBoardPage = PageGeneratorManager.getAdvertiserDashBoardPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 37: Open Advertiser Page Successfull");
		assertTrue(advertiserDashBoardPage.isDeliveryMenuDisplayed());
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}
}
