package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {
    private static ArrayList<Book> books = new ArrayList<>() {{
        add(new Book("Hello"));
        add(new Book("World"));
    }};

    public static void main(String[] args) {
        printWelcome();
        listAllBooks(books);
    }

    public static void printWelcome() {
        String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
        System.out.println(welcomeMessage);
    }

    public static void listAllBooks(ArrayList<Book> books) {
        for (Book book: books) {
            System.out.println(book.getName());
        }
    }
}
