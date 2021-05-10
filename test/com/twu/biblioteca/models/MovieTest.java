package com.twu.biblioteca.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MovieTest {
    Movie testMovie;

    @Before
    public void setup() {
        testMovie = new Movie("name", "director", 2021, 10);
    }

    @Test
    public void testToString() {
        String expectValue = "name\t2021\tdirector\t10";
        String actualValue = testMovie.toString();
        assertEquals(expectValue, actualValue);
    }
}
