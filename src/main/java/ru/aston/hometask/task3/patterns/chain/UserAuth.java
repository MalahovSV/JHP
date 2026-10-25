package ru.aston.hometask.task3.patterns.chain;

import ru.aston.hometask.task3.patterns.proxy.UserRole;

public class UserAuth {
    private final String username;
    private final UserRole role;
    private final boolean isBanned;

    public UserAuth(String username, UserRole role, boolean isBanned) {
        this.username = username;
        this.role = role;
        this.isBanned = isBanned;
    }

    public String getUsername() { return username; }
    public UserRole getRole() { return role; }
    public boolean isBanned() { return isBanned; }
}