package org.example.generator;

import org.example.entities.TodoItem;

public class EntityMocker {
    public static String mockStringField() {
        return "mocked data " + Math.random();
    }

    public static Object mockEntity(String entityType) {
        switch (entityType) {
            case "t":
                return new TodoItem(mockStringField());
            default:
                // still have only one usable entity
                return new TodoItem(mockStringField());
        }
    };
}
