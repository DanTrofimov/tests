package org.example.helpers;

import org.example.AppManager;
import org.example.entities.AccountData;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import java.util.HashMap;

public class LoginHelper extends HelperBase {
    public HashMap<String, Boolean> loggedMap = new HashMap<>();

    public LoginHelper(AppManager appManager) {
        this.appManager = appManager;
        this.driver = appManager.getDriver();
    }

    public void login(AccountData user) {
        if (!loggedMap.containsKey(user.email) || !loggedMap.get(user.email)) {
            loggedMap.put(user.email, true);
            driver.manage().window().setSize(new Dimension(1536, 824));
            driver.findElement(By.id("email")).click();
            driver.findElement(By.id("email")).sendKeys(user.email);
            driver.findElement(By.id("password")).sendKeys(user.password);
            driver.findElement(By.cssSelector(".send-button")).click();
        }
    };

    public void logout(AccountData user) {
        if (loggedMap.containsKey(user.email) && loggedMap.get(user.email)) {
            driver.get(appManager.getBaseUrl() + "/main");
            driver.findElement(By.cssSelector(".sign-out-button")).click();
        }
    }
}
