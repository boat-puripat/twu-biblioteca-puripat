package com.twu.biblioteca.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MediaTest {
    Media testMedia;

    @Before
    public void setup() {
        testMedia = new Media("name", "creator", 2021, true);
    }

    @Test
    public void testGetName() {
        String expectValue = "name";
        String actualValue = testMedia.getName();
        assertEquals(expectValue, actualValue);
    }

    @Test
    public void testIsAvailable() {
        boolean actualValue = testMedia.isAvailable();
        assertTrue(actualValue);
    }

    @Test
    public void testCheckout() {
        testMedia.checkout();
        boolean actualValue = testMedia.isAvailable();
        assertFalse(actualValue);
    }
}
