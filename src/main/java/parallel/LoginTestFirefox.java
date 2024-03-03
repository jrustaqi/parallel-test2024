package parallel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTestFirefox {
	WebDriver driver;

	@BeforeTest
	public void init() {
		System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.get("https://www.codefios.com/ebilling/login");
	}

	@Test
	public void loginTest() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("demo@codefios.com");
		driver.findElement(By.id("password")).sendKeys("abc123");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("login_submit"))));
		driver.findElement(By.id("login_submit")).click();
	}

	//@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
