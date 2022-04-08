package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LearnKeyboardEvent {

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
		
		driver.findElement(USERNAME_LOCATOR).sendKeys("demo@techfios.com");
		driver.findElement(PASSWORD_LOCATOR).sendKeys("abc123");
		
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
//		action.sendKeys(Keys.RETURN).build().perform();
		
	}
}
