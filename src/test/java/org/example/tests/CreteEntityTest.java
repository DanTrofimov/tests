package org.example.tests;

import org.example.entities.AccountData;
import org.example.entities.TodoItem;
import org.example.generator.GenerateData;
import org.example.tests.base.TodoEntityTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedHashMap;
import java.util.stream.Stream;

public class CreteEntityTest extends TodoEntityTest {
    public static GenerateData<TodoItem> generateData = new GenerateData<>();
    public static AccountData currentUser;

    public static Stream<Arguments> getGeneratedData() {
        String sourceFile = "todo.xml";
        generateData.handleEntity("t", sourceFile);
        return Stream.of(Arguments.of(generateData.getEntity(sourceFile)));
    }

    @BeforeEach
    public void init() {
        setUp();
        currentUser = new AccountData(config.email, config.password);
    }

    @ParameterizedTest
    @MethodSource("getGeneratedData")
    // JUnit can't convert map -> TodoItem, do it by urself
    public void createTodoItem(LinkedHashMap generatedData) {
        TodoItem todo = new TodoItem((String) generatedData.get("text"));
        auth(currentUser);
        createTodo(todo);

        Assertions.assertTrue(hasItemByText(todo.text));
    }
}
