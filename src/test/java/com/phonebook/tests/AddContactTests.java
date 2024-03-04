package com.phonebook.tests;

import com.phonebook.fw.DataProviders;
import com.phonebook.models.Contact;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.DataInput;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AddContactTests extends TestBase{

    // precondition
    @BeforeMethod
    public void precondition(){
        // if Login Link is not present
        if(!app.getUser().isLoginLinkPresent()) {
            // click on Sign Out button
            app.getUser().clickOnSignOutButton();
        }
        // click on Login link
        app.getUser().clickOnLoginLink();
        // enter email
        app.getUser().fillLoginRegisterForm(new User()
                .setEmail("amir@mir.com")
                .setPassword("Amirmir8$"));
        // click on the Login button
        app.getUser().clickOnLoginButton();
    }





    @AfterMethod
    public void postCondition(){
        // click on the card
        app.getContact().removeContact();
    }

    @DataProvider
    public Iterator<Object[]> addContact() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Oliver", "Kan", "1234567890","kan@gm.com", "Berlin", "goalkeeper"});
        list.add(new Object[]{"Oliver1", "Kan1", "1234567890","kan@gm.com", "Berlin", "goalkeeper"});
        list.add(new Object[]{"Oliver2", "Kan2", "1234567890","kan@gm.com", "Berlin", "goalkeeper"});
        return list.iterator();
    }
    @Test(dataProvider = "addContact", dataProviderClass = DataProviders.class)
    public void addContactPositiveTestFromDataProvider(String name, String lastname, String phone, String email, String address, String desc) {
        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(new Contact()
                .setName(name)
                .setLastname(lastname)
                .setEmail(email)
                .setPhone(phone)
                .setAddress(address)
                .setDescription(desc));
        // click on the Save button
        app.getContact().clickOnSaveButton();
        // assert Contact is added by text
        Assert.assertTrue(app.getContact().isContactCreateByTet(name));
    }



    @Test(dataProvider = "addContactFromCSV", dataProviderClass = DataProviders.class)
    public void addContactPositiveTestFromDataProviderWithFile (Contact contact) {
        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(contact);

        // click on the Save button
        app.getContact().clickOnSaveButton();
        // assert Contact is added by text
        Assert.assertTrue(app.getContact().isContactCreateByTet(contact.getName()));
    }
    }

