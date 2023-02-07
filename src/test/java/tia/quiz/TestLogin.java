package tia.quiz;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestLogin {

	WebDriver driver;
	JavascriptExecutor js;
	
	@BeforeClass
	public void testLaunchWebsiteLogin() {
		System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		
		driver.get(Constants.urlLogin);
		System.out.println("Launch Website Login DemoQA");
		
		driver.manage().window().maximize();
		System.out.println("Window Maximize");
	}
	
	@Test(description = "Deskripsi Login")
	public void testLoginWeb() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement Login = driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/h2"));
		js.executeScript("arguments[0].scrollIntoView()", Login);
		
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("shinta");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("shinta123");
		driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[3]/button")).click();
		System.out.println("Logged In");
	
		String element = driver.findElement(By.cssSelector("#post-8 > div > div > div > p:nth-child(2)")).getText();;
		Assert.assertTrue(element.contains("shinta"));
	}
	
	@AfterTest
	public void quitBrowser() {
		delay(3);
		driver.quit();
	}
	
	static void delay(int detik) {
		try {
			Thread.sleep(detik*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
