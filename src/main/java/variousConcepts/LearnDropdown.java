package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LearnDropdown {

	WebDriver driver;

	@Before
	public void init() {

		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.techfios.com/billing/?ng=login/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void logintest() {

		By USERNAME_LOCATOR = By.xpath("//input[@id='username']");
		By PASSWORD_LOCATOR = By.xpath("//input[@id='password']");
		By SIGNIN_BUTTON_LOCATOR = By.xpath("//button[@name='login' and @type='submit']");
		By DASHBOARD_HEADER_LOCATOR = By.xpath("//h2[contains(text(), 'Dashboard')]");
		By TRANSACTION_MENU_LOCATOR = By.xpath("//span[contains(text(), 'Transactions')]");
		By ADD_DEPOSIT_MENU_LOCATOR = By.xpath("//a[contains(text(), 'New Deposit')]");
		By ACCOUNT_LOCATOR = By.xpath("//select[@id='account']");

		driver.findElement(USERNAME_LOCATOR).sendKeys("demo@techfios.com");
		driver.findElement(PASSWORD_LOCATOR).sendKeys("abc123");
		driver.findElement(SIGNIN_BUTTON_LOCATOR).click();

		Assert.assertEquals("wrong page", "Dashboard", driver.findElement(DASHBOARD_HEADER_LOCATOR).getText());
		
		driver.findElement(TRANSACTION_MENU_LOCATOR).click();
		driver.findElement(ADD_DEPOSIT_MENU_LOCATOR).click();
		
		Select sel = new Select(driver.findElement(ACCOUNT_LOCATOR));
		sel.selectByVisibleText("CHECKING");
//		sel.getOptions();

	}
}
