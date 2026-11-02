package ru.aston.hometask.task3.patterns.chain;

public interface AuthHandler {
    void setNext(AuthHandler next);
    boolean handle(UserAuth user);
}
