package com.qa67el.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountRegisterTests extends TestBase {

    @Test
    public void newUserRegisterPositiveTest(){
        int i = (int) ((System.currentTimeMillis()/1000)%3600);

        clickOnRegisterLink();

        fillLoginRegisterForm("Wasja", "Pipetkin", "Aa12345!", "Aa12345!");
        type(By.name("Email"), "vaclav2026" + i + "@gmx.de");

        click(By.id("register-button"));

        Assert.assertTrue(isElementPresent(By.className("result")));
    }

    @Test
    public void existedUserRegisterNegativeTest(){
        clickOnRegisterLink();

        fillLoginRegisterForm("Wasja", "Pipetkin", "Aa12345!", "Aa12345!");
        type(By.name("Email"), "vaclav2026@gmx.de");

        click(By.id("register-button"));

        Assert.assertTrue(
                isElementPresent(By.cssSelector(".validation-summary-errors"))
        );
    }
}