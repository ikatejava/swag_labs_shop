package com.saucedemo.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static io.qameta.allure.Allure.step;


public class AddToCartTests extends TestBase {

    @CsvFileSource(resources = "/csvs/AddToCartPositive.csv")

    @ParameterizedTest(name = "{0} successfully adds {4} to Cart, checks its title and price {5}")
    @Tag("add_to_cart")
    @Tag("positive")
    @DisplayName("Successful adding product to Cart")
    void addProductToCartSuccessTest(String username, String rightPassword, String productsText,
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
        step("Reset App State so to make possible run other parameterized tests", () -> {
            sidebarMenuPage.openHamburgerMenu()
                    .clickResetButton();
        });
    }


    @CsvFileSource(resources = "/csvs/AddToCartNegative.csv")

    @ParameterizedTest(name = "{0} fails to add {4} to Cart")
    @Tag("add_to_cart")
    @Tag("negative")
    @DisplayName("problem_user fails to add product to Cart")
    void addProductToCartFailedTest(String username, String rightPassword, String productsText,
                                    String addToCart, String productTitle) {
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
        step("Check that the Cart is empty", () -> {
            cartPage.checkCartIsEmpty();
        });
        step("Reset App State so to make possible run other parameterized tests", () -> {
            sidebarMenuPage.openHamburgerMenu()
                    .clickResetButton();
        });
    }
}
