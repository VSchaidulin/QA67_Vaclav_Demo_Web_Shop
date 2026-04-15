package com.qa67el.core;

import com.demowebshop.core.ApplicationManager;
import org.openqa.selenium.remote.Browser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class TestBase {

    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser", Browser.CHROME.browserName()));

    //Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod
    //@BeforeSuite
    public void setUp() {
        app.init();
    }

    @AfterMethod
    //@AfterSuite
    public void tearDown() {
        app.stop();
    }
}