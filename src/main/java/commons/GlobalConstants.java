package commons;

import java.io.File;

public class GlobalConstants {
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String JAVA_VERSION = System.getProperty("java.version");
	public static final String OS_NAME = System.getProperty("os.name");
	public static final String UPLOAD_FILE = PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
	public static final String TEST_DATA = PROJECT_PATH + File.separator + "testdata" + File.separator;
	public static final String DOWNLOAD_FILE = PROJECT_PATH + File.separator + "downloadFiles";
	public static final String BROWSER_LOG = PROJECT_PATH + File.separator + "browserLogs";
	public static final String DRAG_DROP_HTML5 = PROJECT_PATH + File.separator + "dragDropHTML5";
	public static final String AUTO_IT_SCRIPT = PROJECT_PATH + File.separator + "autoIT";
	public static final String REPORTNG_SCREENSHOT = PROJECT_PATH + File.separator + "reportNGImages" + File.separator;
	public static final long SHORT_TIME_OUT = 2;
	public static final long SHORT_TIME_OUT_WAIT_ELEMENT = 2;
	public static final long LONG_TIME_OUT = 30;
	public static final long RETRY_TEST__FAIL = 3;
	
	// Definition URL
	public static final String PORTAL_TESTING_URL = "https://tw.test.porsche.revu.net/";
	public static final String ADMIN_TESTING_URL = "https://admin.test.ent.revu.net/";
	public static final String ADMIN_STAGING_URL = "https://admin.staging.ent.revu.net";
	public static final String ADVERTISER_TEST_URL = "partner";
	
	// Admin Information
	public static final String EMAIL_MANAGER_ROLE = "kr.super.manager@revu.net";
	public static final String PASSWORD = "123456";
	public static final String INCORRECT_PASSWORD = "123456789";
	public static final String EMAIL_PARTNER_ROLE = "kr.partner1@revu.net";
	
	// Brand Management Information
	public static final String PARTNER_NAME_SEARCH_FIELD = "Dong Corporation";
	public static final String PARTNER_NAME_AND_EMAIL_SEARCH_FIELD = "Dong Corporation (partner_ED2@yopmail.com)";
	public static final String FIELD_DROPDOWN_LIST = "FOOD";
	public static final String PLACE_HOLDER_TEXTBOX_KR = "입력";
	public static final String PLACE_HOLDER_TEXTBOX_EN = "Input";
	public static final String PLACE_HOLDER_PHONE_TEXTBOX_EN = "Number Only";
	public static final String PLACE_HOLDER_PHONE_TEXTBOX_KR = "숫자만 입력";
	public static final String PLACE_HOLDER_FIELD_DROPDOWN_LIST_KR = "선택";
	public static final String PLACE_HOLDER_FIELD_DROPDOWN_LIST_EN = "Select";
	public static final String PLACE_HOLDER_PARTNER_DROPDOWN_LIST_KR = "파트너 검색";
	public static final String PLACE_HOLDER_PARTNER_DROPDOWN_LIST_EN = "Partner search";
	public static final String BRAND_NAME_HAS_CAMPAIGN = "Automation_Brand_7539";
	public static final String KOREA_LANGUAGE = "한국어";
	public static final String ENGLISH_LANGUAGE = "English";
	public static final String ADVERTISER_MANAGEMENT_LINK = "광고주 관리";
	public static final String BRAND_MANAGEMENT_LINK = "브랜드 관리";
	public static final String TITLE_BRAND_MANGEMENT_PAGE = "브랜드 화면 보기";
	public static final String CREATE_A_NEW_BRAND_BUTTON = "+ 새 브랜드 생성";
	public static final String USE_BUTTON_KR = "설정함";
	public static final String USE_BUTTON_EN = "Use";
	public static final String NON_USE_BUTTON_KR = "설정안함";
	public static final String NON_USE_BUTTON_EN = "Nonuse";
	public static final String SAVE_BUTTON_KR = "저장하기";
	public static final String SAVE_BUTTON_EN = "Save";
	public static final String PASSWORD_SETTING_KR = "직접 설정";
	public static final String PASSWORD_SETTING_EN = "Password setting";
	public static final String RESET_PASSWORD_BUTTON_EN = "Password setting";
	public static final String RESET_PASSWORD_BUTTON_KR = "직접 설정";
	public static final String CANCEL_SETTING_EN = "Cancel setting";
	public static final String CANCEL_SETTING_KR = "설정 취소";
	public static final String DELETE_BUTTON = "삭제하기";
	
	//Browser Stack
	public static final String BROWSE_USERNAME = "vodongpham_vbRLlM";
	public static final String BROWSE_AUTOMATE_KEY = "idztyWmBznShx8tLvKAe";
	public static final String BROWSE_STACK_URL = "https://" + BROWSE_USERNAME + ":" + BROWSE_AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
}
