package com.sauceLabs.screens;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.shaft.driver.SHAFT;
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

import static com.ibm.db2.jcc.am.ao.dx;
import static com.ibm.db2.jcc.am.ao.dy;

public class HomeScreen {
    //     public static By products = By.xpath("//*[@text='Products']");
    public final WebDriver driver;
//    public final SHAFT.GUI.WebDriver new_driver;

    public ExtentTest test;
    public ExtentReports extentReports;


    public static By card_number = By.name("carNumber");
    //  //a[@id='customers-suppliers']

    private final By Fuel_liters = By.name("fuelInLiters");
    private final By fuel_cost  = By.name("fuelCost");
    private final By FuelType = By.name("fuelType");

    private final By CustomerCompanyID = By.name("companyId");
    /********************************************************************************************************************************/

    private final By productsAndWarehouseMenu = By.id("products-menu");
    //    private final By products = By.xpath("//a[@href='https://gdawel.app/dashboard/products']");
    private final By products = By.id("product-list-menu");

    private final By product_category = By.id("category-menu");
    //    private final By AddQtyAdjustment = By.cssSelector("li#adjustment-list-menu>a");
    private final By AddQtyAdjustment = By.id("adjustment-list-menu");

    private final By OpenStockCount = By.id("stock-count-menu");

    // li#transfer-list-menu>a
    private final By OpenTransfer = By.id("transfer-list-menu");
    // //td[@class='sorting_1']//a[1]
    private final By OpenWareHouse = By.id("warehouse-menu");
    private final By OpenBrands = By.cssSelector("li#brand-menu>a");
    private final By OpenUnits = By.cssSelector("li#unit-menu>a");
    // /html/body/nav/ul/li[4]/a
    private final By OpenPurchasesAndSales = By.cssSelector("ul#side-main-menu>li:nth-of-type(4)>a");
    private final By OpenQuotation = By.cssSelector("li#quotation-list-menu>a");
    private final By OpenGiftCards = By.cssSelector("li#gift-card-menu>a");
    private final By OpenCoupons = By.xpath("//li[@id='coupon-menu']//a[1]");

    private final By OpenPurchases = By.cssSelector("li#purchase-list-menu>a");
    private final By OpenSales = By.cssSelector("li#sale-list-menu>a");
    private final By OpenExchange = By.cssSelector("li#exchange-bonds-menu>a");
    private final By OpenReceipt = By.cssSelector("li#receipt-bonds-menu>a");
    private final By ClickOnProfileImg = By.xpath("//img[@class='shadow-sm']/following-sibling::span[1]");
    /********************************************************************************************************************************/
    private final By clickOnProfile = By.xpath("//span[text()[normalize-space()='الملف الشخصي']]");

    //    public  WebDriver driver;
    public HomeScreen(WebDriver driver) {
        this.driver = driver;
    }

    public HomeScreen(WebDriver driver, SHAFT.GUI.WebDriver new_driver) {
        this.driver = driver;
    }

    @Step("click On Login")
    public LoginScreen clickOnLogin() {
        extentReports = new ExtentReports("/home/hash-pc-8/Documents/vs_code/gdawel_test/ExtentReports/TestReports.html", true);
        test = extentReports.startTest("verify login page is opened");


        if (driver.findElement(loginLink).isDisplayed()) {
            test.log(LogStatus.PASS, "login page is open  ");
        } else
            test.log(LogStatus.FAIL, "fail to find login page");

        driver.findElement(loginLink).click();
        extentReports.endTest(test);
        extentReports.flush();
        return new LoginScreen(driver);
    }

    @Step("click On Side Menu Then open Customers")
    public CustomersScreen clickOnSideMenu() throws InterruptedException {
        //new WebDriverWait(driver, Duration.ofSeconds(15));
//        driver.findElement(By.className("version-modal")).click();
        //WebElement modal_content = WebDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("version-modal")));

//        driver.findElement(By.xpath("//html")).click();

        Thread.sleep(10000);
        Actions action = new Actions(driver);
        action.moveByOffset(0, 0).click().build().perform();
        //driver.switchTo().alert().dismiss();
        // driver.findElement(By.className("side-navbar")).click();
        //clickAt(locator, coordinates);
        driver.findElement(openCustomerAndSupplierMenu).click();
        boolean n = driver.findElement(customers).isSelected();
        if (n) {
            System.out.println("Element is Present");
        } else {
            System.out.println("Element is Absent");
        }
        Thread.sleep(2000);
        new WebDriverWait(driver,Duration.ofSeconds(3))
            .until(ExpectedConditions.visibilityOfElementLocated(customers));
        driver.findElement(customers).click();

        return new CustomersScreen(driver);
    }

