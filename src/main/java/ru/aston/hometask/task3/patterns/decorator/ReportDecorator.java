package ru.aston.hometask.task3.patterns.decorator;

public abstract class ReportDecorator implements Report {
    protected Report wrappee;

    public ReportDecorator(Report report) {
        this.wrappee = report;
    }

    @Override
    public String format() {
        return wrappee.format();
    }
}