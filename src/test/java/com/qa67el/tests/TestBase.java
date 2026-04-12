package com.qa67el.tests;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {

    ApplicationManager app = new ApplicationManager();

    @BeforeMethod
    public void setUp() {
        app.init();
    }
    @AfterMethod
    public void tearDown() {
        app.stop();
    }
}