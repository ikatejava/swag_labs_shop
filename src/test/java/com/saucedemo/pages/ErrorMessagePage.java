package com.saucedemo.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ErrorMessagePage {
    SelenideElement
            errorMessage = $(".error-message-container");

    public void checkErrorMessage(String message) {

        errorMessage.shouldBe(visible).shouldHave(text(message));
    }
}
