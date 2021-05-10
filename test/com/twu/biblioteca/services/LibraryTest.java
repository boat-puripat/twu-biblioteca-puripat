package com.twu.biblioteca.services;

import com.twu.biblioteca.managers.Printer;
import com.twu.biblioteca.managers.SystemExit;
import com.twu.biblioteca.models.Book;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LibraryTest {
    @InjectMocks
    public Library library;

    @Mock
    public Printer printer;

    @Spy
    public List<Book> books = new ArrayList<Book>() {{
        add(Mockito.spy(new Book("test1", "author1", 2021)));
        add(Mockito.spy(new Book("test2", "author2", 2021, false)));
    }};

    @Mock
    public SystemExit systemExit;

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
        Mockito.doNothing().when(printer).print(Matchers.anyString(), Matchers.eq(true));
        library.listBooks();
        Mockito.verify(printer, Mockito.times(1)).print(Matchers.anyString(), Matchers.eq(true));
    }

    @Test
    public void testShowMenu() {
        Mockito.doNothing().when(printer).print(Matchers.anyString(), Matchers.eq(true));
        library.showMenu();
        Mockito.verify(printer, Mockito.times(1)).print("Main Menu", true);
        Mockito.verify(printer, Mockito.times(1)).print("1 List of books", true);
        Mockito.verify(printer, Mockito.times(1)).print("2 Checkout a book", true);
        Mockito.verify(printer, Mockito.times(1)).print("3 Return a book", true);
        Mockito.verify(printer, Mockito.times(1)).print("q Quit", true);
    }

    @Test
    public void testInvalidOption() {
        Mockito.doNothing().when(printer).print(Matchers.anyString(), Matchers.eq(true));
        library.invalidOption();
        Mockito.verify(printer, Mockito.times(1)).print("Please select a valid option!", true);
    }

    @Test
    public void testCheckoutBookWithSuccess() {
        String bookNameForCheckout = "test1";
        library.checkoutBook(bookNameForCheckout);
        Book testBook = books.stream().filter(book -> bookNameForCheckout.equals(book.getName())).findAny().orElse(null);
        Mockito.verify(testBook, Mockito.times(1)).checkout();
        Mockito.verify(printer, Mockito.times(1)).print("Thank you! Enjoy the book", true);
    }

    @Test
    public void testCheckoutBookWithFail() {
        String bookNameForCheckout = "test2";
        library.checkoutBook(bookNameForCheckout);
        Mockito.verify(printer, Mockito.times(0)).print("Thank you! Enjoy the book", true);
        Mockito.verify(printer, Mockito.times(1)).print("Sorry, that book is not available", true);
    }

    @Test
    public void testReturnBookWithSuccess() {
        String bookNameForReturn = "test2";
        library.returnBook(bookNameForReturn);
        Book testBook = books.stream().filter(book -> bookNameForReturn.equals(book.getName())).findAny().orElse(null);
        Mockito.verify(testBook, Mockito.times(1)).returnBook();
        Mockito.verify(printer, Mockito.times(1)).print("Thank you for returning the book", true);
    }

    @Test
    public void testReturnBookWithFail() {
        String bookNameForCheckout = "test1";
        library.returnBook(bookNameForCheckout);
        Mockito.verify(printer, Mockito.times(0)).print("Thank you for returning the book", true);
        Mockito.verify(printer, Mockito.times(1)).print("That is not a valid book to return.", true);
    }

    @Test
    public void testQuit() {
        Mockito.doNothing().when(systemExit).exit(0);
        library.quit();
        Mockito.verify(systemExit, Mockito.times(1)).exit(0);
    }
}
