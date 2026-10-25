package ru.aston.hometask.task3.patterns.decorator;

import ru.aston.hometask.task3.patterns.builder.builders.Computer;

public class SimpleReport implements Report {
    private final Computer computer;

    public SimpleReport(Computer computer) {
        this.computer = computer;
    }

    @Override
    public String format() {
        return "Данные устройства: " + computer.toString();
    }
}