package com.demowebshop.fw;

import com.demowebshop.core.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemHelper extends BaseHelper {

    public ItemHelper(WebDriver driver) {
        super(driver);
    }

    public void addLaptopToCart() {
        click(By.xpath("//h2[@class='product-title']/a[text()='14.1-inch Laptop']/ancestor::div[@class='details']//input[@value='Add to cart']"));
    }

    public void openCart() {
        click(By.cssSelector("[href='/cart']"));
    }

    public boolean isItemInCart() {
        return isElementPresent(By.cssSelector(".product-name"));
    }
}