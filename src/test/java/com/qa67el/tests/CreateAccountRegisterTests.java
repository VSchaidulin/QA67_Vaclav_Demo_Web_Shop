package com.qa67el.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountRegisterTests extends TestBase {

    @Test
    public void newUserRegisterPositiveTest(){
        int i = (int) ((System.currentTimeMillis()/1000)%3600);

        String email = "vaclav2026" + System.currentTimeMillis() + "@gmx.de";

        app.getUser().register("Wasja", "Pipetkin", email, "Aa12345!");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertTrue(
                app.getBase().isElementPresent(By.className("result"))
        );


    }

    @Test
    public void existedUserRegisterNegativeTest(){

        app.getUser().register("Wasja", "Pipetkin", "vaclav2026@gmx.de", "Aa12345!");

        Assert.assertTrue(
                app.getBase().isElementPresent(By.cssSelector(".validation-summary-errors"))
        );
    }
}