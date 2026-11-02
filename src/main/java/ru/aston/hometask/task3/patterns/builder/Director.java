package ru.aston.hometask.task3.patterns.builder;

import ru.aston.hometask.task3.patterns.builder.builders.ComputerBuilder;
import ru.aston.hometask.task3.patterns.builder.builders.DeviceBuilder;
import ru.aston.hometask.task3.patterns.builder.builders.RouterBuilder;
import ru.aston.hometask.task3.patterns.builder.components.NetConfig;
import ru.aston.hometask.task3.patterns.builder.types.ComputerType;
import ru.aston.hometask.task3.patterns.builder.types.RouterType;

import java.math.BigDecimal;
import java.util.Date;

public class Director {

    private NetConfig getDefaultConfig() {
        return new NetConfig("192.168.1.100", "255.255.255.0", "192.168.1.1", "8.8.8.8", "8.8.4.4");
    }

    public void makeDesktop(DeviceBuilder builder) {
        builder.reset();
        builder.setSerialNumber("PC-" + (int)(Math.random() * 10000));
        builder.setCreationDate(new Date());
        builder.setPrice(new BigDecimal("100000.00"));

        builder.setNetConfig(getDefaultConfig());

        if (builder instanceof ComputerBuilder) {
            ((ComputerBuilder) builder).setComputerType(ComputerType.DESKTOP);
        }
    }

    public void makeRouter(DeviceBuilder builder) {
        builder.reset();
        builder.setSerialNumber("RT-" + (int)(Math.random() * 10000));
        builder.setCreationDate(new Date());
        builder.setPrice(new BigDecimal("15000.00"));

        builder.setNetConfig(getDefaultConfig());

        if (builder instanceof RouterBuilder) {
            ((RouterBuilder) builder).setRouterType(RouterType.ROUTER);
        }
    }
}