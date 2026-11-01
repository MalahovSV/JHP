package ru.aston.hometask.task4.demo;

public class CorrectWork implements DemoWorkThread {
    private static final Object lock = new Object();
    private static boolean isThreadOne = true;

    public void startPrinting(){
        Thread printerOne = new Thread(() -> {
            while (true) {
                synchronized (lock){
                    while (!isThreadOne){
                        try {
                            lock.wait();
                        }
                        catch (InterruptedException ignored){}
                    }
                    printNumberFromThread(1);

                    isThreadOne = false;
                    lock.notifyAll();
                }
            }
        }, "PrintOneThread");

        Thread printerTwo = new Thread(()-> {
           while (true){
               synchronized (lock) {
                   while (isThreadOne) {
                       try {
                           lock.wait();
                       }
                       catch (InterruptedException ignored){}
                   }
                   printNumberFromThread(2);
                   isThreadOne = true;
                   lock.notifyAll();
               }
           }
        }, "PrintTwoThread");

        printerOne.start();
        printerTwo.start();
    }

    public void printNumberFromThread(int number){
        System.out.printf("[%s]:\t %d\n", Thread.currentThread().getName(), number);
    }
}
