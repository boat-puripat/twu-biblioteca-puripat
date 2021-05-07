package com.twu.biblioteca.services;

import com.twu.biblioteca.managers.Printer;
import com.twu.biblioteca.models.Book;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LibraryTest {
    @InjectMocks
    public Library library;

    @Mock
    public Printer printer;

    @Mock
    public List<Book> books;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testPrintWelcome() {
        Mockito.doNothing().when(printer).print("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!", true);
        library.printWelcome();
        Mockito.verify(printer, Mockito.times(1)).print("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!", true);
    }

    @Test
    public void testListBooks() {
        Mockito.doNothing().when(printer).print(Matchers.anyString(), true);
        library.listBooks();
        Mockito.verify(printer, Mockito.times(books.size())).print(Matchers.anyString(), true);
    }

    @Test
    public void testShowMenu() {
        Mockito.doNothing().when(printer).print(Matchers.anyString(), true);
        library.showMenu();
        Mockito.verify(printer, Mockito.times(1)).print("Main Menu", true);
        Mockito.verify(printer, Mockito.times(1)).print("1 List of books", true);
    }

    @Test
    public void testInvalidOption() {
        Mockito.doNothing().when(printer).print(Matchers.anyString(), true);
        library.invalidOption();
        Mockito.verify(printer, Mockito.times(1)).print("Please select a valid option!", true);
    }
}
