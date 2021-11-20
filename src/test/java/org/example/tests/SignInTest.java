package org.example.tests;

import org.example.entities.AccountData;
import org.example.tests.base.TestBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SignInTest extends TestBase {
    public AccountData currentUser;

    @Before
    public void init() {
        setUp();
        currentUser = new AccountData("trofimovdanil946@gmail.com", "Hello123");
    }

    @Test
    public void signIn() {
        // Arrange
        String expectedUrl = "https://todo--spring--boot.herokuapp.com/main";
        // Act
        auth(currentUser);
        // Assert
        Assert.assertEquals( expectedUrl, getCurrentUrl());
    }
}
