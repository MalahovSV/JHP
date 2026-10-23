package ru.aston.hometask.task3.patterns.builder.builders;

import ru.aston.hometask.task3.patterns.builder.components.NetConfig;
import ru.aston.hometask.task3.patterns.builder.types.RouterType;

import java.math.BigDecimal;
import java.util.Date;

public class RouterBuilder implements DeviceBuilder {
    private String serialNumber;
    private Date creationDate;
    private BigDecimal price;
    private RouterType type;
    private NetConfig netConfig;

    @Override
    public void reset() {
        this.serialNumber = null;
        this.creationDate = null;
        this.price = null;
        this.type = null;
        this.netConfig = null;
    }

    @Override public void setSerialNumber(String serialNumber) { this.serialNumber = serialNumber; }
    @Override public void setCreationDate(Date date) { this.creationDate = date; }
    @Override public void setPrice(BigDecimal price) { this.price = price; }

    @Override
    public void setNetConfig(NetConfig netConfig) {
        this.netConfig = netConfig;
    }

    public void setRouterType(RouterType type) { this.type = type; }

    public Router build() {
        if (this.type == null) throw new IllegalStateException("Не указан тип роутера!");
        if (this.netConfig == null) throw new IllegalStateException("Сетевой конфиг обязателен для роутера!");
        return new Router(serialNumber, creationDate, price, type, netConfig);
    }
}