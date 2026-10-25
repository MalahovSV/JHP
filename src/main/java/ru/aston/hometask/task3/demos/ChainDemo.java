package ru.aston.hometask.task3.demos;

import ru.aston.hometask.task3.patterns.chain.*;
import ru.aston.hometask.task3.patterns.proxy.UserRole;

public class ChainDemo {
    public void run() {
        AuthHandler chain = new AuthenticationFilter();
        AuthHandler banFilter = new BanFilter();
        AuthHandler roleFilter = new RoleFilter(UserRole.ADMIN);

        chain.setNext(banFilter);
        banFilter.setNext(roleFilter);

        System.out.println("\nТест 1: Администратор");
        UserAuth admin = new UserAuth("admin_ivan", UserRole.ADMIN, false);
        boolean result1 = chain.handle(admin);
        System.out.println("  ИТОГ: " + (result1 ? "ДОСТУП РАЗРЕШЕН" : "ДОСТУП ЗАПРЕЩЕН"));

        System.out.println("\nТест 2: Забаненный админ");
        UserAuth bannedAdmin = new UserAuth("bad_admin", UserRole.ADMIN, true);
        boolean result2 = chain.handle(bannedAdmin);
        System.out.println("  ИТОГ: " + (result2 ? "ДОСТУП РАЗРЕШЕН" : "ДОСТУП ЗАПРЕЩЕН"));

        System.out.println("\nТест 3: Гость");
        UserAuth guest = new UserAuth("guest_user", UserRole.GUEST, false);
        boolean result3 = chain.handle(guest);
        System.out.println("  ИТОГ: " + (result3 ? "ДОСТУП РАЗРЕШЕН" : "ДОСТУП ЗАПРЕЩЕН"));
    }
}
