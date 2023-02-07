package tia.quiz;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class OrderForm {
	
	public static void main(String[] args) {
		//running code dari class LoginForm
		LoginForm.main(args);
		
		//initiate
		ChromeDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		//buka website shop
		driver.get("https://shop.demoqa.com/shop/");
		System.out.println("Launch Website Shop DemoQA");
		
		driver.manage().window().maximize();
		System.out.println("Window Maximize");
		
		//pilih product
		js.executeScript("window.scrollBy(0,500)");
		ExpectedCondition<WebElement> shop = ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"noo-site\"]/div[2]/div[2]/div/div/div[3]/div/h3/a"));
		new WebDriverWait(driver, 20).until(shop).click();
		
		//shopping sepatu
		js.executeScript("window.scrollBy(0,700)");
		//pilih color
		Select color = new Select (driver.findElement(By.id("pa_color")));
		color.selectByVisibleText("Black");
		
		//pilih size
		Select size = new Select (driver.findElement(By.id("pa_size")));
		size.selectByVisibleText("36");
		
		//pilih qty
		driver.findElement(By.xpath("//*[@id=\"product-1281\"]/div[1]/div[2]/form/div/div[2]/div/div/button[2]/i")).click();
		
		//add to cart
		driver.findElement(By.xpath("//*[@id=\"product-1281\"]/div[1]/div[2]/form/div/div[2]/button")).click();
		System.out.println("product added to cart");
		
		//checkout cart
		driver.findElement(By.cssSelector("#nav-menu-item-cart > a > span")).click();
		js.executeScript("window.scrollBy(0,900)");
		
		//proceed checkout
		driver.findElement(By.xpath("//*[@id=\"post-6\"]/div/div/div[2]/div[2]/div/a")).click();
		System.out.println("proceed checkout");
		
		//checkoutCart
		js.executeScript("window.scrollBy(0,800)");
		
		//isi form checkout
		driver.findElement(By.id("billing_first_name")).sendKeys("Shinta");
		
		driver.findElement(By.id("billing_last_name")).sendKeys("Wu");
		
		driver.findElement(By.id("billing_company")).sendKeys("Faspay");
		
		driver.findElement(By.cssSelector("#select2-billing_country-container")).click();
		WebElement country = driver.findElement(By.cssSelector("body > span > span > span.select2-search.select2-search--dropdown > input"));
		country.sendKeys("Indonesia");
		country.sendKeys(Keys.ENTER);	
		
		driver.findElement(By.id("billing_address_1")).sendKeys("Jln. Pintu Air Raya");
		
		driver.findElement(By.id("billing_address_2")).sendKeys("Graha Astel");
		
		driver.findElement(By.id("billing_city")).sendKeys("Jakarta Pusat");
		
		driver.findElement(By.cssSelector("#select2-billing_state-container")).click();
		WebElement province = driver.findElement(By.cssSelector("body > span > span > span.select2-search.select2-search--dropdown > input"));
		province.sendKeys("DKI Jakarta");
		province.sendKeys(Keys.ENTER);	
		
		driver.findElement(By.id("billing_postcode")).sendKeys("10710");
		
	    driver.findElement(By.id("billing_phone")).sendKeys("6289603014828");
	    
		driver.findElement(By.xpath("//*[@id=\"order_comments\"]")).sendKeys("test");
		
		driver.findElement(By.id("billing_email")).sendKeys("2611wushinct@gmail.com");
		System.out.println("form checkout filled");
		
		WebElement COD = driver.findElement(By.xpath("//*[@id=\"payment\"]/ul/li/label"));
		js.executeScript("arguments[0].scrollIntoView()", COD);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("terms")).click();	
		System.out.println("tnc clicked");
		driver.findElement(By.xpath("//*[@id='place_order']")).click();
		
		//checkout success
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String element = driver.findElement(By.cssSelector("#post-7 > div > div > div > p.woocommerce-thankyou-order-received")).getText();
		System.out.println(element);

	}
}

