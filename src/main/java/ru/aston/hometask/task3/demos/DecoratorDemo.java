package ru.aston.hometask.task3.demos;

import ru.aston.hometask.task3.patterns.builder.Director;
import ru.aston.hometask.task3.patterns.builder.builders.Computer;
import ru.aston.hometask.task3.patterns.builder.builders.ComputerBuilder;
import ru.aston.hometask.task3.patterns.decorator.BorderReportDecorator;
import ru.aston.hometask.task3.patterns.decorator.Report;
import ru.aston.hometask.task3.patterns.decorator.SimpleReport;
import ru.aston.hometask.task3.patterns.decorator.TotalPriceReportDecorator;

public class DecoratorDemo {
    public void run() {
        Director director = new Director();
        ComputerBuilder pcBuilder = new ComputerBuilder();
        director.makeDesktop(pcBuilder);
        Computer pc = pcBuilder.build();

        Report report = new SimpleReport(pc);
        System.out.println("1. Базовый отчет:");
        System.out.println(report.format());

        report = new BorderReportDecorator(report);
        System.out.println("\n2. Отчет с рамкой:");
        System.out.println(report.format());

        report = new TotalPriceReportDecorator(report, pc);
        System.out.println("\n3. Полный отчет (Рамка + Итог):");
        System.out.println(report.format());
    }
}
