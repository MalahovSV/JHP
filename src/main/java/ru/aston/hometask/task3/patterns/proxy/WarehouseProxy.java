package ru.aston.hometask.task3.patterns.proxy;

import java.util.List;

public class WarehouseProxy implements Warehouse {
    private final ConcreteWarehouse concreteWarehouse;
    private final UserRole userRole;

    public WarehouseProxy(ConcreteWarehouse concreteWarehouse, UserRole userRole) {
        this.concreteWarehouse = concreteWarehouse;
        this.userRole = userRole;
    }

    @Override
    public void addDevice(Object device) {
        if (userRole == UserRole.ADMIN) {
            concreteWarehouse.addDevice(device);
        } else {
            System.out.println("[" + userRole.getDescription() + "] ДОСТУП ЗАПРЕЩЁН: Только администратор может добавлять технику!");
        }
    }

    @Override
    public void showAllDevices() {
        concreteWarehouse.showAllDevices();
    }

    @Override
    public List<Object> getDevices() {
        return concreteWarehouse.getDevices();
    }
}