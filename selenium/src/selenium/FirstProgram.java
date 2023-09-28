package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstProgram {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Bhanu Pratap\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
	}

}
