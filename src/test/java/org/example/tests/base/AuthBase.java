package org.example.tests.base;

import org.example.entities.AccountData;

public class AuthBase extends TestBase {
    public void auth(AccountData user) {
        this.navigationHelper.visitPage("sign-in");
        this.loginHelper.login(user);
    };
}
