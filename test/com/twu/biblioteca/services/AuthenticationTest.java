package com.twu.biblioteca.services;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AuthenticationTest {
    Authentication authentication;

    @Before
    public void setup() {
        authentication = new Authentication();
    }

    @Test
    public void testVerifyUserSuccess() {
        boolean actualValue = authentication.verifyUser("xxx-xxxx", "password");
        assertTrue(actualValue);
    }

    @Test
    public void testVerifyUserFail() {
        boolean actualValue = authentication.verifyUser("xxx-xxxxx", "password");
        assertFalse(actualValue);
    }
}
