package com.twu.biblioteca.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {
    Book testBook;

    @Before
    public void setup() {
        testBook = new Book("name", "author", 2021, false);
    }

    @Test
    public void testReturnBook() {
        testBook.returnBook();
        boolean actualValue = testBook.isAvailable();
        assertTrue(actualValue);
    }

    @Test
    public void testToString() {
        String expectedValue = "name\tauthor\t2021";
        String actualValue = testBook.toString();
        assertEquals(expectedValue, actualValue);
    }
}