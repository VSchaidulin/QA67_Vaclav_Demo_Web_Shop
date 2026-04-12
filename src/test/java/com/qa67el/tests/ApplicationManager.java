package com.qa67el.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ApplicationManager {

    WebDriver driver;
    BaseHelper base;
    UserHelper user;


     public void init() {
         driver = new ChromeDriver();
         driver.get("https://demowebshop.tricentis.com/");
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         base = new BaseHelper(driver);
         user = new UserHelper(driver);

     }
     public void stop() {
         driver.quit();
     }
     public WebDriver getDriver() {
         return driver;
     }

    public BaseHelper getBase() {
        return base;
    }

    public UserHelper getUser() {
        return user;
    }
}
