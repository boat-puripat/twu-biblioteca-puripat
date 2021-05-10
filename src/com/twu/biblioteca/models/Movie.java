package com.twu.biblioteca.models;

public class Movie extends Media {
    private int rating;

    public Movie(String name, String director, int year, int rating) {
        this(name, director, year, rating, true);
    }

    public Movie(String name, String director, int year, int rating, boolean isAvailable) {
        super(name, director, year, isAvailable);
        this.rating = rating;
    }

    @Override
    public String toString() {
        return name + "\t" + year + "\t" + creator + "\t" + rating;
    }
}
