package ru.aston.hometask.task3.patterns.decorator;

public class BorderReportDecorator extends ReportDecorator {
    public BorderReportDecorator(Report report) {
        super(report);
    }

    @Override
    public String format() {
        String baseText = super.format();

        StringBuilder sb = new StringBuilder();
        sb.append("========================================\n");
        sb.append(baseText).append("\n");
        sb.append("========================================");
        return sb.toString();
    }
}