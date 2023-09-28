package rahulshetty;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropdown {

	public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bhanu Pratap\\Downloads\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
	driver.get("https://www.rahulshettyacademy.com/dropdownsPractise/");
	WebElement ele = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
	Select sel = new Select(ele);
	
	sel.selectByIndex(2);
	System.out.println(sel.getFirstSelectedOption().getText());
	sel.selectByVisibleText("INR");
	System.out.println(sel.getFirstSelectedOption().getText());
	sel.selectByValue("USD");
	System.out.println(sel.getFirstSelectedOption().getText());
	driver.close();
	}

}
