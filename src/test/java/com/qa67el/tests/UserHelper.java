package com.qa67el.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper{

    public UserHelper(WebDriver driver) {
        super(driver);
    }
    public void register (String firstName, String lastName, String email, String password) {

        click(By.cssSelector("[href='/register']"));
        click(By.id("gender-male"));
        type(By.name("FirstName"), firstName);
        type(By.name("LastName"), lastName);
        type(By.name("Email"), email);
        type(By.name("Password"), password);
        type(By.name("ConfirmPassword"), password);

        click(By.id("register-button"));
    }
    public boolean isRegistrationSucces() {
        return isElementPresent(By.cssSelector("result"));
    }
}
