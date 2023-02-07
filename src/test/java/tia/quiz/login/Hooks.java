package tia.quiz.login;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import tia.quiz.drivers.DriverSingleton;
import tia.quiz.utils.Constants;
import tia.quiz.utils.TestScenarios;
import tia.quiz.utils.Utils;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	public static WebDriver driver;
	public static ExtentReports reports = new ExtentReports("target/extent-report.html");
	public static ExtentTest extentTest;

    @Before
    public void setUp() {
        DriverSingleton.getInstance(Constants.CHROME);
        driver = DriverSingleton.getDriver();
        TestScenarios[] tests = TestScenarios.values();
        extentTest = reports.startTest(tests[Utils.testCount].getTestName());
        Utils.testCount++;
    }

    @AfterStep
    public void getResultStatus(Scenario scenario)throws IOException {
    	if(scenario.isFailed()) {
    		String screenPath = Utils.getScreenshot(driver, scenario.getName().replace(" ", "_"));
    		extentTest.log(LogStatus.FAIL, scenario.getName()+"\n"
    				+extentTest.addScreenCapture(screenPath));
    	}
    }
    
    @After
    public void closeObject() {
    	reports.endTest(extentTest);
    	reports.flush();
    }
    
    
    @AfterAll
    public static void closeBrowser() {
        delay(3);
        DriverSingleton.closeObjectInstance();
    }

    public static void delay(int detik) {
        try {
            Thread.sleep(1000*detik);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void scroll(int vertical) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,"+vertical+")");
    }
    
}
