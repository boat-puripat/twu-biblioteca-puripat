package com.twu.biblioteca;

import com.twu.biblioteca.managers.PrinterConsole;
import com.twu.biblioteca.managers.SystemExit;
import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.Movie;
import com.twu.biblioteca.models.User;
import com.twu.biblioteca.services.Authentication;
import com.twu.biblioteca.services.Library;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {
    public static void main(String[] args) {
        PrinterConsole printer = new PrinterConsole();
        SystemExit systemExit = new SystemExit();
        ArrayList<Book> books = new ArrayList<>() {{
            add(new Book("Hello", "Mr. A", 2021));
            add(new Book("World", "Ms. B", 2021));
        }};
        ArrayList<Movie> movies = new ArrayList<>() {{
            add(new Movie("Parasite", "Mr. C", 2021, 10));
            add(new Movie("Dinosaur", "Mrs. D", 2021, 5));
        }};
        Scanner scanner = new Scanner(System.in);
        Authentication authentication = new Authentication();
        User user;
        printer.print("Need to login:(y/n) ", false);
        String needToLogin = scanner.nextLine();
        if (needToLogin.equalsIgnoreCase("y")) {
            printer.print("Your library number: ", false);
            String libraryNumber = scanner.nextLine();
            printer.print("Your password: ", false);
            String password = scanner.nextLine();
            user = authentication.verifyUser(libraryNumber, password);
        } else {
            user = null;
        }
        Library library = new Library(printer, systemExit, books, movies, user);
        library.printWelcome();
        library.showMenu();
        while (true) {
            printer.print("Choose option: ", false);
            String selectedOption = scanner.nextLine();
            if (selectedOption.equals("1")) library.listAvailableBooks();
            else if (selectedOption.equals("2")) {
                printer.print("Checkout book name: ", false);
                String bookName = scanner.nextLine();
                library.checkoutBook(bookName);
            }
            else if (selectedOption.equals("3")) {
                printer.print("Return book name: ", false);
                String bookName = scanner.nextLine();
                library.returnBook(bookName);
            }
            else if (selectedOption.equals("4")) library.listAvailableMovies();
            else if (selectedOption.equals("5")) {
                printer.print("Checkout movie name: ", false);
                String movieName = scanner.nextLine();
                library.checkoutMovie(movieName);
            }
            else if (selectedOption.equals("q")) library.quit();
            else library.invalidOption();
        }
    }
}
