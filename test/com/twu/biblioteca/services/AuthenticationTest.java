package com.twu.biblioteca.services;

import com.twu.biblioteca.models.User;
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
        User actualValue = authentication.verifyUser("xxx-xxxx", "password");
        assertNotNull(actualValue);
    }

    @Test
    public void testVerifyUserFail() {
        User actualValue = authentication.verifyUser("xxx-xxxxx", "password");
        assertNull(actualValue);
    }
}
