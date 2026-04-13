package com.qa67el.tests;

import com.qa67el.core.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ItemTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        app.getUser().login("vaclav2026@gmx.de", "Aa12345!");
    }

    @Test
    public void addItemToCartTest() {

        app.getItem().addLaptopToCart();
        app.getItem().openCart();

        Assert.assertTrue(app.getItem().isItemInCart());
    }
}