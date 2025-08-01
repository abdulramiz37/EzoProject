package ezion.Resources;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNg {

	public static ExtentReports getReportObject()
	{
        String reportsDir = System.getProperty("user.dir") + File.separator + "reports";
        File reportDir = new File(reportsDir);
        
        // Create the reports folder if it doesn't exist
        if (!reportDir.exists()) {
            reportDir.mkdirs();
            System.out.println("Created reports directory at: " + reportsDir);
        }

        String path = reportsDir + File.separator + "index.html";
        System.out.println("Writing report to: " + path);
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
