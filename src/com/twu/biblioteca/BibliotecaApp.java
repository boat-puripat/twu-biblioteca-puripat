package com.twu.biblioteca;

import com.twu.biblioteca.managers.PrinterConsole;
import com.twu.biblioteca.managers.SystemExit;
import com.twu.biblioteca.models.Book;
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
        Library library = new Library(printer, systemExit, books);
        library.printWelcome();
        library.showMenu();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printer.print("Choose option: ", false);
            String selectedOption = scanner.nextLine();
            if (selectedOption.equals("1")) library.listBooks();
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
            else if (selectedOption.equals("q")) library.quit();
            else library.invalidOption();
        }
    }
}
