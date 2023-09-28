package e1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReport {
	ExtentReports exe;
	@BeforeTest
	public void Report() {
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation");
		reporter.config().setDocumentTitle("Practice");
		
		 exe = new ExtentReports();
		exe.attachReporter(reporter);
		exe.setSystemInfo("Tester","Bhanu");
	}
	
	
	@Test
	public void Extent() {
		exe.createTest("InitialDemo");
		
		ChromeOptions option = new ChromeOptions()	;
		option.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(option);
		driver.get("https://www.google.com/");
		driver.close();
		exe.flush();
		
	}

}
