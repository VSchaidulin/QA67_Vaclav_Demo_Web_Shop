package com.qa67el.tests;

import com.qa67el.core.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {
    @Test
    public void isHomeComponentPresentTest(){
        //System.out.println("Home component is " + isHomeComponentPresent());
        Assert.assertTrue(app.getUser().isHomeComponentPresent());

    }
}
