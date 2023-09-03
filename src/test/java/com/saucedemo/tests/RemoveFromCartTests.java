package com.saucedemo.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static io.qameta.allure.Allure.step;


public class RemoveFromCartTests extends TestBase {

    @CsvFileSource(resources = "/csvs/RemoveFromCartPositive.csv")

    @ParameterizedTest(name = "{0} adds {5} to Cart then successfully removes it on Inventory page")
    @Tag("remove_from_cart")
    @Tag("remove_in_the_shop")
    @Tag("positive")
    @DisplayName("Successful removing product from Cart by clicking 'Remove' button on Inventory page")
    void removeProductFromCartOnInventoryPageSuccessTest(String username, String rightPassword, String productsText,
                                                         String addToCart, String removeFromCart, String productTitle) {
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
        step("Remove product from Cart by clicking 'Remove' button", () -> {
            removeFromCartPage.clickRemoveFromCart(removeFromCart);
        });
        step("Navigate to Cart", () -> {
            inventoryPage.clickCartIcon();
        });
        step("Check that the Cart is empty", () -> {
            cartPage.checkCartIsEmpty();
        });
        step("Logout", () -> {
            sidebarMenuPage.openHamburgerMenu()
                    .clickLogoutButton();
        });
    }


    @CsvFileSource(resources = "/csvs/RemoveFromCartNegative.csv")

    @ParameterizedTest(name = "{0} adds {5} to Cart then fails to remove it on Inventory page")
    @Tag("remove_from_cart")
    @Tag("remove_in_the_shop")
    @Tag("negative")
    @DisplayName("problem_user fails to remove product from Cart by clicking 'Remove' button on Inventory page")
    void removeProductFromCartOnInventoryPageFailedTest(String username, String rightPassword, String productsText,
                                                        String addToCart, String removeFromCart, String productTitle) {
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
        step("Try to remove product from Cart by clicking 'Remove' button", () -> {
            removeFromCartPage.clickRemoveFromCart(removeFromCart);
        });
        step("Navigate to Cart", () -> {
            inventoryPage.clickCartIcon();
        });
        step("Check that the product hasn't been removed from Cart", () -> {
            checkoutPage.checkProductTitleInTheCart(productTitle);
        });
        step("Reset App State so to make possible run other parameterized tests", () -> {
            sidebarMenuPage.openHamburgerMenu()
                    .clickResetButton();
        });
    }


    @CsvFileSource(resources = "/csvs/RemoveInTheCart.csv")

    @ParameterizedTest(name = "{0} adds {5} to Cart then successfully removes it in the Cart")
    @Tag("remove_from_cart")
    @Tag("remove_in_the_cart")
    @Tag("positive")
    @DisplayName("Successful removing product in the Cart")
    void removeProductInTheCartSuccessTest(String username, String rightPassword, String productsText,
                                           String addToCart, String removeFromCart, String productTitle) {
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
        step("Check product presense in the Cart", () -> {
            checkoutPage.checkProductTitleInTheCart(productTitle);
        });
        step("Remove product from Cart by clicking 'Remove' button", () -> {
            removeFromCartPage.clickRemoveFromCart(removeFromCart);
        });
        step("Check that the Cart is empty", () -> {
            cartPage.checkCartIsEmpty();
        });
        step("Click 'Continue Shopping' button", () -> {
            cartPage.clickContinueShoppingButton();
        });
        step("Check presence of products to buy to verify being back in the shop", () -> {
            inventoryPage.checkPresenceOfProducts();
        });
        step("Logout", () -> {
            sidebarMenuPage.openHamburgerMenu()
                    .clickLogoutButton();
        });
    }
}
