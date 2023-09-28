package rahulshetty;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calender {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Bhanu Pratap\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
        driver.get("https://www.rahulshettyacademy.com/dropdownsPractise/");
       // driver.findElement(By.id("ctl00$mainContent$view_date1")).click();
        driver.findElement(By.className("ui-state-default ui-state-highlight")).click();
        
	}

}
