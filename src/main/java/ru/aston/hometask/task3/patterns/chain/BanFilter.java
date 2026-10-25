package ru.aston.hometask.task3.patterns.chain;

public class BanFilter extends BaseAuthHandler {
    @Override
    public boolean handle(UserAuth user) {
        if (user.isBanned()) {
            System.out.println("БАН: Пользователь " + user.getUsername() + " заблокирован!");
            return false;
        }
        System.out.println("Проверка на бан пройдена.");
        return super.handle(user);
    }
}
