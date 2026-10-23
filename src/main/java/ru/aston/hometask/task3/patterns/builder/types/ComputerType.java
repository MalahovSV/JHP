package ru.aston.hometask.task3.patterns.builder.types;

public enum ComputerType {
    DESKTOP("Настольный ПК"),
    NOTEBOOK("Ноутбук"),
    SERVER("Сервер");

    private final String description;

    ComputerType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}