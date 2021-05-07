package com.twu.biblioteca.models;

public class Book {
    private String name;
    private String author;
    private int publicationYear;

    public Book(String name, String author, int publicationYear) {
        this.name = name;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    @Override
    public String toString() {
        return name + "\t" + author + "\t" + publicationYear;
    }
}
