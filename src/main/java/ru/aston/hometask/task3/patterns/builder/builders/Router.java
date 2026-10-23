package ru.aston.hometask.task3.patterns.builder.builders;

import ru.aston.hometask.task3.patterns.builder.components.NetConfig;
import ru.aston.hometask.task3.patterns.builder.types.RouterType;

import java.math.BigDecimal;
import java.util.Date;

public class Router {
    private final String serialNumber;
    private final Date creationDate;
    private final BigDecimal price;
    private final RouterType type;
    private final NetConfig netConfig; // <--- ДОБАВИЛИ

    public Router(String serialNumber, Date creationDate, BigDecimal price, RouterType type, NetConfig netConfig) {
        this.serialNumber = serialNumber;
        this.creationDate = creationDate;
        this.price = price;
        this.type = type;
        this.netConfig = netConfig;
    }

    @Override
    public String toString() {
        String configStr = (netConfig != null) ? netConfig.toString() : "не настроены";
        return String.format("[%s] S/N: %s | Цена: %s | Дата: %s | Сеть: %s",
                type.getDescription(), serialNumber, price, creationDate, configStr);
    }
}