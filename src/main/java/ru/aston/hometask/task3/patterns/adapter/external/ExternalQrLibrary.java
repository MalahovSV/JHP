package ru.aston.hometask.task3.patterns.adapter.external;

public class ExternalQrLibrary {
    public String generateQrCode(String data, int size, boolean withBorder) {
        return "Имитация qr-code: " +
                "\nДанные: " + data +
                "\nРазмер: " + size + "x" + size +
                "\nРамка: " + (withBorder ? "Есть" : "Нет");
    }
}