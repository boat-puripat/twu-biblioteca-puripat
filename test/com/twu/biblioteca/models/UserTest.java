package com.twu.biblioteca.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {
    User testUser;

    @Before
    public void setup() {
        testUser = new User("username", "password");
    }

    @Test
    public void testEqualWithSameReference() {
        boolean actualValue = testUser.equals(testUser);
        assertTrue(actualValue);
    }

    @Test
    public void testEqualWithNull() {
        boolean actualValue = testUser.equals(null);
        assertFalse(actualValue);
    }

    @Test
    public void testEqualWithDifferenceClass() {
        String user = "user";
        boolean actualValue = testUser.equals(user);
        assertFalse(actualValue);
    }

    @Test
    public void testEqualWithSameLibraryNumberAndPassword() {
        User testUser2 = new User("username", "password");
        boolean actualValue = testUser.equals(testUser2);
        assertTrue(actualValue);
    }

    @Test
    public void testEqualWithDifferenceLibraryNumberAndPassword() {
        User testUser2 = new User("username", "123456");
        boolean actualValue = testUser.equals(testUser2);
        assertFalse(actualValue);
    }
}
