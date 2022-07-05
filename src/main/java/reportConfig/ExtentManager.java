package reportConfig;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import commons.GlobalConstants_KR;

public class ExtentManager {
	public static final ExtentReports extentReports = new ExtentReports();

	public synchronized static ExtentReports createExtentReports() {
		ExtentSparkReporter reporter = new ExtentSparkReporter(GlobalConstants_KR.PROJECT_PATH + "/extentV5/ExtentReport.html");
		reporter.config().setReportName("Revu HTML Report");
		reporter.config().setDocumentTitle("Revu HTML Report");
		reporter.config().setTimelineEnabled(true);
		reporter.config().setEncoding("utf-8");
		reporter.config().setTheme(Theme.DARK);

		extentReports.attachReporter(reporter);
		extentReports.setSystemInfo("Revu Company", "Automation FC");
		extentReports.setSystemInfo("Project", "Revu");
		extentReports.setSystemInfo("Team", "Pham Vo Dong - Edward");
		extentReports.setSystemInfo("JDK version", GlobalConstants_KR.JAVA_VERSION);
		return extentReports;
	}
}