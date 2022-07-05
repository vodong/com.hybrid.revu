package pageUIs.revu.admin;

public class BasePageUI {
	//li[@class='ng-scope' and contains(.,'%s)]
	public static final String DYNAMIC_SIDER_LINK_BY_PAGE_NAME = "XPATH=//span[@class='ng-binding' and contains(.,'%s')]";
	public static final String DYNAMIC_PARTNER_SIDER_LINK_BY_PAGE_NAME = "XPATH=//span[@class='ng-binding' and contains(.,'%s')]";
	public static final String DYNAMIC_SIDER_LINK_BY_NAME = "XPATH=//li[@class='ng-scope'  and contains(.,'%s')]";
	public static final String DYNAMIC_PARTNER_SIDER_LINK_BY_NAME = "XPATH=//li//a//span[@class='ng-binding' and contains(.,'%s')]";
	public static final String DYNAMIC_LANGUAGE_BY_NAME = "XPATH=//div[@class='navbar-top-menu']//li[@class='wrap-language']//a[contains(.,'%s')]";
	public static final String LANGUAGE_DROPDOWN_LIST = "XPATH=//div[@class='navbar-top-menu']//li[@class='wrap-language']";
	public static final String TITLE_PAGE_NAME = "CSS=span.title-page";
	public static final String UPLOAD_FILE_TYPE = "xpath=//input[@type='file']";
	public static final String EMAIL_TEXTBOX = "XPATH=//input[@ng-model='data.email']";
	public static final String EMAIL_TEXTBOX_LOGIN_PAGE = "XPATH=//input[@ng-model='login.email']";
	public static final String EMAIL_TEXTBOX_ADVERTISER_TAB = "XPATH=//input[@ng-model='advertiser.email']";
	public static final String PASSWORD_TEXTBOX = "XPATH=//input[@ng-model='data.password']";
	public static final String PASSWORD_TEXTBOX_LOGIN_PAGE = "XPATH=//input[@ng-model='login.password']";
	public static final String PASSWORD_TEXTBOX_LOGIN_ADVERTISER_TAB = "XPATH=//input[@ng-model='advertiser.password']";
	public static final String CONFIRM_PASSWORD_TEXTBOX = "XPATH=//input[@ng-model='data.password_confirmation']";
	public static final String SAVE_BUTTON_ATTRIBUTE = "XPATH=//span[(text()='%s')]/ancestor::button";
	public static final String SAVE_BUTTON_TEXT = "XPATH=//button[@type='submit']//span[@class='ng-scope']/span[text()='%s']";
	public static final String RESET_PASSWORD_BUTTON = "CSS=div.form-group-yt button.button_setting";
	public static final String DYNAMIC_RESET_PASSWORD_BUTTON = "XPATH=//div/button[contains(text(),'%s')]";
	public static final String BUTTON_NAME = "XPATH=//button[contains(text(),'%s')]";
	public static final String LOGOUT_LINK_HEADER ="XPATH=//li[@class='login']/a";
	public static final String LOGIN_LINK_HEADER = "XPATH=//a[@class='ng-binding' and @ng-click='statusFormLogin()']";
	public static final String PARTNER_ADVERTISER_TAB = "XPATH=//div[@class='row']//a[contains(text(),'%s')]";
}
