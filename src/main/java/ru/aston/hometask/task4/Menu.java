package ru.aston.hometask.task4;

import ru.aston.hometask.task4.demo.CorrectWork;
import ru.aston.hometask.task4.demo.DeadLock;
import ru.aston.hometask.task4.demo.DemoWorkThread;
import ru.aston.hometask.task4.demo.LiveLock;

import java.util.Scanner;

public class Menu {
    public static void startMenu() {
        System.out.print("1 - Работающий вариант;\n2 - LiveLock;\n3 - DeadLock.\n");
        DemoWorkThread demo = switch (new Scanner(System.in).nextInt()) {
            case 1 -> new CorrectWork();
            case 2 -> new LiveLock();
            case 3 -> new DeadLock();
            default -> null;
        };
        if (demo != null)
            demo.startPrinting();
    }
}
