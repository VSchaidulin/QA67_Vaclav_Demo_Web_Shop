package com.qa67el.tests;

import com.qa67el.core.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @Test
    public void loginPositiveTest() {

        app.getUser().login("vaclav2026@gmx.de", "Aa12345!");

        Assert.assertTrue(app.getUser().isUserLoggedIn());
    }
    @Test
    public void loginNegativeTest() {

        app.getUser().login("wrong@mail.com", "12345");

        Assert.assertFalse(app.getUser().isUserLoggedIn());
    }
}
