package commons;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import factoryEnvironment.BrowserStackFactory;
import factoryEnvironment.LocalFactory;

public class BaseTest {
	private WebDriver driver;
	protected final Log log;

	protected BaseTest() {
		log = LogFactory.getLog(getClass());
	}
	
	protected WebDriver getBrowserDriver(String envName, String serverName, String browserName, String osName, String osVersion) {
		switch (envName) {
		case "local":
			driver = new LocalFactory(browserName).createDriver();
			break;
//		case "Grid":
//			driver = new LocalFactory(browserName).createDriver();
//			break;
		case "BrowserStack":
			driver = new BrowserStackFactory(browserName, osName, osVersion).createDriver();
			break;
		default:
			driver = new LocalFactory(browserName).createDriver();
			break;
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(GlobalConstants_KR.LONG_TIME_OUT, TimeUnit.SECONDS);
		driver.get(getEnvironmentValue(serverName));
		return driver;
	}

	protected String getEnvironmentValue(String serverName) {
		String url = null;
		switch (serverName) {
		case "Test":
			url = GlobalConstants_KR.ADMIN_TESTING_URL;
			break;
		case "Staging":
			url = GlobalConstants_KR.ADMIN_STAGING_URL;
			break;
		case "INFLUENCERS":
			url = GlobalConstants_KR.PORTAL_TESTING_URL;
			break;
		}
		return url;
	}

	protected boolean verifyTrue(boolean condition) {
		boolean pass = true;
		try {
			if (condition) {
				log.info(" -------------------------- PASSED -------------------------- ");
			} else {
				log.info(" -------------------------- FAILED -------------------------- ");
			}
			Assert.assertTrue(condition);
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		boolean pass = true;
		try {
			if (!condition) {
				log.info(" -------------------------- PASSED -------------------------- ");
			} else {
				log.info(" -------------------------- FAILED -------------------------- ");
			}
			Assert.assertFalse(condition);
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			System.out.println(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			pass = false;
			System.out.println(" -------------------------- FAILED -------------------------- ");
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected void closeBrowserAndDriver() {
		//if(envName.equals("local") || envName.equals("Grid")) {
			String cmd = "";
			try {
				String osName = System.getProperty("os.name").toLowerCase();
				log.info("OS name = " + osName);

				String driverInstanceName = driver.toString().toLowerCase();
				log.info("Driver instance name = " + driverInstanceName);

				if (driverInstanceName.contains("chrome")) {
					if (osName.contains("window")) {
						cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
					} else {
						cmd = "pkill chromedriver";
					}
				} else if (driverInstanceName.contains("internetexplorer")) {
					if (osName.contains("window")) {
						cmd = "taskkill /F /FI \"IMAGENAME eq IEDriverServer*\"";
					}
				} else if (driverInstanceName.contains("firefox")) {
					if (osName.contains("windows")) {
						cmd = "taskkill /F /FI \"IMAGENAME eq geckodriver*\"";
					} else {
						cmd = "pkill geckodriver";
					}
				} else if (driverInstanceName.contains("edge")) {
					if (osName.contains("window")) {
						cmd = "taskkill /F /FI \"IMAGENAME eq msedgedriver*\"";
					} else {
						cmd = "pkill msedgedriver";
					}
				} else if (driverInstanceName.contains("opera")) {
					if (osName.contains("window")) {
						cmd = "taskkill /F /FI \"IMAGENAME eq operadriver*\"";
					} else {
						cmd = "pkill operadriver";
					}
				} else if (driverInstanceName.contains("safari")) {
					if (osName.contains("mac")) {
						cmd = "pkill safaridriver";
					}
				}

				if (driver != null) {
					driver.manage().deleteAllCookies();
					driver.quit();
				}
			} catch (Exception e) {
				log.info(e.getMessage());
			} finally {
				try {
					Process process = Runtime.getRuntime().exec(cmd);
					process.waitFor();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		//}
	}

	public WebDriver getDriverInstance() {
		return this.driver;
	}
	
	public int generateNumber() {
		Random number = new Random();
		return number.nextInt(9999);
	}
}
