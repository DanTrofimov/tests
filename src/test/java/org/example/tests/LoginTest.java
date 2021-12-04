package org.example.tests;

import org.example.entities.AccountData;
import org.example.tests.base.TestBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LoginTest extends TestBase {
    public AccountData currentUser;

    @Before
    public void init() {
        setUp();
        currentUser = new AccountData("trofimovdanil946@gmail.com", "Hello123");
    }

    @Test
    public void loginWithValidData() {
        // Arrange
        String expectedUrl = "https://todo--spring--boot.herokuapp.com/main";
        // Act
        auth(currentUser);
        // Assert
        Assert.assertEquals( expectedUrl, getCurrentUrl());
    }

    @Test
    public void loginWithInvalidData() {
        // Arrange
        String expectedUrl = "https://todo--spring--boot.herokuapp.com/main";
        // Act
        currentUser = new AccountData("qwerty@gmail.com", "123123");
        auth(currentUser);
        // Assert
        Assert.assertNotEquals( expectedUrl, getCurrentUrl());
    }
}
