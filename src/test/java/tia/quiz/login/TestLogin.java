package tia.quiz.login;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import tia.quiz.pages.LoginPage;
import tia.quiz.utils.Constants;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestLogin {

	private static WebDriver driver;
	private static ExtentTest extentTest;
    private LoginPage loginPage = new LoginPage();

    public TestLogin() {
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }
    
    // Test Case One
    @When("User go to web demoqa")
    public void user_go_to_Web_demoqa() {
        driver.get(Constants.URL);
        extentTest.log(LogStatus.PASS, "User go to web demoqa");
        
    }

    @And("User enter username password")
    public void user_enter_username_password() {
        loginPage.login("shinta","shinta123");
        extentTest.log(LogStatus.PASS, "User enter username password");
    }

    @And("User click button login")
    public void user_click_button_login() {
        loginPage.clickBtnLogin();
        extentTest.log(LogStatus.PASS, "User click button login");
    }

    @Then("User valid credentials")
    public void user_invalid_credentials() {
       Assert.assertEquals(loginPage.getTxtDashboard(), "MY ACCOUNT");
       extentTest.log(LogStatus.PASS, "User valid credentials");
    }
    
}
