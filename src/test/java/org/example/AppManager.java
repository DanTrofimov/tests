package org.example;

import org.example.helpers.LoginHelper;
import org.example.helpers.NavigationHelper;
import org.example.helpers.TodoHelper;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppManager {
    private ChromeDriver driver;
    private String baseUrl;

    // helpers
    private NavigationHelper navigationHelper;
    private LoginHelper loginHelper;
    private TodoHelper todoHelper;

    public AppManager() {
        this.driver = new ChromeDriver();
        this.baseUrl = "https://todo--spring--boot.herokuapp.com/";
        this.navigationHelper = new NavigationHelper(this);
        this.loginHelper = new LoginHelper(this);
        this.todoHelper = new TodoHelper(this);
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public LoginHelper getLoginHelper() {
        return loginHelper;
    }

    public TodoHelper getTodoHelper() {
        return todoHelper;
    }

    public ChromeDriver getDriver() {
        return driver;
    }

    public String getBaseUrl() {
        return baseUrl;
    }
}
