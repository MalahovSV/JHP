package ru.aston.hometask.task3.patterns.proxy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConcreteWarehouse implements Warehouse {
    private final List<Object> devices = new ArrayList<>();

    @Override
    public void addDevice(Object device) {
        devices.add(device);
        System.out.println("Устройство успешно добавлено.");
    }

    @Override
    public void showAllDevices() {
        System.out.println("На складе " + devices.size() + " ед.");
        devices.forEach(System.out::println);
    }

    @Override
    public List<Object> getDevices() {
        return List.copyOf(devices);
    }
}