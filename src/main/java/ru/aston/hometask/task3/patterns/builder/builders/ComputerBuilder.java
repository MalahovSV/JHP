package ru.aston.hometask.task3.patterns.builder.builders;

import ru.aston.hometask.task3.patterns.builder.components.NetConfig;
import ru.aston.hometask.task3.patterns.builder.types.ComputerType;

import java.math.BigDecimal;
import java.util.Date;

public class ComputerBuilder implements DeviceBuilder {
    private String serialNumber;
    private Date creationDate;
    private BigDecimal price;
    private NetConfig netConfig;
    private ComputerType type;

    @Override
    public void reset() {
        this.serialNumber = null;
        this.creationDate = null;
        this.price = null;
        this.netConfig = null;
        this.type = null;
    }

    @Override public void setSerialNumber(String serialNumber) { this.serialNumber = serialNumber; }
    @Override public void setCreationDate(Date date) { this.creationDate = date; }
    @Override public void setPrice(BigDecimal price) { this.price = price; }

    @Override
    public void setNetConfig(NetConfig netConfig) {
        this.netConfig = netConfig;
    }

    public void setComputerType(ComputerType type) { this.type = type; }

    public Computer build() {
        if (this.type == null) throw new IllegalStateException("Не указан тип компьютера!");
        return new Computer(serialNumber, creationDate, price, type, netConfig);
    }
}