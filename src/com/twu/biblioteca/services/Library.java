package com.twu.biblioteca.services;

import com.twu.biblioteca.managers.Printer;
import com.twu.biblioteca.managers.SystemExit;
import com.twu.biblioteca.models.Book;

import java.util.List;

public class Library {
    private Printer printer;
    private SystemExit systemExit;
    private List<Book> books;

    public Library(Printer printer, SystemExit systemExit, List<Book> books) {
        this.printer = printer;
        this.systemExit = systemExit;
        this.books = books;
    }

    public void printWelcome() {
        String welcomeSentence = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
        printer.print(welcomeSentence, true);
    }

    public void listBooks() {
        for (Book book: books) {
            if (book.isAvailable()) printer.print(book.toString(), true);
        }
    }

    public void showMenu() {
        printer.print("Main Menu", true);
        printer.print("1 List of books", true);
        printer.print("2 Checkout a book", true);
        printer.print("q Quit", true);
    }

    public void invalidOption() {
        printer.print("Please select a valid option!", true);
    }

    public void checkoutBook(String bookName) {
        Book bookForCheckout = books.stream().filter(book -> bookName.equals(book.getName())).findAny().get();
        bookForCheckout.checkout();
    }

    public void quit() {
        systemExit.exit(0);
    }
}
