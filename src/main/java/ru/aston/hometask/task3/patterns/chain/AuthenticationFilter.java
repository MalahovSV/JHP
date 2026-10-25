package ru.aston.hometask.task3.patterns.chain;

public class AuthenticationFilter extends BaseAuthHandler {
    @Override
    public boolean handle(UserAuth user) {
        if (user == null) {
            System.out.println("Error: Пользователь не передан.");
            return false;
        }
        System.out.println("Аутентификация: " + user.getUsername());
        return super.handle(user);
    }
}