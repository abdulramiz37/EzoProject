package ezion.Resources;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNg {

	public static ExtentReports getReportObject()
	{
	    String path = System.getProperty("user.dir") + File.separator + "reports" + File.separator + "index.html";

		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setTimelineEnabled(true);

		// Disable CDN loading
		reporter.config().setEncoding("utf-8");
		reporter.config().setOfflineMode(true);
		reporter.config().setReportName("Ezion Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		reporter.config().setTimeStampFormat("dd/MM/yyyy HH:mm:ss"); // ✅ Fix time 

		
		ExtentReports extent =new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester"," Abdul Ramiz" );
		return extent;
		
		
		
	}
}
