package com.twu.biblioteca;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.awt.print.Book;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class BibliotecaAppTest {
    @Test
    public void shouldPrintWelcomeMessage() {
        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        PrintStream outStream = new PrintStream(outputContent);
        System.setOut(outStream);
        BibliotecaApp.printWelcome();
        String expectedValue = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n";
        assertEquals(expectedValue, outputContent.toString());
    }

    @Test
    public void shouldListAllBooks() {
        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        PrintStream outStream = new PrintStream(outputContent);
        System.setOut(outStream);
        ArrayList<Book> books = new ArrayList<>() {{
            add(new Book("Hello"));
            add(new Book("World"));
        }};

        BibliotecaApp.listAllBooks(books);
        String expectedValue = "Hello\nWorld\n";
        assertEquals(expectedValue, outputContent.toString());
    }
}
