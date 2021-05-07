package com.twu.biblioteca.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {
    Book testBook;

    @Before
    public void setup() {
        testBook = new Book("name", "author", 2021);
    }

    @Test
    public void testGetName() {
        String expectedValue = "name";
        String actualValue = testBook.getName();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testGetAuthor() {
        String expectedValue = "author";
        String actualValue = testBook.getAuthor();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testGetPublicationYear() {
        int expectedValue = 2021;
        int actualValue = testBook.getPublicationYear();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testToString() {
        String expectedValue = "name\tauthor\t2021";
        String actualValue = testBook.toString();
        assertEquals(expectedValue, actualValue);
    }
}