package com.twu.biblioteca;

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
        System.out.print("Choose option: ");
        int selectedOption = scanner.nextInt();
        excuseMainMenu(selectedOption, books);
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
    }

    public static void excuseMainMenu(int option, Book[] books) {
        if (option == 1) {
            listAllBooks(books);
        }
    }
}
