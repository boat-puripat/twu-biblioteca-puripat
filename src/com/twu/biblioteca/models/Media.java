package com.twu.biblioteca.models;

public class Media {
    protected String name;
    protected String creator;
    protected int year;
    protected boolean isAvailable;

    public Media(String name, String creator, int year, boolean isAvailable) {
        this.name = name;
        this.creator = creator;
        this.year = year;
        this.isAvailable = isAvailable;
    }

    public String getName() {
        return name;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void checkout() {
        this.isAvailable = false;
    }
}
