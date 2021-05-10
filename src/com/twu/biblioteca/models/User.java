package com.twu.biblioteca.models;

import com.twu.biblioteca.constaints.ActionType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User {
    private String libraryNumber;
    private String password;
    private List<ActionHistory> actionHistories;

    public User() {
        this.actionHistories = new ArrayList<>();
    }

    public User(String libraryNumber, String password) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.actionHistories = new ArrayList<>();
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
}
