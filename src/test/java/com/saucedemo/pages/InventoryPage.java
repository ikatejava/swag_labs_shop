package com.saucedemo.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;

public class InventoryPage {
    SelenideElement
            subtitleText = $(".title"),
            itemsToBuy = $(".inventory_list"),
            cartIcon = $(".shopping_cart_link");

    public InventoryPage checkSubtitle(String productsText) {
        subtitleText.shouldHave(text(productsText));
        return this;
    }

    public void checkPresenceOfProducts() {
        itemsToBuy.shouldBe(visible);
    }

    public void clickAddToCart(String productAddToCart) {
        $(byName(productAddToCart)).shouldBe(visible).click();
    }

    public void clickCartIcon() {
        cartIcon.click();
    }
}
