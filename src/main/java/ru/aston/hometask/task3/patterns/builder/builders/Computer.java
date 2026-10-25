package ru.aston.hometask.task3.patterns.builder.builders;

import ru.aston.hometask.task3.patterns.builder.components.NetConfig;
import ru.aston.hometask.task3.patterns.builder.types.ComputerType;

import java.math.BigDecimal;
import java.util.Date;

public class Computer {
    private final String serialNumber;
    private final Date creationDate;
    private final BigDecimal price;
    private final NetConfig netConfig;
    private final ComputerType type;

    public Computer(String serialNumber, Date creationDate, BigDecimal price, ComputerType type, NetConfig netConfig) {
        this.serialNumber = serialNumber;
        this.creationDate = creationDate;
        this.price = price;
        this.type = type;
        this.netConfig = netConfig;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    @Override
    public String toString() {
        String configStr = (netConfig != null) ? netConfig.toString() : "не настроены";
        return String.format("[%s] S/N: %s | Цена: %s | Дата: %s | Сеть: %s",
                type.getDescription(), serialNumber, price, creationDate, configStr);
    }

    public BigDecimal getPrice() {
        return price;
    }
}