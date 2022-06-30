package pageUIs.revu.admin;


public class AdminHomePageUI {
	public static final String LOGIN_LINK_HEADER = "XPATH=//a[@class='ng-binding' and @ng-click='statusFormLogin()']";
	public static final String LOGIN_LINK = "XPATH=//div[@id='navbar']//a[@ng-click='statusFormLogin()']";
	public static final String COUNTRY_DROPDOWN_LIST = "CSS=form.ng-valid ul.mr-20";
	public static final String COUNTRY_DROPDOWN_LIST_POPUP = "XPATH=//form[@name='partnerForm']//ul[@class='dropdown-menu']//a[contains(.,'%s')]";
	public static final String EMAIL_TEXTBOX = "XPATH=//input[@ng-model='login.email']";
	public static final String PASSWORD_TEXTBOX = "XPATH=//input[@ng-model='login.password']";
	public static final String LOGIN_BUTTON_PARTNER_MANAGER_ROLE = "XPATH=//form[@ng-submit='submit()']//span[@class='ng-scope' and contains(.,'%s')]";
	public static final String LOGIN_BUTTON_ADVERTISER = "XPATH=//form[@name='advertiserForm']//button//span[@class='ng-scope']/span[contains(text(),'%s')]";
}
