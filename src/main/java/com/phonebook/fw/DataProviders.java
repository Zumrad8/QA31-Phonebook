package com.phonebook.fw;

import com.phonebook.models.Contact;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

    @org.testng.annotations.DataProvider
    public Iterator<Object[]> addContact() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Oliver", "Kan", "1234567890","kan@gm.com", "Berlin", "goalkeeper"});
        list.add(new Object[]{"Oliver1", "Kan1", "1234567890","kan@gm.com", "Berlin", "goalkeeper"});
        list.add(new Object[]{"Oliver2", "Kan2", "1234567890","kan@gm.com", "Berlin", "goalkeeper"});
        return list.iterator();
    }
    @org.testng.annotations.DataProvider
    public Iterator<Object[]> addContactFromCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(("src/test/resources/contact.csv")));

        String line = reader.readLine();
        while (line != null) {

            String[] split = line.split(",");

            list.add(new Object[]{new Contact().setName(split[0])
                    .setLastname(split[1]).setPhone(split[2])
                    .setEmail(split[3]).setAddress(split[4]).setDescription(split[5])});
            line = reader.readLine();
        }
        return list.iterator();
    }
}
