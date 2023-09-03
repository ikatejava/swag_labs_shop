package com.saucedemo.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    SelenideElement
            usernameField = $("#user-name"),
            passwordField = $("#password"),
            loginButton = $("#login-button");

    public LoginPage enterUsername(String username) {
        usernameField.setValue(username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        passwordField.setValue(password);
        return this;
    }

    public void clickLoginButton() {
        loginButton.click();
    }
}
