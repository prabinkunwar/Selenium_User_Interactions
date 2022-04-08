package variousConcepts;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnWindowHandle {

	WebDriver driver;

	@Before
	public void init() {

		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.yahoo.com/?guccounter=1");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void windowHandleTest() throws InterruptedException {

//		System.out.println(driver.getTitle());
//		String handle1 = driver.getWindowHandle();
//		System.out.println(handle1);
		driver.findElement(By.id("ybar-sbq")).sendKeys("xpath");
		driver.findElement(By.id("ybar-search")).click();
		Thread.sleep(3000);
//		String handle2 = driver.getWindowHandle();
//		System.out.println(handle2);
//		System.out.println(driver.getTitle());

		driver.findElement(By.xpath("//div[@class='compTitle options-toggle']/h3/child::a[1]")).click();
		System.out.println(driver.getTitle());
		Set<String> handle3 = driver.getWindowHandles();
		System.out.println(handle3);
		for (String i : handle3) {
			System.out.println(i);
			driver.switchTo().window(i);
		}

		System.out.println(driver.getTitle());

	}

}
