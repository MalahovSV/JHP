package ru.aston.hometask.task3.demos;

import ru.aston.hometask.task3.patterns.builder.Director;
import ru.aston.hometask.task3.patterns.builder.builders.ComputerBuilder;
import ru.aston.hometask.task3.patterns.builder.builders.RouterBuilder;

import java.util.ArrayList;
import java.util.List;

public class BuilderDemo {
    public void run() {
        Director director = new Director();
        List<Object> warehouse = new ArrayList<>();

        ComputerBuilder pcBuilder = new ComputerBuilder();
        director.makeDesktop(pcBuilder);
        warehouse.add(pcBuilder.build());

        RouterBuilder routerBuilder = new RouterBuilder();
        director.makeRouter(routerBuilder);
        warehouse.add(routerBuilder.build());
        warehouse.forEach(System.out::println);
    }
}
