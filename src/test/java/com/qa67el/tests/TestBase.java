package com.qa67el.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
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
        return isElementPresent(By.cssSelector("[href='/register']"));
    }

    public boolean isElementPresent(By locator){
        return driver.findElements(locator).size() > 0;
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    public void type(By locator, String text) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public boolean isAlertPresent() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.alertIsPresent());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void fillLoginRegisterForm(String firstName, String lastName, String password, String confirmPassword) {
        type(By.name("FirstName"), firstName);
        type(By.name("LastName"), lastName);
        type(By.name("Password"), password);
        type(By.name("ConfirmPassword"), confirmPassword);
    }

    public void clickOnRegisterLink() {
        click(By.cssSelector("[href='/register']"));
    }
}