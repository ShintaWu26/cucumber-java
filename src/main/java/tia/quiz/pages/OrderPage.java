package tia.quiz.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tia.quiz.drivers.DriverSingleton;


public class OrderPage {
	private WebDriver driver;

    public OrderPage() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(xpath = "//input[@id='username']")
    WebElement inputUsername;
    
    @FindBy(xpath = "//input[@id='password']")
    WebElement inputPassword;
    
	@FindBy(name = "login")
	WebElement btnLogin;
	
	@FindBy(xpath = "/html/body/div[1]/section/div/div/h1")
	WebElement txtDashboard;
	
	public void login(String username, String password) {
		inputUsername.sendKeys(username);
		inputPassword.sendKeys(password);
	}
	
	public void clickBtnLogin() {
		btnLogin.click();
	}
	
	public String getTxtDashboard() {
		return txtDashboard.getText();
	}
	
}
	
	

