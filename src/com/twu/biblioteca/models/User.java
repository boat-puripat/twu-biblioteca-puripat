package com.twu.biblioteca.models;

import com.twu.biblioteca.constaints.ActionType;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String libraryNumber;
    private String password;
    private String name;
    private String email;
    private String phoneNumber;
    private List<ActionHistory> actionHistories;

    public User() {
        this.actionHistories = new ArrayList<>();
    }

    public User(String libraryNumber, String password) {
        this();
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    public User(String libraryNumber, String password, String name, String email, String phoneNumber) {
        this(libraryNumber, password);
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public List<ActionHistory> getActionHistories() {
        return actionHistories;
    }

    public void logAction(Media media, ActionType actionType) {
        actionHistories.add(new ActionHistory(media, actionType));
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (!(object instanceof User)) return false;
        User user = (User) object;
        return libraryNumber.equals(user.libraryNumber) && password.equals(user.password);
    }

    @Override
    public String toString() {
        return name + "\t" + email + "\t" + phoneNumber;
    }
}
