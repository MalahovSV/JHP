package ru.aston.hometask.task3.patterns.adapter;

import ru.aston.hometask.task3.patterns.adapter.external.ExternalQrLibrary;

public class QrLabelAdapter implements LabelPrinter {
    private final ExternalQrLibrary externalLibrary;

    public QrLabelAdapter(ExternalQrLibrary externalLibrary) {
        this.externalLibrary = externalLibrary;
    }

    @Override
    public String printLabel(String serialNumber) {
        return externalLibrary.generateQrCode(serialNumber, 200, true);
    }
}