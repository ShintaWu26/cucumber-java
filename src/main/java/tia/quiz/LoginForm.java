package tia.quiz;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginForm {
	
	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		driver.get("https://shop.demoqa.com/my-account/");
		System.out.println("Launch Website Login DemoQA");
		
		driver.manage().window().maximize();
		System.out.println("Window Maximize");
		
		
		//driver.findElement(By.id(null))
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement Login = driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/h2"));
		js.executeScript("arguments[0].scrollIntoView()", Login);
		
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("shinta");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("shinta123");
		driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[3]/button")).click();
		System.out.println("Logged In");
	
		String element = driver.findElement(By.cssSelector("#post-8 > div > div > div > p:nth-child(2)")).getText();;
		System.out.println(element);
		
		driver.close();
		System.out.println("Page Login Closed");
	}
}
