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

    public boolean isSingnButton() {
        return isElementPresent(By.id("#register-button"));
    }

    public void fillLoginRegisterForm(String firstName, String lastName, String password, String confirmPassword) {
        click(By.name(firstName));
        driver.findElement(By.name(firstName)).clear();
        driver.findElement(By.name(firstName)).sendKeys("Wasja");
        click(By.name(lastName));
        driver.findElement(By.name(lastName)).clear();
        driver.findElement(By.name(lastName)).sendKeys("Pipetkin");
        click(By.name(password));
        driver.findElement(By.name(password)).clear();
        driver.findElement(By.name(password)).sendKeys("Aa12345!");
        click(By.name(confirmPassword));
        driver.findElement(By.name(confirmPassword)).clear();
        driver.findElement(By.name(confirmPassword)).sendKeys("Aa12345!");
    }

    public void clickOnRegisterLink() {
        clickOnRegistrationButton();
    }

    public void clickOnRegistrationButton() {
        click(By.cssSelector("[href='/register']"));
    }

    public void type(By locator, String Text) {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(By.name("email")).sendKeys(Text);   //für Homework для многократного запуска
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    @Test
    public void existedUserRegisterNegativeTest(){
        clickOnRegisterLink();
        fillLoginRegisterForm("FirstName", "LastName", "Password", "ConfirmPassword");
        click(By.name("register-button"));
        type();
        

    }

    public void type() {
        click(By.name("Email"));
        driver.findElement(By.name("Email")).clear();
        driver.findElement(By.name("Email")).sendKeys("vaclav2026@gmx.de");
    }

}