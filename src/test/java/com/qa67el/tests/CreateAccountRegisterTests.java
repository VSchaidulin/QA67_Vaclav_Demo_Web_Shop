package com.qa67el.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CreateAccountRegisterTests extends TestBase {

    @Test(enabled = false)
    public void newUserRegisterPositiveTest(){
        int i = (int) ((System.currentTimeMillis()/1000)%3600); //für Homework
        clickOnRegisterLink();
        fillLoginRegisterForm("FirstName", "LastName", "Password", "ConfirmPassword");
        type(By.name("Email"), "vaclav2026" + i + "@gmx.de");
        click(By.name("register-button"));
        Assert.assertTrue(isSingnButton());

    }


    @Test
    public void existedUserRegisterNegativeTest(){
        clickOnRegisterLink();
        fillLoginRegisterForm("FirstName", "LastName", "Password", "ConfirmPassword");
        click(By.name("register-button"));
        type();
        

    }

}