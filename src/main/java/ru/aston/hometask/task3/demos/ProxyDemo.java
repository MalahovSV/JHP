package ru.aston.hometask.task3.demos;

import ru.aston.hometask.task3.patterns.builder.Director;
import ru.aston.hometask.task3.patterns.builder.builders.ComputerBuilder;
import ru.aston.hometask.task3.patterns.builder.builders.RouterBuilder;
import ru.aston.hometask.task3.patterns.proxy.ConcreteWarehouse;
import ru.aston.hometask.task3.patterns.proxy.UserRole;
import ru.aston.hometask.task3.patterns.proxy.Warehouse;
import ru.aston.hometask.task3.patterns.proxy.WarehouseProxy;

public class ProxyDemo {
    public void run() {
        ConcreteWarehouse concreteWarehouse = new ConcreteWarehouse();

        Director director = new Director();

        ComputerBuilder pcBuilder = new ComputerBuilder();
        director.makeDesktop(pcBuilder);
        Object pc = pcBuilder.build();

        RouterBuilder routerBuilder = new RouterBuilder();
        director.makeRouter(routerBuilder);
        Object router = routerBuilder.build();

        System.out.println("Authorization: " + UserRole.GUEST.getDescription());
        Warehouse guestAccess = new WarehouseProxy(concreteWarehouse, UserRole.GUEST);
        guestAccess.addDevice(pc);
        guestAccess.addDevice(router);
        guestAccess.showAllDevices();

        System.out.println("Authorization: " + UserRole.ADMIN.getDescription());
        Warehouse adminAccess = new WarehouseProxy(concreteWarehouse, UserRole.ADMIN);
        adminAccess.addDevice(pc);
        adminAccess.addDevice(router);
        adminAccess.showAllDevices();
    }
}
