package trun;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.Reusable;

public class HomePage extends Reusable {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	
	}
	@FindBy(xpath="//a[normalize-space()='Dashboard']")
	WebElement Dashboard;
	@FindBy(xpath="//a[normalize-space()='Manage Client']")
	WebElement ManageClient;
    @FindBy(xpath="//a[normalize-space()='Add Client']")
    WebElement AddClient;
    @FindBy(xpath="//a[normalize-space()='Logout']")
    WebElement Logout;


public void HomePage() {
	click1(Dashboard);
	click1(ManageClient);
	click1(AddClient);
	click1(Logout);
	
}
}