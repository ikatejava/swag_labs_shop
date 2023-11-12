package com.saucedemo.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.saucedemo.tests.TestData.*;
import static io.qameta.allure.Allure.step;

public class LoginTests extends TestBase {

    @CsvSource(value = {"standard_user | secret_sauce | Products",
            "problem_user | secret_sauce | Products",
            "performance_glitch_user | secret_sauce | Products"
    }, delimiter = '|')

    @ParameterizedTest(name = "Successful authorization of {0}")
    @Tag("login")
    @Tag("positive")
    @DisplayName("Successful authorization of existing user")
    void successfulLoginTest(String username, String rightPassword, String productsText) {
        step("Fill out authorization form with correct data", () -> {
            loginPage.enterUsername(username)
                    .enterPassword(rightPassword)
                    .clickLoginButton();
        });
        step("Check presence of 'Products' subtitle and products to verify authorization", () -> {
            inventoryPage.checkSubtitle(productsText)
                    .checkPresenceOfProducts();
        });
        step("Logout", () -> {
            sidebarMenuPage.openHamburgerMenu()
                    .clickLogoutButton();
        });
    }


    @CsvSource(value = {"standard_user | secretsauce",
            "problem_user | secretsauce",
            "performance_glitch_user | secretsauce"
    }, delimiter = '|')

    @ParameterizedTest(name = "Failed authorization of {0} with wrong password")
    @Tag("login")
    @Tag("negative")
    @DisplayName("Failed authorization of existing user with wrong password")
    void failedLoginWithWrongPasswordTest(String username, String wrongPassword) {
        step("Fill out authorization form with incorrect password", () -> {
            loginPage.enterUsername(username)
                    .enterPassword(wrongPassword)
                    .clickLoginButton();
        });
        step("Check error message", () -> {
            errorMessagePage.checkErrorMessage(errorMessageWrongPassword);
        });
    }

    @Test
    @Tag("login")
    @Tag("negative")
    @DisplayName("Failed authorization of the lockout user")
    void failedLoginOfTheLockoutUserTest() {
        step("Fill out authorization form with correct data", () -> {
            loginPage.enterUsername(lockedoutUserLogin)
                    .enterPassword(passwordForAllUsers)
                    .clickLoginButton();
        });
        step("Check error message", () -> {
            errorMessagePage.checkErrorMessage(errorMessageLockedOut);
        });
    }


    @ValueSource(
            strings = {"best_user", "old_user"}
    )

    @ParameterizedTest(name = "Failed authorization with non-existent username {0}")
    @Tag("login")
    @Tag("negative")
    @DisplayName("Failed authorization of non-existent user")
    void failedLoginOfNonexistentUserTest(String username) {
        step("Fill out authorization form with incorrect username", () -> {
            loginPage.enterUsername(username)
                    .enterPassword(passwordForAllUsers)
                    .clickLoginButton();
        });
        step("Check error message", () -> {
            errorMessagePage.checkErrorMessage(errorMessageNoSuchUser);
        });
    }
}
