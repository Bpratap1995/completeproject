package trun_testcomponents;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.datadriven.test.Xls_Reader;

import resources.ExtentReporterNg;

public class Listeners extends BaseTest implements ITestListener {

	Xls_Reader reader = new Xls_Reader("C:\\Users\\Bhanu Pratap\\Downloads\\AttendFyData.xlsx");
	int rowNum;
	String popupText;

	ExtentTest Test;
	ExtentReports extent = ExtentReporterNg.getReportObject();
	ThreadLocal<ExtentTest> tl = new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {
		Test = extent.createTest(result.getMethod().getMethodName());
		extent.setSystemInfo("Tester", "Bhanu");
		tl.set(Test);

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		tl.get().log(Status.PASS, "Test is pass");

		reader.addColumn("AttendFy", "output");
		popupText = extractPopupText();
		writePopupTextToExcel(popupText);

	}

	private String extractPopupText() {
		WebElement p = driver
				.findElement(By.xpath("//span[@class='text-danger text-error database_error input-group']"));
		return p.getText();
	}

	private void writePopupTextToExcel(String popupText) {

		reader.setCellData("AttendFy", "output", rowNum, popupText);
		rowNum++;

	}

	@Override
	public void onTestFailure(ITestResult result) {
		tl.get().log(Status.FAIL, "Test is Fail");
		tl.get().fail(result.getThrowable());
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {

			e.printStackTrace();
		}

		String filepath = null;
		try {
			filepath = getScreenshot(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		tl.get().addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void onFinish(ITestContext context) {

		extent.flush();
	}

}
