package org.example.helpers;

import org.example.AppManager;

public class NavigationHelper extends HelperBase {
    private String baseUrl;

    public NavigationHelper(AppManager appManager) {
        this.driver = appManager.getDriver();
        this.baseUrl = appManager.getBaseUrl();
    }

    public void visitPage(String pageUrl) {
        this.driver.get(this.baseUrl + pageUrl);
    }

    public String getCurrentUrl() {
        return this.driver.getCurrentUrl();
    }
}
