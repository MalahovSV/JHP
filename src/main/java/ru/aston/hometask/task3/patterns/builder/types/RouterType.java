package ru.aston.hometask.task3.patterns.builder.types;

public enum RouterType {
    ROUTER("Маршрутизатор"),
    SWITCH("Коммутатор"),
    HUB("Сетевой концетратор");

    private final String description;
    RouterType(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
}