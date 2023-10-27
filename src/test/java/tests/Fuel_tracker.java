package tests;

import com.sauceLabs.screens.homeScreen;
import io.qameta.allure.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static org.testng.AssertJUnit.assertNull;
@Epic("Fuel_tracker form")
@Feature("Functional")
public class Fuel_tracker{
    public ChromeDriver driver;
    @BeforeSuite
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\NANABODEY\\IdeaProjects\\car_fuel_tracker\\src\\test\\resources\\chromedriver.exe");
        String baseURL = "http://hiring.petroapp.com/test2.html";
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseURL);
        String verifyAssertNull = null;
        assertNull(verifyAssertNull);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Given I am on the Home page,\nThen complete the represented form.")
    @Test(description = "Check Functionality Scenario")
    public void TestScenarios() throws IOException {
        try {
            new homeScreen(driver)
                    .fuel_tracker_valid_submitting()
                    .fuel_tracker_Scenario1()
                    .fuel_tracker_Scenario2()
                    .fuel_tracker_Scenario3()
                    .fuel_tracker_Scenario4()
                    .fuel_tracker_Scenario5()
                    .fuel_tracker_Scenario6()
                    .fuel_tracker_Scenario7()
                    .fuel_tracker_delete_record();

        } catch (Exception e) {
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String screenshotFilePath = "path/to/screenshot.png";
            FileUtils.copyFile(screenshotFile, new File(screenshotFilePath));
            Reporter.log("<br><img src='" + screenshotFilePath + "' height='400' width='400'/><br>");
            Reporter.getCurrentTestResult();
            e.printStackTrace();
            // xoxb-5047666852083-5308135282803-uV2u3xENP1zzEMslqYBnqnyA

        }
    }
//    @AfterSuite
//    public void tearDown(){
//        driver.quit();
//    }
}
