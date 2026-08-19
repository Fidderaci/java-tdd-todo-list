package com.booleanuk.extension;

import java.util.ArrayList;
import java.util.*;

public class ToDoList {
    private ArrayList<Task> tasks = new ArrayList<>();

    private int idCounter = 1;

    public boolean addTask(String name) {
        if (name == null || name.isEmpty()) {
            return false;
        }

        Task newTask = new Task(idCounter, name);
        tasks.add(newTask);

        idCounter++;
        return true;

    }

    public Task getTaskById(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }
    public boolean updateName(int id, String name){
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setName(name);
                return true;
            }
        }
        return false;
    }

    public boolean changeStatusById(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                boolean currentStatus = task.isComplete();

                task.setComplete(!currentStatus);
                return true;
            }
        }
        return false;
    }
}
