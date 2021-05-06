package com.twu.biblioteca;

import com.twu.biblioteca.manager.ExitManager;
import com.twu.biblioteca.manager.ExitManagerImpl;

import java.util.Scanner;

public class BibliotecaApp {
    public static void main(String[] args) {
        printWelcome();
        Book[] books = new Book[] {
            new Book("Hello", "Mr. A", 2021),
            new Book("World", "Ms. B", 2021)
        };
        showMainMenu();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Choose option: ");
            String selectedOption = scanner.nextLine();
            excuseMainMenu(selectedOption, books);
        }
    }

    public static void printWelcome() {
        String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
        System.out.println(welcomeMessage);
    }

    public static void listAllBooks(Book[] books) {
        for (Book book: books) {
            System.out.printf("%-10s%-10s%4d%n", book.getName(), book.getAuthor(), book.getPublicationYear());
        }
    }

    public static void showMainMenu() {
        System.out.println("Main Menu");
        System.out.println("1. List of books");
        System.out.println("q. quit");
    }

    public static void excuseMainMenu(String option, Book[] books, ExitManager exitManager) {
        if (option.equals("1")) {
            listAllBooks(books);
        } else if (option.equals("q")) {
            exitManager.exit(0);
        } else {
            System.out.println("Please select a valid option!");
        }
    }

    public static void excuseMainMenu(String option, Book[] books) {
        ExitManagerImpl exitManager = new ExitManagerImpl();
        excuseMainMenu(option, books, exitManager);
    }
}
