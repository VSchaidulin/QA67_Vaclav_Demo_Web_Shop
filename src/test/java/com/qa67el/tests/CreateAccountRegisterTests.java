package com.qa67el.tests;

import com.qa67el.core.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountRegisterTests extends TestBase {


    @Test
    public void newUserRegisterPositiveTest() {
        String email = "vaclav" + System.currentTimeMillis() + "@gmx.de";

        app.getUser().register("Wasja", "Pipetkin", email, "Aa12345!");

        Assert.assertTrue(app.getUser().isRegistrationSuccess());
    }

    @Test
    public void existedUserRegisterNegativeTest() {

        app.getUser().register("Wasja", "Pipetkin", "vaclav2026@gmx.de", "Aa12345!");

        Assert.assertTrue(app.getUser().isRegistrationError());
    }
}