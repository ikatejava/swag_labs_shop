package com.saucedemo.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class PersonalInfoPage {
    SelenideElement
            firstNameField = $("#first-name"),
            lastNameField = $("#last-name"),
            zipCodeField = $("#postal-code"),
            continueButton = $("#continue");

    public PersonalInfoPage enterFirstName(String userName) {
        firstNameField.setValue(userName);
        return this;
    }

    public PersonalInfoPage enterLastName(String lastName) {
        lastNameField.setValue(lastName);
        return this;
    }

    public void enterZipCode(String zipCode) {
        zipCodeField.setValue(zipCode);
    }

    public void clickContinueButton() {
        continueButton.click();
    }
}
