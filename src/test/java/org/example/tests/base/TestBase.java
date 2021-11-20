package org.example.tests.base;
import org.example.AppManager;
import org.example.entities.AccountData;
import org.example.entities.TodoItem;
import org.example.helpers.FindItemsHelper;
import org.example.helpers.LoginHelper;
import org.example.helpers.NavigationHelper;
import org.example.helpers.TodoHelper;

public class TestBase {
    protected static AppManager appManager;
    protected NavigationHelper navigationHelper;
    protected LoginHelper loginHelper;
    protected TodoHelper todoHelper;
    protected FindItemsHelper findItemsHelper;

    static {
        appManager = new AppManager();
    };

    public void setUp() {
        this.navigationHelper = appManager.getNavigationHelper();
        this.loginHelper = appManager.getLoginHelper();
        this.todoHelper = appManager.getTodoHelper();
        this.findItemsHelper = appManager.getFindItemsHelper();
    };

    public void auth(AccountData user) {
        navigationHelper.visitPage("sign-in");
        loginHelper.auth(user);
    };

    public boolean hasItemByText(String text) {
        return findItemsHelper.hasElementByText(text);
    }

    public String getCurrentUrl() {
        return navigationHelper.getCurrentUrl();
    }

    public void destruct() {
        appManager.destruct();
    }
}