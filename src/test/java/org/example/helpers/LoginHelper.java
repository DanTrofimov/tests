package org.example.helpers;

import org.example.AppManager;
import org.example.entities.AccountData;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

public class LoginHelper extends HelperBase {
    public LoginHelper(AppManager appManager) {
        this.appManager = appManager;
        this.driver = appManager.getDriver();
    }

    public void auth(AccountData user) {
        driver.manage().window().setSize(new Dimension(1536, 824));
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).sendKeys(user.email);
        driver.findElement(By.id("password")).sendKeys(user.password);
        driver.findElement(By.cssSelector(".send-button")).click();
    };
}
