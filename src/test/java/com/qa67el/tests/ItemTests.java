package com.qa67el.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ItemTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        // login
        click(By.cssSelector("[href='/login']"));
        type(By.id("Email"), "vaclav2026@gmx.de");
        type(By.id("Password"), "Aa12345!");
        click(By.cssSelector("input[value='Log in']"));
    }

    @Test
    public void addItemToCartTest() {

        // клик по второй кнопке Add to cart
        click(By.xpath("(//input[@value='Add to cart' and @type='button'])[2]"));

        // переход в корзину
        click(By.cssSelector("[href='/cart']"));

        // проверка, что товар добавлен (по имени)
        Assert.assertTrue(
                isElementPresent(By.cssSelector(".product-name"))
        );
    }
}