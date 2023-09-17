package com.saucedemo.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class FinalPage {
    SelenideElement
            conclusionText = $("#checkout_complete_container"),
            backHomeButton = $("#back-to-products");

    public FinalPage checkTextElementsToBePresent(String thankYouText, String orderInformation) {
        conclusionText.shouldBe(visible).shouldHave(text(thankYouText))
                .shouldHave(text(orderInformation));
        return this;
    }

    public void checkBackHomeButtonPresence() {
        backHomeButton.shouldBe(visible).shouldBe(interactable);
    }

    public void clickBackHomeButton() {
        backHomeButton.click();
    }
}
