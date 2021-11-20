package org.example.tests;

import org.example.entities.AccountData;
import org.example.entities.TodoItem;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DeleteTestEntity extends TestBase {
    public AccountData currentUser;

    @Before
    public void init() {
        setUp();
        currentUser = new AccountData("trofimovdanil946@gmail.com", "Hello123");
    }

    @Test
    public void deleteTodoItem() {
        TodoItem todo = new TodoItem("example text");
        auth(currentUser);
        createTodo(todo);
        deleteTodo();
    }
}
