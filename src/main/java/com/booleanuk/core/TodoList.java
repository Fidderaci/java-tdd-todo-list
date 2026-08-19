package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.*;

public class TodoList {

    private HashMap<String, Boolean> tasks =  new HashMap<>();


    public boolean addTask(String task) {
        if (tasks.containsKey(task)) {
            return false;
        }
        tasks.put(task, false);
        return true;
    }

    public HashMap<String, Boolean> showAllTasks() {
        return tasks;
    }

    public void changeStatus(String task) {

        if (tasks.containsKey(task)) {
            boolean status = tasks.get(task);
            tasks.put(task, !status);
        }
    }


    public ArrayList<String> getComplete() {
        ArrayList<String> completedList = new ArrayList<>();

        for (String task : tasks.keySet()) {
            if (tasks.get(task)) {
                completedList.add(task);
            }
        }
        return completedList;
    }

    public ArrayList<String> getIncomplete() {
        ArrayList<String> incompleteList = new ArrayList<>();

        for (String task : tasks.keySet()) {
            if (!tasks.get(task)) {
                incompleteList.add(task);
            }
        }
        return incompleteList;
    }

    public String search(String task) {
        if (tasks.containsKey(task)) {
            return "Task found: " + task;
        }
        return "Task NOT found: " + task;
    }

    public boolean remove(String task) {
        if (tasks.containsKey(task)) {
            tasks.remove(task);
            return true;
        }
        return false;
    }

    public ArrayList<String> sortAscList() {
        ArrayList<String> ascList = new ArrayList<>(tasks.keySet());

        Collections.sort(ascList);

        return ascList;
    }

    public ArrayList<String> sortDescList() {
        ArrayList<String> descList = new ArrayList<>(tasks.keySet());

        Collections.sort(descList);
        Collections.reverse(descList);

        return descList;
    }

}

