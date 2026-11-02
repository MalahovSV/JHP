package ru.aston.hometask.task3;

import ru.aston.hometask.task3.demos.*;

import java.util.ArrayList;
import java.util.List;


public class StartPatterns {
    private final String SEPARATOR_LINE = "\n========================================================================\n";
    private final List<Runnable> exampleDemos = new ArrayList<>();

    public void startAllPatterns() {
        addPatternsInCollection();
        for (Runnable pattern : exampleDemos){
            System.out.println(SEPARATOR_LINE);
            pattern.run();
        }
    }

    private void addPatternsInCollection(){
        exampleDemos.add(new BuilderDemo()::run);
        exampleDemos.add(new StrategyDemo()::run);
        exampleDemos.add(new ProxyDemo()::run);
        exampleDemos.add(new DecoratorDemo()::run);
        exampleDemos.add(new AdapterDemo()::run);
        exampleDemos.add(new ChainDemo()::run);
    }
}
