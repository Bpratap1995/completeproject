package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Biocube {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Bhanu Pratap\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.get("https://biopasstest.com:9067");
		driver.get("https://biopasstest.com:9067/");
		driver.findElement(By.cssSelector("li.nav-item")).click();
		
		
		
		

	}

}
