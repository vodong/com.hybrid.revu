package pageUIs.revu.admin;

public class BasePageUI {
	public static final String DYNAMIC_SIDER_LINK_BY_PAGE_NAME = "XPATH=//span[@class='ng-binding' and contains(.,'%s')]";
	public static final String DYNAMIC_SIDER_LINK_BY_NAME = "XPATH=//li[@class='ng-scope'  and contains(.,'%s')]";
	public static final String DYNAMIC_LANGUAGE_BY_NAME = "XPATH=//div[@class='navbar-top-menu']//li[@class='wrap-language']//a[contains(.,'%s')]";
	public static final String LANGUAGE_DROPDOWN_LIST = "XPATH=//div[@class='navbar-top-menu']//li[@class='wrap-language']";
	public static final String TITLE_PAGE_NAME = "CSS=span.title-page";
	public static final String UPLOAD_FILE_TYPE = "xpath=//input[@type='file']";
}
