package trun;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.Reusable;
     

public class LoginPage extends Reusable {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="email_id")
	WebElement Id;
	@FindBy(id="password")
	WebElement password;
	@FindBy(id="submitBtn")
	WebElement SubmitBtn;
	@FindBy(xpath="//a[@class='nav-link']")
	WebElement Logout;
	
	
	
	public void Login(String id, String password1) {
		Id.sendKeys(id);
		password.sendKeys(password1);
		SubmitBtn.click();
		
	
		
	}
	public HomePage Login1() {
		Id.sendKeys("biocube@gmail.com");
		password.sendKeys("1234");
		SubmitBtn.click();
		HomePage hmg= new HomePage(driver);
		return hmg;
		
	
		
	}
	
	
	public void goTo() {
		
		driver.get("https://biopasstest.com:9069/admin-login");
	}


	public void validateLogin(String expectedTitle, String data ) {
		
		ValidatepopUp(expectedTitle,data, Logout);
		
		
	}


}
