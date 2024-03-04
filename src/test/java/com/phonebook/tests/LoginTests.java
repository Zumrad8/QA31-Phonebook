package com.phonebook.tests;

import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
    @BeforeMethod
    public void ensurePrecondition() {
        // if Login Link is not present
        if(!app.getUser().isLoginLinkPresent()) {
            // click on Sign Out button
            app.getUser().clickOnSignOutButton();
        }
    }

    @Test (priority = 1)
    public void loginPositiveTest(){
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User()
                .setEmail("amir@mir.com")
                .setPassword("Amirmir8$"));
        app.getUser().clickOnLoginButton();
        //assert Sign Out is present
        Assert.assertTrue(app.getUser().isSignOutButtonPresent());
    }
    @Test (priority = 2)
    public void loginNegativeTestWithoutEmail() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User()
                .setPassword("Amirmir8$"));
        app.getUser().clickOnLoginButton();
        //assert Sign Out is present
        Assert.assertTrue(app.getUser().isAlertAppears());
    }

}
