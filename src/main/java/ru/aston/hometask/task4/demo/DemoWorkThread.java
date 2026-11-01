package ru.aston.hometask.task4.demo;

public interface DemoWorkThread {
    public void startPrinting();
    public default void printNumberFromThread(int number){
        System.out.printf("[%s]:\t %d\n", Thread.currentThread().getName(), number);
    };
}
