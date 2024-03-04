package com.phonebook.tests;

import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {
        if(!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
    }

    @Test
    public void creteExistedAccountNegativeTest(){
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User()
                .setEmail("amir@mir.com")
                .setPassword("Amirmir8$"));
        app.getUser().clickOnRegistrationButton();
        // assert Sign Out button is present
        Assert.assertTrue(app.getUser().isAlertAppears());
    }

}
