package org.example.tests.base;

import org.example.entities.TodoItem;

public class TodoEntityTest extends AuthBase {

    public void createTodo(TodoItem todo) {
        navigationHelper.visitPage("main");
        todoHelper.createTodo(todo);
    };

    public void deleteTodo() {
        navigationHelper.visitPage("main");
        todoHelper.deleteTodo();
    }
}
