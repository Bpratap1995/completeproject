package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNg {
	
	public static ExtentReports getReportObject() {
		String path=System.getProperty("user.dir")+"\\reports\\truNtrance1.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("AttendFy");
		reporter.config().setDocumentTitle("TruNtrance");
		
		ExtentReports exe = new ExtentReports();
		exe.attachReporter(reporter);
		return exe;
	}

}
