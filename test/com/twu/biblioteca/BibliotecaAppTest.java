package com.twu.biblioteca;

import com.twu.biblioteca.manager.ExitManagerMock;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class BibliotecaAppTest {
    private ByteArrayOutputStream outputContent;

    @Before
    public void setUp() throws Exception {
        outputContent = new ByteArrayOutputStream();
        PrintStream outStream = new PrintStream(outputContent);
        System.setOut(outStream);
    }

    @Test
    public void shouldPrintWelcomeMessage() {
        BibliotecaApp.printWelcome();
        String expectedValue = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n";
        assertEquals(expectedValue, outputContent.toString());
    }

    @Test
    public void shouldListAllBooks() {
        Book[] books = new Book[] {
            new Book("Hello", "Mr. A", 2021),
            new Book("World", "Ms. B", 2021)
        };

        BibliotecaApp.listAllBooks(books);
        String expectedValue = "Hello     Mr. A     2021\nWorld     Ms. B     2021\n";
        assertEquals(expectedValue, outputContent.toString());
    }

    @Test
    public void shouldShowMainMenuOfOptions() {
        String expectedValue = "Main Menu\n1. List of books\n";
        BibliotecaApp.showMainMenu();
        assertEquals(expectedValue, outputContent.toString());
    }

    @Test
    public void shouldListAllBooksWhenChoose1() {
        Book[] books = new Book[] {new Book("Hello", "Mr. A", 2021)};
        BibliotecaApp.excuseMainMenu("1", books);
        String expectedValue = "Hello     Mr. A     2021\n";
        assertEquals(expectedValue, outputContent.toString());
    }

    @Test
    public void shouldReEnterOptionWhenChooseInvalid() {
        Book[] books = new Book[1];
        String expectedValue = "Please select a valid option!\n";
        BibliotecaApp.excuseMainMenu("-1", books);
        assertEquals(expectedValue, outputContent.toString());
    }

    @Test
    public void systemShouldExitWhenChooseExit() {
        ExitManagerMock mockExitManager = new ExitManagerMock();
        Book[] books = new Book[1];
        BibliotecaApp.excuseMainMenu("q", books);
        assertTrue(mockExitManager.exitWasCalled);
    }
}
