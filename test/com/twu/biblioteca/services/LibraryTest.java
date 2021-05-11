package com.twu.biblioteca.services;

import com.twu.biblioteca.constaints.ActionType;
import com.twu.biblioteca.managers.Printer;
import com.twu.biblioteca.managers.SystemExit;
import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.Movie;
import com.twu.biblioteca.models.User;
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
    public List<Book> books = new ArrayList<>() {{
        add(Mockito.spy(new Book("test1", "author1", 2021)));
        add(Mockito.spy(new Book("test2", "author2", 2021, false)));
    }};

    @Spy
    public List<Movie> movies = new ArrayList<>() {{
        add(Mockito.spy(new Movie("test1", "director1", 2021, 10)));
        add(Mockito.spy(new Movie("test2", "director2", 2021, 10, false)));
    }};

    @Mock
    public SystemExit systemExit;

    @Spy
    public User testUser = new User();

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
    public void testListAvailableBooks() {
        Mockito.doNothing().when(printer).print(Matchers.anyString(), Matchers.eq(true));
        library.listAvailableBooks();
        Mockito.verify(printer, Mockito.times(1)).print(Matchers.anyString(), Matchers.eq(true));
    }

    @Test
    public void testShowMenuWithoutAuth() {
        Library library = new Library(printer, systemExit, books, movies, null);
        Mockito.doNothing().when(printer).print(Matchers.anyString(), Matchers.eq(true));
        library.showMenu();
        Mockito.verify(printer, Mockito.times(1)).print("Main Menu", true);
        Mockito.verify(printer, Mockito.times(1)).print("1 List of books", true);
        Mockito.verify(printer, Mockito.times(0)).print("2 Checkout a book", true);
        Mockito.verify(printer, Mockito.times(0)).print("3 Return a book", true);
        Mockito.verify(printer, Mockito.times(1)).print("4 List of movies", true);
        Mockito.verify(printer, Mockito.times(1)).print("5 Checkout a movie", true);
        Mockito.verify(printer, Mockito.times(1)).print("q Quit", true);

    }

    @Test
    public void testShowMenuWithAuth() {
        Mockito.doNothing().when(printer).print(Matchers.anyString(), Matchers.eq(true));
        library.showMenu();
        Mockito.verify(printer, Mockito.times(1)).print("Main Menu", true);
        Mockito.verify(printer, Mockito.times(1)).print("1 List of books", true);
        Mockito.verify(printer, Mockito.times(1)).print("2 Checkout a book", true);
        Mockito.verify(printer, Mockito.times(1)).print("3 Return a book", true);
        Mockito.verify(printer, Mockito.times(1)).print("4 List of movies", true);
        Mockito.verify(printer, Mockito.times(1)).print("5 Checkout a movie", true);
        Mockito.verify(printer, Mockito.times(1)).print("q Quit", true);
    }

    @Test
    public void testInvalidOption() {
        Mockito.doNothing().when(printer).print(Matchers.anyString(), Matchers.eq(true));
        library.invalidOption();
        Mockito.verify(printer, Mockito.times(1)).print("Please select a valid option!", true);
    }

    @Test
    public void testCheckoutBookWithoutAuth() {
        Library library = new Library(printer, systemExit, books, movies, null);
        Mockito.doNothing().when(printer).print(Matchers.anyString(), Matchers.eq(true));
        String bookNameForCheckout = "test1";
        library.checkoutBook(bookNameForCheckout);
        Mockito.verify(printer, Mockito.times(0)).print("Thank you! Enjoy the book", true);
        Mockito.verify(printer, Mockito.times(0)).print("Sorry, that book is not available", true);
    }

    @Test
    public void testCheckoutBookWithSuccess() {
        String bookNameForCheckout = "test1";
        Mockito.doNothing().when(printer).print(Matchers.anyString(), Matchers.eq(true));
        Book testBook = books.stream().filter(book -> bookNameForCheckout.equals(book.getName())).findAny().orElse(null);
        Mockito.doNothing().when(testUser).logAction(testBook, ActionType.CHECKOUT);
        library.checkoutBook(bookNameForCheckout);
        Mockito.verify(testBook, Mockito.times(1)).checkout();
        Mockito.verify(testUser, Mockito.times(1)).logAction(testBook, ActionType.CHECKOUT);
        Mockito.verify(printer, Mockito.times(1)).print("Thank you! Enjoy the book", true);
    }

    @Test
    public void testCheckoutBookWithFail() {
        Mockito.doNothing().when(printer).print(Matchers.anyString(), Matchers.eq(true));
        String bookNameForCheckout = "test2";
        library.checkoutBook(bookNameForCheckout);
        Mockito.verify(printer, Mockito.times(0)).print("Thank you! Enjoy the book", true);
        Mockito.verify(printer, Mockito.times(1)).print("Sorry, that book is not available", true);
    }

    @Test
    public void testReturnBookWithoutAuth() {
        Library library = new Library(printer, systemExit, books, movies, null);
        Mockito.doNothing().when(printer).print(Matchers.anyString(), Matchers.eq(true));
        String bookNameForReturn = "test2";
        library.returnBook(bookNameForReturn);
        Mockito.verify(printer, Mockito.times(0)).print("Thank you for returning the book", true);
        Mockito.verify(printer, Mockito.times(0)).print("That is not a valid book to return.", true);
    }

    @Test
    public void testReturnBookWithSuccess() {
        String bookNameForReturn = "test2";
        Mockito.doNothing().when(printer).print(Matchers.anyString(), Matchers.eq(true));
        Book testBook = books.stream().filter(book -> bookNameForReturn.equals(book.getName())).findAny().orElse(null);
        Mockito.doNothing().when(testUser).logAction(testBook, ActionType.RETURN);
        library.returnBook(bookNameForReturn);
        Mockito.verify(testBook, Mockito.times(1)).returnBook();
        Mockito.verify(testUser, Mockito.times(1)).logAction(testBook, ActionType.RETURN);
        Mockito.verify(printer, Mockito.times(1)).print("Thank you for returning the book", true);
    }

    @Test
    public void testReturnBookWithFail() {
        Mockito.doNothing().when(printer).print(Matchers.anyString(), Matchers.eq(true));
        String bookNameForCheckout = "test1";
        library.returnBook(bookNameForCheckout);
        Mockito.verify(printer, Mockito.times(0)).print("Thank you for returning the book", true);
        Mockito.verify(printer, Mockito.times(1)).print("That is not a valid book to return.", true);
    }

    @Test
    public void testListAvailableMovies() {
        Mockito.doNothing().when(printer).print(Matchers.anyString(), Matchers.eq(true));
        library.listAvailableMovies();
        Mockito.verify(printer, Mockito.times(1)).print(Matchers.anyString(), Matchers.eq(true));
    }

    @Test
    public void testCheckoutMovie() {
        String movieNameForCheckout = "test1";
        library.checkoutMovie(movieNameForCheckout);
        Movie testMovie = movies.stream().filter(movie -> movieNameForCheckout.equals(movie.getName())).findAny().orElse(null);
        Mockito.verify(testMovie, Mockito.times(1)).checkout();
    }

    @Test
    public void testViewUserInformationWithoutAuth() {
        library.viewUserInformation();
        Mockito.verify(testUser, Mockito.times(0)).toString();
    }

    @Test
    public void testViewUserInformation() {
        String profile = "user";
        Mockito.doReturn(profile).when(testUser).toString();
        Mockito.doNothing().when(printer).print(profile, true);
        library.viewUserInformation();
        Mockito.verify(testUser, Mockito.times(1)).toString();
        Mockito.verify(printer, Mockito.times(1)).print(profile, true);
    }

    @Test
    public void testQuit() {
        Mockito.doNothing().when(systemExit).exit(0);
        library.quit();
        Mockito.verify(systemExit, Mockito.times(1)).exit(0);
    }
}
