package tests;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sauceLabs.screens.HomeScreen;
import io.qameta.allure.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.IExecutionListener;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static org.testng.AssertJUnit.assertNull;
@Epic("Gdawel App")
@Feature("Functional")
public class Fuel_tracker   implements IExecutionListener {

    public ChromeDriver driver;
    public ExtentTest test;
    public ExtentReports extentReports;

    @BeforeSuite
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "/home/hash-pc-8/Downloads/gdawelTest/src/test/resources/Resources/chromedriver");
        extentReports = new ExtentReports("/home/hash-pc-8/Documents/vs_code/gdawel_test/ExtentReports/TestReports.html", false);
        String baseURL = "https://gdawel.app/";
        test = extentReports.startTest("verify open browser ");
        test.log(LogStatus.INFO, "open browser Test in initialized");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("w3c", true);
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        test.log(LogStatus.PASS, "browser is open and windows is maximized");
        driver.get(baseURL);
        test.log(LogStatus.PASS, "String URL is opening in  chrome browser");
        extentReports.endTest(test);
        extentReports.flush();
        extentReports.getReportId();
        String verifyAssertNull = null;
        assertNull(verifyAssertNull);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
    }

    @Severity(SeverityLevel.CRITICAL)
    @Epic("SHAFT Web GUI Template")
    @Story("Check Functionality of gdawel")
    @TmsLink("TC-001")
    @Description("Given I am on the Home page,\nThen the browser title should be 'Google'.")
    @Parameters({"environment"})
    @Test(description = "Check Functionality Scenario")
    public void TestScenario() throws IOException {
        try {
            new HomeScreen(driver)
                    .clickOnLogin();

        } catch (Exception e) {
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String screenshotFilePath = "path/to/screenshot.png";
            FileUtils.copyFile(screenshotFile, new File(screenshotFilePath));
//            screenshotFile.canWrite();
            Reporter.log("<br><img src='" + screenshotFilePath + "' height='400' width='400'/><br>");
            Reporter.getCurrentTestResult();

            e.printStackTrace();
            // xoxb-5047666852083-5308135282803-uV2u3xENP1zzEMslqYBnqnyA

        }
    }
}
