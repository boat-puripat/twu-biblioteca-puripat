package com.twu.biblioteca.models;

import com.twu.biblioteca.constaints.ActionType;

public class ActionHistory {
    private Media media;
    private ActionType type;

    public ActionHistory(Media media, ActionType type) {
        this.media = media;
        this.type = type;
    }
}
