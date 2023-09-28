 package trun_testcomponents;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import trun.LoginPage;



public class BaseTest {
	public WebDriver driver;
	public LoginPage lp;
	DataFormatter formatter = new DataFormatter();
	
	public WebDriver initializeDriver() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\GlobalData.properties");
		prop.load(fis);
		String browserName=	System.getProperty("browser")!=null ? System.getProperty("browser"): prop.getProperty("browser");
		//String browserName = prop.getProperty("browser");
		
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		
		if(browserName.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver(co);
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
		//firefox
		}
		else if (browserName.equalsIgnoreCase("Edge")) {
			//edge
		}
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		return driver;
		
	}
	public List<HashMap<String, String>> getJsonDataToMap(String Filepath) throws IOException {

		String JsonContent = FileUtils.readFileToString(new File(Filepath)
				,"UTF-8");

		ObjectMapper mapper = new ObjectMapper();

		List<HashMap<String, String>> data = mapper.readValue(JsonContent,
				new TypeReference<List<HashMap<String, String>>>() {});

		return data;
	}
	public String getScreenshot(String testcaseName,WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
	
		File dest=new File(System.getProperty("user.dir")+"//reports//"+ testcaseName +".png");
		FileUtils.copyFile(source, dest);
		return System.getProperty("user.dir")+"//reports//"+ testcaseName +".png";
		
	}

	
	@BeforeMethod(alwaysRun=true)
	public LoginPage LaunchApplication() throws IOException {
		
		driver = initializeDriver();
		
		 lp = new LoginPage(driver);
		lp.goTo();
		return lp;
	}
	@AfterMethod(alwaysRun=true)
	public void DriverClose() throws InterruptedException {
		
		driver.close();
	}
	
	@DataProvider(name="drivenTest")
	public Object[][] getData() throws IOException {
		File file = new File("C:\\Users\\Bhanu Pratap\\Downloads\\TruN.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Trun");
		int rowCount = sheet.getPhysicalNumberOfRows();
		XSSFRow row = sheet.getRow(0);
	    int colCount = row.getLastCellNum();
	    Object [][] data = new Object[rowCount-1][colCount];
	    for(int i=0;i<rowCount-1;i++) {
	    	row=sheet.getRow(i+1);
	    	for(int j=0;j<colCount;j++) {
	    		XSSFCell cell = row.getCell(j);
	    		data[i][j]=formatter.formatCellValue(cell);
	    		
	    		
	    	}
	    }
	    return data;
		
	}
	public void writeData() {
		
	}
	
	

}
