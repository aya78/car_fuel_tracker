package com.sauceLabs.screens;

import com.github.javafaker.Faker;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
//import org.junit.jupiter.api.Test;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class homeScreen {
    public final WebDriver driver;
    public static By car_num = By.name("carNumber");
    private final By fuel_liters = By.name("fuelInLiters");
    private final By fuel_cost  = By.name("fuelCost");
    private final By fuelType = By.name("fuelType");
    private final  By date_and_time = By.name("dateAndTime");
    private final  By customer_company_id = By.name("companyId");
    private final  By delete_button = By.xpath("//*[@id=\"root\"]/div/table/tbody/tr[1]/td[7]/button");


    int car_number = Integer.parseInt(RandomStringUtils.random(6, false, true));
    Faker fakeData=new Faker();
    int id = fakeData.number().randomDigit();

    int cost = Integer.parseInt(fakeData.number().digits(3));
    private final  By edit_button = By.xpath("//button[@class='btn btn-primary']");
    public homeScreen(WebDriver driver) {
        this.driver = driver;
    }
    @TmsLink("TC-001")
    @Story("Check Functionality of tracker form with valid data")
    @Description("Given I am on form page,\nThen enter valid data in all fields in represented form ," +
            "and click on edit  .")
    @Step("test fuel tracker form")
    @Test
    public homeScreen fuel_tracker_valid_submitting() throws InterruptedException {
        driver.findElement(car_num).sendKeys(""+car_number);
        driver.findElement(fuel_liters).sendKeys(""+12);
        driver.findElement(fuel_cost).sendKeys(""+5);
        driver.findElement(fuelType).sendKeys("solar");
        Actions a = new Actions(driver);
        a.sendKeys(Keys.PAGE_DOWN).build().perform();
        WebElement dateBox = driver.findElement(date_and_time);
        //Fill date as mm/dd/yyyy as 09/25/2013
        dateBox.sendKeys("09252013");
        Thread.sleep(1000);
        //Press tab to shift focus to time field
        dateBox.sendKeys(Keys.TAB);
        //Fill time as 02:45 PM
        dateBox.sendKeys("0245PM");
        driver.findElement(customer_company_id).sendKeys(""+id);
        driver.findElement(edit_button).sendKeys(Keys.ENTER);
        String expectedCar_number = ""+car_number;
        String actualCar_number = driver.findElement(By.xpath("/html/body/div/div/table/tbody/tr/td[1]")).getText();
        Assert.assertEquals(actualCar_number, expectedCar_number);


        return new homeScreen(driver);
    }
    @TmsLink("TC-002")
    @Story("Check Functionality of tracker form with invalid data")
    @Description("Given I am on form page,\nThen enter invalid car number, keep date & time  empty and  fill valid data in all fields in represented form ," +
            "and click on edit  .")
    @Step("test fuel tracker form")
    @Test (dependsOnMethods = "fuel_tracker_valid_submitting")
    public homeScreen fuel_tracker_Scenario1() throws InterruptedException {
        driver.findElement(car_num).sendKeys(""+fakeData.number().digits(4));
        driver.findElement(fuel_liters).sendKeys(""+12);
        driver.findElement(fuel_cost).sendKeys(""+5);
        driver.findElement(fuelType).sendKeys("solar");
        Actions a = new Actions(driver);
        a.sendKeys(Keys.PAGE_DOWN).build().perform();
        driver.findElement(date_and_time).getAttribute("value");
        driver.findElement(customer_company_id).sendKeys(""+fakeData.number().randomDigit());
        driver.findElement(edit_button).sendKeys(Keys.ENTER);

        return new homeScreen(driver);
    }
    @TmsLink("TC-003")
    @Story("Check Functionality of tracker form with invalid data")
    @Description("Given I am on form page,\nThen fill fuel type & date , keep all fields empty in represented form ," +
            "and click on edit  .")
    @Step("test fuel tracker form")
    @Test (dependsOnMethods = "fuel_tracker_Scenario1")
    public homeScreen fuel_tracker_Scenario2() throws InterruptedException {
        Faker faker = new Faker();
        driver.findElement(car_num).sendKeys("");
        driver.findElement(fuel_liters).sendKeys("");
        driver.findElement(fuel_cost).sendKeys("");
        driver.findElement(fuelType).sendKeys("solar");
        Actions a = new Actions(driver);
        a.sendKeys(Keys.PAGE_DOWN).build().perform();
        WebElement dateBox = driver.findElement(date_and_time);
        //Fill date as mm/dd/yyyy as 09/25/2013
        dateBox.sendKeys("09252013");
        Thread.sleep(1000);
        //Press tab to shift focus to time field
        dateBox.sendKeys(Keys.TAB);
        //Fill time as 02:45 PM
        dateBox.sendKeys("0245PM");
        driver.findElement(customer_company_id).sendKeys("");
        driver.findElement(edit_button).sendKeys(Keys.ENTER);

        return new homeScreen(driver);
    }
    @TmsLink("TC-004")
    @Story("Check Functionality of tracker form with invalid data")
    @Description("Given I am on form page,\nThen fill already exist car number , enter zero in cost and  fill all fields  in represented form ," +
            "and click on edit  .")
    @Step("test fuel tracker form")
    @Test(dependsOnMethods = "fuel_tracker_Scenario2")
    public homeScreen fuel_tracker_Scenario3() throws InterruptedException {

        driver.findElement(car_num).sendKeys(""+car_number);
        driver.findElement(fuel_liters).sendKeys(""+20);
        driver.findElement(fuel_cost).sendKeys(""+0);
        driver.findElement(fuelType).sendKeys("solar");
        Actions a = new Actions(driver);
        a.sendKeys(Keys.PAGE_DOWN).build().perform();
        WebElement dateBox = driver.findElement(date_and_time);
        //Fill date as mm/dd/yyyy as 09/25/2013
        dateBox.sendKeys("09252013");
        Thread.sleep(1000);
        //Press tab to shift focus to time field
        dateBox.sendKeys(Keys.TAB);
        //Fill time as 02:45 PM
        dateBox.sendKeys("0245PM");
        driver.findElement(customer_company_id).sendKeys(""+2);
        driver.findElement(edit_button).sendKeys(Keys.ENTER);

        return new homeScreen(driver);
    }
    @TmsLink("TC-005")
    @Story("Check Functionality of tracker form with invalid data")
    @Description("Given I am on form page,\nThen fill a negative number in  car number , enter a space in fuel in liters & cost , field and  fill all fields  in represented form ," +
            "and click on edit  .")
    @Step("test fuel tracker form")
    @Test(dependsOnMethods = "fuel_tracker_Scenario3")
    public homeScreen fuel_tracker_Scenario4() throws InterruptedException {

        driver.findElement(car_num).sendKeys(""+car_number);
        driver.findElement(fuel_liters).sendKeys(""+21+""+10);
        driver.findElement(fuel_cost).sendKeys(""+10+" "+222);
        driver.findElement(fuelType).sendKeys("solar");
        Actions a = new Actions(driver);
        a.sendKeys(Keys.PAGE_DOWN).build().perform();
        WebElement dateBox = driver.findElement(date_and_time);
        //Fill date as mm/dd/yyyy as 09/25/2013
        dateBox.sendKeys("09252013");
        Thread.sleep(1000);
        //Press tab to shift focus to time field
        dateBox.sendKeys(Keys.TAB);
        //Fill time as 02:45 PM
        dateBox.sendKeys("0245PM");
        driver.findElement(customer_company_id).sendKeys(""+2);
        driver.findElement(edit_button).sendKeys(Keys.ENTER);

        return new homeScreen(driver);
    }
    @TmsLink("TC-006")
    @Story("Check Functionality of tracker form with invalid data")
    @Description("Given I am on form page,\nThen fill already exist customer id  ," +
            " enter letters in cost & enter space in customer id  and  fill all fields  in represented form ," +
            "and click on edit  .")
    @Step("test fuel tracker form")
    @Test(dependsOnMethods = "fuel_tracker_Scenario4")
    public homeScreen fuel_tracker_Scenario5() throws InterruptedException {

        driver.findElement(car_num).sendKeys(""+car_number);
        driver.findElement(fuel_liters).sendKeys("liter");
        driver.findElement(fuel_cost).sendKeys("nnn");
        driver.findElement(fuelType).sendKeys("solar");
        Actions a = new Actions(driver);
        a.sendKeys(Keys.PAGE_DOWN).build().perform();
        WebElement dateBox = driver.findElement(date_and_time);
        //Fill date as mm/dd/yyyy as 09/25/2013
        dateBox.sendKeys("09252013");
        Thread.sleep(1000);
        //Press tab to shift focus to time field
        dateBox.sendKeys(Keys.TAB);
        //Fill time as 02:45 PM
        dateBox.sendKeys("0245PM");
        driver.findElement(customer_company_id).sendKeys(""+2+" "+2);
        driver.findElement(edit_button).sendKeys(Keys.ENTER);

        return new homeScreen(driver);
    }
    @TmsLink("TC-007")
    @Story("Check Functionality of tracker form with invalid data")
    @Description("Given I am on form page,\nThen fill already exist customer id for the same car number ," +
            " enter negative number in cost & fuel in liters and " +
            " fill all fields  in represented form ,and click on edit  .")
    @Step("test fuel tracker form")
    @Test(dependsOnMethods = "fuel_tracker_Scenario5")
    public homeScreen fuel_tracker_Scenario6() throws InterruptedException {

        driver.findElement(car_num).sendKeys(""+car_number);
        driver.findElement(fuel_liters).sendKeys("-"+20);
        driver.findElement(fuel_cost).sendKeys("-"+11);
        driver.findElement(fuelType).sendKeys("solar");
        Actions a = new Actions(driver);
        a.sendKeys(Keys.PAGE_DOWN).build().perform();
        WebElement dateBox = driver.findElement(date_and_time);
        //Fill date as mm/dd/yyyy as 09/25/2013
        dateBox.sendKeys("09252013");
        Thread.sleep(1000);
        //Press tab to shift focus to time field
        dateBox.sendKeys(Keys.TAB);
        //Fill time as 02:45 PM
        dateBox.sendKeys("0245PM");
        driver.findElement(customer_company_id).sendKeys(""+id);
        driver.findElement(edit_button).sendKeys(Keys.ENTER);

        return new homeScreen(driver);
    }
    @TmsLink("TC-008")
    @Story("Check Functionality of tracker form with invalid data")
    @Description("Given I am on form page,\nThen " +
            " enter negative number in customer id  ,  " +
            " fill all fields  in represented form ,and click on edit  .")
    @Step("test fuel tracker form")
    @Test(dependsOnMethods = "fuel_tracker_Scenario6")
    public homeScreen fuel_tracker_Scenario7() throws InterruptedException {

        driver.findElement(car_num).sendKeys(""+car_number);
        driver.findElement(fuel_liters).sendKeys(""+20);
        driver.findElement(fuel_cost).sendKeys(""+11);
        driver.findElement(fuelType).sendKeys("solar");
        Actions a = new Actions(driver);
        a.sendKeys(Keys.PAGE_DOWN).build().perform();
        WebElement dateBox = driver.findElement(date_and_time);
        //Fill date as mm/dd/yyyy as 09/25/2013
        dateBox.sendKeys("09252013");
        Thread.sleep(1000);
        //Press tab to shift focus to time field
        dateBox.sendKeys(Keys.TAB);
        //Fill time as 02:45 PM
        dateBox.sendKeys("0245PM");
        driver.findElement(customer_company_id).sendKeys("-"+id);
        driver.findElement(edit_button).sendKeys(Keys.ENTER);

        return new homeScreen(driver);
    }

    @TmsLink("TC-009")
    @Story("Check Functionality of tracker form with  invalid data")
    @Description("Given I am on form page,\nThen " +
            "delete record from table .")
    @Step("test fuel tracker form")
    @Test(dependsOnMethods = "fuel_tracker_Scenario6")
    public homeScreen fuel_tracker_delete_record() {
        Actions a = new Actions(driver);
        a.sendKeys(Keys.PAGE_DOWN).build().perform();
        driver.findElement(delete_button).sendKeys(Keys.ENTER);
        return new homeScreen(driver);
    }



}
