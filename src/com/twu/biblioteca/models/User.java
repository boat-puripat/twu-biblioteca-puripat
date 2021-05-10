package com.twu.biblioteca.models;

import java.util.Collections;
import java.util.List;

public class User {
    private String libraryNumber;
    private String password;
    private List<ActionHistory> actionHistories;

    public User(String libraryNumber, String password) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.actionHistories = Collections.emptyList();
    }

}
