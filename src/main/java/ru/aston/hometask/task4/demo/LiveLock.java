package ru.aston.hometask.task4.demo;

public class LiveLock implements DemoWorkThread {
    private static final Object lock = new Object();
    private static boolean firstWantsToYield = true;
    private static boolean secondWantsToYield = true;

    public void startPrinting(){
        Thread printerOne = new Thread(() -> {
            while (true) {
                synchronized (lock){

                    if (secondWantsToYield){
                        firstWantsToYield = true;
                        lock.notifyAll();
                        continue;
                    }

                    printNumberFromThread(1);
                    secondWantsToYield = false;
                    lock.notifyAll();
                }
            }
        }, "PrintOneThread");

        Thread printerTwo = new Thread(() -> {
            while (true) {
                synchronized (lock) {

                    if (firstWantsToYield) {
                        secondWantsToYield = true;
                        lock.notifyAll();
                        continue;
                    }

                    printNumberFromThread(2);
                    firstWantsToYield = false;
                    lock.notifyAll();
                }
            }
        });

        printerOne.start();
        printerTwo.start();
    }

}
