package org.example.tests;

import org.example.entities.AccountData;
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
        auth(currentUser);
    }
}
