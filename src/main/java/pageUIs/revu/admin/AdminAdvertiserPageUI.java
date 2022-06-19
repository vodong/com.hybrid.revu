package pageUIs.revu.admin;


public class AdminAdvertiserPageUI {
	public static final String SEARCH_FILTER_AREA = "XPATH=//div/label[text()='%s']/parent::div//input[@placeholder='%s']";
	public static final String SEARCH_FILTER_AREA_FIELD_DROPDOWN_LIST = "XPATH=//select/option[contains(text(),'%s')]/ancestor::div[@class='row']//label[text()='%s']";
	public static final String COLUMN_INDEX_BY_NAME = "XPATH=//table//tr/th[text()='%s']/preceding-sibling::th";
	public static final String COLUMN_NAME = "XPATH=//tr/th[text()='%s']";
	public static final String TEXT_BY_COLUMN_INDEX_AND_ROW_INDEX = "XPATH=//tbody/tr[%s]/td/a[contains(text(),'%s')]";
	public static final String TEXT_BRAND_CREATED_BY_COLUMN_INDEX_AND_ROW_INDEX = "XPATH=//tbody/tr[%s]/td[contains(text(),'%s')]";
	public static final String DYNAMIC_TEXT_BUTTON = "XPATH=//button[contains(text(),'%s')]";
	public static final String CREATE_NEW_BRAND_BUTTON = "XPATH=//a[contains(text(),'%s')]";
}
