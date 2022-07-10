package commons;

import java.io.File;

import lombok.Getter;

@Getter
public class GlobalConstants_KR {
	private static GlobalConstants_KR globalInstanceKR;
	
	public static synchronized GlobalConstants_KR getGlobalConstants() {
		if(globalInstanceKR == null) {
			globalInstanceKR = new GlobalConstants_KR();
		}
		return globalInstanceKR;
	}
	
	private final String projectPath = System.getProperty("user.dir");
	private final String javaVersion = System.getProperty("java.version");
	private final String osName = System.getProperty("os.name");
	private final String uploadFile = projectPath + File.separator + "uploadFiles" + File.separator;
	private final String testData = projectPath + File.separator + "testdata" + File.separator;
	private final String downloadFile = projectPath + File.separator + "downloadFiles";
	private final String browserLog = projectPath + File.separator + "browserLogs";
	private final String dragDropHTML5 = projectPath + File.separator + "dragDropHTML5";
	private final String autoITScritp = projectPath + File.separator + "autoIT";
	private final String reportingScreenshot = projectPath + File.separator + "reportNGImages" + File.separator;
	private final long shortTimeout = 2;
	private final long shortTimeoutWaiElement = 2;
	private final long longTimeout = 30;
	private final long retryTestFail = 3;
	
	// Definition URL
	private final String testingUrl = "https://tw.test.porsche.revu.net/";
	private final String adminTestingUrl = "https://admin.test.ent.revu.net/";
	private final String adminStagingUrl = "https://admin.staging.ent.revu.net";
	private final String advertiserTestUrl = "partner";
	
	// Admin Information
	private final String emailManagerRole = "kr.super.manager@revu.net";
	private final String password = "123456";
	private final String incorrectPassword = "123456789";
	private final String emailPartnerRole = "kr.partner1@revu.net";
	private final String wrongEmailFormat = "kr.com";
	
	// Brand Management Information
	private final String partnerNameSearchField = "Dong Corporation";
	private final String partnerNameAndEmailSearchField = "Dong Corporation (partner_ED2@yopmail.com)";
	private final String fieldDropDownListValue = "FOOD";
	private final String placeholderSearchTextBoxKR = "브랜드명 검색 ";
	private final String placeholderSearchTextBoxEN = "Brand Search";
	private final String placeholderTextBoxKR = "입력";
	private final String placeholderTextBoxEN = "Input";
	private final String placeholderPhoneTextBoxEN = "Number Only";
	private final String placeholderPhoneTextBoxKR = "숫자만 입력";
	private final String placeholderFieldDropDownListKR = "선택";
	private final String placeholderFieldDropDownListEN = "Select";
	private final String placeholderPartnerDropDownListKR = "파트너 검색";
	private final String placeholderPartnerDropDownListEN = "Partner search";
	private final String brandNameHasCampaignManagerRoleKR = "Automation_Brand_7539";
	private final String brandNameHasCampaignPartnerRoleKR = "MATE International Marketing";
	private final String koreaLanguage = "한국어";
	private final String englishLangguage = "English";
	private final String advertiserManagementLink = "광고주 관리";
	private final String brandManagementLink = "브랜드 관리";
	private final String titleBrandManagementPage = "브랜드 화면 보기";
	private final String createANewBrandButton = "+ 새 브랜드 생성";
	private final String useButtonKR = "설정함";
	private final String useButtonEN = "Use";
	private final String nonUseButtonKR = "설정안함";
	private final String nonUseButtonEN = "Nonuse";
	private final String saveButtonKR = "저장하기";
	private final String saveButtonEN = "Save";
	private final String passwordSettingKR = "직접 설정";
	private final String passwordSettingEN = "Password setting";
	private final String resetPasswordButtonEN = "Password setting";
	private final String resetPasswordButtonKR = "직접 설정";
	private final String cancelSettingEN = "Cancel setting";
	private final String cancelSettingKR = "설정 취소";
	private final String deleteButtonKR = "삭제하기";
	
	//Browser Stack
	private final String browserUserName = "vodongpham_vbRLlM";
	private final String browserAutomateKey = "idztyWmBznShx8tLvKAe";
	private final String browserStackUrl = "https://" + browserUserName + ":" + browserAutomateKey + "@hub-cloud.browserstack.com/wd/hub";
}
