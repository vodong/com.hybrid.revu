package commons;

import java.io.File;

import lombok.Getter;

@Getter
public class GlobalConstants {
	private static GlobalConstants globalInstance;

	public static synchronized GlobalConstants getGlobalConstants() {
		if (globalInstance == null) {
			globalInstance = new GlobalConstants();
		}
		return globalInstance;
	}

	private final String projectPath = System.getProperty("user.dir");
	private final String javaVersion = System.getProperty("java.version");
	private final String osName = System.getProperty("os.name");
	private final String uploadFile = projectPath + File.separator + "uploadFiles" + File.separator;
	private final String testData = projectPath + File.separator + "testdata" + File.separator;
	private final String downloadFile = projectPath + File.separator + "downloadFiles";
	private final String browserLog = projectPath + File.separator + "browserLogs" + File.separator;
	private final String dragDropHTML5 = projectPath + File.separator + "dragDropHTML5";
	private final String autoITScritp = projectPath + File.separator + "autoIT";
	private final String reportingScreenshot = projectPath + File.separator + "reportNGImages" + File.separator;
	private final long shortTimeout = 2;
	private final long shortTimeoutWaiElement = 2;
	private final long longTimeout = 30;
	private final long retryTestFail = 3;

	// Definition URL
	private final String testingUrl = "https://tw.test.porsche.revu.net/";
	private final String adminTestingUrl = "https://admin.test.ent.revu.net/";
	private final String adminStagingUrl = "https://admin.staging.ent.revu.net";
	private final String advertiserTestUrl = "partner";
	
	// Admin Home Page
	private final String loginButtonKR = "로그인";

	// Admin Information Korea
	private final String emailKoreaManagerRole = "kr.super.manager@revu.net";
	private final String password = "123456";
	private final String incorrectPassword = "123456789";
	private final String emailKoreaPartnerRole = "kr.partner1@revu.net";
	private final String wrongEmailFormat = "kr.com";
	
	// Admin Information Taiwan
	private final String emailTaiwanManagerRole = "tw.super.manager.select@revu.net";
	private final String emailTaiwanPartnerRole = "tw.partner.select@revu.net";
	
	//Language
	private final String koreaLanguage = "한국어";
	private final String taiwanLanguage = "繁體中文";
	private final String englishLangguage = "English";
	
	//Country Name
	private final String koreaCountry = "Korea";
	private final String taiwanCountry = "Taiwan";

	// Browser Stack
	private final String browserUserName = "vodongpham_vbRLlM";
	private final String browserAutomateKey = "idztyWmBznShx8tLvKAe";
	private final String browserStackUrl = "https://" + browserUserName + ":" + browserAutomateKey
			+ "@hub-cloud.browserstack.com/wd/hub";
}
