package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class vivi {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Bhanu Pratap\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://biocube.storehippo.com/en");
       WebElement ele = driver.findElement(By.className("/brands ms-ft-none text-left ms-d-inline"));
    String ele1 = ele.getText();
        
        System.out.println(ele1);
       
       
      
	
		
	
        
        
     
       
      
      
   
   
      
      
        

	}

}
