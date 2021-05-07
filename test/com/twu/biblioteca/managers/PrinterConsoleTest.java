package com.twu.biblioteca.managers;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

@RunWith(MockitoJUnitRunner.class)
public class PrinterConsoleTest {
    @InjectMocks
    public PrinterConsole printerConsole;

    private ByteArrayOutputStream outputContent;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        outputContent = new ByteArrayOutputStream();
        PrintStream outStream = new PrintStream(outputContent);
        System.setOut(outStream);
    }

    @Test
    public void testPrintString() {
        String expectedValue = "test";
        printerConsole.print("test", false);
        assertEquals(expectedValue, outputContent.toString());
    }

    @Test
    public void testPrintStringWithNewline() {
        String expectedValue = "test\n";
        printerConsole.print("test", true);
        assertEquals(expectedValue, outputContent.toString());
    }
}
