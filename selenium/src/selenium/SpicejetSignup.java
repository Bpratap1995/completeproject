package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;


public class SpicejetSignup {

	public static void main(String[] args) throws InterruptedException {
		//Handle browser based popup
		ChromeOptions option = new ChromeOptions();
		option.addArguments("disable-notifications");
		//set the location of chromedriver
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Bhanu Pratap\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(option);
		//windows operation
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		//url
		driver.get("https://www.spicejet.com/");
		driver.findElement(By.xpath("//div[contains(text(),'Signup')]")).click();
		
		driver.findElement(By.id("first_name")).sendKeys("Bhanu");
		
	}

}
