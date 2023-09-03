package com.saucedemo.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CheckoutPage {
    SelenideElement
            productCartName = $(".inventory_item_name"),
            productCartPrice = $(".inventory_item_price"),
            finishButton = $("#finish");

    public CheckoutPage checkProductTitleInTheCart(String productTitle) {
        productCartName.shouldBe(visible).shouldHave(text(productTitle));
        return this;
    }

    public void checkProductPriceInTheCart(String productPrice) {
        productCartPrice.shouldBe(visible).shouldHave(text(productPrice));
    }

    public void clickFinishButton() {
        finishButton.click();
    }
}
