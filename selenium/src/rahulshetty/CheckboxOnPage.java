package rahulshetty;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckboxOnPage {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bhanu Pratap\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		driver.get("https://www.rahulshettyacademy.com/dropdownsPractise/");
		List<WebElement> ele = driver.findElements(By.xpath("//input[@type='checkbox']"));
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_friendsandfamily']")).click();
		boolean ele2 = driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_friendsandfamily']")).isSelected();
		System.out.println(ele2);
        int size = ele.size();
        System.out.println(size);
		for(WebElement ele1 :ele) {
	 ele1.click();
  }
	}

}