    @Step("click On Side Menu Then open Suppliers")
    public SuppliersScreen navigateToSupplierList() {
        driver.findElement(suppliers).click();
        return new SuppliersScreen(driver);
    }

    @Step("click On Side Menu Then open Customer Group")
    public CustomerGroupScreen navigateToCustomerGroup() {
        driver.findElement(customerGroup).click();
        return new CustomerGroupScreen(driver);
    }

    @Step("click On Side Menu Then open product Group")
    public ProductsScreen navigateToProducts() {
        driver.findElement(productsAndWarehouseMenu).click();
        driver.findElement(products).click();
        return new ProductsScreen(driver);
    }

    @Step("click On Side Menu Then open product Group")
    public ProductCategoryScreen navigateToProductsCategory() {
        driver.findElement(productsAndWarehouseMenu).click();

        driver.findElement(product_category).click();
        return new ProductCategoryScreen(driver);
    }

    @Step("click On Side Menu Then open QtyAdjustment")
    public QtyAdjustmentScreen navigateToQtyAdjustment() {
//            driver.findElement(productsAndWarehouseMenu).click();

        driver.findElement(AddQtyAdjustment).click();
        return new QtyAdjustmentScreen(driver);
    }

    @Step("click On Side Menu Then open StockCount")
    public StockCountScreen navigateToStockCount() {
//        driver.findElement(productsAndWarehouseMenu).click();

        driver.findElement(OpenStockCount).click();
        return new StockCountScreen(driver);
    }

    @Step("click On Side Menu Then open Transfer")
    public TransfersScreen navigateToTransfer() {
        //////////////////////////////////////////////////////////////////////////////
//        driver.findElement(productsAndWarehouseMenu).click();

        driver.findElement(OpenTransfer).click();
        return new TransfersScreen(driver);
    }

    @Step("click On Side Menu Then open WareHouses")
    public WarehousesScreen navigateToWareHouses() {
        //
        driver.findElement(OpenWareHouse).click();
        return new WarehousesScreen(driver);
    }

    @Step("click On Side Menu Then open Brands")
    public BrandScreen navigateToBrands() {
        /***************************************************************************/
//                driver.findElement(productsAndWarehouseMenu).click();

        driver.findElement(OpenBrands).click();
        return new BrandScreen(driver);
    }

    @Step("click On Side Menu Then open Units")
    public UnitScreen navigateToUnits() {
        driver.findElement(OpenUnits).click();
        return new UnitScreen(driver);
    }

    @Step("click On Side Menu Then open Purchases")
    public PurchasesScreen navigateToPurchases() {
        driver.findElement(OpenPurchasesAndSales).click();
        driver.findElement(OpenPurchases).click();
        return new PurchasesScreen(driver);
    }

    // QuotationScreen
    @Step("click On Side Menu Then open Quotation")
    public QuotationScreen navigateToQuotations() {
        driver.findElement(OpenPurchasesAndSales).click();

        driver.findElement(OpenQuotation).click();
        return new QuotationScreen(driver);
    }

    @Step("click On Side Menu Then open GiftCards")
    public GiftCardScreen navigateToGiftCards() {
        driver.findElement(OpenPurchasesAndSales).click();

        driver.findElement(OpenGiftCards).click();
        return new GiftCardScreen(driver);
    }

    @Step("click On Side Menu Then open Coupons")
    public CouponScreen navigateToCoupons() {
//        driver.findElement(OpenPurchasesAndSales).click();

        driver.findElement(OpenCoupons).click();
        return new CouponScreen(driver);
    }

    @Step("click On Side Menu Then open Sales")
    public SalesScreen navigateToSales() {
        driver.findElement(OpenPurchasesAndSales).click();
        driver.findElement(OpenSales).click();
        return new SalesScreen(driver);
    }

    @Step("click On Side Menu Then open Exchanges")
    public ExchangeScreen navigateToExchange() {
        driver.findElement(OpenPurchasesAndSales).click();
        driver.findElement(OpenExchange).click();
        return new ExchangeScreen(driver);
    }

    @Step("click On Side Menu Then open Receipt")
    public ReceiptScreen navigateToReceipts() {
//        driver.findElement(OpenPurchasesAndSales).click();
        driver.findElement(OpenReceipt).click();
        return new ReceiptScreen(driver);
    }

    @Step("click On Side Menu Then open ProfileScreen")
    public ProfileScreen navigateToProfile() {
        driver.findElement(ClickOnProfileImg).click();
        driver.findElement(clickOnProfile).click();
        return new ProfileScreen(driver);
    }


}
