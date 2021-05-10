package com.twu.biblioteca.models;

public class Book {
    private String name;
    private String author;
    private int publicationYear;
    private boolean isAvailable;

    public Book(String name, String author, int publicationYear) {
        this(name, author, publicationYear, true);
    }

    public Book(String name, String author, int publicationYear, boolean isAvailable) {
        this.name = name;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isAvailable = isAvailable;
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

    public boolean isAvailable() {
        return isAvailable;
    }

    public void checkout() {
        this.isAvailable = false;
    }

    public void returnBook() {
        this.isAvailable = true;
    }

    @Override
    public String toString() {
        return name + "\t" + author + "\t" + publicationYear;
    }
}
