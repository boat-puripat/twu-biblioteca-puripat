package com.twu.biblioteca.services;

import com.twu.biblioteca.manager.Printer;
import com.twu.biblioteca.models.Book;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
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
        library.printWelcome();
        Mockito.verify(printer, Mockito.times(1)).print("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!", true);
    }
}
