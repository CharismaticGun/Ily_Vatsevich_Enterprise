package org.example.JD2_Maven.home_work_1.web.service;

import org.example.JD2_Maven.home_work_1.dto.Roles;
import org.example.JD2_Maven.home_work_1.dto.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserStorage {
    private final List<User> users;
    private UserStorage(List<User> users) {
        this.users = users;
    }

    private static class UserStorageHandler {
        private static final UserStorage userStorage = new UserStorage(new ArrayList<>());
    }

    public static UserStorage getInstance() {
        return UserStorageHandler.userStorage;
    }

    public boolean userRegistration(String login,String password,String fullName,String dateOfBirth) {

        if ("".equals(login)||"".equals(password)||"".equals(fullName)||"".equals(dateOfBirth)) {
            throw new IllegalArgumentException("Заполнены не все поля");
        }

        if (users.isEmpty()) {
            users.add(new User("admin",
                    "admin".toCharArray(),
                    "Ivan Jovanovich Ivanov",
                    "18.09.1990",
                    LocalDate.now(),
                    Roles.ADMIN.name()));
        }

        boolean b = getUsers().stream().noneMatch(user -> user.getLogin().equals(login));

        if (b) {
            users.add(new User(login,
                    password.toCharArray(),
                    fullName,
                    dateOfBirth,
                    LocalDate.now(),
                    Roles.USER.name()));
            return true;
        }
        return false;
    }
    public List<User> getUsers() {
        return users;
    }
}
