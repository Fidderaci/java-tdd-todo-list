package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

class TodoListTest {
    @Test
    public void testAddTask() {

        TodoList todoList = new TodoList();

        boolean result = todoList.addTask("clean room");
        Assertions.assertTrue(result);

    }
    @Test
    public void testShowAllTasks() {

        TodoList list = new TodoList();

        list.addTask("Clean room");
        list.addTask("Wash car");

        HashMap<String, Boolean> result = list.showAllTasks();

        Assertions.assertFalse(result.get("Clean room"));
        Assertions.assertFalse(result.get("Wash car"));

    }
    @Test
    public void testChangeStatus() {
        TodoList list = new TodoList();
        list.addTask("Clean room");

        list.changeStatus("Clean room");

        HashMap<String, Boolean> result = list.showAllTasks();
        Assertions.assertTrue(result.get("Clean room"));

        list.changeStatus("Clean room");
        Assertions.assertFalse(result.get("Clean room"));
    }
    @Test
    public void getCompleteTask() {
        TodoList list = new TodoList();
        list.addTask("Clean room");
        list.addTask("Wash car");

        list.changeStatus("Clean room");

        ArrayList<String> completedTasks = list.getComplete();

        Assertions.assertEquals(1, completedTasks.size());
        Assertions.assertTrue(completedTasks.contains("Clean room"));
    }

    @Test
    public void getIncompleteTask() {
        TodoList list = new TodoList();
        list.addTask("Clean room");
        list.addTask("Wash car");

        list.changeStatus("Clean room");

        ArrayList<String> incompleteTasks = list.getIncomplete();


        Assertions.assertEquals(1, incompleteTasks.size());
        Assertions.assertTrue(incompleteTasks.contains("Wash car"));
    }

    @Test
    public void searchTask() {

        TodoList list = new TodoList();

        list.addTask("Wash car");

        String foundMessage = list.search("Wash car");
        Assertions.assertEquals("Task found: Wash car", foundMessage);

        String notFoundMessage = list.search("Clean room");
        Assertions.assertEquals("Task NOT found: Clean room", notFoundMessage);
    }

    @Test
    public void removeTask() {
        TodoList list = new TodoList();
        list.addTask("Clean room");

        boolean isRemoved = list.remove("Clean room");
        Assertions.assertTrue(isRemoved);

        Assertions.assertEquals(0, list.showAllTasks().size());

        boolean isNotRemoved = list.remove("Wash car");
        Assertions.assertFalse(isNotRemoved);
    }

    @Test
    public void sortAsc(){
        TodoList list = new TodoList();
        list.addTask("Clean room");
        list.addTask("Wash car");
        list.addTask("Empty washing machine");

        ArrayList<String> sorted = list.sortAscList();

        Assertions.assertEquals("Clean room", sorted.get(0));
        Assertions.assertEquals("Empty washing machine", sorted.get(1));
        Assertions.assertEquals("Wash car", sorted.get(2));

    }

    @Test
    public void sortDesc(){
        TodoList list = new TodoList();
        list.addTask("Clean room");
        list.addTask("Wash car");
        list.addTask("Empty washing machine");

        ArrayList<String> sorted = list.sortDescList();
        Assertions.assertEquals("Wash car", sorted.get(0));
        Assertions.assertEquals("Empty washing machine", sorted.get(1));
        Assertions.assertEquals("Clean room", sorted.get(2));

    }
}
