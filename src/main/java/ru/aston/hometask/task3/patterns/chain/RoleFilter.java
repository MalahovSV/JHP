package ru.aston.hometask.task3.patterns.chain;

import ru.aston.hometask.task3.patterns.proxy.UserRole;

public class RoleFilter extends BaseAuthHandler {
    private final UserRole requiredRole;

    public RoleFilter(UserRole requiredRole) {
        this.requiredRole = requiredRole;
    }

    @Override
    public boolean handle(UserAuth user) {
        if (user.getRole() != requiredRole) {
            System.out.println("Нужна роль " + requiredRole.getDescription() +
                    ", а у вас " + user.getRole().getDescription());
            return false;
        }
        System.out.println("Роль подтверждена: " + user.getRole().getDescription());
        return super.handle(user);
    }
}