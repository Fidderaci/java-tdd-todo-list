package com.booleanuk.extension;

import java.time.LocalDateTime;

public class Task {
    private int id;
    private String name;
    private boolean isComplete;
    private LocalDateTime createdAt;

    public Task(int id, String name) {
        this.id = id;
        this.name = name;
        this.isComplete = false;
        this.createdAt = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public boolean isComplete() {
        return isComplete;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setComplete(boolean isComplete) {
        this.isComplete = isComplete;
    }
}
