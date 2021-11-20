package org.example.tests;

import org.example.entities.AccountData;
import org.example.entities.TodoItem;
import org.example.tests.base.TodoEntityTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DeleteTestEntity extends TodoEntityTest {
    public AccountData currentUser;

    @Before
    public void init() {
        setUp();
        currentUser = new AccountData("trofimovdanil946@gmail.com", "Hello123");
    }

    @Test
    public void deleteTodoItem() {
        // Arrange
        String todoText = "example text " + Math.random();
        TodoItem todo = new TodoItem(todoText);
        // Act
        auth(currentUser);
        createTodo(todo);
        deleteTodo();
        // Assert
        Assert.assertFalse(hasItemByText(todoText));
    }
}
