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
	}

	@Test
	public void TC_01_Open_Admin_Page_And_Select_Country(Method method) {

		ExtentTestManager.startTest(method.getName(), "Open Admin Page And Select Country");
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 01: Open Country List");
		adminHomePage.openCountryList();

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 02: Select Country");
		adminHomePage.hoverCountryName("Korea");

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 03: Select language");
		adminHomePage.selectLanguage("한국어");

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 04: Open Login Form");
		adminHomePage.openLoginPopup();
	}

	@Test
	public void TC_02_Login_To_DashBoard_Page(Method method) {
		ExtentTestManager.startTest(method.getName(), "Login To DasbhBoard Page");
		ExtentTestManager.getTest().log(Status.INFO,
				"Admin Page - Step 01: Enter Email'" + GlobalConstants.getGlobalConstants().getEmailPartnerRole() + "'");
		adminHomePage.enterToEmailTextbox(GlobalConstants.getGlobalConstants().getEmailPartnerRole());

		ExtentTestManager.getTest().log(Status.INFO,
				"Admin Page - Step 02: Enter Password'" + GlobalConstants.getGlobalConstants().getPassword() + "'");
		adminHomePage.enterToPasswordTextbox(GlobalConstants.getGlobalConstants().getPassword());

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
		adminDashBoardPage.clickOnByMenuNameLink(driver, GlobalConstants.getGlobalConstants().getAdvertiserManagementLink());

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 02: Click on 'Brand Management Link");
		adminDashBoardPage.openByNameLink(driver, GlobalConstants.getGlobalConstants().getBrandManagementLink());
		partnerBrandManagementPage = PageGeneratorManager.getPartnerBrandMangementPage(driver);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 03: Verify (브랜드 관리) Brand Management Page is Displayed");
		assertEquals(partnerBrandManagementPage.getTitlePageName(driver), "브랜드 관리\n+ 새 브랜드 생성");

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 04: Verify Place Holder Of Search Text Box is Korea Text");
		assertTrue(
				partnerBrandManagementPage.isSearchTextBoxDisplayed(GlobalConstants.placeholderSearchTextBoxKR));

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
		partnerBrandManagementPage.openSelectLanguageList(driver, GlobalConstants.englishLangguage);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 02: Verify Brand Management Page is Displayed");
		assertEquals(partnerBrandManagementPage.getTitlePageName(driver), "Brand Management\n+ Create a new brand");

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 03: Verify Place Holder Of Search Text Box is English Text");
		assertTrue(
				partnerBrandManagementPage.isSearchTextBoxDisplayed(GlobalConstants.placeholderSearchTextBoxEN));

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

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 11: Verify Delete column is English languages");
		assertTrue(partnerBrandManagementPage.isColumnNameDisplayed("Delete"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 12: Verify Delete button is English languages");
		assertTrue(partnerBrandManagementPage.isTextAtRowDisplayed("Delete", "1", "Delete"));

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 13: Change to Korea Language");
		partnerBrandManagementPage.openSelectLanguageList(driver, GlobalConstants.koreaLanguage);
	}

	@Test
	public void TC_05_Check_Translate_To_Korea_Create_Brand_Page(Method method) {
		ExtentTestManager.startTest(method.getName(), "Check Translate To Korea At Create Brand Page");
		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 01: Click on 'Create a new Brand' Button");
		partnerBrandManagementPage.openCreateANewBrand(GlobalConstants.createANewBrandButton);
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
		assertTrue(partnerCreateNewBrandPage.isPlaceHolderByLabelNameDisplayed("브랜드명",
				GlobalConstants.placeholderTextBoxKR));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 07: Verify Account Setting area translate to Korea");
		assertTrue(partnerCreateNewBrandPage.isAccountSettingDisplayed("계정 설정"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 08: Verify Use button translate to Korea");
		assertTrue(partnerCreateNewBrandPage.isButtonNameDisplayed(GlobalConstants.useButtonKR));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 09: Verify Nonuse button translate to Korea");
		assertTrue(partnerCreateNewBrandPage.isButtonNameDisplayed(GlobalConstants.nonUseButtonKR));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 10: Verify Field area translate to Korea");
		assertTrue(partnerCreateNewBrandPage.isPlaceHolderByDropDownListNameDisplayed("분야",
				GlobalConstants.placeholderFieldDropDownListKR));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 11: Verify Save button translate to Korea");
		assertTrue(partnerCreateNewBrandPage.isSaveButtonDisplayed(GlobalConstants.saveButtonKR));

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 12: Verify Save button is disabled");
		assertFalse(partnerCreateNewBrandPage.isSaveButtonDisabled(GlobalConstants.saveButtonKR));

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 13: Verify Field after selecting value");
		partnerCreateNewBrandPage.selectField(GlobalConstants.fieldDropDownListValue);
		assertTrue(partnerCreateNewBrandPage.isPlaceHolderByDropDownListNameDisplayed("분야",
				GlobalConstants.fieldDropDownListValue));

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 14: Verify Save button is disabled");
		assertTrue(partnerCreateNewBrandPage.isSaveButtonDisabled(GlobalConstants.saveButtonKR));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 15: Verify Account Information After Clicking On 'Use' Button");
		partnerCreateNewBrandPage.clickOnButtonByName(GlobalConstants.useButtonKR);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 16: Verify Email area translate to Korea");
		assertTrue(partnerCreateNewBrandPage.isPlaceHolderByLabelNameDisplayed("이메일",
				GlobalConstants.placeholderTextBoxKR));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 17: Verify Password area translate to Korea");
		assertTrue(partnerCreateNewBrandPage.isLabelByNameDisplayed("비밀번호"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 18: Verify Reset Password button translate to Korea");
		assertEquals(partnerCreateNewBrandPage.getTextResetPasswordButton(),
				GlobalConstants.resetPasswordButtonKR);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 19: Verify Representative area translate to Korea");
		assertTrue(partnerCreateNewBrandPage.isPlaceHolderByLabelNameDisplayed("담당자명",
				GlobalConstants.placeholderTextBoxKR));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 20: Verify Phone area translate to Korea");
		assertTrue(partnerCreateNewBrandPage.isPlaceHolderByLabelNameDisplayed("휴대전화",
				GlobalConstants.placeholderPhoneTextBoxKR));

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 21: Verify Refesh Current Page");
		partnerCreateNewBrandPage.refeshCurrentPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 22: Verify Save button is disabled");
		assertFalse(partnerCreateNewBrandPage.isSaveButtonDisabled(GlobalConstants.saveButtonKR));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 23: Verify Account Information After Clicking On 'Use' Button");
		partnerCreateNewBrandPage.clickOnButtonByName(GlobalConstants.useButtonKR);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 24: Verify Reset Password button translate to Korea");
		assertEquals(partnerCreateNewBrandPage.getTextResetPasswordButton(), GlobalConstants.passwordSettingKR);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 25: Click on Password Setting Button");
		partnerCreateNewBrandPage.clickToPasswordSettingButton(GlobalConstants.passwordSettingKR);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 26: Verify Reset Password will be changed to Cancel Setting");
		assertEquals(partnerCreateNewBrandPage.getTextResetPasswordButton(), GlobalConstants.cancelSettingKR);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 27: Enter Password '" + GlobalConstants.password + "'");
		partnerCreateNewBrandPage.enterToPasswordTextBox(GlobalConstants.password);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 28: Enter Confirm Password is not match '"
						+ GlobalConstants.incorrectPassword + "'");
		partnerCreateNewBrandPage.enterToConfirmPasswordTextBox(GlobalConstants.incorrectPassword);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 29: Click on 'Save' Button");
		partnerCreateNewBrandPage.clickSaveButton(GlobalConstants.saveButtonKR);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 30: Verify Error Message At Brand Name textbox translate to Korea");
		assertEquals(partnerCreateNewBrandPage.getErrorMessageAtBrandNameTextBox(), "필수입력사항 입니다.");

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 31: Verify Error Message At Field DropDown List translate to Korea");
		assertEquals(partnerCreateNewBrandPage.getErrorMessageAtFieldDropdownList(), "필수입력사항 입니다.");

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 32: Verify Error Message At Email textbox translate to Korea");
		assertEquals(partnerCreateNewBrandPage.getErrorMessageAtEmailTextBox(), "필수입력사항 입니다.");

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 33: Verify Error Message At Confirm Password textbox translate to Korea");
		assertEquals(partnerCreateNewBrandPage.getErrorMessageAtConfirmPasswordTextBox(), "정보가 일치하지 않습니다.");

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 34: Enter To Email TextBox Wrong Email Format");
		partnerCreateNewBrandPage.enterToEmailTextBox(GlobalConstants.wrongEmailFormat);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 35: Click On Save Button");
		partnerCreateNewBrandPage.clickSaveButton(GlobalConstants.saveButtonKR);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 36: Verify Error Message At Email textbox translate to Taiwan When Inputting Wrong Email Format");
		assertEquals(partnerCreateNewBrandPage.getErrorMessageAtEmailTextBox(), "이메일 형식에 맞게 입력해주세요.");
	}

	@Test
	public void TC_06_Check_Translate_To_English_Create_Brand_Page(Method method) {
		ExtentTestManager.startTest(method.getName(), "Check Translate To English At Create Brand Page");
		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 01: Refresh Current Page");
		partnerCreateNewBrandPage.refeshCurrentPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 02: Change to English Language");
		partnerCreateNewBrandPage.openSelectLanguageList(driver, GlobalConstants.englishLangguage);

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
				GlobalConstants.placeholderTextBoxEN));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 08: Verify Account Setting area translate to English");
		assertTrue(partnerCreateNewBrandPage.isAccountSettingDisplayed("Account Setting"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 09: Verify Use button translate to English");
		assertTrue(partnerCreateNewBrandPage.isButtonNameDisplayed(GlobalConstants.useButtonEN));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 10: Verify Nonuse button translate to English");
		assertTrue(partnerCreateNewBrandPage.isButtonNameDisplayed(GlobalConstants.nonUseButtonEN));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 11: Verify Field area translate to English");
		assertTrue(partnerCreateNewBrandPage.isPlaceHolderByDropDownListNameDisplayed("Field",
				GlobalConstants.placeholderFieldDropDownListEN));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 12: Verify Save button translate to English");
		assertTrue(partnerCreateNewBrandPage.isSaveButtonDisplayed(GlobalConstants.saveButtonEN));

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 13: Verify Save button is disabled");
		assertFalse(partnerCreateNewBrandPage.isSaveButtonDisabled(GlobalConstants.saveButtonEN));

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 14: Verify Field after selecting value");
		partnerCreateNewBrandPage.selectField(GlobalConstants.fieldDropDownListValue);
		assertTrue(partnerCreateNewBrandPage.isPlaceHolderByDropDownListNameDisplayed("Field",
				GlobalConstants.fieldDropDownListValue));

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 15: Verify Save button is disabled");
		assertTrue(partnerCreateNewBrandPage.isSaveButtonDisabled(GlobalConstants.saveButtonEN));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 16: Verify Account Information After Clicking On 'Use' Button");
		partnerCreateNewBrandPage.clickOnButtonByName(GlobalConstants.useButtonEN);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 17: Verify Email area translate to English");
		assertTrue(partnerCreateNewBrandPage.isPlaceHolderByLabelNameDisplayed("Email",
				GlobalConstants.placeholderTextBoxEN));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 18: Verify Password area translate to English");
		assertTrue(partnerCreateNewBrandPage.isLabelByNameDisplayed("Password"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 19: Verify Reset Password button translate to English");
		assertEquals(partnerCreateNewBrandPage.getTextResetPasswordButton(), GlobalConstants.passwordSettingEN);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 20: Verify Representative area translate to English");
		assertTrue(partnerCreateNewBrandPage.isPlaceHolderByLabelNameDisplayed("Representative",
				GlobalConstants.placeholderTextBoxEN));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 21: Verify Phone area translate to English");
		assertTrue(partnerCreateNewBrandPage.isPlaceHolderByLabelNameDisplayed("Phone",
				GlobalConstants.placeholderPhoneTextBoxEN));

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 22: Verify Refesh Current Page");
		partnerCreateNewBrandPage.refeshCurrentPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 23: Verify Save button is disabled");
		assertFalse(partnerCreateNewBrandPage.isSaveButtonDisabled(GlobalConstants.saveButtonEN));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 24: Verify Account Information After Clicking On 'Use' Button");
		partnerCreateNewBrandPage.clickOnButtonByName(GlobalConstants.useButtonEN);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 25: Click On Password Setting Button");
		partnerCreateNewBrandPage.clickToPasswordSettingButton(GlobalConstants.passwordSettingEN);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 26: Verify Reset Password will be changed to Cancel Setting");
		assertEquals(partnerCreateNewBrandPage.getTextResetPasswordButton(), GlobalConstants.cancelSettingEN);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 27: Enter Password '" + GlobalConstants.password + "'");
		partnerCreateNewBrandPage.enterToPasswordTextBox(GlobalConstants.password);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 28: Enter Confirm Password is not match '"
						+ GlobalConstants.incorrectPassword + "'");
		partnerCreateNewBrandPage.enterToConfirmPasswordTextBox(GlobalConstants.incorrectPassword);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 29: Click on 'Save' Button");
		partnerCreateNewBrandPage.clickSaveButton(GlobalConstants.saveButtonEN);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 30: Verify Error Message At Brand Name textbox translate to English");
		assertEquals(partnerCreateNewBrandPage.getErrorMessageAtBrandNameTextBox(), "This field is required.");

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 31: Verify Error Message At Field DropDown List translate to English");
		assertEquals(partnerCreateNewBrandPage.getErrorMessageAtFieldDropdownList(), "The selected value is invalid.");

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 32: Verify Error Message At Email textbox translate to English");
		assertEquals(partnerCreateNewBrandPage.getErrorMessageAtEmailTextBox(),
				"The email field is required when account setting is use.");

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 33: Verify Error Message At Confirm Password textbox translate to English");
		assertEquals(partnerCreateNewBrandPage.getErrorMessageAtConfirmPasswordTextBox(),
				"The confirmation does not match.");

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 34: Enter To Email TextBox Wrong Email Format");
		partnerCreateNewBrandPage.enterToEmailTextBox(GlobalConstants.wrongEmailFormat);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 35: Click On Save Button");
		partnerCreateNewBrandPage.clickSaveButton(GlobalConstants.saveButtonEN);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 36: Verify Error Message At Email textbox translate to Taiwan When Inputting Wrong Email Format");
		assertEquals(partnerCreateNewBrandPage.getErrorMessageAtEmailTextBox(),
				"The email must be a valid email address.");
	}

	@Test
	public void TC_07_Create_Brand_Non_Use_Option(Method method) {
		ExtentTestManager.startTest(method.getName(), "Create Brand By Nonuse Option");
		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 01: Refesh Current Page");
		partnerCreateNewBrandPage.refeshCurrentPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 02: Change to Korea Language");
		partnerCreateNewBrandPage.openSelectLanguageList(driver, GlobalConstants.koreaLanguage);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 03: Upload Avatar");
		partnerCreateNewBrandPage.upLoadMultipleFiles(driver, imageAvatart);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 04: Verify Image Is Uploaded Successfully");
		assertTrue(partnerCreateNewBrandPage.isAvatarUpLoaded());

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 05: Input Brand Name '" + brandName + "'");
		partnerCreateNewBrandPage.enterToBrandNameTextBox(brandName);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 06: Select Field '" + GlobalConstants.fieldDropDownListValue + "'");
		partnerCreateNewBrandPage.selectField(GlobalConstants.fieldDropDownListValue);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 07: Click on 'Save' button");
		partnerCreateNewBrandPage.clickSaveButton(GlobalConstants.saveButtonKR);
		partnerBrandManagementPage = PageGeneratorManager.getPartnerBrandMangementPage(driver);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management - Step 08: Verify Brand has just been created in Brand Management list");
		assertTrue(partnerBrandManagementPage.isTextCreatedBrandAtRowDisplayed("브랜드명", "1", brandName));
		assertTrue(partnerBrandManagementPage.isTextCreatedBrandAtRowDisplayed("분야", "1",
				GlobalConstants.fieldDropDownListValue));

	}

	@Test
	public void TC_08_Delete_Brand_Advertiser_Do_Not_Have_CamPaign(Method method) {
		ExtentTestManager.startTest(method.getName(), "Delete Brand Do Not Have Campaign");
		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 01: Input Brand Name '" + brandName + "'");
		partnerBrandManagementPage.enterToSearchBrandTextBox(brandName);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 02: Click on Delete Button");
		partnerBrandManagementPage.clickToDeleteButtonByRownNumber("1", GlobalConstants.deleteButtonKR);

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

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 07: Click To Delete Button");
		partnerBrandManagementPage.clickToDeleteButtonByRownNumber("1", GlobalConstants.deleteButtonKR);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 08: Close Popup By Clicking On Cancel Button");
		partnerBrandManagementPage.clickToClosePopupCancelButton();

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 09: Delete Brand");
		partnerBrandManagementPage.clickToDeleteButtonByRownNumber("1", GlobalConstants.deleteButtonKR);
		partnerBrandManagementPage.clickToDeleteButton();

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 10: Refesh Current Page");
		partnerBrandManagementPage.refeshCurrentPage(driver);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 11: Click on 'Advertiser Management Link");
		partnerBrandManagementPage.clickOnByMenuNameLink(driver, GlobalConstants.advertiserManagementLink);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 12: Click on 'Brand Management Link");
		partnerBrandManagementPage.openByNameLink(driver, GlobalConstants.brandManagementLink);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 13: Verify Brand Is Deleted '" + brandName + "'");
		assertNotEquals(partnerBrandManagementPage.getBrandNameByRownNumber("1", "1"), brandName);
	}

	@Test
	public void TC_09_Create_Brand_Use_Option(Method method) {
		ExtentTestManager.startTest(method.getName(), "Create Brand By Use Option");
		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 01: Open Create A New Brand Page");
		partnerBrandManagementPage.openCreateANewBrand(GlobalConstants.createANewBrandButton);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 02: Upload Avatar");
		partnerCreateNewBrandPage.upLoadMultipleFiles(driver, imageAvatart);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 03: Verify Image Upload Successfully");
		assertTrue(partnerCreateNewBrandPage.isAvatarUpLoaded());

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 04: Input Brand Name '" + brandName + "'");
		partnerCreateNewBrandPage.enterToBrandNameTextBox(brandName);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 05: Select Field '" + GlobalConstants.fieldDropDownListValue + "'");
		partnerCreateNewBrandPage.selectField(GlobalConstants.fieldDropDownListValue);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 06: Click on 'Use' button");
		partnerCreateNewBrandPage.clickOnButtonByName(GlobalConstants.useButtonKR);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 07: Input Email '" + partnerEmailAddress + "'");
		partnerCreateNewBrandPage.enterToEmailTextBox(partnerEmailAddress);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 08: Click On Password Setting Button");
		partnerCreateNewBrandPage.clickToPasswordSettingButton(GlobalConstants.passwordSettingKR);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 09: Input Password '" + GlobalConstants.password + "'");
		partnerCreateNewBrandPage.enterToPasswordTextBox(GlobalConstants.password);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 10: Input Confirm Password '" + GlobalConstants.password + "'");
		partnerCreateNewBrandPage.enterToConfirmPasswordTextBox(GlobalConstants.password);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 11: Click on 'Save' button");
		partnerCreateNewBrandPage.clickSaveButton(GlobalConstants.saveButtonKR);
		partnerBrandManagementPage = PageGeneratorManager.getPartnerBrandMangementPage(driver);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management - Step 12: Verify Brand has just been created in Brand Management list");
		partnerBrandManagementPage.isTextCreatedBrandAtRowDisplayed("브랜드명", "1", brandName);
		partnerBrandManagementPage.isTextCreatedBrandAtRowDisplayed("분야", "1", GlobalConstants.fieldDropDownListValue);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 13: Delete Brand");
		partnerBrandManagementPage.clickToDeleteButtonByRownNumber("1", "삭제하기");

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 14: Close Delete Brand Popup");
		partnerBrandManagementPage.clickToClosePopupCancelButton();
	}

	@Test
	public void TC_10_Delete_Brand_Advertiser_Has_CamPaign(Method method) {
		ExtentTestManager.startTest(method.getName(), "Delete Brand Has Campaign");
		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 01: Search Brand '"
				+ GlobalConstants.brandNameHasCampaignPartnerRoleKR + "'");
		partnerBrandManagementPage
				.enterToSearchBrandTextBox(GlobalConstants.brandNameHasCampaignPartnerRoleKR);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 02: Click on Delete Button");
		partnerBrandManagementPage.clickToDeleteButtonByRownNumber("1", "삭제하기");

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 03: Verify Message Popup is Displayed");
		assertTrue(partnerBrandManagementPage.isPopupDisplayed());

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 04: Change to English Language");
		partnerBrandManagementPage.openSelectLanguageList(driver, GlobalConstants.englishLangguage);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 05: Verify Message Popup translate to English");
		assertEquals(partnerBrandManagementPage.getTitlePopup(), "Delete Brand");
		assertEquals(partnerBrandManagementPage.getTextMessage(),
				"You cannot delete the brand that has any campaign history.");
		assertEquals(partnerBrandManagementPage.getDeleteButtonText(), "Confirm");

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 06: Change to Korea Language");
		partnerBrandManagementPage.openSelectLanguageList(driver, GlobalConstants.koreaLanguage);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 07: Verify Message Popup translate to Korea");
		assertEquals(partnerBrandManagementPage.getTitlePopup(), "브랜드 삭제");
		assertEquals(partnerBrandManagementPage.getTextMessage(), "캠페인을 진행한 이력이 있는 광고주는 삭제할 수 없습니다.");
		assertEquals(partnerBrandManagementPage.getDeleteButtonText(), "확인");

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 08: Click On Confirm Button");
		partnerBrandManagementPage.clickToDeleteButton();

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 09: Verify Brand Is Not Deleted");
		assertEquals(partnerBrandManagementPage.getBrandNameByRownNumber("1", "1"),
				GlobalConstants.brandNameHasCampaignPartnerRoleKR);
	}

	@Test
	public void TC_11_Edit_Brand_Information(Method method) {
		ExtentTestManager.startTest(method.getName(), "Edit Brand Information");
		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 01: Refesh Page");
		partnerBrandManagementPage.refeshCurrentPage(driver);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 02: Click on 'Advertiser Brand Management Link");
		partnerBrandManagementPage.clickOnByMenuNameLink(driver, GlobalConstants.advertiserManagementLink);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 03: Click on 'Brand Management Link");
		partnerBrandManagementPage.openByNameLink(driver, GlobalConstants.brandManagementLink);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 04: Click on 'Create a new Brand' Button");
		partnerBrandManagementPage.openCreateANewBrand(GlobalConstants.createANewBrandButton);
		partnerCreateNewBrandPage = PageGeneratorManager.getPartnerCreateANewBrandPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 05: Upload Avatar");
		partnerCreateNewBrandPage.upLoadMultipleFiles(driver, imageAvatart);
		assertTrue(partnerCreateNewBrandPage.isAvatarUpLoaded());

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 06: Input Brand Name");
		partnerCreateNewBrandPage.enterToBrandNameTextBox(brandName);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 07: Select Field");
		partnerCreateNewBrandPage.selectField(GlobalConstants.fieldDropDownListValue);

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
		assertEquals(partnerDetailBrandPage.getSeeBrandTextButton(), GlobalConstants.titleBrandManagementPage);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 15: Open See Brand Partner Page");
		partnerDetailBrandPage.clickToSeeBrandPageButton();

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 16: Switch To Advertiser Page");
		partnerDetailBrandPage.switchTab(GlobalConstants.advertiserTestUrl);
		advertiserDashBoardPage = PageGeneratorManager.getAdvertiserDashBoardPage(driver);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management - Step 17: Verify Advertiser Name '" + brandName + "'");
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
		partnerDetailBrandPage.enterToPasswordTextBox(GlobalConstants.password);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 25: Enter To Confirm Password TextBox");
		partnerDetailBrandPage.enterToConfirmPasswordTextBox(GlobalConstants.password);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 26: Click On Save Button");
		partnerDetailBrandPage.clickSaveButton("저장하기");

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management - Step 27: Verify Email Alerady Exists In System Korea Language");
		assertEquals(partnerDetailBrandPage.getErrorMessageAtEmailTextBox(), "이미 사용 중 입니다.");

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 28: Change To English Language");
		partnerDetailBrandPage.openSelectLanguageList(driver, GlobalConstants.englishLangguage);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management - Step 29: Verify Email Alerady Exists In System English Language");
		assertEquals(partnerDetailBrandPage.getErrorMessageAtEmailTextBox(), "The email has already been taken.");

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 30: Change To Korea Language");
		partnerDetailBrandPage.openSelectLanguageList(driver, GlobalConstants.koreaLanguage);

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
		adminHomePage.enterToPasswordAdvertiserTextBox(GlobalConstants.password);

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 37: Open Advertiser Page");
		advertiserDashBoardPage = adminHomePage.openAdvertiserPage("로그인");
		advertiserDashBoardPage = PageGeneratorManager.getAdvertiserDashBoardPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 38: Open Advertiser Page Successfull");
		assertTrue(advertiserDashBoardPage.isDeliveryMenuDisplayed());
	}

	@Parameters({ "browser" })
	@AfterClass(alwaysRun = true)
	public void afterClass(String browserName) {
		ExtentTestManager.getTest().log(Status.INFO, "Close broser '" + browserName + "'");
		closeBrowserAndDriver();
	}
}
