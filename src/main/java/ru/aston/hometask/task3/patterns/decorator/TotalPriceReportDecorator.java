package ru.aston.hometask.task3.patterns.decorator;

import ru.aston.hometask.task3.patterns.builder.builders.Computer;

public class TotalPriceReportDecorator extends ReportDecorator {
    private final Computer computer;

    public TotalPriceReportDecorator(Report report, Computer computer) {
        super(report);
        this.computer = computer;
    }

    @Override
    public String format() {
        String baseText = super.format();

        StringBuilder sb = new StringBuilder(baseText);
        sb.append("\n");
        sb.append("----------------------------------------\n");
        sb.append("ИТОГО: ").append(computer.getPrice()).append(" руб.");
        return sb.toString();
    }
}