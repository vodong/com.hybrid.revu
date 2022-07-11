package pageUIs.revu.admin;


public class AdminAdvertiserPageUI {
	public static final String SEARCH_FILTER_AREA = "XPATH=//div/label[text()='%s']/parent::div//input[@placeholder='%s']";
	public static final String SEARCH_FILTER_AREA_FIELD_DROPDOWN_LIST = "XPATH=//div//label[text()='%s']/parent::div//select-custome//span[contains(.,'%s')]";
//	public static final String SEARCH_FILTER_AREA_FIELD_DROPDOWN_LIST = "XPATH=//select/option[contains(text(),'%s')]/ancestor::div[@class='row']//label[text()='%s']";
	public static final String COLUMN_INDEX_BY_NAME = "XPATH=//table//tr/th[text()='%s']/preceding-sibling::th";
	public static final String COLUMN_NAME = "XPATH=//tr/th[text()='%s']";
	public static final String TEXT_BY_COLUMN_INDEX_AND_ROW_INDEX = "XPATH=//tbody/tr[%s]/td/a[contains(text(),'%s')]";
	public static final String BRAND_NAME_BY_COLUMN_INDEX_AND_ROW_INDEX = "XPATH=//tbody/tr[%s]/td[%s]";
	public static final String TEXT_BRAND_CREATED_BY_COLUMN_INDEX_AND_ROW_INDEX = "XPATH=//tbody/tr[%s]/td[contains(text(),'%s')]";
	public static final String DYNAMIC_TEXT_BUTTON = "XPATH=//button[contains(text(),'%s')]";
	public static final String CREATE_NEW_BRAND_BUTTON = "XPATH=//a[contains(text(),'%s')]";
	public static final String BRAND_TEXTBOX = "XPATH=//input[@ng-model='filter.l_name']";
	public static final String SEARCH_BUTTON = "CSS=button.btn-search";
	public static final String RESET_BUTTON = "CSS=button.btn-clear";
	public static final String DELETE_BRAND_POPUP = "CSS=div.modal-content";
	public static final String TITLE_DELETE_BRAND_POPUP = "xpath=//div[@ng-controller='AlertConfirmController']//h5";
	public static final String MESSAGE_DELETE_BRAND_POPUP = "xpath=//div[@ng-controller='AlertConfirmController']//span";
	public static final String DELETE_BUTTON_POPUP = "css=button.btn-save";
	public static final String CANCEL_BUTTON_POPUP = "css=button.btn-close";
	public static final String CLOSE_BUTTON_POPUP = "css=button.close ";
}
