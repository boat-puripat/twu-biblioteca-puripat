package com.twu.biblioteca.services;

import com.twu.biblioteca.models.User;

public class Authentication {
    public User verifyUser(String libraryNumber, String password) {
        User mockUser = new User("xxx-xxxx", "password");
        User loginUser = new User(libraryNumber, password);
        if (!mockUser.equals(loginUser)) return null;
        return mockUser;
    }
}
