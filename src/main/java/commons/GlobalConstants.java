package commons;

import java.io.File;

public class GlobalConstants {
	public static final String PORTAL_TESTING_URL = "https://tw.test.porsche.revu.net/";
	public static final String ADMIN_TESTING_URL = "https://admin.test.ent.revu.net/login?redirect=%2F";
	public static final String ADMIN_STAGING_URL = "https://admin.staging.ent.revu.net/login?redirect=%2F";
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
	
	public static final String EMAIL_MANAGER_ROLE = "kr.super.manager@revu.net";
	public static final String PASSWORD = "123456";
	public static final String INCORRECT_PASSWORD = "123456789";
	public static final String EMAIL_PARTNER_ROLE = "kr.partner1@revu.net";
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

	public static final long SHORT_TIME_OUT = 2;
	public static final long SHORT_TIME_OUT_WAIT_ELEMENT = 2;
	public static final long LONG_TIME_OUT = 30;
	public static final long RETRY_TEST__FAIL = 3;
}
