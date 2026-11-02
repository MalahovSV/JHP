package ru.aston.hometask.task3.patterns.proxy;

public enum UserRole {
    ADMIN("Администратор"),
    GUEST("Гость");

    private final String description;

    UserRole(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}