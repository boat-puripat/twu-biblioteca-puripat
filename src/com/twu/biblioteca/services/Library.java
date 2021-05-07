package com.twu.biblioteca.services;

import com.twu.biblioteca.managers.Printer;
import com.twu.biblioteca.models.Book;

import java.util.List;

public class Library {
    private Printer printer;
    private List<Book> books;

    public Library(Printer printer, List<Book> books) {
        this.printer = printer;
        this.books = books;
    }

    public void printWelcome() {
        String welcomeSentence = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
        printer.print(welcomeSentence, true);
    }
}
