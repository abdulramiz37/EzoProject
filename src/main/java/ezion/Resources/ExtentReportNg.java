package ezion.Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNg {

	public static ExtentReports getReportObject()
	{
		String path =System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setTimelineEnabled(true);

		// Disable CDN loading
		reporter.config().setEncoding("utf-8");
		reporter.config().setOfflineMode(true);
		reporter.config().setReportName("Ezion Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		ExtentReports extent =new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester"," Abdul Ramiz" );
		return extent;
		
		
		
	}
}
