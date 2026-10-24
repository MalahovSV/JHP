package ru.aston.hometask.task3.patterns.proxy;

import java.util.List;

public interface Warehouse {
    void addDevice(Object device);
    void showAllDevices();
    List<Object> getDevices();
}