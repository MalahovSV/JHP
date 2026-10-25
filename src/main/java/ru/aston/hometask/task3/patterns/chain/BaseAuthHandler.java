package ru.aston.hometask.task3.patterns.chain;

public abstract class BaseAuthHandler implements AuthHandler {
    private AuthHandler next;

    @Override
    public void setNext(AuthHandler next) {
        this.next = next;
    }

    @Override
    public boolean handle(UserAuth user) {
        if (next != null) {
            return next.handle(user);
        }
        return true;
    }
}
