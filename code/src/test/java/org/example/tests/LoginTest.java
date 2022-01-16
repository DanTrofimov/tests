package org.example.tests;

import org.example.entities.AccountData;
import org.example.tests.base.AuthBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LoginTest extends AuthBase {
    public AccountData currentUser;

    @Before
    public void init() {
        setUp();
        currentUser = new AccountData(config.email, config.password);
    }

    @Test
    public void loginWithValidData() {
        // Arrange
        String expectedUrl = config.baseUrl + "main";
        // Act
        auth(currentUser);
        // Assert
        Assert.assertEquals( expectedUrl, getCurrentUrl());
    }

    @Test
    public void loginWithInvalidData() {
        // Arrange
        String expectedUrl = config.baseUrl + "main";
        // Act
        currentUser = new AccountData(config.invalidEmail, config.invalidPassword);
        auth(currentUser);
        // Assert
        Assert.assertNotEquals( expectedUrl, getCurrentUrl());
    }
}
