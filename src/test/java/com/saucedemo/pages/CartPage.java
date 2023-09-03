package com.saucedemo.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CartPage {
    SelenideElement

            productCartName = $(".inventory_item_name"),
            continueShoppingButton = $("#continue-shopping"),
            checkoutButton = $("#checkout");

    public void checkCartIsEmpty() {
        productCartName.shouldNotBe(visible);
    }

    public void clickContinueShoppingButton() {
        continueShoppingButton.click();
    }

    public void clickCheckoutButton() {
        checkoutButton.click();
    }
}
