package org.example.tests;
import org.example.AppManager;
import org.example.entities.AccountData;
import org.example.entities.TodoItem;
import org.example.helpers.LoginHelper;
import org.example.helpers.NavigationHelper;
import org.example.helpers.TodoHelper;

public class TestBase {
    protected static AppManager appManager;
    protected NavigationHelper navigationHelper;
    protected LoginHelper loginHelper;
    protected TodoHelper todoHelper;

    static {
        appManager = new AppManager();
    };

    public void setUp() {
        this.navigationHelper = appManager.getNavigationHelper();
        this.loginHelper = appManager.getLoginHelper();
        this.todoHelper = appManager.getTodoHelper();
    };

    public void auth(AccountData user) {
        navigationHelper.visitPage("sign-in");
        loginHelper.auth(user);
    };

    public void createTodo(TodoItem todo) {
        navigationHelper.visitPage("main");
        todoHelper.createTodo(todo);
    };

    public void deleteTodo() {
        navigationHelper.visitPage("main");
        todoHelper.deleteTodo();
    }

    public TodoItem find(String todoText) {

    }

    public void destruct() {
        appManager.destruct();
    }
}
