package org.example;


import Base.Base;
import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class GeneralStore extends Base {

    TestMethodOrder Ascending;
    @Test
    @Order(1)
    public  void t1scrollDropDownModelUntilAruba() throws InterruptedException, MalformedURLException {
        configureAppium();
        GeneralStoreElements.PageHeader.equals("General Store");
        GeneralStoreElements.CountrySelection.click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Aruba\"));"));
        GeneralStoreElements.Aruba.click();
    }
    @Test
    @Order(2)
    public  void t2femaleRadioButtonShouldGetClicked() throws InterruptedException, MalformedURLException {
        configureAppium();
        GeneralStoreElements.PageHeader.equals("General Store");
        GeneralStoreElements.CountrySelection.click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Aruba\"));"));
        GeneralStoreElements.Aruba.click();
        GeneralStoreElements.femaleRadioButton.click();
    }

    @Test
    @Order(3)
    public  void t3maleRadioButtonShouldGetClicked() throws InterruptedException, MalformedURLException {
        configureAppium();
        GeneralStoreElements.PageHeader.equals("General Store");
        GeneralStoreElements.CountrySelection.click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Aruba\"));"));
        GeneralStoreElements.Aruba.click();
        GeneralStoreElements.maleRadioButton.click();
    }

    @Test
    @Order(4)
    public void t4productPageShouldVisibleAfterLetsShopIsClicked() throws MalformedURLException, InterruptedException {
        configureAppium();
        GeneralStoreElements.CountrySelection.click();
        GeneralStoreElements.Aruba.click();
        GeneralStoreElements.Name.should(Condition.visible);
        GeneralStoreElements.Name.sendKeys("Hello");
        GeneralStoreElements.LetsShop.should(Condition.visible);
        GeneralStoreElements.LetsShop.click();
        GeneralStoreElements.PageHeader.equals("Products");
    }

    @Test
    @Order(5)
    public void t5AddAnyProductToCart() throws MalformedURLException, InterruptedException {
        configureAppium();
        GeneralStoreElements.CountrySelection.click();
        GeneralStoreElements.Aruba.click();
        Thread.sleep(500);
        GeneralStoreElements.Name.sendKeys("Hello");
        GeneralStoreElements.LetsShop.click();
        GeneralStoreElements.PageHeader.equals("Products");
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"PG 3\"));"));
        GeneralStoreElements.AddToCart.should(Condition.visible);
        GeneralStoreElements.AddToCart.click();
        GeneralStoreElements.cartIcon.click();
        GeneralStoreElements.PageHeader.equals("Cart");
        GeneralStoreElements.Proceed.click();
    }

}


