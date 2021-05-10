package com.twu.biblioteca.models;

public class Movie {
    private String name;
    private String director;
    private int year;
    private int rating;
    private boolean isAvailable;

    public Movie(String name, String director, int year, int rating) {
        this(name, director, year, rating, true);
    }

    public Movie(String name, String director, int year, int rating, boolean isAvailable) {
        this.name = name;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.isAvailable = isAvailable;
    }

    public String getName() {
        return name;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    @Override
    public String toString() {
        return name + "\t" + year + "\t" + director + "\t" + rating;
    }
}
