package com.saucedemo.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SidebarMenuPage {
    SelenideElement
            hamburgerMenu = $("#react-burger-menu-btn"),
            logoutButton = $("#logout_sidebar_link"),
            resetButton = $("#reset_sidebar_link");

    public SidebarMenuPage openHamburgerMenu() {
        hamburgerMenu.shouldBe(interactable);
        hamburgerMenu.click();
        return this;
    }

    public void clickLogoutButton() {
        logoutButton.shouldBe(interactable);
        logoutButton.click();
    }

    public void clickResetButton() {
        resetButton.shouldBe(interactable);
        resetButton.click();
    }
}
