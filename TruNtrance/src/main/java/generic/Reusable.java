package generic;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Reusable {

	WebDriver driver;

	public Reusable(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// Scroll the page
	public void scrollPage(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Scrolling down the page till the element is found
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	public void waitForElementToDisappear(WebElement ele) throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		wait.until(ExpectedConditions.visibilityOf((ele)));

	}

	public void dropdown(WebElement element, int i) {

		Select s = new Select(element);
		s.selectByIndex(i);
	}

	public void click(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public void click1(WebElement ele) {
		ele.click();

	}

	public void wait1() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void MouseHover(WebElement ele) {
		Actions action = new Actions(driver);
		action.moveToElement(ele).click().build().perform();

	}

	public void ValidatepopUp(String expectedTitle, String data, WebElement logout) {
		if (data.equals("valid")) {
			String ActualTitle = driver.getTitle();
			if (expectedTitle.equals(ActualTitle)) {
				// click(loginDropDown);
				click(logout);

				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}

		} else if (data.equals("Invalid")) {
			String ActualTitle = driver.getTitle();
			if (expectedTitle.equals(ActualTitle)) {
				System.out.println(expectedTitle + "===== " + ActualTitle);
				// click(loginDropDown);
				click(logout);

				Assert.assertTrue(false);
			} else {
				Assert.assertTrue(true);
			}

		}

	}
}
