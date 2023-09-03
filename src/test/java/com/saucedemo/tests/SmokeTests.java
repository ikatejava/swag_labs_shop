package com.saucedemo.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static com.saucedemo.tests.TestData.errorMessageLastNameRequired;
import static com.saucedemo.tests.TestData.orderInformation;
import static io.qameta.allure.Allure.step;


public class SmokeTests extends TestBase {

    @CsvFileSource(resources = "/csvs/SmokePositive.csv")

    @ParameterizedTest(name = "{0} successfully adds {4} to cart, checks price {5} and {6} text after purchase")
    @Tag("smoke")
    @Tag("positive")
    @DisplayName("Successful adding product to Cart, checking its title and price, and buying product")
    void swagLabsSmokeSuccessTest(String username, String rightPassword, String productsText,
                                  String addToCart, String productTitle, String productPrice,
                                  String thankYou) {
        step("Fill out authorization form with correct data", () -> {
            loginPage.enterUsername(username)
                    .enterPassword(rightPassword)
                    .clickLoginButton();
        });
        step("Check presence of 'Products' subtitle and products to verify authorization", () -> {
            inventoryPage.checkSubtitle(productsText)
                    .checkPresenceOfProducts();
        });
        step("Add product to Cart", () -> {
            inventoryPage.clickAddToCart(addToCart);
        });
        step("Navigate to Cart", () -> {
            inventoryPage.clickCartIcon();
        });
        step("Check that product title and price in the Cart are correct", () -> {
            checkoutPage.checkProductTitleInTheCart(productTitle)
                    .checkProductPriceInTheCart(productPrice);
        });
        step("Click 'Checkout' and navigate to personal information form", () -> {
            cartPage.clickCheckoutButton();
        });
        step("Fill out personal information form with faker data", () -> {
            personalInfoPage.enterFirstName(faker.name().firstName())
                    .enterLastName(faker.name().lastName())
                    .enterZipCode(faker.address().zipCode());
        });
        step("Click 'Continue' button", () -> {
            personalInfoPage.clickContinueButton();
        });
        step("Check that product title and price on Checkout page are correct", () -> {
            checkoutPage.checkProductTitleInTheCart(productTitle)
                    .checkProductPriceInTheCart(productPrice);
        });
        step("Click 'Finish' button", () -> {
            checkoutPage.clickFinishButton();
        });
        step("Check presence of 'Thank you...' and order information texts on final page", () -> {
            finalPage.checkTextElementsToBePresent(thankYou, orderInformation)
                    .checkBackHomeButtonPresence();
        });
        step("Click 'Back Home' button and navigate back to the shop", () -> {
            finalPage.clickBackHomeButton();
        });
        step("Check presence of products to buy to verify being back in the shop", () -> {
            inventoryPage.checkPresenceOfProducts();
        });
        step("Logout", () -> {
            sidebarMenuPage.openHamburgerMenu()
                    .clickLogoutButton();
        });
    }


    @CsvFileSource(resources = "/csvs/SmokeNegative.csv")

    @ParameterizedTest(name = "{0} adds {4} to cart, checks its title and price {5}, then fails on personal info page")
    @Tag("smoke")
    @Tag("negative")
    @DisplayName("Adding product to Cart, checking its title and price, then failure at filling out personal info")
    void swagLabsSmokeFailedTest(String username, String rightPassword, String productsText,
                                 String addToCart, String productTitle, String productPrice) {
        step("Fill out authorization form with correct data", () -> {
            loginPage.enterUsername(username)
                    .enterPassword(rightPassword)
                    .clickLoginButton();
        });
        step("Check presence of 'Products' subtitle and products to verify authorization", () -> {
            inventoryPage.checkSubtitle(productsText)
                    .checkPresenceOfProducts();
        });
        step("Add product to Cart", () -> {
            inventoryPage.clickAddToCart(addToCart);
        });
        step("Navigate to Cart", () -> {
            inventoryPage.clickCartIcon();
        });
        step("Check that product title and price in the Cart are correct", () -> {
            checkoutPage.checkProductTitleInTheCart(productTitle)
                    .checkProductPriceInTheCart(productPrice);
        });
        step("Click 'Checkout' and navigate to personal information form", () -> {
            cartPage.clickCheckoutButton();
        });
        step("Fill out personal information form with faker data", () -> {
            personalInfoPage.enterFirstName(faker.name().firstName())
                    .enterLastName(faker.name().lastName())
                    .enterZipCode(faker.address().zipCode());
        });
        step("Click 'Continue' button", () -> {
            personalInfoPage.clickContinueButton();
        });
        step("Check error message", () -> {
            errorMessagePage.checkErrorMessage(errorMessageLastNameRequired);
        });
        step("Reset App State so to make possible run other parameterized tests", () -> {
            sidebarMenuPage.openHamburgerMenu()
                    .clickResetButton();
        });
    }
}
