package commons;

import java.io.File;

public class GlobalConstants_TW {
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
	public static final String EMAIL_MANAGER_ROLE = "tw.super.manager.select@revu.net";
	public static final String PASSWORD = "123456";
	public static final String INCORRECT_PASSWORD = "123456789";
	public static final String EMAIL_PARTNER_ROLE = "tw.partner.select@revu.net";
	public static final String WRONG_EMAIL_FORMAT = "tw.com";
	
	// Brand Management Information
	public static final String PARTNER_NAME_SEARCH_FIELD = "Edward_POE_Company";
	public static final String PARTNER_NAME_AND_EMAIL_SEARCH_FIELD = "Edward_POE_Company (phamvodong8@gmail.com)";
	public static final String FIELD_DROPDOWN_LIST = "FOOD";
	public static final String PLACE_HOLDER_SEARCH_TEXTBOX_KR = "브랜드명 검색 ";
	public static final String PLACE_HOLDER_SEARCH_TEXTBOX_EN = "Brand Search";
	public static final String PLACE_HOLDER_TEXTBOX_TW = "輸入";
	public static final String PLACE_HOLDER_TEXTBOX_EN = "Input";
	public static final String PLACE_HOLDER_PHONE_TEXTBOX_EN = "Number Only";
	public static final String PLACE_HOLDER_PHONE_TEXTBOX_TW = "僅能輸入數字";
//	public static final String PLACE_HOLDER_FIELD_DROPDOWN_LIST_TW = "선택";
//	public static final String PLACE_HOLDER_FIELD_DROPDOWN_LIST_EN = "Select";
	public static final String PLACE_HOLDER_PARTNER_DROPDOWN_LIST_TW = "合作夥伴搜尋";
	public static final String PLACE_HOLDER_PARTNER_DROPDOWN_LIST_EN = "Partner search";
	public static final String BRAND_NAME_HAS_CAMPAIGN_MANAGER_ROLE_TW = "Test Branch tw 12";
	public static final String BRAND_NAME_HAS_CAMPAIGN_PARTNER_ROLE_KR = "MATE International Marketing";
	public static final String TAIWAN_LANGUAGE = "繁體中文";
	public static final String ENGLISH_LANGUAGE = "English";
	public static final String ADVERTISER_MANAGEMENT_LINK = "廣告商管理";
	public static final String BRAND_MANAGEMENT_LINK = "品牌管理";
	public static final String TITLE_BRAND_MANGEMENT_DETAIL_PAGE = "品牌資訊";
	public static final String CREATE_A_NEW_BRAND_BUTTON = "+ 新建一個新品牌";
	public static final String SEE_BRAND_BUTTON = "查看品牌頁面";
	public static final String USE_BUTTON_TW = "使用";
	public static final String USE_BUTTON_EN = "Use";
	public static final String NON_USE_BUTTON_TW = "不使用";
	public static final String NON_USE_BUTTON_EN = "Nonuse";
	public static final String SAVE_BUTTON_TW = "儲存";
	public static final String SAVE_BUTTON_EN = "Save";
	public static final String PASSWORD_SETTING_TW = "密碼設定";
	public static final String PASSWORD_SETTING_EN = "Password setting";
	public static final String RESET_PASSWORD_BUTTON_EN = "Password setting";
	public static final String RESET_PASSWORD_BUTTON_TW = "取消";
	public static final String CANCEL_SETTING_EN = "Cancel setting";
	public static final String CANCEL_SETTING_TW = "取消";
	public static final String DELETE_BUTTON = "刪除";
	
	//Browser Stack
	public static final String BROWSE_USERNAME = "vodongpham_vbRLlM";
	public static final String BROWSE_AUTOMATE_KEY = "idztyWmBznShx8tLvKAe";
	public static final String BROWSE_STACK_URL = "https://" + BROWSE_USERNAME + ":" + BROWSE_AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
}
