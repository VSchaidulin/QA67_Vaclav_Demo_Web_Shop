package com.qa67el.tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class CreateAccountRegisterTests extends TestBase {
    @Test(enabled = false)
    public void newUserRegisterPositiveTest(){
        int i = (int) ((System.currentTimeMillis()/1000)%3600); //für Homework
        //click on Register link
        click(By.cssSelector("[href='/register']"));

        //enter First name
        click(By.name("FirstName"));
        driver.findElement(By.name("FirstName")).clear();
        driver.findElement(By.name("FirstName")).sendKeys("Wasja");

        //enter Last name
        click(By.name("LastName"));
        driver.findElement(By.name("LastName")).clear();
        driver.findElement(By.name("LastName")).sendKeys("Pipetkin");

        //enter Email
        type(By.name("Email"), "vaclav2026" + i + "@gmx.de");
        //driver.findElement(By.name("Email")).sendKeys("vaclav2026@gmx.de");   //для однократного запуска при написании

        //enter Password
        click(By.name("Password"));
        driver.findElement(By.name("Password")).clear();
        driver.findElement(By.name("Password")).sendKeys("Aa12345!");

        //enter Confirm password
        click(By.name("ConfirmPassword"));
        driver.findElement(By.name("ConfirmPassword")).clear();
        driver.findElement(By.name("ConfirmPassword")).sendKeys("Aa12345!");

        //click on Register button
        click(By.name("register-button"));

        //assert SigOut button is present
        Assert.assertTrue(isElementPresent(By.id("#register-button")));

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
        //click on Register link
        click(By.cssSelector("[href='/register']"));

        //enter First name
        click(By.name("FirstName"));
        driver.findElement(By.name("FirstName")).clear();
        driver.findElement(By.name("FirstName")).sendKeys("Wasja");

        //enter Last name
        click(By.name("LastName"));
        driver.findElement(By.name("LastName")).clear();
        driver.findElement(By.name("LastName")).sendKeys("Pipetkin");

        //enter Email
        type();

        //enter Password
        click(By.name("Password"));
        driver.findElement(By.name("Password")).clear();
        driver.findElement(By.name("Password")).sendKeys("Aa12345!");

        //enter Confirm password
        click(By.name("ConfirmPassword"));
        driver.findElement(By.name("ConfirmPassword")).clear();
        driver.findElement(By.name("ConfirmPassword")).sendKeys("Aa12345!");

        //click on Register button
        click(By.name("register-button"));

        //assert alert appears
        //Assert.assertTrue(isAlertPresent());


    }

    public void type() {
        click(By.name("Email"));
        driver.findElement(By.name("Email")).clear();
        driver.findElement(By.name("Email")).sendKeys("vaclav2026@gmx.de");
    }

    public boolean isAlertPresent() {
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.alertIsPresent());
        if (alert == null) {
            return false;
        } else {
            return true;
        }
    }
}
