package com.twu.biblioteca;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BibliotecaAppTest {
    @Test
    public void shouldPrintWelcomeMessage() {
        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        PrintStream outStream = new PrintStream(outputContent);
        System.setOut(outStream);
        BibliotecaApp.printWelcome();
        String expectedValue = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n";
        assertEquals(expectedValue, outputContent.toString());
    }
}
