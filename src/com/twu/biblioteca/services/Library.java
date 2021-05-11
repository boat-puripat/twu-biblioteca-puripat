package com.twu.biblioteca.services;

import com.twu.biblioteca.constaints.ActionType;
import com.twu.biblioteca.managers.Printer;
import com.twu.biblioteca.managers.SystemExit;
import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.Movie;
import com.twu.biblioteca.models.User;

import java.util.List;

public class Library {
    private Printer printer;
    private SystemExit systemExit;
    private List<Book> books;
    private List<Movie> movies;
    private User user;

    public Library(Printer printer, SystemExit systemExit, List<Book> books, List<Movie> movies, User user) {
        this.printer = printer;
        this.systemExit = systemExit;
        this.books = books;
        this.movies = movies;
        this.user = user;
    }

    public void printWelcome() {
        String welcomeSentence = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
        printer.print(welcomeSentence, true);
    }

    public void listAvailableBooks() {
        for (Book book: books) {
            if (book.isAvailable()) printer.print(book.toString(), true);
        }
    }

    public void showMenu() {
        printer.print("Main Menu", true);
        printer.print("1 List of books", true);
        if (user != null) {
            printer.print("2 Checkout a book", true);
            printer.print("3 Return a book", true);
        }
        printer.print("4 List of movies", true);
        printer.print("5 Checkout a movie", true);
        if (user != null) {
            printer.print("v View my information", true);
        }
        printer.print("q Quit", true);
    }

    public void invalidOption() {
        printer.print("Please select a valid option!", true);
    }

    public void checkoutBook(String bookName) {
        if (user == null) return;
        Book bookForCheckout = books.stream().filter(book -> bookName.equals(book.getName())).findAny().orElse(null);
        if (bookForCheckout != null && bookForCheckout.isAvailable()) {
            bookForCheckout.checkout();
            user.logAction(bookForCheckout, ActionType.CHECKOUT);
            printer.print("Thank you! Enjoy the book", true);
        } else {
            printer.print("Sorry, that book is not available", true);
        }
    }

    public void returnBook(String bookName) {
        if (user == null) return;
        Book bookForReturn = books.stream().filter(book -> bookName.equals(book.getName())).findAny().orElse(null);
        if (bookForReturn != null && !bookForReturn.isAvailable()) {
            bookForReturn.returnBook();
            user.logAction(bookForReturn, ActionType.RETURN);
            printer.print("Thank you for returning the book", true);
        } else {
            printer.print("That is not a valid book to return.", true);
        }
    }

    public void listAvailableMovies() {
        for (Movie movie: movies) {
            if (movie.isAvailable()) printer.print(movie.toString(), true);
        }
    }

    public void checkoutMovie(String movieName) {
        Movie movieForCheckout = movies.stream().filter(movie -> movieName.equals(movie.getName())).findAny().orElse(null);
        if (movieForCheckout != null) movieForCheckout.checkout();
    }

    public void viewUserInformation() {
        if (user == null) return;
        String userProfile = user.toString();
        printer.print(userProfile, true);
    }

    public void quit() {
        systemExit.exit(0);
    }
}
