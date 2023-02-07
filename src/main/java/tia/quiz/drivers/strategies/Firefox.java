package tia.quiz.drivers.strategies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox implements DriverStrategy {

	public WebDriver setStrategy() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new FirefoxDriver();
        return driver;
    }
	
}
