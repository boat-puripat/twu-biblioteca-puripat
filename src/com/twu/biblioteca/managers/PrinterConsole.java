package com.twu.biblioteca.managers;

public class PrinterConsole implements Printer {
    @Override
    public void print(String sentence, boolean newline) {
        if (newline) {
            System.out.println(sentence);
        } else {
            System.out.print(sentence);
        }
    }
}
