package com.qa67el.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BaseHelper {

    WebDriver driver;

    public BaseHelper(WebDriver driver) {
        this.driver = driver;
    }
    public void click(By locator) {
        driver.findElement(locator).click();
    }
    public void type(By locator, String text) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }
    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }
    public boolean isHomeComponentPresent() {
        return isElementPresent(By.cssSelector("[href='/register']"));
    }

}
