package org.example.JD2_Maven.home_work_1.web.service;

import org.example.JD2_Maven.home_work_1.dto.User;

import java.util.Arrays;

public class UserControl {

    UserStorage storage = UserStorage.getInstance();

    public User userLogIn(String login,String password) {
        for (User user : storage.getUsers()) {
            if (Arrays.equals(user.getPassword(), password.toCharArray())
                    && user.getLogin().equals(login)) {
                return user;
            }
        }
        throw new IllegalArgumentException("Логин или пароль неверные");
    }


}
