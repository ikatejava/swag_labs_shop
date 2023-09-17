package com.saucedemo.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import com.saucedemo.config.WebConfig;
import com.saucedemo.helpers.Attach;
import com.saucedemo.pages.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {

    static WebConfig config = ConfigFactory.create(WebConfig.class, System.getProperties());

    Faker faker = new Faker();

    LoginPage loginPage = new LoginPage();
    ErrorMessagePage errorMessagePage = new ErrorMessagePage();
    InventoryPage inventoryPage = new InventoryPage();
    CheckoutPage checkoutPage = new CheckoutPage();
    SidebarMenuPage sidebarMenuPage = new SidebarMenuPage();
    CartPage cartPage = new CartPage();
    RemoveFromCartPage removeFromCartPage = new RemoveFromCartPage();
    PersonalInfoPage personalInfoPage = new PersonalInfoPage();
    FinalPage finalPage = new FinalPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false;
        Configuration.pollingInterval = 400;
        Configuration.timeout = 4000;
        Configuration.baseUrl = config.baseUrl();
        Configuration.browser = config.browser();
        Configuration.browserSize = config.browserSize();
        if (config.isRemote()) {
            Configuration.remote = config.remoteUrl();
        }

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    void beforeEach() {
        open(baseUrl);
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }
}