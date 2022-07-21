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
import factoryEnvironment.GridFactory;
import factoryEnvironment.LocalFactory;
//import utilities.PropertiesConfig;

public class BaseTest {
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	protected final Log log;

	protected BaseTest() {
		log = LogFactory.getLog(getClass());
	}
	
	protected WebDriver getBrowserDriver(String envName, String serverName, String browserName, String osName, String osVersion, String ipAddress, String portNumber) {
		switch (envName) {
		case "local":
			driver.set(new LocalFactory(browserName).createDriver());
			break;
		case "grid":
			driver.set(new GridFactory(browserName, ipAddress, portNumber).createDriver());
			break;
		case "browserstack":
			driver.set(new BrowserStackFactory(browserName, osName, osVersion).createDriver());
			break;
		default:
			driver.set(new LocalFactory(browserName).createDriver());
			break;
		}
		
		driver.get().manage().timeouts().implicitlyWait(GlobalConstants.getGlobalConstants().getLongTimeout(), TimeUnit.SECONDS);
//		driver.get().manage().timeouts().implicitlyWait(PropertiesConfig.getFileConfigReader().getLongTimeout(), TimeUnit.SECONDS);
		driver.get().get(getEnvironmentValue(serverName));
		driver.get().manage().window().maximize();
		return driver.get();
	}

	protected String getEnvironmentValue(String serverName) {
		String url = null;
		switch (serverName) {
		case "Test":
			url = GlobalConstants.getGlobalConstants().getAdminTestingUrl();
			break;
		case "Staging":
			url = GlobalConstants.getGlobalConstants().getAdminStagingUrl();
			break;
		case "INFLUENCERS":
			url = GlobalConstants.getGlobalConstants().getTestingUrl();
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
			String cmd = "";
			try {
				String osName = System.getProperty("os.name").toLowerCase();
				log.info("OS name = " + osName);

				String driverInstanceName = driver.get().toString().toLowerCase();
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
					driver.get().manage().deleteAllCookies();
					driver.get().quit();
					
					driver.remove();
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
}

	public WebDriver getDriverInstance() {
		return driver.get();
	}
	
	public int generateNumber() {
		Random number = new Random();
		return number.nextInt(9999);
	}
}
