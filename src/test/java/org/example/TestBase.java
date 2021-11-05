package org.example;
import org.example.entities.AccountData;
import org.example.entities.TodoItem;
import org.example.helpers.LoginHelper;
import org.example.helpers.NavigationHelper;
import org.example.helpers.TodoHelper;

public class TestBase {
    protected AppManager appManager;
    protected NavigationHelper navigationHelper;
    protected LoginHelper loginHelper;
    protected TodoHelper todoHelper;

    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
        this.appManager = new AppManager();
        this.navigationHelper = this.appManager.getNavigationHelper();
        this.loginHelper = this.appManager.getLoginHelper();
        this.todoHelper = this.appManager.getTodoHelper();
    };

    public void auth(AccountData user) {
        navigationHelper.visitPage("sign-in");
        loginHelper.auth(user);
    };

    public void createTodo(TodoItem todo) {
        navigationHelper.visitPage("main");
        todoHelper.createTodo(todo);
    };
}
