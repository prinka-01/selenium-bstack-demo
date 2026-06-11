package com.bstackdemo.automation.utils;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "invalidLoginData")
    public Object[][] invalidData() {

        return new Object[][] {

                {"invalid_user1", "wrongpass1"},
                {"invalid_user2", "wrongpass2"},
                {"userlocked", "pass123"},
                {"testuser", "invalidpass"},
                {"dummyuser", "dummypass"}
        };
    }
}