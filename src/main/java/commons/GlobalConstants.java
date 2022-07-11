package commons;

import java.io.File;

import lombok.Getter;

@Getter
public class GlobalConstants {
	private static GlobalConstants globalInstanceKR;

	public static synchronized GlobalConstants getGlobalConstants() {
		if (globalInstanceKR == null) {
			globalInstanceKR = new GlobalConstants();
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

	// Admin Information Korea
	private final String emailKoreaManagerRole = "kr.super.manager@revu.net";
	private final String password = "123456";
	private final String incorrectPassword = "123456789";
	private final String emailKoreaPartnerRole = "kr.partner1@revu.net";
	private final String wrongEmailFormat = "kr.com";
	
	// Admin Information Taiwan
	private final String emailTaiwanManagerRole = "tw.super.manager.select@revu.net";
	private final String emailTaiwanPartnerRole = "tw.partner.select@revu.net";

	// Brand Management Information Korea
	private final String partnerNameSearchFieldKorea = "Dong Corporation";
	private final String partnerNameAndEmailSearchFieldKorea = "Dong Corporation (partner_ED2@yopmail.com)";
	private final String fieldDropDownListValue = "FOOD";
	private final String placeholderSearchTextBoxKR = "브랜드명 검색 ";
	private final String placeholderTextBoxKR = "입력";
	private final String placeholderPhoneTextBoxKR = "숫자만 입력";
	private final String placeholderFieldDropDownListKR = "선택";
	private final String placeholderPartnerDropDownListKR = "파트너 검색";
	private final String brandNameHasCampaignManagerRoleKR = "Automation_Brand_7539";
	private final String brandNameHasCampaignPartnerRoleKR = "MATE International Marketing";
	private final String advertiserManagementLinkKR = "광고주 관리";
	private final String brandManagementLinkKR = "브랜드 관리";
	private final String titleBrandManagementPageKR = "브랜드 관리\n+ 새 브랜드 생성";
	private final String titleBrandManagementDetailPageKR = "브랜드 정보";
	private final String seeBrandButtonKR = "브랜드 화면 보기";
	private final String createANewBrandButtonKR = "+ 새 브랜드 생성";
	private final String loginButtonKR = "로그인";
	private final String useButtonKR = "설정함";
	private final String useButtonEN = "Use";
	private final String nonUseButtonKR = "설정안함";
	private final String nonUseButtonEN = "Nonuse";
	private final String saveButtonKR = "저장하기";
	private final String passwordSettingKR = "직접 설정";	
	private final String cancelSettingKR = "설정 취소";
	private final String deleteButtonKR = "삭제하기";
	private final String searchButtonAtSearchFilterKR = "검색";
	private final String resetButtonAtSearchFilterKR = "초기화";

	// Brand Management Information Taiwan
	private final String partnerNameSearchFieldTaiwan = "Edward_POE_Company";
	private final String partnerNameAndEmailSearchFieldTaiwan = "Edward_POE_Company (phamvodong8@gmail.com)";
	private final String placeholderSearchTextBoxTW = "搜尋品牌";
	private final String placeholderTextBoxTW = "輸入";
	private final String placeholderPhoneTextBoxTW = "僅能輸入數字";
	private final String loginButtonTW = "登入";
	private final String placeholderPartnerDropDownListTW = "合作夥伴搜尋";
	private final String brandNameHasCampaignManagerRoleTW = "Test Branch tw 12";
	private final String brandNameHasCampaignPartnerRoleTW = "Company test";
	private final String advertiserManagementLinkTW = "廣告商管理";
	private final String brandManagementLinkTW = "品牌管理";
	private final String titleBrandManagementDetailPageTW = "品牌資訊";
	private final String titleBrandManagementPageTW = "品牌管理\n+ 新建一個新品牌";
	private final String createANewBrandButtonTW = "+ 新建一個新品牌";
	private final String seeBrandButtonTW = "查看品牌頁面";
	private final String useButtonTW = "使用";
	private final String nonUseButtonTW = "不使用";
	private final String saveButtonTW = "儲存";
	private final String passwordSettingTW = "密碼設定";
	private final String resetPasswordButtonTW = "取消";
	private final String cancelSettingTW = "取消";
	private final String deleteButtonOnPopupTW = "刪除";
	private final String confirmButtonOnPopupTW = "確認";
	private final String deleteButtonAtRowTW = "刪除品牌";
	
	// Brand Management Information English
	private final String placeholderTextBoxEN = "Input";
	private final String placeholderPhoneTextBoxEN = "Number Only";
	private final String placeholderSearchTextBoxEN = "Brand Search";
	private final String placeholderFieldDropDownListEN = "Select";
	private final String placeholderPartnerDropDownListEN = "Partner search";
	private final String titleBrandManagementPageEN = "Brand Management\n+ Create a new brand";
	private final String titleBrandManagementDetailPageEN = "Brand Information";
	private final String saveButtonEN = "Save";
	private final String passwordSettingEN = "Password setting";
	private final String cancelSettingEN = "Cancel setting";
	private final String searchButtonAtSearchFilterEN = "Search";
	private final String resetButtonAtSearchFilterEN = "Reset";
	
	//Language
	private final String koreaLanguage = "한국어";
	private final String taiwanLanguage = "繁體中文";
	private final String englishLangguage = "English";

	// Browser Stack
	private final String browserUserName = "vodongpham_vbRLlM";
	private final String browserAutomateKey = "idztyWmBznShx8tLvKAe";
	private final String browserStackUrl = "https://" + browserUserName + ":" + browserAutomateKey
			+ "@hub-cloud.browserstack.com/wd/hub";
}
