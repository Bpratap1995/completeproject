package rahulshetty;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bhanu Pratap\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("");
		Set<String> ele = driver.getWindowHandles();
		Iterator<String> it = ele.iterator();
		it.next();
		it.next();
		driver.switchTo().window(null);
		

	}

}
