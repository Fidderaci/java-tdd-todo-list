package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.time.*;

public class ToDoListTest {

    @Test
    public void getTaskByUniqueId() {
        ToDoList list = new ToDoList();
        list.addTask("Clean room");

        Task foundTask = list.getTaskById(1);

        Assertions.assertNotNull(foundTask);
        Assertions.assertEquals("Clean room", foundTask.getName());
        Assertions.assertEquals(1, foundTask.getId());
    }

    @Test
    public void updateNameById() {
        ToDoList list = new ToDoList();
        list.addTask("Clean room");

        boolean result = list.updateName(1, "Wash car");

        Assertions.assertTrue(result);

        Task foundTask = list.getTaskById(1);
        Assertions.assertEquals("Wash car", foundTask.getName());
    }

    @Test
    public void changeStatusById() {
        ToDoList list = new ToDoList();
        list.addTask("Clean room");

        boolean result = list.changeStatusById(1);

        Assertions.assertTrue(result);

        Task foundTask = list.getTaskById(1);
        Assertions.assertTrue(foundTask.isComplete());
    }

    @Test
    public void seeDateAndTimeOfTask() {
        ToDoList list = new ToDoList();
        list.addTask("Clean room");

        Task task = list.getTaskById(1);

        LocalDateTime time = LocalDateTime.now();

        Assertions.assertNotNull(task.getCreatedAt());
        Assertions.assertEquals(time.getYear(), task.getCreatedAt().getYear());
        Assertions.assertEquals(time.getMinute(), task.getCreatedAt().getMinute());
    }
}
