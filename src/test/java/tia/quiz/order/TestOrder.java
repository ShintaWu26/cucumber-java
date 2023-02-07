package tia.quiz.order;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import tia.quiz.pages.LoginPage;
import tia.quiz.pages.OrderPage;
import tia.quiz.utils.Constants;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestOrder {

	private static WebDriver driver;
    private OrderPage orderPage = new OrderPage();

    public TestOrder() {
        driver = Hooks.driver;
    }
    
    // Test Case One
    @When("User go to web product demoqa")
    public void user_go_to_web_product_demoqa() {
        driver.get(Constants.URL);
    }

    @And("User enter username password")
    public void user_enter_username_password() {
        orderPage.login("shinta","shinta123");
    }

    @And("User click button login")
    public void user_click_button_login() {
     //   loginPage.clickBtnLogin();
    }

    @Then("User valid credentials")
    public void user_invalid_credentials() {
    //   Assert.assertEquals(loginPage.getTxtDashboard(), "MY ACCOUNT");
    }
    
}
