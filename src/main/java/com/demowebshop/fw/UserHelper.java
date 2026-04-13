package com.demowebshop.fw;

import com.demowebshop.core.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper {

    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public void register(String firstName, String lastName, String email, String password) {

        click(By.cssSelector("[href='/register']"));

        click(By.id("gender-male"));

        type(By.name("FirstName"), firstName);
        type(By.name("LastName"), lastName);
        type(By.name("Email"), email);
        type(By.name("Password"), password);
        type(By.name("ConfirmPassword"), password);

        click(By.id("register-button"));
    }

    public boolean isRegistrationSuccess() {
        return isElementPresent(By.className("result"));
    }

    public boolean isRegistrationError() {
        return isElementPresent(By.cssSelector(".validation-summary-errors"));
    }

    public void login(String email, String password) {
        click(By.cssSelector("[href='/login']"));
        type(By.id("Email"), email);
        type(By.id("Password"), password);
        click(By.cssSelector("input[value='Log in']"));
    }
    public boolean isHomeComponentPresent() {
        return isElementPresent(By.cssSelector("[href='/register']"));
    }
    public boolean isUserLoggedIn() {
        return isElementPresent(By.cssSelector("[href='/logout']"));
    }
}