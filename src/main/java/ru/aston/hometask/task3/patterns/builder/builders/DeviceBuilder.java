package ru.aston.hometask.task3.patterns.builder.builders;

import ru.aston.hometask.task3.patterns.builder.components.NetConfig;

import java.math.BigDecimal;
import java.util.Date;

public interface DeviceBuilder {
    void reset();
    void setSerialNumber(String serialNumber);
    void setCreationDate(Date date);
    void setPrice(BigDecimal price);
    default void setNetConfig(NetConfig netConfig) {}
}
