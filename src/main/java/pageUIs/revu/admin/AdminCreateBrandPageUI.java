package pageUIs.revu.admin;


public class AdminCreateBrandPageUI {
	public static final String TITLE_COMPANY_INFORMATION_NAME = "CSS=div.pb-5 div.wrap-title h3";
	public static final String TITLE_ACCOUNT_INFORMATION_NAME = "CSS=div.section-account-info div.wrap-title h3";
	public static final String TITLE_AREA_NAME = "XPATH=//h3[text()='%s']";
	public static final String PLACE_HOLDER_BY_LABEL_NAME = "XPATH=//div//label[text()='%s']/parent::div//input[@placeholder='%s']";
	public static final String BUTTON_NAME = "XPATH=//button[contains(text(),'%s')]";
	public static final String PLACE_HOLDER_BY_DROPDOWN_LIST_NAME = "XPATH=//div//label[text()='%s']/parent::div//select-custome[contains(.,'%s')]";
	public static final String FIELD_DROPDOWN_LIST = "CSS=div.form-group-yt  select-custome.ng-pristine div.select-btn";
	public static final String FIELD_DROPDOWN_LIST_OPTION = "CSS=ul.ng-scope li.ng-scope span.ng-binding";
	public static final String ACCOUNT_SETTING_LABEL = "XPATH=//div[@class='wrap-form-group']//label[text()='%s']";
	public static final String DYNAMIC_LABEL_NAME = "XPATH=//div[@class='form-group']/label[text()='%s']";
	public static final String RESET_PASSWORD_BUTTON = "CSS=div.form-group-yt button.button_setting";
	public static final String DYNAMIC_RESET_PASSWORD_BUTTON = "XPATH=//div/button[contains(text(),'%s')]";
	public static final String EMAIL_TEXTBOX = "XPATH=//input[@ng-model='data.email']";
	public static final String PASSWORD_TEXTBOX = "XPATH=//input[@ng-model='data.password']";
	public static final String CONFIRM_PASSWORD_TEXTBOX = "XPATH=//input[@ng-model='data.password_confirmation']";
	public static final String SAVE_BUTTON_ATTRIBUTE = "XPATH=//span[(text()='%s')]/ancestor::button";
	public static final String SAVE_BUTTON_TEXT = "XPATH=//button[@type='submit']//span[@class='ng-scope']/span[text()='%s']";
	public static final String ERROR_MESSAGE_AT_BRAND_NAME = "XPATH=//error-message[@ng-model='errorMessage.name']//span";
	public static final String ERROR_MESSAGE_AT_FIELD_DROPDOWN_LIST = "XPATH=//error-message[@ng-model='errorMessage.advertiser_field_id']//span";
	public static final String ERROR_MESSAGE_AT_PARTNER_DROPDOWN_LIST = "XPATH=//error-message[@ng-model='errorMessage.partner_id']//span";
	public static final String ERROR_MESSAGE_AT_EMAIl_TEXTBOX = "XPATH=//error-message[@ng-model='errorMessage.email']//span";
	public static final String ERROR_MESSAGE_AT_CONFIRM_PASSWORD_TEXTBOX = "XPATH=//error-message[@ng-model='errorMessage.password']//span";
	public static final String AVATAR_UPLOADED = "CSS=div.info-reviewer-img img.avatar";
	public static final String BRAND_NAME_TEXTBOX = "XPATH=//input[@ng-model='data.name']";
	public static final String PARTNER_TEXTBOX = "CSS=div.typeahead input.input-sm";
	public static final String PARTNER_DROPDOWN_LIST = "CSS=ul.ng-isolate-scope li.ng-scope a.ng-binding";
	public static final String REPRESENTATIVE_TEXTBOX = "XPATH=//input[@ng-model='data.representative']";
}
