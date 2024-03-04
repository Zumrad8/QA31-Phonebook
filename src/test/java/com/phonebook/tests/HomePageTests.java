package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;

public class HomePageTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        if(!app.getHomePage().isHomeComponentPresent()){
            clickOnHomeLink();
        }

    }

    public void clickOnHomeLink() {
        app.getHomePage().click(By.cssSelector("[href='/home']"));
    }


}
