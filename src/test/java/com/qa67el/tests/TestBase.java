package com.qa67el.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public boolean isHomeComponentPresent(){
        return driver.findElements(By.xpath("//*[@href='/register']")).size()>0;
    }

    public boolean isElementPresent(By locator){
        return driver.findElements(locator).size()>0;
    }

    @AfterMethod(enabled = false)
    public void tearDown(){
        driver.quit();
    }

    public void type(By locator, String text) {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);   //für Homework для многократного запуска
    }

    public void click(By locator) {
        driver.findElement(locator).click();
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

    public void type() {
        click(By.name("Email"));
        driver.findElement(By.name("Email")).clear();
        driver.findElement(By.name("Email")).sendKeys("vaclav2026@gmx.de");
    }
}
