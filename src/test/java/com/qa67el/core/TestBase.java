package com.qa67el.core;

import com.demowebshop.core.ApplicationManager;
import org.openqa.selenium.remote.Browser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.Arrays;


public class TestBase {

    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser", Browser.CHROME.browserName()));

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod
    //@BeforeSuite
    public void setUp(Method method, Object[] p)  {
        app.init();
        logger.info("Start test {} with data: {}", method.getName(), Arrays.asList(p));
    }

    @AfterMethod
    //@AfterSuite
    public void tearDown(ITestResult result) {
        if(result.isSuccess()) {
            logger.info("PASSED: {}", result.getMethod().getMethodName());
        } else {
            logger.error("FAILD: {}. Screenshot - > {}", result.getMethod().getMethodName(),
                    app.getUser().takeScreenshot());
        }
        logger.info("Stop test");
        logger.info("*****************************");
        app.stop();
    }
}