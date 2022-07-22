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
import pageObjects.revu.Admin.AdminDashBoardPageObject;
import pageObjects.revu.Admin.AdminHomePageObject;
import pageObjects.revu.Advertiser.AdvertiserDashBoardPageObject;
import pageObjects.revu.Manager.ManagerBrandManagementPageObject;
import pageObjects.revu.Manager.ManagerCreateBrandManagementPageObject;
import pageObjects.revu.Manager.ManagerDetailBrandManagementPageObject;
import reportConfig.ExtentTestManager;

public class Create_Edit_Login_Advertiser_Korea_Manager_Role extends BaseTest {

	WebDriver driver;
	AdminDashBoardPageObject adminDashBoardPage;
	AdminHomePageObject adminHomePage;
	ManagerBrandManagementPageObject adminBrandManagementPage;
	AdvertiserDashBoardPageObject advertiserDashBoardPage;
	ManagerDetailBrandManagementPageObject adminDetailBrandPage;
	ManagerCreateBrandManagementPageObject adminCreateNewBrandPage;
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
	public void Manage_Role_KR_TC_03_Check_Translate_To_Korea_Brand_Management_Page(Method method) {
		ExtentTestManager.startTest(method.getName(), "Check Translate To Korea At Brand Management Page");
		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 01: Click on 'Advertiser Brand Management Link");
		adminDashBoardPage.clickOnByMenuNameLink(driver, GlobalConstants.getGlobalConstants().getAdvertiserManagementLinkKR());

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 02: Click on 'Brand Management Link");
		adminDashBoardPage.openByNameLink(driver, GlobalConstants.getGlobalConstants().getBrandManagementLinkKR());
		adminBrandManagementPage = PageGeneratorManager.getManagementPage(driver);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 03: Verify (브랜드 관리) Brand Management Page is Displayed");
		assertEquals(adminBrandManagementPage.getTitlePageName(driver), GlobalConstants.getGlobalConstants().getTitleBrandManagementPageKR());

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 04: Verify Brand label is Korea languages");
		assertTrue(adminBrandManagementPage.isPlaceHolderDisplayed("브랜드명", GlobalConstants.getGlobalConstants().getPlaceholderTextBoxKR()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 05: Verify Field label is Korea languages");
		assertTrue(adminBrandManagementPage.isPlaceHolderFieldDropDownListDisplayed("분야",
				GlobalConstants.getGlobalConstants().getPlaceholderFieldDropDownListKR()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 06: Verify Representative label is Korea languages");
		assertTrue(adminBrandManagementPage.isPlaceHolderDisplayed("담당자명", GlobalConstants.getGlobalConstants().getPlaceholderTextBoxKR()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 07: Verify Partner label is Korea languages");
		assertTrue(adminBrandManagementPage.isPlaceHolderDisplayed("브랜드명", GlobalConstants.getGlobalConstants().getPlaceholderTextBoxKR()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 08: Verify Email label is Korea languages");
		assertTrue(adminBrandManagementPage.isPlaceHolderDisplayed("이메일", GlobalConstants.getGlobalConstants().getPlaceholderTextBoxKR()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 09: Verify Phone label is Korea languages");
		assertTrue(adminBrandManagementPage.isPlaceHolderDisplayed("휴대전화",
				GlobalConstants.getGlobalConstants().getPlaceholderPhoneTextBoxKR()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 10: Verify Search button is Korea languages");
		assertTrue(adminBrandManagementPage.isButtonDisplayed(GlobalConstants.getGlobalConstants().getSearchButtonAtSearchFilterKR()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 11: Verify Reset button is Korea languages");
		assertTrue(adminBrandManagementPage.isButtonDisplayed(GlobalConstants.getGlobalConstants().getResetButtonAtSearchFilterKR()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 12: Verify Brand No. column is Korea languages");
		assertTrue(adminBrandManagementPage.isColumnNameDisplayed("브랜드 번호"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 13: Verify Partner column is Korea languages");
		assertTrue(adminBrandManagementPage.isColumnNameDisplayed("파트너명"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 14: Verify Brand column is Korea languages");
		assertTrue(adminBrandManagementPage.isColumnNameDisplayed("브랜드명"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 15: Verify Field column is Korea languages");
		assertTrue(adminBrandManagementPage.isColumnNameDisplayed("분야"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 16: Verify Email	column is Korea languages");
		assertTrue(adminBrandManagementPage.isColumnNameDisplayed("이메일"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 17: Verify Representative column is Korea languages");
		assertTrue(adminBrandManagementPage.isColumnNameDisplayed("담당자명"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 18: Verify Phone column is Korea languages");
		assertTrue(adminBrandManagementPage.isColumnNameDisplayed("휴대전화"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 19: Verify Camp. On-going column is Korea languages");
		assertTrue(adminBrandManagementPage.isColumnNameDisplayed("캠페인 진행중"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 20: Verify Camp. Completed column is Korea languages");
		assertTrue(adminBrandManagementPage.isColumnNameDisplayed("캠페인 종료"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 21: Verify Date of Creation column is Korea languages");
		assertTrue(adminBrandManagementPage.isColumnNameDisplayed("생성 일자"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 22: Verify Delete column is Korea languages");
		assertTrue(adminBrandManagementPage.isColumnNameDisplayed("삭제"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 23: Verify Delete button is Korea languages");
		assertTrue(adminBrandManagementPage.isTextAtRowDisplayed("삭제", "1", GlobalConstants.getGlobalConstants().getDeleteButtonKR()));
	}

	@Test
	public void Manage_Role_KR_TC_04_Check_Translate_To_English_Brand_Management_Page(Method method) {
		ExtentTestManager.startTest(method.getName(), "Check Translate To English At Brand Management Page");
		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 1: Change to English Language");
		adminBrandManagementPage.openSelectLanguageList(driver, GlobalConstants.getGlobalConstants().getEnglishLangguage());

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 2: Verify Brand Management Page is Displayed");
		assertEquals(adminBrandManagementPage.getTitlePageName(driver), GlobalConstants.getGlobalConstants().getTitleBrandManagementPageEN());

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 3: Verify Brand label is English languages");
		assertTrue(
				adminBrandManagementPage.isPlaceHolderDisplayed("Brand", GlobalConstants.getGlobalConstants().getPlaceholderTextBoxEN()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 4: Verify Field label is English languages");
		assertTrue(adminBrandManagementPage.isPlaceHolderFieldDropDownListDisplayed("Field",
				GlobalConstants.getGlobalConstants().getPlaceholderFieldDropDownListEN()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 5: Verify Representative label is English languages");
		assertTrue(adminBrandManagementPage.isPlaceHolderDisplayed("Representative",
				GlobalConstants.getGlobalConstants().getPlaceholderTextBoxEN()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 6: Verify Partner label is English languages");
		assertTrue(
				adminBrandManagementPage.isPlaceHolderDisplayed("Partner", GlobalConstants.getGlobalConstants().getPlaceholderTextBoxEN()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 7: Verify Email label is English languages");
		assertTrue(
				adminBrandManagementPage.isPlaceHolderDisplayed("Email", GlobalConstants.getGlobalConstants().getPlaceholderTextBoxEN()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 8: Verify Phone label is English languages");
		assertTrue(adminBrandManagementPage.isPlaceHolderDisplayed("Phone",
				GlobalConstants.getGlobalConstants().getPlaceholderPhoneTextBoxEN()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 9: Verify Search button is English languages");
		assertTrue(adminBrandManagementPage.isButtonDisplayed(GlobalConstants.getGlobalConstants().getSearchButtonAtSearchFilterEN()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 10: Verify Reset button is English languages");
		assertTrue(adminBrandManagementPage.isButtonDisplayed(GlobalConstants.getGlobalConstants().getResetButtonAtSearchFilterEN()));

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
		assertTrue(adminBrandManagementPage.isTextAtRowDisplayed("Delete", "1", GlobalConstants.getGlobalConstants().getDeleteButtonEN()));

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 23: Change to Korea Language");
		adminBrandManagementPage.openSelectLanguageList(driver, GlobalConstants.getGlobalConstants().getKoreaLanguage());
	}

	@Test
	public void Manage_Role_KR_TC_05_Check_Translate_To_Korea_Create_Brand_Page(Method method) {
		ExtentTestManager.startTest(method.getName(), "Check Translate To Korea At Create Brand Page");
		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 01: Click on 'Create a new Brand' Button");
		adminBrandManagementPage.openCreateANewBrand(GlobalConstants.getGlobalConstants().getCreateANewBrandButtonKR());
		adminCreateNewBrandPage = PageGeneratorManager.getCreateANewBrandPage(driver);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 02: Verify Open 'Create New Brand Page' Successfull");
		assertEquals(adminCreateNewBrandPage.getTitlePageName(driver), GlobalConstants.getGlobalConstants().getTitleBrandManagementDetailPageKR());

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
		assertTrue(adminCreateNewBrandPage.isPlaceHolderByLabelNameDisplayed("브랜드명",
				GlobalConstants.getGlobalConstants().getPlaceholderTextBoxKR()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 07: Verify Partner area translate to Korea");
		assertTrue(adminCreateNewBrandPage.isPlaceHolderByLabelNameDisplayed("파트너",
				GlobalConstants.getGlobalConstants().getPlaceholderPartnerDropDownListKR()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 08: Verify Account Setting area translate to Korea");
		assertTrue(adminCreateNewBrandPage.isAccountSettingDisplayed("계정 설정"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 09: Verify Use button translate to Korea");
		assertTrue(adminCreateNewBrandPage.isButtonNameDisplayed(GlobalConstants.getGlobalConstants().getUseButtonKR()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 10: Verify Nonuse button translate to Korea");
		assertTrue(adminCreateNewBrandPage.isButtonNameDisplayed(GlobalConstants.getGlobalConstants().getNonUseButtonKR()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 11: Verify Field area translate to Korea");
		assertTrue(adminCreateNewBrandPage.isPlaceHolderByDropDownListNameDisplayed("분야",
				GlobalConstants.getGlobalConstants().getPlaceholderFieldDropDownListKR()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 12: Verify Save button translate to Korea");
		assertTrue(adminCreateNewBrandPage.isSaveButtonDisplayed(GlobalConstants.getGlobalConstants().getSaveButtonKR()));

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 13: Verify Save button is disabled");
		assertFalse(adminCreateNewBrandPage.isSaveButtonDisabled(GlobalConstants.getGlobalConstants().getSaveButtonKR()));

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 14: Verify Field after selecting value");
		adminCreateNewBrandPage.selectField(GlobalConstants.getGlobalConstants().getFieldDropDownListValue());
		assertTrue(adminCreateNewBrandPage.isPlaceHolderByDropDownListNameDisplayed("분야",
				GlobalConstants.getGlobalConstants().getFieldDropDownListValue()));

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 15: Verify Save button is disabled");
		assertTrue(adminCreateNewBrandPage.isSaveButtonDisabled(GlobalConstants.getGlobalConstants().getSaveButtonKR()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 16: Verify Account Information After Clicking On 'Use' Button");
		adminCreateNewBrandPage.clickOnButtonByName(GlobalConstants.getGlobalConstants().getUseButtonKR());

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 17: Verify Email area translate to Korea");
		assertTrue(adminCreateNewBrandPage.isPlaceHolderByLabelNameDisplayed("이메일",
				GlobalConstants.getGlobalConstants().getPlaceholderTextBoxKR()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 18: Verify Password area translate to Korea");
		assertTrue(adminCreateNewBrandPage.isLabelByNameDisplayed("비밀번호"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 19: Verify Password Setting button translate to Korea");
		assertEquals(adminCreateNewBrandPage.getTextResetPasswordButton(), GlobalConstants.getGlobalConstants().getPasswordSettingKR());

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 20: Verify Representative area translate to Korea");
		assertTrue(adminCreateNewBrandPage.isPlaceHolderByLabelNameDisplayed("담당자명",
				GlobalConstants.getGlobalConstants().getPlaceholderTextBoxKR()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 21: Verify Phone area translate to Korea");
		assertTrue(adminCreateNewBrandPage.isPlaceHolderByLabelNameDisplayed("휴대전화",
				GlobalConstants.getGlobalConstants().getPlaceholderPhoneTextBoxKR()));

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 22: Verify Refesh Current Page");
		adminCreateNewBrandPage.refeshCurrentPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 23: Verify Save button is disabled");
		assertFalse(adminCreateNewBrandPage.isSaveButtonDisabled(GlobalConstants.getGlobalConstants().getSaveButtonKR()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 24: Verify Account Information After Clicking On 'Use' Button");
		adminCreateNewBrandPage.clickOnButtonByName(GlobalConstants.getGlobalConstants().getUseButtonKR());

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 25: Click on Password Setting Button");
		adminCreateNewBrandPage.clickToPasswordSettingButton(GlobalConstants.getGlobalConstants().getPasswordSettingKR());

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 26: Verify Password Setting will be changed to Cancel Setting");
		assertEquals(adminCreateNewBrandPage.getTextResetPasswordButton(), GlobalConstants.getGlobalConstants().getCancelSettingKR());

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 27: Enter Password '" + GlobalConstants.getGlobalConstants().getPassword() + "'");
		adminCreateNewBrandPage.enterToPasswordTextBox(GlobalConstants.getGlobalConstants().getPassword());

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 28: Enter Confirm Password is not match '"
						+ GlobalConstants.getGlobalConstants().getIncorrectPassword() + "'");
		adminCreateNewBrandPage.enterToConfirmPasswordTextBox(GlobalConstants.getGlobalConstants().getIncorrectPassword());

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 29: Click on 'Save' Button");
		adminCreateNewBrandPage.clickSaveButton(GlobalConstants.getGlobalConstants().getSaveButtonKR());

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 30: Verify Error Message At Brand Name textbox translate to Korea");
		assertEquals(adminCreateNewBrandPage.getErrorMessageAtBrandNameTextBox(), "필수입력사항 입니다.");

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 31: Verify Error Message At Field DropDown List translate to Korea");
		assertEquals(adminCreateNewBrandPage.getErrorMessageAtFieldDropdownList(), "필수입력사항 입니다.");

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 32: Verify Error Message At Partner dropdown list translate to Korea");
		assertEquals(adminCreateNewBrandPage.getErrorMessageAtPartnerDropdownList(), "필수입력사항 입니다.");

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 33: Verify Error Message At Email textbox translate to Korea");
		assertEquals(adminCreateNewBrandPage.getErrorMessageAtEmailTextBox(), "필수입력사항 입니다.");

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 34: Verify Error Message At Confirm Password textbox translate to Korea");
		assertEquals(adminCreateNewBrandPage.getErrorMessageAtConfirmPasswordTextBox(), "정보가 일치하지 않습니다.");

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 35: Enter To Email TextBox Wrong Email Format");
		adminCreateNewBrandPage.enterToEmailTextBox(GlobalConstants.getGlobalConstants().getWrongEmailFormat());

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 36: Click On Save Button");
		adminCreateNewBrandPage.clickSaveButton(GlobalConstants.getGlobalConstants().getSaveButtonKR());

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 37: Verify Error Message At Email textbox translate to Taiwan When Inputting Wrong Email Format");
		assertEquals(adminCreateNewBrandPage.getErrorMessageAtEmailTextBox(), "이메일 형식에 맞게 입력해주세요.");
	}

	@Test
	public void Manage_Role_KR_TC_06_Check_Translate_To_English_Create_Brand_Page(Method method) {
		ExtentTestManager.startTest(method.getName(), "Check Translate To English At Create Brand Page");
		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 01: Refresh Current Page");
		adminCreateNewBrandPage.refeshCurrentPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 02: Change to English Language");
		adminCreateNewBrandPage.openSelectLanguageList(driver, GlobalConstants.getGlobalConstants().getEnglishLangguage());

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 03: Verify Title of Company Information section translate to English");
		assertEquals(adminCreateNewBrandPage.getTitlePageName(driver), GlobalConstants.getGlobalConstants().getTitleBrandManagementDetailPageEN());

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
				GlobalConstants.getGlobalConstants().getPlaceholderTextBoxEN()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 08: Verify Partner area translate to English");
		assertTrue(adminCreateNewBrandPage.isPlaceHolderByLabelNameDisplayed("Partner",
				GlobalConstants.getGlobalConstants().getPlaceholderPartnerDropDownListEN()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 09: Verify Account Setting area translate to English");
		assertTrue(adminCreateNewBrandPage.isAccountSettingDisplayed("Account Setting"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 10: Verify Use button translate to English");
		assertTrue(adminCreateNewBrandPage.isButtonNameDisplayed(GlobalConstants.getGlobalConstants().getUseButtonEN()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 11: Verify Nonuse button translate to English");
		assertTrue(adminCreateNewBrandPage.isButtonNameDisplayed(GlobalConstants.getGlobalConstants().getNonUseButtonEN()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 12: Verify Field area translate to English");
		assertTrue(adminCreateNewBrandPage.isPlaceHolderByDropDownListNameDisplayed("Field",
				GlobalConstants.getGlobalConstants().getPlaceholderFieldDropDownListEN()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 13: Verify Save button translate to English");
		assertTrue(adminCreateNewBrandPage.isSaveButtonDisplayed(GlobalConstants.getGlobalConstants().getSaveButtonEN()));

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 14: Verify Save button is disabled");
		assertFalse(adminCreateNewBrandPage.isSaveButtonDisabled(GlobalConstants.getGlobalConstants().getSaveButtonEN()));

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 15: Verify Field after selecting value");
		adminCreateNewBrandPage.selectField(GlobalConstants.getGlobalConstants().getFieldDropDownListValue());
		assertTrue(adminCreateNewBrandPage.isPlaceHolderByDropDownListNameDisplayed("Field",
				GlobalConstants.getGlobalConstants().getFieldDropDownListValue()));

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 16: Verify Save button is disabled");
		assertTrue(adminCreateNewBrandPage.isSaveButtonDisabled(GlobalConstants.getGlobalConstants().getSaveButtonEN()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 17: Verify Account Information After Clicking On 'Use' Button");
		adminCreateNewBrandPage.clickOnButtonByName(GlobalConstants.getGlobalConstants().getUseButtonEN());

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 18: Verify Email area translate to English");
		assertTrue(adminCreateNewBrandPage.isPlaceHolderByLabelNameDisplayed("Email",
				GlobalConstants.getGlobalConstants().getPlaceholderTextBoxEN()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 19: Verify Password area translate to English");
		assertTrue(adminCreateNewBrandPage.isLabelByNameDisplayed("Password"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 20: Verify Reset Password button translate to English");
		assertEquals(adminCreateNewBrandPage.getTextResetPasswordButton(), GlobalConstants.getGlobalConstants().getPasswordSettingEN());

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 21: Verify Representative area translate to English");
		assertTrue(adminCreateNewBrandPage.isPlaceHolderByLabelNameDisplayed("Representative",
				GlobalConstants.getGlobalConstants().getPlaceholderTextBoxEN()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 22: Verify Phone area translate to English");
		assertTrue(adminCreateNewBrandPage.isPlaceHolderByLabelNameDisplayed("Phone",
				GlobalConstants.getGlobalConstants().getPlaceholderPhoneTextBoxEN()));

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 23: Verify Refesh Current Page");
		adminCreateNewBrandPage.refeshCurrentPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 24: Verify Save button is disabled");
		assertFalse(adminCreateNewBrandPage.isSaveButtonDisabled(GlobalConstants.getGlobalConstants().getSaveButtonEN()));

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 25: Verify Account Information After Clicking On 'Use' Button");
		adminCreateNewBrandPage.clickOnButtonByName(GlobalConstants.getGlobalConstants().getUseButtonEN());

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 26: Click On Password Setting Button");
		adminCreateNewBrandPage.clickToPasswordSettingButton(GlobalConstants.getGlobalConstants().getPasswordSettingEN());

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 27: Verify Reset Password will be changed to Cancel Setting");
		assertEquals(adminCreateNewBrandPage.getTextResetPasswordButton(), GlobalConstants.getGlobalConstants().getCancelSettingEN());

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 28: Enter Password '" + GlobalConstants.getGlobalConstants().getPassword() + "'");
		adminCreateNewBrandPage.enterToPasswordTextBox(GlobalConstants.getGlobalConstants().getPassword());

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 29: Enter Confirm Password is not match '"
						+ GlobalConstants.getGlobalConstants().getPassword() + "'");
		adminCreateNewBrandPage.enterToConfirmPasswordTextBox(GlobalConstants.getGlobalConstants().getIncorrectPassword());

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 30: Click on 'Save' Button");
		adminCreateNewBrandPage.clickSaveButton(GlobalConstants.getGlobalConstants().getSaveButtonEN());

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

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 34: Enter To Email TextBox Wrong Email Format");
		adminCreateNewBrandPage.enterToEmailTextBox(GlobalConstants.getGlobalConstants().getWrongEmailFormat());

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 35: Click On Save Button");
		adminCreateNewBrandPage.clickSaveButton(GlobalConstants.getGlobalConstants().getSaveButtonEN());

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 36: Verify Error Message At Email textbox translate to Taiwan When Inputting Wrong Email Format");
		assertEquals(adminCreateNewBrandPage.getErrorMessageAtEmailTextBox(),
				"The email must be a valid email address.");
	}

	@Test
	public void Manage_Role_KR_TC_07_Create_Brand_Non_Use_Option(Method method) {
		ExtentTestManager.startTest(method.getName(), "Create Brand By Nonuse Option");
		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 01: Refesh Current Page");
		adminCreateNewBrandPage.refeshCurrentPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 02: Change to Korea Language");
		adminCreateNewBrandPage.openSelectLanguageList(driver, GlobalConstants.getGlobalConstants().getKoreaLanguage());

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 03: Upload Avatar");
		adminCreateNewBrandPage.upLoadMultipleFiles(driver, imageAvatart);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 04: Verify Image Is Uploaded Successfully");
		assertTrue(adminCreateNewBrandPage.isAvatarUpLoaded());

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 05: Input Brand Name '" + brandName + "'");
		adminCreateNewBrandPage.enterToBrandNameTextBox(brandName);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 06: Select Field '" + GlobalConstants.getGlobalConstants().getFieldDropDownListValue() + "'");
		adminCreateNewBrandPage.selectField(GlobalConstants.getGlobalConstants().getFieldDropDownListValue());

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 07: Input Partner Name '"
				+ GlobalConstants.getGlobalConstants().getPartnerNameSearchFieldKorea() + "'");
		adminCreateNewBrandPage.enterToPartNameTextBox(GlobalConstants.getGlobalConstants().getPartnerNameSearchFieldKorea());

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 08: Select Partner Name '"
				+ GlobalConstants.getGlobalConstants().getPartnerNameAndEmailSearchFieldKorea() + "'");
		adminCreateNewBrandPage.selectPartnerByName(GlobalConstants.getGlobalConstants().getPartnerNameAndEmailSearchFieldKorea());

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 09: Click on 'Save' button");
		adminCreateNewBrandPage.clickSaveButton(GlobalConstants.getGlobalConstants().getSaveButtonKR());
		adminBrandManagementPage = PageGeneratorManager.getManagementPage(driver);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management - Step 10: Verify Brand has just been created in Brand Management list");
		assertTrue(adminBrandManagementPage.isTextCreatedBrandAtRowDisplayed("파트너명", "1",
				GlobalConstants.getGlobalConstants().getPartnerNameSearchFieldKorea()));
		assertTrue(adminBrandManagementPage.isTextCreatedBrandAtRowDisplayed("브랜드명", "1", brandName));
		assertTrue(adminBrandManagementPage.isTextCreatedBrandAtRowDisplayed("분야", "1",
				GlobalConstants.getGlobalConstants().getFieldDropDownListValue()));

	}

	@Test
	public void Manage_Role_KR_TC_08_Delete_Brand_Advertiser_Do_Not_Have_CamPaign(Method method) {
		ExtentTestManager.startTest(method.getName(), "Delete Brand Do Not Have Campaign");
		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 01: Input Brand Name '" + brandName + "'");
		adminBrandManagementPage.enterToSearchBrandTextBox(brandName);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 02: Click on Search Button");
		adminBrandManagementPage.clickToSearchButton();

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 03: Click on Delete Button");
		adminBrandManagementPage.clickToDeleteButtonByRownNumber("1", GlobalConstants.getGlobalConstants().getDeleteButtonKR());

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

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 08: Click To Delete Button");
		adminBrandManagementPage.clickToDeleteButtonByRownNumber("1", GlobalConstants.getGlobalConstants().getDeleteButtonKR());

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 09: Close Popup By Clicking On Cancel Button");
		adminBrandManagementPage.clickToClosePopupCancelButton();

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 10: Delete Brand");
		adminBrandManagementPage.clickToDeleteButtonByRownNumber("1", GlobalConstants.getGlobalConstants().getDeleteButtonKR());
		adminBrandManagementPage.clickToDeleteButton();

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 11: Click on 'Brand Management Link");
		adminBrandManagementPage.openByNameLink(driver, GlobalConstants.getGlobalConstants().getBrandManagementLinkKR());

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 12: Verify Brand Is Deleted '" + brandName + "'");
		assertNotEquals(adminBrandManagementPage.getBrandNameByRownNumber("1", "3"), brandName);
	}

	@Test
	public void Manage_Role_KR_TC_09_Create_Brand_Use_Option(Method method) {
		ExtentTestManager.startTest(method.getName(), "Create Brand By Use Option");
		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 01: Open Create A New Brand Page");
		adminBrandManagementPage.openCreateANewBrand(GlobalConstants.getGlobalConstants().getCreateANewBrandButtonKR());

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 02: Upload Avatar");
		adminCreateNewBrandPage.upLoadMultipleFiles(driver, imageAvatart);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 03: Verify Image Upload Successfully");
		assertTrue(adminCreateNewBrandPage.isAvatarUpLoaded());

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 04: Input Brand Name '" + brandName + "'");
		adminCreateNewBrandPage.enterToBrandNameTextBox(brandName);

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 05: Select Field '" + GlobalConstants.getGlobalConstants().getFieldDropDownListValue() + "'");
		adminCreateNewBrandPage.selectField(GlobalConstants.getGlobalConstants().getFieldDropDownListValue());

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 06: Input Partner Name '"
				+ GlobalConstants.getGlobalConstants().getPartnerNameSearchFieldKorea() + "'");
		adminCreateNewBrandPage.enterToPartNameTextBox(GlobalConstants.getGlobalConstants().getPartnerNameSearchFieldKorea());

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 07: Select Partner Name '"
				+ GlobalConstants.getGlobalConstants().getPartnerNameAndEmailSearchFieldKorea() + "'");
		adminCreateNewBrandPage.selectPartnerByName(GlobalConstants.getGlobalConstants().getPartnerNameAndEmailSearchFieldKorea());

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 08: Click on 'Use' button");
		adminCreateNewBrandPage.clickOnButtonByName(GlobalConstants.getGlobalConstants().getUseButtonKR());

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 09: Input Email '" + partnerEmailAddress + "'");
		adminCreateNewBrandPage.enterToEmailTextBox(partnerEmailAddress);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 10: Click On Password Setting Button");
		adminCreateNewBrandPage.clickToPasswordSettingButton(GlobalConstants.getGlobalConstants().getPasswordSettingKR());

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 11: Input Password '" + GlobalConstants.getGlobalConstants().getPassword() + "'");
		adminCreateNewBrandPage.enterToPasswordTextBox(GlobalConstants.getGlobalConstants().getPassword());

		ExtentTestManager.getTest().log(Status.INFO,
				"Create Brand Page - Step 12: Input Confirm Password '" + GlobalConstants.getGlobalConstants().getPassword() + "'");
		adminCreateNewBrandPage.enterToConfirmPasswordTextBox(GlobalConstants.getGlobalConstants().getPassword());

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 13: Click on 'Save' button");
		adminCreateNewBrandPage.clickSaveButton(GlobalConstants.getGlobalConstants().getSaveButtonKR());
		adminBrandManagementPage = PageGeneratorManager.getManagementPage(driver);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management - Step 14: Verify Brand has just been created in Brand Management list");
		adminBrandManagementPage.isTextCreatedBrandAtRowDisplayed("파트너명", "1",
				GlobalConstants.getGlobalConstants().getPartnerNameSearchFieldKorea());
		adminBrandManagementPage.isTextCreatedBrandAtRowDisplayed("브랜드명", "1", brandName);
		adminBrandManagementPage.isTextCreatedBrandAtRowDisplayed("분야", "1", GlobalConstants.getGlobalConstants().getFieldDropDownListValue());

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 15: Delete Brand");
		adminBrandManagementPage.clickToDeleteButtonByRownNumber("1", GlobalConstants.getGlobalConstants().getDeleteButtonKR());

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 16: Close Delete Brand Popup");
		adminBrandManagementPage.clickToClosePopupCancelButton();
	}

	@Test
	public void Manage_Role_KR_TC_10_Delete_Brand_Advertiser_Has_CamPaign(Method method) {
		ExtentTestManager.startTest(method.getName(), "Delete Brand Has Campaign");
		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 01: Search Brand '"
				+ GlobalConstants.getGlobalConstants().getBrandNameHasCampaignManagerRoleKR() + "'");
		adminBrandManagementPage.enterToSearchBrandTextBox(GlobalConstants.getGlobalConstants().getBrandNameHasCampaignManagerRoleKR());

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 02: Click on Search Button");
		adminBrandManagementPage.clickToResetButton();

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 03: Search Brand '"
				+ GlobalConstants.getGlobalConstants().getBrandNameHasCampaignManagerRoleKR() + "'");
		adminBrandManagementPage.enterToSearchBrandTextBox(GlobalConstants.getGlobalConstants().getBrandNameHasCampaignManagerRoleKR());

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 04: Click on Search Button");
		adminBrandManagementPage.clickToSearchButton();

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 05: Click on Delete Button");
		adminBrandManagementPage.clickToDeleteButtonByRownNumber("1", GlobalConstants.getGlobalConstants().getDeleteButtonKR());

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 06: Verify Message Popup is Displayed");
		assertTrue(adminBrandManagementPage.isPopupDisplayed());

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 07: Change to English Language");
		adminBrandManagementPage.openSelectLanguageList(driver, GlobalConstants.getGlobalConstants().getEnglishLangguage());

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 08: Verify Message Popup translate to English");
		assertEquals(adminBrandManagementPage.getTitlePopup(), "Delete Brand");
		assertEquals(adminBrandManagementPage.getTextMessage(),
				"You cannot delete the brand that has any campaign history.");
		assertEquals(adminBrandManagementPage.getDeleteButtonText(), "Confirm");

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 09: Change to Korea Language");
		adminBrandManagementPage.openSelectLanguageList(driver, GlobalConstants.getGlobalConstants().getKoreaLanguage());

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 10: Verify Message Popup translate to Korea");
		assertEquals(adminBrandManagementPage.getTitlePopup(), "브랜드 삭제");
		assertEquals(adminBrandManagementPage.getTextMessage(), "캠페인을 진행한 이력이 있는 광고주는 삭제할 수 없습니다.");
		assertEquals(adminBrandManagementPage.getDeleteButtonText(), "확인");

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 11: Click On Confirm Button");
		adminBrandManagementPage.clickToDeleteButton();

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 12: Verify Brand Is Not Deleted");
		assertEquals(adminBrandManagementPage.getBrandNameByRownNumber("1", "3"),
				GlobalConstants.getGlobalConstants().getBrandNameHasCampaignManagerRoleKR());
	}

	@Test
	public void Manage_Role_KR_TC_11_Edit_Brand_Information(Method method) {
		ExtentTestManager.startTest(method.getName(), "Edit Brand Information");
		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 01: Refesh Page");
		adminBrandManagementPage.refeshCurrentPage(driver);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 02: Click on 'Advertiser Brand Management Link");
		adminBrandManagementPage.clickOnByMenuNameLink(driver, GlobalConstants.getGlobalConstants().getAdvertiserManagementLinkKR());

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 03: Click on 'Brand Management Link");
		adminBrandManagementPage.openByNameLink(driver, GlobalConstants.getGlobalConstants().getBrandManagementLinkKR());

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management Page - Step 04: Click on 'Create a new Brand' Button");
		adminBrandManagementPage.openCreateANewBrand(GlobalConstants.getGlobalConstants().getCreateANewBrandButtonKR());
		adminCreateNewBrandPage = PageGeneratorManager.getCreateANewBrandPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 05: Upload Avatar");
		adminCreateNewBrandPage.upLoadMultipleFiles(driver, imageAvatart);
		assertTrue(adminCreateNewBrandPage.isAvatarUpLoaded());

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 06: Input Brand Name");
		adminCreateNewBrandPage.enterToBrandNameTextBox(brandName);

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 07: Select Field");
		adminCreateNewBrandPage.selectField(GlobalConstants.getGlobalConstants().getFieldDropDownListValue());

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 08: Input Partner Name '"
				+ GlobalConstants.getGlobalConstants().getPartnerNameSearchFieldKorea() + "'");
		adminCreateNewBrandPage.enterToPartNameTextBox(GlobalConstants.getGlobalConstants().getPartnerNameSearchFieldKorea());

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 09: Select Partner Name '"
				+ GlobalConstants.getGlobalConstants().getPartnerNameAndEmailSearchFieldKorea() + "'");
		adminCreateNewBrandPage.selectPartnerByName(GlobalConstants.getGlobalConstants().getPartnerNameAndEmailSearchFieldKorea());

		ExtentTestManager.getTest().log(Status.INFO, "Create Brand Page - Step 10: Click on 'Save' button");
		adminCreateNewBrandPage.clickSaveButton(GlobalConstants.getGlobalConstants().getSaveButtonKR());
		adminBrandManagementPage = PageGeneratorManager.getManagementPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 11: Search Brand '" + brandName + "'");
		adminBrandManagementPage.enterToSearchBrandTextBox(brandName);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management Page - Step 12: Click on Search Button");
		adminBrandManagementPage.clickToSearchButton();

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 13: Open Brand Information Detail Page");
		adminBrandManagementPage.clickToBrandNameByRownNumber("1", brandName);
		adminDetailBrandPage = PageGeneratorManager.getDetailBrandPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 14: Get Current Page URL");
		getCurrentUrl = adminDetailBrandPage.getPageUrl(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 15: Get Current Page ID");
		getCurrentPageID = adminDetailBrandPage.getParentID(driver);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management - Step 16: Verify Brand Information Detail Page");
		assertEquals(adminDetailBrandPage.getSeeBrandTextButton(), GlobalConstants.getGlobalConstants().getSeeBrandButtonKR());

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 17: Open See Brand Partner Page");
		adminDetailBrandPage.clickToSeeBrandPageButton();

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 18: Switch To Advertiser Page");
		adminDetailBrandPage.switchTab(GlobalConstants.getGlobalConstants().getAdvertiserTestUrl());
		advertiserDashBoardPage = PageGeneratorManager.getAdvertiserDashBoardPage(driver);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management - Step 19: Verify Advertiser Name '" + brandName + "'");
		assertEquals(advertiserDashBoardPage.getPartnerName(), brandName);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 20: Switch To Edit Brand Page");
		advertiserDashBoardPage.switchTab(getCurrentUrl);
		adminDetailBrandPage = PageGeneratorManager.getDetailBrandPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 21: Close Advertiser Page");
		advertiserDashBoardPage.closeTab(getCurrentPageID);

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management - Step 22: Verify Change To Brand Information Successfully");
		assertEquals(adminDetailBrandPage.getSeeBrandTextButton(), GlobalConstants.getGlobalConstants().getSeeBrandButtonKR());

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 23: Click on Use Button");
		adminDetailBrandPage.clickOnButtonByName(GlobalConstants.getGlobalConstants().getUseButtonKR());

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management - Step 24: Enter Emaill Address'" + partnerEmailAddress + "'");
		adminDetailBrandPage.enterToEmailTextBox(partnerEmailAddress);

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 25: Open Setting Password");
		adminDetailBrandPage.clickToPasswordSettingButton(GlobalConstants.getGlobalConstants().getPasswordSettingKR());

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 26: Enter To Password TextBox");
		adminDetailBrandPage.enterToPasswordTextBox(GlobalConstants.getGlobalConstants().getPassword());

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 27: Enter To Confirm Password TextBox");
		adminDetailBrandPage.enterToConfirmPasswordTextBox(GlobalConstants.getGlobalConstants().getPassword());

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 25: Click On Save Button");
		adminDetailBrandPage.clickSaveButton(GlobalConstants.getGlobalConstants().getSaveButtonKR());

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management - Step 26: Verify Email Alerady Exists In System Korea Language");
		assertEquals(adminDetailBrandPage.getErrorMessageAtEmailTextBox(), "이미 사용 중 입니다.");

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 27: Change To English Language");
		adminDetailBrandPage.openSelectLanguageList(driver, GlobalConstants.getGlobalConstants().getEnglishLangguage());

		ExtentTestManager.getTest().log(Status.INFO,
				"Brand Management - Step 28: Verify Email Alerady Exists In System English Language");
		assertEquals(adminDetailBrandPage.getErrorMessageAtEmailTextBox(), "The email has already been taken.");

		ExtentTestManager.getTest().log(Status.INFO, "Brand Management - Step 29: Change To Korea Language");
		adminDetailBrandPage.openSelectLanguageList(driver, GlobalConstants.getGlobalConstants().getKoreaLanguage());

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
		adminHomePage.enterToPasswordAdvertiserTextBox(GlobalConstants.getGlobalConstants().getPassword());

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 36: Open Advertiser Page");
		advertiserDashBoardPage = adminHomePage.openAdvertiserPage("로그인");
		advertiserDashBoardPage = PageGeneratorManager.getAdvertiserDashBoardPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 37: Open Advertiser Page Successfull");
		assertTrue(advertiserDashBoardPage.isDeliveryMenuDisplayed());
	}

	@Parameters({ "browser"})
	@AfterClass(alwaysRun = true)
	public void afterClass(String browserName) {
		ExtentTestManager.getTest().log(Status.INFO, "Close broser '" + browserName + "'");
		closeBrowserAndDriver();
	}
}
