package com.sauceLabs.screens;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.qameta.allure.Step;
//import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.time.Duration;


public class HomeScreen {
    public final WebDriver driver;
    public ExtentTest test;
    public ExtentReports extentReports;
    public static By card_number = By.name("carNumber");
    private final By Fuel_liters = By.name("fuelInLiters");
    private final By fuel_cost  = By.name("fuelCost");
    private final By FuelType = By.name("fuelType");

    //    public  WebDriver driver;
    public HomeScreen(WebDriver driver) {
        this.driver = driver;
    }
    @Step("test fuel tracker form ")
    public HomeScreen fuel_tracker_form() {
        extentReports = new ExtentReports("/home/hash-pc-8/Documents/vs_code/gdawel_test/ExtentReports/TestReports.html", true);
        test = extentReports.startTest("verify login page is opened");

        return new HomeScreen(driver);
    }
    @Step("new ")
    public void vvvv(){

    }




}
