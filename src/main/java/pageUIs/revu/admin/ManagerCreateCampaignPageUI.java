package pageUIs.revu.admin;


public class ManagerCreateCampaignPageUI {
	public static final String TITLE_CAMPAIGN_REGISTER = "CSS=h2.title-page";
	public static final String TITLE_EACH_AREA_AT_CAMPAIGN_REGISTER = "xpath=//div[@class='wrap-title']/h3[contains(text(),'%s')]";
	public static final String TEMPORARY_SAVE_CREATE_BUTTON = "xpath=//span[@class='ng-scope' and contains(.,'%s')]";
	public static final String PREVIEW_BUTTON = "xpath=//button[@ng-click='preview()' and contains(text(),'%s')]";
	public static final String LABEL_AND_PLACEHOLDER = "xpath=//div/label[contains(text(),'%s')]/parent::div//input[@placeholder='%s']";
	public static final String LABEL_AND_RADIO_BUTTON = "xpath=//div/label[contains(text(),'%s')]/parent::div//div//label[contains(.,'%s')]";
	public static final String THUMBNAIL_LABLE_AND_UPLOAD_BUTTON = "xpath=//div//label[contains(text(),'%s')]/parent::div//div//button[contains(.,'%s')]";
	public static final String THUMBNAIL_LABLE_AND_CAUTION_TEXT = "xpath=//div//label[contains(text(),'%s')]/parent::div//span[contains(.,'%s')]";
	public static final String LABLE_AND_CHECKBOX = "xpath=//div//label[contains(text(),'%s')]/parent::div//span[contains(.,'%s')]";
	public static final String COLUMN_NAME_AT_BOUNDARIES_TABLE = "xpath=//table//td[contains(text(),'%s')]/following-sibling::td[contains(text(),'%s')]";
	public static final String CONTENT_AT_ROWN_NAME = "xpath=//table//td[contains(text(),'%s')]/following-sibling::td//li[contains(text(),'%s')]";
}
