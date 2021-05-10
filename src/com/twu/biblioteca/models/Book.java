package com.twu.biblioteca.models;

public class Book extends Media {
    public Book(String name, String author, int publicationYear) {
        this(name, author, publicationYear, true);
    }

    public Book(String name, String author, int publicationYear, boolean isAvailable) {
        super(name, author, publicationYear, isAvailable);
    }

    public void returnBook() {
        this.isAvailable = true;
    }

    @Override
    public String toString() {
        return name + "\t" + creator + "\t" + year;
    }
}
