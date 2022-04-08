package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LearnMouseHover {

	WebDriver driver;

	@Before
	public void init() {

		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.dell.com/en-us");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void learnMouseHover() {
		
		By PRODUCT_LOCATOR = By.xpath("//span[text()='Products']");
		By MONITOR_LOCATOR =By.xpath("//a[contains(text(),'Monitors')]");
		By FOR_HOME_MONITORS_LOCATOR_1 = By.xpath("//a[contains(text(), 'Monitors')]/following-sibling::ul/descendant::a[2]");
//		By FOR_HOME_MONITORS_LOCATOR_2 = By.xpath("//a[contains(text(), 'Monitors')]/parent::li/descendant::a[3]");
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(PRODUCT_LOCATOR)).build().perform();
		action.moveToElement(driver.findElement(MONITOR_LOCATOR)).build().perform();
		driver.findElement(FOR_HOME_MONITORS_LOCATOR_1).click();

		
	}
	
}
