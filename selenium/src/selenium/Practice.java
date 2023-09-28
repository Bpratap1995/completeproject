package selenium;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Practice {

	public static void main(String[] args) throws InterruptedException {
		//
		ChromeOptions option = new ChromeOptions();
		option.addArguments("disable-notifications");
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bhanu Pratap\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://www.spicejet.com/");
		driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-1loqt21 r-18u37iz r-1otgn73']")).click();
		driver.findElement(By.xpath("//input[@type='number']")).sendKeys("8319366872");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("biocube@123");
        
	}

}
