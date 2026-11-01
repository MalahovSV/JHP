package ru.aston.hometask.task4.demo;

public class DeadLock implements DemoWorkThread {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public void startPrinting() {
        Thread printerOne = new Thread(() -> {
            while (true) {
                synchronized (lock1) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                    }
                    synchronized (lock2) {
                        printNumberFromThread(1);
                    }
                }
            }
        });

        Thread printerTwo = new Thread(() -> {
            while (true) {
                synchronized (lock2) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                    }
                    synchronized (lock1) {
                        printNumberFromThread(2);
                    }
                }
            }
        });

        printerOne.start();
        printerTwo.start();
    }

    public void printNumberFromThread(int number){
        System.out.printf("[%s]:\t %d\n", Thread.currentThread().getName(), number);
    }
}
