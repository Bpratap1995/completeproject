package rahulshetty;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Mouseover {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Bhanu Pratap\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		//url 
		driver.get("https://www.amazon.com/");
		WebElement ele = driver.findElement(By.cssSelector("span[class='nav-line-2 ']"));
		WebElement ele1 = driver.findElement(By.id("twotabsearchtextbox"));
		
		//Actions Class
		Actions action = new Actions(driver);
		//WebElement ele = driver.findElement(By.cssSelector("span[class='nav-line-2 ']"));
		action.moveToElement(ele).build().perform();
		action.moveToElement(ele1).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		action.moveToElement(ele).contextClick().build().perform();

	}

}
