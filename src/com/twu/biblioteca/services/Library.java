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
        printer.print("3 Return a book", true);
        printer.print("q Quit", true);
    }

    public void invalidOption() {
        printer.print("Please select a valid option!", true);
    }

    public void checkoutBook(String bookName) {
        Book bookForCheckout = books.stream().filter(book -> bookName.equals(book.getName())).findAny().orElse(null);
        if (bookForCheckout != null && bookForCheckout.isAvailable()) {
            bookForCheckout.checkout();
            printer.print("Thank you! Enjoy the book", true);
        } else {
            printer.print("Sorry, that book is not available", true);
        }
    }

    public void returnBook(String bookName) {
        Book bookForReturn = books.stream().filter(book -> bookName.equals(book.getName())).findAny().orElse(null);
        if (bookForReturn != null && !bookForReturn.isAvailable()) {
            bookForReturn.returnBook();
            printer.print("Thank you for returning the book", true);
        } else {
            printer.print("That is not a valid book to return.", true);
        }
    }

    public void quit() {
        systemExit.exit(0);
    }
}
