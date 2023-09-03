package com.saucedemo.pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;

public class RemoveFromCartPage {
    public void clickRemoveFromCart(String productRemoveFromCart) {
        $(byName(productRemoveFromCart)).shouldBe(visible).click();
    }
}
