package ru.aston.hometask.task3.demos;

import ru.aston.hometask.task3.patterns.adapter.LabelPrinter;
import ru.aston.hometask.task3.patterns.adapter.QrLabelAdapter;
import ru.aston.hometask.task3.patterns.adapter.external.ExternalQrLibrary;
import ru.aston.hometask.task3.patterns.builder.Director;
import ru.aston.hometask.task3.patterns.builder.builders.Computer;
import ru.aston.hometask.task3.patterns.builder.builders.ComputerBuilder;

public class AdapterDemo {
    public void run() {
        Director director = new Director();
        ComputerBuilder pcBuilder = new ComputerBuilder();
        director.makeDesktop(pcBuilder);
        Computer pc = pcBuilder.build();

        ExternalQrLibrary externalLib = new ExternalQrLibrary();

        LabelPrinter printer = new QrLabelAdapter(externalLib);

        String qrCode = printer.printLabel(pc.getSerialNumber());

        System.out.println("Печать наклейки для устройства на складе:");
        System.out.println(qrCode);
    }
}
