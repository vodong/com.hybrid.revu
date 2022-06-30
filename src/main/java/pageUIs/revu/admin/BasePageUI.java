package pageUIs.revu.admin;

public class BasePageUI {
	public static final String DYNAMIC_SIDER_LINK_BY_PAGE_NAME = "XPATH=//span[@class='ng-binding' and contains(.,'%s')]";
	public static final String DYNAMIC_SIDER_LINK_BY_NAME = "XPATH=//li[@class='ng-scope'  and contains(.,'%s')]";
	public static final String DYNAMIC_LANGUAGE_BY_NAME = "XPATH=//div[@class='navbar-top-menu']//li[@class='wrap-language']//a[contains(.,'%s')]";
	public static final String LANGUAGE_DROPDOWN_LIST = "XPATH=//div[@class='navbar-top-menu']//li[@class='wrap-language']";
	public static final String TITLE_PAGE_NAME = "CSS=span.title-page";
	public static final String UPLOAD_FILE_TYPE = "xpath=//input[@type='file']";
	public static final String EMAIL_TEXTBOX = "XPATH=//input[@ng-model='data.email']";
	public static final String PASSWORD_TEXTBOX = "XPATH=//input[@ng-model='data.password']";
	public static final String CONFIRM_PASSWORD_TEXTBOX = "XPATH=//input[@ng-model='data.password_confirmation']";
	public static final String SAVE_BUTTON_ATTRIBUTE = "XPATH=//span[(text()='%s')]/ancestor::button";
	public static final String SAVE_BUTTON_TEXT = "XPATH=//button[@type='submit']//span[@class='ng-scope']/span[text()='%s']";
	public static final String RESET_PASSWORD_BUTTON = "CSS=div.form-group-yt button.button_setting";
	public static final String DYNAMIC_RESET_PASSWORD_BUTTON = "XPATH=//div/button[contains(text(),'%s')]";
	public static final String BUTTON_NAME = "XPATH=//button[contains(text(),'%s')]";
}
